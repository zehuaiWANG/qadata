package com.qadata.service;


import com.qadata.dao.InspectionReportMapper;
import com.qadata.dao.MeasurementAndWeightMapper;
import com.qadata.dao.OnSiteTestMapper;
import com.qadata.dao.WorkmanshipMapper;
import com.qadata.pojo.InspectionReport;
import com.qadata.pojo.MeasurementAndWeight;
import com.qadata.pojo.OnSiteTest;
import com.qadata.pojo.Workmanship;
import com.qadata.vo.InspectionOrder.SimpleInspectionOrderObject;
import com.qadata.vo.InspectionReport.InspectionReportAllInfo;
import com.qadata.vo.InspectionReport.InspectionReportBasicInfoObj;
import com.qadata.vo.InspectionReport.InspectionReportObject;
import com.qadata.vo.InspectionReport.SimpleInspectionReportObject;
import com.qadata.vo.InspectionReport.sub.MeasurementAndWeightObject;
import com.qadata.vo.InspectionReport.sub.OnSiteTestObject;
import com.qadata.vo.InspectionReport.sub.WorkmanShipObject;
import com.qadata.vo.Range;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
@Service
public class InspectionReportService {
    @Autowired
    InspectionReportMapper inspectionReportMapper;
    @Autowired
    OnSiteTestMapper onSiteTestMapper;
    @Autowired
    MeasurementAndWeightMapper measurementAndWeightMapper;
    @Autowired
    WorkmanshipMapper workmanShipMapper;

    public void addInspectionReport(InspectionReportObject inspectionReportObject, Integer id, String fileUrl) {
        InspectionReport inspectionReport = inspectionReportObject.transToInspectionReport();
        inspectionReport.setUserId(id);
        inspectionReport.setFileUrl(fileUrl);
        inspectionReportMapper.insertSelective(inspectionReport);
        for (OnSiteTestObject onSiteTestObject : inspectionReportObject.getResultData().getOnSiteTestObjects()) {
            OnSiteTest onSiteTest = onSiteTestObject.getOnSiteTest();
            onSiteTest.setReportId(inspectionReport.getId());
            onSiteTestMapper.insertSelective(onSiteTest);
        }
        for (MeasurementAndWeightObject measurementAndWeightObject : inspectionReportObject.getMeasurementAndWeightSummary().getMeasurementAndWeightObjects()) {
            MeasurementAndWeight measurementAndWeight = measurementAndWeightObject.getMeasurementAndWeight();
            measurementAndWeight.setReportId(inspectionReport.getId());
            measurementAndWeightMapper.insertSelective(measurementAndWeight);
        }
        for (WorkmanShipObject workmanShipObject : inspectionReportObject.getWorkmanShipDetailsObject().getWorkmanShipObjects()) {
            Workmanship workmanShip = workmanShipObject.getWorkmanship();
            workmanShip.setReportId(inspectionReport.getId());
            workmanShipMapper.insertSelective(workmanShip);
        }
    }

    public void addInspectionReport1(InspectionReportBasicInfoObj inspectionReportBasicInfoObj, Integer id, String fileUrl) {
        InspectionReport inspectionReport = inspectionReportBasicInfoObj.getInspectionReport();
        inspectionReport.setUserId(id);
        inspectionReport.setFileUrl(fileUrl);
        inspectionReportMapper.insertSelective(inspectionReport);
        OnSiteTestObject onSiteTestObject = inspectionReportBasicInfoObj.getOnSiteTestObject();
        OnSiteTest onSiteTest = onSiteTestObject.getOnSiteTest();
        onSiteTest.setReportId(inspectionReport.getId());
        onSiteTestMapper.insertSelective(onSiteTest);
        OnSiteTestObject onSiteTestObject1 = inspectionReportBasicInfoObj.getOnSiteTestObject1();
        onSiteTest = onSiteTestObject1.getOnSiteTest();
        onSiteTest.setReportId(inspectionReport.getId());
        onSiteTestMapper.insertSelective(onSiteTest);

        MeasurementAndWeightObject measurementAndWeightObject = inspectionReportBasicInfoObj.getMeasurementAndWeightObject();
        MeasurementAndWeight measurementAndWeight = measurementAndWeightObject.getMeasurementAndWeight();
        measurementAndWeight.setReportId(inspectionReport.getId());
        measurementAndWeightMapper.insertSelective(measurementAndWeight);
        measurementAndWeight = measurementAndWeightObject.getMeasurementAndWeight();
        measurementAndWeight.setReportId(inspectionReport.getId());
        measurementAndWeightMapper.insertSelective(measurementAndWeight);

        WorkmanShipObject workmanShipObject = inspectionReportBasicInfoObj.getWorkmanShipObject();
        Workmanship workmanShip = workmanShipObject.getWorkmanship();
        workmanShip.setReportId(inspectionReport.getId());
        workmanShipMapper.insertSelective(workmanShip);
        WorkmanShipObject workmanShipObject1 = inspectionReportBasicInfoObj.getWorkmanShipObject1();
        workmanShip=workmanShipObject1.getWorkmanship();
        workmanShipMapper.insertSelective(workmanShip);
    }

