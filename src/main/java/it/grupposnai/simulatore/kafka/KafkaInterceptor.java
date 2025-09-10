package it.grupposnai.simulatore.kafka;

import it.cogetech.lib.common.util.Configurazione;
import it.grupposnai.kafka.Costanti;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Modifier;

@Interceptor
public class KafkaInterceptor {

    final Logger LOGGER = Logger.getLogger(KafkaInterceptor.class);

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
        Object result = null;
        try {
            // Serve per evitare la duplice chiamata a parità di contesto metodo su cui viene applicato l'around invoke
            if(StringUtils.equalsIgnoreCase(context.getClass().getName(), "org.jboss.invocation.InterceptorContext$Invocation")) {
                try {
                    boolean toSend = true;
                    if(Configurazione.INSTANCE.containsKey(Costanti.SEND_ENABLE)) {
                        try {
                            toSend = Configurazione.INSTANCE.getBoolean(Costanti.SEND_ENABLE);
                        } catch (Throwable tex) {
                            LOGGER.error(String.format("aroundInvoke get send enable kafka error msg: %s", tex.getMessage()));
                        }
                    }
                    if(toSend) {
                        LOGGER.info("interceptor invio kafka abilitato");
                        final String methodName = context.getMethod().getName();
                        Object[] arguments = context.getParameters();
                        // l'invio verso kafka avviene soltanto se il metodo è pubblico, non void e con un solo paramnetro di input
                        final boolean isToSendKafka = isToSendKafka(context, arguments);
                        if (isToSendKafka) sendToKafka(methodName, "request", arguments[0]);
                        result = context.proceed(); // Proceed with method execution: must be executed also for void interceptor methods
                        if (isToSendKafka) sendToKafka(methodName, "response", result);
                    } else {
                        LOGGER.info("interceptor invio kafka disabilitato");
                        result =  context.proceed();
                    }
                } catch (Throwable tex) {
                    LOGGER.error(String.format("aroundInvoke kafka error msg: %s", tex.getMessage()));
                }
            } else {
                result =  context.proceed();
            }
        } catch (Throwable tex) {
            LOGGER.error(String.format("aroundInvoke error msg: %s", tex.getMessage()));
        }
        if(result == null) {
            result = context.proceed();
        }
        return result;
    }

    private boolean isToSendKafka(InvocationContext context, Object[] arguments) {
        try {
            return Modifier.isPublic(context.getMethod().getModifiers())
                    && arguments != null && arguments.length == 1
                    && context.getMethod().getReturnType() != void.class;
        } catch (Throwable tex) {
            LOGGER.error(String.format("Errore isToSendKafka msg: %s", tex.getMessage()));
            return false;
        }
    }

    private void sendToKafka(String methodName, String suffixMessage, Object entityMessage) {
        try {
            KafkaClientMessenger.send(String.format("%s-%s", methodName, suffixMessage), entityMessage);
        } catch (Throwable tex) {
            LOGGER.error(String.format("Errore sendToKafka msg: %s", tex.getMessage()));
        }
    }
}
