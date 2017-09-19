package com.qadata.pojo;

public class TestOrder {
    private Integer id;

    private Integer userId;

    private String serviceType;

    private String productsType;

    private String exportMarket;

    private String buyer;

    private String testStandard;

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

    public String getProductsType() {
        return productsType;
    }

    public void setProductsType(String productsType) {
        this.productsType = productsType == null ? null : productsType.trim();
    }

    public String getExportMarket() {
        return exportMarket;
    }

    public void setExportMarket(String exportMarket) {
        this.exportMarket = exportMarket == null ? null : exportMarket.trim();
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
    }

    public String getTestStandard() {
        return testStandard;
    }

    public void setTestStandard(String testStandard) {
        this.testStandard = testStandard == null ? null : testStandard.trim();
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