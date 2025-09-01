package it.grupposnai.paymatservices.adapter;

public class MavRavAdapter {
	
	//Mapping delle request
	
	/**
	 * Mappa un oggetto ReserveMavRavRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.ReserveMavRavRequest getReserveMavRavRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.mavRav.ReserveMavRavRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.ReserveMavRavRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.ReserveMavRavRequest();
		newRequest.setCab(request.getCab());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setCodicePaese(request.getCodicePaese());
//		newRequest.setEseguitoDa(request.getEseguitoDa());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setImporto(request.getImporto());
		newRequest.setNumeroMavRav(request.getNumeroMavRav());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setToken(request.getToken());
		newRequest.setUserIP(request.getUserIp());
		newRequest.setTipoProdotto(request.getTipoProdotto());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setEmail(request.getEmail());
		newRequest.setTelefono(request.getTelefono());
		newRequest.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		newRequest.setCodiceCredito(request.getCodiceCredito());
		return newRequest;		
	}
	
	/**
	 * Mappa un oggetto ConfirmMavRavRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.ConfirmMavRavRequest getConfirmMavRavRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.mavRav.ConfirmMavRavRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.ConfirmMavRavRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.ConfirmMavRavRequest();
		newRequest.setCab(request.getCab());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setToken(request.getToken());
		newRequest.setUserIP(request.getUserIp());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		return newRequest;		
	}
	
	/**
	 * Mappa un oggetto CancelMavRavRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.CancelMavRavRequest getCancelMavRavRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.mavRav.CancelMavRavRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.CancelMavRavRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.CancelMavRavRequest();
		newRequest.setCab(request.getCab());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setToken(request.getToken());
		newRequest.setUserIP(request.getUserIp());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setIdTerminale(request.getIdTerminale());
		return newRequest;
	}
	
	// Mapping delle Response
	
	/**
	 * Mappa un oggetto ReserveMavRavResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.ReserveMavRavResponse getReserveMavRavResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.mavRav.ReserveMavRavResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.ReserveMavRavResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.ReserveMavRavResponse();
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setListaTasse(ModelAdapter.getTasseList(response.getListaTasse()));
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setDataCompetenza(response.getDataCompetenza());		
		return newResponse;		
	}

	/**
	 * Mappa un oggetto ConfirmMavRavResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.ConfirmMavRavResponse getConfirmMavRavResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.mavRav.ConfirmMavRavResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.ConfirmMavRavResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.ConfirmMavRavResponse();
		newResponse.setDataCompetenza(response.getDataCompetenza());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setListaTasse(ModelAdapter.getTasseList(response.getListaTasse()));
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
		return newResponse;
	}
	
	/**
	 * Mappa un oggetto CancelMavRavResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.CancelMavRavResponse getCancelMavRavResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.mavRav.CancelMavRavResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.CancelMavRavResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.CancelMavRavResponse();
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setDataCancel(response.getDataCancel());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;		
	}

}
