
package it.grupposnai.paymatservices.model.response.ricarica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.Brand;


/**
 * <p>Classe Java per ArrayOfBrand complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBrand"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Brand" type="{http://ws.paymatservizi.it/}Brand" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBrand", propOrder = {
    "brand"
})
public class ArrayOfBrand {

    @XmlElement(name = "Brand", nillable = true)
    protected List<Brand> brand = new ArrayList<Brand>();

    /**
     * Gets the value of the brand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the brand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBrand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Brand }
     * 
     * 
     */
    public List<Brand> getBrand() {
        if (brand == null) {
            brand = new ArrayList<Brand>();
        }
        return this.brand;
    }

}
