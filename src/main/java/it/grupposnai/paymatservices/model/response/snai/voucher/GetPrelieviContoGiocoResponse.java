package it.grupposnai.paymatservices.model.response.snai.voucher;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.VTransaction;
import it.grupposnai.paymatservices.model.response.Response;

@XmlType(name = "GetPrelieviContoGiocoResponse")
public class GetPrelieviContoGiocoResponse implements Response {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private VTransaction[] transactionList;

	public static GetPrelieviContoGiocoResponse build(String callerId, String requestId, Integer resultCode, String resultDesc) {
		return build(callerId, requestId, resultCode, resultDesc, null);
	}

	public static GetPrelieviContoGiocoResponse build(String callerId, String requestId, Integer resultCode, String resultDesc, VTransaction[] transactionList) {
		GetPrelieviContoGiocoResponse instance = new GetPrelieviContoGiocoResponse();
		instance.setCallerId(callerId);
		instance.setRequestId(requestId);
		instance.setResultCode(resultCode);
		instance.setResultDesc(resultDesc);
		instance.setTransactionList(transactionList);
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

	public VTransaction[] getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(VTransaction[] transactionList) {
		this.transactionList = transactionList;
	}

	@Override
	public String toString() {
		return "GetPrelieviContoGiocoResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", transactionList=" + Arrays.toString(transactionList) + "]";
	}

}
