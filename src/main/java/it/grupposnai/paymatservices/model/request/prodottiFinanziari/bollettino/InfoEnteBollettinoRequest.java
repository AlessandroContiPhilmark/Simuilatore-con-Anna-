package it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettino;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

@XmlType(name = "InfoEnteBollettinoRequest")
public class InfoEnteBollettinoRequest {

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
	private String numeroCCEnte;
	private String identificativoBollettino;



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

	public String getNumeroCCEnte() {
		return numeroCCEnte;
	}

	public void setNumeroCCEnte(String numeroCCEnte) {
		this.numeroCCEnte = numeroCCEnte;
	}

	public String getIdentificativoBollettino() {
		return identificativoBollettino;
	}

	public void setIdentificativoBollettino(String identificativoBollettino) {
		this.identificativoBollettino = identificativoBollettino;
	}

	public String validate() {
		String validationErrors = "";
		if (StringUtils.isBlank(getIdTerminale()))
			validationErrors += " idTerminale,";
		if (StringUtils.isBlank(getNumeroCCEnte()))
			validationErrors += " numeroCCEnte,";
		if (StringUtils.isBlank(getIdentificativoBollettino()))
			validationErrors += " identificativoBollettino,";
		return validationErrors.length() > 0 ? validationErrors.substring(0, validationErrors.length() - 1) : null;
	}

	@Override
	public String toString() {
		return "InfoEnteBollettinoRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab
				+ ", idTerminale=" + idTerminale + ", numeroCCEnte=" + numeroCCEnte + ", identificativoBollettino=" + identificativoBollettino + "]";
	}

}
