package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.service;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.Organization;

import java.util.List;

/**
 * 组织管理模块
 * 组织信息管理子模块服务接口
 *
 * @author Lian
 * @date 2021/2/19 0:28
 **/
public interface OrganizationInfoManagementService {
    /**
     * 创建组织
     *
     * @param organization 包含基本信息的组织业务对象
     * @return 创建的组织的基本信息
     */
    Organization organizationCreate(Organization organization);

    /**
     * 修改组织信息
     *
     * @param organization 包含基本信息的组织业务对象
     * @return 修改的组织的基本信息
     */
    Organization organizationUpdate(Organization organization);

    /**
     * 删除组织
     *
     * @param organization 包含组织编号的组织业务对象
     * @return 删除后的信息
     */
    Organization organizationDelete(Organization organization);

    /**
     * 根据名称查找组织
     *
     * @param organization 包含组织名称的组织业务对象
     * @return 符合该名称的组织集合
     */
    List<Organization> organizationFindByName(Organization organization);

    /**
     * 根据编号查找组织
     *
     * @param organization 包含组织编号的组织业务对象
     * @return 符合该编号的组织
     */
    Organization organizationFindById(Organization organization);

    /**
     * 根据父组织编号查找组织
     *
     * @param organization 包含父组织编号的组织业务对象
     * @return 符合该父组织编号的组织集合
     */
    List<Organization> organizationFindByParentId(Organization organization);
}
