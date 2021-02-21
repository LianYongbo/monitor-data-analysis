package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.service;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Menu;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;

import java.util.List;

/**
 * 权限管理模块
 * 角色信息管理子模块服务接口
 *
 * @author Lian
 * @date 2021/2/18 14:11
 **/
public interface RoleInfoManagementService {
    /**
     * 创建角色
     *
     * @param role  包含角色基本信息的角色业务对象
     * @param menus 角色包含的菜单（路由和按钮）集合
     * @return 用来展示
     */
    Role roleCreate(Role role, List<Menu> menus);

    /**
     * 修改角色信息
     *
     * @param role  包含角色基本信息的角色业务对象
     * @param menus 角色包含的菜单（路由和按钮）集合
     * @return 用来展示
     */
    Role roleUpdate(Role role, List<Menu> menus);

    /**
     * 删除角色
     *
     * @param role 包含角色编号的角色业务对象
     * @return 用来判断是否删除成功
     */
    Role roleDelete(Role role);

    /**
     * 获取所有的角色信息
     *
     * @return 可用的角色集合
     */
    List<Role> roleFindAll();

    /**
     * 根据中文名称查找角色
     *
     * @param role 包含角色中文名称的角色业务对象
     * @return 符合该中文名称的可用的角色集合
     */
    List<Role> roleFindByNameZh(Role role);

    /**
     * 根据角色编号查找包含的菜单，筛选出路由
     *
     * @param role 包含角色编号的角色业务对象
     * @return 该角色对应的路由集合
     */
    List<Menu> routingFindByRoleId(Role role);

    /**
     * 根据角色编号查找包含的菜单，筛选出按钮
     *
     * @param role 包含角色编号的角色业务对象
     * @return 该角色对应的按钮集合
     */
    List<Menu> buttonFindByRoleId(Role role);
}
