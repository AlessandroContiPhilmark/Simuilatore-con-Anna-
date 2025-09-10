package it.grupposnai.simulatore.util;

public interface CostantiWsPaymat {
	
	public static final Integer VALIDATION_ERROR_CODE = 1;
	public static final String VALIDATION_ERROR_DESC = "Request non valida, campi obbligatori mancanti";
	
	public static final String OLD_WS_PAYMATSERVICES_WSDL = "old_ws_ricariche_wsdl";
	public static final String OLD_WS_PAYMATSERVICES_ENDPOINT = "old_ws_ricariche_endpoint";
	public static final String BRAND_RICARICHE_LEGACY = "brand_ricariche_legacy";
	public static final String BRAND_PIN_LEGACY = "brand_pin_legacy";
	
	/*PARAMETRI DB*/
	public static final String RESULT_CODE = "RESULT_CODE";
	public static final String RESULT_DESC = "RESULT_DESC";
	public static final String NUM_RETRY = "NUM_RETRY";
	public static final String MSG_RESPONSE = "MSG_RESPONSE";
	
	/*SERVIZI*/
	public static final int SERVIZIO_RICARICHE = 0;
	public static final int SERVIZIO_PIN_DISPATCHING = 0;
	public static final int SERVIZIO_BOLLETTINI_POSTALI = 0;
	public static final int SERVIZIO_MAV_RAV = 0;
	public static final int SERVIZIO_POSTEPAY = 0;
	public static final int SERVIZIO_CBILL = 0;
	public static final int SERVIZIO_PAYMENT_CODE = 0;
	public static final int SERVIZIO_PAGOPA = 0;
	public static final int SERVIZIO_BOLLO_AUTO = 0;
	
	/*MESSAGGI*/
	public static final int INFO_BRAND_RICARICHE = 0;
	public static final int INFO_TAGLI_RICARICHE = 0;
	public static final int RESERVE_RICARICA_TELEFONICA = 0;
	public static final int CONFIRM_RICARICA_TELEFONICA = 0;
	public static final int CANCEL_RICARICA_TELEFONICA = 0;
	
	public static final int INFO_BRAND_PIN = 0;
	public static final int INFO_TAGLI_PIN = 0;
	public static final int RESERVE_ACQUISTO_PIN = 0;
	public static final int CONFIRM_ACQUISTO_PIN = 0;
	public static final int CANCEL_ACQUISTO_PIN = 0;
	public static final int STORNO_ACQUISTO_PIN = 0;
	
	public static final int RESERVE_UTILIZZO_PIN = 0;
	public static final int CONFIRM_UTILIZZO_PIN = 0;
	public static final int CANCEL_UTILIZZO_PIN = 0;
	
	public static final int RESERVE_MAV_RAV = 0;
	public static final int CONFIRM_MAV_RAV = 0;
	public static final int CANCEL_MAV_RAV = 0;
	
	public static final int RESERVE_BOLLETTINO = 0;
	public static final int CONFIRM_BOLLETTINO = 0;
	public static final int CANCEL_BOLLETTINO = 0;
	
	public static final int RESERVE_POSTEPAY = 0;
	public static final int CONFIRM_POSTEPAY = 0;
	public static final int CANCEL_POSTEPAY = 0;
	
	public static final int RESERVE_CBILL = 0;
	public static final int CONFIRM_CBILL = 0;
	public static final int CANCEL_CBILL = 0;
	public static final int INFO_CBILL_GETBILLERS = 0;
	public static final int INFO_CBILL_GETBILLS = 0;
	
	public static final int RECUPERO_INFO_TRANSAZIONE = 0;
	
	public static final int RESERVE_PAYMENT_CODE = 0;
	public static final int CONFIRM_PAYMENT_CODE = 0;
	public static final int CANCEL_PAYMENT_CODE = 0;	
	
	public static final int RESERVE_PAGOPA = 0;
	public static final int CONFIRM_PAGOPA = 0;
	public static final int CANCEL_PAGOPA = 0;
	
	public static final int RESERVE_BOLLO_AUTO = 0;
	public static final int CONFIRM_BOLLO_AUTO = 0;
	public static final int CANCEL_BOLLO_AUTO = 0;

	public static final int DEFAULT_CODICE_MESSAGGIO = 0; // anche basta a scrivere 200 costanti tutte a zero... d'ora in poi si usano sempre queste
	public static final int DEFAULT_CODICE_SERVIZIO = 0;
	
	public static final String LEGACY_FASTWEB = "legacy_fastweb";
	public static final String SHOW_PIN_ON_RESERVEACQUISTOPIN = "show_pin_on_reserveacquistopin";
	
	public static final String SEPAFIN_CALLBACK_URL = "sepafin.services.loginmfa.callbackUrl";
	public static final String SEPAFIN_AUTH_USER = "sepafin.services.username";
	public static final String SEPAFIN_AUTH_PWD = "sepafin.services.password";
	public static final String SEPAFIN_CONNECTOR_ENDPOINT = "sepafin.connector.endpoint";

	public static final String CALLERS_NO_IMPORTO_DESC_TAGLI = "callers_no_importo_desc_tagli";
	
	public static final String PRENOTAZIONESERVICE_WSDL_URL = "prenotazioneservice.wsdlUrl";

    public static final String MOCK_RESPONSE_RESERVE = "mock.response.reserve";
    public static final String MOCK_RESPONSE_CONFIRM = "mock.response.confirm";
    public static final String MOCK_RESPONSE_CANCEL = "mock.response.cancel";


}
