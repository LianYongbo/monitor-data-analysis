package com.bdilab.mine.business.organizationManagement.organizationInfoManagement.conversion;

import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.standard.OrganizationFindByNameStandard;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.view.OrganizationFindByNameView;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.vertification.OrganizationInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 根据名称查找组织接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/19 10:59
 **/
@Component
public class OrganizationFindByNameConversion {
    private final OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity;

    public OrganizationFindByNameConversion(OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity) {
        this.organizationInfoManagementVerifyIntegrity = organizationInfoManagementVerifyIntegrity;
    }

    /**
     * 根据名称查找组织入参转换为业务对象
     *
     * @param organizationFindByNameStandard 根据名称查找组织入参
     * @return 转换后的业务对象
     */
    public Organization conversion(OrganizationFindByNameStandard organizationFindByNameStandard) {
        if (!organizationInfoManagementVerifyIntegrity.verify(organizationFindByNameStandard)) {
            System.out.println("根据名称查找组织接口 - 入参转换业务对象 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        Organization organization = new Organization();
        organization.setOrganizationName(organizationFindByNameStandard.getOrganizationName());
        organization.setOrganizationParentId(organizationFindByNameStandard.getOrganizationParentId());
        return organization;
    }

    /**
     * 根据名称查找组织业务对象转换为出参
     *
     * @param organization 根据名称查找组织业务对象
     * @return 转换后的出参
     */
    public OrganizationFindByNameView conversion(Organization organization) {
        int type = 2;
        if (!organizationInfoManagementVerifyIntegrity.verifyFindByName(organization, type)) {
            System.out.println("修改组织信息接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        OrganizationFindByNameView organizationFindByNameView = new OrganizationFindByNameView();
        organizationFindByNameView.setOrganizationId(organization.getOrganizationId());
        organizationFindByNameView.setOrganizationName(organization.getOrganizationName());
        organizationFindByNameView.setOrganizationContact(organization.getOrganizationContact());
        organizationFindByNameView.setOrganizationAddress(organization.getOrganizationAddress());
        organizationFindByNameView.setOrganizationParentId(organization.getOrganizationParentId());
        organizationFindByNameView.setOrganizationRemark(organization.getOrganizationRemark());
        return organizationFindByNameView;
    }
}
