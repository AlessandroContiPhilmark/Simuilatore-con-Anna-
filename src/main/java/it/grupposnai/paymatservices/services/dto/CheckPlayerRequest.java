package it.grupposnai.paymatservices.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.grupposnai.paymatservices.model.Parameter;

import java.util.List;

public class CheckPlayerRequest {
    @JsonProperty
    private List<Parameter> parameters;

    @JsonProperty
    private String signature;

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
        return "CheckPlayerRequest{" +
                "parameters=" + parameters +
                ", signature='" + signature + '\'' +
                '}';
    }
}
