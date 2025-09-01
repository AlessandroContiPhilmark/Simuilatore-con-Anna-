package it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettino;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "RegistrazioneEnteBollettinoResponse")
public class RegistrazioneEnteBollettinoResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;

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

	@Override
	public String toString() {
		return "RegistrazioneEnteBollettinoResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + "]";
	}

}
