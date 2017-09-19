package com.qadata.vo.InspectionOrder;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by Admin on 2017/8/16.
 */
//@ApiModel(value = "InspectionOrderObject",description="验货订单")
public class InspectionOrderObject extends InspectionOrderBasicInfoObj{

    //@ApiModelProperty(value = "产品信息")
    protected List<OrderProductionInfoObject> orderProductionInfoObjects;

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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
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

    public String getFactoryContacts() {
        return factoryContacts;
    }

    public void setFactoryContacts(String factoryContacts) {
        this.factoryContacts = factoryContacts;
    }

    public String getFactoryEmail() {
        return factoryEmail;
    }

    public void setFactoryEmail(String factoryEmail) {
        this.factoryEmail = factoryEmail;
    }

    public String getFactoryTel() {
        return factoryTel;
    }

    public void setFactoryTel(String factoryTel) {
        this.factoryTel = factoryTel;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public List<OrderProductionInfoObject> getOrderProductionInfoObjects() {
        return orderProductionInfoObjects;
    }

    public void setOrderProductionInfoObjects(List<OrderProductionInfoObject> orderProductionInfoObjects) {
        this.orderProductionInfoObjects = orderProductionInfoObjects;
    }


}
