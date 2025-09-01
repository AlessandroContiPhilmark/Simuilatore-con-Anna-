package it.grupposnai.paymatservices.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.grupposnai.paymatcore.api.PaymatCoreApi;
import it.grupposnai.paymatcore.api.request.callback.sepafin.OtpFlowNotifyRequestCore;
import it.grupposnai.paymatcore.api.request.callback.sepafin.OtpFlowNotifyResponseCore;
import it.grupposnai.paymatservices.adapter.SepafinAdapter;
import it.grupposnai.paymatservices.services.dto.OtpFlowNotifyRequest;
import it.grupposnai.paymatservices.services.dto.OtpFlowNotifyResponse;
import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

//TODO 0013: qui ci sta il mio servizio OtpFlowNotify
@Path("/OtpFlowNotify")
public class OtpFlowNotifyService {

    private PaymatCoreApi paymatCoreApi;
    private static final Logger LOG = Logger.getLogger(OtpFlowNotifyService.class.getName());

    @POST
//    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public OtpFlowNotifyResponseCore sepafinCallback(String requestString) {
        LOG.info("sepafinCallback request=[" + requestString + "]");
        ObjectMapper objectMapper = new ObjectMapper();
        OtpFlowNotifyRequest request = null;
        try {
            request = objectMapper.readValue(requestString, OtpFlowNotifyRequest.class);
            request.setMessage(requestString);
        } catch (IOException e) {
//            e.printStackTrace();
            LOG.error("Errore nel readValue per requestString convertito a JSON", e);
        }

        OtpFlowNotifyResponseCore response = new OtpFlowNotifyResponseCore();

        OtpFlowNotifyRequestCore requestCore = SepafinAdapter.convert(request);
        try {
            response = getPaymatCoreApi().setExpireSepafinToken(requestCore);
        } catch (NamingException e){
            LOG.error("Errore nella creazione di PaymatCoreApi", e);
        } catch (Exception e) {
            LOG.error("Errore nel PaymatCore per sepafinCallback", e);
        }
        LOG.info("sepafinCallback response=[" + response + "]");

        return response;
    }

    private PaymatCoreApi getPaymatCoreApi() throws NamingException {
        if (this.paymatCoreApi == null) {
            try {
                this.paymatCoreApi = new PaymatCoreApi(true, new InitialContext());
            } catch (NamingException e) {
                throw e;
            }
        }
        return this.paymatCoreApi;
    }

}
