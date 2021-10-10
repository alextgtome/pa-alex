/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.service.impl;

import br.com.pa.alex.getnet.model.GetnetAuthorizationTokenResponse;
import br.com.pa.alex.getnet.service.GetnetAuthorizationService;
import br.com.pa.alex.getnet.util.JsonConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 03/10/2021
 */
@Log4j2
@Service
public class GetnetAuthorizationServiceImpl implements GetnetAuthorizationService {

    @Value("${getnet.keys.scope}")
    private String SCOPE;

    @Value("${getnet.keys.grantType}")
    private String GRANT_TYPE;

    @Value("${getnet.keys.username}")
    private String USERNAME;

    @Value("${getnet.keys.password}")
    private String PASSWORD;

    @Value("${getnet.url}")
    private String GETNET_URL;

    private JsonConverter jsonConverter;

    public GetnetAuthorizationServiceImpl(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @Override
    public GetnetAuthorizationTokenResponse getAuthorizationToken() {
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> bodyMap = buildTokenRequestBody();
        HttpHeaders headers = buildTokenRequestHeaders();
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(bodyMap, headers);
        String response = restTemplate.postForObject(GETNET_URL.concat("/auth/oauth/v2/token"), httpEntity, String.class);
        return jsonConverter.fromJson(response, GetnetAuthorizationTokenResponse.class);
    }

    private MultiValueMap buildTokenRequestBody() {
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("scope", SCOPE);
        body.add("grant_type", GRANT_TYPE);
        return body;
    }

    private HttpHeaders buildTokenRequestHeaders() {
        HttpHeaders headers = new HttpHeaders();
        String token = Base64.getEncoder().encodeToString(USERNAME.concat(":").concat(PASSWORD).getBytes(StandardCharsets.UTF_8));
        headers.add("Authorization", "Basic ".concat(token));
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        return headers;
    }

}
