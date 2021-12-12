package com.studenttest.trspo_test_report.api.dto;

public record Answer(long id, long questionId, String text, boolean isCorrect) {
}
