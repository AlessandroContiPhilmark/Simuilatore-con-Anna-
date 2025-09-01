package it.grupposnai.paymatservices.util;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import it.cogetech.lib.common.util.Configurazione;
import it.cogetech.lib.db.util.CostantiDB;
import it.cogetech.lib.db.util.PoollableDatasource;

public class DataSourceManager {

	private static Logger logger = Logger.getLogger(DataSourceManager.class);

	public static void init() {
		initDatasources();
	}

	public static void init(String filePath) {
		initConfigurazione(filePath);
		initDatasources();
	}

	public static void init(Configuration configProp) {
		initConfigurazione(configProp);
		initDatasources();
	}

	private static void initDatasources() {
		logger.info("Inizializzazione Datasources");
		String dss = Configurazione.INSTANCE.getString(CostantiDB.DATASOURCES);
		String[] dssArray = dss.split(";");
		for (String string : dssArray) {
			String connectURI = Configurazione.INSTANCE.getString(string + "." + CostantiDB.CONNECT_URI);
			String driver = Configurazione.INSTANCE.getString(string + "." + CostantiDB.DRIVER);
			String username = Configurazione.INSTANCE.getString(string + "." + CostantiDB.USERNAME);
			String passwd = Configurazione.INSTANCE.getString(string + "." + CostantiDB.PASSWORD);
			int maxActive = Configurazione.INSTANCE.getInt(string + "." + CostantiDB.MAX_ACTIVE);
			int maxIdle = Configurazione.INSTANCE.getInt(string + "." + CostantiDB.MAX_IDLE);
			int maxWait = Configurazione.INSTANCE.getInt(string + "." + CostantiDB.MAX_WAIT);
			boolean defaultAutoCommit = Configurazione.INSTANCE.getBoolean(string + "." + CostantiDB.DEFAULT_AUTOCOMMIT);
			PoollableDatasource.init(string, connectURI, driver, username, passwd, maxActive, maxIdle, maxWait, defaultAutoCommit);
			logger.info("Datasource:[" + string + "] Inizializzato.");
		}
	}

	private static void initConfigurazione(String filePath) {
		System.out.println("inizializzo properit� con file:[" + filePath + "]");
		File file = new File(filePath);
		if (!file.exists()) {
			logger.error("file properties non trovato!!!");
			System.out.println("file properties non trovato!!!");
		} else {
			try {
				Configuration config = new PropertiesConfiguration(filePath);
				initConfigurazione(config);
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}

	private static void initConfigurazione(Configuration config) {
		for (Iterator<?> iter = config.getKeys(); iter.hasNext();) {
			Object key = iter.next();
			Configurazione.INSTANCE.setProperty((String) key, config.getProperty((String) key));
			System.out.println("Property: KEY[" + key + "] VALUE[" + config.getProperty((String) key) + "]");
			logger.info("Property: KEY[" + key + "] VALUE[" + config.getProperty((String) key) + "]");
		}
	}

}
