package it.grupposnai.paymatservices.model.request.prodottiFinanziari.bollettino;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.CreditoManager;
import it.grupposnai.paymatservices.model.Bollettino;
import it.grupposnai.paymatservices.model.PersonaFisica;

@XmlType(name = "ReserveBollettinoRequest")
public class ReserveBollettinoRequest {

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
	private Bollettino bollettino;
	private PersonaFisica[] persone;
	private String codiceCredito;
	private String email;
	private String telefono;
	private String idPrenotazione;
	private Integer[] progressiviProdottoPrenotazione;

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

	public Bollettino getBollettino() {
		return bollettino;
	}

	public void setBollettino(Bollettino bollettino) {
		this.bollettino = bollettino;
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
	
	public String validate() {
		String validationErrors = "";
		if(StringUtils.isNotBlank(getCallerId()) && CreditoManager.getInstance().isCallerWithRequiredCodiceCredito(getCallerId()) && StringUtils.isBlank(getCodiceCredito()))
			validationErrors += " codiceCredito,";
		if(getBollettino() == null)
			validationErrors += " bollettino,";
		if(getBollettino() != null && !isLong(getBollettino().getNumeroCC()))
			validationErrors += " numeroCC formato non valido,";
		if (validationErrors.length() > 0)
			validationErrors = validationErrors.substring(0, validationErrors.length() - 1);
		else
			validationErrors = null;
		return validationErrors;
	}

	public String getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(String idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public Integer[] getProgressiviProdottoPrenotazione() {
		return progressiviProdottoPrenotazione;
	}

	public void setProgressiviProdottoPrenotazione(Integer[] progressiviProdottoPrenotazione) {
		this.progressiviProdottoPrenotazione = progressiviProdottoPrenotazione;
	}

	@Override
	public String toString() {
		return "ReserveBollettinoRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore
				+ ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab + ", idTerminale=" + idTerminale + ", bollettino=" + bollettino + ", persone=" + Arrays.toString(persone) + ", codiceCredito=" + codiceCredito + ", email=" + email
				+ ", telefono=" + telefono + ", idPrenotazione=" + idPrenotazione + ", progressiviProdottoPrenotazione=" + ( progressiviProdottoPrenotazione != null ? java.util.Arrays.toString(progressiviProdottoPrenotazione) : null ) + "]";
	}
	
	private boolean isLong(String s) {
		try {
			Long.parseLong(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
