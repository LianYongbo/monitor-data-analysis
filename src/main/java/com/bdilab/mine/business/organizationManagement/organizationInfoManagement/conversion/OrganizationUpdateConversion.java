package com.bdilab.mine.business.organizationManagement.organizationInfoManagement.conversion;

import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.standard.OrganizationUpdateStandard;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.view.OrganizationUpdateView;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.vertification.OrganizationInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 修改组织信息接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/19 2:45
 **/
@Component
public class OrganizationUpdateConversion {
    private final OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity;

    public OrganizationUpdateConversion(OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity) {
        this.organizationInfoManagementVerifyIntegrity = organizationInfoManagementVerifyIntegrity;
    }

    /**
     * 修改组织信息入参转换为业务对象
     *
     * @param organizationUpdateStandard 修改组织信息入参
     * @return 转换后的业务对象
     */
    public Organization conversion(OrganizationUpdateStandard organizationUpdateStandard) {
        if (!organizationInfoManagementVerifyIntegrity.verify(organizationUpdateStandard)) {
            System.out.println("修改组织信息接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Organization organization = new Organization();
        organization.setOrganizationId(organizationUpdateStandard.getOrganizationId());
        organization.setOrganizationName(organizationUpdateStandard.getOrganizationName());
        organization.setOrganizationContact(organizationUpdateStandard.getOrganizationContact());
        organization.setOrganizationAddress(organizationUpdateStandard.getOrganizationAddress());
        organization.setOrganizationRemark(organizationUpdateStandard.getOrganizationRemark());
        return organization;
    }

    /**
     * 修改组织信息业务对象转换为出参
     *
     * @param organization 修改组织信息业务对象
     * @return 转换后的出参
     */
    public OrganizationUpdateView conversion(Organization organization) {
        int type = 2;
        if (!organizationInfoManagementVerifyIntegrity.verifyUpdate(organization, type)) {
            System.out.println("修改组织信息接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        OrganizationUpdateView organizationUpdateView = new OrganizationUpdateView();
        organizationUpdateView.setOrganizationId(organization.getOrganizationId());
        organizationUpdateView.setOrganizationName(organization.getOrganizationName());
        organizationUpdateView.setOrganizationAddress(organization.getOrganizationAddress());
        organizationUpdateView.setOrganizationContact(organization.getOrganizationContact());
        organizationUpdateView.setOrganizationRemark(organization.getOrganizationRemark());
        organizationUpdateView.setOrganizationParentId(organization.getOrganizationParentId());
        return organizationUpdateView;
    }
}
