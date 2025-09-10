package it.grupposnai.simulatore.model.response.login;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "PaymentLoginResponse")
public class PaymentLoginResponse {
	
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
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultDesc() {
		return resultDesc;
	}
	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}
	public int getOtpRequired() {
		return otpRequired;
	}
	public void setOtpRequired(int otpRequired) {
		this.otpRequired = otpRequired;
	}
	private String callerId;
	private String requestId;
	private int resultCode;
	private String resultDesc;
	private int otpRequired;
	private String authenticationId;

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	@Override
	public String toString() {
		return "PaymentLoginResponse{" +
				"callerId='" + callerId + '\'' +
				", requestId='" + requestId + '\'' +
				", resultCode=" + resultCode +
				", resultDesc='" + resultDesc + '\'' +
				", otpRequired=" + otpRequired +
				", authenticationId='" + authenticationId + '\'' +
				'}';
	}
}
