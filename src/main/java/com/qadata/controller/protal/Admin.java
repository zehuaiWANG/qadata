package com.qadata.controller.protal;

import com.qadata.pojo.User;
import com.qadata.service.*;
import com.qadata.vo.CheckResult;
import com.qadata.vo.InspectionOrder.InspectionOrderAllInfo;
import com.qadata.vo.InspectionOrder.SimpleInspectionOrderObject;
import com.qadata.vo.InspectionReport.InspectionReportAllInfo;
import com.qadata.vo.InspectionReport.SimpleInspectionReportObject;
import com.qadata.vo.PageModel;
import com.qadata.vo.Range;
import com.qadata.vo.testOrder.SimpleTestOrderObject;
import com.qadata.vo.testOrder.TestOrderAllInfo;
import com.qadata.vo.testReport.SimpleTestReportObject;
import com.qadata.vo.testReport.TestReportAllInfo;
import com.qadata.vo.user.UserInfoChangeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/admin/")
public class Admin {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private InspectionOrderService inspectionOrderService;
    @Autowired
    private InspectionReportService inspectionReportService;
    @Autowired
    private TestOrderInfoService testOrderInfoService;
    @Autowired
    private TestReportService testReportService;


    @RequestMapping(value = "findAllInspectionOrder",method= RequestMethod.POST)
    @ResponseBody
    public PageModel<SimpleInspectionOrderObject> findAllInspectionOrder(@RequestParam("pageNumber")Integer pageNumber, HttpServletRequest request){
        PageModel<SimpleInspectionOrderObject> pageModel = new PageModel<>();
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(inspectionOrderService.getTotalPageByAdmin(dataNumberPerPage));
        Range range = new Range();
        pageNumber = pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        pageModel.setObjects(inspectionOrderService.getAllTestOrderByAdmin(range));
        return pageModel;
    }

    @RequestMapping(value = "findInspectionOrderById",method= RequestMethod.POST)
    @ResponseBody
    public InspectionOrderAllInfo findInspectionOrderById(@RequestParam("id")Integer id, HttpServletRequest request){
        return inspectionOrderService.findById(id,request);
    }


    @RequestMapping(value = "findAllInspectionReport",method= RequestMethod.POST)
    @ResponseBody
    public PageModel<SimpleInspectionReportObject> findAllInspectionReportByAdmin(@RequestParam("pageNumber")Integer pageNumber, HttpServletRequest request){
        PageModel<SimpleInspectionReportObject> pageModel=new PageModel<>();
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(inspectionReportService.getTotalPageByAdmin(dataNumberPerPage));
        Range range=new Range();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        pageModel.setObjects(inspectionReportService.findAllInspectionReportByAdmin(range));
        return pageModel;
    }

    @RequestMapping(value = "findInspectionReportById",method= RequestMethod.POST)
    @ResponseBody
    public InspectionReportAllInfo findInspectionReportById(HttpServletRequest request, @RequestParam("id")int id){
        return inspectionReportService.findById(id,request);
    }

    @RequestMapping(value = "findAllTestReport",method= RequestMethod.POST)
    @ResponseBody
    public PageModel<SimpleTestReportObject> findAllTestReport(@RequestParam("pageNumber")Integer pageNumber, HttpServletRequest request){
        PageModel<SimpleTestReportObject> pageModel=new PageModel<>();
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(testReportService.getTotalPageByAdmin(dataNumberPerPage));
        Range range=new Range();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        pageModel.setObjects(testReportService.getAllTestReportByAdmin(range));
        return pageModel;
    }

    @RequestMapping(value = "findTestReportById",method= RequestMethod.POST)
    @ResponseBody
    public TestReportAllInfo findTestReportById(HttpServletRequest request, @RequestParam("id")int id){
        return testReportService.findById(id,request);
    }

    @RequestMapping(value = "findAllTestOrder",method= RequestMethod.POST)
    @ResponseBody
    public PageModel<SimpleTestOrderObject> findAllTestOrder(@RequestParam("pageNumber")Integer pageNumber, HttpServletRequest request){
        PageModel<SimpleTestOrderObject> pageModel=new PageModel<>();
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(testOrderInfoService.getTotalPageByAdmin(dataNumberPerPage));
        Range range=new Range();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        pageModel.setObjects(testOrderInfoService.getAllTestOrderByAdmin(range));
        return pageModel;
    }

    @RequestMapping(value = "findTestOrderById",method= RequestMethod.POST)
    @ResponseBody
    public TestOrderAllInfo findTestOrderById(HttpServletRequest request, @RequestParam("id")int id){
        return testOrderInfoService.findById(id,request);
    }

    @RequestMapping(value = "changeUserInfo",method= RequestMethod.POST)
    @ResponseBody
    public CheckResult changeUserInfo(@ModelAttribute("userInfoChangeObject")UserInfoChangeObject uerInfoChangeObject, HttpServletRequest request){
        CheckResult checkResult=new CheckResult();
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("请先登录");
            return checkResult;
        }
        if(!user.getType().equals("admin")){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("不是管理员无法进行此操作");
            return checkResult;
        }
        if(!userInfoService.hasUser(uerInfoChangeObject.getId())){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("id 为"+uerInfoChangeObject.getId()+"的用户不存在");
            return checkResult;
        }
        userInfoService.changeUserInfo(uerInfoChangeObject);
        checkResult.setSuccess(true);
        return  checkResult;
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public PageModel<User> getAllUser(@RequestParam("pageNumber")Integer pageNumber, HttpServletRequest request){
        PageModel<User> pageModel=new PageModel<>();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(userInfoService.getTotalPage());
        pageModel.setObjects(userInfoService.getAllUser(pageNumber-1));
        pageModel.setSuccess(true);
        return pageModel;
    }

    @RequestMapping("unableUser")
    @ResponseBody
    public CheckResult unableUser(@RequestParam("mail")String mail){
        CheckResult checkResult=new CheckResult();
        User user=userInfoService.getUserByMail(mail);
        if(user==null){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("用户不存在");
            return checkResult;
        }
        if(user.getState().equals("禁用")) {
            checkResult.setSuccess(true);
            return checkResult;
        }
        user.setState("禁用");
        userInfoService.changeUserState(user);
        checkResult.setSuccess(true);
        return checkResult;
    }

    @RequestMapping("enableUser")
    @ResponseBody
    public CheckResult enableUser(@RequestParam("mail")String mail){
        CheckResult checkResult=new CheckResult();
        User user=userInfoService.getUserByMail(mail);
        if(user==null){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("用户不存在");
            return checkResult;
        }
        if(user.getState().equals("已启用")) {
            checkResult.setSuccess(true);
            return checkResult;
        }
        user.setState("已启用");
        userInfoService.changeUserState(user);
        checkResult.setSuccess(true);
        return checkResult;
    }
}
