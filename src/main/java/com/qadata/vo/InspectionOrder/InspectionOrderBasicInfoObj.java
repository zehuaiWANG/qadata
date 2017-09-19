package com.qadata.vo.InspectionOrder;


//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import com.qadata.pojo.InspectionOrder;

/**
 * Created by Admin on 2017/8/20.
 */
//@ApiModel(value = "InspectionOrderBasicInfoObj",description="验货订单基础信息")
public class InspectionOrderBasicInfoObj {

    //@ApiModelProperty(value = "服务类型")
    protected String serviceType;

    //@ApiModelProperty(value = "检验标准")
    protected String inspectionStandard;

    //@ApiModelProperty(value = "验货实验室")
    protected String inspectionLab;

    //@ApiModelProperty(value = "验货日期")
    protected String inspectionDate;

    //@ApiModelProperty(value = "预计装船日期")
    protected String estimatedLoadingDate;

    //@ApiModelProperty(value = "买家")
    protected String buyer;

    //@ApiModelProperty(value = "联系人")
    protected String contacts;

    //@ApiModelProperty(value = "联系人邮箱")
    protected String buyerEmail;

    //@ApiModelProperty(value = "联系人电话")
    protected String buyerTel;

    //@ApiModelProperty(value = "验货地点")
    protected String inspectionAddress;

    //@ApiModelProperty(value = "工厂名称")
    protected String factoryName;

    //@ApiModelProperty(value = "工厂联系人")
    protected String factoryContacts;

    //@ApiModelProperty(value = "电子邮箱")
    protected String factoryEmail;

    //@ApiModelProperty(value = "电话")
    protected String factoryTel;

    //@ApiModelProperty(value = "其他信息")
    protected String otherInfo;

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

    public InspectionOrder transToInspectionOrder() {
        InspectionOrder inspectionOrder=new InspectionOrder();
        inspectionOrder.setServiceType(getServiceType());
        inspectionOrder.setInspectionStandard(getInspectionStandard());
        inspectionOrder.setInspectionLab(getInspectionLab());
        inspectionOrder.setInspectionDate(getInspectionDate());
        inspectionOrder.setEstimatedLoadingDate(getEstimatedLoadingDate());
        inspectionOrder.setBuyer(getBuyer());
        inspectionOrder.setContacts(getContacts());
        inspectionOrder.setBuyerEmail(getBuyerEmail());
        inspectionOrder.setBuyerTel(getBuyerTel());
        inspectionOrder.setInspectionAddress(getInspectionAddress());
        inspectionOrder.setFactoryName(getFactoryName());
        inspectionOrder.setFactoryContacts(getFactoryContacts());
        inspectionOrder.setFactoryEmail(getFactoryEmail());
        inspectionOrder.setFactoryTel(getFactoryTel());
        inspectionOrder.setOtherInfo(getOtherInfo());
        return inspectionOrder;
    }
}
