package com.qadata.controller.protal;
import com.qadata.pojo.User;
import com.qadata.service.FileOperateService;
import com.qadata.service.FileService;
import com.qadata.service.InspectionOrderService;
import com.qadata.vo.CheckResult;
import com.qadata.vo.InspectionOrder.*;
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
@RequestMapping(value = "inspectionOrder")
public class InspectionOrderInfo {
    @Autowired
    InspectionOrderService inspectionOrderService;

    @ApiOperation(value = "添加验货订单", httpMethod = "POST", response = CheckResult.class, notes = "添加验货订单")
    @RequestMapping(value = "/addInspectionOrder")
    @ResponseBody
    public CheckResult addInspectionOrder(@ModelAttribute("InspectionOrderObject") InspectionOrderObject inspectionOrderObject,
                                          @RequestParam(value = "file",required = false) MultipartFile[] file,
                                          HttpServletRequest request) {
        CheckResult checkResult = new CheckResult();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            checkResult.setSuccess(false);
            checkResult.setErrMsg("请先登录");
            return checkResult;
        }
        String uploadDir = FileOperateService.getUploadDir(request) + user.getId() + "\\";
        String fileUrl = null;
        if (file != null)
            try {
                fileUrl = FileService.uploadMultiFile(uploadDir, file);
            } catch (Exception e) {
                checkResult.setSuccess(false);
                checkResult.setErrMsg(e.getMessage());
                return checkResult;
            }
        inspectionOrderService.addInspectionOrder(inspectionOrderObject, fileUrl, user.getId());
        checkResult.setSuccess(true);
        return checkResult;
    }

    @RequestMapping(value = "/addInspectionOrder2")
    @ResponseBody
    public CheckResult addInspectionOrder2(@ModelAttribute("InspectionOrderBasicInfoObj") InspectionOrderBasicInfoObj inspectionOrderBasicInfoObj,
                                           @ModelAttribute("OrderProductionInfoObject") OrderProductionInfoObject orderProductionInfoObject,
                                           @ModelAttribute("OrderProductionInfoObject2") OrderProductionInfoObject orderProductionInfoObject2,
                                           @RequestParam(value = "file", required = false) MultipartFile file,
                                           @RequestParam(value = "file1",required = false) MultipartFile file1,
                                           HttpServletRequest request) {
        CheckResult checkResult = new CheckResult();
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            checkResult.setSuccess(false);
            checkResult.setErrMsg("请先登录");
            return checkResult;
        }
        String uploadDir = FileOperateService.getUploadDir(request) + user.getId() + "\\";
        String fileUrl = null;
            try {
                fileUrl = FileService.uploadMultiFile(uploadDir, file, file1);
            } catch (Exception e) {
                checkResult.setSuccess(false);
                checkResult.setErrMsg(e.getMessage());
                return checkResult;
            }
        inspectionOrderService.addInspectionOrder(inspectionOrderBasicInfoObj, fileUrl, user.getId(), orderProductionInfoObject, orderProductionInfoObject2);
        checkResult.setSuccess(true);
        return checkResult;
    }

    @RequestMapping(value = "/findAllInspectionOrder")
    @ResponseBody
    public PageModel<SimpleInspectionOrderObject> findAllInspectionOrder(@RequestParam("pageNumber") Integer pageNumber, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return null;
        }
        PageModel<SimpleInspectionOrderObject> pageModel = new PageModel<>();
        int dataNumberPerPage = pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(inspectionOrderService.getTotalPage(dataNumberPerPage, user.getId()));
        Range2 range = new Range2();
        pageNumber = pageNumber - 1;
        range.setStart(pageNumber * dataNumberPerPage + 1);
        range.setLast(pageNumber * dataNumberPerPage + dataNumberPerPage);
        range.setUserId(user.getId());
        pageModel.setObjects(inspectionOrderService.getAllTestOrder(range));
        return pageModel;
    }

    @RequestMapping(value = "/findInspectionOrderById")
    @ResponseBody
    public InspectionOrderAllInfo findInspectionOrderById(@RequestParam("id") Integer id, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return null;
        }
        return inspectionOrderService.findById(id,request);
    }

    @RequestMapping(value = "/fuzzySearch")
    @ResponseBody
    public PageModel<SimpleInspectionOrderObject> FuzzySearch(HttpServletRequest request,@RequestParam("pageNumber")int pageNumber, @RequestParam("content")String content){
        User user=(User)request.getSession().getAttribute("user");
        PageModel<SimpleInspectionOrderObject> pageModel=new PageModel<>();
        if(user==null){
            pageModel.setSuccess(false);
            pageModel.setErrMsg("请先登录");
            return pageModel;
        }
        int dataNumberPerPage=pageModel.getDataNumberPerPage();
        pageModel.setCurrentPage(pageNumber);
        pageModel.setTotalPage(inspectionOrderService.getFuzzySearchTotalPage(user.getId(),content,dataNumberPerPage));
        Range3 range=new Range3();
        pageNumber=pageNumber-1;
        range.setStart(pageNumber*dataNumberPerPage+1);
        range.setLast(pageNumber*dataNumberPerPage+dataNumberPerPage);
        range.setUserId(user.getId());
        range.setContent(content);
        pageModel.setObjects(inspectionOrderService.fuzzySearch(range));
        return pageModel;
    }
}
