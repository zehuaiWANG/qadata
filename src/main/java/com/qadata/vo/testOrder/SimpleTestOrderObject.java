package com.qadata.vo.testOrder;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class SimpleTestOrderObject {
    private Integer id;

    private String serviceType;

    private String productsType;

    private String exportMarket;

    private String buyer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getProductsType() {
        return productsType;
    }

    public void setProductsType(String productsType) {
        this.productsType = productsType;
    }

    public String getExportMarket() {
        return exportMarket;
    }

    public void setExportMarket(String exportMarket) {
        this.exportMarket = exportMarket;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
