package it.grupposnai.paymatservices.model.request;

public interface Request {

	public String getCallerId();
	public void setCallerId(String callerId);

	public String getRequestId();
	public void setRequestId(String requestId);

	public String getFirma();
	public void setFirma(String firma);

	public String getSkin();
	public void setSkin(String skin);

	public String getUserIp();
	public void setUserIp(String userIp);

	public String getIdTerminale();
	public void setIdTerminale(String idTerminale);

	public String getToken();
	public void setToken(String token);

	public String getIdAziendaDistributore();
	public void setIdAziendaDistributore(String idAziendaDistributore);

	public String getIdAziendaEsercente();
	public void setIdAziendaEsercente(String idAziendaEsercente);

	public String getCab();
	public void setCab(String cab);

}