    public int getTotalPage(int dataNumberPerPage,int userId) {
        int totalPage = inspectionReportMapper.getTotalNumber(userId) / dataNumberPerPage;
        if ((inspectionReportMapper.getTotalNumber(userId) % dataNumberPerPage) != 0) {
            totalPage++;
        }
        return totalPage;
    }

    public int getTotalPageByAdmin(int dataNumberPerPage) {
        int totalPage = inspectionReportMapper.getTotalNumberByAdmin() / dataNumberPerPage;
        if ((inspectionReportMapper.getTotalNumberByAdmin() % dataNumberPerPage) != 0) {
            totalPage++;
        }
        return totalPage;
    }

    public List<SimpleInspectionReportObject> findAllInspectionReport(Range2 range) {
        List<InspectionReport> inspectionReports = inspectionReportMapper.selectInspectionReportInRange(range);
        return dataTrans(inspectionReports);
    }

    public List<SimpleInspectionReportObject> findAllInspectionReportByAdmin(Range range) {
        List<InspectionReport> inspectionReports = inspectionReportMapper.selectAllInspectionReportInRange(range);
        return dataTrans(inspectionReports);
    }
    public List<SimpleInspectionReportObject> dataTrans(List<InspectionReport> inspectionReports){
        List<SimpleInspectionReportObject> simpleInspectionReportObjects = new ArrayList<>();
        for (InspectionReport inspectionReport : inspectionReports) {
            SimpleInspectionReportObject simpleInspectionReportObject = inspectionReport.getSimpleInspectionReportObject();
            simpleInspectionReportObjects.add(simpleInspectionReportObject);
        }
        return simpleInspectionReportObjects;
    }

    public InspectionReportAllInfo findById(int id, HttpServletRequest request) {
        InspectionReportAllInfo inspectionReportAllInfo = new InspectionReportAllInfo();

        InspectionReport inspectionReport = inspectionReportMapper.selectByPrimaryKey(id);

        if(inspectionReport==null){
            return null;
        }

        inspectionReportAllInfo.transFrom(inspectionReport,workmanShipMapper,onSiteTestMapper,measurementAndWeightMapper);

        inspectionReportAllInfo.setFilesName(FileOperateService.getFileListInZip(inspectionReport.getFileUrl()));

        inspectionReportAllInfo.setDownloadURL(FileOperateService.getDownloadURL(request,inspectionReport.getFileUrl()));

        return inspectionReportAllInfo;
    }


    public int getFuzzySearchTotalPage(int userId,String content,int dataNumberPerPage){
        Range3 range3=new Range3();
        range3.setContent(content);
        range3.setUserId(userId);
        int totalPage=inspectionReportMapper.getFuzzySearchTotalNumber(range3)/dataNumberPerPage;
        if((inspectionReportMapper.getFuzzySearchTotalNumber(range3)%dataNumberPerPage)!=0){
            totalPage++;
        }
        return totalPage;
    }

    public List<SimpleInspectionReportObject> fuzzySearch(Range3 range){
        List<InspectionReport> list=inspectionReportMapper.fuzzySearch(range);
        List<SimpleInspectionOrderObject> list1=new ArrayList<>();
        return dataTrans(list);
    }




}
