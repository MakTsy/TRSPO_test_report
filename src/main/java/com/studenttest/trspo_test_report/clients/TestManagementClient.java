package com.studenttest.trspo_test_report.clients;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.studenttest.trspo_test_report.api.dto.Question;

public class TestManagementClient {

    private TestManagementClient() {}

    private static final String TEST_MANAGEMENT_SERVICE_URL_ADRESS ="http://service-test-management:8082/tests";

    public static List<Question> getTestAnswers(Long testId) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<Long> userRequest = new HttpEntity<>(testId);

        final ResponseEntity<Question[]> testResponse = restTemplate
                .exchange(TEST_MANAGEMENT_SERVICE_URL_ADRESS + "/questions/" + testId,
                        HttpMethod.GET, userRequest, Question[].class);
        List<Question> questions = Arrays.asList(Objects.requireNonNull(testResponse.getBody()));
        return Objects.requireNonNull(questions);
    }
}
