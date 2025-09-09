package it.grupposnai.paymatservices.adapter;

import java.util.ArrayList;
import java.util.List;

import it.grupposnai.paymatcore.api.request.header.BaseRequest;
import it.grupposnai.paymatcore.api.response.header.BaseResponse;
import it.grupposnai.paymatservices.model.Account;
import it.grupposnai.paymatservices.model.VTransaction;
import it.grupposnai.paymatservices.model.request.Request;
import it.grupposnai.paymatservices.model.response.Response;

public class ModelAdapter {
	
	/* CATEGORIE */

	/**
	 * Mappa una lista di oggetti Categoria PaymatCore in un array di oggetti Categoria PaymatService
	 * 
	 * @param list
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Categoria[] getCategorieList(List<it.grupposnai.paymatcore.api.model.Categoria> list) {
		it.grupposnai.paymatservices.model.Categoria[] newList;
		if (list == null || list.size() == 0)
			newList = new it.grupposnai.paymatservices.model.Categoria[0];
		else {
			newList = new it.grupposnai.paymatservices.model.Categoria[list.size()];
			for (int i = 0; i < list.size(); i++) {
				newList[i] = getCategoria(list.get(i));
			}
		}
		return newList;
	}

	/**
	 * Mappa un oggetto Categoria da PaymatCore a PaymatService
	 * 
	 * @param categoria
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Categoria getCategoria(it.grupposnai.paymatcore.api.model.Categoria categoria) {
		it.grupposnai.paymatservices.model.Categoria newCategoria = null;
		if (categoria != null) {
			newCategoria = new it.grupposnai.paymatservices.model.Categoria();
			newCategoria.setCodice(categoria.getCodice());
			newCategoria.setDescrizione(categoria.getDescrizione());
			newCategoria.setTipo(categoria.getTipo());
			newCategoria.setPriorita(categoria.getPriorita());
			newCategoria.setBrand(categoria.getBrand());
		}
		return newCategoria;
	}

	/* BRAND */

	/**
	 * Mappa una lista di oggetti Brand PaymatCore in un array di oggetti Brand PaymatService
	 * 
	 * @param infoList
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Brand[] getBrandList(List<it.grupposnai.paymatcore.api.response.info.Brand> infoList) {
		it.grupposnai.paymatservices.model.Brand[] newInfoList;
		if (infoList == null || infoList.size() == 0)
			newInfoList = new it.grupposnai.paymatservices.model.Brand[0];
		else {
			newInfoList = new it.grupposnai.paymatservices.model.Brand[infoList.size()];
			for (int i = 0; i < infoList.size(); i++) {
				newInfoList[i] = getBrand(infoList.get(i));
			}
		}
		return newInfoList;
	}

	/**
	 * Mappa un oggetto Brand da PaymatCore a PaymatService
	 * 
	 * @param brand
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Brand getBrand(it.grupposnai.paymatcore.api.response.info.Brand brand) {
		it.grupposnai.paymatservices.model.Brand newBrand = null;
		if (brand != null) {
			newBrand = new it.grupposnai.paymatservices.model.Brand();
			newBrand.setCodiceBrand(brand.getCodice());
			newBrand.setDescrizione(brand.getDescrizione());
			newBrand.setTipologia(brand.getTipologia());
			newBrand.setCategorie(brand.getCategorie());
		}
		return newBrand;
	}

	/**
	 * Mappa una lista di oggetti Brand PaymatCore in un oggetto ArrayOfBrand di PaymatService
	 * 
	 * @param listaBrand
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.ricarica.ArrayOfBrand getArrayOfBrand(List<it.grupposnai.paymatcore.api.response.info.Brand> listaBrand) {
		it.grupposnai.paymatservices.model.response.ricarica.ArrayOfBrand aob = new it.grupposnai.paymatservices.model.response.ricarica.ArrayOfBrand();
		if (listaBrand != null && listaBrand.size() > 0) {
			for (int i = 0; i < listaBrand.size(); i++) {
				aob.getBrand().add(getBrand(listaBrand.get(i)));
			}
		}

		return aob;
	}

	/* TAGLI */

