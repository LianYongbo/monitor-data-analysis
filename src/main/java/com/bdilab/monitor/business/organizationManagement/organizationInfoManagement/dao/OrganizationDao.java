package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.dao;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationDao {
    int deleteByPrimaryKey(String organizationId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String organizationId);

    Organization selectByPrimaryKeyAndParentId(@Param("id") String organizationId,@Param("parentId") String organizationParentId);

    List<Organization> selectFuzzyByNameAndParentId(@Param("name") String organizationName,@Param("parentId") String organizationParentId);

    /**
     * 根据父组织编号获取下一层组织
     * @param organizationParentId
     * @return
     */
    List<Organization> selectByParentId(@Param("parentId") String organizationParentId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

}