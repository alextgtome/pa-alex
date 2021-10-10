/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 03/10/2021
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("document_number")
    private String documentNumber;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("billing_address")
    private BillingAddress billingAddress;

}
