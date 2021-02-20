package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.service.impl;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.service.OrganizationInfoManagementService;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.vertification.OrganizationInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 组织管理模块
 * 组织信息管理子模块服务接口实现
 *
 * @author Lian
 * @date 2021/2/19 0:30
 **/
@Service
public class OrganizationInfoManagementServiceImpl implements OrganizationInfoManagementService {
    private final OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity;

    public OrganizationInfoManagementServiceImpl(OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity) {
        this.organizationInfoManagementVerifyIntegrity = organizationInfoManagementVerifyIntegrity;
    }

    @Override
    public Organization organizationCreate(Organization organization) {
        int type = 1;
        if (!organizationInfoManagementVerifyIntegrity.verifyCreate(organization, type)) {
            System.out.println("创建组织接口 - 创建组织服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        return organization;
    }

    @Override
    public Organization organizationUpdate(Organization organization) {
        int type = 1;
        if (!organizationInfoManagementVerifyIntegrity.verifyUpdate(organization, type)) {
            System.out.println("修改组织信息接口 - 修改组织信息服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        organization.setOrganizationParentId("1");
        return organization;
    }

    @Override
    public Organization organizationDelete(Organization organization) {
        int type = 1;
        if (!organizationInfoManagementVerifyIntegrity.verifyDelete(organization, type)) {
            System.out.println("删除组织信息接口 - 删除组织信息服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        organization.setOrganizationDeleted(true);
        return organization;
    }

    @Override
    public List<Organization> organizationFindByName(Organization organization) {
        int type = 1;
        if (!organizationInfoManagementVerifyIntegrity.verifyFindByName(organization, type)) {
            System.out.println("根据名称查找组织接口 - 根据名称查找组织服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        organization.setOrganizationId("1");
        organization.setOrganizationAddress("北街");
        organization.setOrganizationContact("4322");
        organization.setOrganizationRemark("无");
        List<Organization> organizations = new ArrayList<>();
        Organization organization1 = new Organization();
        organization1.setOrganizationParentId(organization.getOrganizationParentId());
        organization1.setOrganizationId("3");
        organization1.setOrganizationName(organization.getOrganizationName());
        organization1.setOrganizationAddress("北街A");
        organization1.setOrganizationContact("4322A");
        organization1.setOrganizationRemark("无");
        organizations.add(organization);
        organizations.add(organization1);
        return organizations;
    }

    @Override
    public Organization organizationFindById(Organization organization) {
        int type = 1;
        if (!organizationInfoManagementVerifyIntegrity.verifyFindById(organization, type)) {
            System.out.println("根据编号查找组织接口 - 根据编号查找组织服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        organization.setOrganizationName("华美集团");
        organization.setOrganizationAddress("北街");
        organization.setOrganizationContact("4322");
        organization.setOrganizationRemark("无");
        return organization;
    }

    @Override
    public List<Organization> organizationFindByParentId(Organization organization) {
        int type = 1;
        if (!organizationInfoManagementVerifyIntegrity.verifyFindByParentId(organization, type)) {
            System.out.println("根据父组织编号查找组织接口 - 根据父组织编号查找组织服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        organization.setOrganizationId("2");
        organization.setOrganizationName("华美集团");
        organization.setOrganizationAddress("北街");
        organization.setOrganizationContact("4322");
        organization.setOrganizationRemark("无");
        List<Organization> organizations = new ArrayList<>();
        Organization organization1 = new Organization();
        organization1.setOrganizationParentId(organization.getOrganizationParentId());
        organization1.setOrganizationId("3");
        organization1.setOrganizationName("华美集团A");
        organization1.setOrganizationAddress("北街A");
        organization1.setOrganizationContact("4322A");
        organization1.setOrganizationRemark("无");
        organizations.add(organization);
        organizations.add(organization1);
        return organizations;
    }
}
