package it.grupposnai.simulatore.model.response.generali;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "InfoCreditoResiduoResponse")
public class InfoCreditoResiduoResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private Integer creditoResiduo;
	private Integer creditoTerminale;
	private Integer affiliazione;
	private String codiceBu;

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

	public Integer getCreditoResiduo() {
		return creditoResiduo;
	}

	public void setCreditoResiduo(Integer creditoResiduo) {
		this.creditoResiduo = creditoResiduo;
	}

	public Integer getCreditoTerminale() {
		return creditoTerminale;
	}

	public void setCreditoTerminale(Integer creditoTerminale) {
		this.creditoTerminale = creditoTerminale;
	}

	public Integer getAffiliazione() {
		return affiliazione;
	}

	public void setAffiliazione(Integer affiliazione) {
		this.affiliazione = affiliazione;
	}

	public String getCodiceBu() {
		return codiceBu;
	}

	public void setCodiceBu(String codiceBu) {
		this.codiceBu = codiceBu;
	}

	@Override
	public String toString() {
		return "InfoCreditoResiduoResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", creditoResiduo=" + creditoResiduo + ", creditoTerminale=" + creditoTerminale + ", affiliazione=" + affiliazione + ", codiceBu=" + codiceBu + "]";
	}

	


}
