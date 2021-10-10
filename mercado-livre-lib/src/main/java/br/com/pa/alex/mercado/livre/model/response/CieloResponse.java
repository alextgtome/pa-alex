package br.com.pa.alex.mercado.livre.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CieloResponse {

    @JsonProperty("MerchantOrderId")
    public String merchantOrderId;

    @JsonProperty("Customer")
    public CustomerResponse customer;

    @JsonProperty("Payment")
    public PaymentResponse paymentResponse;

}
