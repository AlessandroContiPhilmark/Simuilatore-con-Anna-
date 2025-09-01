package it.grupposnai.paymatservices.model.request.prodottiFinanziari.postePay;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.CreditoManager;
import it.grupposnai.paymatservices.model.Allegato;
import it.grupposnai.paymatservices.model.PersonaFisica;

@XmlType(name = "ReservePostePayRequest")
public class ReservePostePayRequest {

	private String callerId;
	private String requestId;
	private String skin;
	private String userIp;
	private String firma;
	private String token;
	private String idAziendaDistributore;
	private String idAziendaEsercente;
	private String cab;
	private String idTerminale;
	private Integer importoRicarica;
	private String numeroPostePay;
	private String email;
	private String telefono;
	private Integer accettazioneConsenso;
	private Allegato[] allegati;
	private PersonaFisica[] persone;
	private String codiceCredito;

	public String getCallerId() {
		return callerId;
	}

	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIdAziendaDistributore() {
		return idAziendaDistributore;
	}

	public void setIdAziendaDistributore(String idAziendaDistributore) {
		this.idAziendaDistributore = idAziendaDistributore;
	}

	public String getIdAziendaEsercente() {
		return idAziendaEsercente;
	}

	public void setIdAziendaEsercente(String idAziendaEsercente) {
		this.idAziendaEsercente = idAziendaEsercente;
	}

	public String getCab() {
		return cab;
	}

	public void setCab(String cab) {
		this.cab = cab;
	}

	public String getIdTerminale() {
		return idTerminale;
	}

	public void setIdTerminale(String idTerminale) {
		this.idTerminale = idTerminale;
	}

	public Integer getImportoRicarica() {
		return importoRicarica;
	}

	public void setImportoRicarica(Integer importoRicarica) {
		this.importoRicarica = importoRicarica;
	}

	public String getNumeroPostePay() {
		return numeroPostePay;
	}

	public void setNumeroPostePay(String numeroPostePay) {
		this.numeroPostePay = numeroPostePay;
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

	public Integer getAccettazioneConsenso() {
		return accettazioneConsenso;
	}

	public void setAccettazioneConsenso(Integer accettazioneConsenso) {
		this.accettazioneConsenso = accettazioneConsenso;
	}

	public Allegato[] getAllegati() {
		return allegati;
	}

	public void setAllegati(Allegato[] allegati) {
		this.allegati = allegati;
	}

	public PersonaFisica[] getPersone() {
		return persone;
	}

	public void setPersone(PersonaFisica[] persone) {
		this.persone = persone;
	}

	public String getCodiceCredito() {
		return codiceCredito;
	}

	public void setCodiceCredito(String codiceCredito) {
		this.codiceCredito = codiceCredito;
	}
	
	public String validate() {
		String validationErrors = "";
		if (StringUtils.isNotBlank(getCallerId()) && CreditoManager.getInstance().isCallerWithRequiredCodiceCredito(getCallerId()) && StringUtils.isBlank(getCodiceCredito()))
			validationErrors += " codiceCredito,";
		if (validationErrors.length() > 0)
			validationErrors = validationErrors.substring(0, validationErrors.length() - 1);
		else
			validationErrors = null;
		return validationErrors;
	}

	@Override
	public String toString() {
		return "ReservePostePayRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token
				+ ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab + ", idTerminale=" + idTerminale + ", importoRicarica="
				+ importoRicarica + ", numeroPostePay=" + numeroPostePay + ", email=" + email + ", telefono=" + telefono + ", accettazioneConsenso=" + accettazioneConsenso + ", allegati="
				+ Arrays.toString(allegati) + ", persone=" + Arrays.toString(persone) + ", codiceCredito=" + codiceCredito + "]";
	}

}
