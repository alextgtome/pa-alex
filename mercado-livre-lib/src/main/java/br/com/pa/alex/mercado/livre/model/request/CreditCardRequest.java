package br.com.pa.alex.mercado.livre.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardRequest {

    @JsonProperty("CardNumber")
    public String cardNumber;

    @JsonProperty("Holder")
    public String holder;

    @JsonProperty("ExpirationDate")
    public String expirationDate;

    @JsonProperty("SecurityCode")
    public String securityCode;

    @JsonProperty("SaveCard")
    public String saveCard;

    @JsonProperty("Brand")
    public String brand;

    @JsonProperty("CardOnFile")
    public CardOnFileRequest cardOnFileRequest;

}
