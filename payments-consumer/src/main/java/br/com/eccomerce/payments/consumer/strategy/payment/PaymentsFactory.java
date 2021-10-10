/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.eccomerce.payments.consumer.strategy.payment;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: payments-consumer
 * @since 10/10/2021
 */
@Log4j2
@Component
public class PaymentsFactory {

    private Map<PaymentsEnum, PaymentStrategy> strategies;

    @Autowired
    public PaymentsFactory(Set<PaymentStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public PaymentStrategy findStrategy(PaymentsEnum strategyName) {
        return strategies.get(strategyName);
    }

    private void createStrategy(Set<PaymentStrategy> strategySet) {
        strategies = new HashMap<PaymentsEnum, PaymentStrategy>();
        strategySet.forEach(
                strategy -> strategies.put(strategy.getPaymentName(), strategy));
    }

}
