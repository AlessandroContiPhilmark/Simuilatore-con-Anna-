package it.grupposnai.paymatservices.adapter;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import it.grupposnai.paymatservices.model.request.sim.AttivaLottoSimRequest;
import it.grupposnai.paymatservices.model.request.sim.CancelAcquistoSimRequest;
import it.grupposnai.paymatservices.model.request.sim.ConfirmAcquistoSimRequest;
import it.grupposnai.paymatservices.model.request.sim.ReserveAcquistoSimRequest;
import it.grupposnai.paymatservices.model.response.sim.AttivaLottoSimResponse;
import it.grupposnai.paymatservices.model.response.sim.CancelAcquistoSimResponse;
import it.grupposnai.paymatservices.model.response.sim.ConfirmAcquistoSimResponse;
import it.grupposnai.paymatservices.model.response.sim.ReserveAcquistoSimResponse;

public class SimAdapter {

	// Mapping delle request

	public static it.grupposnai.paymatcore.api.request.sim.ReserveAcquistoSimRequest getReserveAcquistoSimRequest(ReserveAcquistoSimRequest request) throws IllegalAccessException, InvocationTargetException {
		it.grupposnai.paymatcore.api.request.sim.ReserveAcquistoSimRequest newRequest = new it.grupposnai.paymatcore.api.request.sim.ReserveAcquistoSimRequest();
		newRequest.setAllegati(ModelAdapter.getAllegatoList(request.getAllegati()));
		newRequest.setCab(request.getCab());
		newRequest.setCallerId(request.getCallerId());
		newRequest.setCodiceCredito(request.getCodiceCredito());
		newRequest.setCodiceSim(request.getCodiceSim());
		newRequest.setFirma(request.getFirma());
		newRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		newRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		newRequest.setIdBrand(request.getIdBrand());
		newRequest.setIdTaglio(request.getIdTaglio());
		newRequest.setIdTerminale(request.getIdTerminale());
		newRequest.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		newRequest.setRequestId(request.getRequestId());
		newRequest.setSkin(request.getSkin());
		newRequest.setToken(request.getToken());
		newRequest.setUserIp(request.getUserIp());
		return newRequest;
	}

	public static it.grupposnai.paymatcore.api.request.sim.ConfirmAcquistoSimRequest getConfirmAcquistoSimRequest(ConfirmAcquistoSimRequest request) throws IllegalAccessException, InvocationTargetException {
		it.grupposnai.paymatcore.api.request.sim.ConfirmAcquistoSimRequest newRequest = new it.grupposnai.paymatcore.api.request.sim.ConfirmAcquistoSimRequest();
		BeanUtils.copyProperties(newRequest, request);
		return newRequest;
	}

	public static it.grupposnai.paymatcore.api.request.sim.CancelAcquistoSimRequest getCancelAcquistoSimRequest(CancelAcquistoSimRequest request) throws IllegalAccessException, InvocationTargetException {
		it.grupposnai.paymatcore.api.request.sim.CancelAcquistoSimRequest newRequest = new it.grupposnai.paymatcore.api.request.sim.CancelAcquistoSimRequest();
		BeanUtils.copyProperties(newRequest, request);
		return newRequest;
	}

	public static it.grupposnai.paymatcore.api.request.sim.AttivaLottoSimRequest getAttivaLottoSimRequest(AttivaLottoSimRequest request) throws IllegalAccessException, InvocationTargetException {
		it.grupposnai.paymatcore.api.request.sim.AttivaLottoSimRequest newRequest = new it.grupposnai.paymatcore.api.request.sim.AttivaLottoSimRequest();
		BeanUtils.copyProperties(newRequest, request);
		return newRequest;
	}

	// Mapping delle response

	public static ReserveAcquistoSimResponse getReserveAcquistoSimResponse(it.grupposnai.paymatcore.api.response.sim.ReserveAcquistoSimResponse response) throws IllegalAccessException, InvocationTargetException {
		ReserveAcquistoSimResponse newResponse = new ReserveAcquistoSimResponse();
		newResponse.setCallerId(response.getCallerId());
		newResponse.setRequestId(response.getRequestId());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		return newResponse;
	}

	public static ConfirmAcquistoSimResponse getConfirmAcquistoSimResponse(it.grupposnai.paymatcore.api.response.sim.ConfirmAcquistoSimResponse response) throws IllegalAccessException, InvocationTargetException {
		ConfirmAcquistoSimResponse newResponse = new ConfirmAcquistoSimResponse();
		newResponse.setCallerId(response.getCallerId());
		newResponse.setRequestId(response.getRequestId());
		newResponse.setResultCode(response.getResultCode());
		newResponse.setResultDesc(response.getResultDesc());
		newResponse.setTicket(ModelAdapter.getInfoTicket(response.getTicket()));
		return newResponse;
	}

	public static CancelAcquistoSimResponse getCancelAcquistoSimResponse(it.grupposnai.paymatcore.api.response.sim.CancelAcquistoSimResponse response) throws IllegalAccessException, InvocationTargetException {
		CancelAcquistoSimResponse newResponse = new CancelAcquistoSimResponse();
		BeanUtils.copyProperties(newResponse, response);
		return newResponse;
	}

	public static AttivaLottoSimResponse getAttivaLottoSimResponse(it.grupposnai.paymatcore.api.response.sim.AttivaLottoSimResponse response) throws IllegalAccessException, InvocationTargetException {
		AttivaLottoSimResponse newResponse = new AttivaLottoSimResponse();
		BeanUtils.copyProperties(newResponse, response);
		return newResponse;
	}

}
