package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.dao;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.RoleMenu;

public interface RoleMenuDao {
    int deleteByPrimaryKey(String id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);
}