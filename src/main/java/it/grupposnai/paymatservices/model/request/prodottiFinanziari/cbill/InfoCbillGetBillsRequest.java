package it.grupposnai.paymatservices.model.request.prodottiFinanziari.cbill;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "InfoCbillGetBillsRequest")
public class InfoCbillGetBillsRequest {

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
	private String codiceSiaBollettino;
	private String codiceFiscaleDebitore;
	private String dataInizioRicerca;
	private String dataFineRicerca;

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

	public String getCodiceSiaBollettino() {
		return codiceSiaBollettino;
	}

	public void setCodiceSiaBollettino(String codiceSiaBollettino) {
		this.codiceSiaBollettino = codiceSiaBollettino;
	}

	public String getCodiceFiscaleDebitore() {
		return codiceFiscaleDebitore;
	}

	public void setCodiceFiscaleDebitore(String codiceFiscaleDebitore) {
		this.codiceFiscaleDebitore = codiceFiscaleDebitore;
	}

	public String getDataInizioRicerca() {
		return dataInizioRicerca;
	}

	public void setDataInizioRicerca(String dataInizioRicerca) {
		this.dataInizioRicerca = dataInizioRicerca;
	}

	public String getDataFineRicerca() {
		return dataFineRicerca;
	}

	public void setDataFineRicerca(String dataFineRicerca) {
		this.dataFineRicerca = dataFineRicerca;
	}

	@Override
	public String toString() {
		return "InfoCbillGetBillsRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token
				+ ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab + ", idTerminale=" + idTerminale
				+ ", codiceSiaBollettino=" + codiceSiaBollettino + ", codiceFiscaleDebitore=" + codiceFiscaleDebitore + ", dataInizioRicerca=" + dataInizioRicerca
				+ ", dataFineRicerca=" + dataFineRicerca + "]";
	}

}
