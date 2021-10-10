package br.com.pa.alex.mercado.livre.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreditCardResponse {

    @JsonProperty("CardNumber")
    public String cardNumber;

    @JsonProperty("Holder")
    public String holder;

    @JsonProperty("ExpirationDate")
    public String expirationDate;

    @JsonProperty("SaveCard")
    public boolean saveCard;

    @JsonProperty("Brand")
    public String brand;

    @JsonProperty("CardOnFile")
    public CardOnFileResponse cardOnFileResponse;

}
