package it.grupposnai.paymatservices.adapter;

public class RicaricheAdapter {

	/* Mapping delle request */

	/**
	 * Mappa un oggetto InfoBrandRicaricheRequest da PaymatService a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoBrandRicaricheRequest getInfoBrandRicaricheRequest(it.grupposnai.paymatservices.model.request.ricarica.InfoBrandRicaricheRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoBrandRicaricheRequest newRequest = new it.grupposnai.paymatcore.api.request.info.InfoBrandRicaricheRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIP());
		return newRequest;
	}
	
	/**
	 * Mappa un oggetto InfoTaglioRicaricheRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoTaglioRicaricheRequest getInfoTagliRicaricheRequest(it.grupposnai.paymatservices.model.request.ricarica.InfoTaglioRicaricheRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoTaglioRicaricheRequest newRequest = new it.grupposnai.paymatcore.api.request.info.InfoTaglioRicaricheRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setCodiceBrand(request.getIdBrand());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setNumeroTelefonico(request.getNumeroTelefonico());
		return newRequest;
	}
	
	/**
	 * Mappa un oggetto ReserveRicaricaTelefonicaRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.ricaricaTelefonica.ReserveRicaricaTelefonicaRequest getReserveRicaricaTelefonicaRequest(it.grupposnai.paymatservices.model.request.ricarica.ReserveRicaricaTelefonicaRequest request) {
		it.grupposnai.paymatcore.api.request.ricaricaTelefonica.ReserveRicaricaTelefonicaRequest newRequest = new it.grupposnai.paymatcore.api.request.ricaricaTelefonica.ReserveRicaricaTelefonicaRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIP());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setIdBrand(request.getBrand());
		newRequest.setNumeroTelefonico(request.getNumeroTelefonico());
		newRequest.setTaglio(request.getTaglio());
		newRequest.setImporto(request.getImporto());
		newRequest.setVar(request.getVar());
		newRequest.setEmail(request.getEmail());
		newRequest.setTelefono(request.getTelefono());
		newRequest.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		newRequest.setCodiceCredito(request.getCodiceCredito());
		return newRequest;
	}

	/**
	 * Mappa un oggetto ConfirmRicaricaTelefonicaRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.ricaricaTelefonica.ConfirmRicaricaTelefonicaRequest getConfirmRicaricaTelefonicaRequest(it.grupposnai.paymatservices.model.request.ricarica.ConfirmRicaricaTelefonicaRequest request) {
		it.grupposnai.paymatcore.api.request.ricaricaTelefonica.ConfirmRicaricaTelefonicaRequest newRequest = new it.grupposnai.paymatcore.api.request.ricaricaTelefonica.ConfirmRicaricaTelefonicaRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIP());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setCab(request.getCab());
		newRequest.setIdTerminale(request.getIdterminale());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setIdBrand(request.getBrand());
		newRequest.setVar(request.getVar());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		return newRequest;
	}

	/**
	 * Mappa un oggetto CancelRicaricaTelefonicaRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static  it.grupposnai.paymatcore.api.request.ricaricaTelefonica.CancelRicaricaTelefonicaRequest getCancelRicaricaTelefonicaRequest(it.grupposnai.paymatservices.model.request.ricarica.CancelRicaricaTelefonicaRequest request) {
		it.grupposnai.paymatcore.api.request.ricaricaTelefonica.CancelRicaricaTelefonicaRequest newRequest = new it.grupposnai.paymatcore.api.request.ricaricaTelefonica.CancelRicaricaTelefonicaRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIP());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setIdBrand(request.getBrand());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setIdTerminale(request.getIdTerminale());
		return newRequest;
	}
	
	/* Mapping delle response */

	/**
	 * Mappa un oggetto InfoBrandRicaricheResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.ricarica.InfoBrandRicaricheResponse2 getInfoBrandRicaricheResponse(it.grupposnai.paymatcore.api.response.info.InfoBrandRicaricheResponse response) {
		it.grupposnai.paymatservices.model.response.ricarica.InfoBrandRicaricheResponse2 newResponse = new it.grupposnai.paymatservices.model.response.ricarica.InfoBrandRicaricheResponse2();
		newResponse.setListaBrand(ModelAdapter.getArrayOfBrand(response.getBrandRicariche()));
		newResponse.setResultCode(response.getResultCode() != null ? response.getResultCode().toString() : "");
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}
	
	/**
	 * Mappa un oggetto InfoTagliRicaricheResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.ricarica.InfoTaglioRicaricheResponse getInfoTaglioRicaricheResponse(it.grupposnai.paymatcore.api.response.info.InfoTagliRicaricheResponse response) {
		it.grupposnai.paymatservices.model.response.ricarica.InfoTaglioRicaricheResponse newResponse = new it.grupposnai.paymatservices.model.response.ricarica.InfoTaglioRicaricheResponse();
		newResponse.setListaTagli(ModelAdapter.getArrayOfTaglio(response.getTagliRicariche()));
		newResponse.setResultCode(response.getResultCode() != null ? response.getResultCode().toString() : "");
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}
	
	/**
	 * Mappa un oggetto ReserveRicaricaTelefonicaResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.ricarica.ReserveRicaricaTelefonicaResponse2 getReserveRicaricaTelefonicaResponse(it.grupposnai.paymatcore.api.response.ricaricaTelefonica.ReserveRicaricaTelefonicaResponse response) {
		it.grupposnai.paymatservices.model.response.ricarica.ReserveRicaricaTelefonicaResponse2 newResponse =  new it.grupposnai.paymatservices.model.response.ricarica.ReserveRicaricaTelefonicaResponse2();
		newResponse.setResultCode(response.getResultCode() != null ? response.getResultCode().toString() : "");
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		newResponse.setIdTranEsterno(response.getIdTranEsterno());
		return newResponse;
	}

	/**
	 * Mappa un oggetto ConfirmRicaricaTelefonicaResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.ricarica.ConfirmRicaricaTelefonicaResponse2 getConfirmRicaricaTelefonicaResponse(it.grupposnai.paymatcore.api.response.ricaricaTelefonica.ConfirmRicaricaTelefonicaResponse response) {
		it.grupposnai.paymatservices.model.response.ricarica.ConfirmRicaricaTelefonicaResponse2 newResponse = new it.grupposnai.paymatservices.model.response.ricarica.ConfirmRicaricaTelefonicaResponse2();
		newResponse.setResultCode(response.getResultCode() != null ? response.getResultCode().toString() : "");
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setIdTranPaymat(response.getIdTranPaymat());
		it.grupposnai.paymatservices.model.response.ricarica.Ticket ticket = new it.grupposnai.paymatservices.model.response.ricarica.Ticket();
		if(response.getTicket() != null){			
			it.grupposnai.paymatcore.api.response.info.Ticket d = response.getTicket();
			ticket = ModelAdapter.getTicket(d);
		}		
		newResponse.setTicket(ticket);
		return newResponse;		
	}

	/**
	 * Mappa un oggetto CancelRicaricaTelefonicaResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.ricarica.CancelRicaricaTelefonicaResponse2 getCancelRicaricaTelefonicaResponse(it.grupposnai.paymatcore.api.response.ricaricaTelefonica.CancelRicaricaTelefonicaResponse response) {
		it.grupposnai.paymatservices.model.response.ricarica.CancelRicaricaTelefonicaResponse2 newResponse = new it.grupposnai.paymatservices.model.response.ricarica.CancelRicaricaTelefonicaResponse2();
		newResponse.setResultCode(response.getResultCode() != null ? response.getResultCode().toString() : "");
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}

}
