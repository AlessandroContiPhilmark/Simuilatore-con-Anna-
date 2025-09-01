package it.grupposnai.paymatservices.model.request.ricaricaContoGioco;

import javax.xml.bind.annotation.XmlType;


@XmlType(name = "ReserveRicaricaContoGiocoRequest")
public class ReserveRicaricaContoGiocoRequest {

    private String callerId;
    private String requestId;
    private String skin;
    private String userIp;
    private String firma;
    private String code;
    private boolean ricWithAircash;
    private String contoGioco;
    private String mail;
    private String fiscalCode;
    //usato solo se non passiamo per aircash, importo settimanale < 100
    private String amount;
    private String token;
    private String idAziendaEsercente;
    private String idAziendaDistributore;
    private String cab;
    private String idTerminale;
   //serve per passarlo in input come LocationId a Aircash
    private String codiceBu;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isRicWithAircash() {
        return ricWithAircash;
    }

    public void setRicWithAircash(boolean ricWithAircash) {
        this.ricWithAircash = ricWithAircash;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContoGioco() {
        return contoGioco;
    }

    public void setContoGioco(String contoGioco) {
        this.contoGioco = contoGioco;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdAziendaEsercente() {
        return idAziendaEsercente;
    }

    public void setIdAziendaEsercente(String idAziendaEsercente) {
        this.idAziendaEsercente = idAziendaEsercente;
    }

    public String getIdAziendaDistributore() {
        return idAziendaDistributore;
    }

    public void setIdAziendaDistributore(String idAziendaDistributore) {
        this.idAziendaDistributore = idAziendaDistributore;
    }

    public String getCab() {
        return cab;
    }

    public void setCab(String cab) {
        this.cab = cab;
    }

    public String getIdTerminale() {
        return idTerminale;
    }

    public void setIdTerminale(String idTerminale) {
        this.idTerminale = idTerminale;
    }

    public String getCodiceBu() {
        return codiceBu;
    }

    public void setCodiceBu(String codiceBu) {
        this.codiceBu = codiceBu;
    }

    @Override
    public String toString() {
        return "ReserveRicaricaContoGiocoRequest{" +
                "callerId='" + callerId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", skin='" + skin + '\'' +
                ", userIp='" + userIp + '\'' +
                ", firma='" + firma + '\'' +
                ", code='" + code + '\'' +
                ", ricWithAircash=" + ricWithAircash +
                ", contoGioco='" + contoGioco + '\'' +
                ", mail='" + mail + '\'' +
                ", fiscalCode='" + fiscalCode + '\'' +
                ", amount='" + amount + '\'' +
                ", token='" + token + '\'' +
                ", idAziendaEsercente='" + idAziendaEsercente + '\'' +
                ", idAziendaDistributore='" + idAziendaDistributore + '\'' +
                ", cab='" + cab + '\'' +
                ", idTerminale='" + idTerminale + '\'' +
                ", codiceBu='" + codiceBu + '\'' +
                '}';
    }

    public int validateOnlyOneField(String contoGioco, String fiscalCode, String mail) {
        int count = 0;

        if (contoGioco != null && !contoGioco.isEmpty()) count++;
        if (mail!= null && !mail.isEmpty()) count++;
        if (fiscalCode != null && !fiscalCode.isEmpty()) count++;

       return count;
    }
}
