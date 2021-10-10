package br.com.pa.alex.cielo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequest {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Birthdate")
    private String birthdate;

    @JsonProperty("Address")
    private AddressRequest addressRequest;

    @JsonProperty("DeliveryAddress")
    private DeliveryAddressRequest deliveryAddressRequest;

}
