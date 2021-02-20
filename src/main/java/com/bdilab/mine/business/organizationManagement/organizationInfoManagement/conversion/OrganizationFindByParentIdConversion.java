package com.bdilab.mine.business.organizationManagement.organizationInfoManagement.conversion;

import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.standard.OrganizationFindByParentIdStandard;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.view.OrganizationFindByParentIdView;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.vertification.OrganizationInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 根据父组织编号查找组织接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/19 12:55
 **/
@Component
public class OrganizationFindByParentIdConversion {
    private final OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity;

    public OrganizationFindByParentIdConversion(OrganizationInfoManagementVerifyIntegrity organizationInfoManagementVerifyIntegrity) {
        this.organizationInfoManagementVerifyIntegrity = organizationInfoManagementVerifyIntegrity;
    }

    /**
     * 根据父组织编号查找组织入参转换为业务对象
     *
     * @param organizationFindByParentIdStandard 根据父组织编号查找组织入参
     * @return 转换后的业务对象
     */
    public Organization conversion(OrganizationFindByParentIdStandard organizationFindByParentIdStandard) {
        if (!organizationInfoManagementVerifyIntegrity.verify(organizationFindByParentIdStandard)) {
            System.out.println("根据父组织编号查找组织接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Organization organization = new Organization();
        organization.setOrganizationId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        organization.setOrganizationParentId(organizationFindByParentIdStandard.getOrganizationParentId());
        return organization;
    }

    public OrganizationFindByParentIdView conversion(Organization organization) {
        int type = 2;
        if (!organizationInfoManagementVerifyIntegrity.verifyFindByParentId(organization, type)) {
            System.out.println("根据父组织编号查找组织接口 - 业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        OrganizationFindByParentIdView organizationFindByParentIdView = new OrganizationFindByParentIdView();
        organizationFindByParentIdView.setOrganizationId(organization.getOrganizationId());
        organizationFindByParentIdView.setOrganizationName(organization.getOrganizationName());
        organizationFindByParentIdView.setOrganizationAddress(organization.getOrganizationAddress());
        organizationFindByParentIdView.setOrganizationContact(organization.getOrganizationContact());
        organizationFindByParentIdView.setOrganizationParentId(organization.getOrganizationParentId());
        organizationFindByParentIdView.setOrganizationRemark(organization.getOrganizationRemark());
        return organizationFindByParentIdView;
    }
}
