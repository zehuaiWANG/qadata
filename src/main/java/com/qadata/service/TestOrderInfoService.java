package com.qadata.service;

import com.qadata.dao.TestOrderMapper;
import com.qadata.pojo.TestOrder;
import com.qadata.vo.Range;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import com.qadata.vo.testOrder.SimpleTestOrderObject;
import com.qadata.vo.testOrder.TestOrderAllInfo;
import com.qadata.vo.testOrder.TestOrderObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
@Service
public class TestOrderInfoService {
    @Autowired
    private TestOrderMapper testOrderMapper;

    public void addTestOrder(TestOrderObject testOrderObject, int userId, String fileUrl) {
        TestOrder testOrder = new TestOrder();
        testOrder.setExportMarket(testOrderObject.getExportMarket());
        testOrder.setOtherInfo(testOrderObject.getOtherInfo());
        testOrder.setProductsType(testOrderObject.getProductsType());
        testOrder.setServiceType(testOrderObject.getServiceType());
        testOrder.setTestStandard(testOrderObject.getTestStandard());
        testOrder.setBuyer(testOrderObject.getBuyer());
        testOrder.setUserId(userId);
        testOrder.setFileUrl(fileUrl);
        testOrderMapper.insertSelective(testOrder);
    }

    public List<SimpleTestOrderObject> getAllTestOrder(Range2 range) {
        List<TestOrder> list = testOrderMapper.selectTestOrderInRange(range);
        List<SimpleTestOrderObject> list1 = new ArrayList<>();
        return dataTrans(list, list1);
    }

    private List<SimpleTestOrderObject> dataTrans(List<TestOrder> list, List<SimpleTestOrderObject> list1) {
        for (TestOrder t : list) {
            SimpleTestOrderObject simpleTestOrderObject = new SimpleTestOrderObject();
            simpleTestOrderObject.setId(t.getId());
            simpleTestOrderObject.setBuyer(t.getBuyer());
            simpleTestOrderObject.setServiceType(t.getServiceType());
            simpleTestOrderObject.setExportMarket(t.getExportMarket());
            simpleTestOrderObject.setProductsType(t.getProductsType());
            list1.add(simpleTestOrderObject);
        }
        return list1;
    }

    public List<SimpleTestOrderObject> getAllTestOrderByAdmin(Range range) {
        List<TestOrder> list = testOrderMapper.selectAllTestOrderInRange(range);
        List<SimpleTestOrderObject> list1 = new ArrayList<>();
        return dataTrans(list, list1);
    }

    public int getTotalPageByAdmin(int dataNumberPerPage){
        int totalPage=testOrderMapper.getTotalNumberByAdmin()/dataNumberPerPage;
        if((testOrderMapper.getTotalNumberByAdmin()%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }
    public int getTotalPage(int dataNumberPerPage,int userId){
        int totalPage=testOrderMapper.getTotalNumber(userId)/dataNumberPerPage;
        if((testOrderMapper.getTotalNumber(userId)%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }

    public TestOrderAllInfo findById(int id, HttpServletRequest request) {
        TestOrder t = testOrderMapper.selectByPrimaryKey(id);
        TestOrderAllInfo testOrderAllInfo = new TestOrderAllInfo();
        if(t==null){
            return testOrderAllInfo;
        }
        testOrderAllInfo.setDownloadURL(FileOperateService.getDownloadURL(request, t.getFileUrl()));
        testOrderAllInfo.setFilesName(FileOperateService.getFileListInZip(t.getFileUrl()));
        testOrderAllInfo.tranFrom(t);
        return testOrderAllInfo;
    }

    public String getFileUrlById(int id){
        TestOrder testOrder=testOrderMapper.selectByPrimaryKey(id);
        return testOrder.getFileUrl();
    }

    public int getFuzzySearchTotalPage(int userId,String content,int dataNumberPerPage){
        Range3 range3=new Range3();
        range3.setContent(content);
        range3.setUserId(userId);
        int totalPage=testOrderMapper.getFuzzySearchTotalNumber(range3)/dataNumberPerPage;
        if((testOrderMapper.getFuzzySearchTotalNumber(range3)%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }

    public List<SimpleTestOrderObject> fuzzySearch(Range3 range){
        List<TestOrder> list=testOrderMapper.fuzzySearch(range);
        List<SimpleTestOrderObject> list1=new ArrayList<>();
        return dataTrans(list,list1);
    }
}
