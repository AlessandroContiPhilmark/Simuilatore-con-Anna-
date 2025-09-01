package it.grupposnai.paymatservices.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "EnteBollettino")
public class EnteBollettino {
	private String nome;
	private String numeroCC;
	private String note;
	private String memoCausale;
	private int obbligatorietaCodFisPiva;
	private CampoVariabileBollettino[] campiVariabiliBollettinoEnte;
	private CampoVariabileBollettino[] campiVariabiliBollettinoCliente;

	public int isObbligatorietaCodFisPiva() {
		return obbligatorietaCodFisPiva;
	}

	public void setObbligatorietaCodFisPiva(int obbligatorietaCodFisPiva) {
		this.obbligatorietaCodFisPiva = obbligatorietaCodFisPiva;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroCC() {
		return numeroCC;
	}

	public void setNumeroCC(String numeroCC) {
		this.numeroCC = numeroCC;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMemoCausale() {
		return memoCausale;
	}

	public void setMemoCausale(String memoCausale) {
		this.memoCausale = memoCausale;
	}

	public CampoVariabileBollettino[] getCampiVariabiliBollettinoEnte() {
		return campiVariabiliBollettinoEnte;
	}

	public void setCampiVariabiliBollettinoEnte(CampoVariabileBollettino[] campiVariabiliBollettinoEnte) {
		this.campiVariabiliBollettinoEnte = campiVariabiliBollettinoEnte;
	}

	public CampoVariabileBollettino[] getCampiVariabiliBollettinoCliente() {
		return campiVariabiliBollettinoCliente;
	}

	public void setCampiVariabiliBollettinoCliente(CampoVariabileBollettino[] campiVariabiliBollettinoCliente) {
		this.campiVariabiliBollettinoCliente = campiVariabiliBollettinoCliente;
	}

	@Override
	public String toString() {
		return "EnteBollettino{" +
				"nome=" + nome +
				", numeroCC=" + numeroCC +
				", note=" + note +
				", memoCausale=" + memoCausale +
				", obbligatorietaCodFisPiva=" + obbligatorietaCodFisPiva +
				", campiVariabiliBollettinoEnte=" + (campiVariabiliBollettinoEnte!=null?Arrays.toString(campiVariabiliBollettinoEnte):null) +
				", campiVariabiliBollettinoCliente=" + (campiVariabiliBollettinoCliente!=null?Arrays.toString(campiVariabiliBollettinoCliente):null) +
				"}";
	}
}
