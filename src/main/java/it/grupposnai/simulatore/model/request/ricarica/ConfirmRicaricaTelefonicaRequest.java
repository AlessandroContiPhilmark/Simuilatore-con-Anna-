
package it.grupposnai.simulatore.model.request.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.CreditoManager;

/**
 * <p>
 * Classe Java per ConfirmRicaricaTelefonicaRequest complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ConfirmRicaricaTelefonicaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAziendaDistributore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAziendaEsercente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cab" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idterminale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reserveRequestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="brand" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmRicaricaTelefonicaRequest", propOrder = { "idAziendaDistributore", "idAziendaEsercente", "cab", "idterminale", "reserveRequestId", "brand", "var", "codiceCredito" })
public class ConfirmRicaricaTelefonicaRequest extends GenericRequest {

	protected String idAziendaDistributore;
	protected String idAziendaEsercente;
	protected String cab;
	protected String idterminale;
	protected String reserveRequestId;
	protected int brand;
	protected String var;
	private String codiceCredito;

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
	 * Recupera il valore della proprietà idterminale.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIdterminale() {
		return idterminale;
	}

	/**
	 * Imposta il valore della proprietà idterminale.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdterminale(String value) {
		this.idterminale = value;
	}

	/**
	 * Recupera il valore della proprietà reserveRequestId.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReserveRequestId() {
		return reserveRequestId;
	}

	/**
	 * Imposta il valore della proprietà reserveRequestId.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setReserveRequestId(String value) {
		this.reserveRequestId = value;
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

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
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
		// if(StringUtils.isBlank(getIdterminale())) validationErrors+= " idTerminale,";
		// if(StringUtils.isBlank(getReserveRequestId())) validationErrors+= " reserveRequestId,";
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
		return "ConfirmRicaricaTelefonicaRequest [idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab + ", idterminale=" + idterminale
				+ ", reserveRequestId=" + reserveRequestId + ", brand=" + brand + ", var=" + var + ", codiceCredito=" + codiceCredito + ", callerId=" + callerId + ", requestId=" + requestId
				+ ", skin=" + skin + ", userIP=" + userIP + ", firma=" + firma + ", token=" + token + "]";
	}

}
