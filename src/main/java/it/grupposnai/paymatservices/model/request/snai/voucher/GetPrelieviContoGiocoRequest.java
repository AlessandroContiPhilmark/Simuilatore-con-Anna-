package it.grupposnai.paymatservices.model.request.snai.voucher;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatservices.model.request.Request;
import it.grupposnai.paymatservices.util.Validation;

@XmlType(name = "GetPrelieviContoGiocoRequest")
public class GetPrelieviContoGiocoRequest implements Request {

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
	private String dataInizio;
	private String dataFine;
	private String codiceSnaipay;
	private String descrizioneAzienda;

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

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public String getCodiceSnaipay() {
		return codiceSnaipay;
	}

	public void setCodiceSnaipay(String codiceSnaipay) {
		this.codiceSnaipay = codiceSnaipay;
	}

	public String getDescrizioneAzienda() {
		return descrizioneAzienda;
	}

	public void setDescrizioneAzienda(String descrizioneAzienda) {
		this.descrizioneAzienda = descrizioneAzienda;
	}

	public String validate() {
		String validationErrors = Validation.validateRequest(this);
		validationErrors += Validation.validateRequestString(dataInizio, "dataInizio");
		validationErrors += Validation.validateRequestString(dataFine, "dataFine");
		if (StringUtils.isNotBlank(getDataInizio())) {
			validationErrors += Validation.validateRequestDate(dataInizio, "dataInizio in formato dd/mm/aaaa");
		}
		if (StringUtils.isNotBlank(getDataFine())) {
			validationErrors += Validation.validateRequestDate(dataFine, "dataFine in formato dd/mm/aaaa");
		}
		return Validation.formatValidation(validationErrors);
	}

	@Override
	public String toString() {
		return "GetPrelieviContoGiocoRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab
				+ ", idTerminale=" + idTerminale + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", codiceSnaipay=" + codiceSnaipay + ", descrizioneAzienda=" + descrizioneAzienda + "]";
	}

}
