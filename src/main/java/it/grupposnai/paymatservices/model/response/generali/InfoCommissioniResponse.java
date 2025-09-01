package it.grupposnai.paymatservices.model.response.generali;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "InfoCommissioniResponse")
public class InfoCommissioniResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private Integer commissioni;

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

	public Integer getCommissioni() {
		return commissioni;
	}

	public void setCommissioni(Integer commissioni) {
		this.commissioni = commissioni;
	}

	@Override
	public String toString() {
		return "InfoCommissioniResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", commissioni=" + commissioni + "]";
	}

}
