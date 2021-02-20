package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.dao;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;

public interface RoleDao {
    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}