
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
 *         &lt;element name="infoBrandRicaricheResult" type="{http://ws.paymatservizi.it/}InfoBrandRicaricheResponse" minOccurs="0"/&gt;
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
    "infoBrandRicaricheResult"
})
@XmlRootElement(name = "infoBrandRicaricheResponse")
public class InfoBrandRicaricheResponse {

    protected InfoBrandRicaricheResponse2 infoBrandRicaricheResult;

    /**
     * Recupera il valore della proprietà infoBrandRicaricheResult.
     * 
     * @return
     *     possible object is
     *     {@link InfoBrandRicaricheResponse2 }
     *     
     */
    public InfoBrandRicaricheResponse2 getInfoBrandRicaricheResult() {
        return infoBrandRicaricheResult;
    }

    /**
     * Imposta il valore della proprietà infoBrandRicaricheResult.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoBrandRicaricheResponse2 }
     *     
     */
    public void setInfoBrandRicaricheResult(InfoBrandRicaricheResponse2 value) {
        this.infoBrandRicaricheResult = value;
    }

}
