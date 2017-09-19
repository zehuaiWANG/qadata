package com.qadata.dao;

import com.qadata.pojo.TestOrder;
import com.qadata.vo.Range;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TestOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestOrder record);

    int insertSelective(TestOrder record);

    //新增
    List<TestOrder> selectTestOrderInRange(Range2 range);

    //新增
    List<TestOrder> selectAllTestOrderInRange(Range range);

    TestOrder selectByPrimaryKey(Integer id);

    //新增
    List<TestOrder> selectByUserId(Integer id);

    int updateByPrimaryKeySelective(TestOrder record);

    int updateByPrimaryKey(TestOrder record);

    //新增
    int getTotalNumberByAdmin();

    //新增
    int getTotalNumber(int userId);

    //新增
    int getFuzzySearchTotalNumber(Range3 range);

    //新增
    List<TestOrder> fuzzySearch(Range3 range);
}