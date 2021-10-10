package br.com.pa.alex.cielo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CieloResponse {

    @JsonProperty("MerchantOrderId")
    private String merchantOrderId;

    @JsonProperty("Customer")
    private CustomerResponse customer;

    @JsonProperty("Payment")
    private PaymentResponse paymentResponse;

}
