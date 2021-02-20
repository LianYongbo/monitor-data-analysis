package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.conversion;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.standard.OrganizationCreateStandard;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.view.OrganizationCreateView;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.vertification.OrganizationInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 创建组织接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/19 0:59
 **/
@Component
public class OrganizationCreateConversion {
    private final OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity;

    public OrganizationCreateConversion(OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity) {
        this.organizationInfoManagementVerifyIntegrity = organizationInfoManagementVerifyIntegrity;
    }

    /**
     * 创建组织入参转换为业务对象
     *
     * @param organizationCreateStandard 创建组织入参
     * @return 转换后的业务对象
     */
    public Organization conversion(OrganizationCreateStandard organizationCreateStandard) {
        if (!organizationInfoManagementVerifyIntegrity.verify(organizationCreateStandard)) {
            System.out.println("创建组织接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Organization organization = new Organization();
        organization.setOrganizationId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        organization.setOrganizationName(organizationCreateStandard.getOrganizationName());
        organization.setOrganizationAddress(organizationCreateStandard.getOrganizationAddress());
        organization.setOrganizationContact(organizationCreateStandard.getOrganizationContact());
        organization.setOrganizationParentId(organizationCreateStandard.getOrganizationParentId());
        organization.setOrganizationRemark(organizationCreateStandard.getOrganizationRemark());
        organization.setOrganizationDeleted(false);
        return organization;
    }

    /**
     * 创建组织业务对象转换为出参
     *
     * @param organization 创建组织业务对象
     * @return 转换后的出参
     */
    public OrganizationCreateView conversion(Organization organization) {
        int type = 2;
        if (!organizationInfoManagementVerifyIntegrity.verifyCreate(organization, type)) {
            System.out.println("创建组织接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        OrganizationCreateView organizationCreateView = new OrganizationCreateView();
        organizationCreateView.setOrganizationId(organization.getOrganizationId());
        organizationCreateView.setOrganizationName(organization.getOrganizationName());
        organizationCreateView.setOrganizationAddress(organization.getOrganizationAddress());
        organizationCreateView.setOrganizationContact(organization.getOrganizationContact());
        organizationCreateView.setOrganizationParentId(organization.getOrganizationParentId());
        organizationCreateView.setOrganizationRemark(organization.getOrganizationRemark());
        return organizationCreateView;
    }
}
