package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.conversion;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Menu;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view.RoleButtonView;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view.RoleRoutingView;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view.RoleView;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.verification.RoleInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Role、Menu转换为RoleView
 *
 * @author Lian
 * @date 2021/2/21 1:03
 **/
@Component
public class RoleViewConversion {
    private final RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity;

    public RoleViewConversion(RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity) {
        this.roleInfoManagementVerifyIntegrity = roleInfoManagementVerifyIntegrity;
    }

    /**
     * 角色、菜单业务对象转换为出参
     *
     * @param role     角色业务对象
     * @param routings 菜单（路由）业务对象集合
     * @param buttons  菜单（按钮）业务对象集合
     * @return 转换后的出参
     */
    public RoleView conversion(Role role, List<Menu> routings, List<Menu> buttons) {
        if (!roleInfoManagementVerifyIntegrity.verify(role)) {
            System.out.println("角色、菜单业务对象 - 角色、菜单业务对象转换出参 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        RoleView roleView = new RoleView();
        roleView.setRoleId(role.getRoleId());
        roleView.setRoleName(role.getRoleName());
        roleView.setRoleNameZh(role.getRoleNameZh());
        roleView.setRoleRemark(role.getRoleRemark());
        if (routings == null) {
            System.out.println("角色、菜单业务对象 - 角色、菜单业务对象转换出参 - " + new Date() + " - 路由业务对象集合有误！");
            return null;
        }
        List<RoleRoutingView> roleRoutingViews = new ArrayList<>();
        for (Menu menu : routings) {
            if (menu == null) {
                System.out.println("角色、菜单业务对象 - 角色、菜单业务对象转换出参 - " + new Date() + " - 路由业务对象有误！A");
                return null;
            }
            RoleRoutingView roleRoutingView = conversion(menu, buttons);
            if (roleRoutingView == null) {
                System.out.println("角色、菜单业务对象 - 角色、菜单业务对象转换出参 - " + new Date() + " - 路由业务对象有误！B");
                return null;
            }
            boolean flag = false;
            for (RoleRoutingView roleRoutingView1 : roleRoutingViews) {
                if (roleRoutingView1.getRoutingId().equals(roleRoutingView.getRoutingId())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                roleRoutingViews.add(roleRoutingView);
            }
        }
        roleView.setRoleRouting(roleRoutingViews);
        return roleView;
    }

    /**
     * 菜单业务对象转换为路由出参
     *
     * @param routing 菜单（路由）业务对象
     * @param buttons 菜单（按钮）业务对象集合
     * @return 转换后的出参
     */
    private RoleRoutingView conversion(Menu routing, List<Menu> buttons) {
        RoleRoutingView roleRoutingView = new RoleRoutingView();
        roleRoutingView.setRoutingId(routing.getMenuId());
        roleRoutingView.setRoutingTitle(routing.getMenuTitle());
        roleRoutingView.setRoutingKey(routing.getMenuKey());
        roleRoutingView.setRoutingRemark(routing.getMenuRemark());
        if (buttons == null) {
            System.out.println("角色、菜单业务对象 - 角色、菜单业务对象转换出参 - " + new Date() + " - 按钮业务对象集合有误！");
            return null;
        }
        List<RoleButtonView> roleButtonViews = new ArrayList<>();
        for (Menu menu : buttons) {
            if (menu == null) {
                System.out.println("角色、菜单业务对象 - 角色、菜单业务对象转换出参 - " + new Date() + " - 按钮业务对象有误！A");
                return null;
            }
            RoleButtonView roleButtonView = conversion(menu);
            if (roleButtonView == null) {
                System.out.println("角色、菜单业务对象 - 角色、菜单业务对象转换出参 - " + new Date() + " - 按钮业务对象有误！B");
                return null;
            }
            if (routing.getMenuId().equals(menu.getMenuParentId())) {
                boolean flag = false;
                for (RoleButtonView roleButtonView1 : roleButtonViews) {
                    if (roleButtonView1.getButtonId().equals(roleButtonView.getButtonId())) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    roleButtonViews.add(roleButtonView);
                }
            }
        }
        roleRoutingView.setRoutingButton(roleButtonViews);
        return roleRoutingView;
    }

    /**
     * 菜单业务对象转换为按钮出参
     *
     * @param button 菜单（按钮）业务对象
     * @return 转换后的出参
     */
    private RoleButtonView conversion(Menu button) {
        int type = 2;
        if (!roleInfoManagementVerifyIntegrity.verify(button, type)) {
            System.out.println("角色、菜单业务对象 - 角色、菜单业务对象转换出参 - " + new Date() + " - 按钮业务对象有误！");
            return null;
        }
        RoleButtonView roleButtonView = new RoleButtonView();
        roleButtonView.setButtonId(button.getMenuId());
        roleButtonView.setButtonLabel(button.getMenuLabel());
        roleButtonView.setButtonValue(button.getMenuValue());
        roleButtonView.setButtonPattern(button.getMenuPattern());
        roleButtonView.setButtonRemark(button.getMenuRemark());
        return roleButtonView;
    }
}
