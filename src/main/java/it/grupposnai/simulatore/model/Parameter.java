package it.grupposnai.simulatore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parameter {
    @JsonProperty
    private String key;
    @JsonProperty
    private String value;

    public Parameter() {
    }

    public Parameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
