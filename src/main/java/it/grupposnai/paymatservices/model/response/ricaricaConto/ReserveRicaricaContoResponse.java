package it.grupposnai.paymatservices.model.response.ricaricaConto;

import it.grupposnai.paymatservices.model.response.ricarica.Ticket;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ReserveRicaricaContoResponse")
public class ReserveRicaricaContoResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
    private String importo;
    private Ticket ticket;
    
	public String getImporto() {
		return importo;
	}

	public void setImporto(String importo) {
		this.importo = importo;
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
		return "ReserveRicaricaContoResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode="
				+ resultCode + ", resultDesc=" + resultDesc + ", importo=" + importo + ", ticket=" + ticket + "]";
	}

}
