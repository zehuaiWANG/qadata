package com.qadata.dao;



import com.qadata.pojo.InspectionReport;
import com.qadata.vo.Range;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InspectionReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InspectionReport record);

    int insertSelective(InspectionReport record);

    InspectionReport selectByPrimaryKey(Integer id);

    //新增
    List<InspectionReport> selectInspectionReportInRange(Range2 range);

    //新增
    List<InspectionReport> selectAllInspectionReportInRange(Range range);

    //新增
    int getTotalNumber(int userId);

    //新增
    int getTotalNumberByAdmin();

    int updateByPrimaryKeySelective(InspectionReport record);

    int updateByPrimaryKey(InspectionReport record);

    //新增
    int getFuzzySearchTotalNumber(Range3 range);

    //新增
    List<InspectionReport> fuzzySearch(Range3 range);
}