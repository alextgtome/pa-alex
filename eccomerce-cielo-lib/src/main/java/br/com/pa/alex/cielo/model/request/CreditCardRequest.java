package br.com.pa.alex.cielo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardRequest {

    @JsonProperty("CardNumber")
    private String cardNumber;

    @JsonProperty("Holder")
    private String holder;

    @JsonProperty("ExpirationDate")
    private String expirationDate;

    @JsonProperty("SecurityCode")
    private String securityCode;

    @JsonProperty("SaveCard")
    private String saveCard;

    @JsonProperty("Brand")
    private String brand;

    @JsonProperty("CardOnFile")
    private CardOnFileRequest cardOnFileRequest;

}
