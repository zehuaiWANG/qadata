package com.qadata.pojo;


import com.qadata.vo.InspectionReport.SimpleInspectionReportObject;

public class InspectionReport {
    private Integer id;

    private Integer userId;

    private String reportNumber;

    private String serviceType;

    private String inspectionStandard;

    private String inspectionLab;

    private String inspectionDate;

    private String factoryNumber;

    private String factoryName;

    private String reportResult;

    private String buyer;

    private String productionInfoOnPo;

    private String productSpecifications;

    private String submittedSamples;

    private String barcodeVerification;

    private String labeling;

    private String packing;

    private String assortment;

    private String exportCartonPacking;

    private String innerCartonPacking;

    private String productPacking;

    private String conditionOfContainers;

    private String conditionOfExportCartons;

    private String quantityAndAssortment;

    private String weightResult;

    private String measurementResult;

    private String workmanshipDetails;

    private String fileUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber == null ? null : reportNumber.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getInspectionStandard() {
        return inspectionStandard;
    }

    public void setInspectionStandard(String inspectionStandard) {
        this.inspectionStandard = inspectionStandard == null ? null : inspectionStandard.trim();
    }

    public String getInspectionLab() {
        return inspectionLab;
    }

    public void setInspectionLab(String inspectionLab) {
        this.inspectionLab = inspectionLab == null ? null : inspectionLab.trim();
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate == null ? null : inspectionDate.trim();
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }

    public void setFactoryNumber(String factoryNumber) {
        this.factoryNumber = factoryNumber == null ? null : factoryNumber.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getReportResult() {
        return reportResult;
    }

    public void setReportResult(String reportResult) {
        this.reportResult = reportResult == null ? null : reportResult.trim();
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
    }

    public String getProductionInfoOnPo() {
        return productionInfoOnPo;
    }

    public void setProductionInfoOnPo(String productionInfoOnPo) {
        this.productionInfoOnPo = productionInfoOnPo == null ? null : productionInfoOnPo.trim();
    }

    public String getProductSpecifications() {
        return productSpecifications;
    }

    public void setProductSpecifications(String productSpecifications) {
        this.productSpecifications = productSpecifications == null ? null : productSpecifications.trim();
    }

    public String getSubmittedSamples() {
        return submittedSamples;
    }

    public void setSubmittedSamples(String submittedSamples) {
        this.submittedSamples = submittedSamples == null ? null : submittedSamples.trim();
    }

    public String getBarcodeVerification() {
        return barcodeVerification;
    }

    public void setBarcodeVerification(String barcodeVerification) {
        this.barcodeVerification = barcodeVerification == null ? null : barcodeVerification.trim();
    }

    public String getLabeling() {
        return labeling;
    }

    public void setLabeling(String labeling) {
        this.labeling = labeling == null ? null : labeling.trim();
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing == null ? null : packing.trim();
    }

    public String getAssortment() {
        return assortment;
    }

    public void setAssortment(String assortment) {
        this.assortment = assortment == null ? null : assortment.trim();
    }

    public String getExportCartonPacking() {
        return exportCartonPacking;
    }

    public void setExportCartonPacking(String exportCartonPacking) {
        this.exportCartonPacking = exportCartonPacking == null ? null : exportCartonPacking.trim();
    }

    public String getInnerCartonPacking() {
        return innerCartonPacking;
    }

    public void setInnerCartonPacking(String innerCartonPacking) {
        this.innerCartonPacking = innerCartonPacking == null ? null : innerCartonPacking.trim();
    }

    public String getProductPacking() {
        return productPacking;
    }

    public void setProductPacking(String productPacking) {
        this.productPacking = productPacking == null ? null : productPacking.trim();
    }

    public String getConditionOfContainers() {
        return conditionOfContainers;
    }

    public void setConditionOfContainers(String conditionOfContainers) {
        this.conditionOfContainers = conditionOfContainers == null ? null : conditionOfContainers.trim();
    }

    public String getConditionOfExportCartons() {
        return conditionOfExportCartons;
    }

    public void setConditionOfExportCartons(String conditionOfExportCartons) {
        this.conditionOfExportCartons = conditionOfExportCartons == null ? null : conditionOfExportCartons.trim();
    }

    public String getQuantityAndAssortment() {
        return quantityAndAssortment;
    }

    public void setQuantityAndAssortment(String quantityAndAssortment) {
        this.quantityAndAssortment = quantityAndAssortment == null ? null : quantityAndAssortment.trim();
    }

    public String getWeightResult() {
        return weightResult;
    }

    public void setWeightResult(String weightResult) {
        this.weightResult = weightResult == null ? null : weightResult.trim();
    }

    public String getMeasurementResult() {
        return measurementResult;
    }

    public void setMeasurementResult(String measurementResult) {
        this.measurementResult = measurementResult == null ? null : measurementResult.trim();
    }

    public String getWorkmanshipDetails() {
        return workmanshipDetails;
    }

    public void setWorkmanshipDetails(String workmanshipDetails) {
        this.workmanshipDetails = workmanshipDetails == null ? null : workmanshipDetails.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public SimpleInspectionReportObject getSimpleInspectionReportObject() {
        SimpleInspectionReportObject simpleInspectionReportObject = new SimpleInspectionReportObject();
        simpleInspectionReportObject.setInspectionLab(getInspectionLab());
        simpleInspectionReportObject.setServiceType(getServiceType());
        simpleInspectionReportObject.setBuyer(getBuyer());
        simpleInspectionReportObject.setFactoryName(getFactoryName());
        simpleInspectionReportObject.setFactoryNumber(getFactoryNumber());
        simpleInspectionReportObject.setId(getId());
        simpleInspectionReportObject.setInspectionDate(getInspectionDate());
        simpleInspectionReportObject.setInspectionStandard(getInspectionStandard());
        simpleInspectionReportObject.setReportNumber(getReportNumber());
        simpleInspectionReportObject.setReportResult(getReportResult());
        return simpleInspectionReportObject;
    }

}