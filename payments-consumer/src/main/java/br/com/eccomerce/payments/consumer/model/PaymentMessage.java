package br.com.eccomerce.payments.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMessage {

    private String currency = null;

    private String country = null;

    private String type = null;

    private Long amount = null;

    private Integer installments = null;

    private String softDescriptor = null;

    private CreditCardMessage creditCard = null;

}

