package it.grupposnai.paymatservices.model.response.prodottiFinanziari.bollettinoFreccia;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.Tassa;
import it.grupposnai.paymatservices.model.response.ricarica.Ticket;

@XmlType(name = "ConfirmBollettinoFrecciaResponse")
public class ConfirmBollettinoFrecciaResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private String idTranPaymat;
	private String idTranEsterno;
	private Tassa[] listaTasse;
	private Ticket ticket;

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

	public Tassa[] getListaTasse() {
		return listaTasse;
	}

	public void setListaTasse(Tassa[] listaTasse) {
		this.listaTasse = listaTasse;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "ConfirmBollettinoFrecciaResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode="
				+ resultCode + ", resultDesc=" + resultDesc + ", idTranPaymat=" + idTranPaymat + ", idTranEsterno="
				+ idTranEsterno + ", listaTasse=" + Arrays.toString(listaTasse) + ", ticket=" + ticket + "]";
	}

}
