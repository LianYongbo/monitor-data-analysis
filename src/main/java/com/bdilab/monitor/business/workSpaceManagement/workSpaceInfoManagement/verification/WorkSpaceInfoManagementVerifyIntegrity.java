package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.verification;

import com.bdilab.monitor.business.userManagement.userInfoManagement.model.business.User;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.Workspace;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.standard.*;
import com.bdilab.monitor.util.VerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 工区管理模块
 * 工区信息管理子模块
 * 验证参数完整性
 *
 * @author Lian
 * @date 2021/2/20 0:07
 **/
@Component
public class WorkSpaceInfoManagementVerifyIntegrity {
    private final VerifyIntegrity verifyIntegrity;

    public WorkSpaceInfoManagementVerifyIntegrity(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    /**
     * 创建工区入参完整性校验
     *
     * @param workSpaceCreateStandard 创建工区入参对象
     * @return 工区名称、父组织编号、工区联系电话、工区地址中有为空或为Null，返回false，备注为Null，返回false；否则返回true
     */
    public Boolean verify(WorkSpaceCreateStandard workSpaceCreateStandard) {
        return !verifyIntegrity.verify(workSpaceCreateStandard.getWorkSpaceName()) && !verifyIntegrity.verify(workSpaceCreateStandard.getWorkSpaceContact()) &&
                !verifyIntegrity.verify(workSpaceCreateStandard.getWorkSpaceAddress()) && !verifyIntegrity.verify(workSpaceCreateStandard.getWorkSpaceParentId()) &&
                workSpaceCreateStandard.getWorkSpaceRemark() != null;
    }

    /**
     * 创建工区业务对象完整性校验
     *
     * @param workSpace 创建工区业务对象
     * @param type      可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 工区编号、工区名称、父组织编号、工区联系电话、工区地址中有为空或为Null，返回false，备注、工区人数为Null，返回false；否则返回true
     */
    public Boolean verifyCreate(Workspace workSpace, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceName()) && !verifyIntegrity.verify(workSpace.getWorkSpaceContact()) &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceAddress()) && !verifyIntegrity.verify(workSpace.getWorkSpaceParentId()) &&
                        workSpace.getWorkSpaceRemark() != null;
            case 2:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceId()) && workSpace.getWorkSpacePeopleNumber() != null &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceName()) && !verifyIntegrity.verify(workSpace.getWorkSpaceContact()) &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceAddress()) && !verifyIntegrity.verify(workSpace.getWorkSpaceParentId()) &&
                        workSpace.getWorkSpaceRemark() != null;
            default:
                System.out.println("创建工区接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 修改工区信息入参完整性校验
     *
     * @param workSpaceUpdateStandard 修改工区信息入参对象
     * @return 工区编号、工区名称、工区联系电话、工区地址中有为空或为Null，返回false，备注为Null，返回false；否则返回true
     */
    public Boolean verify(WorkSpaceUpdateStandard workSpaceUpdateStandard) {
        return !verifyIntegrity.verify(workSpaceUpdateStandard.getWorkSpaceId()) && !verifyIntegrity.verify(workSpaceUpdateStandard.getWorkSpaceContact()) &&
                !verifyIntegrity.verify(workSpaceUpdateStandard.getWorkSpaceName()) && !verifyIntegrity.verify(workSpaceUpdateStandard.getWorkSpaceAddress()) &&
                workSpaceUpdateStandard.getWorkSpaceRemark() != null;
    }

    /**
     * 修改工区信息业务对象完整性校验
     *
     * @param workSpace 修改工区信息业务对象
     * @param type      可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 工区编号、工区名称、父组织编号、工区联系电话、工区地址中有为空或为Null，返回false，备注、工区人数为Null，返回false；否则返回true
     */
    public Boolean verifyUpdate(Workspace workSpace, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceId()) && !verifyIntegrity.verify(workSpace.getWorkSpaceContact()) &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceName()) && !verifyIntegrity.verify(workSpace.getWorkSpaceAddress()) &&
                        workSpace.getWorkSpaceRemark() != null;
            case 2:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceId()) && workSpace.getWorkSpacePeopleNumber() != null &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceName()) && !verifyIntegrity.verify(workSpace.getWorkSpaceContact()) &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceAddress()) && !verifyIntegrity.verify(workSpace.getWorkSpaceParentId()) &&
                        workSpace.getWorkSpaceRemark() != null;
            default:
                System.out.println("修改工区信息接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 根据工区编号查找用户入参完整性校验
     *
     * @param userFindByWorkSpaceIdStandard 根据工区编号查找用户入参对象
     * @return 工区编号为空或为Null，返回false；否则返回true
     */
    public Boolean verify(UserFindByWorkSpaceIdStandard userFindByWorkSpaceIdStandard) {
        return !verifyIntegrity.verify(userFindByWorkSpaceIdStandard.getWorkSpaceId());
    }

    /**
     * 根据工区编号查找用户业务对象中的工区完整性校验
     *
     * @param workSpace 根据工区编号查找用户业务对象中的工区
     * @return 工区编号为空或为Null，返回false；否则返回true
     */
    public Boolean verifyFindByWorkSpaceIdWorkSpace(Workspace workSpace) {
        return !verifyIntegrity.verify(workSpace.getWorkSpaceId());
    }

    /**
     * 根据工区编号查找用户业务对象中的用户完整性校验
     *
     * @param user 根据工区编号查找用户业务对象中的用户
     * @return 用户手机号、用户姓名、用户组织编号、用户工区编号中有为空或为Null，返回false，备注、邮箱为Null，返回false；否则返回true
     */
    public Boolean verifyFindByWorkSpaceIdUser(User user) {
        return !verifyIntegrity.verify(user.getUserMobile()) && !verifyIntegrity.verify(user.getUserName()) &&
                user.getUserEmail() != null && !verifyIntegrity.verify(user.getUserOrganizationId()) &&
                !verifyIntegrity.verify(user.getUserWorkSpaceId()) && user.getUserRemark() != null;
    }

    /**
     * 调动工区内用户入参完整性校验
     *
     * @param userTransferStandard 调动工区内用户入参对象
     * @return 用户手机号、工区编号中有为空或为Null，返回false，是否调入为Null，返回false；否则返回true
     */
    public Boolean verify(UserTransferStandard userTransferStandard) {
        return !verifyIntegrity.verify(userTransferStandard.getUserMobile()) && !verifyIntegrity.verify(userTransferStandard.getWorkSpaceId()) &&
                userTransferStandard.getWorkSpaceAdd() != null;
    }

    /**
     * 调动工区内用户业务对象中的工区完整性校验
     *
     * @param workSpace 动工区内用户业务对象中的工区
     * @return 工区编号为空或为Null，返回false，工区人数为Null，返回false；否则返回true
     */
    public Boolean verifyTransferWorkSpace(Workspace workSpace) {
        return !verifyIntegrity.verify(workSpace.getWorkSpaceId()) && workSpace.getWorkSpacePeopleNumber() != null;
    }

    /**
     * 调动工区内用户业务对象中的用户完整性校验
     *
     * @param user 调动工区内用户业务对象中的用户
     * @return 用户手机号为空或为Null，返回false，用户工区编号为Null，返回false；否则返回true
     */
    public Boolean verifyTransferUser(User user) {
        return !verifyIntegrity.verify(user.getUserMobile()) && user.getUserWorkSpaceId() != null;
    }

    /**
     * 删除工区入参完整性校验
     *
     * @param workSpaceDeleteStandard 删除工区入参对象
     * @return 工区编号为空或为Null，返回false；否则返回true
     */
    public Boolean verify(WorkSpaceDeleteStandard workSpaceDeleteStandard) {
        return !verifyIntegrity.verify(workSpaceDeleteStandard.getWorkSpaceId());
    }

    /**
     * 删除工区业务对象完整性校验
     *
     * @param workSpace 删除工区业务对象
     * @param type      可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 工区编号为空或为Null，返回false，工区是否被删除为Null，返回false；否则返回true
     */
    public Boolean verifyDelete(Workspace workSpace, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceId());
            case 2:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceId()) && workSpace.getWorkSpaceDeleted() != null;
            default:
                System.out.println("删除工区接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 根据父组织编号查找工区入参完整性校验
     *
     * @param workSpaceFindByParentIdStandard 根据父组织编号查找工区入参对象
     * @return 父组织编号为空或为Null，返回false；否则返回true
     */
    public Boolean verify(WorkSpaceFindByParentIdStandard workSpaceFindByParentIdStandard) {
        return !verifyIntegrity.verify(workSpaceFindByParentIdStandard.getWorkSpaceParentId());
    }

    /**
     * 根据父组织编号查找工区业务对象完整性校验
     *
     * @param workSpace 根据父组织编号查找工区业务对象
     * @param type      可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 工区编号、工区名称、父组织编号、工区联系电话、工区地址中有为空或为Null，返回false，备注、工区人数为Null，返回false；否则返回true
     */
    public Boolean verifyFindByParentId(Workspace workSpace, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceParentId());
            case 2:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceId()) && workSpace.getWorkSpacePeopleNumber() != null &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceName()) && !verifyIntegrity.verify(workSpace.getWorkSpaceContact()) &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceAddress()) && !verifyIntegrity.verify(workSpace.getWorkSpaceParentId()) &&
                        workSpace.getWorkSpaceRemark() != null;
            default:
                System.out.println("根据父组织编号查找工区接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 根据组织编号查找工区入参完整性校验
     *
     * @param workSpaceFindByIdStandard 根据组织编号查找工区入参对象
     * @return 工区编号、父组织编号中有为空或为Null，返回false；否则返回true
     */
    public Boolean verify(WorkSpaceFindByIdStandard workSpaceFindByIdStandard) {
        return !verifyIntegrity.verify(workSpaceFindByIdStandard.getWorkSpaceId()) && !verifyIntegrity.verify(workSpaceFindByIdStandard.getWorkSpaceParentId());
    }

    /**
     * 根据组织编号查找工区业务对象完整性校验
     *
     * @param workSpace 根据组织编号查找工区业务对象
     * @param type      可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 工区编号、工区名称、父组织编号、工区联系电话、工区地址中有为空或为Null，返回false，备注、工区人数为Null，返回false；否则返回true
     */
    public Boolean verifyFindById(Workspace workSpace, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceId()) && !verifyIntegrity.verify(workSpace.getWorkSpaceParentId());
            case 2:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceId()) && workSpace.getWorkSpacePeopleNumber() != null &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceName()) && !verifyIntegrity.verify(workSpace.getWorkSpaceContact()) &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceAddress()) && !verifyIntegrity.verify(workSpace.getWorkSpaceParentId()) &&
                        workSpace.getWorkSpaceRemark() != null;
            default:
                System.out.println("根据工区编号查找工区接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 根据名称查找工区入参完整性校验
     *
     * @param workSpaceFindByNameStandard 根据名称查找工区入参对象
     * @return 工区名称、父组织编号中有为空或为Null，返回false；否则返回true
     */
    public Boolean verify(WorkSpaceFindByNameStandard workSpaceFindByNameStandard) {
        return !verifyIntegrity.verify(workSpaceFindByNameStandard.getWorkSpaceName()) && !verifyIntegrity.verify(workSpaceFindByNameStandard.getWorkSpaceParentId());
    }

    /**
     * 根据名称查找工区业务对象完整性校验
     *
     * @param workSpace 根据名称查找工区业务对象
     * @param type      可选类型：1是校验入参转换成的业务对象；2是校验转成出参的业务对象
     * @return 工区编号、工区名称、父组织编号、工区联系电话、工区地址中有为空或为Null，返回false，备注、工区人数为Null，返回false；否则返回true
     */
    public Boolean verifyFindByName(Workspace workSpace, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceName()) && !verifyIntegrity.verify(workSpace.getWorkSpaceParentId());
            case 2:
                return !verifyIntegrity.verify(workSpace.getWorkSpaceId()) && workSpace.getWorkSpacePeopleNumber() != null &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceName()) && !verifyIntegrity.verify(workSpace.getWorkSpaceContact()) &&
                        !verifyIntegrity.verify(workSpace.getWorkSpaceAddress()) && !verifyIntegrity.verify(workSpace.getWorkSpaceParentId()) &&
                        workSpace.getWorkSpaceRemark() != null;
            default:
                System.out.println("根据名称查找工区接口 - 业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }
}
