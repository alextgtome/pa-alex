/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 10/10/2021
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditResponse {

    @JsonProperty("delayed")
    private boolean delayed;

    @JsonProperty("authorization_code")
    private String authorizationCode;

    @JsonProperty("authorized_at")
    private Date authorizedAt;

    @JsonProperty("reason_code")
    private String reasonCode;

    @JsonProperty("reason_message")
    private String reasonMessage;

    @JsonProperty("acquirer")
    private String acquirer;

    @JsonProperty("soft_descriptor")
    private String softDescriptor;

    @JsonProperty("terminal_nsu")
    private String terminalNsu;

    @JsonProperty("acquirer_transaction_id")
    private String acquirerTransactionId;

    @JsonProperty("transaction_id")
    private String transactionId;

}
