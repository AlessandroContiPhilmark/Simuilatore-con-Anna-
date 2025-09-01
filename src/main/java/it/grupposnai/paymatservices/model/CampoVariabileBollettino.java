package it.grupposnai.paymatservices.model;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CampoVariabileBollettino")
public class CampoVariabileBollettino {

	private String nome;
	private String descrizione;
	private Integer tipo;
	private Integer lunghezza;
	private String valore;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Integer getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(Integer lunghezza) {
		this.lunghezza = lunghezza;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	@Override
	public String toString() {
		return "CampoVariabileCausaleBollettino [nome=" + nome + ", descrizione=" + descrizione + ", tipo=" + tipo + ", lunghezza=" + lunghezza + ", valore=" + valore + "]";
	}

}
