package com.qadata.vo.user;

//import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/8/8 0008.
 */
public class UserInfoChangeObject {
    //@ApiModelProperty(value = "用户ID")
    private Integer id;

    //@ApiModelProperty(value = "公司名称")
    private String name;

    //@ApiModelProperty(value = "注册邮箱")
    private String mail;

    //@ApiModelProperty(value = "手机号")
    private String phonenumber;

    //@ApiModelProperty(value = "接收邮箱")
    private String receiveMail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getReceiveMail() {
        return receiveMail;
    }

    public void setReceiveMail(String receiveMail) {
        this.receiveMail = receiveMail;
    }
}
