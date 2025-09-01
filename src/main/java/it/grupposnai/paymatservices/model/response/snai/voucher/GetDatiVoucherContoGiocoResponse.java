package it.grupposnai.paymatservices.model.response.snai.voucher;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.Account;
import it.grupposnai.paymatservices.model.Voucher;
import it.grupposnai.paymatservices.model.response.Response;

@XmlType(name = "GetDatiVoucherContoGiocoResponse")
public class GetDatiVoucherContoGiocoResponse implements Response {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private Account account;
	private Voucher[] voucher;

	public static GetDatiVoucherContoGiocoResponse build(String callerId, String requestId, Integer resultCode, String resultDesc) {
		return build(callerId, requestId, resultCode, resultDesc, null, null);
	}

	public static GetDatiVoucherContoGiocoResponse build(String callerId, String requestId, Integer resultCode, String resultDesc, Account account, Voucher[] voucher) {
		GetDatiVoucherContoGiocoResponse instance = new GetDatiVoucherContoGiocoResponse();
		instance.setCallerId(callerId);
		instance.setRequestId(requestId);
		instance.setResultCode(resultCode);
		instance.setResultDesc(resultDesc);
		instance.setAccount(account);
		instance.setVoucher(voucher);
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Voucher[] getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher[] voucher) {
		this.voucher = voucher;
	}

	@Override
	public String toString() {
		return "GetDatiVoucherContoGiocoResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", account=" + account + ", voucher=" + Arrays.toString(voucher) + "]";
	}

}
