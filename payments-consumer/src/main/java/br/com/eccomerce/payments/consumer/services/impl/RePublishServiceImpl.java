package br.com.eccomerce.payments.consumer.services.impl;

import br.com.eccomerce.payments.consumer.amqp.RePublishRabbitMQ;
import br.com.eccomerce.payments.consumer.services.RePublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-consist-accounts-domain
 * @since 04/09/2020
 */
@Service
public class RePublishServiceImpl implements RePublishService {

    @Autowired
    private RePublishRabbitMQ rePublish;

    @Override
    public void rePublish() {
        rePublish.rePublish();
    }

}
