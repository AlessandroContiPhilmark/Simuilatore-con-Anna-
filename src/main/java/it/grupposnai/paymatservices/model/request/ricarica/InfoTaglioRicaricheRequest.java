
package it.grupposnai.paymatservices.model.request.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per InfoTaglioRicaricheRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="InfoTaglioRicaricheRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAziendaDistributore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAziendaEsercente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idBrand" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoTaglioRicaricheRequest", propOrder = {
    "idAziendaDistributore",
    "idAziendaEsercente",
    "idBrand",
    "numeroTelefonico"
})
public class InfoTaglioRicaricheRequest
    extends GenericRequest
{

    protected String idAziendaDistributore;
    protected String idAziendaEsercente;
    protected int idBrand;
    protected String numeroTelefonico;

    /**
     * Recupera il valore della proprietà idAziendaDistributore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAziendaDistributore() {
        return idAziendaDistributore;
    }

    /**
     * Imposta il valore della proprietà idAziendaDistributore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAziendaDistributore(String value) {
        this.idAziendaDistributore = value;
    }

    /**
     * Recupera il valore della proprietà idAziendaEsercente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAziendaEsercente() {
        return idAziendaEsercente;
    }

    /**
     * Imposta il valore della proprietà idAziendaEsercente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAziendaEsercente(String value) {
        this.idAziendaEsercente = value;
    }

    /**
     * Recupera il valore della proprietà idBrand.
     * 
     */
    public int getIdBrand() {
        return idBrand;
    }

    /**
     * Imposta il valore della proprietà idBrand.
     * 
     */
    public void setIdBrand(int value) {
        this.idBrand = value;
    }
    
    /**
     * Recupera il valore della proprietà numeroTelefonico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    /**
     * Imposta il valore della proprietà numeroTelefonico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTelefonico(String value) {
        this.numeroTelefonico = value;
    }

	@Override
	public String toString() {
		return "InfoTaglioRicaricheRequest [idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", idBrand=" + idBrand
				+ ", numeroTelefonico=" + numeroTelefonico + ", callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIP=" + userIP + ", firma=" + firma
				+ ", token=" + token + "]";
	}

}
