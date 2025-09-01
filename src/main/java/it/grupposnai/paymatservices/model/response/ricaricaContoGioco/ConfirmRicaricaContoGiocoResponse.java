package it.grupposnai.paymatservices.model.response.ricaricaContoGioco;

import it.grupposnai.paymatservices.model.response.ricarica.Ticket;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ConfirmRicaricaContoGiocoResponse")
public class ConfirmRicaricaContoGiocoResponse {

        private String callerId;
        private String requestId;

        private Ticket ticket;
        private Integer resultCode;
        private String resultDesc;


    //capire quali info aggiungere info per stampa scontrino


    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "ConfirmRicaricaContoGiocoResponse{" +
                "callerId='" + callerId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", ticket=" + ticket +
                ", resultCode=" + resultCode +
                ", resultDesc='" + resultDesc + '\'' +
                '}';
    }
}
