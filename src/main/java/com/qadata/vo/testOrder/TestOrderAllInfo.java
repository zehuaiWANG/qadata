package com.qadata.vo.testOrder;

//import com.deusino.entity.TestOrder;

import com.qadata.pojo.TestOrder;

import java.util.List;

/**
 * Created by Administrator on 2017/8/14 0014.
 */
public class TestOrderAllInfo {

    private int id;

    private String serviceType;

    private String productsType;

    private String exportMarket;

    private String buyer;

    private String testStandard;

    private String otherInfo;

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

    public List<String> getFilesName() {
        return filesName;
    }

    public void setFilesName(List<String> filesName) {
        this.filesName = filesName;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public void tranFrom(TestOrder t) {
        setId(t.getId());
        setBuyer(t.getBuyer());
        setServiceType(t.getServiceType());
        setExportMarket(t.getExportMarket());
        setProductsType(t.getProductsType());
        setOtherInfo(t.getOtherInfo());
        setTestStandard(t.getTestStandard());
    }
}
