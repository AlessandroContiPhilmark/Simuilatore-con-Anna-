package it.grupposnai.paymatservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Allegato")
public class Allegato {

	private String codice;
	private String hexString;
	private String type;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getHexString() {
		return hexString;
	}

	public void setHexString(String hexString) {
		this.hexString = hexString;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// ATTENZIONE: NON RIGENERARE, MODIFICATO A MANO
	@Override
	public String toString() {
		return "Allegato [codice=" + codice + ", hexString.length=" + (hexString != null ? hexString.length() : "0") + ", type=" + type + "]";
	}
}
