package it.grupposnai.paymatservices.model.response.pin;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.Brand;

@XmlType(name = "InfoBrandPinResponse")
public class InfoBrandPinResponse {

	private Integer resultCode;
	private String resultDesc;
	private String callerId;
	private String requestId;
	private Brand[] brand;

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

	public Brand[] getBrand() {
		return brand;
	}

	public void setBrand(Brand[] brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "InfoBrandPinResponse [resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", callerId="
				+ callerId + ", requestId=" + requestId + ", brand=" + Arrays.toString(brand) + "]";
	}

}
