package com.qadata.vo.InspectionReport.sub;

//import com.deusino.entity.Workmanship;

import com.qadata.pojo.Workmanship;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class WorkmanShipObject {

    private String po;

    private String item;

    private Integer sampleSizeOfWorkmanship;

    private String defectCodeAndDescription;

    private Integer critical;

    private Integer major;

    private Integer minor;

    private Integer function;

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
        this.defectCodeAndDescription = defectCodeAndDescription;
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

    public Workmanship getWorkmanship() {
        Workmanship workmanShip = new Workmanship();
        workmanShip.setItem(getItem());
        workmanShip.setPo(getPo());
        workmanShip.setCritical(getCritical());
        workmanShip.setDefectCodeAndDescription(getDefectCodeAndDescription());
        workmanShip.setFunction(getFunction());
        workmanShip.setMajor(getMajor());
        workmanShip.setSampleSizeOfWorkmanship(getSampleSizeOfWorkmanship());
        workmanShip.setMinor(getMinor());
        return workmanShip;
    }

    public void transFrom(Workmanship workmanShip) {
        setPo(workmanShip.getPo());
        setItem(workmanShip.getItem());
        setSampleSizeOfWorkmanship(workmanShip.getSampleSizeOfWorkmanship());
        setDefectCodeAndDescription(workmanShip.getDefectCodeAndDescription());
        setCritical(workmanShip.getCritical());
        setMajor(workmanShip.getMajor());
        setMinor(workmanShip.getMinor());
        setFunction(workmanShip.getFunction());
    }
}
