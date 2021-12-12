package com.studenttest.trspo_test_report.service;

import java.util.List;

import com.studenttest.trspo_test_report.repo.model.TestReport;

public interface TestReportService {
    TestReport fetchTestReportByUserIdAndTestId(long userId, long testId);
    List<TestReport> fetchTestReportsForUser(long userId);
    List<TestReport> fetchReportsForTest(long testId);
    long createTestReport(long userId, long testId);
}
