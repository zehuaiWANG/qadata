package com.qadata.vo.testReport;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class SimpleTestReportObject {

    private int id;

    private String reportNumber;

    private String testLab;

    private String testResult;

    private String testDate;

    private String testType;

    private String buyer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getTestLab() {
        return testLab;
    }

    public void setTestLab(String testLab) {
        this.testLab = testLab;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
