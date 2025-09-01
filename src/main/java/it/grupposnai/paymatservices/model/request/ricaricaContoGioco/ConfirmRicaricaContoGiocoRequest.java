package it.grupposnai.paymatservices.model.request.ricaricaContoGioco;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ConfirmRicaricaContoGiocoRequest")
public class ConfirmRicaricaContoGiocoRequest {
    private String callerId;
    private String requestId;
    private String reserveCode;
    private String contoGioco;

    private String fiscalCode;
    private String reserveRequestId;
    private String barCode;
    private String amount;
    private boolean ricWithAircash;
    private String skin;
    private String userIp;

    private String token;
    private String firma;
    private String cro;

    private String idAziendaEsercente;
    private String codiceBU;

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getReserveCode() {
        return reserveCode;
    }

    public void setReserveCode(String reserveCode) {
        this.reserveCode = reserveCode;
    }

    public String getReserveRequestId() {
        return reserveRequestId;
    }

    public void setReserveRequestId(String reserveRequestId) {
        this.reserveRequestId = reserveRequestId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public boolean isRicWithAircash() {
        return ricWithAircash;
    }

    public void setRicWithAircash(boolean ricWithAircash) {
        this.ricWithAircash = ricWithAircash;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getContoGioco() {
        return contoGioco;
    }

    public void setContoGioco(String contoGioco) {
        this.contoGioco = contoGioco;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getCodiceBU() {
        return codiceBU;
    }

    public void setCodiceBU(String codiceBU) {
        this.codiceBU = codiceBU;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdAziendaEsercente() {
        return idAziendaEsercente;
    }

    public void setIdAziendaEsercente(String idAziendaEsercente) {
        this.idAziendaEsercente = idAziendaEsercente;
    }

    @Override
    public String toString() {
        return "ConfirmRicaricaContoGiocoRequest{" +
                "callerId='" + callerId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", reserveCode='" + reserveCode + '\'' +
                ", contoGioco='" + contoGioco + '\'' +
                ", fiscalCode='" + fiscalCode + '\'' +
                ", reserveRequestId='" + reserveRequestId + '\'' +
                ", barCode='" + barCode + '\'' +
                ", amount='" + amount + '\'' +
                ", ricWithAircash=" + ricWithAircash +
                ", skin='" + skin + '\'' +
                ", userIp='" + userIp + '\'' +
                ", token='" + token + '\'' +
                ", firma='" + firma + '\'' +
                ", cro='" + cro + '\'' +
                ", codiceBu='" + codiceBU + '\'' +
                ", idAziendaEsercente='" + idAziendaEsercente + '\'' +
                '}';
    }
}
