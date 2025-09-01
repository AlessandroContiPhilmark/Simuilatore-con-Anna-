package it.grupposnai.paymatservices.adapter;


import it.grupposnai.paymatcore.api.request.ricaricaConto.CancelRicaricaWalletRequest;
import it.grupposnai.paymatcore.api.request.ricaricaConto.ConfirmRicaricaWalletRequest;
import it.grupposnai.paymatcore.api.request.ricaricaConto.ReserveRicaricaWalletRequest;
import it.grupposnai.paymatcore.api.response.ricaricaConto.CancelRicaricaWalletResponse;
import it.grupposnai.paymatcore.api.response.ricaricaConto.ConfirmRicaricaWalletResponse;
import it.grupposnai.paymatcore.api.response.ricaricaConto.ReserveRicaricaWalletResponse;
import it.grupposnai.paymatservices.model.request.ricaricaConto.CancelRicaricaContoRequest;
import it.grupposnai.paymatservices.model.request.ricaricaConto.ConfirmRicaricaContoRequest;
import it.grupposnai.paymatservices.model.request.ricaricaConto.ReserveRicaricaContoRequest;
import it.grupposnai.paymatservices.model.response.ricaricaConto.CancelRicaricaContoResponse;
import it.grupposnai.paymatservices.model.response.ricaricaConto.ConfirmRicaricaContoResponse;
import it.grupposnai.paymatservices.model.response.ricaricaConto.ReserveRicaricaContoResponse;

public class RicaricaContoAdapter {

	// MAPPING DELLE RESERVE
	/**
	 * Mappa un oggetto ReserveRicaricaContoRequest da PaymatServices a PaymatCore
	 * 
	 * @param request
	 * @return
	 */

	public static ReserveRicaricaWalletRequest getReserveRicaricaContoRequest(ReserveRicaricaContoRequest request) {
		ReserveRicaricaWalletRequest newRequest = new ReserveRicaricaWalletRequest();
		// TODO Fare Mapping delle request.
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
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setCodiceConto(request.getCodiceConto());
		newRequest.setImporto(request.getImporto());
		newRequest.setGestore(request.getGestore());
		
		return newRequest;
	}


	// Mapping della response

	/**
	 * Mappa un oggetto ReserveRicaricaContoResponse da PaymatCore a PaymatServices
	 * 
	 * @param response
	 * @return
	 */

	public static ReserveRicaricaContoResponse getReserveRicaricaContoResponse(ReserveRicaricaWalletResponse response) {
		ReserveRicaricaContoResponse newResponse = new ReserveRicaricaContoResponse();
		newResponse.setCallerId(response.getCallerId());
		newResponse.setRequestId(response.getRequestId());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setImporto(String.valueOf(response.getImportoTransazione()));
		if(response.getTicket() != null) newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
		return newResponse;

	}

	// MAPPING DELLE CONFIRM

	/**
	 * Mappa un oggetto ConfirmRicaricaContoRequest da PaymatServices a PaymatCore
	 * 
	 * @param request
	 * @return
	 */

	public static ConfirmRicaricaWalletRequest getConfirmRicaricaContoRequest(ConfirmRicaricaContoRequest request) {
		
		ConfirmRicaricaWalletRequest newRequest = new ConfirmRicaricaWalletRequest();

		newRequest.setCallerId(request.getCallerId());
		newRequest.setRequestId(request.getRequestId());
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
	 * Mappa un oggetto ConfirmRicaricaContoResponse da PaymatCore a PaymatServices
	 * 
	 * @param request
	 * @return
	 */

	public static ConfirmRicaricaContoResponse getConfirmRicaricaContoResponse(ConfirmRicaricaWalletResponse response) {
		ConfirmRicaricaContoResponse newResponse = new ConfirmRicaricaContoResponse();

		newResponse.setCallerId(response.getCallerId());
		newResponse.setRequestId(response.getRequestId());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
		
		return newResponse;

	}

	/**
	 * Mappa un oggetto CancelRicaricaContoRequest da PaymatServices a PaymatCore
	 * 
	 * @param request
	 * @return
	 */

	public static CancelRicaricaWalletRequest getCancelRicaricaContoRequest(CancelRicaricaContoRequest request) {
		CancelRicaricaWalletRequest newRequest = new CancelRicaricaWalletRequest();
		
		newRequest.setCallerId(request.getCallerId());
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setUserIp(request.getUserIp());
		newRequest.setFirma(request.getFirma());
		newRequest.setToken(request.getToken());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setReserveRequestId(request.getReserveRequestId());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		
		return newRequest;
	}

	/**
	 * Mappa un oggetto CancelRicaricaContoResponse da PaymatCore a PaymatServices
	 * 
	 * @param request
	 * @return
	 */
	

	public static CancelRicaricaContoResponse getCancelRicaricaContoResponse(CancelRicaricaWalletResponse response) {
		CancelRicaricaContoResponse newResponse = new CancelRicaricaContoResponse();
		newResponse.setCallerId(response.getCallerId());
		newResponse.setRequestID(response.getRequestId());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;

	}

}
