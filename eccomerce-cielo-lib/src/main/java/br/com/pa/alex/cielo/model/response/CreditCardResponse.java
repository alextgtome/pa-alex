package br.com.pa.alex.cielo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreditCardResponse {

    @JsonProperty("CardNumber")
    private String cardNumber;

    @JsonProperty("Holder")
    private String holder;

    @JsonProperty("ExpirationDate")
    private String expirationDate;

    @JsonProperty("SaveCard")
    private boolean saveCard;

    @JsonProperty("Brand")
    private String brand;

    @JsonProperty("CardOnFile")
    private CardOnFileResponse cardOnFileResponse;

}
