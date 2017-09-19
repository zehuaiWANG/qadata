package com.qadata.vo;

import java.util.List;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class PageModel<AnyType> {
    private List<AnyType> Objects;

    private int currentPage;

    private int totalPage;

    private boolean success;

    private String errMsg;

    private int dataNumberPerPage =10;

    public List<AnyType> getObjects() {
        return Objects;
    }

    public void setObjects(List<AnyType> objects) {
        this.Objects = objects;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getDataNumberPerPage() {
        return dataNumberPerPage;
    }

    public void setDataNumberPerPage(int dataNumberPerPage) {
        this.dataNumberPerPage = dataNumberPerPage;
    }
}
