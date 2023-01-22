package com.studenttest.trspo_test_report.repo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "test_report")
@NoArgsConstructor
public class TestReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    long id;
    long userId;
    @Column
    long testId;
    @Column
    long correctAnswersNumber;
    @Column
    long questionNumber;
    @Column
    String datetime;

    public TestReport(long userId, long testId, long correctAnswersNumber, long questionNumber, String datetime) {
        this.userId = userId;
        this.testId = testId;
        this.correctAnswersNumber = correctAnswersNumber;
        this.questionNumber = questionNumber;
        this.datetime = datetime;
    }
}