
package it.grupposnai.paymatservices.model.response.ricarica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.Taglio;


/**
 * <p>Classe Java per ArrayOfTaglio complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTaglio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Taglio" type="{http://ws.paymatservizi.it/}Taglio" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTaglio", propOrder = {
    "taglio"
})
public class ArrayOfTaglio {

    @XmlElement(name = "Taglio", nillable = true)
    protected List<Taglio> taglio = new ArrayList<Taglio>();

    /**
     * Gets the value of the taglio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taglio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaglio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Taglio }
     * 
     * 
     */
    public List<Taglio> getTaglio() {
        if (taglio == null) {
            taglio = new ArrayList<Taglio>();
        }
        return this.taglio;
    }

	@Override
	public String toString() {
		return "ArrayOfTaglio [taglio=" + taglio + "]";
	}

}
