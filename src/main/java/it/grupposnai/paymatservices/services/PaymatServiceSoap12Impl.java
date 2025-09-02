package it.grupposnai.paymatservices.services;

import it.cogetech.lib.common.util.Configurazione;
import it.cogetech.lib.common.util.IpAddress;
import it.cogetech.lib.common.util.XmlSerializer;
import it.cogetech.lib.db.util.CostantiDB;
import it.grupposnai.paymatcore.api.PaymatCoreApi;
import it.grupposnai.paymatcore.api.request.login.CheckPaymentLoginConfirmationRequestCore;
import it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.CancelBillFrecciaRequest;
import it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.ConfirmBillFrecciaRequest;
import it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.ReserveBillFrecciaRequest;
import it.grupposnai.paymatcore.api.request.ricaricaConto.CancelRicaricaWalletRequest;
import it.grupposnai.paymatcore.api.request.ricaricaConto.ConfirmRicaricaWalletRequest;
import it.grupposnai.paymatcore.api.request.ricaricaConto.ReserveRicaricaWalletRequest;
import it.grupposnai.paymatcore.api.response.login.CheckPaymentLoginConfirmationResponseCore;
import it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettinoFreccia.CancelBillFrecciaResponse;
import it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettinoFreccia.ConfirmBillFrecciaResponse;
import it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettinoFreccia.ReserveBillFrecciaResponse;
import it.grupposnai.paymatcore.api.response.ricaricaConto.CancelRicaricaWalletResponse;
import it.grupposnai.paymatcore.api.response.ricaricaConto.ConfirmRicaricaWalletResponse;
import it.grupposnai.paymatcore.api.response.ricaricaConto.ReserveRicaricaWalletResponse;
import it.grupposnai.paymatcore.utils.CommissioniManager;
import it.grupposnai.paymatcore.utils.CreditoManager;
import it.grupposnai.paymatcore.utils.GTWServiziManager;
import it.grupposnai.paymatcore.utils.TagliManager;
import it.grupposnai.paymatservices.AuditLogDelegate;
import it.grupposnai.paymatservices.adapter.*;
import it.grupposnai.paymatservices.kafka.KafkaInterceptor;
import it.grupposnai.paymatservices.legacywrapper.OldWsPaymatClient;
import it.grupposnai.paymatservices.legacywrapper.model.GenericResponse;
import it.grupposnai.paymatservices.model.request.generali.*;
import it.grupposnai.paymatservices.model.request.login.CheckPaymentLoginConfirmationRequest;
import it.grupposnai.paymatservices.model.request.login.PaymentLoginRequest;
import it.grupposnai.paymatservices.model.request.pin.*;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettino.*;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettinoFreccia.CancelBollettinoFrecciaRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettinoFreccia.ConfirmBollettinoFrecciaRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettinoFreccia.ReserveBollettinoFrecciaRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.bolloAuto.CancelBolloAutoRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.bolloAuto.ConfirmBolloAutoRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.bolloAuto.ReserveBolloAutoRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.cbill.*;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.mavRav.CancelMavRavRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.mavRav.ConfirmMavRavRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.mavRav.ReserveMavRavRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.pagoPa.CancelPagoPaRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.pagoPa.ConfirmPagoPaRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.pagoPa.ReservePagoPaRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.paymentCode.CancelPaymentCodeRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.paymentCode.ConfirmPaymentCodeRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.paymentCode.ReservePaymentCodeRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.postePay.CancelPostePayRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.postePay.ConfirmPostePayRequest;
import it.grupposnai.paymatservices.model.request.prodottiFinanziari.postePay.ReservePostePayRequest;
import it.grupposnai.paymatservices.model.request.ricarica.*;
import it.grupposnai.paymatservices.model.request.ricaricaConto.CancelRicaricaContoRequest;
import it.grupposnai.paymatservices.model.request.ricaricaConto.ConfirmRicaricaContoRequest;
import it.grupposnai.paymatservices.model.request.ricaricaConto.ReserveRicaricaContoRequest;
import it.grupposnai.paymatservices.model.request.ricaricaContoGioco.ConfirmRicaricaContoGiocoRequest;
import it.grupposnai.paymatservices.model.request.ricaricaContoGioco.ReserveRicaricaContoGiocoRequest;
import it.grupposnai.paymatservices.model.request.sim.AttivaLottoSimRequest;
import it.grupposnai.paymatservices.model.request.sim.CancelAcquistoSimRequest;
import it.grupposnai.paymatservices.model.request.sim.ConfirmAcquistoSimRequest;
import it.grupposnai.paymatservices.model.request.sim.ReserveAcquistoSimRequest;
import it.grupposnai.paymatservices.model.request.snai.voucher.GetDatiVoucherContoGiocoRequest;
import it.grupposnai.paymatservices.model.request.snai.voucher.GetPrelieviContoGiocoRequest;
import it.grupposnai.paymatservices.model.request.snai.voucher.PagamentoVoucherContoGiocoRequest;
import it.grupposnai.paymatservices.model.response.generali.*;
import it.grupposnai.paymatservices.model.response.login.CheckPaymentLoginConfirmationResponse;
import it.grupposnai.paymatservices.model.response.login.PaymentLoginResponse;
import it.grupposnai.paymatservices.model.response.pin.*;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino.*;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.CancelBollettinoFrecciaResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.ConfirmBollettinoFrecciaResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia.ReserveBollettinoFrecciaResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.CancelBolloAutoResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.ConfirmBolloAutoResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.bolloAuto.ReserveBolloAutoResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill.*;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.CancelMavRavResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.ConfirmMavRavResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.mavRav.ReserveMavRavResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.CancelPagoPaResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.ConfirmPagoPaResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa.ReservePagoPaResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.CancelPaymentCodeResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.ConfirmPaymentCodeResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.paymentCode.ReservePaymentCodeResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.CancelPostePayResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.ConfirmPostePayResponse;
import it.grupposnai.paymatservices.model.response.prodottiFinanziari.postePay.ReservePostePayResponse;
import it.grupposnai.paymatservices.model.response.ricarica.*;
import it.grupposnai.paymatservices.model.response.ricaricaConto.CancelRicaricaContoResponse;
import it.grupposnai.paymatservices.model.response.ricaricaConto.ConfirmRicaricaContoResponse;
import it.grupposnai.paymatservices.model.response.ricaricaConto.ReserveRicaricaContoResponse;
import it.grupposnai.paymatservices.model.response.ricaricaContoGioco.ConfirmRicaricaContoGiocoResponse;
import it.grupposnai.paymatservices.model.response.ricaricaContoGioco.ReserveRicaricaContoGiocoResponse;
import it.grupposnai.paymatservices.model.response.sim.AttivaLottoSimResponse;
import it.grupposnai.paymatservices.model.response.sim.CancelAcquistoSimResponse;
import it.grupposnai.paymatservices.model.response.sim.ConfirmAcquistoSimResponse;
import it.grupposnai.paymatservices.model.response.sim.ReserveAcquistoSimResponse;
import it.grupposnai.paymatservices.model.response.snai.voucher.GetDatiVoucherContoGiocoResponse;
import it.grupposnai.paymatservices.model.response.snai.voucher.GetPrelieviContoGiocoResponse;
import it.grupposnai.paymatservices.model.response.snai.voucher.PagamentoVoucherContoGiocoResponse;
import it.grupposnai.paymatservices.util.CostantiWsPaymat;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.interceptor.Interceptors;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.Arrays;
import java.util.Map;


