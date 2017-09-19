package com.qadata.dao;


import com.qadata.pojo.ReportProductInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportProductInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportProductInfo record);

    int insertSelective(ReportProductInfo record);

    ReportProductInfo selectByPrimaryKey(Integer id);

    //新增
    List<ReportProductInfo> selectByReportId(Integer id);

    int updateByPrimaryKeySelective(ReportProductInfo record);

    int updateByPrimaryKey(ReportProductInfo record);
}