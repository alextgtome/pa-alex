package br.com.pa.alex.cielo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CardOnFileResponse {

    @JsonProperty("Usage")
    private String usage;

    @JsonProperty("Reason")
    private String reason;

}
