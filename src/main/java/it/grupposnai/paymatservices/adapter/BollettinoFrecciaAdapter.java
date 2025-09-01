package it.grupposnai.paymatservices.adapter;

public class BollettinoFrecciaAdapter {

	// Mapping delle request

	/**
	 * Mappa un oggetto ReserveBollettinoFrecciaRequest da PaymatServices a
	 * PaymatCore
	 * 
	 * @param request
	 * @return
	 */

	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.ReserveBillFrecciaRequest getReserveBollettinoFrecciaRequest(
			it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettinoFreccia.ReserveBollettinoFrecciaRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.ReserveBillFrecciaRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.ReserveBillFrecciaRequest();

		newRequest.setRequestId(request.getRequestId());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIp(request.getUserIp());
		newRequest.setToken(request.getToken());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setEmail(request.getEmail());
		newRequest.setTelefono(request.getTelefono());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		newRequest.setBollettinoFreccia(ModelAdapter.getBollettinoFreccia(request.getBollettinoFreccia()));

		return newRequest;
	}

	/**
	 * Mappa un oggetto ReserveBollettinoFrecciaResponse da PaymatCore a
	 * PaymatService
	 * 
	 * @param response
	 * @return
	 */

	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.ReserveBollettinoFrecciaResponse getReserveBollettinoFrecciaResponse(
			it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettinoFreccia.ReserveBillFrecciaResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.ReserveBollettinoFrecciaResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.ReserveBollettinoFrecciaResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setResultDetail(response.getResultDetail());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setListaTasse(ModelAdapter.getTasseList(response.getListaTasse()));
		return newResponse;
	}

	// Mapping delle confirm

	/**
	 * Mappa un oggetto ConfirmBollettinoFrecciaRequest da PaymatServices a
	 * PaymatCore
	 * 
	 * @param request
	 * @return
	 */

	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.ConfirmBillFrecciaRequest getConfirmBollettinoFrecciaRequest(
			it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettinoFreccia.ConfirmBollettinoFrecciaRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.ConfirmBillFrecciaRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.ConfirmBillFrecciaRequest();

		newRequest.setCallerId(request.getCallerId());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIp(request.getUserIp());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		return newRequest;
	}

	/**
	 * Mappa un oggetto ConfirmBollettinoFrecciaResponse da PaymatCore a
	 * PaymatService
	 * 
	 * @param response
	 * @return
	 */

	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.ConfirmBollettinoFrecciaResponse getConfirmBollettinoFrecciaResponse(
			it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettinoFreccia.ConfirmBillFrecciaResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.ConfirmBollettinoFrecciaResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.ConfirmBollettinoFrecciaResponse();

		newResponse.setCallerId(response.getCallerId());
		newResponse.setRequestId(response.getRequestId());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setListaTasse(ModelAdapter.getTasseList(response.getListaTasse()));
		newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
		return newResponse;
	}

	// Mapping delle Cancel

	/**
	 * Mappa un oggetto CancelBollettinoFrecciaRequest da PaymatServices a
	 * PaymatCore
	 * 
	 * @param request
	 * @return
	 */

	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.CancelBillFrecciaRequest getCancelBollettinoFrecciaRequest(
			it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettinoFreccia.CancelBollettinoFrecciaRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.CancelBillFrecciaRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.CancelBillFrecciaRequest();

		newRequest.setCallerId(request.getCallerId());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIp(request.getUserIp());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setCab(request.getCab());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		return newRequest;
	}

	/**
	 * Mappa un oggetto CancelBollettinoFrecciaResponse da PaymatCore a
	 * PaymatService
	 * 
	 * @param response
	 * @return
	 */

	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.CancelBollettinoFrecciaResponse getCancelBollettinoFrecciaResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettinoFreccia.CancelBillFrecciaResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.CancelBollettinoFrecciaResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.CancelBollettinoFrecciaResponse();
		newResponse.setCallerId(response.getCallerId());
		newResponse.setRequestId(response.getRequestId());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		return newResponse;
	}

}
