package com.qadata.vo.InspectionOrder;


//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

import com.qadata.pojo.OrderProductInfo;

/**
 * Created by Admin on 2017/8/16.
 */
//@ApiModel(value = "OrderProductionInfoObject",description="验货订单产品信息")
public class OrderProductionInfoObject {

    //@ApiModelProperty(value = "终端客户的品牌名称")
    private String endCustomerBrand;

    //@ApiModelProperty(value = "客户订单号PO#")
    private String clientPurchaseOrderNo;

    //@ApiModelProperty(value = "客户的产品型号/款号/货号")
    private String style;

    //@ApiModelProperty(value = "客户的产品名称")
    private String clientProductName;

    //@ApiModelProperty(value = "每款所含颜色或尺码的数目")
    private Integer totalColorQuantity;

    //@ApiModelProperty(value = "产品订单数量")
    private Integer purchasedOrderQuantity;

    //@ApiModelProperty(value = "产品可供检验数量")
    private Integer quantityAvailableForIns;

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

    public String getClientProductName() {
        return clientProductName;
    }

    public void setClientProductName(String clientProductName) {
        this.clientProductName = clientProductName;
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


    public OrderProductInfo TransToOrderProductInfo() {
        OrderProductInfo orderProductInfo=new OrderProductInfo();
        orderProductInfo.setClientProductName(getClientProductName());
        orderProductInfo.setClientPurchaseOrderNo(getClientPurchaseOrderNo());
        orderProductInfo.setEndCustomerBrand(getEndCustomerBrand());
        orderProductInfo.setTotalColorQuantity(getTotalColorQuantity());
        orderProductInfo.setPurchasedOrderQuantity(getPurchasedOrderQuantity());
        orderProductInfo.setQuantityAvailableForIns(getQuantityAvailableForIns());
        return orderProductInfo;
    }

    public void transFrom(OrderProductInfo orderProductInfo) {
        setClientProductName(orderProductInfo.getClientProductName());
        setClientPurchaseOrderNo(orderProductInfo.getClientPurchaseOrderNo());
        setEndCustomerBrand(orderProductInfo.getEndCustomerBrand());
        setPurchasedOrderQuantity(orderProductInfo.getPurchasedOrderQuantity());
        setQuantityAvailableForIns(orderProductInfo.getQuantityAvailableForIns());
        setStyle(orderProductInfo.getStyle());
        setTotalColorQuantity(orderProductInfo.getTotalColorQuantity());
    }
}
