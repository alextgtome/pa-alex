/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 10/10/2021
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetnetRequest {

    private String cardNumber;

    private String orderId;

    private String cardholderName;

    private String expirationYear;

    private String expirationMonth;

    private String securityCode;

    private String brand;

    private String amount;

}
