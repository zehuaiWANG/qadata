package com.qadata.dao;


import com.qadata.pojo.Workmanship;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkmanshipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workmanship record);

    int insertSelective(Workmanship record);

    Workmanship selectByPrimaryKey(Integer id);

    List<Workmanship> selectByReportId(Integer id);

    int updateByPrimaryKeySelective(Workmanship record);

    int updateByPrimaryKey(Workmanship record);
}