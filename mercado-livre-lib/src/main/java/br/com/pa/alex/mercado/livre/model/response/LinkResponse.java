package br.com.pa.alex.mercado.livre.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LinkResponse {

    @JsonProperty("Method")
    public String method;

    @JsonProperty("Rel")
    public String rel;

    @JsonProperty("Href")
    public String href;

}
