package it.grupposnai.paymatservices.model.response.ricaricaConto;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CancelRicaricaContoResponse")
public class CancelRicaricaContoResponse {

	private String callerId;
	private String requestID;
	private Integer resultCode;
	private String resultDesc;
	
	public String getCallerId() {
		return callerId;
	}

	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}

	public String getRequestID() {
		return requestID;
	}

	public void setRequestID(String requestID) {
		this.requestID = requestID;
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
		return "CancelRicaricaContoResponse [callerId=" + callerId + ", requestID=" + requestID + ", resultCode="
				+ resultCode + ", resultDesc=" + resultDesc + "]";
	}
	
	
	 

}
