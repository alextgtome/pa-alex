/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.service.impl;

import br.com.pa.alex.getnet.model.*;
import br.com.pa.alex.getnet.service.GetnetAuthorizationService;
import br.com.pa.alex.getnet.service.GetnetCreditPaymentService;
import br.com.pa.alex.getnet.service.GetnetPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 10/10/2021
 */
@Component
public class GetnetPaymentServiceImpl implements GetnetPaymentService {

    @Value("${getnet.keys.sellerId}")
    private String SELLER_ID;

    private final GetnetAuthorizationService authorizationService;
    private final GetnetCreditPaymentService creditPaymentService;

    @Autowired
    public GetnetPaymentServiceImpl(GetnetAuthorizationService authorizationService, GetnetCreditPaymentService creditPaymentService) {
        this.authorizationService = authorizationService;
        this.creditPaymentService = creditPaymentService;
    }

    @Override
    public GetnetCreditPaymentResponse creditPayment(GetnetRequest request) {
        GetnetAuthorizationTokenResponse token = authorizationService.getAuthorizationToken();
        String CreditCardToken = creditPaymentService.cardTokenization(token.getAccessToken(), new TokenCardRequest(request.getCardNumber()));

        GetnetCreditPaymentRequest getnetCreditPaymentRequest = buildGetnetRequest(request, CreditCardToken);
        GetnetCreditPaymentResponse response = creditPaymentService.simpleCreditCardPayment(token.getAccessToken(), getnetCreditPaymentRequest);

        return response;
    }

    private GetnetCreditPaymentRequest buildGetnetRequest(GetnetRequest request, String creditCardToken) {
        return GetnetCreditPaymentRequest.builder()
                .sellerId(SELLER_ID)
                .amount(request.getAmount())
                .order(new Order(request.getOrderId()))
                .credit(Credit.builder()
                        .card(Card.builder()
                                .cardholderName(request.getCardholderName())
                                .expirationMonth(request.getExpirationMonth())
                                .expirationYear(request.getExpirationYear())
                                .numberToken(creditCardToken)
                                .build())
                        .build())
                .customer(Customer.builder()
                        .customerId("564564654")
                        .billingAddress(BillingAddress.builder().build())
                        .build())
                .build();
    }

}
