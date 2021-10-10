/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.cielo.integration;

import br.com.pa.alex.cielo.model.request.CieloRequest;
import br.com.pa.alex.cielo.model.response.CieloResponse;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-cielo-lib
 * @since 28/03/2021
 */
public interface CieloPaymentService {


    CieloResponse simpleCreditCardPayment(CieloRequest cieloRequest);

    CieloResponse creditCardPayment(CieloRequest cieloRequest);

}
