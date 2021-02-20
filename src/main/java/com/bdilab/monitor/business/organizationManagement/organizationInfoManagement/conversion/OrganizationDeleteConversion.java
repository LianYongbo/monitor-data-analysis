package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.conversion;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.standard.OrganizationDeleteStandard;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.view.OrganizationDeleteView;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.vertification.OrganizationInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 删除组织接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/19 3:43
 **/
@Component
public class OrganizationDeleteConversion {
    private final OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity;

    public OrganizationDeleteConversion(OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity) {
        this.organizationInfoManagementVerifyIntegrity = organizationInfoManagementVerifyIntegrity;
    }

    /**
     * 删除组织入参转换为业务对象
     *
     * @param organizationDeleteStandard 删除组织入参
     * @return 转换后的业务对象
     */
    public Organization conversion(OrganizationDeleteStandard organizationDeleteStandard) {
        if (!organizationInfoManagementVerifyIntegrity.verify(organizationDeleteStandard)) {
            System.out.println("删除组织接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Organization organization = new Organization();
        organization.setOrganizationId(organizationDeleteStandard.getOrganizationId());
        return organization;
    }

    /**
     * 删除组织业务对象转换为出参
     *
     * @param organization 删除组织业务对象
     * @return 转换后的出参
     */
    public OrganizationDeleteView conversion(Organization organization) {
        int type = 2;
        if (!organizationInfoManagementVerifyIntegrity.verifyDelete(organization, type)) {
            System.out.println("删除组织接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
        }
        OrganizationDeleteView organizationDeleteView = new OrganizationDeleteView();
        organizationDeleteView.setOrganizationId(organization.getOrganizationId());
        organizationDeleteView.setOrganizationDeleted(organization.getOrganizationDeleted());
        return organizationDeleteView;
    }
}
