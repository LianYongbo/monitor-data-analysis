package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.dao;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Menu;

public interface MenuDao {
    int deleteByPrimaryKey(String menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}