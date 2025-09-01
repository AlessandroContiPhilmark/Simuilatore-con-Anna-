package it.grupposnai.paymatservices.services.dto;

import it.grupposnai.paymatservices.model.Parameter;

import java.util.List;

public class CreateAndConfirmPaymentResponse {

    private boolean success;
    private String partnerTransactionId;
    private ErrorRicaricaContoGiocoAircash error;
    private List<Parameter> parameters;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getPartnerTransactionId() {
        return partnerTransactionId;
    }

    public void setPartnerTransactionId(String partnerTransactionId) {
        this.partnerTransactionId = partnerTransactionId;
    }

    public ErrorRicaricaContoGiocoAircash getError() {
        return error;
    }

    public void setError(ErrorRicaricaContoGiocoAircash error) {
        this.error = error;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "CreateAndConfirmPaymentResponse{" +
                "success=" + success +
                ", partnerTransactionId='" + partnerTransactionId + '\'' +
                ", error=" + error +
                ", parameters=" + parameters +
                '}';
    }
}
