package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.dao;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.UserRole;

public interface UserRoleDao {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}