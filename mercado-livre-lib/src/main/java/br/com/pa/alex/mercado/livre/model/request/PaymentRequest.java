package br.com.pa.alex.mercado.livre.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequest {

    @JsonProperty("Currency")
    public String currency;

    @JsonProperty("Country")
    public String country;

    @JsonProperty("ServiceTaxAmount")
    public int serviceTaxAmount;

    @JsonProperty("Installments")
    public int installments;

    @JsonProperty("Interest")
    public String interest;

    @JsonProperty("Capture")
    public boolean capture;

    @JsonProperty("Authenticate")
    public boolean authenticate;

    @JsonProperty("SoftDescriptor")
    public String softDescriptor;

    @JsonProperty("CreditCard")
    public CreditCardRequest creditCard;

    @JsonProperty("IsCryptoCurrencyNegotiation")
    public boolean isCryptoCurrencyNegotiation;

    @JsonProperty("Type")
    public String type;

    @JsonProperty("Amount")
    public int amount;

    @JsonProperty("AirlineData")
    public AirlineDataRequest airlineDataRequest;

}