	/**
	 * Mappa una lista di oggetti Taglio PaymatCore in un array di oggetti Taglio PaymatService
	 * 
	 * @param infoList
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Taglio[] getTaglioList(List<it.grupposnai.paymatcore.api.response.info.Taglio> infoList, boolean includiImportoInDescrizione) {
		it.grupposnai.paymatservices.model.Taglio[] newInfoList;
		if (infoList == null || infoList.size() == 0)
			newInfoList = new it.grupposnai.paymatservices.model.Taglio[0];
		else {
			newInfoList = new it.grupposnai.paymatservices.model.Taglio[infoList.size()];
			for (int i = 0; i < infoList.size(); i++) {
				newInfoList[i] = getTaglio(infoList.get(i), includiImportoInDescrizione);
			}
		}
		return newInfoList;
	}

	/**
	 * Mappa un oggetto Taglio da PaymatCore a PaymatService
	 * 
	 * @param taglio
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Taglio getTaglio(it.grupposnai.paymatcore.api.response.info.Taglio taglio, boolean includiImportoInDescrizione) {
		it.grupposnai.paymatservices.model.Taglio newTaglio = null;
		if (taglio != null) {
			newTaglio = new it.grupposnai.paymatservices.model.Taglio();
			newTaglio.setCodiceTaglio(taglio.getCodice());
			newTaglio.setDescrizione(taglio.getDescrizioneEsetesa() + (includiImportoInDescrizione ? " " + taglio.getValore() : ""));
			newTaglio.setTipologia(taglio.getTipologia());
			newTaglio.setImporto(taglio.getImporto());
			newTaglio.setValoreIva(taglio.getValoreIva());
			newTaglio.setImportoIva(taglio.getImportoIva());
		}
		return newTaglio;
	}

	/**
	 * Mappa una lista di oggetti Tagli PaymatCore in un oggetto ArrayOfTaglio di PaymatService
	 * 
	 * @param listaTagli
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.ricarica.ArrayOfTaglio getArrayOfTaglio(List<it.grupposnai.paymatcore.api.response.info.Taglio> listaTagli) {
		it.grupposnai.paymatservices.model.response.ricarica.ArrayOfTaglio aot = new it.grupposnai.paymatservices.model.response.ricarica.ArrayOfTaglio();
		if (listaTagli != null && listaTagli.size() > 0) {
			for (int i = 0; i < listaTagli.size(); i++) {
				aot.getTaglio().add(getTaglio(listaTagli.get(i), true));
			}
		}
		return aot;
	}

	/* TICKET */

	/**
	 * Mappa un oggetto DatiScontrino di PaymatCore in un oggetto Ticket di PaymatService ATTENZIONE: NON USARE PER NUOVI PRODOTTI. UTILIZZARE getInfoTicket
	 * 
	 * @deprecated Utilizzare getInfoTicket
	 * @param ticket
	 * @return
	 */
	@Deprecated
	public static it.grupposnai.paymatservices.model.response.ricarica.Ticket getTicket(it.grupposnai.paymatcore.api.response.info.Ticket ticket) {
		it.grupposnai.paymatservices.model.response.ricarica.Ticket newTicket = new it.grupposnai.paymatservices.model.response.ricarica.Ticket();
		if (ticket != null) {
			newTicket.setLogoAziendale(ticket.getLogoAziendale());
			newTicket.setNomeEsercente(ticket.getNomeEsercente());
			newTicket.setDescrizioneProdotto(ticket.getDescrizioneProdotto());
			newTicket.setDataOraTransazione(ticket.getDataOraTransazione());
			newTicket.setEsitoTransazione(ticket.getEsitoTransazione());
			newTicket.setLogoBrand(ticket.getLogoBrand());
			newTicket.setImportoFacciale(ticket.getImportoFacciale());
			newTicket.setNoteTransazione(ticket.getNoteTransazione());
			newTicket.setLinkSitoWeb(ticket.getLinkSitoWeb());
			newTicket.setNumeroAssistenza(ticket.getNumeroAssistenza());
			newTicket.setFooterScontrino(ticket.getFooterScontrino());
			newTicket.setIdTerminale(ticket.getIdTerminale());
			newTicket.setAbi(ticket.getAbi());
			newTicket.setCab(ticket.getCab());
			newTicket.setNumeroOperazione(ticket.getNumeroOperazione());
			newTicket.setIdAutorizzazione(ticket.getIdAutorizzazione());
			newTicket.setIdTranPaymat(ticket.getIdTranPaymat());
			newTicket.setNumeroTelefonico(ticket.getSerialNumber());
			newTicket.setPin(ticket.getPin());
			newTicket.setVariabile(ticket.getVariabile());
			newTicket.setTasse(getTasseList(ticket.getListaTasse()));
			newTicket.setEseguitoDa(ticket.getEseguitoDa());
			newTicket.setNumeroIPPS(ticket.getNumeroIPPS());
			// newTicket.setRichiedenteBollettino(getRichiedenteBollettino(ticket.getRichiedente()));
			// newTicket.setBeneficiarioBollettino(getBeneficiarioBollettino(ticket.getBeneficiario()));
			newTicket.setDataScadenza(ticket.getDataScadenza());
			newTicket.setSerialNumber(ticket.getSerialNumber());
		}
		return newTicket;
	}

