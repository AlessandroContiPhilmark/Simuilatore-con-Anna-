package it.grupposnai.paymatservices.model.request.pin;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.CreditoManager;

@XmlType(name = "CancelAcquistoPinRequest")
public class CancelAcquistoPinRequest {

	private String callerId;
	private String requestId;
	private String firma;
	private String skin;
	private String userIP;
	private String idAziendaDistributore;
	private String idAziendaEsercente;
	private String reserveRequestId;
	private Integer idBrand;
	private String token;
	private String codiceCredito;
	private String idTerminale;

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

	public String getReserveRequestId() {
		return reserveRequestId;
	}

	public void setReserveRequestId(String reserveRequestId) {
		this.reserveRequestId = reserveRequestId;
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

	public String getCodiceCredito() {
		return codiceCredito;
	}

	public void setCodiceCredito(String codiceCredito) {
		this.codiceCredito = codiceCredito;
	}

	public String getIdTerminale() {
		return idTerminale;
	}

	public void setIdTerminale(String idTerminale) {
		this.idTerminale = idTerminale;
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
		return "CancelAcquistoPinRequest [callerId=" + callerId + ", requestId=" + requestId + ", firma=" + firma + ", skin=" + skin + ", userIP=" + userIP + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente="
				+ idAziendaEsercente + ", reserveRequestId=" + reserveRequestId + ", idBrand=" + idBrand + ", token=" + token + ", codiceCredito=" + codiceCredito + ", idTerminale=" + idTerminale + "]";
	}

}
