
package it.grupposnai.simulatore.model.request.ricarica;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.CreditoManager;
import it.grupposnai.simulatore.model.PersonaFisica;

/**
 * <p>
 * Classe Java per ReserveRicaricaTelefonicaRequest complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ReserveRicaricaTelefonicaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAziendaDistributore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAziendaEsercente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cab" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTerminale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numeroTelefonico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taglio" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="importo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReserveRicaricaTelefonicaRequest", propOrder = { "idAziendaDistributore", "idAziendaEsercente", "cab", "idTerminale", "brand", "numeroTelefonico", "taglio", "importo", "var", "email",
		"telefono", "persone", "codiceCredito" })
public class ReserveRicaricaTelefonicaRequest extends GenericRequest {

	protected String idAziendaDistributore;
	protected String idAziendaEsercente;
	protected String cab;
	protected String idTerminale;
	protected int brand;
	protected String numeroTelefonico;
	protected int taglio;
	protected int importo;
	protected String var;
	protected String email;
	protected String telefono;
	protected PersonaFisica[] persone;
	protected String codiceCredito;

	/**
	 * Recupera il valore della proprietà idAziendaDistributore.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdAziendaDistributore() {
		return idAziendaDistributore;
	}

	/**
	 * Imposta il valore della proprietà idAziendaDistributore.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdAziendaDistributore(String value) {
		this.idAziendaDistributore = value;
	}

	/**
	 * Recupera il valore della proprietà idAziendaEsercente.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdAziendaEsercente() {
		return idAziendaEsercente;
	}

	/**
	 * Imposta il valore della proprietà idAziendaEsercente.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdAziendaEsercente(String value) {
		this.idAziendaEsercente = value;
	}

	/**
	 * Recupera il valore della proprietà cab.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCab() {
		return cab;
	}

	/**
	 * Imposta il valore della proprietà cab.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCab(String value) {
		this.cab = value;
	}

	/**
	 * Recupera il valore della proprietà idTerminale.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdTerminale() {
		return idTerminale;
	}

	/**
	 * Imposta il valore della proprietà idTerminale.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdTerminale(String value) {
		this.idTerminale = value;
	}

	/**
	 * Recupera il valore della proprietà brand.
	 * 
	 */
	public int getBrand() {
		return brand;
	}

	/**
	 * Imposta il valore della proprietà brand.
	 * 
	 */
	public void setBrand(int value) {
		this.brand = value;
	}

	/**
	 * Recupera il valore della proprietà numeroTelefonico.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}

	/**
	 * Imposta il valore della proprietà numeroTelefonico.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNumeroTelefonico(String value) {
		this.numeroTelefonico = value;
	}

	/**
	 * Recupera il valore della proprietà taglio.
	 * 
	 */
	public int getTaglio() {
		return taglio;
	}

	/**
	 * Imposta il valore della proprietà taglio.
	 * 
	 */
	public void setTaglio(int value) {
		this.taglio = value;
	}

	/**
	 * Recupera il valore della proprietà importo.
	 * 
	 */
	public int getImporto() {
		return importo;
	}

	/**
	 * Imposta il valore della proprietà importo.
	 * 
	 */
	public void setImporto(int value) {
		this.importo = value;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public PersonaFisica[] getPersone() {
		return persone;
	}

	public void setPersone(PersonaFisica[] persone) {
		this.persone = persone;
	}

	public String validate() {
		String validationErrors = "";
		// if(StringUtils.isBlank(getCallerId())) validationErrors+= " callerId,";
		// if(StringUtils.isBlank(getRequestId())) validationErrors+= " requestId,";
		// if(StringUtils.isBlank(getSkin())) validationErrors+= " skin,";
		if (StringUtils.isBlank(getUserIP()))
			validationErrors += " userIp,";
		// if(StringUtils.isBlank(getFirma())) validationErrors+= " firma,";
		// if(StringUtils.isBlank(getToken())) validationErrors+= " token,";
		// if(StringUtils.isBlank(getIdAziendaDistributore())) validationErrors+= " idAziendaDistributore,";
		// if(StringUtils.isBlank(getIdTerminale())) validationErrors+= " idTerminale,";
		// if(StringUtils.isBlank(getNumeroTelefonico())) validationErrors+= " numeroTelefonico,";
		if(StringUtils.isNotBlank(getCallerId()) && CreditoManager.getInstance().isCallerWithRequiredCodiceCredito(getCallerId()) && StringUtils.isBlank(getCodiceCredito()))
			validationErrors += " codiceCredito,";
		if (validationErrors.length() > 0)
			validationErrors = validationErrors.substring(0, validationErrors.length() - 1);
		else
			validationErrors = null;
		return validationErrors;
	}

	public String getCodiceCredito() {
		return codiceCredito;
	}

	public void setCodiceCredito(String codiceCredito) {
		this.codiceCredito = codiceCredito;
	}

	@Override
	public String toString() {
		return "ReserveRicaricaTelefonicaRequest [idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab + ", idTerminale=" + idTerminale
				+ ", brand=" + brand + ", numeroTelefonico=" + numeroTelefonico + ", taglio=" + taglio + ", importo=" + importo + ", var=" + var + ", email=" + email + ", telefono=" + telefono
				+ ", persone=" + Arrays.toString(persone) + ", codiceCredito=" + codiceCredito + ", callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIP=" + userIP
				+ ", firma=" + firma + ", token=" + token + "]";
	}

}
