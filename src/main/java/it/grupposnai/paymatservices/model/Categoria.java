package it.grupposnai.paymatservices.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Categoria")
public class Categoria {

	private String codice;
	private String descrizione;
	private Integer tipo;
	private int priorita;
	private int[] brand;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getPriorita() {
		return priorita;
	}

	public void setPriorita(Integer priorita) {
		this.priorita = priorita;
	}

	public int[] getBrand() {
		return brand;
	}

	public void setBrand(int[] brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Categoria [codice=" + codice + ", descrizione=" + descrizione + ", tipo=" + tipo + ", priorita="
				+ priorita + ", brand=" + Arrays.toString(brand) + "]";
	}

}
