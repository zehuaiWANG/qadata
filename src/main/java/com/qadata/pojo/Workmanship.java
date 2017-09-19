package com.qadata.pojo;

public class Workmanship {
    private Integer id;

    private Integer reportId;

    private String po;

    private String item;

    private Integer sampleSizeOfWorkmanship;

    private String defectCodeAndDescription;

    private Integer critical;

    private Integer major;

    private Integer minor;

    private Integer function;

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

    public Integer getSampleSizeOfWorkmanship() {
        return sampleSizeOfWorkmanship;
    }

    public void setSampleSizeOfWorkmanship(Integer sampleSizeOfWorkmanship) {
        this.sampleSizeOfWorkmanship = sampleSizeOfWorkmanship;
    }

    public String getDefectCodeAndDescription() {
        return defectCodeAndDescription;
    }

    public void setDefectCodeAndDescription(String defectCodeAndDescription) {
        this.defectCodeAndDescription = defectCodeAndDescription == null ? null : defectCodeAndDescription.trim();
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }

    public Integer getMinor() {
        return minor;
    }

    public void setMinor(Integer minor) {
        this.minor = minor;
    }

    public Integer getFunction() {
        return function;
    }

    public void setFunction(Integer function) {
        this.function = function;
    }
}