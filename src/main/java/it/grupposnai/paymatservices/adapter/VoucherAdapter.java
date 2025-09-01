package it.grupposnai.paymatservices.adapter;

import it.grupposnai.paymatservices.model.request.snai.voucher.GetDatiVoucherContoGiocoRequest;
import it.grupposnai.paymatservices.model.request.snai.voucher.GetPrelieviContoGiocoRequest;
import it.grupposnai.paymatservices.model.request.snai.voucher.PagamentoVoucherContoGiocoRequest;
import it.grupposnai.paymatservices.model.response.snai.voucher.GetDatiVoucherContoGiocoResponse;
import it.grupposnai.paymatservices.model.response.snai.voucher.GetPrelieviContoGiocoResponse;
import it.grupposnai.paymatservices.model.response.snai.voucher.PagamentoVoucherContoGiocoResponse;

public class VoucherAdapter {

	// Mapping delle request

	/**
	 * Mappa un oggetto GetDatiVoucherContoGiocoRequest da PaymatServices a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.snai.voucher.GetDatiVoucherContoGiocoRequest getGetDatiVoucherContoGiocoRequest(GetDatiVoucherContoGiocoRequest request) {
		it.grupposnai.paymatcore.api.request.snai.voucher.GetDatiVoucherContoGiocoRequest coreRequest = new it.grupposnai.paymatcore.api.request.snai.voucher.GetDatiVoucherContoGiocoRequest();
		ModelAdapter.copyStandardProperties(request, coreRequest);
		coreRequest.setCodiceVoucher(request.getCodiceVoucher());
		coreRequest.setContoGioco(request.getContoGioco());
		coreRequest.setIdTransazione(request.getIdTransazione());
		coreRequest.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		return coreRequest;
	}

	/**
	 * Mappa un oggetto PagamentoVoucherContoGiocoRequest da PaymatServices a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.snai.voucher.PagamentoVoucherContoGiocoRequest getPagamentoVoucherContoGiocoRequest(PagamentoVoucherContoGiocoRequest request) {
		it.grupposnai.paymatcore.api.request.snai.voucher.PagamentoVoucherContoGiocoRequest coreRequest = new it.grupposnai.paymatcore.api.request.snai.voucher.PagamentoVoucherContoGiocoRequest();
		ModelAdapter.copyStandardProperties(request, coreRequest);
		coreRequest.setPersone(ModelAdapter.getPersonaFisicaList(request.getPersone()));
		coreRequest.setEmail(request.getEmail());
		coreRequest.setTelefono(request.getTelefono());
		coreRequest.setIdTransazione(request.getIdTransazione());
		return coreRequest;
	}

	/**
	 * Mappa un oggetto GetPrelieviContoGiocoRequest da PaymatServices a PaymatCore
	 * 
	 * @param request
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.snai.voucher.GetPrelieviContoGiocoRequest getGetPrelieviContoGiocoRequest(GetPrelieviContoGiocoRequest request) {
		it.grupposnai.paymatcore.api.request.snai.voucher.GetPrelieviContoGiocoRequest coreRequest = new it.grupposnai.paymatcore.api.request.snai.voucher.GetPrelieviContoGiocoRequest();
		ModelAdapter.copyStandardProperties(request, coreRequest);
		coreRequest.setDataInizio(request.getDataInizio());
		coreRequest.setDataFine(request.getDataFine());
		coreRequest.setCodiceSnaipay(request.getCodiceSnaipay());
		coreRequest.setDescrizioneAzienda(request.getDescrizioneAzienda());
		return coreRequest;
	}

	// Mapping delle response

	/**
	 * Mappa un oggetto GetDatiVoucherContoGiocoResponse da PaymatCore a PaymatService
	 * 
	 * @param coreResponse
	 * @return
	 */
	public static GetDatiVoucherContoGiocoResponse getGetDatiVoucherContoGiocoResponse(it.grupposnai.paymatcore.api.response.snai.voucher.GetDatiVoucherContoGiocoResponse coreResponse) {
		GetDatiVoucherContoGiocoResponse response = new GetDatiVoucherContoGiocoResponse();
		ModelAdapter.copyStandardProperties(coreResponse, response);
		response.setAccount(ModelAdapter.getAccount(coreResponse.getAccount()));
		response.setVoucher(ModelAdapter.getVoucherList(coreResponse.getVoucherList()));
		return response;
	}

	/**
	 * Mappa un oggetto PagamentoVoucherContoGiocoResponse da PaymatCore a PaymatServices
	 * 
	 * @param coreResponse
	 * @return
	 */
	public static PagamentoVoucherContoGiocoResponse getPagamentoVoucherContoGiocoResponse(it.grupposnai.paymatcore.api.response.snai.voucher.PagamentoVoucherContoGiocoResponse coreResponse) {
		PagamentoVoucherContoGiocoResponse response = new PagamentoVoucherContoGiocoResponse();
		ModelAdapter.copyStandardProperties(coreResponse, response);
		response.setTicket(ModelAdapter.getInfoTicket(coreResponse.getTicket()));
		return response;
	}

	/**
	 * Mappa un oggetto GetPrelieviContoGiocoResponse da PaymatCore a PaymatServices
	 * 
	 * @param coreResponse
	 * @return
	 */
	public static GetPrelieviContoGiocoResponse getGetPrelieviContoGiocoRequest(it.grupposnai.paymatcore.api.response.snai.voucher.GetPrelieviContoGiocoResponse coreResponse) {
		GetPrelieviContoGiocoResponse response = new GetPrelieviContoGiocoResponse();
		ModelAdapter.copyStandardProperties(coreResponse, response);
		response.setTransactionList(ModelAdapter.getVTransactionList(coreResponse.getTransactionList()));
		return response;
	}

}
