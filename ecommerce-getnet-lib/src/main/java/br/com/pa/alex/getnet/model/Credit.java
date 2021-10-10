/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.model;

import br.com.pa.alex.getnet.TransactionTypeEnum;
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
public class Credit {

    @JsonProperty("delayed")
    private final boolean delayed = false;

    @JsonProperty("save_card_data")
    private final boolean saveCardData = false;

    @JsonProperty("transaction_type")
    private final TransactionTypeEnum transactionType = TransactionTypeEnum.FULL;

    @JsonProperty("number_installments")
    private final int numberInstallments = 1;

    @JsonProperty("card")
    private Card card;

}
