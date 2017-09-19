package com.qadata.vo.InspectionReport;



import com.qadata.dao.MeasurementAndWeightMapper;
import com.qadata.dao.OnSiteTestMapper;
import com.qadata.dao.WorkmanshipMapper;
import com.qadata.pojo.InspectionReport;
import com.qadata.pojo.MeasurementAndWeight;
import com.qadata.pojo.OnSiteTest;
import com.qadata.pojo.Workmanship;
import com.qadata.vo.InspectionReport.sub.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class InspectionReportAllInfo extends InspectionReportObject{

    private int id;

    private List<String> filesName;

    private String downloadURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void transFrom(InspectionReport inspectionReport, WorkmanshipMapper workmanShipMapper, OnSiteTestMapper onSiteTestMapper, MeasurementAndWeightMapper measurementAndWeightMapper) {

        setId(inspectionReport.getId());

        setBasicInfoObject(inspectionReport);

        setResultData(inspectionReport,onSiteTestMapper);

        setMeasurementAndWeightSummary(inspectionReport,measurementAndWeightMapper);

        setWorkmanShipDetailsObject(inspectionReport,workmanShipMapper);
    }

    public void setBasicInfoObject(InspectionReport inspectionReport) {
        BasicInfoObject basicInfoObject = new BasicInfoObject();
        basicInfoObject.transfrom(inspectionReport);
        setBasicInfoObject(basicInfoObject);
    }

    public void setWorkmanShipDetailsObject(InspectionReport inspectionReport,WorkmanshipMapper workmanShipMapper) {
        WorkmanShipDetailsObject workmanShipDetailsObject = new WorkmanShipDetailsObject();
        workmanShipDetailsObject.setWorkmanshipDetails(inspectionReport.getWorkmanshipDetails());
        List<WorkmanShipObject> workmanShipObjects = new ArrayList<>();
        List<Workmanship> workmanShips = workmanShipMapper.selectByReportId(inspectionReport.getId());
        for (Workmanship workmanShip : workmanShips) {
            WorkmanShipObject workmanShipObject = new WorkmanShipObject();
            workmanShipObject.transFrom(workmanShip);
            workmanShipObjects.add(workmanShipObject);
        }
        workmanShipDetailsObject.setWorkmanShipObjects(workmanShipObjects);
        setWorkmanShipDetailsObject(workmanShipDetailsObject);
    }
    public void setResultData(InspectionReport inspectionReport,OnSiteTestMapper onSiteTestMapper) {
        ResultData resultData = new ResultData();
        resultData.transFrom(inspectionReport);
        List<OnSiteTestObject> onSiteTestObjects = new ArrayList<>();
        List<OnSiteTest> onSiteTests = onSiteTestMapper.selectByReportId(inspectionReport.getId());
        for (OnSiteTest onSiteTest : onSiteTests) {
            OnSiteTestObject onSiteTestObejct = new OnSiteTestObject();
            onSiteTestObejct.transFrom(onSiteTest);
            onSiteTestObjects.add(onSiteTestObejct);
        }
        resultData.setOnSiteTestObjects(onSiteTestObjects);
        setResultData(resultData);
    }

    public void setMeasurementAndWeightSummary( InspectionReport inspectionReport,MeasurementAndWeightMapper measurementAndWeightMapper) {
        MeasurementAndWeightSummary measurementAndWeightSummary = new MeasurementAndWeightSummary();
        measurementAndWeightSummary.setMeasurementResult(inspectionReport.getMeasurementResult());
        measurementAndWeightSummary.setWeightResult(inspectionReport.getWeightResult());
        List<MeasurementAndWeightObject> measurementAndWeightObjects = new ArrayList<>();
        List<MeasurementAndWeight> measurementAndWeights = measurementAndWeightMapper.selectByReportId(inspectionReport.getId());
        for (MeasurementAndWeight measurementAndWeight : measurementAndWeights) {
            MeasurementAndWeightObject measurementAndWeightObject = new MeasurementAndWeightObject();
            measurementAndWeightObject.transFrom(measurementAndWeight);
            measurementAndWeightObjects.add(measurementAndWeightObject);
        }
        measurementAndWeightSummary.setMeasurementAndWeightObjects(measurementAndWeightObjects);
        setMeasurementAndWeightSummary(measurementAndWeightSummary);
    }
}
