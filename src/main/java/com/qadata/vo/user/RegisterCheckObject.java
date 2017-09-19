package com.qadata.vo.user;

//import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2017/8/5 0005.
 */
public class RegisterCheckObject {

   // @ApiModelProperty(value = "邮箱", required = true)
    private String mail;
   // @ApiModelProperty(value = "注册码", required = true)
    private String registerCode;
    //@ApiModelProperty(value = "密码", required = true)
    private String password;
   // @ApiModelProperty(value = "公司名称", required = true)
    private String name;
    //@ApiModelProperty(value = "电话号码", required = true)
    private String phonenumber;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
