package com.qadata.dao;


import com.qadata.pojo.OnSiteTest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnSiteTestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OnSiteTest record);

    int insertSelective(OnSiteTest record);

    OnSiteTest selectByPrimaryKey(Integer id);

    //新增
    List<OnSiteTest> selectByReportId(Integer id);

    int updateByPrimaryKeySelective(OnSiteTest record);

    int updateByPrimaryKey(OnSiteTest record);
}