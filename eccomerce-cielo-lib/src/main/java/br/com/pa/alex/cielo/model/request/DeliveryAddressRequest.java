package br.com.pa.alex.cielo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeliveryAddressRequest {

    @JsonProperty("Street")
    private String street;

    @JsonProperty("Number")
    private String number;

    @JsonProperty("Complement")
    private String complement;

    @JsonProperty("ZipCode")
    private String zipCode;

    @JsonProperty("City")
    private String city;

    @JsonProperty("State")
    private String state;

    @JsonProperty("Country")
    private String country;

}