	/**
	 * Mappa un oggetto DatiScontrino di PaymatCore in un oggetto Ticket di PaymatService La differenza tra questo metodo e getTicket è che getTicket utilizza una pezza (setta il serial number nel numero
	 * telefonico), mentre questo metodo ricalca esattamente tutti i campi del protocollo nella trafila paymatservices->paymatcore->sp db. Questo è il metodo corretto a livello di protocollo e va usato ed
	 * eventualmente aggiornato per tutti i nuovi prodotti futuri, inoltre sarebbe cosa buona e giusta che nel tempo sostituisse tutte le occorrenze di getTicket (raddrizzando la situazione a partire
	 * dalle stored procedure).
	 * 
	 * @param ticket
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.response.ricarica.Ticket getInfoTicket(it.grupposnai.paymatcore.api.response.info.Ticket ticket) {
		it.grupposnai.paymatservices.model.response.ricarica.Ticket newTicket = new it.grupposnai.paymatservices.model.response.ricarica.Ticket();
		if (ticket != null) {
			newTicket.setLogoAziendale(ticket.getLogoAziendale());
			newTicket.setNomeEsercente(ticket.getNomeEsercente());
			newTicket.setDescrizioneProdotto(ticket.getDescrizioneProdotto());
			newTicket.setDataOraTransazione(ticket.getDataOraTransazione());
			newTicket.setEsitoTransazione(ticket.getEsitoTransazione());
			newTicket.setLogoBrand(ticket.getLogoBrand());
			newTicket.setImportoFacciale(ticket.getImportoFacciale());
			newTicket.setNoteTransazione(ticket.getNoteTransazione());
			newTicket.setLinkSitoWeb(ticket.getLinkSitoWeb());
			newTicket.setNumeroAssistenza(ticket.getNumeroAssistenza());
			newTicket.setFooterScontrino(ticket.getFooterScontrino());
			newTicket.setIdTerminale(ticket.getIdTerminale());
			newTicket.setAbi(ticket.getAbi());
			newTicket.setCab(ticket.getCab());
			newTicket.setNumeroOperazione(ticket.getNumeroOperazione());
			newTicket.setIdAutorizzazione(ticket.getIdAutorizzazione());
			newTicket.setIdTranPaymat(ticket.getIdTranPaymat());
			newTicket.setNumeroTelefonico(ticket.getNumeroTelefonico());
			newTicket.setPin(ticket.getPin());
			newTicket.setVariabile(ticket.getVariabile());
			newTicket.setEseguitoDa(ticket.getEseguitoDa());
			newTicket.setNumeroIPPS(ticket.getNumeroIPPS());
			newTicket.setDataScadenza(ticket.getDataScadenza());
			newTicket.setTasse(getTasseList(ticket.getListaTasse()));
			newTicket.setBeneficiario(ticket.getBeneficiario());
			newTicket.setCausale(ticket.getCausale());
			newTicket.setSerialNumber(ticket.getSerialNumber());
		}
		return newTicket;
	}

	/* TASSA */

	/**
	 * Mappa una lista di oggetti Tasse PaymatCore in un array di oggetti Tassa PaymatService
	 * 
	 * @param list
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Tassa[] getTasseList(List<it.grupposnai.paymatcore.api.response.info.Tassa> list) {
		it.grupposnai.paymatservices.model.Tassa[] newList;
		if (list == null || list.size() == 0)
			newList = new it.grupposnai.paymatservices.model.Tassa[0];
		else {
			newList = new it.grupposnai.paymatservices.model.Tassa[list.size()];
			for (int i = 0; i < list.size(); i++) {
				newList[i] = getTassa(list.get(i));
			}
		}
		return newList;
	}

	/**
	 * Mappa un oggetto Tasse di PaymatCore in un oggetto Tassa di PaymatService
	 * 
	 * @param tassa
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Tassa getTassa(it.grupposnai.paymatcore.api.response.info.Tassa tassa) {
		it.grupposnai.paymatservices.model.Tassa newTassa = null;
		if (tassa != null) {
			newTassa = new it.grupposnai.paymatservices.model.Tassa();
			newTassa.setImportoTassa(tassa.getImportoTassa());
			newTassa.setTipoTassa(tassa.getTipoTassa());
		}
		return newTassa;
	}

	/* ALLEGATO */

