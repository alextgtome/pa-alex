/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.payments.services;

import br.com.ecommerce.payments.model.Payment;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: eccomerce-payments-domain
 * @since 28/03/2021
 */
public interface PaymentService {

    Payment creditCardPayment(Payment paymentGateway);
}
