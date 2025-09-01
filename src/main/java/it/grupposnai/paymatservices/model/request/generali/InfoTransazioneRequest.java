package it.grupposnai.paymatservices.model.request.generali;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "InfoTransazioneRequest")
public class InfoTransazioneRequest {

	private String callerId;
	private String requestId;
	private String skin;
	private String userIP;
	private String firma;
	private String token;
	private String idAziendaDistributore;
	private String idAziendaEsercente;
	private String reserveRequestId;
	private String idTranPaymat;

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

	public String getUserIP() {
		return userIP;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
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

	public String getReserveRequestId() {
		return reserveRequestId;
	}

	public void setReserveRequestId(String reserveRequestId) {
		this.reserveRequestId = reserveRequestId;
	}

	public String getIdTranPaymat() {
		return idTranPaymat;
	}

	public void setIdTranPaymat(String idTranPaymat) {
		this.idTranPaymat = idTranPaymat;
	}

	@Override
	public String toString() {
		return "InfoTransazioneRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIP=" + userIP + ", firma=" + firma + ", token=" + token
				+ ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", reserveRequestId=" + reserveRequestId + ", idTranPaymat="
				+ idTranPaymat + "]";
	}

}
