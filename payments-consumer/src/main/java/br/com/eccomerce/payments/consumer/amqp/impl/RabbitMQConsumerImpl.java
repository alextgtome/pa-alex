/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.eccomerce.payments.consumer.amqp.impl;

import br.com.eccomerce.payments.consumer.amqp.RabbitMQConsumer;
import br.com.eccomerce.payments.consumer.model.PaymentMessage;
import br.com.eccomerce.payments.consumer.services.ConsumerService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-consist-accounts-domain
 * @since 04/09/2020
 */
@Component
public class RabbitMQConsumerImpl implements RabbitMQConsumer<PaymentMessage> {

    @Autowired
    private ConsumerService consumerService;

    @Override
    @RabbitListener(queues = "${spring.rabbitmq.request.routing-key.producer}")
    public void consumer(PaymentMessage paymentMessageData) {
        try {
            consumerService.action(paymentMessageData);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }

}
