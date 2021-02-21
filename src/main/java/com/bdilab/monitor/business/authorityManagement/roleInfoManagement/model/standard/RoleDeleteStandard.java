package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 删除角色入参对象
 *
 * @author Lian
 * @date 2021/2/16 22:05
 **/
public class RoleDeleteStandard {
    @ApiModelProperty(value = "角色编号", required = true)
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
