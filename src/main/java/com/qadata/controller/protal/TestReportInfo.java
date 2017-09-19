package com.qadata.controller.protal;

import com.qadata.pojo.User;
import com.qadata.service.FileOperateService;
import com.qadata.service.FileService;
import com.qadata.service.TestReportService;
import com.qadata.vo.CheckResult;
import com.qadata.vo.PageModel;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import com.qadata.vo.testReport.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/8/29 0029.
 */
@Controller
@RequestMapping(value = "/testReport")
@Api(tags = "testReportInfo",description="测试报告上传与查看")
public class TestReportInfo {
    @Autowired
    TestReportService testReportService;

    @ApiOperation(value = "添加测试报告", httpMethod = "POST", response = CheckResult.class, notes = "添加测试报告")
    @RequestMapping(value = "/addTestReport")
    @ResponseBody
    public CheckResult addTestOrder(@ModelAttribute("TestReportObject")TestReportObject testReportObject, @RequestParam("file")MultipartFile[] file, HttpServletRequest request){
        CheckResult checkResult=new CheckResult();
        String fileUrl=null;
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("请先登录");
            return checkResult;
        }
        try {
            String uploadDir = FileOperateService.getUploadDir(request) +user.getId()+ "\\";
            fileUrl= FileService.uploadMultiFile(uploadDir, file);
        }catch (Exception e){
            checkResult.setSuccess(false);
            checkResult.setErrMsg(e.getMessage());
            return checkResult;
        }
        testReportService.addTestReport(testReportObject,user.getId(),fileUrl);
        checkResult.setSuccess(true);
        return checkResult;
    }
    @ApiOperation(value = "添加测试报告测试", httpMethod = "POST", response = CheckResult.class, notes = "添加测试报告")
    @RequestMapping(value = "/addTestOrderTest")
    @ResponseBody
    public CheckResult addTestOrderTest(@ModelAttribute("TestReportBasicInfoObj")TestReportBasicInfoObj testReportBasicInfoObj,
                                        @ModelAttribute("ReportProductionInfoObject")ReportProductionInfoObject reportProductionInfoObject,
                                        @ModelAttribute("ReportProductionInfoObject2")ReportProductionInfoObject reportProductionInfoObject2,
                                        @RequestParam(value = "file",required = false)MultipartFile file,
                                        @RequestParam(value = "file1",required = false)MultipartFile file1,
                                        HttpServletRequest request){
        CheckResult checkResult=new CheckResult();
        String fileUrl=null;
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("请先登录");
            return checkResult;
        }
        try {
            String uploadDir =FileOperateService.getUploadDir(request) +user.getId()+ "\\";
            fileUrl= FileService.uploadMultiFile(uploadDir, file,file1);
        }catch (Exception e){
            checkResult.setSuccess(false);
            checkResult.setErrMsg(e.getMessage());
            return checkResult;
        }
        testReportService.addTestReport2(testReportBasicInfoObj,user.getId(),fileUrl,reportProductionInfoObject,reportProductionInfoObject2);
        checkResult.setSuccess(true);
        return checkResult;
    }

    @ApiOperation(value = "查看第n页测试报告", httpMethod = "POST", response = SimpleTestReportObject.class, notes = "查看第n页测试报告")
    @RequestMapping(value = "/findAllTestReport")
    @ResponseBody
    public PageModel<SimpleTestReportObject> findAllTestReport(@RequestParam("pageNumber")Integer pageNumber, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        PageModel<SimpleTestReportObject> pageModel=new PageModel<>();
        if(user==null){
            pageModel.setSuccess(false);
            pageModel.setErrMsg("请先登录");
            return pageModel;
        }
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(testReportService.getTotalPage(dataNumberPerPage,user.getId()));
        Range2 range=new Range2();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        range.setUserId(user.getId());
        pageModel.setObjects(testReportService.getAllTestReport(range));
        return pageModel;
    }

    @ApiOperation(value = "查看测试报告详情", httpMethod = "POST", response = TestReportAllInfo.class, notes = "查看测试报告详情")
    @RequestMapping(value = "/findTestReportById")
    @ResponseBody
    public TestReportAllInfo findTestReportById(HttpServletRequest request, @RequestParam("id")int id){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            return null;
        }
        return testReportService.findById(id,request);
    }

    @ApiOperation(value = "模糊搜索", httpMethod = "POST", response = PageModel.class, notes = "模糊搜索")
    @RequestMapping(value = "/fuzzySearch")
    @ResponseBody
    public PageModel<SimpleTestReportObject> FuzzySearch(HttpServletRequest request,@RequestParam("pageNumber")int pageNumber, @RequestParam("content")String content){
        User user=(User)request.getSession().getAttribute("user");
        PageModel<SimpleTestReportObject> pageModel=new PageModel<>();
        if(user==null){
            pageModel.setSuccess(false);
            pageModel.setErrMsg("请先登录");
            return pageModel;
        }
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(testReportService.getFuzzySearchTotalPage(user.getId(),content,dataNumberPerPage));
        Range3 range=new Range3();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        range.setUserId(user.getId());
        range.setContent(content);
        pageModel.setObjects(testReportService.fuzzySearch(range));
        return pageModel;
    }
}
