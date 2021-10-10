package br.com.pa.alex.cielo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PaymentResponse {

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

    @JsonProperty("CreditCard")
    private CreditCardResponse creditCardResponse;

    @JsonProperty("IsCryptoCurrencyNegotiation")
    private boolean isCryptoCurrencyNegotiation;

    @JsonProperty("tryautomaticcancellation")
    private boolean tryautomaticcancellation;
    @JsonProperty("ProofOfSale")
    private String proofOfSale;

    @JsonProperty("Tid")
    private String tid;

    @JsonProperty("AuthorizationCode")
    private String authorizationCode;

    @JsonProperty("PaymentId")
    private String paymentId;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Amount")
    private int amount;

    @JsonProperty("Currency")
    private String currency;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("ExtraDataCollection")
    private List<Object> extraDataCollection;

    @JsonProperty("Status")
    private int status;

    @JsonProperty("ReturnCode")
    private String returnCode;

    @JsonProperty("ReturnMessage")
    private String returnMessage;

    @JsonProperty("Links")
    private List<LinkResponse> links;

}
