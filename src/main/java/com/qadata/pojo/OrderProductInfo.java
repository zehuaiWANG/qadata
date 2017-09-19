package com.qadata.pojo;

public class OrderProductInfo {
    private Integer id;

    private Integer insOrderId;

    private String endCustomerBrand;

    private String clientPurchaseOrderNo;

    private String style;

    private String clientProductName;

    private Integer totalColorQuantity;

    private Integer purchasedOrderQuantity;

    private Integer quantityAvailableForIns;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInsOrderId() {
        return insOrderId;
    }

    public void setInsOrderId(Integer insOrderId) {
        this.insOrderId = insOrderId;
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

    public String getClientProductName() {
        return clientProductName;
    }

    public void setClientProductName(String clientProductName) {
        this.clientProductName = clientProductName == null ? null : clientProductName.trim();
    }

    public Integer getTotalColorQuantity() {
        return totalColorQuantity;
    }

    public void setTotalColorQuantity(Integer totalColorQuantity) {
        this.totalColorQuantity = totalColorQuantity;
    }

    public Integer getPurchasedOrderQuantity() {
        return purchasedOrderQuantity;
    }

    public void setPurchasedOrderQuantity(Integer purchasedOrderQuantity) {
        this.purchasedOrderQuantity = purchasedOrderQuantity;
    }

    public Integer getQuantityAvailableForIns() {
        return quantityAvailableForIns;
    }

    public void setQuantityAvailableForIns(Integer quantityAvailableForIns) {
        this.quantityAvailableForIns = quantityAvailableForIns;
    }

}