/**
 * This class was generated by Apache CXF 3.1.8 2016-10-26T14:54:32.927+02:00
 * Generated source version: 3.1.8
 */
@Interceptors(KafkaInterceptor.class)
@javax.jws.WebService(targetNamespace = "http://ws.paymatservizi.it/")
@BindingType(value = "http://www.w3.org/2003/05/soap/bindings/HTTP/")
public class PaymatServiceSoap12Impl implements PaymatServiceSoap {

    @Resource
    WebServiceContext context;
    private static final Logger LOG = Logger.getLogger(PaymatServiceSoap12Impl.class.getName());
    private PaymatCoreApi paymatCoreApi;
    private static final Integer ID_BRAND_FASTWEB = 1;







    private boolean isCallerDescrizioneTaglioSenzaImporto(String callerId) {
        boolean ret = false;
        for (String caller : Configurazione.INSTANCE.getString(CostantiWsPaymat.CALLERS_NO_IMPORTO_DESC_TAGLI, "").split("-")) {
            if (StringUtils.isNotBlank(caller) && caller.toUpperCase().equals(callerId.toUpperCase())) {
                ret = true;
                break;
            }
        }
        return ret;
    }

    public InfoTransazioneResponse getInfoTransazione(InfoTransazioneRequest request) {
        LOG.info("Request: " + request);
        InfoTransazioneResponse response;
        try {
            it.grupposnai.paymatcore.api.request.info.InfoTransazioneRequest coreRequest = GeneraliAdapter.getInfoTransazioneRequest(request);
            it.grupposnai.paymatcore.api.response.info.InfoTransazioneResponse coreResponse = getPaymatCoreApi().getInfoTransazione(coreRequest);
            response = GeneraliAdapter.getInfoTransazioniResponse(coreResponse);
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new InfoTransazioneResponse();
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        response.setCallerId(request.getCallerId());
        response.setRequestId(request.getRequestId());
        LOG.info("Response: " + response);
        return response;
    }

    public InfoCreditoResiduoResponse getInfoCreditoResiduo(InfoCreditoResiduoRequest request) {
        LOG.info("Request: " + request);
        InfoCreditoResiduoResponse response;
        try {
            it.grupposnai.paymatcore.api.request.info.InfoCreditoResiduoRequest coreRequest = GeneraliAdapter.getInfoCreditoResiduoRequest(request);
            it.grupposnai.paymatcore.api.response.info.InfoCreditoResiduoResponse coreResponse = getPaymatCoreApi().getInfoCreditoResiduo(coreRequest);
            response = GeneraliAdapter.getInfoCreditoResiduoResponse(coreResponse);
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new InfoCreditoResiduoResponse();
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        response.setCallerId(request.getCallerId());
        response.setRequestId(request.getRequestId());
        LOG.info("Response: " + response);
        return response;
    }

    public InfoCommissioniResponse getInfoCommissioni(InfoCommissioniRequest request) {
        LOG.info("Request: " + request);
        InfoCommissioniResponse response;
        try {
            it.grupposnai.paymatcore.api.request.info.InfoCommissioniRequest coreRequest = GeneraliAdapter.getInfoCommissioniRequest(request);
            it.grupposnai.paymatcore.api.response.info.InfoCommissioniResponse coreResponse = getPaymatCoreApi().getInfoCommissioni(coreRequest);
            response = GeneraliAdapter.getInfoCommissioni(coreResponse);
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new InfoCommissioniResponse();
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto");
        }
        response.setCallerId(request.getCallerId());
        response.setRequestId(request.getRequestId());
        LOG.info("Response: " + response);
        return response;
    }

    /* RICARICHE */

    @Deprecated
    public InfoBrandRicaricheResponse2 infoBrandRicariche(InfoBrandRicaricheRequest request) {

        LOG.info("Request: " + request);
        try {
            it.grupposnai.paymatcore.api.request.info.InfoBrandRicaricheRequest coreRequest = RicaricheAdapter.getInfoBrandRicaricheRequest(request);
            it.grupposnai.paymatcore.api.response.info.InfoBrandRicaricheResponse coreResponse = getPaymatCoreApi().infoBrandRicariche(coreRequest);
            InfoBrandRicaricheResponse2 response = RicaricheAdapter.getInfoBrandRicaricheResponse(coreResponse);
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            LOG.info("Response: " + response);
            return response;
        } catch (java.lang.Exception ex) {
            LOG.error("Errore in infoBrandRicariche", ex);
            InfoBrandRicaricheResponse2 response = new InfoBrandRicaricheResponse2();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode("-101");
            response.setResultDesc("Errore imprevisto in infoBrandRicariche: " + ex.getMessage());
            return response;
        }
    }

    @Deprecated
    public InfoTaglioRicaricheResponse infoTagliRicariche(InfoTaglioRicaricheRequest request) {
        LOG.info("Request: " + request);
        try {
            it.grupposnai.paymatcore.api.request.info.InfoTaglioRicaricheRequest coreRequest = RicaricheAdapter.getInfoTagliRicaricheRequest(request);
            it.grupposnai.paymatcore.api.response.info.InfoTagliRicaricheResponse coreResponse = getPaymatCoreApi().infoTagliRicariche(coreRequest);
            InfoTaglioRicaricheResponse response = RicaricheAdapter.getInfoTaglioRicaricheResponse(coreResponse);
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setIdBrand(request.getIdBrand());
            LOG.info("Response: " + response);
            return response;
        } catch (java.lang.Exception ex) {
            LOG.error("Errore in infoTagliRicariche", ex);
            InfoTaglioRicaricheResponse response = new InfoTaglioRicaricheResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode("-101");
            response.setResultDesc("Errore imprevisto in infoTagliRicariche: " + ex.getMessage());
            return response;
        }
    }

    public ReserveRicaricaTelefonicaResponse2 reserveRicaricaTelefonica(ReserveRicaricaTelefonicaRequest request) {
        if (request.validate() != null) {
            LOG.info("Request: " + request);
            ReserveRicaricaTelefonicaResponse2 response = new ReserveRicaricaTelefonicaResponse2();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode("1");
            response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
            LOG.info("Response: " + response);
            return response;
        }
        if (this.isFastweb(request.getBrand())) {
            return reserveRicaricaTelefonicaLegacy(request);
        } else if (isBrandRicaricheWithOldConnector(request.getBrand())) {
            return reserveRicaricaTelefonicaOldConnectors(request);
        } else {
            LOG.info("Request: " + request);
            try {
                HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
                Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIP(), request.getFirma(), request.getToken(),
                        CostantiWsPaymat.SERVIZIO_RICARICHE + "", CostantiWsPaymat.RESERVE_RICARICA_TELEFONICA + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
                short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
                if (esito == CostantiDB.ESITO_OK) {
                    if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                        // PRIMA VOLTA CHE GESTISCO QUESTA RICHIESTA
                        LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                        it.grupposnai.paymatcore.api.request.ricaricaTelefonica.ReserveRicaricaTelefonicaRequest coreRequest = RicaricheAdapter.getReserveRicaricaTelefonicaRequest(request);
                        it.grupposnai.paymatcore.api.response.ricaricaTelefonica.ReserveRicaricaTelefonicaResponse coreResponse = getPaymatCoreApi().reserveRicaricaTelefonica(coreRequest);
                        ReserveRicaricaTelefonicaResponse2 response = RicaricheAdapter.getReserveRicaricaTelefonicaResponse(coreResponse);
                        response.setCallerId(request.getCallerId());
                        response.setRequestId(request.getRequestId());
                        LOG.info("Response: " + response);
                        AuditLogDelegate.insWebServiceResponseMsg(request.getCallerId(), request.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());
                        return response;
                    } else {
                        // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                        LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                        String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                        ReserveRicaricaTelefonicaResponse2 response = XmlSerializer.unserialize(prevResp, ReserveRicaricaTelefonicaResponse2.class);
                        LOG.info("Response: " + response);
                        return response;
                    }
                } else {
                    // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                    LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                    ReserveRicaricaTelefonicaResponse2 response = new ReserveRicaricaTelefonicaResponse2();
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    response.setResultCode(Short.toString(esito));
                    response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                    LOG.info("Response: " + response);
                    return response;
                }

            } catch (java.lang.Exception ex) {
                // ERRORE IMPREVISTO
                LOG.error("Errore imprevisto", ex);
                ReserveRicaricaTelefonicaResponse2 response = new ReserveRicaricaTelefonicaResponse2();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode("-101");
                response.setResultDesc("Errore imprevisto " + ex.getMessage());
                LOG.info("Response: " + response);
                return response;
            }

        }
    }


    public ConfirmRicaricaTelefonicaResponse2 confirmRicaricaTelefonica(ConfirmRicaricaTelefonicaRequest request) {
        if (request.validate() != null) {
            LOG.info("Request: " + request);
            ConfirmRicaricaTelefonicaResponse2 response = new ConfirmRicaricaTelefonicaResponse2();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode("1");
            response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
            LOG.info("Response: " + response);
            return response;
        }
        if (this.isFastweb(request.getBrand())) {
            return confirmRicaricaTelefonicaLegacy(request);
        } else if (isBrandRicaricheWithOldConnector(request.getBrand())) {
            return confirmRicaricaTelefonicaOldConnectors(request);
        } else {
            LOG.info("Request: " + request);
            try {
                HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
                Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIP(), request.getFirma(), request.getToken(),
                        CostantiWsPaymat.SERVIZIO_RICARICHE + "", CostantiWsPaymat.CONFIRM_RICARICA_TELEFONICA + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
                short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
                if (esito == CostantiDB.ESITO_OK) {
                    if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                        LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                        it.grupposnai.paymatcore.api.request.ricaricaTelefonica.ConfirmRicaricaTelefonicaRequest coreRequest = RicaricheAdapter.getConfirmRicaricaTelefonicaRequest(request);
                        it.grupposnai.paymatcore.api.response.ricaricaTelefonica.ConfirmRicaricaTelefonicaResponse coreResponse = getPaymatCoreApi().confirmRicaricaTelefonica(coreRequest);
                        ConfirmRicaricaTelefonicaResponse2 response = RicaricheAdapter.getConfirmRicaricaTelefonicaResponse(coreResponse);
                        response.setCallerId(request.getCallerId());
                        response.setRequestId(request.getRequestId());
                        //con i nuovi connettori questa if non dovrebbe servire
//						if(response.getTicket() != null) {
//							response.getTicket().setDataScadenza(null); //per le ricariche la data scadenza deve essere null
//						}
                        LOG.info("Response: " + response);
                        AuditLogDelegate.insWebServiceResponseMsg(request.getCallerId(), request.getRequestId(), response);
                        return response;

                    } else {
                        // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE VIENE RESTITUITA
                        LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                        String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                        ConfirmRicaricaTelefonicaResponse2 response = XmlSerializer.unserialize(prevResp, ConfirmRicaricaTelefonicaResponse2.class);
                        LOG.info("Response: " + response);
                        return response;
                    }
                } else {
                    // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                    LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                    ConfirmRicaricaTelefonicaResponse2 response = new ConfirmRicaricaTelefonicaResponse2();
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    response.setResultCode(Short.toString(esito));
                    response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                    LOG.info("Response: " + response);
                    return response;
                }

            } catch (Exception ex) {
                // ERRORE IMPREVISTO
                LOG.error("Errore imprevisto", ex);
                ConfirmRicaricaTelefonicaResponse2 response = new ConfirmRicaricaTelefonicaResponse2();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode("-101");
                response.setResultDesc("Errore imprevisto " + ex.getMessage());
                LOG.info("Response: " + response);
                return response;
            }
        }
    }