	/**
	 * Mappa un array di oggetti Allegato di PaymatService in una lista di oggetti Allegato di PaymatCore
	 * 
	 * @param allegati
	 * @return
	 */
	public static List<it.grupposnai.paymatcore.api.model.Allegato> getAllegatoList(it.grupposnai.paymatservices.model.Allegato[] allegati) {
		List<it.grupposnai.paymatcore.api.model.Allegato> newAllegatoList = null;
		if (allegati != null && allegati.length > 0) {
			newAllegatoList = new ArrayList<it.grupposnai.paymatcore.api.model.Allegato>();
			for (it.grupposnai.paymatservices.model.Allegato allegato : allegati) {
				newAllegatoList.add(getAllegato(allegato));
			}
		}
		return newAllegatoList;
	}

	/**
	 * Mappa un oggetto Allegato di PaymatService in un oggetto Allegato di PaymatCore
	 * 
	 * @param allegato
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.model.Allegato getAllegato(it.grupposnai.paymatservices.model.Allegato allegato) {
		it.grupposnai.paymatcore.api.model.Allegato newAllegato = null;
		if (allegato != null) {
			newAllegato = new it.grupposnai.paymatcore.api.model.Allegato();
			newAllegato.setCodice(allegato.getCodice());
			newAllegato.setHexString(allegato.getHexString());
			newAllegato.setType(allegato.getType());
		}
		return newAllegato;
	}

	/* PERSONA FISICA */

	/**
	 * Mappa un array di oggetti PesonaFisica di PaymatService in una lista di oggetti PersonaFisica di PaymatCore
	 * 
	 * @param persone
	 * @return
	 */
	public static List<it.grupposnai.paymatcore.api.model.PersonaFisica> getPersonaFisicaList(it.grupposnai.paymatservices.model.PersonaFisica[] persone) {
		List<it.grupposnai.paymatcore.api.model.PersonaFisica> pfList = null;
		if (persone != null && persone.length > 0) {
			pfList = new ArrayList<it.grupposnai.paymatcore.api.model.PersonaFisica>();
			for (it.grupposnai.paymatservices.model.PersonaFisica pf : persone) {
				pfList.add(getPersonaFisica(pf));
			}
		}
		return pfList;
	}

	/**
	 * Mappa un oggetto PersonaFisica di PaymatService in un oggetto PersonaFisica di PaymatCore
	 * 
	 * @param pf
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.model.PersonaFisica getPersonaFisica(it.grupposnai.paymatservices.model.PersonaFisica pf) {
		it.grupposnai.paymatcore.api.model.PersonaFisica newPf = null;
		if (pf != null) {
			newPf = new it.grupposnai.paymatcore.api.model.PersonaFisica();
			newPf.setCap(pf.getCap());
			newPf.setCitta(pf.getCitta());
			newPf.setCodicefiscale(pf.getCodiceFiscale());
			newPf.setCodicepersonafisica(pf.getCodicePersonaFisica());
			newPf.setCognome(pf.getCognome());
			newPf.setDatadinascita(pf.getDataNascita());
			newPf.setDatascadenzadocumento(pf.getDataScadenzaDocumento());
			newPf.setEmail(pf.getEmail());
			newPf.setIndirizzo(pf.getIndirizzo());
			newPf.setNazione(pf.getNazione());
			newPf.setNome(pf.getNome());
			newPf.setNumerodocumento(pf.getNumeroDocumento());
			newPf.setProvincia(pf.getProvincia());
			newPf.setTelefono(pf.getTelefono());
			newPf.setTipodocumento(pf.getTipoDocumento());
			newPf.setTipopersona(pf.getTipopersona());
			newPf.setFrazione(pf.getFrazione());
			newPf.setInfoAddizionaliIndirizzo(pf.getInfoAddizionaliIndirizzo());
			newPf.setNomeStrada(pf.getNomeStrada());
			newPf.setNumeroCivico(pf.getNumeroCivico());
			newPf.setSesso(pf.getSesso());
			newPf.setToponimo(pf.getToponimo());
		}
		return newPf;
	}



	/* ACCOUNT CONTO GIOCO */

