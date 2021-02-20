package com.bdilab.mine.business.authorityManagement.roleInfoManagement.service;

import com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.business.Role;

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
     * @param role 包含角色基本信息的角色业务对象
     */
    void roleCreate(Role role);

    /**
     * 修改角色信息
     *
     * @param role 包含角色基本信息的角色业务对象
     */
    void roleUpdate(Role role);

    /**
     * 删除角色：假删除
     *
     * @param role 包含角色编号的角色业务对象
     */
    void roleDelete(Role role);

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
}
