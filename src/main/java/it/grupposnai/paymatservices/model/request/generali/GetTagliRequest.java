package it.grupposnai.paymatservices.model.request.generali;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "GetTagliRequest")
public class GetTagliRequest {

	private String callerId;
	private String requestId;
	private String skin;
	private String userIP;
	private String firma;
	private String token;
	private String idAziendaDistributore;
	private String idAziendaEsercente;
	private String cab;
	private String idTerminale;
	private Integer codiceBrand;
	private String var;

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

	public Integer getCodiceBrand() {
		return codiceBrand;
	}

	public void setCodiceBrand(Integer codiceBrand) {
		this.codiceBrand = codiceBrand;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public String toString() {
		return "GetTagliRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIP=" + userIP + ", firma=" + firma + ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente="
				+ idAziendaEsercente + ", cab=" + cab + ", idTerminale=" + idTerminale + ", codiceBrand=" + codiceBrand + ", var=" + var + "]";
	}

}
