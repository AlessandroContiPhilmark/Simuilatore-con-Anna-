
package it.grupposnai.paymatservices.model.response.ricarica;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.Tassa;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ticket", propOrder = { "logoAziendale", "nomeEsercente", "descrizioneProdotto", "dataOraTransazione",
		"esitoTransazione", "logoBrand", "importoFacciale", "noteTransazione", "linkSitoWeb", "numeroAssistenza",
		"footerScontrino", "idTerminale", "abi", "cab", "numeroOperazione", "idAutorizzazione", "idTranPaymat",
		"numeroTelefonico", "pin", "variabile", "tasse", "eseguitoDa", "numeroIPPS", "dataScadenza", "causale", "beneficiario", "serialNumber" })
public class Ticket {

	protected String logoAziendale;
	protected String nomeEsercente;
	protected String descrizioneProdotto;
	protected String dataOraTransazione;
	protected String esitoTransazione;
	protected String logoBrand;
	protected String importoFacciale;
	protected String noteTransazione;
	protected String linkSitoWeb;
	protected String numeroAssistenza;
	protected String footerScontrino;
	protected String idTerminale;
	@XmlElement(name = "ABI")
	protected String abi;
	@XmlElement(name = "CAB")
	protected String cab;
	@XmlElement(name = "numero_operazione")
	protected String numeroOperazione;
	@XmlElement(name = "id_autorizzazione")
	protected String idAutorizzazione;
	protected String idTranPaymat;
	protected String numeroTelefonico;
	protected String pin;
	protected String variabile;
	protected Tassa[] tasse;
	protected String eseguitoDa;
	protected String numeroIPPS;
	protected String dataScadenza;
	protected String causale;
	protected String beneficiario;
	protected String serialNumber;

	public String getLogoAziendale() {
		return logoAziendale;
	}

	public void setLogoAziendale(String logoAziendale) {
		this.logoAziendale = logoAziendale;
	}

	public String getNomeEsercente() {
		return nomeEsercente;
	}

	public void setNomeEsercente(String nomeEsercente) {
		this.nomeEsercente = nomeEsercente;
	}

	public String getDescrizioneProdotto() {
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto) {
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public String getDataOraTransazione() {
		return dataOraTransazione;
	}

	public void setDataOraTransazione(String dataOraTransazione) {
		this.dataOraTransazione = dataOraTransazione;
	}

	public String getEsitoTransazione() {
		return esitoTransazione;
	}

	public void setEsitoTransazione(String esitoTransazione) {
		this.esitoTransazione = esitoTransazione;
	}

	public String getLogoBrand() {
		return logoBrand;
	}

	public void setLogoBrand(String logoBrand) {
		this.logoBrand = logoBrand;
	}

	public String getImportoFacciale() {
		return importoFacciale;
	}

	public void setImportoFacciale(String importoFacciale) {
		this.importoFacciale = importoFacciale;
	}

	public String getNoteTransazione() {
		return noteTransazione;
	}

	public void setNoteTransazione(String noteTransazione) {
		this.noteTransazione = noteTransazione;
	}

	public String getLinkSitoWeb() {
		return linkSitoWeb;
	}

	public void setLinkSitoWeb(String linkSitoWeb) {
		this.linkSitoWeb = linkSitoWeb;
	}

	public String getNumeroAssistenza() {
		return numeroAssistenza;
	}

	public void setNumeroAssistenza(String numeroAssistenza) {
		this.numeroAssistenza = numeroAssistenza;
	}

	public String getFooterScontrino() {
		return footerScontrino;
	}

	public void setFooterScontrino(String footerScontrino) {
		this.footerScontrino = footerScontrino;
	}

	public String getIdTerminale() {
		return idTerminale;
	}

	public void setIdTerminale(String idTerminale) {
		this.idTerminale = idTerminale;
	}

	public String getAbi() {
		return abi;
	}

	public void setAbi(String abi) {
		this.abi = abi;
	}

	public String getCab() {
		return cab;
	}

	public void setCab(String cab) {
		this.cab = cab;
	}

	public String getNumeroOperazione() {
		return numeroOperazione;
	}

	public void setNumeroOperazione(String numeroOperazione) {
		this.numeroOperazione = numeroOperazione;
	}

	public String getIdAutorizzazione() {
		return idAutorizzazione;
	}

	public void setIdAutorizzazione(String idAutorizzazione) {
		this.idAutorizzazione = idAutorizzazione;
	}

	public String getIdTranPaymat() {
		return idTranPaymat;
	}

	public void setIdTranPaymat(String idTranPaymat) {
		this.idTranPaymat = idTranPaymat;
	}

	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getVariabile() {
		return variabile;
	}

	public void setVariabile(String variabile) {
		this.variabile = variabile;
	}

	public Tassa[] getTasse() {
		return tasse;
	}

	public void setTasse(Tassa[] tasse) {
		this.tasse = tasse;
	}

	public String getEseguitoDa() {
		return eseguitoDa;
	}

	public void setEseguitoDa(String eseguitoDa) {
		this.eseguitoDa = eseguitoDa;
	}

	public String getNumeroIPPS() {
		return numeroIPPS;
	}

	public void setNumeroIPPS(String numeroIPPS) {
		this.numeroIPPS = numeroIPPS;
	}

	public String getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Ticket [logoAziendale=" + logoAziendale + ", nomeEsercente=" + nomeEsercente + ", descrizioneProdotto=" + descrizioneProdotto + ", dataOraTransazione=" + dataOraTransazione + ", esitoTransazione=" + esitoTransazione + ", logoBrand="
				+ logoBrand + ", importoFacciale=" + importoFacciale + ", noteTransazione=" + noteTransazione + ", linkSitoWeb=" + linkSitoWeb + ", numeroAssistenza=" + numeroAssistenza + ", footerScontrino=" + footerScontrino + ", idTerminale="
				+ idTerminale + ", abi=" + abi + ", cab=" + cab + ", numeroOperazione=" + numeroOperazione + ", idAutorizzazione=" + idAutorizzazione + ", idTranPaymat=" + idTranPaymat + ", numeroTelefonico=" + numeroTelefonico + ", pin=" + pin
				+ ", variabile=" + variabile + ", tasse=" + Arrays.toString(tasse) + ", eseguitoDa=" + eseguitoDa + ", numeroIPPS=" + numeroIPPS + ", dataScadenza=" + dataScadenza + ", causale=" + causale + ", beneficiario=" + beneficiario  + ", serialNumber=" + serialNumber + "]";
	}

}
