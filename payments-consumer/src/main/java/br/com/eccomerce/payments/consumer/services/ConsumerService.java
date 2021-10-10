package br.com.eccomerce.payments.consumer.services;

import br.com.eccomerce.payments.consumer.model.PaymentMessage;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-consist-accounts-domain
 * @since 04/09/2020
 */
public interface ConsumerService {

    void action(PaymentMessage mailDetails);

}
