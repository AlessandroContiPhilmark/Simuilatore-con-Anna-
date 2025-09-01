package it.grupposnai.paymatservices.model.request.ricaricaConto;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlType;

import it.grupposnai.paymatservices.model.PersonaFisica;

@XmlType(name = "ReserveRicaricaContoRequest")
public class ReserveRicaricaContoRequest {

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
	private String codiceConto;
	private Integer importo;
	private Integer gestore = 1;
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
	public PersonaFisica[] getPersone() {
		return persone;
	}
	public void setPersone(PersonaFisica[] persone) {
		this.persone = persone;
	}
	public String getCodiceConto() {
		return codiceConto;
	}
	public void setCodiceConto(String codiceConto) {
		this.codiceConto = codiceConto;
	}
	public Integer getImporto() {
		return importo;
	}
	public void setImporto(Integer importo) {
		this.importo = importo;
	}
	public Integer getGestore() {
		return gestore;
	}
	public void setGestore(Integer gestore) {
		this.gestore = gestore;
	}
	public String getCodiceCredito() {
		return codiceCredito;
	}
	public void setCodiceCredito(String codiceCredito) {
		this.codiceCredito = codiceCredito;
	}
	@Override
	public String toString() {
		return String.format(
				"ReserveRicaricaContoRequest [callerId=%s, requestId=%s, skin=%s, userIp=%s, firma=%s, token=%s, idAziendaDistributore=%s, idAziendaEsercente=%s, cab=%s, idTerminale=%s, persone=%s, codiceConto=%s, importo=%s, gestore=%s, codiceCredito=%s]",
				callerId, requestId, skin, userIp, firma, token, idAziendaDistributore, idAziendaEsercente, cab,
				idTerminale, Arrays.toString(persone), codiceConto, importo, gestore, codiceCredito);
	}
}