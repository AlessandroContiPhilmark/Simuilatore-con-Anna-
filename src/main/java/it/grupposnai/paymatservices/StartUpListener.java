package it.grupposnai.paymatservices;

import java.io.File;
import java.util.Iterator;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import it.cogetech.lib.common.util.Configurazione;
import it.cogetech.lib.monitoraggio.Monitoraggio;
import it.grupposnai.paymatcore.utils.Costanti;

public class StartUpListener implements ServletContextListener {

	private static Logger logger = Logger.getLogger(StartUpListener.class);
	private static String dirConfig = "/opt/configuration";
	private String WAR_NAME = "application.war.name";
	private String CONFIG_PATH = "application.config.path";
	private ServletContext context = null;
	
	

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		this.context = contextEvent.getServletContext();
		initInfoApp();
		initProperties();
		initLog();
		initMonitoraggio();
	}
	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
	}

	

	private void initLog() {

		String configPath = Configurazione.INSTANCE.getString(CONFIG_PATH);
		String warName = Configurazione.INSTANCE.getString(WAR_NAME);

		String completeFilePath = configPath + "/" + warName + "_log.properties";
		File file = new File(completeFilePath);
		logger.info("Inizializzazione log con file:[" + completeFilePath + "]");
		if (file.exists()) {
			PropertyConfigurator.configure(completeFilePath);
			logger.info("LOG4J INIZIALIZZATO....");
			logger.debug("debug level ok");
		} else {
			logger.error("LOG4J NON INIZIALIZZATO CORRETTAMENTE");
		}
	}
	
	private void initInfoApp() {
		String warName = "RetailService";

		try {
			warName = (String) (new InitialContext()).lookup("java:app/AppName");
		} catch (Exception e) {
			logger.error("Impossibile Recuperare il nome app lascio il default", e);
		}

		String configPath = dirConfig + "/" + warName;

		// Configurazione.INSTANCE.setProperty(Costanti.REAL_PATH, path);
		Configurazione.INSTANCE.setProperty(WAR_NAME, warName);
		Configurazione.INSTANCE.setProperty(CONFIG_PATH, configPath);

	}

	private void initProperties() {

		String configPath = Configurazione.INSTANCE.getString(CONFIG_PATH);
		String warName = Configurazione.INSTANCE.getString(WAR_NAME);

		String completeFilePath = configPath + "/" + warName + ".properties";
		logger.info("inizializzo property con file:[" + completeFilePath + "]");
		File file = new File(completeFilePath);
		if (!file.exists()) {
			logger.error("file properties non trovato!!!");
			//System.out.println("file properties non trovato!!!");
		} else {
			try {
				Configuration config = new PropertiesConfiguration(completeFilePath);
				for (Iterator<?> iter = config.getKeys(); iter.hasNext();) {
					Object key = iter.next();
					Configurazione.INSTANCE.setProperty((String) key, config.getProperty((String) key));
					//System.out.println("Property: KEY[" + key + "] VALUE[" + config.getProperty((String) key) + "]");
					logger.info("Property: KEY[" + key + "] VALUE[" + config.getProperty((String) key) + "]");
					context.setAttribute((String) key, config.getProperty((String) key));
				}
			} catch (ConfigurationException e) {
				logger.error("file properties non trovato!!!", e);
				//logger.error("file properties non trovato!!! " + e.getMessage());
			}
		}
	}

	public void initMonitoraggio() {

		boolean srvMonitoraggio = false;
		if (Configurazione.INSTANCE.getProperty(Costanti.SRV_MONITORAGGIO) != null) {
			srvMonitoraggio = Boolean.valueOf((String) Configurazione.INSTANCE.getProperty(Costanti.SRV_MONITORAGGIO));
		}
		if (srvMonitoraggio) {
			logger.debug("Inizializzazione servizio di monitoraggio");

			try {
				String emailFrom = Configurazione.INSTANCE.getString(Costanti.MON_EMAIL_FROM);
				String[] emailTo = Configurazione.INSTANCE.getString(Costanti.MON_EMAIL_TO).split(";");
				String emailServer = Configurazione.INSTANCE.getString(Costanti.EMAIL_SERVER);
				boolean emailAuthRequired = Configurazione.INSTANCE.getBoolean(Costanti.EMAIL_AUTH_REQUIRED);
				String emailSmtpUsername = null;
				String emailSmtpPassword = null;
				if (emailAuthRequired) {
					emailSmtpUsername = Configurazione.INSTANCE.getString(Costanti.EMAIL_SMTP_USERNAME);
					emailSmtpPassword = Configurazione.INSTANCE.getString(Costanti.EMAIL_SMTP_PASSWORD);
				}

				if (!emailAuthRequired)
					Monitoraggio.init(emailFrom, emailTo, emailServer);
				else
					Monitoraggio.init(emailFrom, emailTo, emailServer, emailAuthRequired, emailSmtpUsername, emailSmtpPassword);
				
				logger.debug("Servizio di monitoraggio inizializzato");
			} catch (Exception e) {
				logger.fatal("IMPOSSIBILE AVVIARE IL SERVIZIO DI MONITORAGGIO ");
				System.exit(-1);
			}

		} else {
			logger.info("SERVIZIO MONITORAGGIO NON ABILITATO");
		}

	}


}
