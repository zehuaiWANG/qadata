package com.qadata.controller.protal;


import com.qadata.pojo.User;
import com.qadata.service.FileOperateService;
import com.qadata.service.FileService;
import com.qadata.service.InspectionReportService;
import com.qadata.vo.CheckResult;
import com.qadata.vo.InspectionReport.InspectionReportAllInfo;
import com.qadata.vo.InspectionReport.InspectionReportBasicInfoObj;
import com.qadata.vo.InspectionReport.InspectionReportObject;
import com.qadata.vo.InspectionReport.SimpleInspectionReportObject;
import com.qadata.vo.PageModel;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
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


@Controller
@RequestMapping(value = "inspectionReport")
@Api(tags = "inspectionReportInfo",description="验货报告上传与查看")
public class InspectionReportInfo {
    @Autowired
    InspectionReportService inspectionReportService;

    //@ApiOperation(value = "添加验货报告测试", httpMethod = "POST", response = CheckResult.class, notes = "添加验货报告")
    @RequestMapping(value = "/addInspectionReportTest")
    @ResponseBody
    public CheckResult addInspectionReportTest(@ModelAttribute("InspectionReportBasicInfoObj")InspectionReportBasicInfoObj inspectionReportBasicInfoObj,
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
        String uploadDir = FileOperateService.getUploadDir(request) +user.getId()+ "\\";
        try {
            fileUrl= FileService.uploadMultiFile(uploadDir, file,file1);
        }catch (Exception e){
            checkResult.setSuccess(false);
            checkResult.setErrMsg(e.getMessage());
            return checkResult;
        }
        inspectionReportService.addInspectionReport1(inspectionReportBasicInfoObj,user.getId(),fileUrl);
        checkResult.setSuccess(true);
        return checkResult;
    }
    @ApiOperation(value = "添加验货报告", httpMethod = "POST", response = CheckResult.class, notes = "添加验货报告")
    @RequestMapping(value = "/addInspectionReport")
    @ResponseBody
    public CheckResult addInspectionReport(@ModelAttribute("InspectionReportObject")InspectionReportObject inspectionReportObject,
                                           @RequestParam(value = "file",required = false)MultipartFile[] file, HttpServletRequest request){
        CheckResult checkResult=new CheckResult();
        String fileUrl=null;
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("请先登录");
            return checkResult;
        }
        String uploadDir = FileOperateService.getUploadDir(request) +user.getId()+ "\\";
        try {
            fileUrl= FileService.uploadMultiFile(uploadDir, file);
        }catch (Exception e){
            checkResult.setSuccess(false);
            checkResult.setErrMsg(e.getMessage());
            return checkResult;
        }
        inspectionReportService.addInspectionReport(inspectionReportObject,user.getId(),fileUrl);
        checkResult.setSuccess(true);
        return checkResult;
    }

    @ApiOperation(value = "查看第n页验货报告", httpMethod = "POST", response = SimpleInspectionReportObject.class, notes = "查看第n页验货报告")
    @RequestMapping(value = "/findAllInspectionReport")
    @ResponseBody
    public PageModel<SimpleInspectionReportObject> findAllInspectionReport(@RequestParam("pageNumber")Integer pageNumber, HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            return null;
        }
        PageModel<SimpleInspectionReportObject> pageModel=new PageModel<>();
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(inspectionReportService.getTotalPage(dataNumberPerPage,user.getId()));
        Range2 range=new Range2();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        range.setUserId(user.getId());
        pageModel.setObjects(inspectionReportService.findAllInspectionReport(range));
        return pageModel;
    }

    @ApiOperation(value = "查看测试报价详情", httpMethod = "POST", response = InspectionReportAllInfo.class, notes = "查看测试报价详情")
    @RequestMapping(value = "/findInspectionReportById")
    @ResponseBody
    public InspectionReportAllInfo findInspectionReportById(HttpServletRequest request, @RequestParam("id")int id){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            return null;
        }
        return inspectionReportService.findById(id,request);
    }

    @ApiOperation(value = "模糊搜索", httpMethod = "POST", response = PageModel.class, notes = "模糊搜索")
    @RequestMapping(value = "/fuzzySearch")
    @ResponseBody
    public PageModel<SimpleInspectionReportObject> FuzzySearch(HttpServletRequest request,@RequestParam("pageNumber")int pageNumber, @RequestParam("content")String content){
        User user=(User)request.getSession().getAttribute("user");
        PageModel<SimpleInspectionReportObject> pageModel=new PageModel<>();
        if(user==null){
            pageModel.setSuccess(false);
            pageModel.setErrMsg("请先登录");
            return pageModel;
        }
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(inspectionReportService.getFuzzySearchTotalPage(user.getId(),content,dataNumberPerPage));
        Range3 range=new Range3();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        range.setUserId(user.getId());
        range.setContent(content);
        pageModel.setObjects(inspectionReportService.fuzzySearch(range));
        return pageModel;
    }
}
