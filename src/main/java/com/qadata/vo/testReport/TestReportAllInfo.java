package com.qadata.vo.testReport;

//import com.deusino.entity.TestReport;

import com.qadata.pojo.TestReport;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
public class TestReportAllInfo {

    private int id;

    private String reportNumber;

    private String testLab;

    private String testResult;

    private String testDate;

    private String testType;

    private String buyer;

    private String otherInfo;

    private List<ReportProductionInfoObject> reportProductionInfoObjects;

    private List<String> filesName;

    private String downloadURL;

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

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public List<ReportProductionInfoObject> getReportProductionInfoObjects() {
        return reportProductionInfoObjects;
    }

    public void setReportProductionInfoObjects(List<ReportProductionInfoObject> reportProductionInfoObjects) {
        this.reportProductionInfoObjects = reportProductionInfoObjects;
    }

    public List<String> getFilesName() {
        return filesName;
    }

    public void setFilesName(List<String> filesName) {
        this.filesName = filesName;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public void transFrom(TestReport testReport) {
        setId(testReport.getId());
        setTestDate(testReport.getTestDate());
        setOtherInfo(testReport.getOtherInfo());
        setReportNumber(testReport.getReportNumber());
        setTestLab(testReport.getTestLab());
        setBuyer(testReport.getBuyer());
        setTestResult(testReport.getTestResult());
        setTestType(testReport.getTestType());
    }
}
