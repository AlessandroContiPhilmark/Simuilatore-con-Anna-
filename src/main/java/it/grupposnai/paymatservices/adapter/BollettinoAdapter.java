package it.grupposnai.paymatservices.adapter;

public class BollettinoAdapter {
	
	//Mapping delle request
	
	/**
	 * Mappa un oggetto InfoEnteBollettinoRequest da PaymatServices a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoEnteBollettinoRequest getInfoEnteBollettinoRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettino.InfoEnteBollettinoRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoEnteBollettinoRequest newRequest = new it.grupposnai.paymatcore.api.request.info.InfoEnteBollettinoRequest();
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIp(request.getUserIp());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());		
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setNumeroCCEnte(request.getNumeroCCEnte());
		newRequest.setIdentificativoBollettino(request.getIdentificativoBollettino());
		return newRequest;
	}
	
	/**
	 * Mappa un oggetto RegistrazioneEnteBollettinoRequest da PaymatServices a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.RegistrazioneEnteBollettinoRequest getRegistrazioneEnteBollettinoRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettino.RegistrazioneEnteBollettinoRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.RegistrazioneEnteBollettinoRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.RegistrazioneEnteBollettinoRequest();
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIp(request.getUserIp());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());		
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setEnteBollettino(ModelAdapter.getEnteBollettino(request.getEnteBollettino()));
		newRequest.setFileBase64(request.getFileBase64());
		newRequest.setContentType(request.getContentType());
		return newRequest;
	}
	
	/**
	 * Mappa un oggetto ReserveBollettinoRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.ReserveBillBlankRequest getReserveBollettinoRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettino.ReserveBollettinoRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.ReserveBillBlankRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.ReserveBillBlankRequest();
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIp(request.getUserIp());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());		
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setEmail(request.getEmail());
		newRequest.setTelefono(request.getTelefono());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		newRequest.setBollettino(ModelAdapter.getBollettino(request.getBollettino()));
		newRequest.setIdPrenotazione(request.getIdPrenotazione());
		newRequest.setProgressiviProdottoPrenotazione(request.getProgressiviProdottoPrenotazione());
		return newRequest;
	}
	
	/**
	 * Mappa un oggetto ConfirmBollettinoRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.ConfirmBillBlankRequest getConfirmBollettinoRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettino.ConfirmBollettinoRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.ConfirmBillBlankRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.ConfirmBillBlankRequest();
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIp(request.getUserIp());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());		
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		return newRequest;
	}
	
	/**
	 * Mappa un oggetto CancelBollettinoRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.CancelBillBlankRequest getCancelBollettinoRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettino.CancelBollettinoRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.CancelBillBlankRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.CancelBillBlankRequest();
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIp(request.getUserIp());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());		
		newRequest.setCab(request.getCab());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setIdTerminale(request.getIdTerminale());
		return newRequest;
	}
	
	// Mapping delle response
	
	/**
	 * Mappa un oggetto InfoEnteBollettinoResponse da PaymatCore a PaymatServices
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.InfoEnteBollettinoResponse getInfoEnteBollettinoResponse(it.grupposnai.paymatcore.api.response.info.InfoEnteBollettinoResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.InfoEnteBollettinoResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.InfoEnteBollettinoResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setEnteBollettino(ModelAdapter.getEnteBollettino(response.getEnteBollettino()));
		newResponse.setCallerId(response.getCallerId());
		newResponse.setRequestId(response.getRequestId());
		return newResponse;
	}

	/**
	 * Mappa un oggetto RegistrazioneEnteBollettinoResponse da PaymatCore a PaymatServices
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.RegistrazioneEnteBollettinoResponse getRegistrazioneEnteBollettinoResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettini.RegistrazioneEnteBollettinoResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.RegistrazioneEnteBollettinoResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.RegistrazioneEnteBollettinoResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setCallerId(response.getCallerId());
		newResponse.setRequestId(response.getRequestId());
		return newResponse;
	}
	
	/**
	 * Mappa un oggetto ReserveBollettinoResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.ReserveBollettinoResponse getReserveBollettinoResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettini.ReserveBillBlankResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.ReserveBollettinoResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.ReserveBollettinoResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setResultDetail(response.getResultDetail());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setListaTasse(ModelAdapter.getTasseList(response.getListaTasse()));
		return newResponse;
	}
	
	/**
	 * Mappa un oggetto ConfirmBollettinoResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.ConfirmBollettinoResponse getConfirmBollettinoResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettini.ConfirmBillBlankResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.ConfirmBollettinoResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.ConfirmBollettinoResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setListaTasse(ModelAdapter.getTasseList(response.getListaTasse()));
		newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
		return newResponse;
	}
	
	/**
	 * Mappa un oggetto CancelBollettinoResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.CancelBollettinoResponse getCancelBollettinoResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettini.CancelBillBlankResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.CancelBollettinoResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.CancelBollettinoResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		return newResponse;
	}

}
