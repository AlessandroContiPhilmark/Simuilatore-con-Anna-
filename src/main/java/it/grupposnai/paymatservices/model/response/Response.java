package it.grupposnai.paymatservices.model.response;

public interface Response {

	public String getCallerId();
	public void setCallerId(String callerId);

	public String getRequestId();
	public void setRequestId(String requestId);

	public Integer getResultCode();
	public void setResultCode(Integer resultCode);

	public String getResultDesc();
	public void setResultDesc(String resultDesc);

}
