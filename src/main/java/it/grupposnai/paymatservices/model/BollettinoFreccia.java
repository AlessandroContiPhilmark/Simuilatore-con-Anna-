package it.grupposnai.paymatservices.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "BollettinoFreccia")
public class BollettinoFreccia {

	private int importoVersamento;
	private String codiceBollettino;
	private String causaleVersamento;
	private String cinImporto;
	private String cinCodiceIdentificativo;
	private String cinComplessivo;
	private String iban;
	private int codiceEsenzione;
	private String informazioniAggiuntive;
	public int getImportoVersamento() {
		return importoVersamento;
	}
	public void setImportoVersamento(int importoVersamento) {
		this.importoVersamento = importoVersamento;
	}
	public String getCodiceBollettino() {
		return codiceBollettino;
	}
	public void setCodiceBollettino(String codiceBollettino) {
		this.codiceBollettino = codiceBollettino;
	}
	public String getCausaleVersamento() {
		return causaleVersamento;
	}
	public void setCausaleVersamento(String causaleVersamento) {
		this.causaleVersamento = causaleVersamento;
	}
	public String getCinImporto() {
		return cinImporto;
	}
	public void setCinImporto(String cinImporto) {
		this.cinImporto = cinImporto;
	}
	public String getCinCodiceIdentificativo() {
		return cinCodiceIdentificativo;
	}
	public void setCinCodiceIdentificativo(String cinCodiceIdentificativo) {
		this.cinCodiceIdentificativo = cinCodiceIdentificativo;
	}
	public String getCinComplessivo() {
		return cinComplessivo;
	}
	public void setCinComplessivo(String cinComplessivo) {
		this.cinComplessivo = cinComplessivo;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public int getCodiceEsenzione() {
		return codiceEsenzione;
	}
	public void setCodiceEsenzione(int codiceEsenzione) {
		this.codiceEsenzione = codiceEsenzione;
	}
	public String getInformazioniAggiuntive() {
		return informazioniAggiuntive;
	}
	public void setInformazioniAggiuntive(String informazioniAggiuntive) {
		this.informazioniAggiuntive = informazioniAggiuntive;
	}
	
	@Override
	public String toString() {
		return "BollettinoFreccia [importoVersamento=" + importoVersamento + ", codiceBollettino=" + codiceBollettino
				+ ", causaleVersamento=" + causaleVersamento + ", cinImporto=" + cinImporto
				+ ", cinCodiceIdentificativo=" + cinCodiceIdentificativo + ", cinComplessivo=" + cinComplessivo
				+ ", iban=" + iban + ", codiceEsenzione=" + codiceEsenzione + ", informazioniAggiuntive="
				+ informazioniAggiuntive + "]";
	}


}
