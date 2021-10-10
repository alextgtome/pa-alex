package br.com.pa.alex.mercado.livre.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CardOnFileResponse {

    @JsonProperty("Usage")
    public String usage;

    @JsonProperty("Reason")
    public String reason;

}
