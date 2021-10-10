/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.eccomerce.payments.consumer.amqp.impl;

import br.com.eccomerce.payments.consumer.amqp.RePublishRabbitMQ;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-consist-accounts-domain
 * @since 04/09/2020
 */
@Component
public class RePublishRabbitMQImpl implements RePublishRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.dead-letter.producer}")
    private String deadLetter;

    @Value("${spring.rabbitmq.request.parking-lot.producer}")
    private String parkingLot;

    private static final String X_RETRIES_HEADER = "x-retries";

    @Override
    public void rePublish() {
        List<Message> messages = getQueueMessages();

        messages.forEach(message -> {
            Map<String, Object> headers = message.getMessageProperties().getHeaders();
            Integer retriesHeader = (Integer) headers.get(X_RETRIES_HEADER);

            if (retriesHeader == null) {
                retriesHeader = 0;
            }

            if (retriesHeader < 3) {
                headers.put(X_RETRIES_HEADER, retriesHeader + 1);
                rabbitTemplate.send(exchange, queue, message);
            } else {
                rabbitTemplate.send(parkingLot, message);
            }
        });
    }

    private List<Message> getQueueMessages() {
        List<Message> messages = new ArrayList<>();
        Boolean isNull;
        Message message;

        do {
            message = rabbitTemplate.receive(deadLetter);
            isNull = message != null;

            if (Boolean.TRUE.equals(isNull)) {
                messages.add(message);
            }
        } while (Boolean.TRUE.equals(isNull));

        return messages;
    }

}
