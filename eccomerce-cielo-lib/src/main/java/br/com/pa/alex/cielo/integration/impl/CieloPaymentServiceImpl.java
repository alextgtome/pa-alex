/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.cielo.integration.impl;

import br.com.pa.alex.cielo.integration.CieloPaymentService;
import br.com.pa.alex.cielo.model.request.CieloRequest;
import br.com.pa.alex.cielo.model.response.CieloResponse;
import br.com.pa.alex.cielo.model.response.PaymentResponse;
import cieloecommerce.sdk.Merchant;
import cieloecommerce.sdk.ecommerce.CieloEcommerce;
import cieloecommerce.sdk.ecommerce.Environment;
import cieloecommerce.sdk.ecommerce.Payment;
import cieloecommerce.sdk.ecommerce.Sale;
import cieloecommerce.sdk.ecommerce.request.CieloError;
import cieloecommerce.sdk.ecommerce.request.CieloRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-cielo-lib
 * @since 28/03/2021
 */

@Service
public class CieloPaymentServiceImpl implements CieloPaymentService {

    @Value("${cielo.keys.merchantId}")
    private String MERCHANT_ID;

    @Value("${cielo.keys.merchantKey}")
    private String MERCHANT_KEY;

    @Override
    public CieloResponse simpleCreditCardPayment(CieloRequest cieloRequest) {
        Merchant merchant = new Merchant(MERCHANT_ID, MERCHANT_KEY);
        Sale sale = new Sale(cieloRequest.getMerchantOrderId());
        Payment payment = sale.payment(cieloRequest.getPayment().getAmount());
        payment.setCapture(Boolean.TRUE);
        payment.creditCard(cieloRequest.getPayment().getCreditCard().getSecurityCode(),
                        cieloRequest.getPayment().getCreditCard().getBrand())
                .setExpirationDate(cieloRequest.getPayment().getCreditCard().getExpirationDate())
                .setCardNumber(cieloRequest.getPayment().getCreditCard().getCardNumber())
                .setHolder(cieloRequest.getPayment().getCreditCard().getHolder());
        CieloResponse response = new CieloResponse();
        try {
            sale = new CieloEcommerce(merchant, Environment.SANDBOX).createSale(sale);

            String paymentId = sale.getPayment().getPaymentId();

            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setPaymentId(paymentId);
            paymentResponse.setReturnCode(sale.getPayment().getReturnCode());
            paymentResponse.setStatus(sale.getPayment().getStatus());
            paymentResponse.setReturnMessage(sale.getPayment().getReturnMessage());
            response.setPaymentResponse(paymentResponse);
        } catch (CieloRequestException e) {
            CieloError error = e.getError();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public CieloResponse creditCardPayment(CieloRequest cieloRequest) {
        return null;
    }
}
