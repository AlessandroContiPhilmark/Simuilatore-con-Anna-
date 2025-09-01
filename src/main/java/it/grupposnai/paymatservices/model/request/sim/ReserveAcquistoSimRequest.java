package it.grupposnai.paymatservices.model.request.sim;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.CreditoManager;
import it.grupposnai.paymatservices.model.Allegato;
import it.grupposnai.paymatservices.model.PersonaFisica;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReserveAcquistoSimRequest")
public class ReserveAcquistoSimRequest {

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
	private String codiceSim;
	private PersonaFisica persone[];
	private Allegato allegati[];
	private String codiceCredito;
	private Integer idBrand;
	private Integer idTaglio;
	private Integer adeguataVerifica;

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

	public String getCodiceSim() {
		return codiceSim;
	}

	public void setCodiceSim(String codiceSim) {
		this.codiceSim = codiceSim;
	}

	public PersonaFisica[] getPersone() {
		return persone;
	}

	public void setPersone(PersonaFisica[] persone) {
		this.persone = persone;
	}

	public Allegato[] getAllegati() {
		return allegati;
	}

	public void setAllegati(Allegato[] allegati) {
		this.allegati = allegati;
	}

	public String getCodiceCredito() {
		return codiceCredito;
	}

	public void setCodiceCredito(String codiceCredito) {
		this.codiceCredito = codiceCredito;
	}

	public Integer getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(Integer idBrand) {
		this.idBrand = idBrand;
	}

	public Integer getIdTaglio() {
		return idTaglio;
	}

	public void setIdTaglio(Integer idTaglio) {
		this.idTaglio = idTaglio;
	}

	public Integer getAdeguataVerifica() {
		return adeguataVerifica;
	}

	public void setAdeguataVerifica(Integer adeguataVerifica) {
		this.adeguataVerifica = adeguataVerifica;
	}

	public String validate() {
		String validationErrors = "";
		if (StringUtils.isNotBlank(getCallerId()) && CreditoManager.getInstance().isCallerWithRequiredCodiceCredito(getCallerId()) && StringUtils.isBlank(getCodiceCredito()))
			validationErrors += " codiceCredito,";
		if (persone == null || persone.length == 0)
			validationErrors += " persone,";
		if (adeguataVerifica == null || adeguataVerifica.intValue() != 1)
			validationErrors += " adeguataVerifica deve essere 1,";
		if (validationErrors.length() > 0)
			validationErrors = validationErrors.substring(0, validationErrors.length() - 1);
		else
			validationErrors = null;
		return validationErrors;
	}

	@Override
	public String toString() {
		return "ReserveAcquistoSimRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab
				+ ", idTerminale=" + idTerminale + ", codiceSim=" + codiceSim + ", persone=" + Arrays.toString(persone) + ", allegati=" + Arrays.toString(allegati) + ", codiceCredito=" + codiceCredito + ", idBrand=" + idBrand + ", idTaglio=" + idTaglio + ", adeguataVerifica=" + adeguataVerifica
				+ "]";
	}

}
