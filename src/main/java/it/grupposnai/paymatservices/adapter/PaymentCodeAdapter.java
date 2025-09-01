package it.grupposnai.paymatservices.adapter;

public class PaymentCodeAdapter {

	// Mapping delle request

	/**
	 * Mappa un oggetto ReservePaymentCodeRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.ReservePaymentCodeRequest getReservePaymentCodeRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.paymentCode.ReservePaymentCodeRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.ReservePaymentCodeRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.ReservePaymentCodeRequest();
		newRequest.setCab(request.getCab());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setEmail(request.getEmail());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setPersoneFisiche(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setTelefono(request.getTelefono());
		newRequest.setTipoVoucher(request.getTipoVoucher());
		newRequest.setToken(request.getToken());
		newRequest.setUserIP(request.getUserIp());
		newRequest.setVar(request.getVar());
		newRequest.setVoucherCode(request.getVoucherCode());
		return newRequest;
	}

	/**
	 * Mappa un oggetto ConfirmPaymentCodeRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.ConfirmPaymentCodeRequest getConfirmPaymentCodeRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.paymentCode.ConfirmPaymentCodeRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.ConfirmPaymentCodeRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.ConfirmPaymentCodeRequest();
		newRequest.setCab(request.getCab());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setToken(request.getToken());
		newRequest.setUserIP(request.getUserIp());		
		return newRequest;
	}

	/**
	 * Mappa un oggetto CancelPaymentCodeRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.CancelPaymentCodeRequest getCancelPaymentCodeRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.paymentCode.CancelPaymentCodeRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.CancelPaymentCodeRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.CancelPaymentCodeRequest();
		newRequest.setCab(request.getCab());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setToken(request.getToken());
		newRequest.setUserIP(request.getUserIp());
		newRequest.setIdTerminale(request.getIdTerminale());
		return newRequest;
	}

	// Mapping delle response

	/**
	 * Mappa un oggetto ReservePaymentCodeResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.ReservePaymentCodeResponse getReservePaymentCodeResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.paymentcode.ReservePaymentCodeResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.ReservePaymentCodeResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.ReservePaymentCodeResponse();
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setImporto(response.getImporto());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setTipoVoucher(response.getTipoVoucher());
		return newResponse;
	}

	/**
	 * Mappa un oggetto ConfirmPaymentCodeResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.ConfirmPaymentCodeResponse getConfirmPaymentCodeResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.paymentcode.ConfirmPaymentCodeResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.ConfirmPaymentCodeResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.ConfirmPaymentCodeResponse();
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setImporto(response.getImporto());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setSeriale(response.getSeriale());
		newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
		return newResponse;
	}

	/**
	 * Mappa un oggetto CancelPaymentCodeResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.CancelPaymentCodeResponse getCancelPaymentCodeResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.paymentcode.CancelPaymentCodeResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.CancelPaymentCodeResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.CancelPaymentCodeResponse();
		newResponse.setDataCancel(response.getDataCancel());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}

}
