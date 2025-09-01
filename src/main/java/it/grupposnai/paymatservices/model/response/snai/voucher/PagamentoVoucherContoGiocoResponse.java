package it.grupposnai.paymatservices.model.response.snai.voucher;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.response.Response;
import it.grupposnai.paymatservices.model.response.ricarica.Ticket;

@XmlType(name = "PagamentoVoucherContoGiocoResponse")
public class PagamentoVoucherContoGiocoResponse implements Response {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private Ticket ticket;

	public static PagamentoVoucherContoGiocoResponse build(String callerId, String requestId, Integer resultCode, String resultDesc) {
		PagamentoVoucherContoGiocoResponse instance = new PagamentoVoucherContoGiocoResponse();
		instance.setCallerId(callerId);
		instance.setRequestId(requestId);
		instance.setResultCode(resultCode);
		instance.setResultDesc(resultDesc);
		return instance;
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
		return "PagamentoVoucherContoGiocoResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", ticket=" + ticket + "]";
	}

}
