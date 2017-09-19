package com.qadata.dao;

import com.qadata.pojo.User;
import com.qadata.vo.Range;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    //新增
    List<User> selectUserInRange(Range range);

    User selectByMail(String mail);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int getTotalNumber();
}