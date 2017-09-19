package com.qadata.vo.testOrder;

//import io.swagger.annotations.ApiModelProperty;
/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class TestOrderObject {

    //@ApiModelProperty(value = "服务类型",required = true)
    private String serviceType;

    //@ApiModelProperty(value = "产品类型",required = true)
    private String productsType;

   // @ApiModelProperty(value = "出口市场",required = true)
    private String exportMarket;

   // @ApiModelProperty(value = "买家")
    private String buyer;

    //@ApiModelProperty(value = "测试标准")
    private String testStandard;

    //@ApiModelProperty(value = "其他信息")
    private String otherInfo;

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

    public boolean notNullCheck(){
        if(serviceType==null||"".equals(serviceType)){
            return false;
        }
        if(productsType==null||"".equals(productsType)){
            return false;
        }
        if(exportMarket==null||"".equals(exportMarket)){
            return false;
        }
        return true;
    }

    public String getErrorMsg(){
        if(serviceType==null||"".equals(serviceType)){
            return "未填写服务类型";
        }
        if(productsType==null||"".equals(productsType)){
            return "未填写产品类型";
        }
        if(exportMarket==null||"".equals(exportMarket)){
            return "未填写出口市场";
        }
        return null;
    }
}
