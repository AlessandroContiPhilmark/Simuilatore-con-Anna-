package it.grupposnai.paymatservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RichiedenteBollettino")
public class RichiedenteBollettino {

	private String denominazione;
	private String indirizzo;
	private String comune;
	private String cap;
	private String provincia;
	private String codiceFiscale;
	private String cittaNascita;
	private String dataNascita;

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCittaNascita() {
		return cittaNascita;
	}

	public void setCittaNascita(String cittaNascita) {
		this.cittaNascita = cittaNascita;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "RichiedenteBollettino [denominazione=" + denominazione + ", indirizzo=" + indirizzo + ", comune="
				+ comune + ", cap=" + cap + ", provincia=" + provincia + ", codiceFiscale=" + codiceFiscale
				+ ", cittaNascita=" + cittaNascita + ", dataNascita=" + dataNascita + "]";
	}

}
