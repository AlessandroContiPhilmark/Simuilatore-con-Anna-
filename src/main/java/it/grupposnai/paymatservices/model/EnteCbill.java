package it.grupposnai.paymatservices.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnteCbill")
public class EnteCbill {

	private String nome;
	private String codiceSia;
	private String codiceCuc;
	private String idNazionale;
	private Integer abilitazioneRicercaBollettini;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceSia() {
		return codiceSia;
	}

	public void setCodiceSia(String codiceSia) {
		this.codiceSia = codiceSia;
	}

	public String getCodiceCuc() {
		return codiceCuc;
	}

	public void setCodiceCuc(String codiceCuc) {
		this.codiceCuc = codiceCuc;
	}

	public String getIdNazionale() {
		return idNazionale;
	}

	public void setIdNazionale(String idNazionale) {
		this.idNazionale = idNazionale;
	}

	public Integer getAbilitazioneRicercaBollettini() {
		return abilitazioneRicercaBollettini;
	}

	public void setAbilitazioneRicercaBollettini(Integer abilitazioneRicercaBollettini) {
		this.abilitazioneRicercaBollettini = abilitazioneRicercaBollettini;
	}

	@Override
	public String toString() {
		return "EnteCbill [nome=" + nome + ", codiceSia=" + codiceSia + ", codiceCuc=" + codiceCuc + ", idNazionale=" + idNazionale + ", abilitazioneRicercaBollettini="
				+ abilitazioneRicercaBollettini + "]";
	}
}
