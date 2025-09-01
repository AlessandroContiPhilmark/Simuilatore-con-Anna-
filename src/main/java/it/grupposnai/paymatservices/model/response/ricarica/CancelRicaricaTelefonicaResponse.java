
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
 *         &lt;element name="cancelRicaricaTelefonicaResult" type="{http://ws.paymatservizi.it/}CancelRicaricaTelefonicaResponse" minOccurs="0"/&gt;
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
    "cancelRicaricaTelefonicaResult"
})
@XmlRootElement(name = "cancelRicaricaTelefonicaResponse")
public class CancelRicaricaTelefonicaResponse {

    protected CancelRicaricaTelefonicaResponse2 cancelRicaricaTelefonicaResult;

    /**
     * Recupera il valore della proprietà cancelRicaricaTelefonicaResult.
     * 
     * @return
     *     possible object is
     *     {@link CancelRicaricaTelefonicaResponse2 }
     *     
     */
    public CancelRicaricaTelefonicaResponse2 getCancelRicaricaTelefonicaResult() {
        return cancelRicaricaTelefonicaResult;
    }

    /**
     * Imposta il valore della proprietà cancelRicaricaTelefonicaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelRicaricaTelefonicaResponse2 }
     *     
     */
    public void setCancelRicaricaTelefonicaResult(CancelRicaricaTelefonicaResponse2 value) {
        this.cancelRicaricaTelefonicaResult = value;
    }

}
