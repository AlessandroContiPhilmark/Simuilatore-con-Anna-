package it.grupposnai.simulatore.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import it.grupposnai.simulatore.model.request.Request;

public class Validation {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public static String validateRequest(Request request) {
		String validationErrors = "";
		validationErrors += validateRequestString(request.getCallerId(), "callerId");
		validationErrors += validateRequestString(request.getRequestId(), "requestId");
		validationErrors += validateRequestString(request.getSkin(), "skin");
		validationErrors += validateRequestString(request.getUserIp(), "userIp");
		validationErrors += validateRequestString(request.getFirma(), "firma");
		validationErrors += validateRequestString(request.getToken(), "token");
		validationErrors += validateRequestString(request.getIdAziendaDistributore(), "idAziendaDistributore");
		validationErrors += !isNullOrInteger(request.getIdAziendaDistributore()) ? buildErrorMessage("idAziendaDistributore errato") : "";
		validationErrors += validateRequestString(request.getIdAziendaEsercente() + request.getCab(), "idAziendaEsercente o cab");
		validationErrors += !isNullOrInteger(request.getIdAziendaEsercente()) ? buildErrorMessage("idAziendaEsercente errato") : "";
		return validationErrors;
	}

	public static String formatValidation(String validationErrors) {
		return validationErrors != null && validationErrors.length() > 0 ? validationErrors.substring(0, validationErrors.length() - 1) : null;
	}

	public static String validateRequestString(String value, String errorMessage) {
		return StringUtils.isBlank(value) ? buildErrorMessage(errorMessage) : "";
	}

	public static <T> String validateRequestArray(T[] array, String errorMessage) {
		return array == null || array != null && array.length == 0 ? buildErrorMessage(errorMessage) : "";
	}
	
	public static String validateRequestDate(String value, String errorMessage) {
		return validateRequestDate(value, errorMessage, dateFormat);
	}
	
	public static String validateRequestDate(String value, String errorMessage, SimpleDateFormat format) {
		try {
			dateFormat.parse(value);
			return "";
		} catch (ParseException e) {
			return buildErrorMessage(errorMessage);
		}
	}

	private static String buildErrorMessage(String errorMessage) {
		return " " + errorMessage + ",";
	}
	
	private static boolean isNullOrInteger(String value) {
		if(StringUtils.isBlank(value)) return true;
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
