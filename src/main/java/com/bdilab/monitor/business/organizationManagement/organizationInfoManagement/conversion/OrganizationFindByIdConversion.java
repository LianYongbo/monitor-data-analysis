package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.conversion;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.standard.OrganizationFindByIdStandard;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.view.OrganizationFindByIdView;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.vertification.OrganizationInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 根据编号查找组织接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/19 13:30
 **/
@Component
public class OrganizationFindByIdConversion {
    private final OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity;

    public OrganizationFindByIdConversion(OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity) {
        this.organizationInfoManagementVerifyIntegrity = organizationInfoManagementVerifyIntegrity;
    }

    /**
     * 根据编号查找组织入参转换为业务对象
     *
     * @param organizationFindByIdStandard 根据编号查找组织入参
     * @return 转换后的业务对象
     */
    public Organization conversion(OrganizationFindByIdStandard organizationFindByIdStandard) {
        if (!organizationInfoManagementVerifyIntegrity.verify(organizationFindByIdStandard)) {
            System.out.println("根据编号查找组织接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Organization organization = new Organization();
        organization.setOrganizationId(organizationFindByIdStandard.getOrganizationId());
        organization.setOrganizationParentId(organizationFindByIdStandard.getOrganizationParentId());
        return organization;
    }

    /**
     * 根据编号查找组织业务对象转换为出参
     *
     * @param organization 根据编号查找组织业务对象
     * @return 转换后的出参
     */
    public OrganizationFindByIdView conversion(Organization organization) {
        int type = 2;
        if (!organizationInfoManagementVerifyIntegrity.verifyFindById(organization, type)) {
            System.out.println("根据编号查找组织接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        OrganizationFindByIdView organizationFindByIdView = new OrganizationFindByIdView();
        organizationFindByIdView.setOrganizationId(organization.getOrganizationId());
        organizationFindByIdView.setOrganizationName(organization.getOrganizationName());
        organizationFindByIdView.setOrganizationAddress(organization.getOrganizationAddress());
        organizationFindByIdView.setOrganizationContact(organization.getOrganizationContact());
        organizationFindByIdView.setOrganizationParentId(organization.getOrganizationParentId());
        organizationFindByIdView.setOrganizationRemark(organization.getOrganizationRemark());
        return organizationFindByIdView;
    }
}
