
package it.grupposnai.paymatservices.model.request.ricarica;

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
 *         &lt;element name="request" type="{http://ws.paymatservizi.it/}ReserveRicaricaTelefonicaRequest" minOccurs="0"/&gt;
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
    "request"
})
@XmlRootElement(name = "reserveRicaricaTelefonica")
public class ReserveRicaricaTelefonica {

    protected ReserveRicaricaTelefonicaRequest request;

    /**
     * Recupera il valore della proprietà request.
     * 
     * @return
     *     possible object is
     *     {@link ReserveRicaricaTelefonicaRequest }
     *     
     */
    public ReserveRicaricaTelefonicaRequest getRequest() {
        return request;
    }

    /**
     * Imposta il valore della proprietà request.
     * 
     * @param value
     *     allowed object is
     *     {@link ReserveRicaricaTelefonicaRequest }
     *     
     */
    public void setRequest(ReserveRicaricaTelefonicaRequest value) {
        this.request = value;
    }

}
