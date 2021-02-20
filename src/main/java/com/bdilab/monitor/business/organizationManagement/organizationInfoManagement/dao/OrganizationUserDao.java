package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.dao;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.OrganizationUser;

public interface OrganizationUserDao {
    int deleteByPrimaryKey(String id);

    int insert(OrganizationUser record);

    int insertSelective(OrganizationUser record);

    OrganizationUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrganizationUser record);

    int updateByPrimaryKey(OrganizationUser record);
}