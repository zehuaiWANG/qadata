package com.qadata.controller.protal;

import com.qadata.pojo.User;
import com.qadata.service.UserInfoService;
import com.qadata.service.mail.MailClientService;
import com.qadata.vo.CheckResult;
import com.qadata.vo.user.LoginCheckObject;
import com.qadata.vo.user.RegisterCheckObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/")
public class UserInfo {
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("login.do")
    @ResponseBody
    public CheckResult doLogin(@ModelAttribute("LoginCheckObject")LoginCheckObject loginCheckObject, HttpServletRequest request) {
        CheckResult checkResult = new CheckResult();
        String mail = loginCheckObject.getMail();
        String password = loginCheckObject.getPassword();
        if(mail == null || mail.equals("")){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("请输入邮箱");
            return checkResult;
        }
        if(password == null || mail == null ){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("请输入密码");
            return checkResult;
        }
        if (!userInfoService.loginCheck(mail,password)) {
            checkResult.setSuccess(false);
            checkResult.setErrMsg("用户不存在或密码错误");
            return checkResult;
        }
        User user=userInfoService.getUserByMail(mail);
        if("已启用".equals(user.getState())){
            request.getSession().setAttribute("user",user);
            checkResult.setSuccess(true);
            return checkResult;
        }
        if("待验证".equals(user.getState())){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("您的账号尚未通过验证");
            return checkResult;
        }
        if("禁用".equals(user.getState())){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("您的账号已被禁用");
            return checkResult;
        }
        checkResult.setSuccess(false);
        checkResult.setErrMsg("未知错误");
        return checkResult;
    }

    @RequestMapping(value = "buyerRegister.do")
    @ResponseBody
    public CheckResult buyerRegister(@ModelAttribute("RegisterCheckObject")RegisterCheckObject registerCheckObject, HttpServletRequest request){
        CheckResult checkResult =new CheckResult();
        if(!registerCheck(registerCheckObject.getRegisterCode(),registerCheckObject.getMail(),checkResult,request)){
            return checkResult;
        }
        userInfoService.register(registerCheckObject,"buyer");
        checkResult.setSuccess(true);
        return checkResult;
    }

    @RequestMapping(value = "factoryRegister.do")
    @ResponseBody
    public CheckResult factoryRegister(@ModelAttribute("RegisterCheckObject")RegisterCheckObject registerCheckObject, HttpServletRequest request){
        CheckResult checkResult =new CheckResult();
        if(!registerCheck(registerCheckObject.getRegisterCode(),registerCheckObject.getMail(),checkResult,request)){
            return checkResult;
        }
        userInfoService.register(registerCheckObject,"factory");
        checkResult.setSuccess(true);
        return checkResult;
    }
    private boolean registerCheck(String registerCode,String mail,CheckResult checkResult,HttpServletRequest request){
        String registerCode1=(String) request.getSession().getAttribute("registerCode");
        request.getSession().removeAttribute("registerCode");
        String mail1=(String) request.getSession().getAttribute("checkMail");
        request.getSession().removeAttribute("checkMail");
        if(registerCode1==null||registerCode==null||!registerCode1.equals(registerCode)){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("注册码错误");
            return false;
        }
        if(mail1==null||mail==null||!mail1.equals(mail)){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("此邮箱非验证邮箱");
            return false;
        }
        return true;
    }

    @RequestMapping("sendRegisterCode.do")
    @ResponseBody
    public CheckResult sendRegisterCode(@RequestParam("mail") String mail, HttpServletRequest request){
        CheckResult checkResult =new CheckResult();
        if(mail==null||mail.equals("")){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("未输入邮箱");
            return checkResult;
        }
        if(userInfoService.hasUser(mail)){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("邮箱已被注册");
            return checkResult;
        }
        String registerCode=String.format("%04d",(int) (Math.random() * 10000));
        MailClientService mailClientService=new MailClientService();
        mailClientService.sendRegisterMail(mail,registerCode);
        request.getSession().setAttribute("registerCode",registerCode);
        request.getSession().setAttribute("checkMail",mail);
        checkResult.setSuccess(true);
        return checkResult;
    }

    @RequestMapping("sendFindCode.do")
    @ResponseBody
    public CheckResult sendFindCode(@RequestParam("mail") String mail, HttpServletRequest request){
        CheckResult checkResult =new CheckResult();
        if(mail==null||mail.equals("")){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("未输入邮箱");
            return checkResult;
        }
        if(!userInfoService.hasUser(mail)){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("此邮箱未注册");
            return checkResult;
        }
        String findCode=String.format("%04d",(int) (Math.random() * 10000));
        MailClientService mailClientService=new MailClientService();
        mailClientService.sendResetPassMail(mail,findCode,userInfoService.getUserByMail(mail).getName());
        request.getSession().setAttribute("findCode",findCode);
        request.getSession().setAttribute("checkMail",mail);
        checkResult.setSuccess(true);
        return checkResult;
    }

    @RequestMapping("resetPassword.do")
    @ResponseBody
    public CheckResult resetPassword(@RequestParam("mail") String mail,@RequestParam("checkCode")String checkCode,@RequestParam("newPassword")String newPassword, HttpServletRequest request){
        CheckResult checkResult =new CheckResult();
        String findCode1=(String) request.getSession().getAttribute("findCode");
        request.getSession().removeAttribute("registerCode");
        String mail1=(String) request.getSession().getAttribute("checkMail");
        request.getSession().removeAttribute("checkMail");
        if(findCode1==null||checkCode==null||!findCode1.equals(checkCode)){
            checkResult.setSuccess(false);
            checkResult.setErrMsg("注册码错误");
            return checkResult;
        }
        if(mail1==null||mail==null||!mail1.trim().equals(mail.trim())){
            checkResult.setSuccess(false);
            System.out.println(mail1+"    "+mail);
            checkResult.setErrMsg("此邮箱非验证邮箱");
            return checkResult;
        }
        userInfoService.changePassword(mail,newPassword);
        checkResult.setSuccess(true);
        return checkResult;
    }
}
