package com.qadata.vo.InspectionReport;


import com.qadata.pojo.InspectionReport;
import com.qadata.vo.InspectionReport.sub.BasicInfoObject;
import com.qadata.vo.InspectionReport.sub.MeasurementAndWeightSummary;
import com.qadata.vo.InspectionReport.sub.ResultData;
import com.qadata.vo.InspectionReport.sub.WorkmanShipDetailsObject;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class InspectionReportObject {

    protected BasicInfoObject basicInfoObject;

    protected ResultData resultData;

    protected MeasurementAndWeightSummary measurementAndWeightSummary;

    protected WorkmanShipDetailsObject workmanShipDetailsObject;

    public BasicInfoObject getBasicInfoObject() {
        return basicInfoObject;
    }

    public void setBasicInfoObject(BasicInfoObject basicInfoObject) {
        this.basicInfoObject = basicInfoObject;
    }

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }

    public MeasurementAndWeightSummary getMeasurementAndWeightSummary() {
        return measurementAndWeightSummary;
    }

    public void setMeasurementAndWeightSummary(MeasurementAndWeightSummary measurementAndWeightSummary) {
        this.measurementAndWeightSummary = measurementAndWeightSummary;
    }

    public WorkmanShipDetailsObject getWorkmanShipDetailsObject() {
        return workmanShipDetailsObject;
    }

    public void setWorkmanShipDetailsObject(WorkmanShipDetailsObject workmanShipDetailsObject) {
        this.workmanShipDetailsObject = workmanShipDetailsObject;
    }

    public InspectionReport transToInspectionReport() {
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
        inspectionReport.setProductionInfoOnPo(getResultData().getProductionInfoOnPo());
        inspectionReport.setProductSpecifications(getResultData().getProductSpecifications());
        inspectionReport.setSubmittedSamples(getResultData().getSubmittedSamples());
        inspectionReport.setBarcodeVerification(getResultData().getBarcodeVerification());
        inspectionReport.setLabeling(getResultData().getLabeling());
        inspectionReport.setPacking(getResultData().getPacking());
        inspectionReport.setAssortment(getResultData().getAssortment());
        inspectionReport.setExportCartonPacking(getResultData().getExportCartonPacking());
        inspectionReport.setInnerCartonPacking(getResultData().getInnerCartonPacking());
        inspectionReport.setProductPacking(getResultData().getProductPacking());
        inspectionReport.setConditionOfContainers(getResultData().getConditionOfContainers());
        inspectionReport.setConditionOfExportCartons(getResultData().getConditionOfExportCartons());
        inspectionReport.setQuantityAndAssortment(getResultData().getQuantityAndAssortment());
        inspectionReport.setWeightResult(getMeasurementAndWeightSummary().getWeightResult());
        inspectionReport.setMeasurementResult(getMeasurementAndWeightSummary().getMeasurementResult());
        inspectionReport.setWorkmanshipDetails(getWorkmanShipDetailsObject().getWorkmanshipDetails());
        return inspectionReport;
    }
}
