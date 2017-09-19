package com.qadata.vo.testReport;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
/**
 * Created by Administrator on 2017/8/29 0029.
 */
//@ApiModel(value = "TestReportObject",description="测试报告")
public class TestReportBasicInfoObj {

    //@ApiModelProperty(value = "报告号码")
    private String reportNumber;

    //@ApiModelProperty(value = "测试实验室")
    private String testLab;

    //@ApiModelProperty(value = "测试结果")
    private String testResult;

    //@ApiModelProperty(value = "测试时间")
    private String testDate;

    //@ApiModelProperty(value = "测试类型")
    private String testType;

    //@ApiModelProperty(value = "买家")
    private String buyer;

    //@ApiModelProperty(value = "其他信息")
    private String otherInfo;

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
}
