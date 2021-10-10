package br.com.pa.alex.mercado.livre.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeliveryAddressRequest {

    @JsonProperty("Street")
    public String street;

    @JsonProperty("Number")
    public String number;

    @JsonProperty("Complement")
    public String complement;

    @JsonProperty("ZipCode")
    public String zipCode;

    @JsonProperty("City")
    public String city;

    @JsonProperty("State")
    public String state;

    @JsonProperty("Country")
    public String country;

}
