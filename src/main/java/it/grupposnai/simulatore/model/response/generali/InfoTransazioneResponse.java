package it.grupposnai.simulatore.model.response.generali;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.simulatore.model.response.ricarica.Ticket;

@XmlType(name = "InfoTransazioneResponse")
public class InfoTransazioneResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private Ticket ticket;

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

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "InfoTransazioneResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode="
				+ resultCode + ", resultDesc=" + resultDesc + ", ticket=" + ticket + "]";
	}

}
