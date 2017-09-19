package com.qadata.vo.InspectionReport.sub;

//import com.deusino.entity.OnSiteTest;

import com.qadata.pojo.OnSiteTest;

/**
 * Created by Administrator on 2017/8/31 0031.
 */
public class OnSiteTestObject {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public void transFrom(OnSiteTest onSiteTest) {
        setName(onSiteTest.getName());
        setValue(onSiteTest.getValue());
    }

    public OnSiteTest getOnSiteTest() {
        OnSiteTest onSiteTest = new OnSiteTest();
        onSiteTest.setName(getName());
        onSiteTest.setValue(getValue());
        return onSiteTest;
    }
}
