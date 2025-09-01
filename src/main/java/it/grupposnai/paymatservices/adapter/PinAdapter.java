package it.grupposnai.paymatservices.adapter;

public class PinAdapter {

	//Mapping delle request

	/**
	 * Mappa un oggetto InfoBrandRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoBrandPinRequest getInfoBrandPinRequest(it.grupposnai.paymatservices.model.request.pin.InfoBrandPinRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoBrandPinRequest newRequest = new it.grupposnai.paymatcore.api.request.info.InfoBrandPinRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIp());
		return newRequest;
	}

	/**
	 * Mappa un oggetto InfoTagliPinRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoTagliPinRequest getInfoTagliRequest(it.grupposnai.paymatservices.model.request.pin.InfoTagliPinRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoTagliPinRequest newRequest = new it.grupposnai.paymatcore.api.request.info.InfoTagliPinRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setCodiceBrand(request.getIdBrand());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		return newRequest;
	}

	/**
	 * Mappa un oggetto ReserveAcquistoPinRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.acquisto.snai.ReserveAcquistoPinRequest getReserveAcquistoPinRequest(it.grupposnai.paymatservices.model.request.pin.ReserveAcquistoPinRequest request) {
		it.grupposnai.paymatcore.api.request.acquisto.snai.ReserveAcquistoPinRequest newRequest = new it.grupposnai.paymatcore.api.request.acquisto.snai.ReserveAcquistoPinRequest();
		newRequest.setCab(request.getCab());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setTaglio(request.getTaglio());
		newRequest.setToken(request.getToken());
		newRequest.setUserIP(request.getUserIP());
		newRequest.setEmail(request.getEmail());
		newRequest.setTelefono(request.getTelefono());
		newRequest.setPersoneFisiche(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setImporto(request.getImporto());
		return newRequest;
	}

	/**
	 * Mappa un oggetto ConfirmAcquistoPinRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.acquisto.snai.ConfirmAcquistoPinRequest getConfirmAcquistoPinRequest(it.grupposnai.paymatservices.model.request.pin.ConfirmAcquistoPinRequest request) {
		it.grupposnai.paymatcore.api.request.acquisto.snai.ConfirmAcquistoPinRequest newRequest = new it.grupposnai.paymatcore.api.request.acquisto.snai.ConfirmAcquistoPinRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIP());
		newRequest.setToken(request.getToken());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdTerminale());
		return newRequest;
	}

	/**
	 * Mappa un oggetto CancelAcquistoPinRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.acquisto.snai.CancelAcquistoPinRequest getCancelAcquistoPinRequest(it.grupposnai.paymatservices.model.request.pin.CancelAcquistoPinRequest request) {
		it.grupposnai.paymatcore.api.request.acquisto.snai.CancelAcquistoPinRequest newRequest = new it.grupposnai.paymatcore.api.request.acquisto.snai.CancelAcquistoPinRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIP());
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setToken(request.getToken());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setIdTerminale(request.getIdTerminale());
		return newRequest;
	}

	/**
	 * Mappa un oggetto ReserveUsePinRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.utilizzo.ReserveUsePinRequest getReserveUsePinRequest(it.grupposnai.paymatservices.model.request.pin.ReserveUsePinRequest request) {
		it.grupposnai.paymatcore.api.request.utilizzo.ReserveUsePinRequest newRequest = new it.grupposnai.paymatcore.api.request.utilizzo.ReserveUsePinRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setContoGioco(request.getAccount());
		newRequest.setFirma(request.getFirma());
		newRequest.setPin(request.getPin());
		newRequest.setRequestId(request.getRequestId());
		return newRequest;
	}

	/**
	 * Mappa un oggetto ConfirmUsePinRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.utilizzo.ConfirmUsePinRequest getConfirmUsePinRequest(it.grupposnai.paymatservices.model.request.pin.ConfirmUsePinRequest request) {
		it.grupposnai.paymatcore.api.request.utilizzo.ConfirmUsePinRequest newRequest = new it.grupposnai.paymatcore.api.request.utilizzo.ConfirmUsePinRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setContoGioco(request.getAccount());
		newRequest.setFirma(request.getFirma());
		newRequest.setPin(request.getPin());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setRequestIdReserve(request.getReserveRequestId());
		return newRequest;
	}

	/**
	 * Mappa un oggetto CancelUsePinRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.utilizzo.CancelUsePinRequest getCancelUsePinRequest(it.grupposnai.paymatservices.model.request.pin.CancelUsePinRequest request) {
		it.grupposnai.paymatcore.api.request.utilizzo.CancelUsePinRequest newRequest = new it.grupposnai.paymatcore.api.request.utilizzo.CancelUsePinRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setContoGioco(request.getAccount());
		newRequest.setFirma(request.getFirma());
		newRequest.setPin(request.getPin());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setRequestIdReserve(request.getReserveRequestId());
		newRequest.setIdTerminale(request.getIdTerminale());
		return newRequest;
	}

	/**
	 * Mappa un oggetto StornoAcquistoPinRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.storno.StornoAcquistoPinRequest getStornoAcquistoPinRequest(it.grupposnai.paymatservices.model.request.pin.StornoAcquistoPinRequest request) {
		it.grupposnai.paymatcore.api.request.storno.StornoAcquistoPinRequest newRequest = new it.grupposnai.paymatcore.api.request.storno.StornoAcquistoPinRequest();
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setReserveRequestId(request.getRequestIdReserve());
		return newRequest;
	}

	//Mapping delle response

	/**
	 * Mappa un oggetto InfoBrandPinResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.InfoBrandPinResponse getInfoBrandResponse(it.grupposnai.paymatcore.api.response.info.InfoBrandPinResponse response) {
		it.grupposnai.paymatservices.model.response.pin.InfoBrandPinResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.InfoBrandPinResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setBrand(ModelAdapter.getBrandList(response.getBrandPin()));
		return newResponse;
	}

	/**
	 * Mappa un oggetto InfoTagliPinResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.InfoTagliPinResponse getInfoTagliPinResponse(it.grupposnai.paymatcore.api.response.info.InfoTagliPinResponse response) {
		it.grupposnai.paymatservices.model.response.pin.InfoTagliPinResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.InfoTagliPinResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setTagli(ModelAdapter.getTaglioList(response.getTagliPin(), true));
		return newResponse;
	}


	/**
	 * Mappa un oggetto ReserveAcquistoPinResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.ReserveAcquistoPinResponse getReserveAcquistoPinResponse(it.grupposnai.paymatcore.api.response.acquisto.snai.ReserveAcquistoPinResponse response) {
		it.grupposnai.paymatservices.model.response.pin.ReserveAcquistoPinResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.ReserveAcquistoPinResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		if(newResponse.getResultCode() == 0) {
			newResponse.setIdTranEsterno("");
			newResponse.setIdTranPaymat(response.getCro());
			newResponse.setImporto(response.getImportoPin());
			newResponse.setPin(response.getPin());
			newResponse.setScadenza(response.getScadenza());
			newResponse.setSeriale(response.getSerialNumber());
		}
		return newResponse;
	}

	/**
	 * Mappa un oggetto ConfirmAcquistoPinResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.ConfirmAcquistoPinResponse getConfirmAcquistoPinResponse(it.grupposnai.paymatcore.api.response.acquisto.snai.ConfirmAcquistoPinResponse response) {
		it.grupposnai.paymatservices.model.response.pin.ConfirmAcquistoPinResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.ConfirmAcquistoPinResponse();
		newResponse.setIdTranEsterno("");
		newResponse.setImporto(response.getImportoPin());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranPaymat(response.getCro());
		newResponse.setPin(response.getPin());
		newResponse.setSeriale(response.getSerialNumber());
		newResponse.setScadenza(response.getScadenza());
		it.grupposnai.paymatservices.model.response.ricarica.Ticket ticket = new it.grupposnai.paymatservices.model.response.ricarica.Ticket();
		if(response.getTicket() != null){
			it.grupposnai.paymatcore.api.response.info.Ticket d = response.getTicket();
			ticket = ModelAdapter.getTicket(d);
		}
		newResponse.setTicket(ticket);

		return newResponse;
	}

	/**
	 * Mappa un oggetto CancelAcquistoPinResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.CancelAcquistoPinResponse getCancelAcquistoPinResponse(it.grupposnai.paymatcore.api.response.acquisto.snai.CancelAcquistoPinResponse response) {
		it.grupposnai.paymatservices.model.response.pin.CancelAcquistoPinResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.CancelAcquistoPinResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}

	/**
	 * Mappa un oggetto ConfirmUsePinResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.ReserveUsePinResponse getReserveUsePinResponse(it.grupposnai.paymatcore.api.response.utilizzo.ReserveUsePinResponse response) {
		it.grupposnai.paymatservices.model.response.pin.ReserveUsePinResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.ReserveUsePinResponse();
		newResponse.setImportoPin(response.getImportoPin());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}

	/**
	 * Mappa un oggetto ConfirmUsePinResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.ConfirmUsePinResponse getConfirmUsePinResponse(it.grupposnai.paymatcore.api.response.utilizzo.ConfirmUsePinResponse response) {
		it.grupposnai.paymatservices.model.response.pin.ConfirmUsePinResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.ConfirmUsePinResponse();
		newResponse.setImportoPin(response.getImportoPin());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}

	/**
	 * Mappa un oggetto CancelUsePinResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.CancelUsePinResponse getCancelUsePinResponse(it.grupposnai.paymatcore.api.response.utilizzo.CancelUsePinResponse response) {
		it.grupposnai.paymatservices.model.response.pin.CancelUsePinResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.CancelUsePinResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}

	/**
	 * Mappa un oggetto StornoAcquistoPinResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.StornoAcquistoPinResponse getStornoAcquistoPinResponse(it.grupposnai.paymatcore.api.response.storno.StornoAcquistoPinResponse response) {
		it.grupposnai.paymatservices.model.response.pin.StornoAcquistoPinResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.StornoAcquistoPinResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}

	/**
	 * Mappa un oggetto CancelAcquistoPinVivacardRequest da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.acquisto.snai.CancelAcquistoPinVivacardRequest getCancelAcquistoPinVivacardRequest(it.grupposnai.paymatservices.model.request.pin.CancelAcquistoPinVivacardRequest request) {
		it.grupposnai.paymatcore.api.request.acquisto.snai.CancelAcquistoPinVivacardRequest newRequest = new it.grupposnai.paymatcore.api.request.acquisto.snai.CancelAcquistoPinVivacardRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setCro(request.getCro());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIP());
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setToken(request.getToken());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setIdFornitore(request.getIdFornitore());
		newRequest.setPin(request.getPin());
		newRequest.setStringaConnettore(request.getStringaConnettore());
		newRequest.setCab(request.getCab());
		newRequest.setIdConnettore(request.getIdConnettore());
		return newRequest;
	}

	/**
	 * Mappa un oggetto CancelAcquistoPinVivacardResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.pin.CancelAcquistoPinVivacardResponse getCancelAcquistoPinVivacardResponse(it.grupposnai.paymatcore.api.response.acquisto.snai.CancelAcquistoPinVivacardResponse response) {
		it.grupposnai.paymatservices.model.response.pin.CancelAcquistoPinVivacardResponse newResponse = new it.grupposnai.paymatservices.model.response.pin.CancelAcquistoPinVivacardResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}
}
