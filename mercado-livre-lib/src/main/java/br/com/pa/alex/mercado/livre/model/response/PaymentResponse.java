package br.com.pa.alex.mercado.livre.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PaymentResponse {

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

    @JsonProperty("CreditCard")
    public CreditCardResponse creditCardResponse;

    @JsonProperty("IsCryptoCurrencyNegotiation")
    public boolean isCryptoCurrencyNegotiation;

    @JsonProperty("tryautomaticcancellation")
    public boolean tryautomaticcancellation;
    @JsonProperty("ProofOfSale")
    public String proofOfSale;

    @JsonProperty("Tid")
    public String tid;

    @JsonProperty("AuthorizationCode")
    public String authorizationCode;

    @JsonProperty("PaymentId")
    public String paymentId;

    @JsonProperty("Type")
    public String type;

    @JsonProperty("Amount")
    public int amount;

    @JsonProperty("Currency")
    public String currency;

    @JsonProperty("Country")
    public String country;

    @JsonProperty("ExtraDataCollection")
    public List<Object> extraDataCollection;

    @JsonProperty("Status")
    public int status;

    @JsonProperty("ReturnCode")
    public String returnCode;

    @JsonProperty("ReturnMessage")
    public String returnMessage;

    @JsonProperty("Links")
    public List<LinkResponse> links;

}
