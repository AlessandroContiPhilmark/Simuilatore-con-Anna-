
package it.grupposnai.paymatservices.model;

import javax.xml.bind.annotation.XmlRegistry;

import it.grupposnai.paymatservices.model.request.pin.ReserveAcquistoPinRequest;
import it.grupposnai.paymatservices.model.request.ricarica.CancelRicaricaTelefonica;
import it.grupposnai.paymatservices.model.request.ricarica.CancelRicaricaTelefonicaRequest;
import it.grupposnai.paymatservices.model.request.ricarica.ConfirmRicaricaTelefonica;
import it.grupposnai.paymatservices.model.request.ricarica.ConfirmRicaricaTelefonicaRequest;
import it.grupposnai.paymatservices.model.request.ricarica.GenericRequest;
import it.grupposnai.paymatservices.model.request.ricarica.InfoBrandRicariche;
import it.grupposnai.paymatservices.model.request.ricarica.InfoBrandRicaricheRequest;
import it.grupposnai.paymatservices.model.request.ricarica.InfoTagliRicariche;
import it.grupposnai.paymatservices.model.request.ricarica.InfoTaglioRicaricheRequest;
import it.grupposnai.paymatservices.model.request.ricarica.ReserveRicaricaTelefonica;
import it.grupposnai.paymatservices.model.request.ricarica.ReserveRicaricaTelefonicaRequest;
import it.grupposnai.paymatservices.model.response.pin.ReserveAcquistoPinResponse;
import it.grupposnai.paymatservices.model.response.ricarica.ArrayOfBrand;
import it.grupposnai.paymatservices.model.response.ricarica.ArrayOfTaglio;
import it.grupposnai.paymatservices.model.response.ricarica.CancelRicaricaTelefonicaResponse;
import it.grupposnai.paymatservices.model.response.ricarica.CancelRicaricaTelefonicaResponse2;
import it.grupposnai.paymatservices.model.response.ricarica.ConfirmRicaricaTelefonicaResponse;
import it.grupposnai.paymatservices.model.response.ricarica.ConfirmRicaricaTelefonicaResponse2;
import it.grupposnai.paymatservices.model.response.ricarica.GenericResponse;
import it.grupposnai.paymatservices.model.response.ricarica.InfoBrandRicaricheResponse;
import it.grupposnai.paymatservices.model.response.ricarica.InfoBrandRicaricheResponse2;
import it.grupposnai.paymatservices.model.response.ricarica.InfoTagliRicaricheResponse;
import it.grupposnai.paymatservices.model.response.ricarica.InfoTaglioRicaricheResponse;
import it.grupposnai.paymatservices.model.response.ricarica.ReserveRicaricaTelefonicaResponse;
import it.grupposnai.paymatservices.model.response.ricarica.ReserveRicaricaTelefonicaResponse2;
import it.grupposnai.paymatservices.model.response.ricarica.Ticket;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.paymatservizi.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.paymatservizi.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReserveRicaricaTelefonica }
     * 
     */
    public ReserveRicaricaTelefonica createReserveRicaricaTelefonica() {
        return new ReserveRicaricaTelefonica();
    }

    /**
     * Create an instance of {@link ReserveRicaricaTelefonicaRequest }
     * 
     */
    public ReserveRicaricaTelefonicaRequest createReserveRicaricaTelefonicaRequest() {
        return new ReserveRicaricaTelefonicaRequest();
    }

    /**
     * Create an instance of {@link ReserveRicaricaTelefonicaResponse }
     * 
     */
    public ReserveRicaricaTelefonicaResponse createReserveRicaricaTelefonicaResponse() {
        return new ReserveRicaricaTelefonicaResponse();
    }

    /**
     * Create an instance of {@link ReserveRicaricaTelefonicaResponse2 }
     * 
     */
    public ReserveRicaricaTelefonicaResponse2 createReserveRicaricaTelefonicaResponse2() {
        return new ReserveRicaricaTelefonicaResponse2();
    }

    /**
     * Create an instance of {@link ConfirmRicaricaTelefonica }
     * 
     */
    public ConfirmRicaricaTelefonica createConfirmRicaricaTelefonica() {
        return new ConfirmRicaricaTelefonica();
    }

    /**
     * Create an instance of {@link ConfirmRicaricaTelefonicaRequest }
     * 
     */
    public ConfirmRicaricaTelefonicaRequest createConfirmRicaricaTelefonicaRequest() {
        return new ConfirmRicaricaTelefonicaRequest();
    }

    /**
     * Create an instance of {@link ConfirmRicaricaTelefonicaResponse }
     * 
     */
    public ConfirmRicaricaTelefonicaResponse createConfirmRicaricaTelefonicaResponse() {
        return new ConfirmRicaricaTelefonicaResponse();
    }

    /**
     * Create an instance of {@link ConfirmRicaricaTelefonicaResponse2 }
     * 
     */
    public ConfirmRicaricaTelefonicaResponse2 createConfirmRicaricaTelefonicaResponse2() {
        return new ConfirmRicaricaTelefonicaResponse2();
    }

    /**
     * Create an instance of {@link CancelRicaricaTelefonica }
     * 
     */
    public CancelRicaricaTelefonica createCancelRicaricaTelefonica() {
        return new CancelRicaricaTelefonica();
    }

    /**
     * Create an instance of {@link CancelRicaricaTelefonicaRequest }
     * 
     */
    public CancelRicaricaTelefonicaRequest createCancelRicaricaTelefonicaRequest() {
        return new CancelRicaricaTelefonicaRequest();
    }

    /**
     * Create an instance of {@link CancelRicaricaTelefonicaResponse }
     * 
     */
    public CancelRicaricaTelefonicaResponse createCancelRicaricaTelefonicaResponse() {
        return new CancelRicaricaTelefonicaResponse();
    }

    /**
     * Create an instance of {@link CancelRicaricaTelefonicaResponse2 }
     * 
     */
    public CancelRicaricaTelefonicaResponse2 createCancelRicaricaTelefonicaResponse2() {
        return new CancelRicaricaTelefonicaResponse2();
    }

    /**
     * Create an instance of {@link InfoBrandRicariche }
     * 
     */
    public InfoBrandRicariche createInfoBrandRicariche() {
        return new InfoBrandRicariche();
    }

    /**
     * Create an instance of {@link InfoBrandRicaricheRequest }
     * 
     */
    public InfoBrandRicaricheRequest createInfoBrandRicaricheRequest() {
        return new InfoBrandRicaricheRequest();
    }

    /**
     * Create an instance of {@link InfoBrandRicaricheResponse }
     * 
     */
    public InfoBrandRicaricheResponse createInfoBrandRicaricheResponse() {
        return new InfoBrandRicaricheResponse();
    }

    /**
     * Create an instance of {@link InfoBrandRicaricheResponse2 }
     * 
     */
    public InfoBrandRicaricheResponse2 createInfoBrandRicaricheResponse2() {
        return new InfoBrandRicaricheResponse2();
    }

    /**
     * Create an instance of {@link InfoTagliRicariche }
     * 
     */
    public InfoTagliRicariche createInfoTagliRicariche() {
        return new InfoTagliRicariche();
    }

    /**
     * Create an instance of {@link InfoTaglioRicaricheRequest }
     * 
     */
    public InfoTaglioRicaricheRequest createInfoTaglioRicaricheRequest() {
        return new InfoTaglioRicaricheRequest();
    }

    /**
     * Create an instance of {@link InfoTagliRicaricheResponse }
     * 
     */
    public InfoTagliRicaricheResponse createInfoTagliRicaricheResponse() {
        return new InfoTagliRicaricheResponse();
    }

    /**
     * Create an instance of {@link InfoTaglioRicaricheResponse }
     * 
     */
    public InfoTaglioRicaricheResponse createInfoTaglioRicaricheResponse() {
        return new InfoTaglioRicaricheResponse();
    }

    /**
     * Create an instance of {@link GenericRequest }
     * 
     */
    public GenericRequest createGenericRequest() {
        return new GenericRequest();
    }

    /**
     * Create an instance of {@link GenericResponse }
     * 
     */
    public GenericResponse createGenericResponse() {
        return new GenericResponse();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link ArrayOfBrand }
     * 
     */
    public ArrayOfBrand createArrayOfBrand() {
        return new ArrayOfBrand();
    }

    /**
     * Create an instance of {@link Brand }
     * 
     */
    public Brand createBrand() {
        return new Brand();
    }

    /**
     * Create an instance of {@link ArrayOfTaglio }
     * 
     */
    public ArrayOfTaglio createArrayOfTaglio() {
        return new ArrayOfTaglio();
    }

    /**
     * Create an instance of {@link Taglio }
     * 
     */
    public Taglio createTaglio() {
        return new Taglio();
    }
    
    public ReserveAcquistoPinRequest createReserveAcquistoPinRequest() {
    	return new ReserveAcquistoPinRequest();
    }
    
    public ReserveAcquistoPinResponse createReserveAcquistoPinResponse() {
    	return new ReserveAcquistoPinResponse();
    }

}
