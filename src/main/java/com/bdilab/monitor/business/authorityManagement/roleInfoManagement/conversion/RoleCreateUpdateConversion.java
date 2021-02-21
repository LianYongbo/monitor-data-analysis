package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.conversion;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Menu;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleButtonStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleRoutingStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleCreateStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleUpdateStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view.RoleButtonView;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.verification.RoleInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 创建角色接口数据结构转换
 *
 * @author Lian
 * @date 2021/2/18 13:00
 **/
@Component
public class RoleCreateUpdateConversion {
    private final RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity;

    public RoleCreateUpdateConversion(RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity) {
        this.roleInfoManagementVerifyIntegrity = roleInfoManagementVerifyIntegrity;
    }

    /**
     * 创建角色入参转换为业务对象
     *
     * @param roleCreateStandard 创建角色入参
     * @return 转换后的角色业务对象
     */
    public Role conversionToRole(RoleCreateStandard roleCreateStandard) {
        if (!roleInfoManagementVerifyIntegrity.verify(roleCreateStandard)) {
            System.out.println("创建角色接口 - 入参转换角色业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Role role = new Role();
        role.setRoleId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        role.setRoleName(roleCreateStandard.getRoleName());
        role.setRoleNameZh(roleCreateStandard.getRoleNameZh());
        role.setRoleRemark(roleCreateStandard.getRoleRemark());
        return role;
    }

    /**
     * 修改角色信息入参转换为业务对象
     *
     * @param roleUpdateStandard 修改角色信息入参
     * @return 转换后的角色业务对象
     */
    public Role conversionToRole(RoleUpdateStandard roleUpdateStandard) {
        if (!roleInfoManagementVerifyIntegrity.verify(roleUpdateStandard)) {
            System.out.println("修改角色信息接口 - 入参转换角色业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Role role = new Role();
        role.setRoleId(roleUpdateStandard.getRoleId());
        role.setRoleName(roleUpdateStandard.getRoleName());
        role.setRoleNameZh(roleUpdateStandard.getRoleNameZh());
        role.setRoleRemark(roleUpdateStandard.getRoleRemark());
        return role;
    }


    /**
     * 创建角色入参中的路由转换为业务对象
     *
     * @param roleCreateStandard 创建角色入参
     * @return 转换后的菜单（路由、按钮）集合
     */
    public List<Menu> conversionToMenu(RoleCreateStandard roleCreateStandard) {
        if (!roleInfoManagementVerifyIntegrity.verify(roleCreateStandard)) {
            System.out.println("创建角色接口 - 入参转换菜单业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        List<Menu> menus = new ArrayList<>();
        for (RoleRoutingStandard roleRoutingStandard : roleCreateStandard.getRoleRouting()) {
            menus.add(conversion(roleRoutingStandard));
            for (RoleButtonStandard roleButtonStandard : roleRoutingStandard.getRoutingButton()) {
                menus.add(conversion(roleButtonStandard));
            }
        }
        return menus;
    }

    /**
     * 修改角色信息入参中的路由转换为业务对象
     *
     * @param roleUpdateStandard 创建角色入参
     * @return 转换后的菜单（路由、按钮）集合
     */
    public List<Menu> conversionToMenu(RoleUpdateStandard roleUpdateStandard) {
        if (!roleInfoManagementVerifyIntegrity.verify(roleUpdateStandard)) {
            System.out.println("修改角色信息接口 - 入参转换菜单业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        List<Menu> menus = new ArrayList<>();
        for (RoleRoutingStandard roleRoutingStandard : roleUpdateStandard.getRoleRouting()) {
            menus.add(conversion(roleRoutingStandard));
            for (RoleButtonStandard roleButtonStandard : roleRoutingStandard.getRoutingButton()) {
                menus.add(conversion(roleButtonStandard));
            }
        }
        return menus;
    }

    /**
     * 修改角色信息、创建对象入参中的路由转换为业务对象
     *
     * @param roleRoutingStandard 创建对象入参中的路由
     * @return 转换后的菜单（路由）
     */
    private Menu conversion(RoleRoutingStandard roleRoutingStandard) {
        Menu menu = new Menu();
        menu.setMenuId(roleRoutingStandard.getRoutingId());
        return menu;
    }

    /**
     * 修改角色信息、创建对象入参中的按钮转换为业务对象
     *
     * @param roleButtonStandard 创建对象入参中的按钮
     * @return 转换后的菜单（按钮）
     */
    private Menu conversion(RoleButtonStandard roleButtonStandard) {
        Menu menu = new Menu();
        menu.setMenuId(roleButtonStandard.getButtonId());
        return menu;
    }
}
