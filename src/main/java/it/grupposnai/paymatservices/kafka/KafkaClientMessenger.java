package it.grupposnai.paymatservices.kafka;

import it.cogetech.lib.common.util.Configurazione;
import it.grupposnai.kafka.Costanti;
import it.grupposnai.kafka.producer.sender.SenderManager;
import it.grupposnai.paymatservices.util.JSonUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class KafkaClientMessenger {

    private static final Logger LOG = Logger.getLogger(KafkaClientMessenger.class);

    public static <I> void send(final String key, final I entity) {
        try {
            if(StringUtils.isBlank(key)) {
                throw new IllegalArgumentException("La defaultKeyù del messaggio deve essere valorizzata");
            }
            if(entity == null) {
                throw new IllegalArgumentException("L'oggetto di input del message deve essere valorizzato");
            }
            final String topic = Configurazione.INSTANCE.getString(Costanti.MESSAGE_TOPIC);
            if(StringUtils.isBlank(topic)) {
                throw new IllegalArgumentException("Il nome della coda topic deve essere presente nella configurazione");
            }
            new SenderManager().sendMessage(topic, appendToKeyMarkedRequestFields(key, entity), JSonUtil.serialize(entity));
        } catch (Exception e) {
            LOG.error("Errore sendKafkaMessage, msg: ", e);
        }
    }

    private static <I> String appendToKeyMarkedRequestFields(final String key, final I entity) {
        try{
            final String callerId = BeanUtils.getProperty(entity, "callerId");
            final String requestId = BeanUtils.getProperty(entity, "requestId");
            if(StringUtils.isNotBlank(callerId) && StringUtils.isNotBlank(requestId)) {
                return String.format("%s-%s-%s", key, callerId, requestId);
            }
            return key;
        } catch (Exception e) {
            LOG.error(String.format("Errore appendToKeyMarkedRequestFields, msg: %s", e.getMessage()));
            return key;
        }
    }
}
