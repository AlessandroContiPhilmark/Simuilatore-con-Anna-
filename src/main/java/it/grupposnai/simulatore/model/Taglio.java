
package it.grupposnai.simulatore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Taglio complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Taglio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codiceTaglio" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="Descrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Tipologia" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Taglio", propOrder = {
    "codiceTaglio",
    "descrizione",
    "tipologia",
    "importo",
    "valoreIva",
    "importoIva"
})
public class Taglio {

    protected int codiceTaglio;
    @XmlElement(name = "Descrizione")

    protected String descrizione;
    @XmlElement(name = "Tipologia")
    protected int tipologia;

    protected Integer importo;

    @XmlElement(name = "ValoreIva")
    protected String valoreIva;

    @XmlElement(name = "ImportoIva")
    protected Integer importoIva;
    /**
     * Recupera il valore della proprietà codiceTaglio.
     * 
     */
    public int getCodiceTaglio() {
        return codiceTaglio;
    }

    /**
     * Imposta il valore della proprietà codiceTaglio.
     * 
     */
    public void setCodiceTaglio(int value) {
        this.codiceTaglio = value;
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

    /**
     * Recupera il valore della proprietà importo.
     *
     */
	public Integer getImporto() {
		return importo;
	}

    /**
     * Imposta il valore della proprietà importo.
     *
     */
	public void setImporto(Integer importo) {
		this.importo = importo;
	}

    /**
     * Recupera il valore della proprietà valoreIva.
     *
     */
    public String getValoreIva() {
        return valoreIva;
    }

    /**
     * Imposta il valore della proprietà valoreIva.
     *
     */
    public void setValoreIva(String valoreIva) {
        this.valoreIva = valoreIva;
    }

    /**
     * Recupera il valore della proprietà importoIva.
     *
     */
    public Integer getImportoIva() {
        return importoIva;
    }

    /**
     * Imposta il valore della proprietà importoIva.
     *
     */
    public void setImportoIva(Integer importoIva) {
        this.importoIva = importoIva;
    }

    @Override
	public String toString() {
		return "Taglio [codiceTaglio=" + codiceTaglio + ", descrizione=" + descrizione + ", tipologia=" + tipologia
				+ ", importo=" + importo + ", valoreIva=" + valoreIva + ", importoIva=" + importoIva + "]";
	}

}
