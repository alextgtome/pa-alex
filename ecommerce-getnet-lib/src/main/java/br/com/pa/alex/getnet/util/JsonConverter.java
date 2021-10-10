/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 10/10/2021
 */
@Log4j2
@Component
public class JsonConverter {

    private final ObjectMapper mapper;

    public JsonConverter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public <T> T fromJson(String payload, Class<T> clazz) {
        try {
            return mapper.readValue(payload, clazz);
        } catch (JsonProcessingException e) {
            log.error(e.getStackTrace());
        }
        return null;
    }

    public String toJson(Object payload) {
        try {
            return mapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            log.error(e.getStackTrace());
        }
        return null;
    }

}
