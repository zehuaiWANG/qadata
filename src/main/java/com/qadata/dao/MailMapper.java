package com.qadata.dao;

import com.qadata.pojo.Mail;
import org.springframework.stereotype.Repository;

@Repository
public interface MailMapper {
    int insert(Mail record);

    int insertSelective(Mail record);
}