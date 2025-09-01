package it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.EnteBollettino;

@XmlType(name = "InfoEnteBollettinoResponse")
public class InfoEnteBollettinoResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private EnteBollettino enteBollettino;

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

	public EnteBollettino getEnteBollettino() {
		return enteBollettino;
	}

	public void setEnteBollettino(EnteBollettino enteBollettino) {
		this.enteBollettino = enteBollettino;
	}

	@Override
	public String toString() {
		return "InfoEnteBollettinoResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", enteBollettino=" + enteBollettino + "]";
	}

}
