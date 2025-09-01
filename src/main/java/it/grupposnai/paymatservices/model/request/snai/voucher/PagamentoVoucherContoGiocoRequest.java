package it.grupposnai.paymatservices.model.request.snai.voucher;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatcore.utils.Costanti;
import it.grupposnai.paymatservices.model.PersonaFisica;
import it.grupposnai.paymatservices.model.request.Request;
import it.grupposnai.paymatservices.util.Validation;

@XmlType(name = "PagamentoVoucherContoGiocoRequest")
public class PagamentoVoucherContoGiocoRequest implements Request {

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
	private PersonaFisica[] persone;
	private String email;
	private String telefono;
	private String idTransazione;
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

	public PersonaFisica[] getPersone() {
		return persone;
	}

	public void setPersone(PersonaFisica[] persone) {
		this.persone = persone;
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

	public String getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(String idTransazione) {
		this.idTransazione = idTransazione;
	}

	public Integer getAdeguataVerifica() {
		return adeguataVerifica;
	}

	public void setAdeguataVerifica(Integer adeguataVerifica) {
		this.adeguataVerifica = adeguataVerifica;
	}

	public String validate() {
		String validationErrors = Validation.validateRequest(this);
		validationErrors += Validation.validateRequestString(idTransazione, "idTransazione");
		validationErrors += Validation.validateRequestArray(persone, "persone");
		if (persone != null && persone.length > 0) {
			boolean presenteBeneficiario = false;
			for (PersonaFisica pf : persone) {
				if (pf.getCodicePersonaFisica() != null && pf.getCodicePersonaFisica().intValue() == Costanti.TIPO_PERSONA_FISICA_BENEFICIARIO) {
					presenteBeneficiario = true;
					if (StringUtils.isBlank(pf.getTipoDocumento()))
						validationErrors += " tipoDocumento del beneficiario,";
					if (StringUtils.isBlank(pf.getNumeroDocumento()))
						validationErrors += " numeroDocumento del beneficiario,";
				}
			}
			if (!presenteBeneficiario)
				validationErrors += " persona di tipo 1 (beneficiario),";
		}
		if (adeguataVerifica == null || adeguataVerifica.intValue() != 1)
			validationErrors += " adeguataVerifica deve essere 1,";

		return Validation.formatValidation(validationErrors);
	}

	@Override
	public String toString() {
		return "PagamentoVoucherContoGiocoRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab="
				+ cab + ", idTerminale=" + idTerminale + ", persone=" + Arrays.toString(persone) + ", email=" + email + ", telefono=" + telefono + ", idTransazione=" + idTransazione + ", adeguataVerifica=" + adeguataVerifica + "]";
	}

}
