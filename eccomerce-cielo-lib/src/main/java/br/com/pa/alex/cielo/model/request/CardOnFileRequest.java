package br.com.pa.alex.cielo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CardOnFileRequest {

    @JsonProperty("Usage")
    private String usage;

    @JsonProperty("Reason")
    private String reason;

}
