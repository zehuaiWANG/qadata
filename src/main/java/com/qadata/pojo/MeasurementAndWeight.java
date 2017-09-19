package com.qadata.pojo;

public class MeasurementAndWeight {
    private Integer id;

    private Integer reportId;

    private String po;

    private String item;

    private Integer sampleSize;

    private Integer measurementDefect;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po == null ? null : po.trim();
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
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
}