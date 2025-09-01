package it.grupposnai.paymatservices.adapter;

import java.util.ArrayList;
import java.util.List;

import it.grupposnai.paymatcore.api.request.header.BaseRequest;
import it.grupposnai.paymatcore.api.response.header.BaseResponse;
import it.grupposnai.paymatservices.model.Account;
import it.grupposnai.paymatservices.model.BollettinoFreccia;
import it.grupposnai.paymatservices.model.VTransaction;
import it.grupposnai.paymatservices.model.Voucher;
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

	/* Ente Cbill */

	/**
	 * Mappa una lista di oggetti EnteCbill PaymatCore in un array di oggetti EnteCbill PaymatService
	 * 
	 * @param list
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.EnteCbill[] getEnteCbillList(List<it.grupposnai.paymatcore.api.response.info.EnteCbill> list) {
		it.grupposnai.paymatservices.model.EnteCbill[] newList;
		if (list == null || list.size() == 0)
			newList = new it.grupposnai.paymatservices.model.EnteCbill[0];
		else {
			newList = new it.grupposnai.paymatservices.model.EnteCbill[list.size()];
			for (int i = 0; i < list.size(); i++) {
				newList[i] = getEnteCbill(list.get(i));
			}
		}
		return newList;
	}

	/**
	 * Mappa un oggetto EnteCbill di PaymatCore in un oggetto Tassa di PaymatService
	 * 
	 * @param tassa
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.EnteCbill getEnteCbill(it.grupposnai.paymatcore.api.response.info.EnteCbill ente) {
		it.grupposnai.paymatservices.model.EnteCbill newEnte = null;
		if (ente != null) {
			newEnte = new it.grupposnai.paymatservices.model.EnteCbill();
			newEnte.setNome(ente.getNome());
			newEnte.setCodiceSia(ente.getCodiceSia());
			newEnte.setCodiceCuc(ente.getCuc());
			newEnte.setIdNazionale(ente.getIdNazionale());
			newEnte.setAbilitazioneRicercaBollettini(ente.getAbilitazioneRicercaBollettini());
		}
		return newEnte;
	}

	/* Bollettino Cbill */

	/**
	 * Mappa una lista di oggetti BollettinoCbill PaymatCore in un array di oggetti BollettinoCbill PaymatService
	 * 
	 * @param list
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.BollettinoCbill[] getBollettinoCbillList(List<it.grupposnai.paymatcore.api.response.info.BollettinoCbill> list) {
		it.grupposnai.paymatservices.model.BollettinoCbill[] newList;
		if (list == null || list.size() == 0)
			newList = new it.grupposnai.paymatservices.model.BollettinoCbill[0];
		else {
			newList = new it.grupposnai.paymatservices.model.BollettinoCbill[list.size()];
			for (int i = 0; i < list.size(); i++) {
				newList[i] = getBollettinoCbill(list.get(i));
			}
		}
		return newList;
	}

	/**
	 * Mappa un oggetto BollettinoCbill di PaymatCore in un oggetto BollettinoCbill di PaymatService
	 * 
	 * @param tassa
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.BollettinoCbill getBollettinoCbill(it.grupposnai.paymatcore.api.response.info.BollettinoCbill bollettino) {
		it.grupposnai.paymatservices.model.BollettinoCbill newBollettino = null;
		if (bollettino != null) {
			newBollettino = new it.grupposnai.paymatservices.model.BollettinoCbill();
			newBollettino.setDataPagamento(bollettino.getDataPagamento());
			newBollettino.setIdPagamento(bollettino.getIdPagamento());
			newBollettino.setIdBanca(bollettino.getIdBanca());
			newBollettino.setStatusBollettino(bollettino.getStatusBollettino());
			newBollettino.setIdBollettino(bollettino.getIdBollettino());
			newBollettino.setImporto(bollettino.getImporto());
			newBollettino.setIdBollettino2(bollettino.getIdBollettino_2());
			newBollettino.setValuta(bollettino.getValuta());
			newBollettino.setReference(bollettino.getReference());
			newBollettino.setDataScadenza(bollettino.getDataScadenza());
			newBollettino.setCostoTotaleServizio(bollettino.getCostoTotaleServizio());
			newBollettino.setCommissioniBollettino(bollettino.getCommissioniBollettino());
			newBollettino.setCommissioniBancarie(bollettino.getCommissioniBancarie());
			newBollettino.setIban(bollettino.getIban());
			newBollettino.setInformazioniAggiuntive(bollettino.getInformazioniAggiuntive());
		}
		return newBollettino;
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

	/* ENTE BOLLETTINO */

	/**
	 * Mappa un oggetto EnteBollettino da PaymatCore a PaymatServices
	 * 
	 * @param ente
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.EnteBollettino getEnteBollettino(it.grupposnai.paymatcore.api.response.info.EnteBollettino ente) {
		it.grupposnai.paymatservices.model.EnteBollettino newEnte = null;
		if (ente != null) {
			newEnte = new it.grupposnai.paymatservices.model.EnteBollettino();
			newEnte.setNome(ente.getNome());
			newEnte.setNumeroCC(ente.getNumeroCC());
			newEnte.setNote(ente.getNote());
			newEnte.setMemoCausale(ente.getMemoCausale());
			newEnte.setCampiVariabiliBollettinoCliente(getCampoVariabileBollettinoList(ente.getCampiVariabiliBollettinoCliente()));
			newEnte.setCampiVariabiliBollettinoEnte(getCampoVariabileBollettinoList(ente.getCampiVariabiliBollettinoEnte()));
			newEnte.setObbligatorietaCodFisPiva(ente.getObbligatorietaCodFisPiva());
		}
		return newEnte;
	}

	public static it.grupposnai.paymatcore.api.response.info.EnteBollettino getEnteBollettino(it.grupposnai.paymatservices.model.EnteBollettino ente) {
		it.grupposnai.paymatcore.api.response.info.EnteBollettino newEnte = null;
		if (ente != null) {
			newEnte = new it.grupposnai.paymatcore.api.response.info.EnteBollettino();
			newEnte.setNome(ente.getNome());
			newEnte.setNumeroCC(ente.getNumeroCC());
			newEnte.setNote(ente.getNote());
			newEnte.setMemoCausale(ente.getMemoCausale());
			newEnte.setCampiVariabiliBollettinoCliente(getCampoVariabileBollettinoList(ente.getCampiVariabiliBollettinoCliente()));
			newEnte.setCampiVariabiliBollettinoEnte(getCampoVariabileBollettinoList(ente.getCampiVariabiliBollettinoEnte()));
		}
		return newEnte;
	}

	/* CAMPO VARIABILE BOLLETTINO */

	/**
	 * Mappa un array di oggetti CampoVariabileBollettino di PaymatServices in una lista di oggetti CampoVariabileBollettino di PaymatCore
	 * 
	 * @param list
	 * @return
	 */
	public static List<it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino> getCampoVariabileBollettinoList(it.grupposnai.paymatservices.model.CampoVariabileBollettino[] list) {
		List<it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino> newList = null;
		if (list != null && list.length > 0) {
			newList = new ArrayList<it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino>();
			for (it.grupposnai.paymatservices.model.CampoVariabileBollettino element : list) {
				newList.add(getCampoVariabileBollettino(element));
			}
		}
		return newList;
	}

	/**
	 * Mappa una array di oggetti CampoVariabileBollettino di PaymatCore in un array di oggetti CampoVariabileBollettino di PaymatServices
	 * 
	 * @param list
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.CampoVariabileBollettino[] getCampoVariabileBollettinoList(it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino[] list) {
		it.grupposnai.paymatservices.model.CampoVariabileBollettino[] newList;
		if (list == null || list.length == 0)
			newList = new it.grupposnai.paymatservices.model.CampoVariabileBollettino[0];
		else {
			newList = new it.grupposnai.paymatservices.model.CampoVariabileBollettino[list.length];
			for (int i = 0; i < list.length; i++) {
				newList[i] = getCampoVariabileBollettino(list[i]);
			}
		}
		return newList;
	}

	/**
	 * Mappa una lista di oggetti CampoVariabileBollettino di PaymatCore in un array di oggetti CampoVariabileBollettino di PaymatServices
	 * 
	 * @param list
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.CampoVariabileBollettino[] getCampoVariabileBollettinoList(List<it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino> list) {
		it.grupposnai.paymatservices.model.CampoVariabileBollettino[] newList;
		if (list == null || list.size() == 0)
			newList = new it.grupposnai.paymatservices.model.CampoVariabileBollettino[0];
		else {
			newList = new it.grupposnai.paymatservices.model.CampoVariabileBollettino[list.size()];
			for (int i = 0; i < list.size(); i++) {
				newList[i] = getCampoVariabileBollettino(list.get(i));
			}
		}
		return newList;
	}

	/**
	 * Mappa un oggetto CampoVariabileBollettino da PaymatServices a PaymatCore
	 * 
	 * @param cvb
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino getCampoVariabileBollettino(it.grupposnai.paymatservices.model.CampoVariabileBollettino cvb) {
		it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino newCvb = new it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino();
		if (cvb != null) {
			newCvb = new it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino();
			newCvb.setDescrizione(cvb.getDescrizione());
			newCvb.setLunghezza(cvb.getLunghezza());
			newCvb.setNome(cvb.getNome());
			newCvb.setTipo(cvb.getTipo());
			newCvb.setValore(cvb.getValore());
		}
		return newCvb;
	}

	/**
	 * Mappa un oggetto CampoVariabileBollettino da PaymatCore a Paymatservices
	 * 
	 * @param cvb
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.CampoVariabileBollettino getCampoVariabileBollettino(it.grupposnai.paymatcore.api.response.info.CampoVariabileBollettino cvb) {
		it.grupposnai.paymatservices.model.CampoVariabileBollettino newCvb = null;
		if (cvb != null) {
			newCvb = new it.grupposnai.paymatservices.model.CampoVariabileBollettino();
			newCvb.setDescrizione(cvb.getDescrizione());
			newCvb.setLunghezza(cvb.getLunghezza());
			newCvb.setNome(cvb.getNome());
			newCvb.setTipo(cvb.getTipo());
			newCvb.setValore(cvb.getValore());
		}
		return newCvb;
	}

	/* BOLLETTINO */

	/**
	 * Mappa un oggetto Bollettino da PaymatServices a PaymatCore
	 * 
	 * @param bollettino
	 * @return
	 */
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.Bollettino getBollettino(it.grupposnai.paymatservices.model.Bollettino bollettino) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.Bollettino newBollettino = null;
		if (bollettino != null) {
			newBollettino = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettini.Bollettino();
			newBollettino.setNumeroCC(Long.parseLong(bollettino.getNumeroCC()));
			newBollettino.setInfoAggiuntive(bollettino.getInfoAggiuntive());
			newBollettino.setImportoVersamento(bollettino.getImportoVersamento());
			newBollettino.setIdentificativoBollettino(bollettino.getIdentificativoBollettino());
			newBollettino.setCodiceBollettino(bollettino.getCodiceBollettino());
			newBollettino.setCausaleVersamento(bollettino.getCausaleVersamento());
			newBollettino.setCampiVariabiliBollettinoCliente(ModelAdapter.getCampoVariabileBollettinoList(bollettino.getCampiVariabiliBollettinoCliente()));
			newBollettino.setCampiVariabiliBollettinoEnte(ModelAdapter.getCampoVariabileBollettinoList(bollettino.getCampiVariabiliBollettinoEnte()));
		}
		return newBollettino;
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
	
	/* VOUCHER */
	
	/**
	 * Mappa una lista di oggetti Voucher da PaymatCore a PaymatServices
	 * @param list
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Voucher[] getVoucherList(List<it.grupposnai.paymatcore.api.model.Voucher> list) {
		it.grupposnai.paymatservices.model.Voucher[] newList;
		if (list == null || list.size() == 0)
			newList = new it.grupposnai.paymatservices.model.Voucher[0];
		else {
			newList = new it.grupposnai.paymatservices.model.Voucher[list.size()];
			for (int i = 0; i < list.size(); i++) {
				newList[i] = getVoucher(list.get(i));
			}
		}
		return newList;
	}

	/**
	 * Mappa un oggetto Voucher da PaymatCore a PaymatServices
	 * @param v
	 * @return
	 */
	public static it.grupposnai.paymatservices.model.Voucher getVoucher(it.grupposnai.paymatcore.api.model.Voucher v) {
		it.grupposnai.paymatservices.model.Voucher newV = null;
		if (v != null) {
			newV = new Voucher();
			newV.setCodiceVoucher(v.getCodiceVoucher());
			newV.setCodTipoDoc(v.getCodTipoDoc());
			newV.setDataEmissione(v.getDataEmissione());
			newV.setDataScadenza(v.getDataScadenza());
			newV.setDescStato(v.getDescStato());
			newV.setIdTran(v.getIdTran());
			newV.setIdTranCsmf(v.getIdTranCsmf());
			newV.setNumDoc(v.getNumDoc());
			newV.setStato(v.getStato());
			newV.setValore(v.getValore());
		}
		return newV;
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
	
	/* BOLLETTINO FRECCIA*/

	/**
	 * Mappa un oggetto BollettinoFreccia da PaymatServices a PaymatCore
	 * 
	 * @param bollettinoFreccia
	 * @return
	 */
	
	public static it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.BollettinoFreccia getBollettinoFreccia(
			BollettinoFreccia bollettinoFreccia) {
		it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.BollettinoFreccia newBollettinoFreccia = null;
		if (bollettinoFreccia != null) {
			newBollettinoFreccia = new it.grupposnai.paymatcore.api.request.prodottiFinanziari.bollettinoFreccia.BollettinoFreccia();
			newBollettinoFreccia.setCausaleVersamento(bollettinoFreccia.getCausaleVersamento());
			newBollettinoFreccia.setCinImporto(bollettinoFreccia.getCinImporto());
			newBollettinoFreccia.setCinComplessivo(bollettinoFreccia.getCinComplessivo());
			newBollettinoFreccia.setCinCodiceIdentificativo(bollettinoFreccia.getCinCodiceIdentificativo());
			newBollettinoFreccia.setCodiceBollettino(bollettinoFreccia.getCodiceBollettino());
			newBollettinoFreccia.setIban(bollettinoFreccia.getIban());
			newBollettinoFreccia.setCodiceEsenzione(bollettinoFreccia.getCodiceEsenzione());
			newBollettinoFreccia.setImportoVersamento(bollettinoFreccia.getImportoVersamento());

		}
		return newBollettinoFreccia;
	}
	

}
