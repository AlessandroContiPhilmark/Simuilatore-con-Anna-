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
        {
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
        {
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
        {
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





}
