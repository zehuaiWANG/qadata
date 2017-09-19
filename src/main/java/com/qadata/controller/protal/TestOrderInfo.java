package com.qadata.controller.protal;

import com.qadata.pojo.User;
import com.qadata.service.FileOperateService;
import com.qadata.service.FileService;
import com.qadata.service.TestOrderInfoService;
import com.qadata.vo.CheckResult;
import com.qadata.vo.PageModel;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import com.qadata.vo.testOrder.SimpleTestOrderObject;
import com.qadata.vo.testOrder.TestOrderAllInfo;
import com.qadata.vo.testOrder.TestOrderObject;
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
 * Created by Administrator on 2017/8/9 0009.
 */
@Controller
@RequestMapping(value = "/testOrder")
@Api(tags = "testOrderInfo",description="测试报价上传与查看")
public class TestOrderInfo {
    @Autowired
    TestOrderInfoService testOrderInfoService;

    @ApiOperation(value = "添加测试报价测试", httpMethod = "POST", response = CheckResult.class, notes = "添加测试报价")
    @RequestMapping(value = "/addTestOrderTest")
    @ResponseBody
    public CheckResult addTestOrder(@ModelAttribute("TestOrderObject")TestOrderObject testOrderObject,
                                    @RequestParam(value = "file" ,required = false)MultipartFile file,
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
        if(!testOrderObject.notNullCheck()){
            checkResult.setSuccess(false);
            checkResult.setErrMsg(testOrderObject.getErrorMsg());
            return checkResult;
        }
        try {
            String uploadDir = FileOperateService.getUploadDir(request) +user.getId()+ "\\";
            fileUrl= FileService.uploadMultiFile(uploadDir, file,file1);
            System.out.println(fileUrl);
        }catch (Exception e){
            checkResult.setSuccess(false);
            checkResult.setErrMsg(e.getMessage());
            return checkResult;
        }
        testOrderInfoService.addTestOrder(testOrderObject,user.getId(),fileUrl);
        checkResult.setSuccess(true);
        return checkResult;
    }

    @ApiOperation(value = "添加测试报价", httpMethod = "POST", response = CheckResult.class, notes = "添加测试报价")
    @RequestMapping(value = "/addTestOrder")
    @ResponseBody
    public CheckResult addTestOrder(@ModelAttribute("TestOrderObject")TestOrderObject testOrderObject,
                                    @RequestParam(value = "file",required = false)MultipartFile[] file, HttpServletRequest request){
        CheckResult checkResult=new CheckResult();
        String fileUrl=null;
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("请先登录");
            return checkResult;
        }
        if(!testOrderObject.notNullCheck()){
            checkResult.setSuccess(false);
            checkResult.setErrMsg(testOrderObject.getErrorMsg());
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
        testOrderInfoService.addTestOrder(testOrderObject,user.getId(),fileUrl);
        checkResult.setSuccess(true);
        return checkResult;
    }

    @ApiOperation(value = "查看第n页测试报价", httpMethod = "POST", response = SimpleTestOrderObject.class, notes = "查看第n页测试报价")
    @RequestMapping(value = "/findAllTestOrder")
    @ResponseBody
    public PageModel<SimpleTestOrderObject> findAllTestOrder(@RequestParam("pageNumber")Integer pageNumber,HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            return null;
        }
        PageModel<SimpleTestOrderObject> pageModel=new PageModel<>();
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(testOrderInfoService.getTotalPage(dataNumberPerPage,user.getId()));
        Range2 range=new Range2();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        range.setUserId(user.getId());
        pageModel.setObjects(testOrderInfoService.getAllTestOrder(range));
        return pageModel;
    }

    @ApiOperation(value = "查看测试报价详情", httpMethod = "POST", response = TestOrderAllInfo.class, notes = "查看测试报价详情")
    @RequestMapping(value = "/findTestOrderById")
    @ResponseBody
    public TestOrderAllInfo findTestOrderById(HttpServletRequest request, @RequestParam("id")int id){
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            return null;
        }
        return testOrderInfoService.findById(id,request);
    }

    @ApiOperation(value = "模糊搜索", httpMethod = "POST", response = PageModel.class, notes = "模糊搜索")
    @RequestMapping(value = "/fuzzySearch")
    @ResponseBody
    public PageModel<SimpleTestOrderObject> FuzzySearch(HttpServletRequest request,@RequestParam("pageNumber")int pageNumber, @RequestParam("content")String content){
        User user=(User)request.getSession().getAttribute("user");
        PageModel<SimpleTestOrderObject> pageModel=new PageModel<>();
        if(user==null){
            pageModel.setSuccess(false);
            pageModel.setErrMsg("请先登录");
            return pageModel;
        }
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(testOrderInfoService.getFuzzySearchTotalPage(user.getId(),content,dataNumberPerPage));
        Range3 range=new Range3();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        range.setUserId(user.getId());
        range.setContent(content);
        pageModel.setObjects(testOrderInfoService.fuzzySearch(range));
        return pageModel;
    }
}
