package com.qadata.dao;



import com.qadata.pojo.OrderProductInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderProductInfo record);

    int insertSelective(OrderProductInfo record);

    OrderProductInfo selectByPrimaryKey(Integer id);

    //新增
    List<OrderProductInfo> selectByOrderId(Integer id);

    int updateByPrimaryKeySelective(OrderProductInfo record);

    int updateByPrimaryKey(OrderProductInfo record);
}