package it.grupposnai.paymatservices.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import it.cogetech.lib.common.string.StringManager;
import it.cogetech.lib.common.util.GZIPUtil;

public class HttpSender {

	private static Logger logger = Logger.getLogger(HttpSender.class);

	public static final char EOF = (char) -1;

	public static void main(String[] args) throws Exception {

		String urlAddress = "http://10.77.1.169:8080/RetailService";
		byte[] risp = null;
		String xml = null;
		String messaggioTest = "";

		risp = sendMessageGettingBytes(urlAddress+"/getPalinsestiXml.action", messaggioTest + EOF, 1000);
		xml = GZIPUtil.decompress(risp);
		System.out.println(StringManager.truncate(xml, 1000));

		risp = sendMessageGettingBytes(urlAddress+"/getSportsXml.action", messaggioTest + EOF, 1000);
		xml = GZIPUtil.decompress(risp);
		System.out.println(StringManager.truncate(xml, 1000));

		risp = sendMessageGettingBytes(urlAddress+"/getManifestazioniXml.action", messaggioTest + EOF, 1000);
		xml = GZIPUtil.decompress(risp);
		System.out.println(StringManager.truncate(xml, 1000));

		risp = sendMessageGettingBytes(urlAddress+"/getTipiScommesseXml.action", messaggioTest + EOF, 1000);
		xml = GZIPUtil.decompress(risp);
		System.out.println(StringManager.truncate(xml, 1000));

		risp = sendMessageGettingBytes(urlAddress+"/getAvvenimentiXml.action?codPal=19328", messaggioTest + EOF, 1000);
		xml = GZIPUtil.decompress(risp);
		System.out.println(StringManager.truncate(xml, 1000));

		risp = sendMessageGettingBytes(urlAddress+"/getAvvenimentoXml.action?codPal=19328&codAvv=13733", messaggioTest + EOF, 1000);
		xml = GZIPUtil.decompress(risp);
		System.out.println(StringManager.truncate(xml, 1000));
		
		

	}

	public static String sendMessage(String url, String message) {
		return sendMessage(url, message, null);
	}

	public static byte[] sendMessageGettingBytes(String url, String message, Integer timeout) {

		System.out.println("invio verso:[" + url + "] questo messaggio:[" + message + "] con timeout :[" + timeout + "]");

		if (timeout == null) {
			timeout = 4000;
		}

		String risp = "";
		HttpURLConnection urlConnection = null;
		DataOutputStream dataOutputStream;
		DataInputStream dataInputStream;

		try {

			dataOutputStream = null;
			dataInputStream = null;

			urlConnection = (HttpURLConnection) (new URL(url).openConnection());
			urlConnection.setRequestProperty("Content-Type", "text/xml");
			urlConnection.setRequestProperty("User-Agent", "Cogetech");
			urlConnection.setRequestMethod("GET");

			// Specifying that we intend to use this connection for input+output
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setConnectTimeout(timeout);

			dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
			// System.out.println(message.getBytes());
			dataOutputStream.write(message.getBytes());
			dataOutputStream.close();

			int responseCode = urlConnection.getResponseCode();

			InputStream inputStream;

			if (responseCode == HttpURLConnection.HTTP_OK) {
				inputStream = urlConnection.getInputStream();
				dataInputStream = new DataInputStream(inputStream);
				byte[] signed = IOUtils.toByteArray(dataInputStream);
				// byte[] signed = dataInputStream.readLine().getBytes();
				return signed;

			} else {
				inputStream = urlConnection.getErrorStream();
				System.out.println("ERRORE HTTP " + responseCode);
			}

			return null;

		} catch (Exception e) {
			logger.error(StringManager.dumpException(e));
			return null;
		}

	}

	
	public static byte[] sendMessageGettingBytes(String url, byte[] message, Integer timeout) {

		System.out.println("invio verso:[" + url + "] questo messaggio:[" + message + "] con timeout :[" + timeout + "]");

		if (timeout == null) {
			timeout = 4000;
		}

		String risp = "";
		HttpURLConnection urlConnection = null;
		DataOutputStream dataOutputStream;
		DataInputStream dataInputStream;

		try {

			dataOutputStream = null;
			dataInputStream = null;

			urlConnection = (HttpURLConnection) (new URL(url).openConnection());
			urlConnection.setRequestProperty("Content-Type", "text/xml");
			urlConnection.setRequestProperty("User-Agent", "Cogetech");
			urlConnection.setRequestMethod("GET");

			// Specifying that we intend to use this connection for input+output
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setConnectTimeout(timeout);

			dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
			// System.out.println(message.getBytes());
			dataOutputStream.write(message);
			dataOutputStream.close();

			int responseCode = urlConnection.getResponseCode();

			InputStream inputStream;

			if (responseCode == HttpURLConnection.HTTP_OK) {
				inputStream = urlConnection.getInputStream();
				dataInputStream = new DataInputStream(inputStream);
				byte[] signed = IOUtils.toByteArray(dataInputStream);
				// byte[] signed = dataInputStream.readLine().getBytes();
				return signed;

			} else {
				inputStream = urlConnection.getErrorStream();
				System.out.println("ERRORE HTTP " + responseCode);
			}

			return null;

		} catch (Exception e) {
			logger.error(StringManager.dumpException(e));
			return null;
		}

	}
	
	public static String sendMessage(String url, String message, Integer timeout) {

		//System.out.println("invio verso:[" + url + "] questo messaggio:[" + message + "] con timeout :[" + timeout + "]");

		if (timeout == null) {
			timeout = 4000;
		}

		String risp = "";
		HttpURLConnection urlConnection = null;
		DataOutputStream dataOutputStream;
		DataInputStream dataInputStream;

		try {

			dataOutputStream = null;
			dataInputStream = null;

			urlConnection = (HttpURLConnection) (new URL(url).openConnection());
			urlConnection.setRequestProperty("Content-Type", "text/xml");
			urlConnection.setRequestProperty("User-Agent", "Cogetech");
			urlConnection.setRequestMethod("GET");

			// Specifying that we intend to use this connection for input+output
			urlConnection.setDoInput(true);
			urlConnection.setDoOutput(true);
			urlConnection.setUseCaches(false);
			urlConnection.setConnectTimeout(timeout);

			dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
			// System.out.println(message.getBytes());
			dataOutputStream.write(message.getBytes());
			dataOutputStream.close();

			int responseCode = urlConnection.getResponseCode();

			InputStream inputStream;

			if (responseCode == HttpURLConnection.HTTP_OK) {
				inputStream = urlConnection.getInputStream();
				dataInputStream = new DataInputStream(inputStream);
				byte[] signed = IOUtils.toByteArray(dataInputStream);
				// byte[] signed = dataInputStream.readLine().getBytes();
				risp = new String(signed);

			} else {
				inputStream = urlConnection.getErrorStream();
				System.out.println("ERRORE HTTP " + responseCode);
			}

			return risp;

		} catch (Exception e) {
			logger.error(StringManager.dumpException(e));
			return null;
		}

	}

	private static String readFileAsString(String filePath) throws java.io.IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}

}
