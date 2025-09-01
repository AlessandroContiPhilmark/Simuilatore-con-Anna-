package it.grupposnai.paymatservices.adapter;

import it.grupposnai.paymatservices.model.Parameter;
import it.grupposnai.paymatservices.model.request.ricaricaContoGioco.ConfirmRicaricaContoGiocoRequest;
import it.grupposnai.paymatservices.model.request.ricaricaContoGioco.ReserveRicaricaContoGiocoRequest;
import it.grupposnai.paymatservices.model.response.ricaricaContoGioco.ConfirmRicaricaContoGiocoResponse;
import it.grupposnai.paymatservices.model.response.ricaricaContoGioco.ReserveRicaricaContoGiocoResponse;
import it.grupposnai.paymatservices.services.dto.*;

import java.util.ArrayList;
import java.util.List;

public class RicaricaContoGiocoAdapter {

    /**
     * Mappa un oggetto ReserveRicaricaContoGiocoRequest da PaymatServices a PaymatCore
     *
     * @param request
     * @return
     */

    public static it.grupposnai.paymatcore.api.request.ricaricaContoGioco.ReserveRicaricaContoGiocoRequest getReserveRicaricaContoGiocoRequest(ReserveRicaricaContoGiocoRequest request) {
        it.grupposnai.paymatcore.api.request.ricaricaContoGioco.ReserveRicaricaContoGiocoRequest newRequest = new it.grupposnai.paymatcore.api.request.ricaricaContoGioco.ReserveRicaricaContoGiocoRequest();
        newRequest.setRequestId(request.getRequestId());
        newRequest.setCallerId(request.getCallerId());
        newRequest.setSkin(request.getSkin());
        newRequest.setUserIp(request.getUserIp());
        newRequest.setFirma(request.getFirma());
        newRequest.setCode(request.getCode());
        newRequest.setRicWithAircash(request.isRicWithAircash());
        newRequest.setFiscalCode(request.getFiscalCode());
        newRequest.setContoGioco(request.getContoGioco());
        newRequest.setMail(request.getMail());
        newRequest.setAmount(request.getAmount());
        newRequest.setToken(request.getToken());
        newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
        newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
        newRequest.setCab(request.getCab());
        newRequest.setIdTerminale(request.getIdTerminale());
        newRequest.setCodiceBu(request.getCodiceBu());
        return newRequest;
    }

    /**
     * Mappa un oggetto ReserveRicaricaContoGiocoResponse da PaymatCore a PaymatServices
     *
     * @param response
     * @return
     */

    public static ReserveRicaricaContoGiocoResponse getReserveRicaricaContoGiocoResponse(it.grupposnai.paymatcore.api.response.ricaricaContoGioco.ReserveRicaricaContoGiocoResponse response) {
        ReserveRicaricaContoGiocoResponse newResponse = new ReserveRicaricaContoGiocoResponse();
        newResponse.setCallerId(response.getCallerId());
        newResponse.setRequestId(response.getRequestId());
        newResponse.setResultCode(response.getResultCode());
        newResponse.setResultDesc(response.getResultDesc());
        newResponse.setFiscalCode(response.getFiscalCode());
        newResponse.setAmount(response.getAmount());
        newResponse.setCurrencyId(response.getCurrencyId());
        newResponse.setBarCode(response.getBarCode());
        newResponse.setReserveCode(response.getReserveCode());
        newResponse.setContoGioco(response.getContoGioco());
        newResponse.setCro(response.getCro());
        return newResponse;
    }

    public static it.grupposnai.paymatcore.api.request.ricaricaContoGioco.ConfirmRicaricaContoGiocoRequest getConfirmRicaricaContoGiocoRequest(ConfirmRicaricaContoGiocoRequest request) {
        it.grupposnai.paymatcore.api.request.ricaricaContoGioco.ConfirmRicaricaContoGiocoRequest newRequest = new it.grupposnai.paymatcore.api.request.ricaricaContoGioco.ConfirmRicaricaContoGiocoRequest();
        newRequest.setRequestId(request.getRequestId());
        newRequest.setCallerId(request.getCallerId());
        newRequest.setSkin(request.getSkin());
        newRequest.setUserIp(request.getUserIp());
        newRequest.setFirma(request.getFirma());
        newRequest.setReserveCode(request.getReserveCode());
        newRequest.setRicWithAircash(request.isRicWithAircash());
        newRequest.setBarCode(request.getBarCode());
        newRequest.setAmount(request.getAmount());
        newRequest.setContoGioco(request.getContoGioco());
        newRequest.setReserveRequestId(request.getReserveRequestId());
        newRequest.setCro(request.getCro());
        newRequest.setFiscalCode(request.getFiscalCode());
        newRequest.setCodiceBu(request.getCodiceBU());
        newRequest.setToken(request.getToken());
        newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
        return newRequest;
    }

    public static ConfirmRicaricaContoGiocoResponse getConfirmRicaricaContoGiocoResponse(it.grupposnai.paymatcore.api.response.ricaricaContoGioco.ConfirmRicaricaContoGiocoResponse response) {
        ConfirmRicaricaContoGiocoResponse newResponse = new ConfirmRicaricaContoGiocoResponse();
        newResponse.setCallerId(response.getCallerId());
        newResponse.setRequestId(response.getRequestId());
        newResponse.setResultCode(response.getResultCode());
        newResponse.setResultDesc(response.getResultDesc());
        if (response.getTicket() != null) newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
        return newResponse;
    }
}
