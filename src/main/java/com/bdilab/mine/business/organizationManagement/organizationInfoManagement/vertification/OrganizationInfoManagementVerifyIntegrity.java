package com.bdilab.mine.business.organizationManagement.organizationInfoManagement.vertification;

import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.standard.*;
import com.bdilab.mine.util.VerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 组织管理模块
 * 组织信息管理子模块
 * 验证参数完整性
 *
 * @author Lian
 * @date 2021/2/19 1:58
 **/
@Component
public class OrganizationInfoManagementVerifyIntegrity {
    private final VerifyIntegrity verifyIntegrity;

    public OrganizationInfoManagementVerifyIntegrity(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    /**
     * 创建组组入参完整性校验
     * 校验组织名称、父组织编号、组织联系电话、组织地址、备注的完整性
     *
     * @param organizationCreateStandard 创建组织入参对象
     * @return 组织名称、父组织编号、组织联系电话、组织地址中有为空或为Null，返回false，备注为Null，返回false；否则返回true
     */
    public Boolean verify(OrganizationCreateStandard organizationCreateStandard) {
        return !verifyIntegrity.verify(organizationCreateStandard.getOrganizationName()) && !verifyIntegrity.verify(organizationCreateStandard.getOrganizationParentId()) &&
                !verifyIntegrity.verify(organizationCreateStandard.getOrganizationContact()) && !verifyIntegrity.verify(organizationCreateStandard.getOrganizationAddress()) &&
                organizationCreateStandard.getOrganizationRemark() != null;
    }

    /**
     * 创建组织业务对象完整性校验
     * 校验组织编号、组织名称、父组织编号、组织联系电话、组织地址、备注的完整性
     *
     * @param organization 创建组织业务对象
     * @param type         可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 组织编号、组织名称、父组织编号、组织联系电话、组织地址中有为空或为Null，返回false，备注、组织是否被删除中有为Null，返回false；否则返回true
     */
    public Boolean verifyCreate(Organization organization, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(organization.getOrganizationName()) && !verifyIntegrity.verify(organization.getOrganizationParentId()) &&
                        !verifyIntegrity.verify(organization.getOrganizationContact()) && !verifyIntegrity.verify(organization.getOrganizationAddress()) &&
                        organization.getOrganizationRemark() != null;
            case 2:
                return !verifyIntegrity.verify(organization.getOrganizationId()) && !verifyIntegrity.verify(organization.getOrganizationName()) &&
                        !verifyIntegrity.verify(organization.getOrganizationParentId()) && !verifyIntegrity.verify(organization.getOrganizationContact()) &&
                        !verifyIntegrity.verify(organization.getOrganizationAddress()) && organization.getOrganizationRemark() != null;
            default:
                System.out.println("创建组织接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 修改组织信息入参完整性校验
     * 校验组织编号、组织名称、组织联系电话、组织地址、备注的完整性
     *
     * @param organizationUpdateStandard 修改组织信息入参对象
     * @return 组织编号、组织名称、组织联系电话、组织地址中有为空或为Null，返回false，备注为Null，返回false；否则返回true
     */
    public Boolean verify(OrganizationUpdateStandard organizationUpdateStandard) {
        return !verifyIntegrity.verify(organizationUpdateStandard.getOrganizationId()) && !verifyIntegrity.verify(organizationUpdateStandard.getOrganizationName()) &&
                !verifyIntegrity.verify(organizationUpdateStandard.getOrganizationContact()) && !verifyIntegrity.verify(organizationUpdateStandard.getOrganizationAddress()) &&
                organizationUpdateStandard.getOrganizationRemark() != null;
    }

    /**
     * 修改组织信息业务对象完整性校验
     * 校验组织编号、组织名称、父组织编号、组织联系电话、组织地址、备注的完整性
     *
     * @param organization 修改组织业务对象
     * @param type         可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 组织编号、组织名称、父组织编号、组织联系电话、组织地址中有为空或为Null，返回false，备注为Null，返回false；否则返回true
     */
    public Boolean verifyUpdate(Organization organization, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(organization.getOrganizationId()) && !verifyIntegrity.verify(organization.getOrganizationName()) &&
                        !verifyIntegrity.verify(organization.getOrganizationContact()) && !verifyIntegrity.verify(organization.getOrganizationAddress()) &&
                        organization.getOrganizationRemark() != null;
            case 2:
                return !verifyIntegrity.verify(organization.getOrganizationId()) && !verifyIntegrity.verify(organization.getOrganizationName()) &&
                        !verifyIntegrity.verify(organization.getOrganizationParentId()) && !verifyIntegrity.verify(organization.getOrganizationContact()) &&
                        !verifyIntegrity.verify(organization.getOrganizationAddress()) && organization.getOrganizationRemark() != null;
            default:
                System.out.println("修改组织接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 删除组织入参完整性校验
     * 校验组织编号的完整性
     *
     * @param organizationDeleteStandard 删除组织入参对象
     * @return 组织编号为空或为Null，返回false；否则返回true
     */
    public Boolean verify(OrganizationDeleteStandard organizationDeleteStandard) {
        return !verifyIntegrity.verify(organizationDeleteStandard.getOrganizationId());
    }

    /**
     * 删除组织业务对象完整性校验
     * 校验组织编号、组织是否被删除的完整性
     *
     * @param organization 删除组织业务对象
     * @param type         可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 组织是否被删除中有为Null，返回false；否则返回true
     */
    public Boolean verifyDelete(Organization organization, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(organization.getOrganizationId());
            case 2:
                return !verifyIntegrity.verify(organization.getOrganizationId()) && organization.getOrganizationDeleted() != null;
            default:
                System.out.println("删除组织接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 根据名称查找组织入参完整性校验
     * 校验组织名称、父组织编号的完整性
     *
     * @param organizationFindByNameStandard 根据名称查找组织入参对象
     * @return 组织名称、父组织编号中有为空或为Null，返回false；否则返回true
     */
    public Boolean verify(OrganizationFindByNameStandard organizationFindByNameStandard) {
        return !verifyIntegrity.verify(organizationFindByNameStandard.getOrganizationName()) && !verifyIntegrity.verify(organizationFindByNameStandard.getOrganizationParentId());
    }

    /**
     * 根据名称查找组织业务对象完整性校验
     * 校验组织编号、组织名称、父组织编号、组织联系电话、组织地址、备注的完整性
     *
     * @param organization 根据名称查找组织业务对象
     * @param type         可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 组织编号、组织名称、父组织编号、组织联系电话、组织地址中有为空或为Null，返回false，备注、组织是否被删除中有为Null，返回false；否则返回true
     */
    public Boolean verifyFindByName(Organization organization, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(organization.getOrganizationName()) && !verifyIntegrity.verify(organization.getOrganizationParentId());
            case 2:
                return !verifyIntegrity.verify(organization.getOrganizationId()) && !verifyIntegrity.verify(organization.getOrganizationName()) &&
                        !verifyIntegrity.verify(organization.getOrganizationParentId()) && !verifyIntegrity.verify(organization.getOrganizationContact()) &&
                        !verifyIntegrity.verify(organization.getOrganizationAddress()) && organization.getOrganizationRemark() != null;
            default:
                System.out.println("根据名称查找组织接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 根据父组织编号查找组织入参完整性校验
     * 校验父组织编号的完整性
     *
     * @param organizationFindByParentIdStandard 根据父组织编号查找组织入参对象
     * @return 父组织编号为空或为Null，返回false；否则返回true
     */
    public Boolean verify(OrganizationFindByParentIdStandard organizationFindByParentIdStandard) {
        return !verifyIntegrity.verify(organizationFindByParentIdStandard.getOrganizationParentId());
    }

    /**
     * 根据父组织编号查找组织业务对象完整性校验
     * 校验组织编号、组织名称、父组织编号、组织联系电话、组织地址、备注的完整性
     *
     * @param organization 根据父组织编号查找组织业务对象
     * @param type         可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 组织编号、组织名称、父组织编号、组织联系电话、组织地址中有为空或为Null，返回false，备注、组织是否被删除中有为Null，返回false；否则返回true
     */
    public Boolean verifyFindByParentId(Organization organization, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(organization.getOrganizationParentId());
            case 2:
                return !verifyIntegrity.verify(organization.getOrganizationId()) && !verifyIntegrity.verify(organization.getOrganizationName()) &&
                        !verifyIntegrity.verify(organization.getOrganizationParentId()) && !verifyIntegrity.verify(organization.getOrganizationContact()) &&
                        !verifyIntegrity.verify(organization.getOrganizationAddress()) && organization.getOrganizationRemark() != null;
            default:
                System.out.println("根据父组织编号查找组织接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 根据编号查找组织入参完整性校验
     * 校验组织编号、父组织编号的完整性
     *
     * @param organizationFindByIdStandard 根据编号查找组织入参对象
     * @return 组织编号、父组织编号中有为空或为Null，返回false；否则返回true
     */
    public Boolean verify(OrganizationFindByIdStandard organizationFindByIdStandard) {
        return !verifyIntegrity.verify(organizationFindByIdStandard.getOrganizationId()) && !verifyIntegrity.verify(organizationFindByIdStandard.getOrganizationParentId());
    }

    /**
     * 根据编号查找组织业务对象完整性校验
     * 校验组织编号、组织名称、父组织编号、组织联系电话、组织地址、备注的完整性
     *
     * @param organization 根据编号查找组织业务对象
     * @param type         可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 组织编号、组织名称、父组织编号、组织联系电话、组织地址中有为空或为Null，返回false，备注、组织是否被删除中有为Null，返回false；否则返回true
     */
    public Boolean verifyFindById(Organization organization, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(organization.getOrganizationId()) && !verifyIntegrity.verify(organization.getOrganizationParentId());
            case 2:
                return !verifyIntegrity.verify(organization.getOrganizationId()) && !verifyIntegrity.verify(organization.getOrganizationName()) &&
                        !verifyIntegrity.verify(organization.getOrganizationParentId()) && !verifyIntegrity.verify(organization.getOrganizationContact()) &&
                        !verifyIntegrity.verify(organization.getOrganizationAddress()) && organization.getOrganizationRemark() != null;
            default:
                System.out.println("根据编号查找组织接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }
}
