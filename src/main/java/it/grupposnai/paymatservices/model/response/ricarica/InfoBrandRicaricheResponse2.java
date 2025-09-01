
package it.grupposnai.paymatservices.model.response.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per InfoBrandRicaricheResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="InfoBrandRicaricheResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="listaBrand" type="{http://ws.paymatservizi.it/}ArrayOfBrand" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoBrandRicaricheResponse", propOrder = {
    "listaBrand"
})
public class InfoBrandRicaricheResponse2
    extends GenericResponse
{

    protected ArrayOfBrand listaBrand = new ArrayOfBrand();

    /**
     * Recupera il valore della proprietà listaBrand.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBrand }
     *     
     */
    public ArrayOfBrand getListaBrand() {
        return listaBrand;
    }

    /**
     * Imposta il valore della proprietà listaBrand.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBrand }
     *     
     */
    public void setListaBrand(ArrayOfBrand value) {
        this.listaBrand = value;
    }

	@Override
	public String toString() {
		return "InfoBrandRicaricheResponse2 [listaBrand=" + listaBrand + ", callerId=" + callerId + ", requestId="
				+ requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc + "]";
	}

}
