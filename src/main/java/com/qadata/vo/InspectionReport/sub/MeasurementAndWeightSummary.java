package com.qadata.vo.InspectionReport.sub;

import java.util.List;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class MeasurementAndWeightSummary {

    private String weightResult;

    private String measurementResult;

    private List<MeasurementAndWeightObject> measurementAndWeightObjects;

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

    public List<MeasurementAndWeightObject> getMeasurementAndWeightObjects() {
        return measurementAndWeightObjects;
    }

    public void setMeasurementAndWeightObjects(List<MeasurementAndWeightObject> measurementAndWeightObjects) {
        this.measurementAndWeightObjects = measurementAndWeightObjects;
    }
}
