package it.grupposnai.paymatservices.model.request.pin;

import it.grupposnai.paymatcore.utils.CreditoManager;
import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CancelAcquistoPinVivacardRequest")
public class CancelAcquistoPinVivacardRequest {

    private String callerId;
    private String requestId;
    private String firma;
    private String skin;
    private String userIP;
    private String cro;
    private Integer idBrand;
    private String token;
    private String idTerminale;
    private String idFornitore;
    private String pin;
    private String stringaConnettore;
    private String cab;
    private Integer idConnettore;



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

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }


    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public Integer getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(Integer idBrand) {
        this.idBrand = idBrand;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getIdTerminale() {
        return idTerminale;
    }

    public void setIdTerminale(String idTerminale) {
        this.idTerminale = idTerminale;
    }

    public String validate() {
        String validationErrors = "";
        if (StringUtils.isNotBlank(getCallerId()) && StringUtils.isBlank(getCro()))
            validationErrors += " cro mancante";
        if (validationErrors.length() > 0)
            validationErrors = validationErrors.substring(0, validationErrors.length() - 1);
        else
            validationErrors = null;
        return validationErrors;
    }

    public String getIdFornitore() {
        return idFornitore;
    }

    public void setIdFornitore(String idFornitore) {
        this.idFornitore = idFornitore;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getStringaConnettore() {
        return stringaConnettore;
    }

    public void setStringaConnettore(String stringaConnettore) {
        this.stringaConnettore = stringaConnettore;
    }

    public String getCab() {
        return cab;
    }

    public void setCab(String cab) {
        this.cab = cab;
    }

    public Integer getIdConnettore() {
        return idConnettore;
    }

    public void setIdConnettore(Integer idConnettore) {
        this.idConnettore = idConnettore;
    }

    @Override
    public String toString() {
        return "CancelAcquistoPinVivacardRequest{" +
                "callerId='" + callerId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", firma='" + firma + '\'' +
                ", skin='" + skin + '\'' +
                ", userIP='" + userIP + '\'' +
                ", cro='" + cro + '\'' +
                ", idBrand=" + idBrand +
                ", token='" + token + '\'' +
                ", idTerminale='" + idTerminale + '\'' +
                ", idFornitore='" + idFornitore + '\'' +
                ", pin='" + pin + '\'' +
                ", stringaConnettore='" + stringaConnettore + '\'' +
                ", cab='" + cab + '\'' +
                ", idConnettore=" + idConnettore +
                '}';
    }
}
