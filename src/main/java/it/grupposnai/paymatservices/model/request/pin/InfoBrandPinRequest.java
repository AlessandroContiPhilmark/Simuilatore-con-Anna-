package it.grupposnai.paymatservices.model.request.pin;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "InfoBrandPinRequest")
public class InfoBrandPinRequest {

	private String callerId;
	private String requestId;
	private String firma;
	private String skin;
	private String userIp;
	private String idAziendaDistributore;
	private String idAziendaEsercente;

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

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
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

	@Override
	public String toString() {
		return "InfoBrandPinRequest [callerId=" + callerId + ", requestId=" + requestId + ", firma=" + firma + ", skin="
				+ skin + ", userIp=" + userIp + ", idAziendaDistributore=" + idAziendaDistributore
				+ ", idAziendaEsercente=" + idAziendaEsercente + "]";
	}

}
