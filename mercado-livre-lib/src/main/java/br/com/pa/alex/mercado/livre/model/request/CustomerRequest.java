package br.com.pa.alex.mercado.livre.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequest {

    @JsonProperty("Name")
    public String name;

    @JsonProperty("Email")
    public String email;

    @JsonProperty("Birthdate")
    public String birthdate;

    @JsonProperty("Address")
    public AddressRequest addressRequest;

    @JsonProperty("DeliveryAddress")
    public DeliveryAddressRequest deliveryAddressRequest;

}
