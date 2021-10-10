package br.com.eccomerce.payments.consumer.services.impl;

import br.com.eccomerce.payments.consumer.model.PaymentData;
import br.com.eccomerce.payments.consumer.model.PaymentMessage;
import br.com.eccomerce.payments.consumer.services.ConsumerService;
import br.com.eccomerce.payments.consumer.strategy.payment.PaymentStrategy;
import br.com.eccomerce.payments.consumer.strategy.payment.PaymentsEnum;
import br.com.eccomerce.payments.consumer.strategy.payment.PaymentsFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-consist-accounts-domain
 * @since 04/09/2020
 */
@Log4j2
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Value("${payment.vendor}")
    private String PAYMENTS_VENDOR;

    private PaymentsFactory paymentsFactory;

    @Autowired
    public ConsumerServiceImpl(PaymentsFactory paymentsFactory) {
        this.paymentsFactory = paymentsFactory;
    }

    @Override
    public void action(PaymentMessage paymentMessageData) {
        PaymentStrategy payment = paymentsFactory.findStrategy(PaymentsEnum.valueOf(PAYMENTS_VENDOR));
        PaymentData paymentData = payment.doPayment(paymentMessageData);
        // AQUI PODERÍAMOS DAR DESTINO AO PAGAMENTO, SEJA UM BANCO DE DADOS OU INTEGRAÇÃO
        // exemplo: repository.save(paymentData)
    }


}
