package it.grupposnai.paymatservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BeneficiarioBollettino")
public class BeneficiarioBollettino {

	private String denominazione;
	private String numeroConto;
	private String codiceBollettino;
	private String tipoBollettino;
	private String causale;

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getNumeroConto() {
		return numeroConto;
	}

	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}

	public String getCodiceBollettino() {
		return codiceBollettino;
	}

	public void setCodiceBollettino(String codiceBollettino) {
		this.codiceBollettino = codiceBollettino;
	}

	public String getTipoBollettino() {
		return tipoBollettino;
	}

	public void setTipoBollettino(String tipoBollettino) {
		this.tipoBollettino = tipoBollettino;
	}

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	@Override
	public String toString() {
		return "BeneficiarioBollettino [denominazione=" + denominazione + ", numeroConto=" + numeroConto
				+ ", codiceBollettino=" + codiceBollettino + ", tipoBollettino=" + tipoBollettino + ", causale="
				+ causale + "]";
	}

}
