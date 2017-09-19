package com.qadata.service;


import com.qadata.dao.InspectionOrderMapper;
import com.qadata.dao.OrderProductInfoMapper;
import com.qadata.pojo.InspectionOrder;
import com.qadata.pojo.OrderProductInfo;
import com.qadata.vo.InspectionOrder.*;
import com.qadata.vo.Range;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/8/17.
 */
@Service
public class InspectionOrderService {
    @Autowired
    InspectionOrderMapper inspectionOrderMapper;
    @Autowired
    OrderProductInfoMapper orderProductInfoMapper;

    public void addInspectionOrder(InspectionOrderObject inspectionOrderObject, String fileUrl, int userId){
        List<OrderProductionInfoObject> orderProductionInfoObjects=inspectionOrderObject.getOrderProductionInfoObjects();
        InspectionOrder inspectionOrder = inspectionOrderObject.transToInspectionOrder();
        inspectionOrder.setUserId(userId);
        inspectionOrder.setFileUrl(fileUrl);
        inspectionOrderMapper.insertSelective(inspectionOrder);
        for(OrderProductionInfoObject orderProductionInfoObject:orderProductionInfoObjects){
            OrderProductInfo orderProductInfo = orderProductionInfoObject.TransToOrderProductInfo();
            orderProductInfo.setInsOrderId(inspectionOrder.getId());
            orderProductInfo.setStyle(orderProductInfo.getStyle());
            orderProductInfoMapper.insertSelective(orderProductInfo);
        }
    }


    public void addInspectionOrder(InspectionOrderBasicInfoObj inspectionOrderBasicInfoObj, String fileUrl, int userId, OrderProductionInfoObject... orderProductionInfoObjects){
        InspectionOrder inspectionOrder = inspectionOrderBasicInfoObj.transToInspectionOrder();
        inspectionOrder.setUserId(userId);
        inspectionOrder.setFileUrl(fileUrl);
        inspectionOrderMapper.insertSelective(inspectionOrder);
        for(OrderProductionInfoObject orderProductionInfoObject:orderProductionInfoObjects){
            OrderProductInfo orderProductInfo = orderProductionInfoObject.TransToOrderProductInfo();
            orderProductInfo.setInsOrderId(inspectionOrder.getId());
            orderProductInfo.setStyle(orderProductionInfoObject.getStyle());
            orderProductInfoMapper.insertSelective(orderProductInfo);
        }
    }


    public int getTotalPage(int dataNumberPerPage,int userId){
        int totalPage=inspectionOrderMapper.getTotalNumber(userId)/dataNumberPerPage;
        if((inspectionOrderMapper.getTotalNumber(userId)%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }

    public int getTotalPageByAdmin(int dataNumberPerPage){
        int totalPage=inspectionOrderMapper.getTotalNumberByAdmin()/dataNumberPerPage;
        if((inspectionOrderMapper.getTotalNumberByAdmin()%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }

    public List<SimpleInspectionOrderObject> getAllTestOrder(Range2 range) {
        List<InspectionOrder> list = inspectionOrderMapper.selectInspectionOrderInRange(range);
        return dataTrans(list);
    }
    public List<SimpleInspectionOrderObject> getAllTestOrderByAdmin(Range range) {
        List<InspectionOrder> list = inspectionOrderMapper.selectAllInspectionOrderInRange(range);
        return dataTrans(list);
    }
    public List<SimpleInspectionOrderObject> dataTrans(List<InspectionOrder> list){
        List<SimpleInspectionOrderObject> list1 = new ArrayList<>();
        for (InspectionOrder inspectionOrder : list) {
            SimpleInspectionOrderObject simpleInspectionOrderObject = new SimpleInspectionOrderObject();
            simpleInspectionOrderObject.transFrom(inspectionOrder);
            list1.add(simpleInspectionOrderObject);
        }
        return list1;
    }

    public InspectionOrderAllInfo findById(int id, HttpServletRequest request){
        InspectionOrderAllInfo inspectionOrderAllInfo=new InspectionOrderAllInfo();
        InspectionOrder inspectionOrder=inspectionOrderMapper.selectByPrimaryKey(id);
        List<OrderProductInfo> orderProductInfos=orderProductInfoMapper.selectByOrderId(id);
        List<OrderProductionInfoObject> orderProductionInfoObjects=new ArrayList<>();
        inspectionOrderAllInfo.transFrom(inspectionOrder);
        for(OrderProductInfo orderProductInfo:orderProductInfos){
            OrderProductionInfoObject orderProductionInfoObject=new OrderProductionInfoObject();
            orderProductionInfoObject.transFrom(orderProductInfo);
            orderProductionInfoObjects.add(orderProductionInfoObject);
        }
        inspectionOrderAllInfo.setOrderProductionInfoObjects(orderProductionInfoObjects);
        inspectionOrderAllInfo.setFilesName(FileOperateService.getFileListInZip(inspectionOrder.getFileUrl()));
        inspectionOrderAllInfo.setDownloadURL(FileOperateService.getDownloadURL(request,inspectionOrder.getFileUrl()));
        return inspectionOrderAllInfo;
    }

    public int getFuzzySearchTotalPage(int userId,String content,int dataNumberPerPage){
        Range3 range3=new Range3();
        range3.setContent(content);
        range3.setUserId(userId);
        int totalPage=inspectionOrderMapper.getFuzzySearchTotalNumber(range3)/dataNumberPerPage;
        if((inspectionOrderMapper.getFuzzySearchTotalNumber(range3)%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }

    public List<SimpleInspectionOrderObject> fuzzySearch(Range3 range){
        List<InspectionOrder> list=inspectionOrderMapper.fuzzySearch(range);
        List<SimpleInspectionOrderObject> list1=new ArrayList<>();
        return dataTrans(list);
    }

}
