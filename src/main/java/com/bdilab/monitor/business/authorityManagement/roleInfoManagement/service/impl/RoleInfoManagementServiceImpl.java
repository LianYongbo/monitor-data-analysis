package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.service.impl;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Menu;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.service.RoleInfoManagementService;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.verification.RoleInfoManagementVerifyIntegrity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 权限管理模块
 * 角色信息管理子模块服务接口实现
 *
 * @author Lian
 * @date 2021/2/18 14:44
 **/
@Service
public class RoleInfoManagementServiceImpl implements RoleInfoManagementService {
    private final
    RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity;

    public RoleInfoManagementServiceImpl(RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity) {
        this.roleInfoManagementVerifyIntegrity = roleInfoManagementVerifyIntegrity;
    }

    @Override
    public Role roleCreate(Role role, List<Menu> menus) {
        return role;
    }

    @Override
    public Role roleUpdate(Role role, List<Menu> menus) {
        return role;
    }

    @Override
    public Role roleDelete(Role role) {
        if (!roleInfoManagementVerifyIntegrity.verifyDelete(role)) {
            System.out.println("删除角色接口 - 删除角色服务 - " + new Date() + " - 业务对象有误！");
            return role;
        }
        role = null;
        return role;
    }

    @Override
    public List<Role> roleFindAll() {
        List<Role> roles = new ArrayList<>();
        Role role = new Role();
        role.setRoleId("1");
        role.setRoleName("ROLE_user");
        role.setRoleNameZh("普通用户");
        role.setRoleRemark("无");
        Role role1 = new Role();
        role1.setRoleId("2");
        role1.setRoleName("ROLE_admin");
        role1.setRoleNameZh("管理员");
        role1.setRoleRemark("无");
        roles.add(role);
        roles.add(role1);
        return roles;
    }

    @Override
    public List<Role> roleFindByNameZh(Role role) {
        List<Role> roles = new ArrayList<>();
        Role role1 = new Role();
        role1.setRoleId("1");
        role1.setRoleName("ROLE_user");
        role1.setRoleNameZh(role.getRoleNameZh());
        role1.setRoleRemark("无");
        Role role2 = new Role();
        role2.setRoleId("2");
        role2.setRoleName("ROLE_admin");
        role2.setRoleNameZh(role.getRoleNameZh());
        role2.setRoleRemark("无");
        roles.add(role1);
        roles.add(role2);
        return roles;
    }

    @Override
    public List<Menu> routingFindByRoleId(Role role) {
        List<Menu> menus = new ArrayList<>();
        Menu menu = new Menu();
        menu.setMenuId("1");
        menu.setMenuTitle("用户路由");
        menu.setMenuKey("user-routing");
        menu.setMenuRemark("无");
        Menu menu1 = new Menu();
        menu1.setMenuId("2");
        menu1.setMenuTitle("权限路由");
        menu1.setMenuKey("authority-routing");
        menu1.setMenuRemark("无");
        menus.add(menu);
        menus.add(menu1);
        return menus;
    }

    @Override
    public List<Menu> buttonFindByRoleId(Role role) {
        List<Menu> menus = new ArrayList<>();
        Menu menu = new Menu();
        menu.setMenuId("1");
        menu.setMenuLabel("按钮A");
        menu.setMenuValue("user/**");
        menu.setMenuPattern("/user/**/**");
        menu.setMenuParentId("1");
        menu.setMenuRemark("无");
        Menu menu1 = new Menu();
        menu1.setMenuId("2");
        menu1.setMenuLabel("按钮B");
        menu1.setMenuValue("authority/**");
        menu1.setMenuPattern("/authority/**/**");
        menu1.setMenuParentId("2");
        menu1.setMenuRemark("无");
        menus.add(menu);
        menus.add(menu1);
        return menus;
    }
}