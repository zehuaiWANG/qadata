package com.qadata.controller.protal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/9/9 0009.
 */
@Controller
public class PageTrans {

    @RequestMapping(value = "login")
    public String goLogin(){
        return "login";
    }

    @RequestMapping(value = "forget")
    public String goForget(){
        return "forget";
    }

    @RequestMapping(value = "make_order")
    public String goMakeOrder(){
        return "make_order";
    }

    @RequestMapping(value = "make_report")
    public String goMakeReport(){
        return "make_report";
    }

    @RequestMapping(value = "my_orders")
    public String goMyOrder(){
        return "my_orders";
    }

    @RequestMapping(value = "my_reports")
    public String goMyReport(){
        return "my_reports";
    }

    @RequestMapping(value = "signin")
    public String goSignIn(){
        return "signin";
    }
}
