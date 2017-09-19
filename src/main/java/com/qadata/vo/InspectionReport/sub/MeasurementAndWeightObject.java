package com.qadata.vo.InspectionReport.sub;

//import com.deusino.entity.MeasurementAndWeight;

import com.qadata.pojo.MeasurementAndWeight;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class MeasurementAndWeightObject {

    private String po;

    private String item;

    private Integer sampleSize;

    private Integer measurementDefect;

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(Integer sampleSize) {
        this.sampleSize = sampleSize;
    }

    public Integer getMeasurementDefect() {
        return measurementDefect;
    }

    public void setMeasurementDefect(Integer measurementDefect) {
        this.measurementDefect = measurementDefect;
    }

    public MeasurementAndWeight getMeasurementAndWeight() {
        MeasurementAndWeight measurementAndWeight = new MeasurementAndWeight();
        measurementAndWeight.setItem(getItem());
        measurementAndWeight.setPo(getPo());
        measurementAndWeight.setSampleSize(getSampleSize());
        measurementAndWeight.setMeasurementDefect(measurementAndWeight.getMeasurementDefect());
        return measurementAndWeight;
    }

    public void transFrom(MeasurementAndWeight measurementAndWeight) {
        setItem(measurementAndWeight.getItem());
        setMeasurementDefect(measurementAndWeight.getMeasurementDefect());
        setPo(measurementAndWeight.getPo());
        setSampleSize(measurementAndWeight.getSampleSize());
    }
}
