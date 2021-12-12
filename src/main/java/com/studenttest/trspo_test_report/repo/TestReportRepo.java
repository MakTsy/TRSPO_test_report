package com.studenttest.trspo_test_report.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studenttest.trspo_test_report.repo.model.TestReport;

public interface TestReportRepo extends JpaRepository<TestReport, Long> {
    @Query
    List<TestReport> getAllByTestId(long testId);

    @Query
    List<TestReport> getAllByUserId(long userId);

    @Query
    TestReport getTestReportByUserIdAndTestId(long userId, long testId);
}
