package it.grupposnai.paymatservices.model.request.pin;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.CreditoManager;

@XmlType(name = "ConfirmAcquistoPinRequest")
public class ConfirmAcquistoPinRequest {

	private String callerId;
	private String requestId;
	private String firma;
	private String skin;
	private String userIP;
	private String reserveRequestId;
	private String token;
	private String idAziendaDistributore;
	private String idAziendaEsercente;
	private String cab;
	private String idTerminale;
	private Integer idBrand;
	private String codiceCredito;

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

	public String getReserveRequestId() {
		return reserveRequestId;
	}

	public void setReserveRequestId(String reserveRequestId) {
		this.reserveRequestId = reserveRequestId;
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

	public int getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}

	public String getCodiceCredito() {
		return codiceCredito;
	}

	public void setCodiceCredito(String codiceCredito) {
		this.codiceCredito = codiceCredito;
	}
	
	public String validate() {
		String validationErrors = "";
		if (StringUtils.isNotBlank(getCallerId()) && CreditoManager.getInstance().isCallerWithRequiredCodiceCredito(getCallerId()) && StringUtils.isBlank(getCodiceCredito()))
			validationErrors += " codiceCredito,";
		if (validationErrors.length() > 0)
			validationErrors = validationErrors.substring(0, validationErrors.length() - 1);
		else
			validationErrors = null;
		return validationErrors;
	}

	@Override
	public String toString() {
		return "ConfirmAcquistoPinRequest [callerId=" + callerId + ", requestId=" + requestId + ", firma=" + firma + ", skin=" + skin + ", userIP=" + userIP + ", reserveRequestId=" + reserveRequestId
				+ ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab + ", idTerminale=" + idTerminale
				+ ", idBrand=" + idBrand + ", codiceCredito=" + codiceCredito + "]";
	}

}
