package it.grupposnai.paymatservices.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.grupposnai.paymatservices.model.Parameter;

import java.util.List;

public class CheckPlayerResponse {
    @JsonProperty("isPlayer")
    private boolean isPlayer;

    private ErrorRicaricaContoGiocoAircash error;

    private List<Parameter> parameters;

    @JsonProperty("isPlayer")
    public boolean isPlayer() {
        return isPlayer;
    }
    @JsonProperty("isPlayer")
    public void setPlayer(boolean player) {
        isPlayer = player;
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
        return "CheckPlayerResponse{" +
                "isPlayer=" + isPlayer +
                ", error=" + error +
                ", parameters=" + parameters +
                '}';
    }
}
