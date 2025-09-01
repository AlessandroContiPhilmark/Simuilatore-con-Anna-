package it.grupposnai.paymatservices.adapter;

public class PostePayAdapter {
	
	//Mapping delle request
	
	/**
	 * Mappa un oggetto ReservePostePayRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.ReservePostePayRequest getReservePostePayRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.postePay.ReservePostePayRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.ReservePostePayRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.ReservePostePayRequest();
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIp());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());		
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setImportoRicarica(request.getImportoRicarica());
		newRequest.setNumeroPostePay(request.getNumeroPostePay());
		newRequest.setEmail(request.getEmail());
		newRequest.setTelefono(request.getTelefono());
		newRequest.setAccettazioneConsenso(request.getAccettazioneConsenso());
		newRequest.setAllegati(ModelAdapter.getAllegatoList(request.getAllegati()));
		newRequest.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		newRequest.setCodiceCredito(request.getCodiceCredito());
		return newRequest;
	}
	
	/**
	 * Mappa un oggetto ConfirmPostePayRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.ConfirmPostePayRequest getConfirmPostePayRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.postePay.ConfirmPostePayRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.ConfirmPostePayRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.ConfirmPostePayRequest();
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIp());
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
	 * Mappa un oggetto CancelPostePayRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.CancelPostePayRequest getCancelPostePayRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.postePay.CancelPostePayRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.CancelPostePayRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.CancelPostePayRequest();
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIp());
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
	 * Mappa un oggetto ReservePostePayResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.ReservePostePayResponse getReservePostePayResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.postepay.ReservePostePayResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.ReservePostePayResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.ReservePostePayResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setDataCompetenza(response.getDataCompetenza());
		return newResponse;
	}
	
	/**
	 * Mappa un oggetto ConfirmPostePayResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.ConfirmPostePayResponse getConfirmPostePayResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.postepay.ConfirmPostePayResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.ConfirmPostePayResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.ConfirmPostePayResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());		
		newResponse.setDataCompetenza(response.getDataCompetenza());
		newResponse.setTicket(ModelAdapter.getTicket(response.getTicket()));
		return newResponse;		
	}
	
	/**
	 * Mappa un oggetto CancelPostePayResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.CancelPostePayResponse getCancelPostePayResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.postepay.CancelPostePayResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.CancelPostePayResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.CancelPostePayResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setDataCancel(response.getDataCancel());
		return newResponse;		
	}

}
