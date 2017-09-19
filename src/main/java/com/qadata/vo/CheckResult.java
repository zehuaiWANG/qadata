package com.qadata.vo;

/**
 * Created by Administrator on 2017/8/2 0002.
 */
public class CheckResult {
   private String errMsg;
   private boolean  success;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
