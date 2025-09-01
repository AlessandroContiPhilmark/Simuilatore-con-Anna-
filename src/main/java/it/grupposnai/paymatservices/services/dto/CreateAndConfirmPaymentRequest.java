package it.grupposnai.paymatservices.services.dto;

import it.grupposnai.paymatservices.model.Parameter;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateAndConfirmPaymentRequest {

    private String transactionId;
    @NotNull
    private Double amount;
    @NotNull
    private List<Parameter> parameters;
    private String signature;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "CreateAndConfirmPaymentRequest{" +
                "transactionId='" + transactionId + '\'' +
                ", amount=" + amount +
                ", parameters=" + parameters +
                ", signature='" + signature + '\'' +
                '}';
    }
}
