package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.dao;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;

import java.util.List;

public interface RoleDao {
    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String roleId);

    List<Role> selectAll();

    List<Role> selectFuzzyByNameZh(String roleNameZh);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}