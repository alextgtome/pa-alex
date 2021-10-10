/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.payments.amqp.impl;

import br.com.ecommerce.payments.amqp.ProducerRabbitMQ;
import br.com.ecommerce.payments.messages.PaymentMessage;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-consist-accounts-domain
 * @since 03/09/2020
 */
@Component
public class ProducerRabbitMQImpl implements ProducerRabbitMQ<PaymentMessage> {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Override
    public void producer(PaymentMessage message) {
        try {
            rabbitTemplate.convertAndSend(exchange, queue, message);
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
