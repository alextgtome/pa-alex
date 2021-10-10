package br.com.pa.alex.mercado.livre.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerResponse {

    @JsonProperty("Name")
    public String name;

}
