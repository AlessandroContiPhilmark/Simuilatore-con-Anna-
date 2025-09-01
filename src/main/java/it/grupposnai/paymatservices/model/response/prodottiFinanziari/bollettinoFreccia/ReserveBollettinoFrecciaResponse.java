package it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.Tassa;

@XmlType(name = "ReserveBollettinoFrecciaResponse")
public class ReserveBollettinoFrecciaResponse {
	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private String resultDetail;
	private String idTranPaymat;
	private String idTranEsterno;
	private Tassa[] listaTasse;

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

	public String getResultDetail() {
		return resultDetail;
	}

	public void setResultDetail(String resultDetail) {
		this.resultDetail = resultDetail;
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

	public Tassa[] getListaTasse() {
		return listaTasse;
	}

	public void setListaTasse(Tassa[] listaTasse) {
		this.listaTasse = listaTasse;
	}

	@Override
	public String toString() {
		return "ReserveBollettinoFrecciaResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode="
				+ resultCode + ", resultDesc=" + resultDesc + ", resultDetail=" + resultDetail + ", idTranPaymat="
				+ idTranPaymat + ", idTranEsterno=" + idTranEsterno + ", listaTasse=" + Arrays.toString(listaTasse)
				+ "]";
	}

}
