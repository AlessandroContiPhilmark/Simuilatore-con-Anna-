package it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettino;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.EnteBollettino;

@XmlType(name = "RegistrazioneEnteBollettinoRequest")
public class RegistrazioneEnteBollettinoRequest {

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
	private EnteBollettino enteBollettino;

	private String fileBase64;

	private String contentType;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getFileBase64() {
		return fileBase64;
	}

	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}

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

	public EnteBollettino getEnteBollettino() {
		return enteBollettino;
	}

	public void setEnteBollettino(EnteBollettino enteBollettino) {
		this.enteBollettino = enteBollettino;
	}

	@Override
	public String toString() {
		return "RegistrazioneEnteBollettinoRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore
				+ ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab + ", idTerminale=" + idTerminale + ", enteBollettino=" + enteBollettino + ", fileBase64=" + fileBase64 + ", contentType=" + contentType + "]";
	}

}
