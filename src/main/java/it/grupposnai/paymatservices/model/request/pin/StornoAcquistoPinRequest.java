package it.grupposnai.paymatservices.model.request.pin;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "StornoAcquistoPinRequest")
public class StornoAcquistoPinRequest {

	private String callerId;
	private String requestId;
	private String firma;
	private String requestIdReserve;
	private String userIp;
	private String token;
	private String skin;
	private String idAziendaDistributore;
	private String idAziendaEsercente;
	private Integer idBrand;

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

	public String getRequestIdReserve() {
		return requestIdReserve;
	}

	public void setRequestIdReserve(String requestIdReserve) {
		this.requestIdReserve = requestIdReserve;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
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

	public Integer getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(Integer idBrand) {
		this.idBrand = idBrand;
	}

	@Override
	public String toString() {
		return "StornoAcquistoPinRequest [callerId=" + callerId + ", requestId=" + requestId + ", firma=" + firma
				+ ", requestIdReserve=" + requestIdReserve + ", userIp=" + userIp + ", token=" + token
				+ ", skin=" + skin + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente="
				+ idAziendaEsercente + ", idBrand=" + idBrand + "]";
	}

}
