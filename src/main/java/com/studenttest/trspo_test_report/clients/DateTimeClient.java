package com.studenttest.trspo_test_report.clients;

import java.util.Objects;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class DateTimeClient {

    private DateTimeClient() {}

    private static final String DATE_TIMR_SERVICE_URL_ADRESS = "http://timr-service:8085/time";

    public static String getCurrentTime() {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<String> userRequest = new HttpEntity<String>("");

        final ResponseEntity<String> timeResponse = restTemplate
                .exchange(DATE_TIMR_SERVICE_URL_ADRESS,
                        HttpMethod.GET,userRequest, String.class);
        String questions = Objects.requireNonNull(timeResponse.getBody());
        return Objects.requireNonNull(questions);
    }
}
