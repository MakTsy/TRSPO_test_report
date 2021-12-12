package com.studenttest.trspo_test_report.api.dto;

import java.util.List;

public record Question(long id, long testId, String text, List<Answer> answers) {
}
