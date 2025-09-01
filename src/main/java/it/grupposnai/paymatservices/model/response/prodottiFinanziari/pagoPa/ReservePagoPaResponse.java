package it.grupposnai.paymatservices.model.response.prodottiFinanziari.pagoPa;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ReservePagoPaResponse")
public class ReservePagoPaResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private String idTranPaymat;
	private String idTranEsterno;
	private String dataCompetenza;
	private String causale;
	private String beneficiario;
	private Integer importo;

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

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Integer getImporto() {
		return importo;
	}

	public void setImporto(Integer importo) {
		this.importo = importo;
	}

	@Override
	public String toString() {
		return "ReservePagoPaResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", idTranPaymat=" + idTranPaymat + ", idTranEsterno=" + idTranEsterno + ", dataCompetenza="
				+ dataCompetenza + ", causale=" + causale + ", beneficiario=" + beneficiario + ", importo=" + importo + "]";
	}

}
