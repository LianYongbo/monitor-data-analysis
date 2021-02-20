package com.bdilab.monitor.business.userManagement.userInfoManagement.dao;

import com.bdilab.monitor.business.userManagement.userInfoManagement.model.business.User;

public interface UserDao {
    int deleteByPrimaryKey(String userMobile);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String userMobile);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}