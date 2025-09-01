package it.grupposnai.paymatservices.adapter;

public class CbillAdapter {
	
	// Mapping delle request

	/**
	 * Mappa un oggetto ReserveCbillRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.ReserveCbillRequest getReserveCbillRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.cbill.ReserveCbillRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.ReserveCbillRequest r = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.ReserveCbillRequest();
		r.setCallerId(request.getCallerId());
		r.setRequestId(request.getRequestId());
		r.setSkin(request.getSkin());
		r.setUserIP(request.getUserIp());
		r.setFirma(request.getFirma());
		r.setToken(request.getToken());
		r.setIdAziendaDistributore(request.getIdAziendaDistributore());
		r.setIdAziendaEsercente(request.getIdAziendaEsercente());
		r.setCab(request.getCab());
		r.setIdTerminale(request.getIdTerminale());
		r.setImportoVersamento(request.getImportoVersamento());
		r.setNumeroIdBollettino(request.getNumeroIdBollettino());
		r.setCodiceSia(request.getCodiceSia());
		r.setCodicePaese(request.getCodicePaese());
		r.setCodFiscaleVersante(request.getCodFiscaleVersante());
		r.setEmail(request.getEmail());
		r.setTelefono(request.getTelefono());
		r.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		r.setCodiceCredito(request.getCodiceCredito());
		return r;
	}
	
	/**
	 * Mappa un oggetto ConfirmCbillRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.ConfirmCbillRequest getConfirmCbillRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.cbill.ConfirmCbillRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.ConfirmCbillRequest r = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.ConfirmCbillRequest();
		r.setCallerId(request.getCallerId());
		r.setRequestId(request.getRequestId());
		r.setSkin(request.getSkin());
		r.setUserIP(request.getUserIp());
		r.setFirma(request.getFirma());
		r.setToken(request.getToken());
		r.setIdAziendaDistributore(request.getIdAziendaDistributore());
		r.setIdAziendaEsercente(request.getIdAziendaEsercente());
		r.setCab(request.getCab());
		r.setIdTerminale(request.getIdTerminale());
		r.setReserveRequestId(request.getReserveRequestId());
		r.setCodiceCredito(request.getCodiceCredito());
		return r;
	}
	
	/**
	 * Mappa un oggetto CancelCbillRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.CancelCbillRequest getCancelCbillRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.cbill.CancelCbillRequest request) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.CancelCbillRequest r = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.CancelCbillRequest();
		r.setCallerId(request.getCallerId());
		r.setRequestId(request.getRequestId());
		r.setSkin(request.getSkin());
		r.setUserIP(request.getUserIp());
		r.setFirma(request.getFirma());
		r.setToken(request.getToken());
		r.setIdAziendaDistributore(request.getIdAziendaDistributore());
		r.setIdAziendaEsercente(request.getIdAziendaEsercente());
		r.setCab(request.getCab());
		r.setReserveRequestId(request.getReserveRequestId());
		r.setCodiceCredito(request.getCodiceCredito());
		r.setIdTerminale(request.getIdTerminale());
		return r;
	}
	
	/**
	 * Mappa un oggetto InfoCbillGetBillersRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoCbillGetBillersRequest getInfoCbillGetBillersRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.cbill.InfoCbillGetBillersRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoCbillGetBillersRequest r = new it.grupposnai.paymatcore.api.request.info.InfoCbillGetBillersRequest();
		r.setCallerId(request.getCallerId());
		r.setRequestId(request.getRequestId());
		r.setSkin(request.getSkin());
		r.setUserIP(request.getUserIp());
		r.setFirma(request.getFirma());
		r.setToken(request.getToken());
		r.setIdAziendaDistributore(request.getIdAziendaDistributore());
		r.setIdAziendaEsercente(request.getIdAziendaEsercente());
		r.setCab(request.getCab());
		r.setIdTerminale(request.getIdTerminale());
		r.setNomeEnte(request.getNomeEnte());
		return r;		
	}
	
	/**
	 * Mappa un oggetto InfoCbillGetBillsRequest da PaymatService a PaymatCore
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.info.InfoCbillGetBillsRequest getInfoCbillGetBillsRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.cbill.InfoCbillGetBillsRequest request) {
		it.grupposnai.paymatcore.api.request.info.InfoCbillGetBillsRequest r = new it.grupposnai.paymatcore.api.request.info.InfoCbillGetBillsRequest();
		r.setCallerId(request.getCallerId());
		r.setRequestId(request.getRequestId());
		r.setSkin(request.getSkin());
		r.setUserIP(request.getUserIp());
		r.setFirma(request.getFirma());
		r.setToken(request.getToken());
		r.setIdAziendaDistributore(request.getIdAziendaDistributore());
		r.setIdAziendaEsercente(request.getIdAziendaEsercente());
		r.setCab(request.getCab());
		r.setIdTerminale(request.getIdTerminale());
		r.setCodiceSiaBollettino(request.getCodiceSiaBollettino());
		r.setCodiceFiscaleDebitore(request.getCodiceFiscaleDebitore());
		r.setDataInizioRicerca(request.getDataInizioRicerca());
		r.setDataFineRicerca(request.getDataFineRicerca());
		return r;
	}

	// Mapping delle response
	
	/**
	 * Mappa un oggetto ReserveCbillResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */	
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.ReserveCbillResponse getReserveCbillResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.cbill.ReserveCbillResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.ReserveCbillResponse r = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.ReserveCbillResponse();
		r.setResultCode(response.getResultCode());
		r.setResultDesc(response.getResultDesc());
		r.setIdTranPaymat(response.getIdTranPaymat());
		r.setIdTranEsterno(response.getIdTranEsterno());
		r.setDataCompetenza(response.getDataCompetenza());
		r.setListaTasse(ModelAdapter.getTasseList(response.getListaTasse()));
		return r;
	}
	
	/**
	 * Mappa un oggetto ConfirmCbillResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.ConfirmCbillResponse getConfirmCbillResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.cbill.ConfirmCbillResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.ConfirmCbillResponse r = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.ConfirmCbillResponse();
		r.setResultCode(response.getResultCode());
		r.setResultDesc(response.getResultDesc());
		r.setIdTranPaymat(response.getIdTranPaymat());
		r.setIdTranEsterno(response.getIdTranEsterno());
		r.setDataCompetenza(response.getDataCompetenza());
		r.setListaTasse(ModelAdapter.getTasseList(response.getListaTasse()));
		r.setTicket(ModelAdapter.getTicket(response.getTicket()));
		return r;
	}
	
	/**
	 * Mappa un oggetto CancelCbillResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.CancelCbillResponse getCancelCbillResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.cbill.CancelCbillResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.CancelCbillResponse r = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.CancelCbillResponse();
		r.setResultCode(response.getResultCode());
		r.setResultDesc(response.getResultDesc());
		r.setIdTranPaymat(response.getIdTranPaymat());
		r.setIdTranEsterno(response.getIdTranEsterno());
		r.setDataCancel(response.getDataCancel());
		return r;
	}
	
	/**
	 * Mappa un oggetto InfoCbillGetBillersResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.InfoCbillGetBillersResponse getInfoCbillGetBillersResponse(it.grupposnai.paymatcore.api.response.info.InfoCbillGetBillersResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.InfoCbillGetBillersResponse r = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.InfoCbillGetBillersResponse();
		r.setResultCode(response.getResultCode());
		r.setResultDesc(response.getResultDesc());
		r.setIdTranPaymat(response.getIdTranPaymat());
		r.setIdTranEsterno(response.getIdTranEsterno());
		r.setDataCompetenza(response.getDataCompetenza());
		r.setListaEnti(ModelAdapter.getEnteCbillList(response.getListaEnti()));
		return r;
	}
	
	/**
	 * Mappa un oggetto InfoCbillGetBillsResponse da PaymatCore a PaymatService
	 * @param response
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.InfoCbillGetBillsResponse getInfoCbillGetBillsResponse(it.grupposnai.paymatcore.api.response.info.InfoCbillGetBillsResponse response) {
		it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.InfoCbillGetBillsResponse r = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.InfoCbillGetBillsResponse();
		r.setResultCode(response.getResultCode());
		r.setResultDesc(response.getResultDesc());
		r.setIdTranPaymat(response.getIdTranPaymat());
		r.setIdTranEsterno(response.getIdTranEsterno());
		r.setDataCompetenza(response.getDataCompetenza());
		r.setListaBollettini(ModelAdapter.getBollettinoCbillList(response.getListaBollettini()));
		return r;
	}
}
