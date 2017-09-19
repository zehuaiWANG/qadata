package com.qadata.dao;

import com.qadata.pojo.MeasurementAndWeight;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementAndWeightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeasurementAndWeight record);

    int insertSelective(MeasurementAndWeight record);

    //新增
    List<MeasurementAndWeight> selectByReportId(Integer id);

    MeasurementAndWeight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeasurementAndWeight record);

    int updateByPrimaryKey(MeasurementAndWeight record);
}