package br.com.pa.alex.mercado.livre.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirlineDataRequest {

    @JsonProperty("TicketNumber")
    public String ticketNumber;

}
