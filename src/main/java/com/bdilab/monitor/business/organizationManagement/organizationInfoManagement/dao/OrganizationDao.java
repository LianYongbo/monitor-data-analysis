package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.dao;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import org.apache.ibatis.annotations.Param;

public interface OrganizationDao {
    int deleteByPrimaryKey(String organizationId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String organizationId);

    Organization selectByPrimaryKeyAndParentId(@Param("id") String organizationId,@Param("parentId") String organizationParentId);

    Organization selectByNameAndParentId(@Param("name") String organizationName,@Param("parentId") String organizationParentId);

    Organization selectByParentId(@Param("parentId") String organizationParentId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

}