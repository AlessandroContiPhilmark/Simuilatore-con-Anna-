package test.dao;

import it.cogetech.lib.db.util.PoollableDatasource;
import it.grupposnai.paymatservices.persistence.WsAuditDao;
import it.grupposnai.paymatservices.util.DataSourceManager;


public class WsAuditDaoTest {
	public static void main(String[] args) throws Exception{
		DataSourceManager.init("./src/test/java/test/dao/test.properties");
		WsAuditDao dao = new WsAuditDao();
		dao.setDataSource(PoollableDatasource.getDatasource("dblog"));
		dao.insRequestWebService("RJ1",  "JACK", 1, "JSKIN", "10.30.51.66", "giacomo gallucci", "tokenello", "1", "2", "10.30.51.1;10.30.51.66", "10.30.51.20", "messaggio xml <ciao>");
		dao.insResponseWebService("RJ1", "JACK", 1, "messaggio risposta");
	}
}
