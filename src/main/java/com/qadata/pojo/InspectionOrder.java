package com.qadata.pojo;

public class InspectionOrder {
    private Integer id;

    private Integer userId;

    private String serviceType;

    private String inspectionStandard;

    private String inspectionLab;

    private String inspectionDate;

    private String estimatedLoadingDate;

    private String buyer;

    private String contacts;

    private String buyerEmail;

    private String buyerTel;

    private String inspectionAddress;

    private String factoryName;

    private String factoryContacts;

    private String factoryEmail;

    private String factoryTel;

    private String otherInfo;

    private String fileUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getInspectionStandard() {
        return inspectionStandard;
    }

    public void setInspectionStandard(String inspectionStandard) {
        this.inspectionStandard = inspectionStandard == null ? null : inspectionStandard.trim();
    }

    public String getInspectionLab() {
        return inspectionLab;
    }

    public void setInspectionLab(String inspectionLab) {
        this.inspectionLab = inspectionLab == null ? null : inspectionLab.trim();
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate == null ? null : inspectionDate.trim();
    }

    public String getEstimatedLoadingDate() {
        return estimatedLoadingDate;
    }

    public void setEstimatedLoadingDate(String estimatedLoadingDate) {
        this.estimatedLoadingDate = estimatedLoadingDate == null ? null : estimatedLoadingDate.trim();
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail == null ? null : buyerEmail.trim();
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel == null ? null : buyerTel.trim();
    }

    public String getInspectionAddress() {
        return inspectionAddress;
    }

    public void setInspectionAddress(String inspectionAddress) {
        this.inspectionAddress = inspectionAddress == null ? null : inspectionAddress.trim();
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName == null ? null : factoryName.trim();
    }

    public String getFactoryContacts() {
        return factoryContacts;
    }

    public void setFactoryContacts(String factoryContacts) {
        this.factoryContacts = factoryContacts == null ? null : factoryContacts.trim();
    }

    public String getFactoryEmail() {
        return factoryEmail;
    }

    public void setFactoryEmail(String factoryEmail) {
        this.factoryEmail = factoryEmail == null ? null : factoryEmail.trim();
    }

    public String getFactoryTel() {
        return factoryTel;
    }

    public void setFactoryTel(String factoryTel) {
        this.factoryTel = factoryTel == null ? null : factoryTel.trim();
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo == null ? null : otherInfo.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }
}