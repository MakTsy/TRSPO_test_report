package com.studenttest.trspo_test_report.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studenttest.trspo_test_report.repo.model.TestReport;
import com.studenttest.trspo_test_report.service.impl.TestReportServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/reports")
@RestController
public class TestReportServiceController {

    private final TestReportServiceImpl testReportService;

    @PostMapping("/{userId}/{testId}")
    public ResponseEntity<Void> create(@PathVariable long userId, @PathVariable long testId) {
        testReportService.createTestReport(userId, testId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TestReport>> showReportsForUser(@PathVariable long userId) {
        final List<TestReport> testReports = testReportService.fetchTestReportsForUser(userId);
        return ResponseEntity.ok(testReports);
    }

    @GetMapping("/test/{testId}")
    public ResponseEntity<List<TestReport>> showReportsForTest(@PathVariable long testId) {
        final List<TestReport> testReports = testReportService.fetchReportsForTest(testId);
        return ResponseEntity.ok(testReports);
    }

    @GetMapping("/{userId}/{testId}")
    public ResponseEntity<TestReport> showReportForTestAndUser(@PathVariable long userId, @PathVariable long testId) {
        final TestReport testReports = testReportService.fetchTestReportByUserIdAndTestId(userId, testId);
        return ResponseEntity.ok(testReports);
    }
}
