package com.qadata.vo.InspectionOrder;


//import io.swagger.annotations.ApiModel;

import com.qadata.pojo.InspectionOrder;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
//@ApiModel(value = "InspectionOrderAllInfo",description="验货订单全部信息")
public class InspectionOrderAllInfo extends InspectionOrderObject{

    private int id;

    private List<String> filesName;

    private String downloadURL;

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

    public List<String> getFilesName() {
        return filesName;
    }

    public void setFilesName(List<String> filesName) {
        this.filesName = filesName;
    }

    public List<OrderProductionInfoObject> getOrderProductionInfoObjects() {
        return orderProductionInfoObjects;
    }

    public void setOrderProductionInfoObjects(List<OrderProductionInfoObject> orderProductionInfoObjects) {
        this.orderProductionInfoObjects = orderProductionInfoObjects;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public void transFrom(InspectionOrder inspectionOrder) {
        setId(inspectionOrder.getId());
        setBuyer(inspectionOrder.getBuyer());
        setServiceType(inspectionOrder.getServiceType());
        setBuyerEmail(inspectionOrder.getBuyerEmail());
        setBuyerTel(inspectionOrder.getBuyerTel());
        setContacts(inspectionOrder.getContacts());
        setEstimatedLoadingDate(inspectionOrder.getEstimatedLoadingDate());
        setFactoryContacts(inspectionOrder.getFactoryContacts());
        setFactoryEmail(inspectionOrder.getFactoryEmail());
        setFactoryName(inspectionOrder.getFactoryName());
        setFactoryTel(inspectionOrder.getFactoryTel());
        setInspectionAddress(inspectionOrder.getInspectionAddress());
        setInspectionDate(inspectionOrder.getInspectionDate());
        setInspectionLab(inspectionOrder.getInspectionLab());
        setInspectionStandard(inspectionOrder.getInspectionStandard());
    }
}
