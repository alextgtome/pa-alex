/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.payments.amqp;

import br.com.ecommerce.payments.messages.PaymentMessage;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-consist-accounts-domain
 * @since 03/09/2020
 */
public interface ProducerRabbitMQ<T> {
    void producer(PaymentMessage t);
}