package it.grupposnai.paymatservices.model.response.pin;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.Taglio;

@XmlType(name = "InfoTagliPinResponse")
public class InfoTagliPinResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private Taglio[] tagli;

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

	public Taglio[] getTagli() {
		return tagli;
	}

	public void setTagli(Taglio[] tagli) {
		this.tagli = tagli;
	}

	@Override
	public String toString() {
		return "InfoTagliPinResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode
				+ ", resultDesc=" + resultDesc + ", tagli=" + Arrays.toString(tagli) + "]";
	}

}
