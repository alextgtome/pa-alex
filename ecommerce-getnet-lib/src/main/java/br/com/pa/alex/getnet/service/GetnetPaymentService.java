/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.service;

import br.com.pa.alex.getnet.model.GetnetCreditPaymentResponse;
import br.com.pa.alex.getnet.model.GetnetRequest;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 10/10/2021
 */
public interface GetnetPaymentService {

    GetnetCreditPaymentResponse creditPayment(GetnetRequest getnetCreditPaymentRequest);

}
