
package it.grupposnai.simulatore.model;

import javax.xml.bind.annotation.XmlRegistry;

import it.grupposnai.simulatore.model.request.ricarica.CancelRicaricaTelefonicaRequest;
import it.grupposnai.simulatore.model.request.ricarica.ConfirmRicaricaTelefonicaRequest;
import it.grupposnai.simulatore.model.request.ricarica.ReserveRicaricaTelefonicaRequest;
import it.grupposnai.simulatore.model.response.ricarica.CancelRicaricaTelefonicaResponse2;
import it.grupposnai.simulatore.model.response.ricarica.ConfirmRicaricaTelefonicaResponse2;
import it.grupposnai.simulatore.model.response.ricarica.GenericResponse;
import it.grupposnai.simulatore.model.response.ricarica.ReserveRicaricaTelefonicaResponse2;
import it.grupposnai.simulatore.model.response.ricarica.Ticket;


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
     * Create an instance of {@link ReserveRicaricaTelefonicaRequest }
     * 
     */
    public ReserveRicaricaTelefonicaRequest createReserveRicaricaTelefonicaRequest() {
        return new ReserveRicaricaTelefonicaRequest();
    }

    /**
     * Create an instance of {@link ReserveRicaricaTelefonicaResponse2 }
     * 
     */
    public ReserveRicaricaTelefonicaResponse2 createReserveRicaricaTelefonicaResponse2() {
        return new ReserveRicaricaTelefonicaResponse2();
    }

    /**
     * Create an instance of {@link ConfirmRicaricaTelefonicaRequest }
     * 
     */
    public ConfirmRicaricaTelefonicaRequest createConfirmRicaricaTelefonicaRequest() {
        return new ConfirmRicaricaTelefonicaRequest();
    }

    /**
     * Create an instance of {@link ConfirmRicaricaTelefonicaResponse2 }
     * 
     */
    public ConfirmRicaricaTelefonicaResponse2 createConfirmRicaricaTelefonicaResponse2() {
        return new ConfirmRicaricaTelefonicaResponse2();
    }

    /**
     * Create an instance of {@link CancelRicaricaTelefonicaRequest }
     * 
     */
    public CancelRicaricaTelefonicaRequest createCancelRicaricaTelefonicaRequest() {
        return new CancelRicaricaTelefonicaRequest();
    }

    /**
     * Create an instance of {@link CancelRicaricaTelefonicaResponse2 }
     * 
     */
    public CancelRicaricaTelefonicaResponse2 createCancelRicaricaTelefonicaResponse2() {
        return new CancelRicaricaTelefonicaResponse2();
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


    

}
