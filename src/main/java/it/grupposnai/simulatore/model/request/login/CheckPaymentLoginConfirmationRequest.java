package it.grupposnai.simulatore.model.request.login;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CheckPaymentLoginConfirmationRequest")
public class CheckPaymentLoginConfirmationRequest {

    private String callerId;
    private String requestId;
    private String skin;
    private String userIp;
    private String firma;
    private String token;
    private String idAziendaDistributore;
    private String idAziendaEsercente;
    private String cab;
    private String idTerminale;
    private String authenticationId;


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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdAziendaDistributore() {
        return idAziendaDistributore;
    }

    public void setIdAziendaDistributore(String idAziendaDistributore) {
        this.idAziendaDistributore = idAziendaDistributore;
    }

    public String getIdAziendaEsercente() {
        return idAziendaEsercente;
    }

    public void setIdAziendaEsercente(String idAziendaEsercente) {
        this.idAziendaEsercente = idAziendaEsercente;
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

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    @Override
    public String toString() {
        return "CheckPaymentLoginConfirmationRequestCore{" +
                "callerId='" + callerId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", skin='" + skin + '\'' +
                ", userIp='" + userIp + '\'' +
                ", firma='" + firma + '\'' +
                ", token='" + token + '\'' +
                ", idAziendaDistributore='" + idAziendaDistributore + '\'' +
                ", idAziendaEsercente='" + idAziendaEsercente + '\'' +
                ", cab='" + cab + '\'' +
                ", idTerminale='" + idTerminale + '\'' +
                ", authenticationId='" + authenticationId + '\'' +
                '}';
    }
}
