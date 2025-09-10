
package it.grupposnai.simulatore.model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Brand complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Brand"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceBrand" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="descrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipologia" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Brand", propOrder = {
    "codiceBrand",
    "descrizione",
    "tipologia",
    "categorie"
})
public class Brand {

    protected int codiceBrand;
    protected String descrizione;
    protected int tipologia;
    private String[] categorie;

    /**
     * Recupera il valore della proprietà codiceBrand.
     * 
     */
    public int getCodiceBrand() {
        return codiceBrand;
    }

    /**
     * Imposta il valore della proprietà codiceBrand.
     * 
     */
    public void setCodiceBrand(int value) {
        this.codiceBrand = value;
    }

    /**
     * Recupera il valore della proprietà descrizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Imposta il valore della proprietà descrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizione(String value) {
        this.descrizione = value;
    }

    /**
     * Recupera il valore della proprietà tipologia.
     * 
     */
    public int getTipologia() {
        return tipologia;
    }

    /**
     * Imposta il valore della proprietà tipologia.
     * 
     */
    public void setTipologia(int value) {
        this.tipologia = value;
    }
    
	public String[] getCategorie() {
		return categorie;
	}

	public void setCategorie(String[] categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Brand [codiceBrand=" + codiceBrand + ", descrizione=" + descrizione + ", tipologia=" + tipologia + ", categorie=" + Arrays.toString(categorie) + "]";
	}
	

}
