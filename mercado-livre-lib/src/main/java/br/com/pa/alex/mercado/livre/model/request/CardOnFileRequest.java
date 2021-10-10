package br.com.pa.alex.mercado.livre.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CardOnFileRequest {

    @JsonProperty("Usage")
    public String usage;

    @JsonProperty("Reason")
    public String reason;

}
