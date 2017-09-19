package com.qadata.vo.InspectionOrder;


import com.qadata.pojo.InspectionOrder;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class SimpleInspectionOrderObject {
    private int id;

    private String serviceType;

    private String inspectionStandard;

    private String inspectionLab;

    private String inspectionDate;

    private String estimatedLoadingDate;

    private String buyer;

    private String inspectionAddress;

    private String factoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getInspectionStandard() {
        return inspectionStandard;
    }

    public void setInspectionStandard(String inspectionStandard) {
        this.inspectionStandard = inspectionStandard;
    }

    public String getInspectionLab() {
        return inspectionLab;
    }

    public void setInspectionLab(String inspectionLab) {
        this.inspectionLab = inspectionLab;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getEstimatedLoadingDate() {
        return estimatedLoadingDate;
    }

    public void setEstimatedLoadingDate(String estimatedLoadingDate) {
        this.estimatedLoadingDate = estimatedLoadingDate;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getInspectionAddress() {
        return inspectionAddress;
    }

    public void setInspectionAddress(String inspectionAddress) {
        this.inspectionAddress = inspectionAddress;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public void transFrom(InspectionOrder inspectionOrder) {
        setId(inspectionOrder.getId());
        setBuyer(inspectionOrder.getBuyer());
        setEstimatedLoadingDate(inspectionOrder.getEstimatedLoadingDate());
        setServiceType(inspectionOrder.getServiceType());
        setFactoryName(inspectionOrder.getFactoryName());
        setInspectionAddress(inspectionOrder.getInspectionAddress());
        setInspectionDate(inspectionOrder.getInspectionDate());
        setInspectionLab(inspectionOrder.getInspectionLab());
        setInspectionStandard(inspectionOrder.getInspectionStandard());
    }
}
