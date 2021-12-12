package com.studenttest.trspo_test_report.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.studenttest.trspo_test_report.api.dto.Answer;
import com.studenttest.trspo_test_report.api.dto.Question;
import com.studenttest.trspo_test_report.api.dto.UserAnswer;
import com.studenttest.trspo_test_report.clients.TestManagementClient;
import com.studenttest.trspo_test_report.clients.TestPassingClient;
import com.studenttest.trspo_test_report.repo.TestReportRepo;
import com.studenttest.trspo_test_report.repo.model.TestReport;
import com.studenttest.trspo_test_report.service.TestReportService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TestReportServiceImpl implements TestReportService {

    private final TestReportRepo testReportRepo;

    public TestReport fetchTestReportByUserIdAndTestId(long userId, long testId) {
        return testReportRepo.getTestReportByUserIdAndTestId(userId, testId);
    }

    public List<TestReport> fetchTestReportsForUser(long userId) {
        return testReportRepo.getAllByUserId(userId);
    }

    public List<TestReport> fetchReportsForTest(long testId) {
        return testReportRepo.getAllByTestId(testId);
    }

    public long createTestReport(long userId, long testId) {
        long questionNumber = TestManagementClient.getTestAnswers(testId).size();
        long correctAnswersNumber = getCorrectAnswers(userId, testId);
        final TestReport testReport = new TestReport(userId, testId, correctAnswersNumber, questionNumber);
        final TestReport savedTestReport = testReportRepo.save(testReport);

        return savedTestReport.getId();
    }

    private long getCorrectAnswers(long userId, long testId) {
        Map<Long, Long> expectedAnswers = TestManagementClient.getTestAnswers(testId).stream()
                .collect(Collectors.toMap(Question::id, question -> question.answers().stream()
                        .filter(Answer::isCorrect).findFirst().orElseThrow().id()));
        Map<Long, Long> actualAnswer = TestPassingClient.getUserAnswersOnTest(testId, userId).stream()
                .collect(Collectors.toMap(UserAnswer::questionId, UserAnswer::answerId));

        AtomicInteger count = new AtomicInteger(0);
        expectedAnswers.keySet().forEach(answerKey -> {
            if(expectedAnswers.get(answerKey).equals(actualAnswer.get(answerKey)))
                count.addAndGet(1);
        });

        return count.longValue();
    }




}
