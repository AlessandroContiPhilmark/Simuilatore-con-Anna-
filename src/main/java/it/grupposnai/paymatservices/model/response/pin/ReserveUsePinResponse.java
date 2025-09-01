package it.grupposnai.paymatservices.model.response.pin;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ReserveUsePinResponse")
public class ReserveUsePinResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
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

	public Integer getImportoPin() {
		return importoPin;
	}

	public void setImportoPin(Integer importoPin) {
		this.importoPin = importoPin;
	}

	@Override
	public String toString() {
		return "ReserveUsePinResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode
				+ ", resultDesc=" + resultDesc + ", importoPin=" + importoPin + "]";
	}

}
