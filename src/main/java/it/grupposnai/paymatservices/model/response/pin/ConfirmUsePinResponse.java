package it.grupposnai.paymatservices.model.response.pin;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.response.ricarica.Ticket;

@XmlType(name = "ConfirmUsePinResponse")
public class ConfirmUsePinResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private Integer importo;
	private String seriale;
	private String pin;
	private String scadenza;
	private String idTranPaymat;
	private String idTranEsterno;
	private Ticket ticket;
	private Integer importoPin;

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

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public Integer getImporto() {
		return importo;
	}

	public void setImporto(Integer importo) {
		this.importo = importo;
	}

	public String getSeriale() {
		return seriale;
	}

	public void setSeriale(String seriale) {
		this.seriale = seriale;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getScadenza() {
		return scadenza;
	}

	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}

	public String getIdTranPaymat() {
		return idTranPaymat;
	}

	public void setIdTranPaymat(String idTranPaymat) {
		this.idTranPaymat = idTranPaymat;
	}

	public String getIdTranEsterno() {
		return idTranEsterno;
	}

	public void setIdTranEsterno(String idTranEsterno) {
		this.idTranEsterno = idTranEsterno;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Integer getImportoPin() {
		return importoPin;
	}

	public void setImportoPin(Integer importoPin) {
		this.importoPin = importoPin;
	}

	@Override
	public String toString() {
		return "ConfirmUsePinResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode
				+ ", resultDesc=" + resultDesc + ", importo=" + importo + ", seriale=" + seriale + ", pin=" + pin
				+ ", scadenza=" + scadenza + ", idTranPaymat=" + idTranPaymat + ", idTranEsterno=" + idTranEsterno
				+ ", ticket=" + ticket + ", importoPin=" + importoPin + "]";
	}

}
