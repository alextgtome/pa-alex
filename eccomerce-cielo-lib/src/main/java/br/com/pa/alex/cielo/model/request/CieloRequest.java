package br.com.pa.alex.cielo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CieloRequest {

    @JsonProperty("MerchantOrderId")
    private String merchantOrderId;

    @JsonProperty("Customer")
    private CustomerRequest customerRequest;

    @JsonProperty("Payment")
    private PaymentRequest payment;

}
