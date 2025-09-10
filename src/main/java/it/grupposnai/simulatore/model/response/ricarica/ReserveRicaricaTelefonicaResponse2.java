
package it.grupposnai.simulatore.model.response.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ReserveRicaricaTelefonicaResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ReserveRicaricaTelefonicaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idTranPaymat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTranEsterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReserveRicaricaTelefonicaResponse", propOrder = {
    "idTranPaymat",
    "idTranEsterno"
})
public class ReserveRicaricaTelefonicaResponse2
    extends GenericResponse
{

    protected String idTranPaymat;
    protected String idTranEsterno;

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
     * Recupera il valore della proprietà idTranEsterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTranEsterno() {
        return idTranEsterno;
    }

    /**
     * Imposta il valore della proprietà idTranEsterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTranEsterno(String value) {
        this.idTranEsterno = value;
    }

	@Override
	public String toString() {
		return "ReserveRicaricaTelefonicaResponse2 [idTranPaymat=" + idTranPaymat + ", idTranEsterno=" + idTranEsterno
				+ ", callerId=" + callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc="
				+ resultDesc + "]";
	}

}