    public CancelRicaricaTelefonicaResponse2 cancelRicaricaTelefonica(CancelRicaricaTelefonicaRequest request) {
        if (request.validate() != null) {
            LOG.info("Request: " + request);
            CancelRicaricaTelefonicaResponse2 response = new CancelRicaricaTelefonicaResponse2();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode("1");
            response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
            LOG.info("Response: " + response);
            return response;
        }
        if (this.isFastweb(request.getBrand())) {
            return cancelRicaricaTelefonicaLegacy(request);
        } else if (isBrandRicaricheWithOldConnector(request.getBrand())) {
            return cancelRicaricaTelefonicaOldConnectors(request);
        } else {
            LOG.info("cancelRicaricaTelefonicaRequest - request: " + request);
            try {
                HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
                Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIP(), request.getFirma(), request.getToken(),
                        CostantiWsPaymat.SERVIZIO_RICARICHE + "", CostantiWsPaymat.CANCEL_RICARICA_TELEFONICA + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
                short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
                if (esito == CostantiDB.ESITO_OK) {
                    if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                        LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                        it.grupposnai.paymatcore.api.request.ricaricaTelefonica.CancelRicaricaTelefonicaRequest coreRequest = RicaricheAdapter.getCancelRicaricaTelefonicaRequest(request);
                        it.grupposnai.paymatcore.api.response.ricaricaTelefonica.CancelRicaricaTelefonicaResponse coreResponse = getPaymatCoreApi().cancelRicaricaTelefonica(coreRequest);
                        CancelRicaricaTelefonicaResponse2 response = RicaricheAdapter.getCancelRicaricaTelefonicaResponse(coreResponse);
                        response.setCallerId(request.getCallerId());
                        response.setRequestId(request.getRequestId());
                        LOG.info("Response: " + response);
                        AuditLogDelegate.insWebServiceResponseMsg(request.getCallerId(), request.getRequestId(), response);
                        return response;
                    } else {
                        // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                        LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                        String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                        CancelRicaricaTelefonicaResponse2 response = XmlSerializer.unserialize(prevResp, CancelRicaricaTelefonicaResponse2.class);
                        LOG.info("Response: " + response);
                        return response;
                    }
                } else {
                    // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                    LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                    CancelRicaricaTelefonicaResponse2 response = new CancelRicaricaTelefonicaResponse2();
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    response.setResultCode(Short.toString(esito));
                    response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                    LOG.info("Response: " + response);
                    return response;
                }

            } catch (Exception ex) {
                // ERRORE IMPREVISTO
                LOG.error("Errore imprevisto", ex);
                CancelRicaricaTelefonicaResponse2 response = new CancelRicaricaTelefonicaResponse2();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode("-101");
                response.setResultDesc("Errore imprevisto " + ex.getMessage());
                LOG.info("Response: " + response);
                return response;
            }
        }
    }


    private void copyResultHeader(GenericResponse source, it.grupposnai.paymatservices.model.response.ricarica.GenericResponse target) {
        target.setResultCode(source.getResultCode());
        target.setResultDesc(source.getResultDesc());
        target.setCallerId(source.getCallerId());
        target.setRequestId(source.getRequestId());
    }

    private boolean isBrandRicaricheWithOldConnector(Integer idBrand) {
        //return false; //impostato a false per evitare di sfociare nel ramo dei vecchi connettori
        return Arrays.asList(getBrandRicaricheOldConnectors()).contains(idBrand.toString());
    }

    private boolean isBrandPinWithOldConnector(Integer idBrand) {
        return Arrays.asList(getBrandPinOldConnectors()).contains(idBrand.toString());
    }

    private String[] getBrandRicaricheOldConnectors() {
        String brands = "";
        if (Configurazione.INSTANCE.containsKey(CostantiWsPaymat.BRAND_RICARICHE_LEGACY))
            brands = Configurazione.INSTANCE.getString(CostantiWsPaymat.BRAND_RICARICHE_LEGACY);
        else
            LOG.error("Chiave " + CostantiWsPaymat.BRAND_RICARICHE_LEGACY + " non trovata nel file di properties!");
        LOG.debug("Brand ricariche con connettori legacy = " + brands);
        return brands.split("-");
    }

    private String[] getBrandPinOldConnectors() {
        String brands = "";
        if (Configurazione.INSTANCE.containsKey(CostantiWsPaymat.BRAND_PIN_LEGACY))
            brands = Configurazione.INSTANCE.getString(CostantiWsPaymat.BRAND_PIN_LEGACY);
        else
            LOG.error("Chiave " + CostantiWsPaymat.BRAND_PIN_LEGACY + " non trovata nel file di properties!");
        LOG.debug("Brand pin con connettori legacy = " + brands);
        return brands.split("-");
    }

    /* PIN */

    @Deprecated
    public InfoBrandPinResponse infoBrandPin(InfoBrandPinRequest infoBrandPinRequest) {
        LOG.info("Request: " + infoBrandPinRequest);
        try {
            it.grupposnai.paymatcore.api.request.info.InfoBrandPinRequest request = PinAdapter.getInfoBrandPinRequest(infoBrandPinRequest);
            it.grupposnai.paymatcore.api.response.info.InfoBrandPinResponse response = getPaymatCoreApi().infoBrandPin(request);
            InfoBrandPinResponse infoBrandPinResponse = PinAdapter.getInfoBrandResponse(response);
            infoBrandPinResponse.setCallerId(infoBrandPinRequest.getCallerId());
            infoBrandPinResponse.setRequestId(infoBrandPinRequest.getRequestId());
            LOG.info("Response: " + infoBrandPinResponse);
            return infoBrandPinResponse;
        } catch (java.lang.Exception ex) {
            LOG.error("Errore in infoBrandPin", ex);
            InfoBrandPinResponse response = new InfoBrandPinResponse();
            response.setCallerId(infoBrandPinRequest.getCallerId());
            response.setRequestId(infoBrandPinRequest.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto in infoBrandPin: " + ex.getMessage());
            return response;
        }
    }

    @Deprecated
    public InfoTagliPinResponse infoTagliPin(InfoTagliPinRequest infoTagliPinRequest) {
        LOG.info("Request: " + infoTagliPinRequest);
        try {
            it.grupposnai.paymatcore.api.request.info.InfoTagliPinRequest request = PinAdapter.getInfoTagliRequest(infoTagliPinRequest);
            it.grupposnai.paymatcore.api.response.info.InfoTagliPinResponse response = getPaymatCoreApi().infoTagliPin(request);
            InfoTagliPinResponse infoTagliPinResponse = PinAdapter.getInfoTagliPinResponse(response);
            infoTagliPinResponse.setCallerId(infoTagliPinRequest.getCallerId());
            infoTagliPinResponse.setRequestId(infoTagliPinRequest.getRequestId());
            LOG.info("Response: " + infoTagliPinResponse);
            return infoTagliPinResponse;
        } catch (java.lang.Exception ex) {
            LOG.error("Errore in infoTagliPin", ex);
            InfoTagliPinResponse response = new InfoTagliPinResponse();
            response.setCallerId(infoTagliPinRequest.getCallerId());
            response.setRequestId(infoTagliPinRequest.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto in infoTagliPin: " + ex.getMessage());
            return response;
        }
    }








    public InfoCbillGetBillersResponse infoCbillGetBillers(InfoCbillGetBillersRequest request) {
        LOG.info("Request: " + request);
        try {
            it.grupposnai.paymatcore.api.request.info.InfoCbillGetBillersRequest coreRequest = CbillAdapter.getInfoCbillGetBillersRequest(request);
            it.grupposnai.paymatcore.api.response.info.InfoCbillGetBillersResponse coreResponse = getPaymatCoreApi().infoCbillGetBillers(coreRequest);
            InfoCbillGetBillersResponse response = CbillAdapter.getInfoCbillGetBillersResponse(coreResponse);
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            LOG.info("Response: CallerId=" + response.getCallerId() + " DataCompetenza=" + response.getDataCompetenza() + " IdTranEsterno=" + response.getIdTranEsterno()
                    + " IdTranPaymat=" + response.getIdTranPaymat() + " RequestId=" + response.getRequestId() + " ResultCode=" + response.getResultCode()
                    + " ResultDesc=" + response.getResultDesc() + " Numero enti=" + (response.getListaEnti() != null ? response.getListaEnti().length : "lista null"));
            return response;
        } catch (java.lang.Exception ex) {
            LOG.error("Errore in infoCbillGetBillers", ex);
            InfoCbillGetBillersResponse response = new InfoCbillGetBillersResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto in infoCbillGetBillers: " + ex.getMessage());
            return response;
        }
    }

    public InfoCbillGetBillsResponse infoCbillGetBills(InfoCbillGetBillsRequest request) {
        LOG.info("Request: " + request);
        try {
            it.grupposnai.paymatcore.api.request.info.InfoCbillGetBillsRequest coreRequest = CbillAdapter.getInfoCbillGetBillsRequest(request);
            it.grupposnai.paymatcore.api.response.info.InfoCbillGetBillsResponse coreResponse = getPaymatCoreApi().infoCbillGetBills(coreRequest);
            InfoCbillGetBillsResponse response = CbillAdapter.getInfoCbillGetBillsResponse(coreResponse);
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            LOG.info("Response: CallerId=" + response.getCallerId() + " DataCompetenza=" + response.getDataCompetenza() + " IdTranEsterno=" + response.getIdTranEsterno()
                    + " IdTranPaymat=" + response.getIdTranPaymat() + " RequestId=" + response.getRequestId() + " ResultCode=" + response.getResultCode()
                    + " ResultDesc=" + response.getResultDesc() + " Numero bollettini=" + (response.getListaBollettini() != null ? response.getListaBollettini().length : "lista null"));
            return response;
        } catch (java.lang.Exception ex) {
            LOG.error("Errore in infoBrandPin", ex);
            InfoCbillGetBillsResponse response = new InfoCbillGetBillsResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto in infoBrandPin: " + ex.getMessage());
            return response;
        }
    }

    /* PostePay */


    public InfoEnteBollettinoResponse infoEnteBollettino(InfoEnteBollettinoRequest request) {
        LOG.info("Request: " + request);
        InfoEnteBollettinoResponse response;
        try {
            if (request.validate() != null) {
                response = new InfoEnteBollettinoResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            it.grupposnai.paymatcore.api.request.info.InfoEnteBollettinoRequest coreRequest = BollettinoAdapter.getInfoEnteBollettinoRequest(request);
            it.grupposnai.paymatcore.api.response.info.InfoEnteBollettinoResponse coreResponse = getPaymatCoreApi().infoEnteBollettino(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
            response = BollettinoAdapter.getInfoEnteBollettinoResponse(coreResponse);
        } catch (Exception ex) {
            response = new InfoEnteBollettinoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.error("Errore in infoEnteBollettino", ex);
        }
        LOG.info("Response: " + response);
        return response;
    }

    public RegistrazioneEnteBollettinoResponse registrazioneEnteBollettino(RegistrazioneEnteBollettinoRequest request) {
        LOG.info("Request: " + request);
        RegistrazioneEnteBollettinoResponse response;
        try {
            it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.RegistrazioneEnteBollettinoRequest coreRequest = BollettinoAdapter.getRegistrazioneEnteBollettinoRequest(request);
            it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettini.RegistrazioneEnteBollettinoResponse coreResponse = getPaymatCoreApi().registrazioneEnteBollettino(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
            response = BollettinoAdapter.getRegistrazioneEnteBollettinoResponse(coreResponse);
        } catch (Exception ex) {
            response = new RegistrazioneEnteBollettinoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.error("Errore in registrazioneEnteBollettino", ex);
        }
        LOG.info("Response: " + response);
        return response;
    }

    /* PagoPa */


    /* BolloAuto */


    /* Payment Code */


    public AttivaLottoSimResponse attivaLottoSim(AttivaLottoSimRequest request) {
        LOG.info("Request: " + request);
        AttivaLottoSimResponse response;
        try {
            if (request.validate() != null) {
                response = new AttivaLottoSimResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(), CostantiWsPaymat.DEFAULT_CODICE_SERVIZIO + "",
                    CostantiWsPaymat.DEFAULT_CODICE_MESSAGGIO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.sim.AttivaLottoSimRequest coreRequest = SimAdapter.getAttivaLottoSimRequest(request);
                    it.grupposnai.paymatcore.api.response.sim.AttivaLottoSimResponse coreResponse = getPaymatCoreApi().attivaLottoSim(coreRequest);
                    response = SimAdapter.getAttivaLottoSimResponse(coreResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, AttivaLottoSimResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new AttivaLottoSimResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode((int) esito);
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + response);
                return response;
            }

        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new AttivaLottoSimResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    /* Voucher conti gioco */

    @Override
    public GetDatiVoucherContoGiocoResponse getDatiVoucherContoGioco(GetDatiVoucherContoGiocoRequest request) {
        LOG.info("Request: " + request);
        GetDatiVoucherContoGiocoResponse response;
        try {
            if (request.validate() != null) {
                response = GetDatiVoucherContoGiocoResponse.build(request.getCallerId(), request.getRequestId(), CostantiWsPaymat.VALIDATION_ERROR_CODE, CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
            } else {
                Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request, (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST));
                short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
                if (esito == CostantiDB.ESITO_OK) {
                    // Per questo metodo, nonostante il log della richiesta, non viene sfruttata la retry per avere sempre info fresche
                    it.grupposnai.paymatcore.api.request.snai.voucher.GetDatiVoucherContoGiocoRequest coreRequest = VoucherAdapter.getGetDatiVoucherContoGiocoRequest(request);
                    it.grupposnai.paymatcore.api.response.snai.voucher.GetDatiVoucherContoGiocoResponse coreResponse = getPaymatCoreApi().getDatiVoucherContoGioco(coreRequest);
                    response = VoucherAdapter.getGetDatiVoucherContoGiocoResponse(coreResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                } else {
                    // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                    LOG.error("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                    response = GetDatiVoucherContoGiocoResponse.build(request.getCallerId(), request.getRequestId(), (int) esito, rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                }
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = GetDatiVoucherContoGiocoResponse.build(request.getCallerId(), request.getRequestId(), -101, "Errore imprevisto " + ex.getMessage());
        }
        LOG.info("Response: " + response);
        return response;
    }

    @Override
    public PagamentoVoucherContoGiocoResponse pagamentoVoucherContoGioco(PagamentoVoucherContoGiocoRequest request) {
        LOG.info("Request: " + request);
        PagamentoVoucherContoGiocoResponse response;
        try {
            if (request.validate() != null) {
                response = PagamentoVoucherContoGiocoResponse.build(request.getCallerId(), request.getRequestId(), CostantiWsPaymat.VALIDATION_ERROR_CODE, CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
            } else {
                Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request, (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST));
                short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
                if (esito == CostantiDB.ESITO_OK) {
                    if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                        // NUOVA RICHIESTA
                        LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                        it.grupposnai.paymatcore.api.request.snai.voucher.PagamentoVoucherContoGiocoRequest coreRequest = VoucherAdapter.getPagamentoVoucherContoGiocoRequest(request);
                        it.grupposnai.paymatcore.api.response.snai.voucher.PagamentoVoucherContoGiocoResponse coreResponse = getPaymatCoreApi().pagamentoVoucherContoGioco(coreRequest);
                        response = VoucherAdapter.getPagamentoVoucherContoGiocoResponse(coreResponse);
                        AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    } else {
                        // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                        LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                        String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                        response = XmlSerializer.unserialize(prevResp, PagamentoVoucherContoGiocoResponse.class);
                    }
                } else {
                    // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                    LOG.error("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                    response = PagamentoVoucherContoGiocoResponse.build(request.getCallerId(), request.getRequestId(), (int) esito, rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                }
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = PagamentoVoucherContoGiocoResponse.build(request.getCallerId(), request.getRequestId(), -101, "Errore imprevisto " + ex.getMessage());
        }
        LOG.info("Response: " + response);
        return response;
    }

    @Override
    public GetPrelieviContoGiocoResponse getPrelieviContoGioco(GetPrelieviContoGiocoRequest request) {
        LOG.info("Request: " + request);
        GetPrelieviContoGiocoResponse response;
        try {
            if (request.validate() != null) {
                response = GetPrelieviContoGiocoResponse.build(request.getCallerId(), request.getRequestId(), CostantiWsPaymat.VALIDATION_ERROR_CODE, CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
            } else {
                // NESSUNA GESTIONE DELLA RETRY
                it.grupposnai.paymatcore.api.request.snai.voucher.GetPrelieviContoGiocoRequest coreRequest = VoucherAdapter.getGetPrelieviContoGiocoRequest(request);
                it.grupposnai.paymatcore.api.response.snai.voucher.GetPrelieviContoGiocoResponse coreResponse = getPaymatCoreApi().getPrelieviContoGioco(coreRequest);
                response = VoucherAdapter.getGetPrelieviContoGiocoRequest(coreResponse);
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = GetPrelieviContoGiocoResponse.build(request.getCallerId(), request.getRequestId(), -101, "Errore imprevisto " + ex.getMessage());
        }
        LOG.info("Response: " + response);
        return response;
    }

    private PaymatCoreApi getPaymatCoreApi() throws NamingException {
        if (this.paymatCoreApi == null) {
            try {
                this.paymatCoreApi = new PaymatCoreApi(true, new InitialContext());
            } catch (NamingException e) {
                LOG.error("Errore nella creazione di PaymatCoreApi", e);
                throw e;
            }
        }
        return this.paymatCoreApi;
    }

//	BollettinoFreccia


    public CheckPaymentLoginConfirmationResponse checkPaymentLoginConfirmation(CheckPaymentLoginConfirmationRequest request) {

        CheckPaymentLoginConfirmationResponse response = new CheckPaymentLoginConfirmationResponse();
        LOG.info("request:" + request);
        try {
            CheckPaymentLoginConfirmationRequestCore coreRequest = new CheckPaymentLoginConfirmationRequestCore();

            coreRequest.setCallerId(request.getCallerId());
            coreRequest.setRequestId(request.getRequestId());
            coreRequest.setSkin(request.getSkin());
            coreRequest.setUserIp(request.getUserIp());
            coreRequest.setFirma(request.getFirma());
            coreRequest.setToken(request.getToken());
            coreRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
            coreRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
            coreRequest.setCab(request.getCab());
            coreRequest.setIdTerminale(request.getIdTerminale());
            coreRequest.setAuthenticationId(request.getAuthenticationId());
            CheckPaymentLoginConfirmationResponseCore coreResponse = getPaymatCoreApi().executeCheckPaymentLoginConfirmation(coreRequest);

            response.setResultCode(coreResponse.getResultCode());
            response.setRequestId(coreResponse.getRequestId());
            response.setCallerId(coreResponse.getCallerId());
            response.setResultDesc(coreResponse.getResultDesc());
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new CheckPaymentLoginConfirmationResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            //return response;
        }
        return response;
    }

    public PaymentLoginResponse paymentLogin(PaymentLoginRequest request) {

        PaymentLoginResponse response = null;
        LOG.info("request:" + request);
        try {
            if (!request.validate()) {
                response = new PaymentLoginResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }

            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.DEFAULT_CODICE_MESSAGGIO + "", CostantiWsPaymat.DEFAULT_CODICE_MESSAGGIO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);

            if (esito == CostantiDB.ESITO_OK) {
                it.grupposnai.paymatcore.api.request.login.PaymentLoginRequest coreReq = new it.grupposnai.paymatcore.api.request.login.PaymentLoginRequest();

                coreReq.setCallerId(request.getCallerId());
                coreReq.setRequestId(request.getRequestId());
                coreReq.setSkin(request.getSkin());
                coreReq.setUserIp(request.getUserIp());
                coreReq.setFirma(request.getFirma());
                coreReq.setToken(request.getToken());
                coreReq.setIdAziendaDistributore(request.getIdAziendaDistributore());
                coreReq.setIdAziendaEsercente(request.getIdAziendaEsercente());
                coreReq.setIdTerminale(request.getIdTerminale());
                coreReq.setCab(request.getCab());
                coreReq.setUsername(request.getUsername());
                coreReq.setPassword(request.getPassword());

                response = new PaymentLoginResponse();
                it.grupposnai.paymatcore.api.response.login.PaymentLoginResponse coreResponse = getPaymatCoreApi().executeLoginSepafin(coreReq, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                response.setRequestId(request.getRequestId());
                response.setCallerId(request.getCallerId());
                response.setResultCode(coreResponse.getResultCode());
                response.setResultDesc(coreResponse.getResultDesc());
                response.setOtpRequired(coreResponse.getOtpRequired());
                response.setAuthenticationId(coreResponse.getAuthenticationId());
                AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                LOG.info("Response: " + response);
                //return response;
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new PaymentLoginResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode((int) esito);
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + response);
                //return response;
            }

        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new PaymentLoginResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            //return response;
        }

        return response;
    }

    public CancelAcquistoPinVivacardResponse cancelAcquistoPinVivacard(CancelAcquistoPinVivacardRequest cancelAcquistoPinVivacardRequest) {


        LOG.info("cancelAcquistoPinVivacard - request: " + cancelAcquistoPinVivacardRequest);
        try {
            if (cancelAcquistoPinVivacardRequest.validate() != null) {
                LOG.info("Request: " + cancelAcquistoPinVivacardRequest);
                CancelAcquistoPinVivacardResponse response = new CancelAcquistoPinVivacardResponse();
                response.setCallerId(cancelAcquistoPinVivacardRequest.getCallerId());
                response.setRequestId(cancelAcquistoPinVivacardRequest.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + cancelAcquistoPinVivacardRequest.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(cancelAcquistoPinVivacardRequest.getRequestId(), cancelAcquistoPinVivacardRequest.getCallerId(), cancelAcquistoPinVivacardRequest.getSkin(), cancelAcquistoPinVivacardRequest.getUserIP(), cancelAcquistoPinVivacardRequest.getFirma(), cancelAcquistoPinVivacardRequest.getToken(),
                    CostantiWsPaymat.SERVIZIO_PIN_DISPATCHING + "", CostantiWsPaymat.CANCEL_ACQUISTO_PIN + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), cancelAcquistoPinVivacardRequest);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + cancelAcquistoPinVivacardRequest.getCallerId() + " e requestId=" + cancelAcquistoPinVivacardRequest.getRequestId());
                    it.grupposnai.paymatcore.api.request.acquisto.snai.CancelAcquistoPinVivacardRequest request = PinAdapter.getCancelAcquistoPinVivacardRequest(cancelAcquistoPinVivacardRequest);

                    it.grupposnai.paymatcore.api.response.acquisto.snai.CancelAcquistoPinVivacardResponse response = getPaymatCoreApi().cancelAcquistoPinVivacard(request);

                    CancelAcquistoPinVivacardResponse cancelAcquistoPinVivacardResponse = PinAdapter.getCancelAcquistoPinVivacardResponse(response);
                    cancelAcquistoPinVivacardResponse.setCallerId(cancelAcquistoPinVivacardRequest.getCallerId());
                    cancelAcquistoPinVivacardResponse.setRequestId(cancelAcquistoPinVivacardRequest.getRequestId());
                    LOG.info("Response: " + cancelAcquistoPinVivacardResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(cancelAcquistoPinVivacardRequest.getCallerId(), cancelAcquistoPinVivacardRequest.getRequestId(), cancelAcquistoPinVivacardResponse);
                    return cancelAcquistoPinVivacardResponse;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + cancelAcquistoPinVivacardRequest.getCallerId() + " e requestId=" + cancelAcquistoPinVivacardRequest.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    CancelAcquistoPinVivacardResponse cancelAcquistoPinResponse = XmlSerializer.unserialize(prevResp, CancelAcquistoPinVivacardResponse.class);
                    LOG.info("Response: " + cancelAcquistoPinResponse);
                    return cancelAcquistoPinResponse;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                CancelAcquistoPinVivacardResponse cancelAcquistoPinVivacardResponse = new CancelAcquistoPinVivacardResponse();
                cancelAcquistoPinVivacardResponse.setCallerId(cancelAcquistoPinVivacardRequest.getCallerId());
                cancelAcquistoPinVivacardResponse.setRequestId(cancelAcquistoPinVivacardRequest.getRequestId());
                cancelAcquistoPinVivacardResponse.setResultCode((int) esito);
                cancelAcquistoPinVivacardResponse.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + cancelAcquistoPinVivacardResponse);
                return cancelAcquistoPinVivacardResponse;
            }

        } catch (Exception ex) {
            //ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            CancelAcquistoPinVivacardResponse cancelAcquistoPinVivacardResponse = new CancelAcquistoPinVivacardResponse();
            cancelAcquistoPinVivacardResponse.setCallerId(cancelAcquistoPinVivacardRequest.getCallerId());
            cancelAcquistoPinVivacardResponse.setRequestId(cancelAcquistoPinVivacardRequest.getRequestId());
            cancelAcquistoPinVivacardResponse.setResultCode(-101);
            cancelAcquistoPinVivacardResponse.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + cancelAcquistoPinVivacardResponse);
            return cancelAcquistoPinVivacardResponse;
        }
    }

}
