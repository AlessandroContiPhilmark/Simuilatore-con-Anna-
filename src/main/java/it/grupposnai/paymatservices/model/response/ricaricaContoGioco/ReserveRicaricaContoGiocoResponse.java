package it.grupposnai.paymatservices.model.response.ricaricaContoGioco;

import javax.xml.bind.annotation.XmlType;


@XmlType(name = "ReserveRicaricaContoGiocoResponse")
public class ReserveRicaricaContoGiocoResponse {

    private String callerId;
    private String requestId;
    private String fiscalCode;
    private String amount;
    private Integer currencyId;
    private String barCode;
    private String contoGioco;
    private Integer resultCode;
    private String resultDesc;
    private String reserveCode;

    private String cro;

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

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getReserveCode() {
        return reserveCode;
    }

    public void setReserveCode(String reserveCode) {
        this.reserveCode = reserveCode;
    }

    public String getContoGioco() {
        return contoGioco;
    }

    public void setContoGioco(String contoGioco) {
        this.contoGioco = contoGioco;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    @Override
    public String toString() {
        return "ReserveRicaricaContoGiocoResponse{" +
                "callerId='" + callerId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", fiscalCode='" + fiscalCode + '\'' +
                ", amount='" + amount + '\'' +
                ", currencyId=" + currencyId +
                ", barCode='" + barCode + '\'' +
                ", contoGioco='" + contoGioco + '\'' +
                ", resultCode=" + resultCode +
                ", resultDesc='" + resultDesc + '\'' +
                ", reserveCode='" + reserveCode + '\'' +
                ", cro='" + cro + '\'' +
                '}';
    }
}
