package it.grupposnai.paymatservices.model.request.snai.voucher;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.paymatservices.model.PersonaFisica;
import it.grupposnai.paymatservices.model.request.Request;
import it.grupposnai.paymatservices.util.Validation;

@XmlType(name = "GetDatiVoucherContoGiocoRequest")
public class GetDatiVoucherContoGiocoRequest implements Request {

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
	private String contoGioco;
	private Integer codiceVoucher;
	private String idTransazione;

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

	public String getContoGioco() {
		return contoGioco;
	}

	public void setContoGioco(String contoGioco) {
		this.contoGioco = contoGioco;
	}

	public Integer getCodiceVoucher() {
		return codiceVoucher;
	}

	public void setCodiceVoucher(Integer codiceVoucher) {
		this.codiceVoucher = codiceVoucher;
	}

	public String getIdTransazione() {
		return idTransazione;
	}

	public void setIdTransazione(String idTransazione) {
		this.idTransazione = idTransazione;
	}
	
	public String validate() {
		String validationErrors = Validation.validateRequest(this);
		if(StringUtils.isBlank(idTransazione) && (StringUtils.isBlank(contoGioco) || codiceVoucher == null))
			validationErrors += " valorizzare idTransazione o la coppia contoGioco-codiceVoucher,";
		return Validation.formatValidation(validationErrors);
	}

	@Override
	public String toString() {
		return "GetDatiVoucherContoGiocoRequest [callerId=" + callerId + ", requestId=" + requestId + ", skin=" + skin + ", userIp=" + userIp + ", firma=" + firma + ", token=" + token + ", idAziendaDistributore=" + idAziendaDistributore + ", idAziendaEsercente=" + idAziendaEsercente + ", cab=" + cab
				+ ", idTerminale=" + idTerminale + ", persone=" + Arrays.toString(persone) + ", contoGioco=" + contoGioco + ", codiceVoucher=" + codiceVoucher + ", idTransazione=" + idTransazione + "]";
	}

}
