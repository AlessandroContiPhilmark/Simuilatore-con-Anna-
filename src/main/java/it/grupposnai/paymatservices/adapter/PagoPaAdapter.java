package it.grupposnai.paymatservices.adapter;

public class PagoPaAdapter {

	// Mapping delle request

	/**
	 * Mappa un oggetto ReservePagoPaRequest da PaymatServices a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.ReservePagoPaRequest getReservePagoPaRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.pagoPa.ReservePagoPaRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.ReservePagoPaRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.ReservePagoPaRequest();
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
		newRequest.setEmail(request.getEmail());
		newRequest.setTelefono(request.getTelefono());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));

		newRequest.setNoticeNumber(request.getCodiceAvviso());
		newRequest.setPaIdentifier(request.getIdentificativoPa());
		return newRequest;
	}

	/**
	 * Mappa un oggetto ConfirmPagoPaRequest da PaymatServices a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.ConfirmPagoPaRequest getConfirmPagoPaRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.pagoPa.ConfirmPagoPaRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.ConfirmPagoPaRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.ConfirmPagoPaRequest();
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
	 * Mappa un oggetto CancelPagoPaRequest da PaymatServices a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.CancelPagoPaRequest getCancelPagoPaRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.pagoPa.CancelPagoPaRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.CancelPagoPaRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.CancelPagoPaRequest();
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
	 * Mappa un oggetto ReservePagoPaResponse da PaymatCore a PaymatServices
	 * 
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.ReservePagoPaResponse getReservePagoPaResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.pagopa.ReservePagoPaResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.ReservePagoPaResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.ReservePagoPaResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setDataCompetenza(response.getDataCompetenza());
		newResponse.setCausale(response.getCausale());
		newResponse.setBeneficiario(response.getBeneficiario());
		newResponse.setImporto(response.getImporto());
		return newResponse;
	}

	/**
	 * Mappa un oggetto ConfirmPagoPaResponse da PaymatCore a PaymatServices
	 * 
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.ConfirmPagoPaResponse getConfirmPagoPaResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.pagopa.ConfirmPagoPaResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.ConfirmPagoPaResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.ConfirmPagoPaResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setListaTasse(ModelAdapter.getTasseList(response.getListaTasse()));
		newResponse.setDataCompetenza(response.getDataCompetenza());
		newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
		return newResponse;
	}

	/**
	 * Mappa un oggetto CancelPagoPaResponse da PaymatCore a PaymatServices
	 * 
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.CancelPagoPaResponse getCancelPagoPaResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.pagopa.CancelPagoPaResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.CancelPagoPaResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.CancelPagoPaResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setDataCompetenza(response.getDataCancel());
		return newResponse;
	}

}
