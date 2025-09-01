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

    private boolean isFastweb(final Integer idBrand) {
        return (Configurazione.INSTANCE.getBoolean(CostantiWsPaymat.LEGACY_FASTWEB, true)) ? idBrand.equals(ID_BRAND_FASTWEB) : false;
    }

    private String getSepafinCallbackUrl() {
        return (Configurazione.INSTANCE.getString(CostantiWsPaymat.SEPAFIN_CALLBACK_URL));
    }

    private String getPrenotazioneServiceEndpoint() {
        return (Configurazione.INSTANCE.getString(CostantiWsPaymat.PRENOTAZIONESERVICE_WSDL_URL));
    }

    private String getSepafinAuthUser() {
        return (Configurazione.INSTANCE.getString(CostantiWsPaymat.SEPAFIN_AUTH_USER));
    }

    private String getSepafinAuthPwd() {
        return (Configurazione.INSTANCE.getString(CostantiWsPaymat.SEPAFIN_AUTH_PWD));
    }

    private String getSepafinConnectorEndpoint() {
        return (Configurazione.INSTANCE.getString(CostantiWsPaymat.SEPAFIN_CONNECTOR_ENDPOINT));
    }

    /* GENERALI */

    public GetCategorieResponse getCategorie(GetCategorieRequest request) {
        LOG.info("Request: " + request);
        GetCategorieResponse response;
        try {
            it.grupposnai.paymatcore.api.request.info.GetCategorieRequest coreRequest = GeneraliAdapter.getGetCategorieRequest(request);
            it.grupposnai.paymatcore.api.response.info.GetCategorieResponse coreResponse = getPaymatCoreApi().getCategorie(coreRequest);
            response = GeneraliAdapter.getGetCategorieResponse(coreResponse);
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new GetCategorieResponse();
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto");
        }
        response.setCallerId(request.getCallerId());
        response.setRequestId(request.getRequestId());
        LOG.info("Response: " + response);
        return response;
    }

    public GetBrandResponse getBrand(GetBrandRequest request) {
        LOG.info("Request: " + request);
        GetBrandResponse response;
        try {
            it.grupposnai.paymatcore.api.request.info.GetBrandRequest coreRequest = GeneraliAdapter.getGetBrandRequest(request);
            it.grupposnai.paymatcore.api.response.info.GetBrandResponse coreResponse = getPaymatCoreApi().getBrand(coreRequest);
            response = GeneraliAdapter.getGetBrandResponse(coreResponse);
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new GetBrandResponse();
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto");
        }
        response.setCallerId(request.getCallerId());
        response.setRequestId(request.getRequestId());
        LOG.info("Response: " + response);
        return response;
    }

    public GetTagliResponse getTagli(GetTagliRequest request) {
        LOG.info("Request: " + request);
        GetTagliResponse response;
        try {
            it.grupposnai.paymatcore.api.request.info.GetTagliRequest coreRequest = GeneraliAdapter.getGetTagliRequest(request);
            it.grupposnai.paymatcore.api.response.info.GetTagliResponse coreResponse = getPaymatCoreApi().getTagli(coreRequest);
            response = GeneraliAdapter.getGetTagliResponse(coreResponse, !isCallerDescrizioneTaglioSenzaImporto(request.getCallerId()));
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new GetTagliResponse();
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto");
        }
        response.setCallerId(request.getCallerId());
        response.setRequestId(request.getRequestId());
        LOG.info("Response: " + response);
        return response;
    }

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

    private ReserveRicaricaTelefonicaResponse2 reserveRicaricaTelefonicaLegacy(
            ReserveRicaricaTelefonicaRequest request) {
        LOG.info("wrapping ReserveRicaricaTelefonica - request: " + request);
        try {
            ReserveRicaricaTelefonicaResponse2 response = new ReserveRicaricaTelefonicaResponse2();

            Integer importoTransazione = TagliManager.getImportoTaglio(request.getTaglio(), request.getBrand(), request.getRequestId(), request.getImporto());
            Integer commissioniTransazione = CommissioniManager.getInfoCommissioni(request.getCallerId(), request.getRequestId(), request.getIdTerminale(), request.getBrand(), request.getTaglio(), request.getToken(), request.getIdAziendaDistributore(), request.getIdAziendaEsercente(), request.getCab(), request.getSkin(), request.getUserIP());
            if (importoTransazione == null || commissioniTransazione == null) {
                LOG.error("Problema nel recupero di importo e commissioni, viene interrotta la reserve - importo=[" + importoTransazione + "] commissioni=[" + commissioniTransazione + "]");
                response.setResultCode("110");
                response.setResultDesc("Brand o taglio non permesso");
                return response;
            }

            if (CreditoManager.checkCodiceCreditoDaUtilizzare(request.getCallerId(), request.getCodiceCredito())) {
                Map<String, Object> rt = CreditoManager.getInstance().setUtilizzoCreditoRicariche(request.getRequestId(), request.getCodiceCredito(), ID_BRAND_FASTWEB, request.getTaglio(), request.getIdAziendaDistributore(), request.getIdAziendaEsercente(), request.getCab(), request.getIdTerminale(), request.getToken(), importoTransazione);
                if ((Integer) rt.get("resultcode") != 0) {
                    LOG.info("Utilizzo credito non andato a buon fine, viene interrotta la reserve - requestId=[" + request.getRequestId() + "] codiceCredito=[" + request.getCodiceCredito() + "] idBrand=[" + ID_BRAND_FASTWEB + "] idTaglio=[" + request.getTaglio() + "]");
                    response.setResultCode(((Integer) rt.get("resultcode")).toString());
                    response.setResultDesc((String) rt.get("resultdesc"));
                    return response;
                }
            }

            if (GTWServiziManager.isTerminalGTWServizi(request.getIdTerminale())) {
                String errorMessage = GTWServiziManager.getInstance().withdrawRetailFromTaglio(request.getCallerId(), request.getRequestId(), request.getIdTerminale(), request.getBrand(), request.getTaglio(), request.getToken(), request.getIdAziendaDistributore(), request.getIdAziendaEsercente(), request.getCab(), request.getSkin(), request.getUserIP(), importoTransazione);
                if (StringUtils.isNotBlank(errorMessage)) {
                    LOG.info("Sincronizzazione self su GTWServizi non andata a buon fine, viene interrotta la reserve - requestId=[" + request.getRequestId() + "] idTerminale=[" + request.getIdTerminale() + "] idBrand=[" + request.getBrand() + "] idTaglio=[" + request.getTaglio() + "]");
                    response.setResultCode("110");
                    response.setResultDesc(errorMessage);
                    return response;
                }
            }

            it.grupposnai.paymatservices.legacywrapper.model.ReserveRicaricaTelefonicaRequest oldRequest = new it.grupposnai.paymatservices.legacywrapper.model.ReserveRicaricaTelefonicaRequest();
            BeanUtils.copyProperties(oldRequest, request);
            oldRequest.setImportoTransazione(importoTransazione);
            oldRequest.setCommissioniTransazione(commissioniTransazione);
            String endPointAddress = Configurazione.INSTANCE.getString(CostantiWsPaymat.OLD_WS_PAYMATSERVICES_WSDL);
            it.grupposnai.paymatservices.legacywrapper.model.ReserveRicaricaTelefonicaResponse2 oldResponse = OldWsPaymatClient.reserveRicaricaTelefonica(oldRequest, endPointAddress);
            BeanUtils.copyProperties(response, oldResponse);
            copyResultHeader(oldResponse, response);

            if (!response.getResultCode().equals("0")) {
                if (CreditoManager.checkCodiceCreditoDaUtilizzare(request.getCallerId(), request.getCodiceCredito())) {
                    CreditoManager.getInstance().setStornoCredito(request.getRequestId(), request.getCodiceCredito(), request.getIdAziendaDistributore(), request.getIdAziendaEsercente(), request.getCab(), request.getToken(), request.getIdTerminale());
                }
                if (GTWServiziManager.isTerminalGTWServizi(request.getIdTerminale())) {
                    GTWServiziManager.getInstance().cancelWithdrawRetail(request.getCallerId(), request.getRequestId(), request.getIdTerminale(), request.getSkin(), request.getUserIP());
                }
            }

            LOG.info("wrapping ReserveRicaricaTelefonica - response: " + response);
            return response;

        } catch (java.lang.Exception ex) {
            LOG.error("ReserveRicaricaTelefonica", ex);
            ReserveRicaricaTelefonicaResponse2 response = new ReserveRicaricaTelefonicaResponse2();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode("-101");
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    private ReserveRicaricaTelefonicaResponse2 reserveRicaricaTelefonicaOldConnectors(ReserveRicaricaTelefonicaRequest request) {
        LOG.info("wrapping ReserveRicaricaTelefonica - request: " + request);
        ReserveRicaricaTelefonicaResponse2 response;
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
                    it.grupposnai.paymatcore.api.response.ricaricaTelefonica.ReserveRicaricaTelefonicaResponse coreResponse = getPaymatCoreApi().reserveRicaricaTelefonicaOldConnectors(coreRequest);
                    response = RicaricheAdapter.getReserveRicaricaTelefonicaResponse(coreResponse);
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    LOG.info("wrapping ReserveRicaricaTelefonica - response: " + response);
                    AuditLogDelegate.insWebServiceResponseMsg(request.getCallerId(), request.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReserveRicaricaTelefonicaResponse2.class);
                    LOG.info("wrapping ReserveRicaricaTelefonica - response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReserveRicaricaTelefonicaResponse2();
                response.setResultCode(Short.toString(esito));
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new ReserveRicaricaTelefonicaResponse2();
            response.setResultCode("-101");
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        response.setCallerId(request.getCallerId());
        response.setRequestId(request.getRequestId());
        LOG.info("wrapping ReserveRicaricaTelefonica - response: " + response);
        return response;
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

    private ConfirmRicaricaTelefonicaResponse2 confirmRicaricaTelefonicaLegacy(
            ConfirmRicaricaTelefonicaRequest request) {
        LOG.info("wrapping ConfirmRicaricaTelefonica - request: " + request);
        try {
            it.grupposnai.paymatservices.legacywrapper.model.ConfirmRicaricaTelefonicaRequest oldRequest = new it.grupposnai.paymatservices.legacywrapper.model.ConfirmRicaricaTelefonicaRequest();
            BeanUtils.copyProperties(oldRequest, request);
            String endPointAddress = Configurazione.INSTANCE.getString(CostantiWsPaymat.OLD_WS_PAYMATSERVICES_WSDL);
            it.grupposnai.paymatservices.legacywrapper.model.ConfirmRicaricaTelefonicaResponse2 oldResponse = OldWsPaymatClient.confirmRicaricaTelefonica(oldRequest, endPointAddress);
            ConfirmRicaricaTelefonicaResponse2 response = new ConfirmRicaricaTelefonicaResponse2();
            try {
                BeanUtils.copyProperties(response, oldResponse);
            } catch (IllegalArgumentException e1) {
                //ignoro probablimente non ÃƒÂ¨ riuscito a copiare l'oggetto Ticket
            }
            it.grupposnai.paymatservices.model.response.ricarica.Ticket newTicket = new Ticket();
            if (oldResponse.getTicket() != null) {
                BeanUtils.copyProperties(newTicket, oldResponse.getTicket());
                newTicket.setCab(oldResponse.getTicket().getCAB());
                response.setIdTranPaymat(oldResponse.getTicket().getIdTranPaymat());
            }
            response.setTicket(newTicket);
            copyResultHeader(oldResponse, response);
            LOG.info("wrapping ConfirmRicaricaTelefonica - response: " + response);
            if (response != null && response.getResultCode().equals("0")) {
                it.grupposnai.paymatcore.api.response.info.Ticket coreTicket = null;
                if (response.getTicket() != null) {
                    coreTicket = new it.grupposnai.paymatcore.api.response.info.Ticket();
                    coreTicket.setImportoFacciale(response.getTicket().getImportoFacciale());
                    coreTicket.setIdTerminale(response.getTicket().getIdTerminale());
                    coreTicket.setIdTranPaymat(response.getTicket().getIdTranPaymat());
                }
                it.grupposnai.paymatcore.utils.GTWServiziManager.getInstance().setMovimentoCassa(request.getCallerId(), request.getSkin(), request.getIdterminale(), request.getReserveRequestId(), request.getRequestId(), request.getUserIP(), coreTicket);
            }

            if (StringUtils.isNotBlank(request.getCodiceCredito()) && !response.getResultCode().equals("0"))
                CreditoManager.getInstance().setStornoCredito(request.getReserveRequestId(), request.getCodiceCredito(), request.getIdAziendaDistributore(), request.getIdAziendaEsercente(), request.getCab(), request.getToken(), request.getIdterminale());

            return response;

        } catch (java.lang.Exception ex) {
            LOG.error("ConfirmRicaricaTelefonica", ex);
            ConfirmRicaricaTelefonicaResponse2 response = new ConfirmRicaricaTelefonicaResponse2();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode("-101");
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    private ConfirmRicaricaTelefonicaResponse2 confirmRicaricaTelefonicaOldConnectors(ConfirmRicaricaTelefonicaRequest request) {
        LOG.info("wrapping ConfirmRicaricaTelefonica - request: " + request);
        ConfirmRicaricaTelefonicaResponse2 response;
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIP(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_RICARICHE + "", CostantiWsPaymat.CONFIRM_RICARICA_TELEFONICA + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.ricaricaTelefonica.ConfirmRicaricaTelefonicaRequest coreRequest = RicaricheAdapter.getConfirmRicaricaTelefonicaRequest(request);
                    it.grupposnai.paymatcore.api.response.ricaricaTelefonica.ConfirmRicaricaTelefonicaResponse coreResponse = getPaymatCoreApi().confirmRicaricaTelefonicaOldConnectors(coreRequest);
                    response = RicaricheAdapter.getConfirmRicaricaTelefonicaResponse(coreResponse);
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    if (response.getTicket() != null) {
                        response.getTicket().setDataScadenza(null); //per le ricariche la data scadenza deve essere null
                    }
                    LOG.info("wrapping ReserveRicaricaTelefonica - response: " + response);
                    AuditLogDelegate.insWebServiceResponseMsg(request.getCallerId(), request.getRequestId(), response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmRicaricaTelefonicaResponse2.class);
                    LOG.info("wrapping ReserveRicaricaTelefonica - response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmRicaricaTelefonicaResponse2();
                response.setResultCode(Short.toString(esito));
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new ConfirmRicaricaTelefonicaResponse2();
            response.setResultCode("-101");
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        response.setCallerId(request.getCallerId());
        response.setRequestId(request.getRequestId());
        LOG.info("wrapping ReserveRicaricaTelefonica - response: " + response);
        return response;
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

    private CancelRicaricaTelefonicaResponse2 cancelRicaricaTelefonicaLegacy(CancelRicaricaTelefonicaRequest request) {
        LOG.info("wrapping CancelRicaricaTelefonica - request: " + request);
        try {
            it.grupposnai.paymatservices.legacywrapper.model.CancelRicaricaTelefonicaRequest oldRequest = new it.grupposnai.paymatservices.legacywrapper.model.CancelRicaricaTelefonicaRequest();
            BeanUtils.copyProperties(oldRequest, request);
            String endPointAddress = Configurazione.INSTANCE.getString(CostantiWsPaymat.OLD_WS_PAYMATSERVICES_WSDL);
            it.grupposnai.paymatservices.legacywrapper.model.CancelRicaricaTelefonicaResponse2 oldResponse = OldWsPaymatClient.cancelRicaricaTelefonica(oldRequest, endPointAddress);
            CancelRicaricaTelefonicaResponse2 response = new CancelRicaricaTelefonicaResponse2();
            BeanUtils.copyProperties(response, oldResponse);
            copyResultHeader(oldResponse, response);
            if (StringUtils.isNotBlank(request.getCodiceCredito()) && !response.getResultCode().equals("0"))
                CreditoManager.getInstance().setStornoCredito(request.getReserveRequestId(), request.getCodiceCredito(), request.getIdAziendaDistributore(), request.getIdAziendaEsercente(), null, request.getToken(), null);
            LOG.info("wrapping CancelRicaricaTelefonica - response: " + response);
            return response;
        } catch (java.lang.Exception ex) {
            LOG.error("CancelRicaricaTelefonica", ex);
            CancelRicaricaTelefonicaResponse2 response = new CancelRicaricaTelefonicaResponse2();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode("-101");
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    private CancelRicaricaTelefonicaResponse2 cancelRicaricaTelefonicaOldConnectors(CancelRicaricaTelefonicaRequest request) {
        LOG.info("wrapping CancelRicaricaTelefonica - Request: " + request);
        CancelRicaricaTelefonicaResponse2 response;
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIP(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_RICARICHE + "", CostantiWsPaymat.CANCEL_RICARICA_TELEFONICA + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.ricaricaTelefonica.CancelRicaricaTelefonicaRequest coreRequest = RicaricheAdapter.getCancelRicaricaTelefonicaRequest(request);
                    it.grupposnai.paymatcore.api.response.ricaricaTelefonica.CancelRicaricaTelefonicaResponse coreResponse = getPaymatCoreApi().cancelRicaricaTelefonicaOldConnectors(coreRequest);
                    response = RicaricheAdapter.getCancelRicaricaTelefonicaResponse(coreResponse);
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    LOG.info("wrapping CancelRicaricaTelefonica - Response: " + response);
                    AuditLogDelegate.insWebServiceResponseMsg(request.getCallerId(), request.getRequestId(), response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelRicaricaTelefonicaResponse2.class);
                    LOG.info("wrapping CancelRicaricaTelefonica - Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelRicaricaTelefonicaResponse2();
                response.setResultCode(Short.toString(esito));
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new CancelRicaricaTelefonicaResponse2();
            response.setResultCode("-101");
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        response.setCallerId(request.getCallerId());
        response.setRequestId(request.getRequestId());
        LOG.info("wrapping CancelRicaricaTelefonica - Response: " + response);
        return response;
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

    public ReserveAcquistoPinResponse reserveAcquistoPin(ReserveAcquistoPinRequest reserveAcquistoPinRequest) {
        LOG.info("Request: " + reserveAcquistoPinRequest);
        try {
            if (reserveAcquistoPinRequest.validate() != null) {
                LOG.info("Request: " + reserveAcquistoPinRequest);
                ReserveAcquistoPinResponse response = new ReserveAcquistoPinResponse();
                response.setCallerId(reserveAcquistoPinRequest.getCallerId());
                response.setRequestId(reserveAcquistoPinRequest.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + reserveAcquistoPinRequest.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(reserveAcquistoPinRequest.getRequestId(), reserveAcquistoPinRequest.getCallerId(), reserveAcquistoPinRequest.getSkin(), reserveAcquistoPinRequest.getUserIP(), reserveAcquistoPinRequest.getFirma(), reserveAcquistoPinRequest.getToken(),
                    CostantiWsPaymat.SERVIZIO_PIN_DISPATCHING + "", CostantiWsPaymat.RESERVE_ACQUISTO_PIN + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), reserveAcquistoPinRequest);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    // PRIMA VOLTA CHE GESTISCO QUESTA RICHIESTA
                    LOG.info("Prima richiesta per callerId=" + reserveAcquistoPinRequest.getCallerId() + " e requestId=" + reserveAcquistoPinRequest.getRequestId());
                    it.grupposnai.paymatcore.api.request.acquisto.snai.ReserveAcquistoPinRequest request = PinAdapter.getReserveAcquistoPinRequest(reserveAcquistoPinRequest);
                    it.grupposnai.paymatcore.api.response.acquisto.snai.ReserveAcquistoPinResponse response;
                    if (isBrandPinWithOldConnector(reserveAcquistoPinRequest.getIdBrand())) {
                        response = getPaymatCoreApi().reserveAcquistoPinOldConnectors(request); //non aggiornato per integrazione psmart/betting (ramo secco)
                    } else {
                        response = getPaymatCoreApi().reserveAcquistoPin(request);
                    }
                    ReserveAcquistoPinResponse reserveAcquistoPinResponse = PinAdapter.getReserveAcquistoPinResponse(response);
                    reserveAcquistoPinResponse.setCallerId(reserveAcquistoPinRequest.getCallerId());
                    reserveAcquistoPinResponse.setRequestId(reserveAcquistoPinRequest.getRequestId());
                    if (!Configurazione.INSTANCE.getBoolean(CostantiWsPaymat.SHOW_PIN_ON_RESERVEACQUISTOPIN, true))
                        reserveAcquistoPinResponse.setPin(""); //pin non piu' restituito in fase di reserve
                    LOG.info("Response: " + reserveAcquistoPinResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(reserveAcquistoPinRequest.getCallerId(), reserveAcquistoPinRequest.getRequestId(), reserveAcquistoPinResponse, response.getImportoTransazione(), response.getCommissioniTransazione());
                    return reserveAcquistoPinResponse;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + reserveAcquistoPinRequest.getCallerId() + " e requestId=" + reserveAcquistoPinRequest.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    ReserveAcquistoPinResponse reserveAcquistoPinResponse = XmlSerializer.unserialize(prevResp, ReserveAcquistoPinResponse.class);
                    if (!Configurazione.INSTANCE.getBoolean(CostantiWsPaymat.SHOW_PIN_ON_RESERVEACQUISTOPIN, true))
                        reserveAcquistoPinResponse.setPin(""); //pin non piu' restituito in fase di reserve
                    LOG.info("Response: " + reserveAcquistoPinResponse);
                    return reserveAcquistoPinResponse;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                ReserveAcquistoPinResponse reserveAcquistoPinResponse = new ReserveAcquistoPinResponse();
                reserveAcquistoPinResponse.setCallerId(reserveAcquistoPinRequest.getCallerId());
                reserveAcquistoPinResponse.setRequestId(reserveAcquistoPinRequest.getRequestId());
                reserveAcquistoPinResponse.setResultCode((int) esito);
                reserveAcquistoPinResponse.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + reserveAcquistoPinResponse);
                return reserveAcquistoPinResponse;
            }

        } catch (java.lang.Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            ReserveAcquistoPinResponse reserveAcquistoPinResponse = new ReserveAcquistoPinResponse();
            reserveAcquistoPinResponse.setCallerId(reserveAcquistoPinRequest.getCallerId());
            reserveAcquistoPinResponse.setRequestId(reserveAcquistoPinRequest.getRequestId());
            reserveAcquistoPinResponse.setResultCode(-101);
            reserveAcquistoPinResponse.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + reserveAcquistoPinResponse);
            return reserveAcquistoPinResponse;
        }
    }

    public ConfirmAcquistoPinResponse confirmAcquistoPin(ConfirmAcquistoPinRequest confirmAcquistoPinRequest) {
        LOG.info("Request: " + confirmAcquistoPinRequest);
        try {
            if (confirmAcquistoPinRequest.validate() != null) {
                LOG.info("Request: " + confirmAcquistoPinRequest);
                ConfirmAcquistoPinResponse response = new ConfirmAcquistoPinResponse();
                response.setCallerId(confirmAcquistoPinRequest.getCallerId());
                response.setRequestId(confirmAcquistoPinRequest.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + confirmAcquistoPinRequest.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(confirmAcquistoPinRequest.getRequestId(), confirmAcquistoPinRequest.getCallerId(), confirmAcquistoPinRequest.getSkin(), confirmAcquistoPinRequest.getUserIP(), confirmAcquistoPinRequest.getFirma(), confirmAcquistoPinRequest.getToken(),
                    CostantiWsPaymat.SERVIZIO_PIN_DISPATCHING + "", CostantiWsPaymat.CONFIRM_ACQUISTO_PIN + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), confirmAcquistoPinRequest);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + confirmAcquistoPinRequest.getCallerId() + " e requestId=" + confirmAcquistoPinRequest.getRequestId());
                    it.grupposnai.paymatcore.api.request.acquisto.snai.ConfirmAcquistoPinRequest request = PinAdapter.getConfirmAcquistoPinRequest(confirmAcquistoPinRequest);
                    it.grupposnai.paymatcore.api.response.acquisto.snai.ConfirmAcquistoPinResponse response;
                    if (isBrandPinWithOldConnector(confirmAcquistoPinRequest.getIdBrand())) {
                        response = getPaymatCoreApi().confirmAcquistoPinOldConnectors(request);
                    } else {
                        response = getPaymatCoreApi().confirmAcquistoPin(request);
                    }
                    ConfirmAcquistoPinResponse confirmAcquistoPinResponse = PinAdapter.getConfirmAcquistoPinResponse(response);
                    confirmAcquistoPinResponse.setCallerId(confirmAcquistoPinRequest.getCallerId());
                    confirmAcquistoPinResponse.setRequestId(confirmAcquistoPinRequest.getRequestId());
                    LOG.info("Response: " + confirmAcquistoPinResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(confirmAcquistoPinRequest.getCallerId(), confirmAcquistoPinRequest.getRequestId(), confirmAcquistoPinResponse);
                    return confirmAcquistoPinResponse;

                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + confirmAcquistoPinRequest.getCallerId() + " e requestId=" + confirmAcquistoPinRequest.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    ConfirmAcquistoPinResponse confirmAcquistoPinResponse = XmlSerializer.unserialize(prevResp, ConfirmAcquistoPinResponse.class);
                    LOG.info("Response: " + confirmAcquistoPinResponse);
                    return confirmAcquistoPinResponse;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                ConfirmAcquistoPinResponse confirmAcquistoPinResponse = new ConfirmAcquistoPinResponse();
                confirmAcquistoPinResponse.setCallerId(confirmAcquistoPinRequest.getCallerId());
                confirmAcquistoPinResponse.setRequestId(confirmAcquistoPinRequest.getRequestId());
                confirmAcquistoPinResponse.setResultCode((int) esito);
                confirmAcquistoPinResponse.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + confirmAcquistoPinResponse);
                return confirmAcquistoPinResponse;
            }

        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            ConfirmAcquistoPinResponse confirmAcquistoPinResponse = new ConfirmAcquistoPinResponse();
            confirmAcquistoPinResponse.setCallerId(confirmAcquistoPinRequest.getCallerId());
            confirmAcquistoPinResponse.setRequestId(confirmAcquistoPinRequest.getRequestId());
            confirmAcquistoPinResponse.setResultCode(-101);
            confirmAcquistoPinResponse.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + confirmAcquistoPinResponse);
            return confirmAcquistoPinResponse;
        }
    }

    public CancelAcquistoPinResponse cancelAcquistoPin(CancelAcquistoPinRequest cancelAcquistoPinRequest) {
        LOG.info("cancelAcquistoPinRequest - request: " + cancelAcquistoPinRequest);
        try {
            if (cancelAcquistoPinRequest.validate() != null) {
                LOG.info("Request: " + cancelAcquistoPinRequest);
                CancelAcquistoPinResponse response = new CancelAcquistoPinResponse();
                response.setCallerId(cancelAcquistoPinRequest.getCallerId());
                response.setRequestId(cancelAcquistoPinRequest.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + cancelAcquistoPinRequest.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(cancelAcquistoPinRequest.getRequestId(), cancelAcquistoPinRequest.getCallerId(), cancelAcquistoPinRequest.getSkin(), cancelAcquistoPinRequest.getUserIP(), cancelAcquistoPinRequest.getFirma(), cancelAcquistoPinRequest.getToken(),
                    CostantiWsPaymat.SERVIZIO_PIN_DISPATCHING + "", CostantiWsPaymat.CANCEL_ACQUISTO_PIN + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), cancelAcquistoPinRequest);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + cancelAcquistoPinRequest.getCallerId() + " e requestId=" + cancelAcquistoPinRequest.getRequestId());
                    it.grupposnai.paymatcore.api.request.acquisto.snai.CancelAcquistoPinRequest request = PinAdapter.getCancelAcquistoPinRequest(cancelAcquistoPinRequest);
                    it.grupposnai.paymatcore.api.response.acquisto.snai.CancelAcquistoPinResponse response;
                    if (isBrandPinWithOldConnector(cancelAcquistoPinRequest.getIdBrand())) {
                        response = getPaymatCoreApi().cancelAcquistoPinOldConnectors(request);
                    } else {
                        response = getPaymatCoreApi().cancelAcquistoPin(request);
                    }
                    CancelAcquistoPinResponse cancelAcquistoPinResponse = PinAdapter.getCancelAcquistoPinResponse(response);
                    cancelAcquistoPinResponse.setCallerId(cancelAcquistoPinRequest.getCallerId());
                    cancelAcquistoPinResponse.setRequestId(cancelAcquistoPinRequest.getRequestId());
                    LOG.info("Response: " + cancelAcquistoPinResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(cancelAcquistoPinRequest.getCallerId(), cancelAcquistoPinRequest.getRequestId(), cancelAcquistoPinResponse);
                    return cancelAcquistoPinResponse;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + cancelAcquistoPinRequest.getCallerId() + " e requestId=" + cancelAcquistoPinRequest.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    CancelAcquistoPinResponse cancelAcquistoPinResponse = XmlSerializer.unserialize(prevResp, CancelAcquistoPinResponse.class);
                    LOG.info("Response: " + cancelAcquistoPinResponse);
                    return cancelAcquistoPinResponse;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                CancelAcquistoPinResponse cancelAcquistoPinResponse = new CancelAcquistoPinResponse();
                cancelAcquistoPinResponse.setCallerId(cancelAcquistoPinRequest.getCallerId());
                cancelAcquistoPinResponse.setRequestId(cancelAcquistoPinRequest.getRequestId());
                cancelAcquistoPinResponse.setResultCode((int) esito);
                cancelAcquistoPinResponse.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + cancelAcquistoPinResponse);
                return cancelAcquistoPinResponse;
            }

        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            CancelAcquistoPinResponse cancelAcquistoPinResponse = new CancelAcquistoPinResponse();
            cancelAcquistoPinResponse.setCallerId(cancelAcquistoPinRequest.getCallerId());
            cancelAcquistoPinResponse.setRequestId(cancelAcquistoPinRequest.getRequestId());
            cancelAcquistoPinResponse.setResultCode(-101);
            cancelAcquistoPinResponse.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + cancelAcquistoPinResponse);
            return cancelAcquistoPinResponse;
        }
    }

    public ReserveUsePinResponse reserveUsePin(ReserveUsePinRequest reserveUsePinRequest) {
        LOG.info("Request: " + reserveUsePinRequest);
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(reserveUsePinRequest.getRequestId(), reserveUsePinRequest.getCallerId(), reserveUsePinRequest.getSkin(), reserveUsePinRequest.getUserIp(), reserveUsePinRequest.getFirma(), reserveUsePinRequest.getToken(),
                    CostantiWsPaymat.SERVIZIO_PIN_DISPATCHING + "", CostantiWsPaymat.RESERVE_UTILIZZO_PIN + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), reserveUsePinRequest);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + reserveUsePinRequest.getCallerId() + " e requestId=" + reserveUsePinRequest.getRequestId());
                    it.grupposnai.paymatcore.api.request.utilizzo.ReserveUsePinRequest request = PinAdapter.getReserveUsePinRequest(reserveUsePinRequest);
                    it.grupposnai.paymatcore.api.response.utilizzo.ReserveUsePinResponse response = paymatCoreApi.reserveUsePin(request);
                    ReserveUsePinResponse reserveUsePinResponse = PinAdapter.getReserveUsePinResponse(response);
                    reserveUsePinResponse.setCallerId(reserveUsePinRequest.getCallerId());
                    reserveUsePinResponse.setRequestId(reserveUsePinRequest.getRequestId());
                    LOG.info("Response: " + reserveUsePinResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(reserveUsePinRequest.getCallerId(), reserveUsePinRequest.getRequestId(), reserveUsePinResponse);
                    return reserveUsePinResponse;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + reserveUsePinRequest.getCallerId() + " e requestId=" + reserveUsePinRequest.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    ReserveUsePinResponse reserveUsePinResponse = XmlSerializer.unserialize(prevResp, ReserveUsePinResponse.class);
                    LOG.info("Response: " + reserveUsePinResponse);
                    return reserveUsePinResponse;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                ReserveUsePinResponse reserveUsePinResponse = new ReserveUsePinResponse();
                reserveUsePinResponse.setCallerId(reserveUsePinRequest.getCallerId());
                reserveUsePinResponse.setRequestId(reserveUsePinRequest.getRequestId());
                reserveUsePinResponse.setResultCode((int) esito);
                reserveUsePinResponse.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + reserveUsePinResponse);
                return reserveUsePinResponse;
            }

        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            ReserveUsePinResponse reserveUsePinResponse = new ReserveUsePinResponse();
            reserveUsePinResponse.setCallerId(reserveUsePinRequest.getCallerId());
            reserveUsePinResponse.setRequestId(reserveUsePinRequest.getRequestId());
            reserveUsePinResponse.setResultCode(-101);
            reserveUsePinResponse.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + reserveUsePinResponse);
            return reserveUsePinResponse;
        }
    }

    public ConfirmUsePinResponse confirmUsePin(ConfirmUsePinRequest confirmUsePinRequest) {
        LOG.info("Request: " + confirmUsePinRequest);
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(confirmUsePinRequest.getRequestId(), confirmUsePinRequest.getCallerId(), confirmUsePinRequest.getSkin(), confirmUsePinRequest.getUserIp(), confirmUsePinRequest.getFirma(), confirmUsePinRequest.getToken(),
                    CostantiWsPaymat.SERVIZIO_PIN_DISPATCHING + "", CostantiWsPaymat.CONFIRM_UTILIZZO_PIN + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), confirmUsePinRequest);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + confirmUsePinRequest.getCallerId() + " e requestId=" + confirmUsePinRequest.getRequestId());
                    it.grupposnai.paymatcore.api.request.utilizzo.ConfirmUsePinRequest request = PinAdapter.getConfirmUsePinRequest(confirmUsePinRequest);
                    it.grupposnai.paymatcore.api.response.utilizzo.ConfirmUsePinResponse response = getPaymatCoreApi().confirmUsePin(request);
                    ConfirmUsePinResponse confirmUsePinResponse = PinAdapter.getConfirmUsePinResponse(response);
                    confirmUsePinResponse.setCallerId(confirmUsePinRequest.getCallerId());
                    confirmUsePinResponse.setRequestId(confirmUsePinRequest.getRequestId());
                    LOG.info("Response: " + confirmUsePinResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(confirmUsePinRequest.getCallerId(), confirmUsePinRequest.getRequestId(), confirmUsePinResponse);
                    return confirmUsePinResponse;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + confirmUsePinRequest.getCallerId() + " e requestId=" + confirmUsePinRequest.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    ConfirmUsePinResponse confirmUsePinResponse = XmlSerializer.unserialize(prevResp, ConfirmUsePinResponse.class);
                    LOG.info("Response: " + confirmUsePinResponse);
                    return confirmUsePinResponse;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                ConfirmUsePinResponse confirmUsePinResponse = new ConfirmUsePinResponse();
                confirmUsePinResponse.setCallerId(confirmUsePinRequest.getCallerId());
                confirmUsePinResponse.setRequestId(confirmUsePinRequest.getRequestId());
                confirmUsePinResponse.setResultCode((int) esito);
                confirmUsePinResponse.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + confirmUsePinResponse);
                return confirmUsePinResponse;
            }

        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            ConfirmUsePinResponse confirmUsePinResponse = new ConfirmUsePinResponse();
            confirmUsePinResponse.setCallerId(confirmUsePinRequest.getCallerId());
            confirmUsePinResponse.setRequestId(confirmUsePinRequest.getRequestId());
            confirmUsePinResponse.setResultCode(-101);
            confirmUsePinResponse.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + confirmUsePinResponse);
            return confirmUsePinResponse;
        }
    }

    public CancelUsePinResponse cancelUsePin(CancelUsePinRequest cancelUsePinRequest) {
        LOG.info("Request: " + cancelUsePinRequest);
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(cancelUsePinRequest.getRequestId(), cancelUsePinRequest.getCallerId(), cancelUsePinRequest.getSkin(), cancelUsePinRequest.getUserIp(), cancelUsePinRequest.getFirma(), cancelUsePinRequest.getToken(),
                    CostantiWsPaymat.SERVIZIO_PIN_DISPATCHING + "", CostantiWsPaymat.CANCEL_UTILIZZO_PIN + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), cancelUsePinRequest);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + cancelUsePinRequest.getCallerId() + " e requestId=" + cancelUsePinRequest.getRequestId());
                    it.grupposnai.paymatcore.api.request.utilizzo.CancelUsePinRequest request = PinAdapter.getCancelUsePinRequest(cancelUsePinRequest);
                    it.grupposnai.paymatcore.api.response.utilizzo.CancelUsePinResponse response = getPaymatCoreApi().cancelUsePin(request);
                    CancelUsePinResponse cancelUsePinResponse = PinAdapter.getCancelUsePinResponse(response);
                    cancelUsePinResponse.setCallerId(cancelUsePinRequest.getCallerId());
                    cancelUsePinResponse.setRequestId(cancelUsePinRequest.getRequestId());
                    LOG.info("Response: " + cancelUsePinResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(cancelUsePinRequest.getCallerId(), cancelUsePinRequest.getRequestId(), cancelUsePinResponse);
                    return cancelUsePinResponse;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + cancelUsePinRequest.getCallerId() + " e requestId=" + cancelUsePinRequest.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    CancelUsePinResponse cancelUsePinResponse = XmlSerializer.unserialize(prevResp, CancelUsePinResponse.class);
                    LOG.info("Response: " + cancelUsePinResponse);
                    return cancelUsePinResponse;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                CancelUsePinResponse cancelUsePinResponse = new CancelUsePinResponse();
                cancelUsePinResponse.setCallerId(cancelUsePinRequest.getCallerId());
                cancelUsePinResponse.setRequestId(cancelUsePinRequest.getRequestId());
                cancelUsePinResponse.setResultCode((int) esito);
                cancelUsePinResponse.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + cancelUsePinResponse);
                return cancelUsePinResponse;

            }

        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            CancelUsePinResponse cancelUsePinResponse = new CancelUsePinResponse();
            cancelUsePinResponse.setCallerId(cancelUsePinRequest.getCallerId());
            cancelUsePinResponse.setRequestId(cancelUsePinRequest.getRequestId());
            cancelUsePinResponse.setResultCode(-101);
            cancelUsePinResponse.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + cancelUsePinResponse);
            return cancelUsePinResponse;
        }
    }

    public StornoAcquistoPinResponse stornoAcquistoPin(StornoAcquistoPinRequest stornoAcquistoPinRequest) {
        LOG.info("Request: " + stornoAcquistoPinRequest);
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(stornoAcquistoPinRequest.getRequestId(), stornoAcquistoPinRequest.getCallerId(), stornoAcquistoPinRequest.getSkin(), stornoAcquistoPinRequest.getUserIp(), stornoAcquistoPinRequest.getFirma(), stornoAcquistoPinRequest.getToken(),
                    CostantiWsPaymat.SERVIZIO_PIN_DISPATCHING + "", CostantiWsPaymat.STORNO_ACQUISTO_PIN + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), stornoAcquistoPinRequest);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + stornoAcquistoPinRequest.getCallerId() + " e requestId=" + stornoAcquistoPinRequest.getRequestId());
                    it.grupposnai.paymatcore.api.request.storno.StornoAcquistoPinRequest request = PinAdapter.getStornoAcquistoPinRequest(stornoAcquistoPinRequest);
                    it.grupposnai.paymatcore.api.response.storno.StornoAcquistoPinResponse response = getPaymatCoreApi().stornoAcquistoPin(request);
                    StornoAcquistoPinResponse stornoAcquistoPinResponse = PinAdapter.getStornoAcquistoPinResponse(response);
                    stornoAcquistoPinResponse.setCallerId(stornoAcquistoPinRequest.getCallerId());
                    stornoAcquistoPinResponse.setRequestId(stornoAcquistoPinRequest.getRequestId());
                    LOG.info("Response: " + stornoAcquistoPinResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(stornoAcquistoPinRequest.getCallerId(), stornoAcquistoPinRequest.getRequestId(), stornoAcquistoPinResponse);
                    return stornoAcquistoPinResponse;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + stornoAcquistoPinRequest.getCallerId() + " e requestId=" + stornoAcquistoPinRequest.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    StornoAcquistoPinResponse stornoAcquistoPinResponse = XmlSerializer.unserialize(prevResp, StornoAcquistoPinResponse.class);
                    LOG.info("Response: " + stornoAcquistoPinResponse);
                    return stornoAcquistoPinResponse;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                StornoAcquistoPinResponse stornoAcquistoPinResponse = new StornoAcquistoPinResponse();
                stornoAcquistoPinResponse.setCallerId(stornoAcquistoPinRequest.getCallerId());
                stornoAcquistoPinResponse.setRequestId(stornoAcquistoPinRequest.getRequestId());
                stornoAcquistoPinResponse.setResultCode((int) esito);
                stornoAcquistoPinResponse.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + stornoAcquistoPinResponse);
                return stornoAcquistoPinResponse;
            }

        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            StornoAcquistoPinResponse stornoAcquistoPinResponse = new StornoAcquistoPinResponse();
            stornoAcquistoPinResponse.setCallerId(stornoAcquistoPinRequest.getCallerId());
            stornoAcquistoPinResponse.setRequestId(stornoAcquistoPinRequest.getRequestId());
            stornoAcquistoPinResponse.setResultCode(-101);
            stornoAcquistoPinResponse.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + stornoAcquistoPinResponse);
            return stornoAcquistoPinResponse;
        }
    }

    /* MAV/RAV */

    public ReserveMavRavResponse reserveMavRav(ReserveMavRavRequest request) {
        LOG.info("Request: " + request);
        ReserveMavRavResponse response;
        try {
            if (request.validate() != null) {
                response = new ReserveMavRavResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_MAV_RAV + "", CostantiWsPaymat.RESERVE_MAV_RAV + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.ReserveMavRavRequest coreRequest = MavRavAdapter.getReserveMavRavRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.mavRav.ReserveMavRavResponse coreResponse = getPaymatCoreApi().reserveMavRav(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = MavRavAdapter.getReserveMavRavResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReserveMavRavResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReserveMavRavResponse();
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
            response = new ReserveMavRavResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public ConfirmMavRavResponse confirmMavRav(ConfirmMavRavRequest request) {
        LOG.info("Request: " + request);
        ConfirmMavRavResponse response;
        try {
            if (request.validate() != null) {
                response = new ConfirmMavRavResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_MAV_RAV + "", CostantiWsPaymat.CONFIRM_MAV_RAV + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.ConfirmMavRavRequest coreRequest = MavRavAdapter.getConfirmMavRavRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.mavRav.ConfirmMavRavResponse coreResponse = getPaymatCoreApi().confirmMavRav(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = MavRavAdapter.getConfirmMavRavResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmMavRavResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmMavRavResponse();
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
            response = new ConfirmMavRavResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public CancelMavRavResponse cancelMavRav(CancelMavRavRequest request) {
        LOG.info("Request: " + request);
        CancelMavRavResponse response;
        try {
            if (request.validate() != null) {
                response = new CancelMavRavResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_MAV_RAV + "", CostantiWsPaymat.CANCEL_MAV_RAV + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.mavRav.CancelMavRavRequest coreRequest = MavRavAdapter.getCancelMavRavRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.mavRav.CancelMavRavResponse coreResponse = getPaymatCoreApi().cancelMavRav(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = MavRavAdapter.getCancelMavRavResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelMavRavResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelMavRavResponse();
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
            response = new CancelMavRavResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    /* CBILL */

    public ReserveCbillResponse reserveCbill(ReserveCbillRequest request) {
        LOG.info("Request: " + request);
        ReserveCbillResponse response;
        try {
            if (request.validate() != null) {
                response = new ReserveCbillResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_CBILL + "", CostantiWsPaymat.RESERVE_CBILL + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.ReserveCbillRequest coreRequest = CbillAdapter.getReserveCbillRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.cbill.ReserveCbillResponse coreResponse = getPaymatCoreApi().reserveCbill(coreRequest);
                    response = CbillAdapter.getReserveCbillResponse(coreResponse);
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReserveCbillResponse.class);
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReserveCbillResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode((int) esito);
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new ReserveCbillResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        LOG.info("Response: " + response);
        return response;
    }

    public ConfirmCbillResponse confirmCbill(ConfirmCbillRequest request) {
        LOG.info("Request: " + request);
        ConfirmCbillResponse response;
        try {
            if (request.validate() != null) {
                response = new ConfirmCbillResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_CBILL + "", CostantiWsPaymat.CONFIRM_CBILL + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.ConfirmCbillRequest coreRequest = CbillAdapter.getConfirmCbillRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.cbill.ConfirmCbillResponse coreResponse = getPaymatCoreApi().confirmCbill(coreRequest);
                    response = CbillAdapter.getConfirmCbillResponse(coreResponse);
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmCbillResponse.class);
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmCbillResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode((int) esito);
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new ConfirmCbillResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        LOG.info("Response: " + response);
        return response;
    }

    public CancelCbillResponse cancelCbill(CancelCbillRequest request) {
        LOG.info("Request: " + request);
        CancelCbillResponse response;
        try {
            if (request.validate() != null) {
                response = new CancelCbillResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_CBILL + "", CostantiWsPaymat.CANCEL_CBILL + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.cbill.CancelCbillRequest coreRequest = CbillAdapter.getCancelCbillRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.cbill.CancelCbillResponse coreResponse = getPaymatCoreApi().cancelCbill(coreRequest);
                    response = CbillAdapter.getCancelCbillResponse(coreResponse);
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelCbillResponse.class);
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelCbillResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode((int) esito);
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new CancelCbillResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        LOG.info("Response: " + response);
        return response;
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

    public ReservePostePayResponse reservePostePay(ReservePostePayRequest request) {
        LOG.info("Request: " + request);
        ReservePostePayResponse response;
        try {
            if (request.validate() != null) {
                response = new ReservePostePayResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_POSTEPAY + "", CostantiWsPaymat.RESERVE_POSTEPAY + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.ReservePostePayRequest coreRequest = PostePayAdapter.getReservePostePayRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.postepay.ReservePostePayResponse coreResponse = getPaymatCoreApi().reservePostePay(coreRequest);
                    response = PostePayAdapter.getReservePostePayResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReservePostePayResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReservePostePayResponse();
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
            response = new ReservePostePayResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public ConfirmPostePayResponse confirmPostePay(ConfirmPostePayRequest request) {
        LOG.info("Request: " + request);
        ConfirmPostePayResponse response;
        try {
            if (request.validate() != null) {
                response = new ConfirmPostePayResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_POSTEPAY + "", CostantiWsPaymat.CONFIRM_POSTEPAY + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.ConfirmPostePayRequest coreRequest = PostePayAdapter.getConfirmPostePayRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.postepay.ConfirmPostePayResponse coreResponse = getPaymatCoreApi().confirmPostePay(coreRequest);
                    response = PostePayAdapter.getConfirmPostePayResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmPostePayResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmPostePayResponse();
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
            response = new ConfirmPostePayResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public CancelPostePayResponse cancelPostePay(CancelPostePayRequest request) {
        LOG.info("Request: " + request);
        CancelPostePayResponse response;
        try {
            if (request.validate() != null) {
                response = new CancelPostePayResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_POSTEPAY + "", CostantiWsPaymat.CANCEL_POSTEPAY + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.postepay.CancelPostePayRequest coreRequest = PostePayAdapter.getCancelPostePayRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.postepay.CancelPostePayResponse coreResponse = getPaymatCoreApi().cancelPostePay(coreRequest);
                    response = PostePayAdapter.getCancelPostePayResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelPostePayResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelPostePayResponse();
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
            response = new CancelPostePayResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    /* Bollettini */
    public ReserveBollettinoResponse reserveBollettino(ReserveBollettinoRequest request) {
        LOG.info("Request: " + request);
        ReserveBollettinoResponse response = null;
        try {
            if (request.validate() != null) {
                response = new ReserveBollettinoResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_BOLLETTINI_POSTALI + "", CostantiWsPaymat.RESERVE_BOLLETTINO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.ReserveBillBlankRequest coreRequest = BollettinoAdapter.getReserveBollettinoRequest(request);
                    // TODO SERVE PER CHIAMATA RETRO COMPATIBILE AL POSTO DI QUELLA ALLA RIGA 1924 per la prenotazione silente: it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettini.ReserveBillBlankResponse coreResponse = getPaymatCoreApi().reserveBollettino(coreRequest,getSepafinConnectorEndpoint(),getSepafinCallbackUrl(),getSepafinAuthUser(),getSepafinAuthPwd());
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettini.ReserveBillBlankResponse coreResponse = getPaymatCoreApi().reserveBollettino(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd(), getPrenotazioneServiceEndpoint());
                    response = BollettinoAdapter.getReserveBollettinoResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReserveBollettinoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReserveBollettinoResponse();
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
            response = new ReserveBollettinoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public ConfirmBollettinoResponse confirmBollettino(ConfirmBollettinoRequest request) {
        LOG.info("Request: " + request);
        ConfirmBollettinoResponse response;
        try {
            if (request.validate() != null) {
                response = new ConfirmBollettinoResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_BOLLETTINI_POSTALI + "", CostantiWsPaymat.CONFIRM_BOLLETTINO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.ConfirmBillBlankRequest coreRequest = BollettinoAdapter.getConfirmBollettinoRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettini.ConfirmBillBlankResponse coreResponse = getPaymatCoreApi().confirmBollettino(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = BollettinoAdapter.getConfirmBollettinoResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmBollettinoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmBollettinoResponse();
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
            response = new ConfirmBollettinoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public CancelBollettinoResponse cancelBollettino(CancelBollettinoRequest request) {
        LOG.info("Request: " + request);
        CancelBollettinoResponse response;
        try {
            if (request.validate() != null) {
                response = new CancelBollettinoResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_POSTEPAY + "", CostantiWsPaymat.CANCEL_POSTEPAY + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.CancelBillBlankRequest coreRequest = BollettinoAdapter.getCancelBollettinoRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollettini.CancelBillBlankResponse coreResponse = getPaymatCoreApi().cancelBollettino(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = BollettinoAdapter.getCancelBollettinoResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelBollettinoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelBollettinoResponse();
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
            response = new CancelBollettinoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

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

    public ReservePagoPaResponse reservePagoPa(ReservePagoPaRequest request) {
        LOG.info("Request: " + request);
        ReservePagoPaResponse response;
        try {
            if (request.validate() != null) {
                response = new ReservePagoPaResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_PAGOPA + "", CostantiWsPaymat.RESERVE_PAGOPA + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.ReservePagoPaRequest coreRequest = PagoPaAdapter.getReservePagoPaRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.pagopa.ReservePagoPaResponse coreResponse = getPaymatCoreApi().reservePagoPa(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = PagoPaAdapter.getReservePagoPaResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReservePagoPaResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReservePagoPaResponse();
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
            response = new ReservePagoPaResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    /* PagoPa */

    public ConfirmPagoPaResponse confirmPagoPa(ConfirmPagoPaRequest request) {
        LOG.info("Request: " + request);
        ConfirmPagoPaResponse response;
        try {
            if (request.validate() != null) {
                response = new ConfirmPagoPaResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_PAGOPA + "", CostantiWsPaymat.CONFIRM_PAGOPA + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.ConfirmPagoPaRequest coreRequest = PagoPaAdapter.getConfirmPagoPaRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.pagopa.ConfirmPagoPaResponse coreResponse = getPaymatCoreApi().confirmPagoPa(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = PagoPaAdapter.getConfirmPagoPaResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmPagoPaResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmPagoPaResponse();
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
            response = new ConfirmPagoPaResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public CancelPagoPaResponse cancelPagoPa(CancelPagoPaRequest request) {
        LOG.info("Request: " + request);
        CancelPagoPaResponse response;
        try {
            if (request.validate() != null) {
                response = new CancelPagoPaResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_PAGOPA + "", CostantiWsPaymat.CANCEL_PAGOPA + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.pagopa.CancelPagoPaRequest coreRequest = PagoPaAdapter.getCancelPagoPaRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.pagopa.CancelPagoPaResponse coreResponse = getPaymatCoreApi().cancelPagoPa(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = PagoPaAdapter.getCancelPagoPaResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelPagoPaResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelPagoPaResponse();
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
            response = new CancelPagoPaResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    /* BolloAuto */

    public ReserveBolloAutoResponse reserveBolloAuto(ReserveBolloAutoRequest request) {
        LOG.info("Request: " + request);
        ReserveBolloAutoResponse response;
        try {
            if (request.validate() != null) {
                response = new ReserveBolloAutoResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_BOLLO_AUTO + "", CostantiWsPaymat.RESERVE_BOLLO_AUTO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.ReserveBolloRequest coreRequest = BolloAutoAdapter.getReserveBolloAutoRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollo.ReserveBolloResponse coreResponse = getPaymatCoreApi().reserveBollo(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = BolloAutoAdapter.getReserveBolloAutoResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReserveBolloAutoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReserveBolloAutoResponse();
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
            response = new ReserveBolloAutoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public ConfirmBolloAutoResponse confirmBolloAuto(ConfirmBolloAutoRequest request) {
        LOG.info("Request: " + request);
        ConfirmBolloAutoResponse response;
        try {
            if (request.validate() != null) {
                response = new ConfirmBolloAutoResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_BOLLO_AUTO + "", CostantiWsPaymat.CONFIRM_BOLLO_AUTO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.ConfirmBolloRequest coreRequest = BolloAutoAdapter.getConfirmBolloAutoRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollo.ConfirmBolloResponse coreResponse = getPaymatCoreApi().confirmBollo(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = BolloAutoAdapter.getConfirmBolloAutoResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmBolloAutoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmBolloAutoResponse();
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
            response = new ConfirmBolloAutoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public CancelBolloAutoResponse cancelBolloAuto(CancelBolloAutoRequest request) {
        LOG.info("Request: " + request);
        CancelBolloAutoResponse response;
        try {
            if (request.validate() != null) {
                response = new CancelBolloAutoResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode(1);
                response.setResultDesc(CostantiWsPaymat.VALIDATION_ERROR_DESC + ":" + request.validate());
                LOG.info("Response: " + response);
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_BOLLO_AUTO + "", CostantiWsPaymat.CANCEL_BOLLO_AUTO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollo.CancelBolloRequest coreRequest = BolloAutoAdapter.getCancelBolloAutoRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.bollo.CancelBolloResponse coreResponse = getPaymatCoreApi().cancelBollo(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = BolloAutoAdapter.getCancelBolloAutoResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelBolloAutoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelBolloAutoResponse();
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
            response = new CancelBolloAutoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    /* Payment Code */

    public ReservePaymentCodeResponse reservePaymentCode(ReservePaymentCodeRequest request) {
        LOG.info("Request: " + request);
        ReservePaymentCodeResponse response;
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_PAYMENT_CODE + "", CostantiWsPaymat.RESERVE_PAYMENT_CODE + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.ReservePaymentCodeRequest coreRequest = PaymentCodeAdapter.getReservePaymentCodeRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.paymentcode.ReservePaymentCodeResponse coreResponse = getPaymatCoreApi().reservePaymentCode(coreRequest);
                    response = PaymentCodeAdapter.getReservePaymentCodeResponse(coreResponse); // gestione credito e gtwservizi non allineata, prodotto mai rilasciato
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());

                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReservePaymentCodeResponse.class);
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReservePaymentCodeResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode((int) esito);
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new ReservePaymentCodeResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        LOG.info("Response: " + response);
        return response;
    }

    public ConfirmPaymentCodeResponse confirmPaymentCode(ConfirmPaymentCodeRequest request) {
        LOG.info("Request: " + request);
        ConfirmPaymentCodeResponse response;
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_PAYMENT_CODE + "", CostantiWsPaymat.CONFIRM_PAYMENT_CODE + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.ConfirmPaymentCodeRequest coreRequest = PaymentCodeAdapter.getConfirmPaymentCodeRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.paymentcode.ConfirmPaymentCodeResponse coreResponse = getPaymatCoreApi().confirmPaymentCode(coreRequest);
                    response = PaymentCodeAdapter.getConfirmPaymentCodeResponse(coreResponse);
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);

                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmPaymentCodeResponse.class);
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmPaymentCodeResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode((int) esito);
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new ConfirmPaymentCodeResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        LOG.info("Response: " + response);
        return response;
    }

    public CancelPaymentCodeResponse cancelPaymentCode(CancelPaymentCodeRequest request) {
        LOG.info("Request: " + request);
        CancelPaymentCodeResponse response;
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.SERVIZIO_PAYMENT_CODE + "", CostantiWsPaymat.CANCEL_PAYMENT_CODE + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.prodottiFinanziari.paymentcode.CancelPaymentCodeRequest coreRequest = PaymentCodeAdapter.getCancelPaymentCodeRequest(request);
                    it.grupposnai.paymatcore.api.response.prodottiFinanziari.paymentcode.CancelPaymentCodeResponse coreResponse = getPaymatCoreApi().cancelPaymentCode(coreRequest);
                    response = PaymentCodeAdapter.getCancelPaymentCodeResponse(coreResponse);
                    response.setCallerId(request.getCallerId());
                    response.setRequestId(request.getRequestId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);

                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelPaymentCodeResponse.class);
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelPaymentCodeResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestId(request.getRequestId());
                response.setResultCode((int) esito);
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new CancelPaymentCodeResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
        }
        LOG.info("Response: " + response);
        return response;
    }

    /* Sim */

    public ReserveAcquistoSimResponse reserveAcquistoSim(ReserveAcquistoSimRequest request) {
        LOG.info("Request: " + request);
        ReserveAcquistoSimResponse response;
        try {
            if (request.validate() != null) {
                response = new ReserveAcquistoSimResponse();
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
                    it.grupposnai.paymatcore.api.request.sim.ReserveAcquistoSimRequest coreRequest = SimAdapter.getReserveAcquistoSimRequest(request);
                    it.grupposnai.paymatcore.api.response.sim.ReserveAcquistoSimResponse coreResponse = getPaymatCoreApi().reserveAcquistoSim(coreRequest);
                    response = SimAdapter.getReserveAcquistoSimResponse(coreResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response, coreResponse.getImportoTransazione(), coreResponse.getCommissioniTransazione());
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReserveAcquistoSimResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReserveAcquistoSimResponse();
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
            response = new ReserveAcquistoSimResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public ConfirmAcquistoSimResponse confirmAcquistoSim(ConfirmAcquistoSimRequest request) {
        LOG.info("Request: " + request);
        ConfirmAcquistoSimResponse response;
        try {
            if (request.validate() != null) {
                response = new ConfirmAcquistoSimResponse();
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
                    it.grupposnai.paymatcore.api.request.sim.ConfirmAcquistoSimRequest coreRequest = SimAdapter.getConfirmAcquistoSimRequest(request);
                    it.grupposnai.paymatcore.api.response.sim.ConfirmAcquistoSimResponse coreResponse = getPaymatCoreApi().confirmAcquistoSim(coreRequest);
                    response = SimAdapter.getConfirmAcquistoSimResponse(coreResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmAcquistoSimResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmAcquistoSimResponse();
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
            response = new ConfirmAcquistoSimResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public CancelAcquistoSimResponse cancelAcquistoSim(CancelAcquistoSimRequest request) {
        LOG.info("Request: " + request);
        CancelAcquistoSimResponse response;
        try {
            if (request.validate() != null) {
                response = new CancelAcquistoSimResponse();
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
                    it.grupposnai.paymatcore.api.request.sim.CancelAcquistoSimRequest coreRequest = SimAdapter.getCancelAcquistoSimRequest(request);
                    it.grupposnai.paymatcore.api.response.sim.CancelAcquistoSimResponse coreResponse = getPaymatCoreApi().cancelAcquistoSim(coreRequest);
                    response = SimAdapter.getCancelAcquistoSimResponse(coreResponse);
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelAcquistoSimResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelAcquistoSimResponse();
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
            response = new CancelAcquistoSimResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

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

    public ReserveBollettinoFrecciaResponse reserveBollettinoFreccia(ReserveBollettinoFrecciaRequest request) {
        LOG.info("request:" + request);
        ReserveBollettinoFrecciaResponse response;
        try {
            if (request.validate() != null) {
                response = new ReserveBollettinoFrecciaResponse();
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
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    ReserveBillFrecciaRequest coreRequest = BollettinoFrecciaAdapter.getReserveBollettinoFrecciaRequest(request);
                    ReserveBillFrecciaResponse coreResponse = getPaymatCoreApi().reserveBollettinoFreccia(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = BollettinoFrecciaAdapter.getReserveBollettinoFrecciaResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId="
                            + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReserveBollettinoFrecciaResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReserveBollettinoFrecciaResponse();
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
            response = new ReserveBollettinoFrecciaResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public ConfirmBollettinoFrecciaResponse confirmBollettinoFreccia(ConfirmBollettinoFrecciaRequest request) {
        LOG.info("request:" + request);
        ConfirmBollettinoFrecciaResponse response;
        try {
            if (request.validate() != null) {
                response = new ConfirmBollettinoFrecciaResponse();
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
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    ConfirmBillFrecciaRequest coreRequest = BollettinoFrecciaAdapter.getConfirmBollettinoFrecciaRequest(request);
                    ConfirmBillFrecciaResponse coreResponse = getPaymatCoreApi().confirmBollettinoFreccia(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = BollettinoFrecciaAdapter.getConfirmBollettinoFrecciaResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId="
                            + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmBollettinoFrecciaResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmBollettinoFrecciaResponse();
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
            response = new ConfirmBollettinoFrecciaResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public CancelBollettinoFrecciaResponse cancelBollettinoFreccia(CancelBollettinoFrecciaRequest request) {
        LOG.info("request:" + request);
        CancelBollettinoFrecciaResponse response;
        try {
            if (request.validate() != null) {
                response = new CancelBollettinoFrecciaResponse();
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
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    CancelBillFrecciaRequest coreRequest = BollettinoFrecciaAdapter.getCancelBollettinoFrecciaRequest(request);
                    CancelBillFrecciaResponse coreResponse = getPaymatCoreApi().cancelBollettinoFreccia(coreRequest, getSepafinConnectorEndpoint(), getSepafinCallbackUrl(), getSepafinAuthUser(), getSepafinAuthPwd());
                    response = BollettinoFrecciaAdapter.getCancelBollettinoFrecciaResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId="
                            + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelBollettinoFrecciaResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelBollettinoFrecciaResponse();
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
            response = new CancelBollettinoFrecciaResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public ReserveRicaricaContoResponse reserveRicaricaConto(ReserveRicaricaContoRequest request) {

        LOG.info("request:" + request);
        ReserveRicaricaContoResponse response = null;

        try {

            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.DEFAULT_CODICE_MESSAGGIO + "", CostantiWsPaymat.DEFAULT_CODICE_MESSAGGIO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    ReserveRicaricaWalletRequest coreRequest = RicaricaContoAdapter.getReserveRicaricaContoRequest(request);
                    ReserveRicaricaWalletResponse coreResponse = getPaymatCoreApi().reserveRicaricaConto(coreRequest);
                    response = RicaricaContoAdapter.getReserveRicaricaContoResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId="
                            + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReserveRicaricaContoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReserveRicaricaContoResponse();
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
            response = new ReserveRicaricaContoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public ConfirmRicaricaContoResponse confirmRicaricaConto(ConfirmRicaricaContoRequest request) {


        LOG.info("request:" + request);
        ConfirmRicaricaContoResponse response;
        try {
            if (request.validate() != null) {
                response = new ConfirmRicaricaContoResponse();
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
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    ConfirmRicaricaWalletRequest coreRequest = RicaricaContoAdapter.getConfirmRicaricaContoRequest(request);
                    ConfirmRicaricaWalletResponse coreResponse = getPaymatCoreApi().confirmRicaricaConto(coreRequest);
                    response = RicaricaContoAdapter.getConfirmRicaricaContoResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId="
                            + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmRicaricaContoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmRicaricaContoResponse();
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
            response = new ConfirmRicaricaContoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

    public CancelRicaricaContoResponse cancelRicaricaConto(CancelRicaricaContoRequest request) {

        LOG.info("request:" + request);
        CancelRicaricaContoResponse response;
        try {
            if (request.validate() != null) {
                response = new CancelRicaricaContoResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestID(request.getRequestId());
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
                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    CancelRicaricaWalletRequest coreRequest = RicaricaContoAdapter.getCancelRicaricaContoRequest(request);
                    CancelRicaricaWalletResponse coreResponse = getPaymatCoreApi().cancelRicaricaConto(coreRequest);
                    response = RicaricaContoAdapter.getCancelRicaricaContoResponse(coreResponse);
                    response.setRequestID(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(response.getCallerId(), response.getRequestID(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId="
                            + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, CancelRicaricaContoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new CancelRicaricaContoResponse();
                response.setCallerId(request.getCallerId());
                response.setRequestID(request.getRequestId());
                response.setResultCode((int) esito);
                response.setResultDesc(rtLogRequest.get(CostantiWsPaymat.RESULT_DESC) + "");
                LOG.info("Response: " + response);
                return response;
            }
        } catch (Exception ex) {
            // ERRORE IMPREVISTO
            LOG.error("Errore imprevisto", ex);
            response = new CancelRicaricaContoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestID(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }

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

    @Override
    public ReserveRicaricaContoGiocoResponse reserveRicaricaContoGioco(ReserveRicaricaContoGiocoRequest request) {

        LOG.info("request:" + request);
        ReserveRicaricaContoGiocoResponse response = null;

        try {
            int count = request.validateOnlyOneField(request.getContoGioco(), request.getFiscalCode(), request.getMail());
            if(count > 1){
                response.setResultCode(-1);
                response.setResultDesc("Deve essere valorizzato solo uno tra contoGioco, mail o codiceFiscale");
                return response;
            }
            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), request.getToken(),
                    CostantiWsPaymat.DEFAULT_CODICE_MESSAGGIO + "", CostantiWsPaymat.DEFAULT_CODICE_MESSAGGIO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {

                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.ricaricaContoGioco.ReserveRicaricaContoGiocoRequest coreRequest = RicaricaContoGiocoAdapter.getReserveRicaricaContoGiocoRequest(request);

                    it.grupposnai.paymatcore.api.response.ricaricaContoGioco.ReserveRicaricaContoGiocoResponse coreResponse = getPaymatCoreApi().reserveRicaricaContoGioco(coreRequest);

                    response = RicaricaContoGiocoAdapter.getReserveRicaricaContoGiocoResponse(coreResponse);
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(request.getCallerId(), request.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId="
                            + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ReserveRicaricaContoGiocoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ReserveRicaricaContoGiocoResponse();
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
            response = new ReserveRicaricaContoGiocoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }

    }

    @Override
    public ConfirmRicaricaContoGiocoResponse confirmRicaricaContoGioco(ConfirmRicaricaContoGiocoRequest request) {
        LOG.info("request:" + request);
        ConfirmRicaricaContoGiocoResponse response = null;

        try {

            HttpServletRequest httpRequest = (HttpServletRequest) context.getMessageContext().get(MessageContext.SERVLET_REQUEST);
            Map<String, Object> rtLogRequest = AuditLogDelegate.insWebServiceRequestMsg(request.getRequestId(), request.getCallerId(), request.getSkin(), request.getUserIp(), request.getFirma(), null,
                    CostantiWsPaymat.DEFAULT_CODICE_MESSAGGIO + "", CostantiWsPaymat.DEFAULT_CODICE_MESSAGGIO + "", IpAddress.getTraceRoute(httpRequest), IpAddress.getClientIpAddr(httpRequest), request);
            short esito = (Short) rtLogRequest.get(CostantiDB.PARAM_ESITO);
            if (esito == CostantiDB.ESITO_OK) {

                if (rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE) == null) {
                    LOG.info("Prima richiesta per callerId=" + request.getCallerId() + " e requestId=" + request.getRequestId());
                    it.grupposnai.paymatcore.api.request.ricaricaContoGioco.ConfirmRicaricaContoGiocoRequest coreRequest = RicaricaContoGiocoAdapter.getConfirmRicaricaContoGiocoRequest(request);

                    it.grupposnai.paymatcore.api.response.ricaricaContoGioco.ConfirmRicaricaContoGiocoResponse coreResponse = getPaymatCoreApi().confirmRicaricaContoGioco(coreRequest);

                    response = RicaricaContoGiocoAdapter.getConfirmRicaricaContoGiocoResponse(coreResponse);
                    response.setRequestId(request.getRequestId());
                    response.setCallerId(request.getCallerId());
                    AuditLogDelegate.insWebServiceResponseMsg(request.getCallerId(), request.getRequestId(), response);
                    LOG.info("Response: " + response);
                    return response;
                } else {
                    // DISPONIBILE UNA RISPOSTA PER IL CHIAMANTE, VIENE RESTITUITA
                    LOG.info("Richiesta successiva alla prima per callerId=" + request.getCallerId() + " e requestId="
                            + request.getRequestId());
                    String prevResp = (String) rtLogRequest.get(CostantiWsPaymat.MSG_RESPONSE);
                    response = XmlSerializer.unserialize(prevResp, ConfirmRicaricaContoGiocoResponse.class);
                    LOG.info("Response: " + response);
                    return response;
                }
            } else {
                // ESITO NEGATIVO NEL LOG DELLA RICHIESTA
                LOG.info("Esito negativo nel log della richiesta: " + rtLogRequest.get(CostantiWsPaymat.RESULT_DESC));
                response = new ConfirmRicaricaContoGiocoResponse();
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
            response = new ConfirmRicaricaContoGiocoResponse();
            response.setCallerId(request.getCallerId());
            response.setRequestId(request.getRequestId());
            response.setResultCode(-101);
            response.setResultDesc("Errore imprevisto " + ex.getMessage());
            LOG.info("Response: " + response);
            return response;
        }
    }
}
