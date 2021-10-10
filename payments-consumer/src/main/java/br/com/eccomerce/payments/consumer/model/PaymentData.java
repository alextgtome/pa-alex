/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.eccomerce.payments.consumer.model;

import br.com.eccomerce.payments.consumer.strategy.payment.PaymentsEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: payments-consumer
 * @since 10/10/2021
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentData {

    private String paymentId;

    private PaymentsEnum paymentName;

    private String amount;

    private String status;

    private String returnMessage;

}
