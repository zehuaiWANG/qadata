package com.qadata.service;


import com.qadata.dao.ReportProductInfoMapper;
import com.qadata.dao.TestReportMapper;
import com.qadata.pojo.ReportProductInfo;
import com.qadata.pojo.TestReport;
import com.qadata.vo.Range;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import com.qadata.vo.testReport.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
@Service
public class TestReportService {
    @Autowired
    TestReportMapper testReportMapper;
    @Autowired
    ReportProductInfoMapper reportProductInfoMapper;
    public void addTestReport(TestReportObject testReportObject, int userId, String fileUrl){
        TestReport testReport=new TestReport();
        testReport.setOtherInfo(testReportObject.getOtherInfo());
        testReport.setBuyer(testReportObject.getBuyer());
        testReport.setReportNumber(testReportObject.getReportNumber());
        testReport.setTestDate(testReportObject.getTestDate());
        testReport.setTestLab(testReportObject.getTestLab());
        testReport.setTestResult(testReportObject.getTestResult());
        testReport.setTestType(testReportObject.getTestType());
        testReport.setUserId(userId);
        testReport.setFileUrl(fileUrl);
        testReportMapper.insertSelective(testReport);
        System.out.println(testReport.getId());
        for(ReportProductionInfoObject reportProductionInfoObject:testReportObject.getReportProductionInfoObjects()){
            ReportProductInfo reportProductInfo=new ReportProductInfo();
            reportProductInfo.setClientPurchaseOrderNo(reportProductionInfoObject.getClientPurchaseOrderNo());
            reportProductInfo.setTestReportId(testReport.getId());
            reportProductInfo.setEndCustomerBrand(reportProductionInfoObject.getEndCustomerBrand());
            reportProductInfo.setStyle(reportProductionInfoObject.getStyle());
            reportProductInfo.setTestReportId(testReport.getId());
            reportProductInfoMapper.insertSelective(reportProductInfo);
        }
    }
    public void addTestReport2(TestReportBasicInfoObj testReportBasicInfoObj, int userId, String fileUrl, ReportProductionInfoObject... reportProductionInfoObjects){
        TestReport testReport=new TestReport();
        testReport.setOtherInfo(testReportBasicInfoObj.getOtherInfo());
        testReport.setBuyer(testReportBasicInfoObj.getBuyer());
        testReport.setReportNumber(testReportBasicInfoObj.getReportNumber());
        testReport.setTestDate(testReportBasicInfoObj.getTestDate());
        testReport.setTestLab(testReportBasicInfoObj.getTestLab());
        testReport.setTestResult(testReportBasicInfoObj.getTestResult());
        testReport.setTestType(testReportBasicInfoObj.getTestType());
        testReport.setUserId(userId);
        testReport.setFileUrl(fileUrl);
        testReportMapper.insertSelective(testReport);
        System.out.println(testReport.getId());
        for(ReportProductionInfoObject reportProductionInfoObject:reportProductionInfoObjects){
            ReportProductInfo reportProductInfo=new ReportProductInfo();
            reportProductInfo.setTestReportId(testReport.getId());
            reportProductInfo.setClientPurchaseOrderNo(reportProductionInfoObject.getClientPurchaseOrderNo());
            reportProductInfo.setEndCustomerBrand(reportProductionInfoObject.getEndCustomerBrand());
            reportProductInfo.setStyle(reportProductionInfoObject.getStyle());
            reportProductInfo.setTestReportId(testReport.getId());
            reportProductInfoMapper.insertSelective(reportProductInfo);
        }
    }


    public int getTotalPage(int dataNumberPerPage,int userId){
        int totalPage=testReportMapper.getTotalNumber(userId)/dataNumberPerPage;
        if((testReportMapper.getTotalNumber(userId)%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }

    public int getFuzzySearchTotalPage(int userId,String content,int dataNumberPerPage){
        Range3 range3=new Range3();
        range3.setContent(content);
        range3.setUserId(userId);
        int totalPage=testReportMapper.getFuzzySearchTotalNumber(range3)/dataNumberPerPage;
        if((testReportMapper.getFuzzySearchTotalNumber(range3)%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }

    public List<SimpleTestReportObject> fuzzySearch(Range3 range){
        List<TestReport> list=testReportMapper.fuzzySearch(range);
        List<SimpleTestReportObject> list1=new ArrayList<>();
        return getSimpleTestReportObjects(list,list1);
    }

    public int getTotalPageByAdmin(int dataNumberPerPage){
        int totalPage=testReportMapper.getTotalNumberByAdmin()/dataNumberPerPage;
        if((testReportMapper.getTotalNumberByAdmin()%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }

    public List<SimpleTestReportObject> getAllTestReport(Range2 range) {
        List<TestReport> list = testReportMapper.selectTestReportInRange(range);
        List<SimpleTestReportObject> list1 = new ArrayList<>();
        return getSimpleTestReportObjects(list, list1);
    }

    public List<SimpleTestReportObject> getAllTestReportByAdmin(Range range) {
        List<TestReport> list = testReportMapper.selectAllTestReportInRange(range);
        List<SimpleTestReportObject> list1 = new ArrayList<>();
        return getSimpleTestReportObjects(list, list1);
    }

    private List<SimpleTestReportObject> getSimpleTestReportObjects(List<TestReport> list, List<SimpleTestReportObject> list1) {
        for (TestReport t : list) {
            SimpleTestReportObject simpleTestReportObject = new SimpleTestReportObject();
            simpleTestReportObject.setId(t.getId());
            simpleTestReportObject.setBuyer(t.getBuyer());
            simpleTestReportObject.setTestType(t.getTestType());
            simpleTestReportObject.setTestResult(t.getTestResult());
            simpleTestReportObject.setTestLab(t.getTestLab());
            simpleTestReportObject.setReportNumber(t.getReportNumber());
            simpleTestReportObject.setTestDate(t.getTestDate());
            list1.add(simpleTestReportObject);
        }
        return list1;
    }

    public TestReportAllInfo findById(int id, HttpServletRequest request){
        TestReport testReport=testReportMapper.selectByPrimaryKey(id);
        if(testReport==null)
            return null;
        TestReportAllInfo testReportAllInfo=new TestReportAllInfo();
        testReportAllInfo.transFrom(testReport);
        List<ReportProductInfo> reportProductInfos=reportProductInfoMapper.selectByReportId(id);
        List<ReportProductionInfoObject> reportProductionInfoObjects=new ArrayList<>();
        for(ReportProductInfo reportProductInfo:reportProductInfos){
            ReportProductionInfoObject reportProductionInfoObject=new ReportProductionInfoObject();
            reportProductionInfoObject.transFrom(reportProductInfo);
            reportProductionInfoObjects.add(reportProductionInfoObject);
        }
        testReportAllInfo.setReportProductionInfoObjects(reportProductionInfoObjects);
        testReportAllInfo.setFilesName(FileOperateService.getFileListInZip(testReport.getFileUrl()));
        testReportAllInfo.setDownloadURL(FileOperateService.getDownloadURL(request,testReport.getFileUrl()));
        return testReportAllInfo;
    }

}
