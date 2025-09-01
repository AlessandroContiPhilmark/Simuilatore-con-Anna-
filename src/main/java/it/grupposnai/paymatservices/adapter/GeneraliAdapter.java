package it.grupposnai.paymatservices.adapter;

public class GeneraliAdapter {

	// Mapping delle request
	
	/**
	 * Mappa un oggetto GetCategorieRequest da PaymatService a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.GetCategorieRequest getGetCategorieRequest(it.grupposnai.paymatservices.model.request.generali.GetCategorieRequest request) {
		it.grupposnai.paymatcore.api.request.info.GetCategorieRequest newRequest = new it.grupposnai.paymatcore.api.request.info.GetCategorieRequest();
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
		newRequest.setVar(request.getVar());
		return newRequest;
	}
	/**
	 * Mappa un oggetto GetBrandRequest da PaymatService a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.GetBrandRequest getGetBrandRequest(it.grupposnai.paymatservices.model.request.generali.GetBrandRequest request) {
		it.grupposnai.paymatcore.api.request.info.GetBrandRequest newRequest = new it.grupposnai.paymatcore.api.request.info.GetBrandRequest();
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
		newRequest.setVar(request.getVar());
		return newRequest;
	}
	
	/**
	 * Mappa un oggetto GetTagliRequest da PaymatServicea a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.GetTagliRequest getGetTagliRequest(it.grupposnai.paymatservices.model.request.generali.GetTagliRequest request) {
		it.grupposnai.paymatcore.api.request.info.GetTagliRequest newRequest = new it.grupposnai.paymatcore.api.request.info.GetTagliRequest();
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
		newRequest.setVar(request.getVar());
		newRequest.setCodiceBrand(request.getCodiceBrand());
		return newRequest;
	}

	/**
	 * Mappa un oggetto InfoTransazioneRequest da PaymatService a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoTransazioneRequest getInfoTransazioneRequest(it.grupposnai.paymatservices.model.request.generali.InfoTransazioneRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoTransazioneRequest newRequest = new it.grupposnai.paymatcore.api.request.info.InfoTransazioneRequest();
		newRequest.setCallerId(request.getCallerId());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIP(request.getUserIP());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setIdTranPaymat(request.getIdTranPaymat());
		return newRequest;
	}

	/**
	 * Mappa un oggetto InfoCreditoResiduoRequest da PaymatService a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoCreditoResiduoRequest getInfoCreditoResiduoRequest(it.grupposnai.paymatservices.model.request.generali.InfoCreditoResiduoRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoCreditoResiduoRequest newRequest = new it.grupposnai.paymatcore.api.request.info.InfoCreditoResiduoRequest();
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
		return newRequest;
	}

	/**
	 * Mappa un oggetto InfoCommissioniRequest da PaymatService a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoCommissioniRequest getInfoCommissioniRequest(it.grupposnai.paymatservices.model.request.generali.InfoCommissioniRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoCommissioniRequest newRequest = new it.grupposnai.paymatcore.api.request.info.InfoCommissioniRequest();
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
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setIdProdotto(request.getIdProdotto());
		return newRequest;
	}

	// Mapping delle response
	
	/**
	 * Mappa un oggetto GetCategorieResponse da PaymatCore a PaymatService
	 * 
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.generali.GetCategorieResponse getGetCategorieResponse(it.grupposnai.paymatcore.api.response.info.GetCategorieResponse response) {
		it.grupposnai.paymatservices.model.response.generali.GetCategorieResponse newResponse = new it.grupposnai.paymatservices.model.response.generali.GetCategorieResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setCategorie(ModelAdapter.getCategorieList(response.getCategorie()));
		return newResponse;
	}
	
	/**
	 * Mappa un oggetto GetBrandResponse da PaymatCore a PaymatService
	 * 
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.generali.GetBrandResponse getGetBrandResponse(it.grupposnai.paymatcore.api.response.info.GetBrandResponse response) {
		it.grupposnai.paymatservices.model.response.generali.GetBrandResponse newResponse = new it.grupposnai.paymatservices.model.response.generali.GetBrandResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setBrand(ModelAdapter.getBrandList(response.getBrand()));
		return newResponse;
	}
	
	/**
	 * Mappa un oggetto GetTagliResponse da PaymatCore a PayamtService
	 * 
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.generali.GetTagliResponse getGetTagliResponse(it.grupposnai.paymatcore.api.response.info.GetTagliResponse response, boolean includiImportoInDescrizione) {
		it.grupposnai.paymatservices.model.response.generali.GetTagliResponse newResponse = new it.grupposnai.paymatservices.model.response.generali.GetTagliResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setTagli(ModelAdapter.getTaglioList(response.getTagli(), includiImportoInDescrizione));
		return newResponse;
	}
	

	/**
	 * Mappa un oggetto InfoTransazioneResponse da PaymatCore a PaymatService
	 * 
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.generali.InfoTransazioneResponse getInfoTransazioniResponse(it.grupposnai.paymatcore.api.response.info.InfoTransazioneResponse response) {
		it.grupposnai.paymatservices.model.response.generali.InfoTransazioneResponse newResponse = new it.grupposnai.paymatservices.model.response.generali.InfoTransazioneResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
		return newResponse;
	}

	/**
	 * Mappa un oggetto InfoCreditoResiduoResponse da PaymatCore a PaymatService
	 * 
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.generali.InfoCreditoResiduoResponse getInfoCreditoResiduoResponse(it.grupposnai.paymatcore.api.response.info.InfoCreditoResiduoResponse response) {
		it.grupposnai.paymatservices.model.response.generali.InfoCreditoResiduoResponse newResponse = new it.grupposnai.paymatservices.model.response.generali.InfoCreditoResiduoResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setCreditoResiduo(response.getCreditoResiduo());
		newResponse.setCreditoTerminale(response.getCreditoTerminale());
		newResponse.setAffiliazione(response.getAffiliazione());
		newResponse.setCodiceBu(response.getCodiceBu());
		return newResponse;
	}

	/**
	 * Mappa un oggetto InfoCommissioniResponse da PaymatCore a PaymatService
	 * 
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.generali.InfoCommissioniResponse getInfoCommissioni(it.grupposnai.paymatcore.api.response.info.InfoCommissioniResponse response) {
		it.grupposnai.paymatservices.model.response.generali.InfoCommissioniResponse newResponse = new it.grupposnai.paymatservices.model.response.generali.InfoCommissioniResponse();
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setCommissioni(response.getCommissioni());
		return newResponse;
	}

}
