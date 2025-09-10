package it.grupposnai.simulatore.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonaFisica")
public class PersonaFisica {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String dataNascita;
	private String tipoDocumento;
	private String numeroDocumento;
	private String dataScadenzaDocumento;
	private String indirizzo;
	private String infoAddizionaliIndirizzo;
	private String toponimo;
	private String nomeStrada;
	private String numeroCivico;
	private String cap;
	private String frazione;
	private String citta;
	private String provincia;
	private String nazione;
	private String email;
	private String telefono;
	private Integer sesso;
	private Integer codicePersonaFisica;
	private Integer tipopersona;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getDataScadenzaDocumento() {
		return dataScadenzaDocumento;
	}

	public void setDataScadenzaDocumento(String dataScadenzaDocumento) {
		this.dataScadenzaDocumento = dataScadenzaDocumento;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getCodicePersonaFisica() {
		return codicePersonaFisica;
	}

	public void setCodicePersonaFisica(Integer codicePersonaFisica) {
		this.codicePersonaFisica = codicePersonaFisica;
	}

	public Integer getTipopersona() {
		return tipopersona;
	}

	public void setTipopersona(Integer tipopersona) {
		this.tipopersona = tipopersona;
	}

	public String getToponimo() {
		return toponimo;
	}

	public void setToponimo(String toponimo) {
		this.toponimo = toponimo;
	}

	public String getNomeStrada() {
		return nomeStrada;
	}

	public void setNomeStrada(String nomeStrada) {
		this.nomeStrada = nomeStrada;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public Integer getSesso() {
		return sesso;
	}

	public void setSesso(Integer sesso) {
		this.sesso = sesso;
	}

	public String getInfoAddizionaliIndirizzo() {
		return infoAddizionaliIndirizzo;
	}

	public void setInfoAddizionaliIndirizzo(String infoAddizionaliIndirizzo) {
		this.infoAddizionaliIndirizzo = infoAddizionaliIndirizzo;
	}

	public String getFrazione() {
		return frazione;
	}

	public void setFrazione(String frazione) {
		this.frazione = frazione;
	}

	@Override
	public String toString() {
		return "PersonaFisica [nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale + ", dataNascita=" + dataNascita + ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", dataScadenzaDocumento=" + dataScadenzaDocumento + ", indirizzo=" + indirizzo
				+ ", infoAddizionaliIndirizzo=" + infoAddizionaliIndirizzo + ", toponimo=" + toponimo + ", nomeStrada=" + nomeStrada + ", numeroCivico=" + numeroCivico + ", cap=" + cap + ", frazione=" + frazione + ", citta=" + citta + ", provincia=" + provincia + ", nazione=" + nazione + ", email="
				+ email + ", telefono=" + telefono + ", sesso=" + sesso + ", codicePersonaFisica=" + codicePersonaFisica + ", tipopersona=" + tipopersona + "]";
	}

}
