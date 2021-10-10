package br.com.pa.alex.mercado.livre.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CieloRequest {

    @JsonProperty("MerchantOrderId")
    public String merchantOrderId;

    @JsonProperty("Customer")
    public CustomerRequest customerRequest;

    @JsonProperty("Payment")
    public PaymentRequest payment;

}
