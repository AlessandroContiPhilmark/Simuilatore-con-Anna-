package it.grupposnai.paymatservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BollettinoCbill")
public class BollettinoCbill {

	private String dataPagamento;
	private String idPagamento;
	private String idBanca;
	private String statusBollettino;
	private String idBollettino;
	private Integer importo;
	private String idBollettino2;
	private String valuta;
	private String reference;
	private String dataScadenza;
	private String costoTotaleServizio;
	private String commissioniBollettino;
	private String commissioniBancarie;
	private String iban;
	private String informazioniAggiuntive;

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getIdBanca() {
		return idBanca;
	}

	public void setIdBanca(String idBanca) {
		this.idBanca = idBanca;
	}

	public String getStatusBollettino() {
		return statusBollettino;
	}

	public void setStatusBollettino(String statusBollettino) {
		this.statusBollettino = statusBollettino;
	}

	public String getIdBollettino() {
		return idBollettino;
	}

	public void setIdBollettino(String idBollettino) {
		this.idBollettino = idBollettino;
	}

	public Integer getImporto() {
		return importo;
	}

	public void setImporto(Integer importo) {
		this.importo = importo;
	}

	public String getIdBollettino2() {
		return idBollettino2;
	}

	public void setIdBollettino2(String idBollettino2) {
		this.idBollettino2 = idBollettino2;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getCostoTotaleServizio() {
		return costoTotaleServizio;
	}

	public void setCostoTotaleServizio(String costoTotaleServizio) {
		this.costoTotaleServizio = costoTotaleServizio;
	}

	public String getCommissioniBollettino() {
		return commissioniBollettino;
	}

	public void setCommissioniBollettino(String commissioniBollettino) {
		this.commissioniBollettino = commissioniBollettino;
	}

	public String getCommissioniBancarie() {
		return commissioniBancarie;
	}

	public void setCommissioniBancarie(String commissioniBancarie) {
		this.commissioniBancarie = commissioniBancarie;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getInformazioniAggiuntive() {
		return informazioniAggiuntive;
	}

	public void setInformazioniAggiuntive(String informazioniAggiuntive) {
		this.informazioniAggiuntive = informazioniAggiuntive;
	}

	@Override
	public String toString() {
		return "BollettinoCbill [dataPagamento=" + dataPagamento + ", idPagamento=" + idPagamento + ", idBanca=" + idBanca + ", statusBollettino=" + statusBollettino
				+ ", idBollettino=" + idBollettino + ", importo=" + importo + ", idBollettino2=" + idBollettino2 + ", valuta=" + valuta + ", reference=" + reference
				+ ", dataScadenza=" + dataScadenza + ", costoTotaleServizio=" + costoTotaleServizio + ", commissioniBollettino=" + commissioniBollettino + ", commissioniBancarie="
				+ commissioniBancarie + ", iban=" + iban + ", informazioniAggiuntive=" + informazioniAggiuntive + "]";
	}

}
