package br.com.pa.alex.cielo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AirlineDataRequest {

    @JsonProperty("TicketNumber")
    private String ticketNumber;

}
