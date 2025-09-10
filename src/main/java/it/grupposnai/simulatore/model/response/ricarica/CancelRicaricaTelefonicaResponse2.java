
package it.grupposnai.simulatore.model.response.ricarica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per CancelRicaricaTelefonicaResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="CancelRicaricaTelefonicaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://ws.paymatservizi.it/}GenericResponse"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelRicaricaTelefonicaResponse")
public class CancelRicaricaTelefonicaResponse2
    extends GenericResponse
{

	@Override
	public String toString() {
		return "CancelRicaricaTelefonicaResponse2 [callerId=" + callerId + ", requestId=" + requestId + ", resultCode="
				+ resultCode + ", resultDesc=" + resultDesc + "]";
	}


}
