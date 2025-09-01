package it.grupposnai.paymatservices.model.response.prodottiFinanziari.cbill;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.EnteCbill;

@XmlType(name = "InfoCbillGetBillersResponse")
public class InfoCbillGetBillersResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private String idTranPaymat;
	private String idTranEsterno;
	private String dataCompetenza;
	private EnteCbill[] listaEnti;

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

	public String getDataCompetenza() {
		return dataCompetenza;
	}

	public void setDataCompetenza(String dataCompetenza) {
		this.dataCompetenza = dataCompetenza;
	}

	public EnteCbill[] getListaEnti() {
		return listaEnti;
	}

	public void setListaEnti(EnteCbill[] listaEnti) {
		this.listaEnti = listaEnti;
	}

	@Override
	public String toString() {
		return "InfoCbillGetBillersResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", idTranPaymat="
				+ idTranPaymat + ", idTranEsterno=" + idTranEsterno + ", dataCompetenza=" + dataCompetenza + ", listaEnti=" + Arrays.toString(listaEnti) + "]";
	}
}
