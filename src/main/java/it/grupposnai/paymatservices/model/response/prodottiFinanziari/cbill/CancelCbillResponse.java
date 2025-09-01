package it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CancelCbillResponse")
public class CancelCbillResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private String idTranPaymat;
	private String idTranEsterno;
	private String dataCancel;

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

	public String getIdTranPaymat() {
		return idTranPaymat;
	}

	public void setIdTranPaymat(String idTranPaymat) {
		this.idTranPaymat = idTranPaymat;
	}

	public String getIdTranEsterno() {
		return idTranEsterno;
	}

	public void setIdTranEsterno(String idTranEsterno) {
		this.idTranEsterno = idTranEsterno;
	}

	public String getDataCancel() {
		return dataCancel;
	}

	public void setDataCancel(String dataCancel) {
		this.dataCancel = dataCancel;
	}

	@Override
	public String toString() {
		return "CancelCbillResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", idTranPaymat="
				+ idTranPaymat + ", idTranEsterno=" + idTranEsterno + ", dataCancel=" + dataCancel + "]";
	}

}
