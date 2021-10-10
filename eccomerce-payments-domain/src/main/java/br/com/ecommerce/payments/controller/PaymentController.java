/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.ecommerce.payments.controller;

import br.com.ecommerce.payments.api.PaymentControllerApi;
import br.com.ecommerce.payments.model.Payment;
import br.com.ecommerce.payments.services.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: eccomerce-payments-domain
 * @since 28/03/2021
 */
@Log4j2
@RestController
public class PaymentController implements PaymentControllerApi {
    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Payment> creditCardPayment(@Valid Payment paymentGateway) {
        Payment payment = service.creditCardPayment(paymentGateway);

        return new ResponseEntity<>(payment, HttpStatus.CREATED);
    }

}
