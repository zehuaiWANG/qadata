package com.qadata.dao;

import com.qadata.pojo.TestReport;
import com.qadata.vo.Range;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestReportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestReport record);

    int insertSelective(TestReport record);

    //新增
    List<TestReport> selectTestReportInRange(Range2 range);

    //新增
    List<TestReport> selectAllTestReportInRange(Range range);

    //新增
    List<TestReport> fuzzySearch(Range3 range);

    TestReport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestReport record);

    int updateByPrimaryKey(TestReport record);

    int getTotalNumber(int userId);

    //新增
    int getFuzzySearchTotalNumber(Range3 range);

    int getTotalNumberByAdmin();
}