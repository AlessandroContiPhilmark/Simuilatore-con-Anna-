package it.grupposnai.simulatore;

import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
//import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import it.cogetech.lib.common.util.Configurazione;
import it.cogetech.lib.common.util.IpAddress;
import it.cogetech.lib.common.util.XmlSerializer;
import it.cogetech.lib.db.util.CostantiDB;
import it.grupposnai.simulatore.model.request.Request;
import it.grupposnai.simulatore.persistence.WsAuditDao;
import it.grupposnai.simulatore.util.CostantiWsPaymat;

public class AuditLogDelegate {

	private static Logger logger = Logger.getLogger(AuditLogDelegate.class);

	public static Map<String, Object> insWebServiceRequestMsg(Object msgRequest, HttpServletRequest httpRequest) {
		Request request = (Request) msgRequest;
		return insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(), 
				Integer.toString(CostantiWsPaymat.DEFAULT_CODICE_SERVIZIO), new Throwable().getStackTrace()[1].getMethodName(),
				IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), msgRequest);
	}
	
	public static Map<String, Object> insWebServiceRequestMsg(String requestId, String callerId, String skin, 
			String userIp, String firma, String token, String codiceMessaggio, String codiceServizio,
			String ipTracert, String ipClient, Object msgRequest) {
		
		logger.info("insWebServiceRequestMsg callerid:["+callerId+"] requestId:["+requestId+"]");
		Map<String, Object> rt = null;
		try {
			WsAuditDao dao = new WsAuditDao();
			DataSource ds = (DataSource) new InitialContext().lookup("jdbc/auditMSSQLDatasource");
			dao.setDataSource(ds);

			//serializzazione messaggio richiesta
			String xmlMessage = XmlSerializer.serialize(msgRequest);
			
			//thread id che sta gestendo la richiesta
			int processo = Configurazione.INSTANCE.getInt("paymatservice_threadid", 1);
			rt = dao.insRequestWebService(requestId, callerId, processo, skin, userIp, firma, token, codiceMessaggio, codiceServizio, ipTracert, ipClient, xmlMessage);
			
		} catch (Exception e) {
			// TODO::inizializzare mappa per esito negativo imprevisto
			logger.error("Errore durante la scrittura della richiesta su db ", e);
			rt = new HashMap<String, Object>();
			rt.put(CostantiDB.PARAM_ESITO, 100);
			rt.put(CostantiWsPaymat.RESULT_DESC, "Errore imprevisto " + e.getMessage());
		}
		return rt;
	}

	public static Map<String, Object> insWebServiceResponseMsg(String callerId, String requestId, Object msgResponse) {
		return insWebServiceResponseMsg(callerId, requestId, msgResponse, null, null);
	}

	public static Map<String, Object> insWebServiceResponseMsg(String callerId, String requestId, Object msgResponse, Integer importo, Integer commissione) {
		
		logger.info("insWebServiceRequestMsg callerid:[" + callerId + "] requestId:[" + requestId + "] importo:[" + importo + "] commissione:[" + commissione + "]");
		Map<String, Object> rt = null;
		try {
			WsAuditDao dao = new WsAuditDao();
			DataSource ds = (DataSource) new InitialContext().lookup("jdbc/auditMSSQLDatasource");
			dao.setDataSource(ds);

			//serializzazione messaggio richiesta
			String xmlMessage = XmlSerializer.serialize(msgResponse);
			
			//thread id che sta gestendo la richiesta
			int processo = Configurazione.INSTANCE.getInt("paymatservice_threadid", 1);
			rt = dao.insResponseWebService(requestId, callerId, processo, xmlMessage, importo, commissione);
			
		} catch (Exception e) {
			// TODO::inizializzare mappa per esito negativo imprevisto
			logger.error("Errore durante la scrittura della richiesta su db ", e);
			rt = new HashMap<String, Object>();
			rt.put(CostantiDB.PARAM_ESITO, 100);
			rt.put(CostantiWsPaymat.RESULT_DESC, "Errore imprevisto " + e.getMessage());
		}
		return rt;
		
	}
	

}
