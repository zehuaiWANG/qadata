package com.qadata.vo.InspectionReport.sub;

//import com.deusino.entity.InspectionReport;

import com.qadata.pojo.InspectionReport;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class ResultData {

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

    private List<OnSiteTestObject> onSiteTestObjects;

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

    public List<OnSiteTestObject> getOnSiteTestObjects() {
        return onSiteTestObjects;
    }

    public void setOnSiteTestObjects(List<OnSiteTestObject> onSiteTestObjects) {
        this.onSiteTestObjects = onSiteTestObjects;
    }
    
    public void transFrom(InspectionReport inspectionReport) {
        setProductionInfoOnPo(inspectionReport.getProductionInfoOnPo());
        setProductSpecifications(inspectionReport.getProductSpecifications());
        setSubmittedSamples(inspectionReport.getSubmittedSamples());
        setBarcodeVerification(inspectionReport.getBarcodeVerification());
        setLabeling(inspectionReport.getLabeling());
        setPacking(inspectionReport.getPacking());
        setAssortment(inspectionReport.getAssortment());
        setExportCartonPacking(inspectionReport.getExportCartonPacking());
        setInnerCartonPacking(inspectionReport.getInnerCartonPacking());
        setProductPacking(inspectionReport.getProductPacking());
        setConditionOfContainers(inspectionReport.getConditionOfContainers());
        setConditionOfExportCartons(inspectionReport.getConditionOfExportCartons());
        setQuantityAndAssortment(inspectionReport.getQuantityAndAssortment());
    }
}
