package it.grupposnai.paymatservices.persistence;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import it.cogetech.lib.db.dao.AbstractCallableDao;
import it.cogetech.lib.db.dao.SpDeclare;
import it.cogetech.lib.db.dao.params.SqlOutParameter;
import it.cogetech.lib.db.dao.params.SqlParameter;
import it.cogetech.lib.db.exception.DatabaseException;
import it.cogetech.lib.db.util.CostantiDB;
import it.grupposnai.paymatservices.util.CostantiWsPaymat;

public class WsAuditDao extends AbstractCallableDao implements CostantiWsPaymat {

	private static Logger logger = Logger.getLogger(WsAuditDao.class);
	private final String dbName = "PAYMAT_SMART_LOG";

	public Map<String, Object> insRequestWebService(String requestId,  String callerId, int processo, String skin,
			String userIp, String firma, String token, String codiceMessaggio, String codiceServizio, String ipTracert,
			String ipClient, String msgRequest) {

		/*
		 * @requestid varchar(100),--chiave univoca fornita da applicativo
		 * 
		 * @Processo int ,-- identificativo del processo
		 * 
		 * @callerId varchar(20),
		 * 
		 * @skin varchar(20),
		 * 
		 * @userIP varchar(40)=null,
		 * 
		 * @firma varchar(32),
		 * 
		 * @token varchar(10),
		 * 
		 * @CodeMessaggio varchar(10) ,--codice identificativo messaggio
		 * 
		 * @CodiceServizio varchar(10) ,--codice identificativo servizio
		 * 
		 * @IPAddressTrace varchar(255) ,--trace indirizzi attraversati
		 * 
		 * @IpAddressClient varchar(32) ,--indirizzo ip di chi origina la
		 * transazione
		 * 
		 * @Messaggio varchar(max),---text ,--
		 * 
		 * @resultcode int output, -- CODICE ESITO
		 * 
		 * @resultdescrizione varchar(255) output, -- DESCRIZIONE ESITO
		 * 
		 * @retry int output, -- NUMERO RETRY IN TABELLA
		 * 
		 * @response varchar(max) output -- MESSAGGIO DI RISPOSTA SE PRESENTE
		 * 
		 */

		List<SpDeclare> lista = new ArrayList<SpDeclare>();
		lista.add(new SpDeclare(new SqlOutParameter(CostantiDB.PARAM_ESITO, Types.SMALLINT)));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), requestId));
		lista.add(new SpDeclare(new SqlParameter(Types.INTEGER), processo));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), callerId));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), skin));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), userIp));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), firma));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), token));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), codiceMessaggio));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), codiceServizio));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), ipTracert));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), ipClient));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), msgRequest));

		lista.add(new SpDeclare(new SqlOutParameter(RESULT_CODE, Types.INTEGER)));
		lista.add(new SpDeclare(new SqlOutParameter(RESULT_DESC, Types.VARCHAR)));
		lista.add(new SpDeclare(new SqlOutParameter(NUM_RETRY, Types.INTEGER)));
		lista.add(new SpDeclare(new SqlOutParameter(MSG_RESPONSE, Types.VARCHAR)));

		// lista.add(new SpDeclare(new SqlReturnResultSet("RS1", new
		// InfoBrandPinMapper())));

		Map<String, Object> out = new HashMap<String, Object>();
		Short esito = -1;

		try {

			out = executeStoredProcedureWithinTransaction(dbName, "sp_MSG_INS_RequestWebService", lista, true);

			if (out.get(CostantiDB.PARAM_ESITO) != null) {
				esito = (Short) out.get(CostantiDB.PARAM_ESITO);
			} else {
				out.put(CostantiDB.PARAM_ESITO, esito);
			}

		} catch (DatabaseException e) {
			esito = -100;
			out = new HashMap<String, Object>();
			out.put(CostantiDB.PARAM_ESITO, esito);
			logger.error("Errore in infoBrandPin ", e);
		}

		return out;
	}

	public Map<String, Object> insResponseWebService(String requestId, String callerId, int processo, String msgResponse) {
		return insResponseWebService(requestId, callerId, processo, msgResponse, null, null);
	}

	public Map<String, Object> insResponseWebService(String requestId, String callerId, int processo, String msgResponse, Integer importo, Integer commissione) {

		/*
		 * @requestid varchar(100),--chiave univoca fornita da applicativo
		 * 
		 * @callerid varchar(20),
		 * 
		 * @Processo int ,-- identificativo del processo
		 * 
		 * @response varchar(max) , -- MESSAGGIO DI RISPOSTA
		 * 
		 * @resultcode int output, -- CODICE ESITO
		 * 
		 * @resultdescrizione varchar(255) output -- DESCRIZIONE ESITO
		 */

		List<SpDeclare> lista = new ArrayList<SpDeclare>();
		lista.add(new SpDeclare(new SqlOutParameter(CostantiDB.PARAM_ESITO, Types.SMALLINT)));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), requestId));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), callerId));
		lista.add(new SpDeclare(new SqlParameter(Types.INTEGER), processo));
		lista.add(new SpDeclare(new SqlParameter(Types.VARCHAR), msgResponse));
		lista.add(new SpDeclare(new SqlOutParameter(RESULT_CODE, Types.INTEGER)));
		lista.add(new SpDeclare(new SqlOutParameter(RESULT_DESC, Types.VARCHAR)));
		lista.add(new SpDeclare(new SqlParameter(Types.INTEGER), importo));
		lista.add(new SpDeclare(new SqlParameter(Types.INTEGER), commissione));
		
		Map<String, Object> out = new HashMap<String, Object>();
		Short esito = -1;

		try {

			out = executeStoredProcedureWithinTransaction(dbName, "sp_MSG_INS_ResponseWebService", lista, true);

			if (out.get(CostantiDB.PARAM_ESITO) != null) {
				esito = (Short) out.get(CostantiDB.PARAM_ESITO);
			} else {
				out.put(CostantiDB.PARAM_ESITO, esito);
			}

		} catch (DatabaseException e) {
			esito = -100;
			out = new HashMap<String, Object>();
			out.put(CostantiDB.PARAM_ESITO, esito);
			logger.error("Errore in infoBrandPin ", e);
		}

		return out;
	}

}
