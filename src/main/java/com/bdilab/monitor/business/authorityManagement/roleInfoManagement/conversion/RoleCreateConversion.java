package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.conversion;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.RoleCreateButton;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.RoleCreateRouting;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleCreateButtonStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleCreateRoutingStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleCreateStandard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 创建角色接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/18 13:00
 **/
@Component
public class RoleCreateConversion {
    /**
     * 创建角色入参转换为业务对象
     *
     * @param roleCreateStandard 创建角色入参
     * @return 转换后的业务对象
     */
    public Role conversion(RoleCreateStandard roleCreateStandard) {
        if (!roleCreateStandard.verify()) {
            return null;
        }
        Role role = new Role();
        role.setRoleId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        role.setRoleName(roleCreateStandard.getRoleName());
        role.setRoleNameZh(roleCreateStandard.getRoleNameZh());
        role.setRoleRemark(roleCreateStandard.getRoleRemark());
        List<RoleCreateRouting> roleCreateRoutings = new ArrayList<>();
        for (RoleCreateRoutingStandard roleCreateRoutingStandard : roleCreateStandard.getRoleRouting()) {
            RoleCreateRouting roleCreateRouting = conversion(roleCreateRoutingStandard);
            if (roleCreateRouting == null) {
                return null;
            }
            roleCreateRoutings.add(roleCreateRouting);
        }
        role.setRoleRouting(roleCreateRoutings);
        return role;
    }

    /**
     * 创建对象入参中的路由转换为业务对象
     *
     * @param roleCreateRoutingStandard 创建对象入参中的路由
     * @return 转换后的路由
     */
    private RoleCreateRouting conversion(RoleCreateRoutingStandard roleCreateRoutingStandard) {
        if (!roleCreateRoutingStandard.verify()) {
            return null;
        }
        RoleCreateRouting roleCreateRouting = new RoleCreateRouting();
        roleCreateRouting.setRoutingId(roleCreateRoutingStandard.getRoutingId());
        List<RoleCreateButton> roleCreateButtons = new ArrayList<>();
        for (RoleCreateButtonStandard roleCreateButtonStandard : roleCreateRoutingStandard.getRoutingButton()) {
            RoleCreateButton roleCreateButton = conversion(roleCreateButtonStandard);
            if (roleCreateButton == null) {
                return null;
            }
            roleCreateButtons.add(roleCreateButton);
        }
        roleCreateRouting.setRoutingButton(roleCreateButtons);
        return roleCreateRouting;
    }

    /**
     * 创建对象入参中的按钮转换为业务对象
     *
     * @param roleCreateButtonStandard 创建对象入参中的按钮
     * @return 转换后的按钮
     */
    private RoleCreateButton conversion(RoleCreateButtonStandard roleCreateButtonStandard) {
        if (!roleCreateButtonStandard.verify()) {
            return null;
        }
        RoleCreateButton roleCreateButton = new RoleCreateButton();
        roleCreateButton.setButtonId(roleCreateButtonStandard.getButtonId());
        return roleCreateButton;
    }
}