	/**
	 * Mappa un oggetto Account da PaymatCore a PaymatServices
	 * @param a
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Account getAccount(it.grupposnai.paymatcore.api.model.Account a) {
		it.grupposnai.paymatservices.model.Account newA = null;
		if (a != null) {
			newA = new Account();
			newA.setBalance(a.getBalance());
			newA.setBonusBalance(a.getBonusBalance());
			newA.setCodiceConto(a.getCodiceConto());
			newA.setCodiceFiscale(a.getCodiceFiscale());
			newA.setCognome(a.getCognome());
			newA.setDataNascita(a.getDataNascita());
			newA.setNome(a.getNome());
			newA.setUsername(a.getUsername());
		}
		return newA;
	}


	
	/* VTransaction */
	
	/**
	 * Mappa una lista di oggetti VTransaction da PaymatCore a PaymatServices
	 * @param list
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.VTransaction[] getVTransactionList(List<it.grupposnai.paymatcore.api.model.VTransaction> list) {
		it.grupposnai.paymatservices.model.VTransaction[] newList;
		if (list == null || list.size() == 0)
			newList = new it.grupposnai.paymatservices.model.VTransaction[0];
		else {
			newList = new it.grupposnai.paymatservices.model.VTransaction[list.size()];
			for (int i = 0; i < list.size(); i++) {
				newList[i] = getVTransaction(list.get(i));
			}
		}
		return newList;
	}

	/**
	 * Mappa un oggetto VTransaction da PaymatCore a PaymatServices
	 * @param vt
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.VTransaction getVTransaction(it.grupposnai.paymatcore.api.model.VTransaction vt) {
		it.grupposnai.paymatservices.model.VTransaction newVt = null;
		if (vt != null) {
			newVt = new VTransaction();
			newVt.setAccountCode(vt.getAccountCode());
			newVt.setCallerId(vt.getCallerId());
			newVt.setCodiceSnaipay(vt.getCodiceSnaipay());
			newVt.setCodiceVoucher(vt.getCodiceVoucher());
			newVt.setCognome(vt.getCognome());
			newVt.setDataOra(vt.getDataOra());
			newVt.setIdTransazione(vt.getIdTransazione());
			newVt.setIdTranSnaipay(vt.getIdTranSnaipay());
			newVt.setImporto(vt.getImporto());
			newVt.setNome(vt.getNome());
			newVt.setNomeAzienda(vt.getNomeAzienda());
			newVt.setNote(vt.getNote());
			newVt.setRequestId(vt.getRequestId());
			newVt.setStato(vt.getStato());
		}
		return newVt;
	}
	
	
	/* UTIL */
	
	/**
	 * Copia le proprieta' comuni di tutte le Request di PaymatServices sul corrispettivo di PaymatCore
	 * @param request
	 * @param coreRequest
	 */
	public static void copyStandardProperties(Request request, BaseRequest coreRequest) {
		coreRequest.setCab(request.getCab());
		coreRequest.setCallerId(request.getCallerId());
		coreRequest.setFirma(request.getFirma());
		coreRequest.setIdAziendaDistributore(request.getIdAziendaDistributore());
		coreRequest.setIdAziendaEsercente(request.getIdAziendaEsercente());
		coreRequest.setIdTerminale(request.getIdTerminale());
		coreRequest.setRequestId(request.getRequestId());
		coreRequest.setSkin(request.getSkin());
		coreRequest.setToken(request.getToken());
		coreRequest.setUserIp(request.getUserIp());
	}

	/**
	 * Copia le proprieta' comuni di tutte le Response di PaymatCore sul corrispettivo di PaymatServices
	 * @param coreResponse
	 * @param response
	 */
	public static void copyStandardProperties(BaseResponse coreResponse, Response response) {
		response.setCallerId(coreResponse.getCallerId());
		response.setRequestId(coreResponse.getRequestId());
		response.setResultCode(coreResponse.getResultCode());
		response.setResultDesc(coreResponse.getResultDesc());
	}
	

}
