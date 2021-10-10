/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.eccomerce.payments.consumer.strategy.payment;

import br.com.eccomerce.payments.consumer.model.PaymentData;
import br.com.eccomerce.payments.consumer.model.PaymentMessage;
import br.com.pa.alex.cielo.integration.CieloPaymentService;
import br.com.pa.alex.cielo.model.request.CieloRequest;
import br.com.pa.alex.cielo.model.request.CreditCardRequest;
import br.com.pa.alex.cielo.model.request.CustomerRequest;
import br.com.pa.alex.cielo.model.request.PaymentRequest;
import br.com.pa.alex.cielo.model.response.CieloResponse;
import br.com.pa.alex.getnet.util.JsonConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: payments-consumer
 * @since 10/10/2021
 */
@Log4j2
@Component
public class CieloIntegration implements PaymentStrategy {

    private CieloPaymentService paymentService;

    private JsonConverter jsonConverter;

    @Autowired
    public CieloIntegration(CieloPaymentService paymentService, JsonConverter jsonConverter) {
        this.paymentService = paymentService;
        this.jsonConverter = jsonConverter;
    }

    @Override
    public PaymentData doPayment(PaymentMessage paymentMessageData) {
        log.info("INICIOU INTEGRAÇÃO COM CIELO");
        log.info("PAYLOAD: " + jsonConverter.toJson(paymentMessageData));
        CieloResponse cieloResponse = paymentService.simpleCreditCardPayment(buildAndCreateCieloPayment(paymentMessageData));
        log.info("ENCERROU INTEGRAÇÃO COM CIELO");
        log.info("RESPONSE PAYLOAD: " + jsonConverter.toJson(cieloResponse));
        return convertCieloResponse(paymentMessageData, cieloResponse);
    }

    @Override
    public PaymentsEnum getPaymentName() {
        return PaymentsEnum.CIELO;
    }

    private CieloRequest buildAndCreateCieloPayment(PaymentMessage paymentMessageData) {

        CreditCardRequest creditCardRequest = CreditCardRequest
                .builder()
                .brand(paymentMessageData.getCreditCard().getBrand())
                .cardNumber(paymentMessageData.getCreditCard().getCardNumber())
                .expirationDate(paymentMessageData.getCreditCard().getExpirationDate())
                .holder(paymentMessageData.getCreditCard().getHolder())
                .securityCode(paymentMessageData.getCreditCard().getSecurityCode())
                .build();
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .creditCard(creditCardRequest)
                .amount(paymentMessageData.getAmount().intValue())
                .capture(Boolean.TRUE)
                .currency(paymentMessageData.getCurrency())
                .softDescriptor(paymentMessageData.getSoftDescriptor())
                .build();
        CustomerRequest customerRequest = CustomerRequest.builder()
                .name(paymentMessageData.getCreditCard().getHolder())
                .build();
        CieloRequest cieloRequest = CieloRequest.builder()
                .merchantOrderId(String.valueOf(Math.random() * (800000 - 1) + 1))
                .payment(paymentRequest)
                .customerRequest(customerRequest)
                .build();
        return cieloRequest;
    }

    private PaymentData convertCieloResponse(PaymentMessage paymentMessageData, CieloResponse cieloResponse) {
        return PaymentData.builder()
                .paymentId(cieloResponse.getPaymentResponse().getPaymentId())
                .paymentName(PaymentsEnum.CIELO)
                .amount(paymentMessageData.getAmount().toString())
                .returnMessage(cieloResponse.getPaymentResponse().getReturnMessage())
                .status(String.valueOf(cieloResponse.getPaymentResponse().getStatus()))
                .build();
    }

}
