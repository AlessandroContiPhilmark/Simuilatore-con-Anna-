package it.grupposnai.paymatservices.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Bollettino")
public class Bollettino {

	private Integer importoVersamento;
	private String numeroCC;
	private String identificativoBollettino;
	private String codiceBollettino;
	private String causaleVersamento;
	private String infoAggiuntive;
	private CampoVariabileBollettino[] campiVariabiliBollettinoEnte;
	private CampoVariabileBollettino[] campiVariabiliBollettinoCliente;

	public Integer getImportoVersamento() {
		return importoVersamento;
	}

	public void setImportoVersamento(Integer importoVersamento) {
		this.importoVersamento = importoVersamento;
	}

	public String getNumeroCC() {
		return numeroCC;
	}

	public void setNumeroCC(String numeroCC) {
		this.numeroCC = numeroCC;
	}

	public String getIdentificativoBollettino() {
		return identificativoBollettino;
	}

	public void setIdentificativoBollettino(String identificativoBollettino) {
		this.identificativoBollettino = identificativoBollettino;
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

	public String getInfoAggiuntive() {
		return infoAggiuntive;
	}

	public void setInfoAggiuntive(String infoAggiuntive) {
		this.infoAggiuntive = infoAggiuntive;
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
		return "Bollettino [importoVersamento=" + importoVersamento + ", numeroCC=" + numeroCC + ", identificativoBollettino=" + identificativoBollettino + ", codiceBollettino=" + codiceBollettino + ", causaleVersamento=" + causaleVersamento
				+ ", infoAggiuntive=" + infoAggiuntive + ", campiVariabiliBollettinoEnte=" + Arrays.toString(campiVariabiliBollettinoEnte) + ", campiVariabiliBollettinoCliente=" + Arrays.toString(campiVariabiliBollettinoCliente) + "]";
	}

}
