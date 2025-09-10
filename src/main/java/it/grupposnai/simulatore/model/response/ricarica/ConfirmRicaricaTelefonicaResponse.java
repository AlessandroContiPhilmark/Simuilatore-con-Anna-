
package it.grupposnai.simulatore.model.response.ricarica;

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
 *         &lt;element name="confirmRicaricaTelefonicaResult" type="{http://ws.paymatservizi.it/}ConfirmRicaricaTelefonicaResponse" minOccurs="0"/&gt;
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
    "confirmRicaricaTelefonicaResult"
})
@XmlRootElement(name = "confirmRicaricaTelefonicaResponse")
public class ConfirmRicaricaTelefonicaResponse {

    protected ConfirmRicaricaTelefonicaResponse2 confirmRicaricaTelefonicaResult;

    /**
     * Recupera il valore della proprietà confirmRicaricaTelefonicaResult.
     * 
     * @return
     *     possible object is
     *     {@link ConfirmRicaricaTelefonicaResponse2 }
     *     
     */
    public ConfirmRicaricaTelefonicaResponse2 getConfirmRicaricaTelefonicaResult() {
        return confirmRicaricaTelefonicaResult;
    }

    /**
     * Imposta il valore della proprietà confirmRicaricaTelefonicaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfirmRicaricaTelefonicaResponse2 }
     *     
     */
    public void setConfirmRicaricaTelefonicaResult(ConfirmRicaricaTelefonicaResponse2 value) {
        this.confirmRicaricaTelefonicaResult = value;
    }

}
