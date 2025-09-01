
package it.grupposnai.paymatservices.model.response.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infoTagliRicaricheResult" type="{http://ws.paymatservizi.it/}InfoTaglioRicaricheResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "infoTagliRicaricheResult"
})
@XmlRootElement(name = "infoTagliRicaricheResponse")
public class InfoTagliRicaricheResponse {

    protected InfoTaglioRicaricheResponse infoTagliRicaricheResult;

    /**
     * Recupera il valore della proprietà infoTagliRicaricheResult.
     * 
     * @return
     *     possible object is
     *     {@link InfoTaglioRicaricheResponse }
     *     
     */
    public InfoTaglioRicaricheResponse getInfoTagliRicaricheResult() {
        return infoTagliRicaricheResult;
    }

    /**
     * Imposta il valore della proprietà infoTagliRicaricheResult.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoTaglioRicaricheResponse }
     *     
     */
    public void setInfoTagliRicaricheResult(InfoTaglioRicaricheResponse value) {
        this.infoTagliRicaricheResult = value;
    }

}
