package com.qadata.vo.testReport;

//import com.deusino.entity.ReportProductInfo;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import com.qadata.pojo.ReportProductInfo;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
//@ApiModel(value = "ReportProductionInfoObject",description="测试报告产品信息")
public class ReportProductionInfoObject {

    //@ApiModelProperty(value = "终端客户的品牌名称")
    private String endCustomerBrand;

    //@ApiModelProperty(value = "客户订单号PO#")
    private String clientPurchaseOrderNo;

    //@ApiModelProperty(value = "客户的产品型号/款型/货号")
    private String style;

    public String getEndCustomerBrand() {
        return endCustomerBrand;
    }

    public void setEndCustomerBrand(String endCustomerBrand) {
        this.endCustomerBrand = endCustomerBrand;
    }

    public String getClientPurchaseOrderNo() {
        return clientPurchaseOrderNo;
    }

    public void setClientPurchaseOrderNo(String clientPurchaseOrderNo) {
        this.clientPurchaseOrderNo = clientPurchaseOrderNo;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void transFrom(ReportProductInfo reportProductInfo) {
        setEndCustomerBrand(reportProductInfo.getEndCustomerBrand());
        setStyle(reportProductInfo.getStyle());
        setClientPurchaseOrderNo(reportProductInfo.getClientPurchaseOrderNo());
    }
}
