package com.qadata.service;


import com.qadata.dao.UserMapper;
import com.qadata.pojo.User;
import com.qadata.vo.Range;
import com.qadata.vo.user.RegisterCheckObject;
import com.qadata.vo.user.UserInfoChangeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserInfoService {
    int number=10;
    @Autowired
    UserMapper userMapper;
    public boolean hasUser(String mail){
        User user=userMapper.selectByMail(mail);
        if(user!=null&&user.getMail().equals(mail)){
            return true;
        }else
            return false;
    }
    public boolean loginCheck(String mail,String password){
        User user = userMapper.selectByMail(mail);
        if(user != null && user.getPassword().equals(password)){
            return true;
        }else
            return false;
    }
    public void register(RegisterCheckObject registerCheckObject, String type){
        User user=new User();
        user.setMail(registerCheckObject.getMail());
        user.setReceiveMail(registerCheckObject.getMail());
        user.setPassword(registerCheckObject.getPassword());
        user.setName(registerCheckObject.getName());
        user.setPhonenumber(registerCheckObject.getPhonenumber());
        user.setState("待验证");
        user.setType(type);
        userMapper.insertSelective(user);
    }
    public void changePassword(String mail,String newPassword){
        User user=userMapper.selectByMail(mail);
        User user1=new User();
        user1.setId(user.getId());
        user1.setPassword(newPassword);
        userMapper.updateByPrimaryKeySelective(user1);
    }
    public User getUserByMail(String mail){
        return userMapper.selectByMail(mail);
    }
    public List<User> getAllUser(Integer pageNumber){
        Range range=new Range();
        range.setStart(pageNumber*10+1);
        range.setLast(pageNumber*10+10);
        return userMapper.selectUserInRange(range);
    }
    public int getTotalPage(){
        int totalPage=userMapper.getTotalNumber()/number;
        if((userMapper.getTotalNumber()%number)!=0){
            totalPage++;
        }
        return totalPage;
    }
    public void changeUserInfo(UserInfoChangeObject userInfo) {
        User user=new User();
        if(userInfo.getMail()!=null&&!userInfo.getMail().equals("null"))
            user.setMail(userInfo.getMail());
        if(userInfo.getPhonenumber()!=null&&!userInfo.getPhonenumber().equals("null"))
            user.setPhonenumber(userInfo.getPhonenumber());
        if(userInfo.getReceiveMail()!=null&&!userInfo.getReceiveMail().equals("null"))
            user.setReceiveMail(userInfo.getReceiveMail());
        if(userInfo.getName()!=null&&!userInfo.getName().equals("null"))
            user.setName(userInfo.getName());
        user.setId(userInfo.getId());
        userMapper.updateByPrimaryKeySelective(user);
    }
    public void changeUserState(User user){
        User user1=new User();
        user1.setId(user.getId());
        user1.setState(user.getState());
        userMapper.updateByPrimaryKeySelective(user1);
    }
    public boolean hasUser(int id){
        return userMapper.selectByPrimaryKey(id)!=null;
    }
}
