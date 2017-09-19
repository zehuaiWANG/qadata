package com.qadata.pojo;

public class ReportProductInfo {
    private Integer id;

    private Integer testReportId;

    private String endCustomerBrand;

    private String clientPurchaseOrderNo;

    private String style;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTestReportId() {
        return testReportId;
    }

    public void setTestReportId(Integer testReportId) {
        this.testReportId = testReportId;
    }

    public String getEndCustomerBrand() {
        return endCustomerBrand;
    }

    public void setEndCustomerBrand(String endCustomerBrand) {
        this.endCustomerBrand = endCustomerBrand == null ? null : endCustomerBrand.trim();
    }

    public String getClientPurchaseOrderNo() {
        return clientPurchaseOrderNo;
    }

    public void setClientPurchaseOrderNo(String clientPurchaseOrderNo) {
        this.clientPurchaseOrderNo = clientPurchaseOrderNo == null ? null : clientPurchaseOrderNo.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }
}