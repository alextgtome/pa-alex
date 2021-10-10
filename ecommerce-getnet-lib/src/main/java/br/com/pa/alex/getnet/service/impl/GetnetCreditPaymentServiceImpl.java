/*
 *  CONSIST - Consultoria e Sistemas
 *  Projeto Licenciado pela Empresa CONSIST - Consultoria e Sistemas
 */
package br.com.pa.alex.getnet.service.impl;

import br.com.pa.alex.getnet.model.CardToken;
import br.com.pa.alex.getnet.model.GetnetCreditPaymentRequest;
import br.com.pa.alex.getnet.model.GetnetCreditPaymentResponse;
import br.com.pa.alex.getnet.model.TokenCardRequest;
import br.com.pa.alex.getnet.service.GetnetCreditPaymentService;
import br.com.pa.alex.getnet.util.JsonConverter;
import lombok.extern.log4j.Log4j2;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Alex Trindade Gomes Tomé <alex.tome@cs-consist.com>
 * @Project: ecommerce-getnet-lib
 * @since 03/10/2021
 */
@Log4j2
@Service
public class GetnetCreditPaymentServiceImpl implements GetnetCreditPaymentService {

    @Value("${getnet.url}")
    private String GETNET_URL;

    private JsonConverter jsonConverter;

    public GetnetCreditPaymentServiceImpl(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    @Override
    public String cardTokenization(String accessToken, TokenCardRequest cardNumber) {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        HttpHeaders headers = createGetnetHeaders(accessToken);
        String bodyMap = jsonConverter.toJson(cardNumber);
        HttpEntity<String> httpEntity = new HttpEntity<>(bodyMap, headers);
        ResponseEntity<String> response = restTemplate.exchange(GETNET_URL.concat("/v1/tokens/card"), HttpMethod.POST, httpEntity, String.class);
        return jsonConverter.fromJson(response.getBody(), CardToken.class).getNumberToken();
    }

    @Override
    public GetnetCreditPaymentResponse simpleCreditCardPayment(String accessToken, GetnetCreditPaymentRequest getnetCreditPaymentRequest) {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        HttpHeaders headers = createGetnetHeaders(accessToken);
        String bodyMap = jsonConverter.toJson(getnetCreditPaymentRequest);
        HttpEntity<String> httpEntity = new HttpEntity<>(bodyMap, headers);
        ResponseEntity<String> response = restTemplate.exchange(GETNET_URL.concat("/v1/payments/credit"), HttpMethod.POST, httpEntity, String.class);
        return jsonConverter.fromJson(response.getBody(), GetnetCreditPaymentResponse.class);
    }

    private HttpHeaders createGetnetHeaders(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer ".concat(accessToken));
        headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));
        return headers;
    }
}
