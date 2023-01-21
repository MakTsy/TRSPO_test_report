package com.studenttest.trspo_test_report.api.dto;

public record TestReport(String datetime, long userId, long testId, int correctAnswersNumber, int questionNumber) {
}
