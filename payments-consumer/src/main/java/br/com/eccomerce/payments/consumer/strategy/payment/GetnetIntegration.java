/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.eccomerce.payments.consumer.strategy.payment;

import br.com.eccomerce.payments.consumer.model.PaymentData;
import br.com.eccomerce.payments.consumer.model.PaymentMessage;
import br.com.pa.alex.getnet.model.GetnetCreditPaymentResponse;
import br.com.pa.alex.getnet.model.GetnetRequest;
import br.com.pa.alex.getnet.service.GetnetPaymentService;
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
public class GetnetIntegration implements PaymentStrategy {

    private GetnetPaymentService paymentService;

    private JsonConverter jsonConverter;

    @Autowired
    public GetnetIntegration(GetnetPaymentService paymentService, JsonConverter jsonConverter) {
        this.paymentService = paymentService;
        this.jsonConverter = jsonConverter;
    }

    @Override
    public PaymentData doPayment(PaymentMessage paymentMessageData) {
        log.info("INICIOU INTEGRAÇÃO COM GETNET");
        log.info("REQUEST PAYLOAD: " + jsonConverter.toJson(paymentMessageData));
        GetnetCreditPaymentResponse getnetCreditPaymentResponse = paymentService.creditPayment(buildAndCreateGetnetPayment(paymentMessageData));
        log.info("ENCERROU INTEGRAÇÃO COM GETNET");
        log.info("RESPONSE PAYLOAD: " + jsonConverter.toJson(getnetCreditPaymentResponse));
        return convertGetnetResponse(paymentMessageData, getnetCreditPaymentResponse);
    }

    @Override
    public PaymentsEnum getPaymentName() {
        return PaymentsEnum.GETNET;
    }

    private GetnetRequest buildAndCreateGetnetPayment(PaymentMessage paymentMessageData) {
        return GetnetRequest.builder()
                .amount(paymentMessageData.getAmount().toString())
                .brand(paymentMessageData.getCreditCard().getBrand())
                .cardNumber(paymentMessageData.getCreditCard().getCardNumber().replaceAll("\\s", ""))
                .securityCode(paymentMessageData.getCreditCard().getSecurityCode())
                .cardholderName(paymentMessageData.getCreditCard().getHolder())
                .expirationMonth(paymentMessageData.getCreditCard().getExpirationDate().split("/")[0])
                .expirationYear(paymentMessageData.getCreditCard().getExpirationDate().split("/")[1].substring(2))
                .orderId(String.valueOf(Math.random() * (800000 - 1) + 1))
                .build();
    }

    private PaymentData convertGetnetResponse(PaymentMessage paymentMessageData, GetnetCreditPaymentResponse getnetCreditPaymentResponse) {
        return PaymentData.builder()
                .paymentId(getnetCreditPaymentResponse.getPaymentId())
                .paymentName(PaymentsEnum.CIELO)
                .amount(paymentMessageData.getAmount().toString())
                .returnMessage(getnetCreditPaymentResponse.getCredit().getReasonMessage())
                .status(String.valueOf(getnetCreditPaymentResponse.getStatus()))
                .build();
    }
}
