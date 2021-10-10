package br.com.pa.alex.cielo.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomerResponse {

    @JsonProperty("Name")
    private String name;

}
