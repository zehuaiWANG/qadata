package com.qadata.vo.InspectionReport.sub;


import com.qadata.pojo.InspectionReport;
//import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class BasicInfoObject {

    //@ApiModelProperty(value = "报告号码")
    private String reportNumber;

   // @ApiModelProperty(value = "服务类型")
    private String serviceType;

   // @ApiModelProperty(value = "检验标准")
    private String inspectionStandard;

   // @ApiModelProperty(value = "验货实验室")
    private String inspectionLab;

   // @ApiModelProperty(value = "验货日期")
    private String inspectionDate;

  //  @ApiModelProperty(value = "工厂编号")
    private String factoryNumber;

  //  @ApiModelProperty(value = "工厂名称")
    private String factoryName;

  //  @ApiModelProperty(value = "报告结果")
    private String reportResult;

  //  @ApiModelProperty(value = "买家")
    private String buyer;

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getInspectionStandard() {
        return inspectionStandard;
    }

    public void setInspectionStandard(String inspectionStandard) {
        this.inspectionStandard = inspectionStandard;
    }

    public String getInspectionLab() {
        return inspectionLab;
    }

    public void setInspectionLab(String inspectionLab) {
        this.inspectionLab = inspectionLab;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getReportResult() {
        return reportResult;
    }

    public void setReportResult(String reportResult) {
        this.reportResult = reportResult;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public void transfrom(InspectionReport inspectionReport) {
        setReportNumber(inspectionReport.getReportNumber());
        setBuyer(inspectionReport.getBuyer());
        setServiceType(inspectionReport.getServiceType());
        setInspectionStandard(inspectionReport.getInspectionStandard());
        setInspectionLab(inspectionReport.getInspectionLab());
        setInspectionDate(inspectionReport.getInspectionDate());
        setFactoryNumber(inspectionReport.getFactoryNumber());
        setFactoryName(inspectionReport.getFactoryName());
        setReportResult(inspectionReport.getReportResult());
    }
}
