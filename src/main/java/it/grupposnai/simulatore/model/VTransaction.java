package it.grupposnai.simulatore.model;

public class VTransaction {

	private String callerId;
	private String requestId;
	private String idTranSnaipay;
	private Integer importo;
	private String dataOra;
	private String accountCode;
	private Integer codiceVoucher;
	private String idTransazione;
	private String note;
	private Integer stato;
	private String nome;
	private String cognome;
	private String codiceSnaipay;
	private String nomeAzienda;

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

	public String getIdTranSnaipay() {
		return idTranSnaipay;
	}

	public void setIdTranSnaipay(String idTranSnaipay) {
		this.idTranSnaipay = idTranSnaipay;
	}

	public Integer getImporto() {
		return importo;
	}

	public void setImporto(Integer importo) {
		this.importo = importo;
	}

	public String getDataOra() {
		return dataOra;
	}

	public void setDataOra(String dataOra) {
		this.dataOra = dataOra;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getStato() {
		return stato;
	}

	public void setStato(Integer stato) {
		this.stato = stato;
	}

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

	public String getCodiceSnaipay() {
		return codiceSnaipay;
	}

	public void setCodiceSnaipay(String codiceSnaipay) {
		this.codiceSnaipay = codiceSnaipay;
	}

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	@Override
	public String toString() {
		return "VTransaction [callerId=" + callerId + ", requestId=" + requestId + ", idTranSnaipay=" + idTranSnaipay + ", importo=" + importo + ", dataOra=" + dataOra + ", accountCode=" + accountCode + ", codiceVoucher=" + codiceVoucher + ", idTransazione=" + idTransazione + ", note=" + note
				+ ", stato=" + stato + ", nome=" + nome + ", cognome=" + cognome + ", codiceSnaipay=" + codiceSnaipay + ", nomeAzienda=" + nomeAzienda + "]";
	}

}
