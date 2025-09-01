package it.grupposnai.paymatservices.model.response.generali;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.Categoria;

@XmlType(name = "GetCategorieResponse")
public class GetCategorieResponse {

	private String callerId;
	private String requestId;
	private Integer resultCode;
	private String resultDesc;
	private Categoria[] categorie;

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

	public Categoria[] getCategorie() {
		return categorie;
	}

	public void setCategorie(Categoria[] categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "GetCategorieResponse [callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + ", categorie=" + Arrays.toString(categorie) + "]";
	}

}
