package com.qadata.vo.InspectionReport;


import com.qadata.pojo.InspectionReport;
import com.qadata.vo.InspectionReport.sub.BasicInfoObject;
import com.qadata.vo.InspectionReport.sub.MeasurementAndWeightObject;
import com.qadata.vo.InspectionReport.sub.OnSiteTestObject;
import com.qadata.vo.InspectionReport.sub.WorkmanShipObject;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class InspectionReportBasicInfoObj {

    private BasicInfoObject basicInfoObject;

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

    private OnSiteTestObject onSiteTestObject;

    private OnSiteTestObject onSiteTestObject1;

    private String weightResult;

    private String measurementResult;

    private MeasurementAndWeightObject measurementAndWeightObject;

    private MeasurementAndWeightObject measurementAndWeightObject1;

    private String workmanshipDetails;

    private WorkmanShipObject workmanShipObject;

    private WorkmanShipObject workmanShipObject1;

    public BasicInfoObject getBasicInfoObject() {
        return basicInfoObject;
    }

    public void setBasicInfoObject(BasicInfoObject basicInfoObject) {
        this.basicInfoObject = basicInfoObject;
    }

    public String getProductionInfoOnPo() {
        return productionInfoOnPo;
    }

    public void setProductionInfoOnPo(String productionInfoOnPo) {
        this.productionInfoOnPo = productionInfoOnPo;
    }

    public String getProductSpecifications() {
        return productSpecifications;
    }

    public void setProductSpecifications(String productSpecifications) {
        this.productSpecifications = productSpecifications;
    }

    public String getSubmittedSamples() {
        return submittedSamples;
    }

    public void setSubmittedSamples(String submittedSamples) {
        this.submittedSamples = submittedSamples;
    }

    public String getBarcodeVerification() {
        return barcodeVerification;
    }

    public void setBarcodeVerification(String barcodeVerification) {
        this.barcodeVerification = barcodeVerification;
    }

    public String getLabeling() {
        return labeling;
    }

    public void setLabeling(String labeling) {
        this.labeling = labeling;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getAssortment() {
        return assortment;
    }

    public void setAssortment(String assortment) {
        this.assortment = assortment;
    }

    public String getExportCartonPacking() {
        return exportCartonPacking;
    }

    public void setExportCartonPacking(String exportCartonPacking) {
        this.exportCartonPacking = exportCartonPacking;
    }

    public String getInnerCartonPacking() {
        return innerCartonPacking;
    }

    public void setInnerCartonPacking(String innerCartonPacking) {
        this.innerCartonPacking = innerCartonPacking;
    }

    public String getProductPacking() {
        return productPacking;
    }

    public void setProductPacking(String productPacking) {
        this.productPacking = productPacking;
    }

    public String getConditionOfContainers() {
        return conditionOfContainers;
    }

    public void setConditionOfContainers(String conditionOfContainers) {
        this.conditionOfContainers = conditionOfContainers;
    }

    public String getConditionOfExportCartons() {
        return conditionOfExportCartons;
    }

    public void setConditionOfExportCartons(String conditionOfExportCartons) {
        this.conditionOfExportCartons = conditionOfExportCartons;
    }

    public String getQuantityAndAssortment() {
        return quantityAndAssortment;
    }

    public void setQuantityAndAssortment(String quantityAndAssortment) {
        this.quantityAndAssortment = quantityAndAssortment;
    }

    public OnSiteTestObject getOnSiteTestObject() {
        return onSiteTestObject;
    }

    public void setOnSiteTestObject(OnSiteTestObject onSiteTestObject) {
        this.onSiteTestObject = onSiteTestObject;
    }

    public String getWeightResult() {
        return weightResult;
    }

    public void setWeightResult(String weightResult) {
        this.weightResult = weightResult;
    }

    public String getMeasurementResult() {
        return measurementResult;
    }

    public void setMeasurementResult(String measurementResult) {
        this.measurementResult = measurementResult;
    }

    public MeasurementAndWeightObject getMeasurementAndWeightObject() {
        return measurementAndWeightObject;
    }

    public void setMeasurementAndWeightObject(MeasurementAndWeightObject measurementAndWeightObject) {
        this.measurementAndWeightObject = measurementAndWeightObject;
    }

    public String getWorkmanshipDetails() {
        return workmanshipDetails;
    }

    public void setWorkmanshipDetails(String workmanshipDetails) {
        this.workmanshipDetails = workmanshipDetails;
    }

    public WorkmanShipObject getWorkmanShipObject() {
        return workmanShipObject;
    }

    public void setWorkmanShipObject(WorkmanShipObject workmanShipObject) {
        this.workmanShipObject = workmanShipObject;
    }

    public OnSiteTestObject getOnSiteTestObject1() {
        return onSiteTestObject1;
    }

    public void setOnSiteTestObject1(OnSiteTestObject onSiteTestObject1) {
        this.onSiteTestObject1 = onSiteTestObject1;
    }

    public MeasurementAndWeightObject getMeasurementAndWeightObject1() {
        return measurementAndWeightObject1;
    }

    public void setMeasurementAndWeightObject1(MeasurementAndWeightObject measurementAndWeightObject1) {
        this.measurementAndWeightObject1 = measurementAndWeightObject1;
    }

    public WorkmanShipObject getWorkmanShipObject1() {
        return workmanShipObject1;
    }

    public void setWorkmanShipObject1(WorkmanShipObject workmanShipObject1) {
        this.workmanShipObject1 = workmanShipObject1;
    }

    public InspectionReport getInspectionReport() {
        InspectionReport inspectionReport = new InspectionReport();
        inspectionReport.setReportNumber(getBasicInfoObject().getReportNumber());
        inspectionReport.setBuyer(getBasicInfoObject().getBuyer());
        inspectionReport.setServiceType(getBasicInfoObject().getServiceType());
        inspectionReport.setInspectionStandard(getBasicInfoObject().getInspectionStandard());
        inspectionReport.setInspectionLab(getBasicInfoObject().getInspectionLab());
        inspectionReport.setInspectionDate(getBasicInfoObject().getInspectionDate());
        inspectionReport.setFactoryNumber(getBasicInfoObject().getFactoryNumber());
        inspectionReport.setFactoryName(getBasicInfoObject().getFactoryName());
        inspectionReport.setReportResult(getBasicInfoObject().getReportResult());
        inspectionReport.setProductionInfoOnPo(getProductionInfoOnPo());
        inspectionReport.setProductSpecifications(getProductSpecifications());
        inspectionReport.setSubmittedSamples(getSubmittedSamples());
        inspectionReport.setBarcodeVerification(getBarcodeVerification());
        inspectionReport.setLabeling(getLabeling());
        inspectionReport.setPacking(getPacking());
        inspectionReport.setAssortment(getAssortment());
        inspectionReport.setExportCartonPacking(getExportCartonPacking());
        inspectionReport.setInnerCartonPacking(getInnerCartonPacking());
        inspectionReport.setProductPacking(getProductPacking());
        inspectionReport.setConditionOfContainers(getConditionOfContainers());
        inspectionReport.setConditionOfExportCartons(getConditionOfExportCartons());
        inspectionReport.setQuantityAndAssortment(getQuantityAndAssortment());
        inspectionReport.setWeightResult(getWeightResult());
        inspectionReport.setMeasurementResult(getMeasurementResult());
        inspectionReport.setWorkmanshipDetails(getWorkmanshipDetails());
        return inspectionReport;
    }
}
