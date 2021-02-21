package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.dao;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.OrganizationUser;
import com.bdilab.monitor.business.userManagement.userInfoManagement.model.business.User;

import java.util.List;

public interface OrganizationUserDao {
    int deleteByPrimaryKey(String id);

    int insert(OrganizationUser record);

    int insertSelective(OrganizationUser record);

    OrganizationUser selectByPrimaryKey(String id);

    /**
     * 获取直属于该组织的所有用户
     * @param organizationId
     * @return
     */
    List<User> selectByOrganizationId(String organizationId);

    int updateByPrimaryKeySelective(OrganizationUser record);

    int updateByPrimaryKey(OrganizationUser record);
}