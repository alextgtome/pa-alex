package br.com.pa.alex.cielo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequest {

    @JsonProperty("Currency")
    private String currency;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("ServiceTaxAmount")
    private int serviceTaxAmount;

    @JsonProperty("Installments")
    private int installments;

    @JsonProperty("Interest")
    private String interest;

    @JsonProperty("Capture")
    private boolean capture;

    @JsonProperty("Authenticate")
    private boolean authenticate;

    @JsonProperty("SoftDescriptor")
    private String softDescriptor;

    @JsonProperty("CreditCard")
    private CreditCardRequest creditCard;

    @JsonProperty("IsCryptoCurrencyNegotiation")
    private boolean isCryptoCurrencyNegotiation;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Amount")
    private int amount;

    @JsonProperty("AirlineData")
    private AirlineDataRequest airlineDataRequest;

}
