/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.mercado.livre.integration.impl;

import br.com.pa.alex.cielo.integration.CieloPaymentService;
import br.com.pa.alex.cielo.model.request.CieloRequest;
import br.com.pa.alex.cielo.model.response.CieloResponse;
import br.com.pa.alex.cielo.model.response.PaymentResponse;
import cieloecommerce.sdk.Merchant;
import cieloecommerce.sdk.ecommerce.*;
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
    private static String MERCHANT_ID;

    @Value("${cielo.keys.merchantKey}")
    private static String MERCHANT_KEY;

    @Override
    public CieloResponse simpleCreditCardPayment(CieloRequest cieloRequest) {

        Merchant merchant = new Merchant(MERCHANT_ID, MERCHANT_KEY);

        // Crie uma instância de Sale informando o ID do pagamento
        Sale sale = new Sale(cieloRequest.getMerchantOrderId());

        // Crie uma instância de Customer informando o nome do cliente
        Customer customer = sale.customer(cieloRequest.customerRequest.getName());

        // Crie uma instância de Payment informando o valor do pagamento
        Payment payment = sale.payment(cieloRequest.getPayment().getAmount());

        // Crie  uma instância de Credit Card utilizando os dados de teste
        // esses dados estão disponíveis no manual de integração
        payment.creditCard(
                cieloRequest.getPayment().getCreditCard().getSecurityCode(),
                cieloRequest.getPayment().getCreditCard().getBrand())
                .setExpirationDate(cieloRequest.getPayment().getCreditCard().getExpirationDate())
                .setCardNumber(cieloRequest.getPayment().getCreditCard().getCardNumber())
                .setHolder(cieloRequest.getPayment().getCreditCard().getHolder());

        // Crie o pagamento na Cielo
        CieloResponse response = new CieloResponse();
        try {
            // Configure o SDK com seu merchant e o ambiente apropriado para criar a venda
            sale = new CieloEcommerce(merchant, Environment.SANDBOX).createSale(sale);

            // Com a venda criada na Cielo, já temos o ID do pagamento, TID e demais
            // dados retornados pela Cielo
            String paymentId = sale.getPayment().getPaymentId();

            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setPaymentId(paymentId);
            paymentResponse.setReturnCode(sale.getPayment().getReturnCode());
            paymentResponse.setStatus(sale.getPayment().getStatus());
            paymentResponse.setReturnMessage(sale.getPayment().getReturnMessage());
            response.setPaymentResponse(paymentResponse );
            // Com o ID do pagamento, podemos fazer sua captura, se ela não tiver sido capturada ainda
//             sale = new CieloEcommerce(merchant, Environment.SANDBOX).captureSale(paymentId, 15700, 0);
//
//            // E também podemos fazer seu cancelamento, se for o caso
//            sale = new CieloEcommerce(merchant, Environment.SANDBOX).cancelSale(paymentId, 15700);
        } catch (CieloRequestException e) {
            // Em caso de erros de integração, podemos tratar o erro aqui.
            // os códigos de erro estão todos disponíveis no manual de integração.
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
