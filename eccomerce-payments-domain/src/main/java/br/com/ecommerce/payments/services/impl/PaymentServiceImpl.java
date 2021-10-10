/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.payments.services.impl;

import br.com.ecommerce.payments.amqp.ProducerRabbitMQ;
import br.com.ecommerce.payments.messages.PaymentMessage;
import br.com.ecommerce.payments.model.Payment;
import br.com.ecommerce.payments.services.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-payments-domain
 * @since 28/03/2021
 */
@Log4j2
@Component
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private ProducerRabbitMQ<PaymentMessage> amqp;

    @Override
    public Payment creditCardPayment(Payment paymentGateway) {
        ModelMapper mapper = new ModelMapper();
        PaymentMessage message = mapper.map(paymentGateway, PaymentMessage.class);
        log.info(message.toString());
        amqp.producer(message);
        return paymentGateway;
    }
}
