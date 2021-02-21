package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据角色中文名称查询入参对象
 *
 * @author Lian
 * @date 2021/2/16 22:15
 **/
public class RoleFindByNameZhStandard {
    @ApiModelProperty(value = "角色中文名称", required = true)
    private String roleNameZh;

    public String getRoleNameZh() {
        return roleNameZh;
    }

    public void setRoleNameZh(String roleNameZh) {
        this.roleNameZh = roleNameZh;
    }
}
