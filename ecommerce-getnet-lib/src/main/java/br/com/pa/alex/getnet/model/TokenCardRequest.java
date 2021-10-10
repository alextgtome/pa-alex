/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 10/10/2021
 */
@Getter
@Setter
public class TokenCardRequest {

    @JsonProperty("card_number")
    private String cardNumber;

    public TokenCardRequest(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
