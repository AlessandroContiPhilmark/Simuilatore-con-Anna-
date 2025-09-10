package it.grupposnai.simulatore.model;

public class Account {

	private String codiceFiscale;
	private String codiceConto;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String username;
	private Integer balance;
	private Integer bonusBalance;

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCodiceConto() {
		return codiceConto;
	}

	public void setCodiceConto(String codiceConto) {
		this.codiceConto = codiceConto;
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

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getBonusBalance() {
		return bonusBalance;
	}

	public void setBonusBalance(Integer bonusBalance) {
		this.bonusBalance = bonusBalance;
	}

	@Override
	public String toString() {
		return "Account [codiceFiscale=" + codiceFiscale + ", codiceConto=" + codiceConto + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", username=" + username + ", balance=" + balance + ", bonusBalance=" + bonusBalance + "]";
	}

}
