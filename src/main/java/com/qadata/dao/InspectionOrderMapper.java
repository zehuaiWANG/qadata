package com.qadata.dao;

import com.qadata.pojo.InspectionOrder;
import com.qadata.vo.Range;
import com.qadata.vo.Range2;
import com.qadata.vo.Range3;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface InspectionOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InspectionOrder record);

    int insertSelective(InspectionOrder record);

    //新增
    List<InspectionOrder> selectInspectionOrderInRange(Range2 range);

    //新增
    List<InspectionOrder> selectAllInspectionOrderInRange(Range range);

    InspectionOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InspectionOrder record);

    int updateByPrimaryKey(InspectionOrder record);

    //新增
    int getTotalNumberByAdmin();

    //新增
    int getTotalNumber(int userId);

    //新增
    int getFuzzySearchTotalNumber(Range3 range);

    //新增
    List<InspectionOrder> fuzzySearch(Range3 range);
}