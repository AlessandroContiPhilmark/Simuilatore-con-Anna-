
package it.grupposnai.paymatservices.model.request.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per InfoBrandRicaricheRequest complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="InfoBrandRicaricheRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAziendaDistributore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAziendaEsercente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoBrandRicaricheRequest", propOrder = {
    "idAziendaDistributore",
    "idAziendaEsercente"
})
public class InfoBrandRicaricheRequest
    extends GenericRequest
{

    protected String idAziendaDistributore;
    protected String idAziendaEsercente;

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

	@Override
	public String toString() {
		return "InfoBrandRicaricheRequest [idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente="
				+ idAziendaEsercente + ", callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin
				+ ", userIP=" + userIP + ", firma=" + firma + ", token=" + token + "]";
	}

}
