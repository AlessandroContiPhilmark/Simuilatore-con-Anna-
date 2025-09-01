
package it.grupposnai.paymatservices.model.response.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per GenericResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="GenericResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="callerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="resultDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericResponse", propOrder = {
    "callerId",
    "requestId",
    "resultCode",
    "resultDesc"
})
@XmlSeeAlso({
    ReserveRicaricaTelefonicaResponse2 .class,
    ConfirmRicaricaTelefonicaResponse2 .class,
    CancelRicaricaTelefonicaResponse2 .class,
    InfoBrandRicaricheResponse2 .class,
    InfoTaglioRicaricheResponse.class
})
public class GenericResponse {

    protected String callerId;
    protected String requestId;
    protected String resultCode;
    protected String resultDesc;

    /**
     * Recupera il valore della proprietà callerId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallerId() {
        return callerId;
    }

    /**
     * Imposta il valore della proprietà callerId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallerId(String value) {
        this.callerId = value;
    }

    /**
     * Recupera il valore della proprietà requestId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Imposta il valore della proprietà requestId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Recupera il valore della proprietà resultCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * Imposta il valore della proprietà resultCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultCode(String value) {
        this.resultCode = value;
    }

    /**
     * Recupera il valore della proprietà resultDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultDesc() {
        return resultDesc;
    }

    /**
     * Imposta il valore della proprietà resultDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultDesc(String value) {
        this.resultDesc = value;
    }

}
