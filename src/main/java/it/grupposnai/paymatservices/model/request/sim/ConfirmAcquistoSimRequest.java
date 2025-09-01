package it.grupposnai.paymatservices.model.request.sim;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.CreditoManager;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmAcquistoSimRequest")
public class ConfirmAcquistoSimRequest {

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
	private String reserveRequestId;
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

	public String getReserveRequestId() {
		return reserveRequestId;
	}

	public void setReserveRequestId(String reserveRequestId) {
		this.reserveRequestId = reserveRequestId;
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
		return "ConfirmAcquistoSimRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab
				+ ", idTerminale=" + idTerminale + ", reserveRequestId=" + reserveRequestId + ", codiceCredito=" + codiceCredito + "]";
	}

}
