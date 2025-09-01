package it.grupposnai.paymatservices.adapter;

public class BolloAutoAdapter {
	
	// Mapping delle request

		/**
		 * Mappa un oggetto ReserveBolloAutoRequest da PaymatServices a PaymatCore
		 * 
		 * @param request
		 * @return
		 */
		public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.ReserveBolloRequest getReserveBolloAutoRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.bolloAuto.ReserveBolloAutoRequest request) {
			it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.ReserveBolloRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.ReserveBolloRequest();
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
			
			newRequest.setTipoVeicolo(request.getTipoVeicolo());
			newRequest.setTargaVeicolo(request.getTargaVeicolo());
			newRequest.setNumeroTelaio(request.getNumeroTelaio());

			return newRequest;
		}

		/**
		 * Mappa un oggetto ConfirmBolloAutoRequest da PaymatServices a PaymatCore
		 * 
		 * @param request
		 * @return
		 */
		public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.ConfirmBolloRequest getConfirmBolloAutoRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.bolloAuto.ConfirmBolloAutoRequest request) {
			it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.ConfirmBolloRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.ConfirmBolloRequest();
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
		 * Mappa un oggetto CancelBolloAutoRequest da PaymatServices a PaymatCore
		 * 
		 * @param request
		 * @return
		 */
		public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.CancelBolloRequest getCancelBolloAutoRequest(it.grupposnai.paymatservices.model.request.prodottiFinanziari.bolloAuto.CancelBolloAutoRequest request) {
			it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.CancelBolloRequest newRequest = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.CancelBolloRequest();
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
		 * Mappa un oggetto ReserveBolloAutoResponse da PaymatCore a PaymatServices
		 * 
		 * @param response
		 * @return
		 */
		public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.ReserveBolloAutoResponse getReserveBolloAutoResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollo.ReserveBolloResponse response) {
			it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.ReserveBolloAutoResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.ReserveBolloAutoResponse();
			newResponse.setResultCode(response.getResultCode());
			newResponse.setResultDesc(response.getResultDesc());
			newResponse.setIdTranEsterno(response.getIdTranEsterno());
			newResponse.setIdTranPaymat(response.getIdTranPaymat());
			newResponse.setDataCompetenza(response.getDataCompetenza());
			newResponse.setCausale(response.getCausale());
			newResponse.setImporto(response.getImporto());
			return newResponse;
		}

		/**
		 * Mappa un oggetto ConfirmBolloAutoResponse da PaymatCore a PaymatServices
		 * 
		 * @param response
		 * @return
		 */
		public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.ConfirmBolloAutoResponse getConfirmBolloAutoResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollo.ConfirmBolloResponse response) {
			it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.ConfirmBolloAutoResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.ConfirmBolloAutoResponse();
			newResponse.setResultCode(response.getResultCode());
			newResponse.setResultDesc(response.getResultDesc());
			newResponse.setIdTranEsterno(response.getIdTranEsterno());
			newResponse.setIdTranPaymat(response.getIdTranPaymat());
			newResponse.setDataCompetenza(response.getDataCompetenza());
			newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
			return newResponse;
		}

		/**
		 * Mappa un oggetto CancelBolloAutoResponse da PaymatCore a PaymatServices
		 * 
		 * @param response
		 * @return
		 */
		public static it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.CancelBolloAutoResponse getCancelBolloAutoResponse(it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollo.CancelBolloResponse response) {
			it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.CancelBolloAutoResponse newResponse = new it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.CancelBolloAutoResponse();
			newResponse.setResultCode(response.getResultCode());
			newResponse.setResultDesc(response.getResultDesc());
			newResponse.setIdTranEsterno(response.getIdTranEsterno());
			newResponse.setIdTranPaymat(response.getIdTranPaymat());
			newResponse.setDataCancel(response.getDataCancel());
			return newResponse;
		}

}
