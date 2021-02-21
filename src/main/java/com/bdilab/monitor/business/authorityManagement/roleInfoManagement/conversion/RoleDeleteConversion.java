package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.conversion;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleDeleteStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view.RoleDeleteView;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.verification.RoleInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 删除角色数据结构转换
 *
 * @author Lian
 * @date 2021/2/21 2:14
 **/
@Component
public class RoleDeleteConversion {
    private final RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity;

    public RoleDeleteConversion(RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity) {
        this.roleInfoManagementVerifyIntegrity = roleInfoManagementVerifyIntegrity;
    }

    /**
     * 删除角色接口入参转换为业务对象
     *
     * @param roleDeleteStandard 删除角色入参
     * @return 转换后的业务对象
     */
    public Role conversion(RoleDeleteStandard roleDeleteStandard) {
        if (!roleInfoManagementVerifyIntegrity.verify(roleDeleteStandard)) {
            System.out.println("删除角色接口 - 删除角色业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Role role = new Role();
        role.setRoleId(roleDeleteStandard.getRoleId());
        return role;
    }

    /**
     * 删除角色接口业务对象转换为入参
     *
     * @param role 删除角色业务对象
     * @return 转换后的出参
     */
    public RoleDeleteView conversion(Role role) {
        RoleDeleteView roleDeleteView = new RoleDeleteView();
        if (role == null) {
            roleDeleteView.setRoleDeleted(true);
        } else {
            roleDeleteView.setRoleDeleted(false);
        }
        return roleDeleteView;
    }
}
