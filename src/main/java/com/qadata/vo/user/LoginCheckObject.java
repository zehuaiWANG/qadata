package com.qadata.vo.user;

//import io.swagger.annotations.ApiModelProperty;
/**
 * Created by Administrator on 2017/8/4 0004.
 */
public class LoginCheckObject {

   // @ApiModelProperty(value = "用户名称", required = true)
    private String mail;
   // @ApiModelProperty(value = "用户密码", required = true)
    private String password;

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
}
