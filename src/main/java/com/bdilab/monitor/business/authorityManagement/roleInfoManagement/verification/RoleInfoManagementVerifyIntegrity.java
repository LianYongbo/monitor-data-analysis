package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.verification;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Menu;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.*;
import com.bdilab.monitor.util.VerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 权限管理模块
 * 角色信息管理子模块
 * 验证参数完整性
 *
 * @author Lian
 * @date 2021/2/20 23:53
 **/
@Component
public class RoleInfoManagementVerifyIntegrity {
    private final VerifyIntegrity verifyIntegrity;

    public RoleInfoManagementVerifyIntegrity(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    /**
     * 创建角色入参完整性校验
     *
     * @param roleCreateStandard 创建角色入参对象
     * @return 角色英文名称、角色中文名称中有为空或Null，返回false，备注为Null，返回false，包含的路由入参对象校验不通过，返回false；否则返回true
     */
    public Boolean verify(RoleCreateStandard roleCreateStandard) {
        if (roleCreateStandard.getRoleRouting() == null) {
            return false;
        }
        for (RoleRoutingStandard roleRoutingStandard : roleCreateStandard.getRoleRouting()) {
            if (!verify(roleRoutingStandard)) {
                return false;
            }
        }
        return !verifyIntegrity.verify(roleCreateStandard.getRoleName()) && !verifyIntegrity.verify(roleCreateStandard.getRoleNameZh()) &&
                roleCreateStandard.getRoleRemark() != null;
    }

    /**
     * 角色业务对象完整性校验
     *
     * @param role 角色业务对象
     * @return 角色编号、角色英文名称、角色中文名称中有为空或Null，返回false，备注为Null，返回false；否则返回true
     */
    public Boolean verify(Role role) {
        return !verifyIntegrity.verify(role.getRoleId()) && !verifyIntegrity.verify(role.getRoleName()) &&
                !verifyIntegrity.verify(role.getRoleNameZh()) && role.getRoleRemark() != null;
    }

    /**
     * 菜单业务对象完整性校验
     *
     * @param menu 菜单业务对象
     * @param type 1：路由；2：按钮
     * @return 1：菜单编号、路由模块名称、路由地址中有为空或Null，返回false，备注为Null，返回false；否则返回true；2：菜单编号、按钮名称、按钮地址、按钮对应接口url、父菜单编号中有为空或Null，返回false，备注为Null，返回false；否则返回true
     */
    public Boolean verify(Menu menu, int type) {
        switch (type) {
            case 1:
                return !verifyIntegrity.verify(menu.getMenuId()) && !verifyIntegrity.verify(menu.getMenuTitle()) &&
                        !verifyIntegrity.verify(menu.getMenuKey()) && menu.getMenuRemark() != null;
            case 2:
                return !verifyIntegrity.verify(menu.getMenuId()) && !verifyIntegrity.verify(menu.getMenuLabel()) &&
                        !verifyIntegrity.verify(menu.getMenuValue()) && !verifyIntegrity.verify(menu.getMenuParentId()) &&
                        !verifyIntegrity.verify(menu.getMenuPattern()) && menu.getMenuRemark() != null;
            default:
                System.out.println("菜单业务对象 - 菜单业务对象完整性校验 - " + new Date() + " - 类型错误！");
                return false;
        }
    }

    /**
     * 修改角色信息入参完整性校验
     *
     * @param roleUpdateStandard 修改角色信息入参对象
     * @return 角色编号、角色英文名称、角色中文名称中有为空或Null，返回false，备注为Null，返回false，包含的路由入参对象校验不通过，返回false；否则返回true
     */
    public Boolean verify(RoleUpdateStandard roleUpdateStandard) {
        if (roleUpdateStandard.getRoleRouting() == null) {
            return false;
        }
        for (RoleRoutingStandard roleRoutingStandard : roleUpdateStandard.getRoleRouting()) {
            if (!verify(roleRoutingStandard)) {
                return false;
            }
        }
        return !verifyIntegrity.verify(roleUpdateStandard.getRoleName()) && !verifyIntegrity.verify(roleUpdateStandard.getRoleNameZh()) &&
                !verifyIntegrity.verify(roleUpdateStandard.getRoleId()) && roleUpdateStandard.getRoleRemark() != null;
    }

    /**
     * 删除角色入参完整性校验
     *
     * @param roleDeleteStandard 删除角色入参对象
     * @return 角色编号为空或Null，返回false；否则返回true
     */
    public Boolean verify(RoleDeleteStandard roleDeleteStandard) {
        return !verifyIntegrity.verify(roleDeleteStandard.getRoleId());
    }

    /**
     * 删除角色业务对象完整性校验
     *
     * @param role 删除角色业务对象
     * @return 角色编号为空或Null，返回false；否则返回true
     */
    public Boolean verifyDelete(Role role) {
        return !verifyIntegrity.verify(role.getRoleId());
    }

    /**
     * 根据中文名称查找角色
     *
     * @param roleFindByNameZhStandard 根据中文名称查找角色入参对象
     * @return 角色中文名称为空或Null，返回false；否则返回true
     */
    public Boolean verify(RoleFindByNameZhStandard roleFindByNameZhStandard) {
        return !verifyIntegrity.verify(roleFindByNameZhStandard.getRoleNameZh());
    }

    /**
     * 路由入参完整性校验
     *
     * @param roleRoutingStandard 路由入参
     * @return 路由编号为空或Null，返回false，包含的按钮对象校验不通过，返回false；否则返回true
     */
    private Boolean verify(RoleRoutingStandard roleRoutingStandard) {
        if (roleRoutingStandard.getRoutingButton() == null) {
            return false;
        }
        for (RoleButtonStandard roleButtonStandard : roleRoutingStandard.getRoutingButton()) {
            if (!verify(roleButtonStandard)) {
                return false;
            }
        }
        return !verifyIntegrity.verify(roleRoutingStandard.getRoutingId());
    }

    /**
     * 按钮入参完整性校验
     *
     * @param roleButtonStandard 按钮入参
     * @return 按钮编号为空或Null，返回false；否则返回true
     */
    private Boolean verify(RoleButtonStandard roleButtonStandard) {
        return !verifyIntegrity.verify(roleButtonStandard.getButtonId());
    }
}
