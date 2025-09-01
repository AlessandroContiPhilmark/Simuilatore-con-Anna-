package it.grupposnai.paymatservices.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Voucher")
public class Voucher {

	private Integer codiceVoucher;
	private Integer valore;
	private String dataEmissione;
	private String dataScadenza;
	private Integer stato;
	private String descStato;
	private Integer codTipoDoc;
	private String numDoc;
	private String idTran;
	private String idTranCsmf;

	public Integer getCodiceVoucher() {
		return codiceVoucher;
	}

	public void setCodiceVoucher(Integer codiceVoucher) {
		this.codiceVoucher = codiceVoucher;
	}

	public Integer getValore() {
		return valore;
	}

	public void setValore(Integer valore) {
		this.valore = valore;
	}

	public String getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(String dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Integer getStato() {
		return stato;
	}

	public void setStato(Integer stato) {
		this.stato = stato;
	}

	public String getDescStato() {
		return descStato;
	}

	public void setDescStato(String descStato) {
		this.descStato = descStato;
	}

	public Integer getCodTipoDoc() {
		return codTipoDoc;
	}

	public void setCodTipoDoc(Integer codTipoDoc) {
		this.codTipoDoc = codTipoDoc;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getIdTran() {
		return idTran;
	}

	public void setIdTran(String idTran) {
		this.idTran = idTran;
	}

	public String getIdTranCsmf() {
		return idTranCsmf;
	}

	public void setIdTranCsmf(String idTranCsmf) {
		this.idTranCsmf = idTranCsmf;
	}

	@Override
	public String toString() {
		return "Voucher [codiceVoucher=" + codiceVoucher + ", valore=" + valore + ", dataEmissione=" + dataEmissione + ", dataScadenza=" + dataScadenza + ", stato=" + stato + ", descStato=" + descStato + ", codTipoDoc=" + codTipoDoc + ", numDoc=" + numDoc + ", idTran=" + idTran
				+ ", idTranCsmf=" + idTranCsmf + "]";
	}

}
