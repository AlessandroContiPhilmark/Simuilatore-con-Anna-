
package it.grupposnai.simulatore.model.request.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.CreditoManager;

/**
 * <p>
 * Classe Java per CancelRicaricaTelefonicaRequest complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CancelRicaricaTelefonicaRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAziendaDistributore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAziendaEsercente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "CancelRicaricaTelefonicaRequest", propOrder = { "idAziendaDistributore", "idAziendaEsercente", "reserveRequestId", "brand", "codiceCredito", "idTerminale" })
public class CancelRicaricaTelefonicaRequest extends GenericRequest {

	protected String idAziendaDistributore;
	protected String idAziendaEsercente;
	protected String reserveRequestId;
	protected int brand;
	private String codiceCredito;
	private String idTerminale;

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
	 * @param value allowed object is {@link String }
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
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setIdAziendaEsercente(String value) {
		this.idAziendaEsercente = value;
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
	 * @param value allowed object is {@link String }
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

	public String getCodiceCredito() {
		return codiceCredito;
	}

	public void setCodiceCredito(String codiceCredito) {
		this.codiceCredito = codiceCredito;
	}

	public String getIdTerminale() {
		return idTerminale;
	}

	public void setIdTerminale(String idTerminale) {
		this.idTerminale = idTerminale;
	}

	public String validate() {
		String validationErrors = "";
		if (StringUtils.isNotBlank(getCallerId()) && CreditoManager.getInstance().isCallerWithRequiredCodiceCredito(getCallerId()) && StringUtils.isBlank(getCodiceCredito()))
			validationErrors += " codiceCredito,";
		if (validationErrors.length() > 0)
			validationErrors = validationErrors.substring(0, validationErrors.length() - 1);
		else
			validationErrors = null;
		return validationErrors;
	}

	@Override
	public String toString() {
		return "CancelRicaricaTelefonicaRequest [idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", reserveRequestId=" + reserveRequestId + ", brand=" + brand + ", codiceCredito=" + codiceCredito
				+ ", idTerminale=" + idTerminale + "]";
	}

}
