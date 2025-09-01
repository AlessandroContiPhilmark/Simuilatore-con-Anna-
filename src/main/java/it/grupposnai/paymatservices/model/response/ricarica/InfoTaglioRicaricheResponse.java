
package it.grupposnai.paymatservices.model.response.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per InfoTaglioRicaricheResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="InfoTaglioRicaricheResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idBrand" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="listaTagli" type="{http://ws.paymatservizi.it/}ArrayOfTaglio" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoTaglioRicaricheResponse", propOrder = {
    "idBrand",
    "listaTagli"
})
public class InfoTaglioRicaricheResponse
    extends GenericResponse
{

    protected int idBrand;
    protected ArrayOfTaglio listaTagli = new ArrayOfTaglio();

    /**
     * Recupera il valore della proprietà idBrand.
     * 
     */
    public int getIdBrand() {
        return idBrand;
    }

    /**
     * Imposta il valore della proprietà idBrand.
     * 
     */
    public void setIdBrand(int value) {
        this.idBrand = value;
    }

    /**
     * Recupera il valore della proprietà listaTagli.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTaglio }
     *     
     */
    public ArrayOfTaglio getListaTagli() {
        return listaTagli;
    }

    /**
     * Imposta il valore della proprietà listaTagli.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTaglio }
     *     
     */
    public void setListaTagli(ArrayOfTaglio value) {
        this.listaTagli = value;
    }

	@Override
	public String toString() {
		return "InfoTaglioRicaricheResponse [idBrand=" + idBrand + ", listaTagli=" + listaTagli + ", callerId="
				+ callerId + ", requestId=" + requestId + ", resultCode=" + resultCode + ", resultDesc=" + resultDesc
				+ "]";
	}

}
