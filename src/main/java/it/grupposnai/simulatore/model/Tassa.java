package it.grupposnai.simulatore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tassa", propOrder = { "tipoTassa", "importoTassa" })
public class Tassa {

	private String tipoTassa;
	private String importoTassa;

	public String getTipoTassa() {
		return tipoTassa;
	}

	public void setTipoTassa(String tipoTassa) {
		this.tipoTassa = tipoTassa;
	}

	public String getImportoTassa() {
		return importoTassa;
	}

	public void setImportoTassa(String importoTassa) {
		this.importoTassa = importoTassa;
	}

	@Override
	public String toString() {
		return "Tasse [tipoTassa=" + tipoTassa + ", importoTassa=" + importoTassa + "]";
	}
}
