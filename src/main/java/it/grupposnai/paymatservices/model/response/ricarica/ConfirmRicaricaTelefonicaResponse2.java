
package it.grupposnai.paymatservices.model.response.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ConfirmRicaricaTelefonicaResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ConfirmRicaricaTelefonicaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idTranPaymat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ticket" type="{http://ws.paymatservizi.it/}Ticket" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmRicaricaTelefonicaResponse", propOrder = {
    "idTranPaymat",
    "ticket"
})
public class ConfirmRicaricaTelefonicaResponse2
    extends GenericResponse
{

    protected String idTranPaymat;
    protected Ticket ticket;

    /**
     * Recupera il valore della proprietà idTranPaymat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTranPaymat() {
        return idTranPaymat;
    }

    /**
     * Imposta il valore della proprietà idTranPaymat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTranPaymat(String value) {
        this.idTranPaymat = value;
    }

    /**
     * Recupera il valore della proprietà ticket.
     * 
     * @return
     *     possible object is
     *     {@link Ticket }
     *     
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Imposta il valore della proprietà ticket.
     * 
     * @param value
     *     allowed object is
     *     {@link Ticket }
     *     
     */
    public void setTicket(Ticket value) {
        this.ticket = value;
    }

	@Override
	public String toString() {
		return "ConfirmRicaricaTelefonicaResponse2 [idTranPaymat=" + idTranPaymat + ", ticket=" + ticket + ", callerId="
				+ callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc
				+ "]";
	}

}
