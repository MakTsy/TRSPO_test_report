package com.studenttest.trspo_test_report.clients;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.studenttest.trspo_test_report.api.dto.UserAnswer;

public class TestPassingClient {

    private TestPassingClient() {}

    private static final String TEST_PASSING_SERVICE_URL_ADRESS = "http://service-test-passing:8081/pass";

    public static List<UserAnswer> getUserAnswersOnTest(Long testId, Long userId) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<Long> userRequest = new HttpEntity<>(testId);

        final ResponseEntity<UserAnswer[]> answerResponse = restTemplate
                .exchange(TEST_PASSING_SERVICE_URL_ADRESS + "/" + userId + "/" + testId,
                        HttpMethod.GET, userRequest, UserAnswer[].class);
        List<UserAnswer> answers = Arrays.asList(Objects.requireNonNull(answerResponse.getBody()));
        return Objects.requireNonNull(answers);
    }
}
