package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.conversion;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleFindByNameZhStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.verification.RoleInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 根据角色中文名查找角色数据结构转换
 *
 * @author Lian
 * @date 2021/2/21 2:23
 **/
@Component
public class RoleFindByNameZhConversion {
    private final RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity;

    public RoleFindByNameZhConversion(RoleInfoManagementVerifyIntegrity roleInfoManagementVerifyIntegrity) {
        this.roleInfoManagementVerifyIntegrity = roleInfoManagementVerifyIntegrity;
    }

    /**
     * 根据角色中文名查找角色接口入参转换为业务对象
     *
     * @param roleFindByNameZhStandard 根据角色中文名查找角色入参
     * @return 转换后的业务对象
     */
    public Role conversion(RoleFindByNameZhStandard roleFindByNameZhStandard) {
        if (!roleInfoManagementVerifyIntegrity.verify(roleFindByNameZhStandard)) {
            System.out.println("根据角色中文名查找角色接口 - 入参转换业务对象 - " + new Date() + " - 入参有误！");
            return null;
        }
        Role role = new Role();
        role.setRoleNameZh(roleFindByNameZhStandard.getRoleNameZh());
        return role;
    }
}
