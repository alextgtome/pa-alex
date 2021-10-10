/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 03/10/2021
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @JsonProperty("order_id")
    private String orderId;

    @JsonProperty("sales_tax")
    private String salesTax;

    @JsonProperty("product_type")
    private String productType;

    public Order(String orderId) {
        this.orderId = orderId;
    }

}
