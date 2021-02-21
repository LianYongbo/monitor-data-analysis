package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business;

import io.swagger.annotations.ApiModelProperty;

/**
 * 角色业务对象
 *
 * @author Lian
 * @date 2021/2/18 12:23
 **/
public class Role {
    @ApiModelProperty(value = "角色编号", required = true)
    private String roleId;
    @ApiModelProperty(value = "角色英文名称", required = true)
    private String roleName;
    @ApiModelProperty(value = "角色中文名称", required = true)
    private String roleNameZh;
    @ApiModelProperty(value = "备注")
    private String roleRemark;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNameZh() {
        return roleNameZh;
    }

    public void setRoleNameZh(String roleNameZh) {
        this.roleNameZh = roleNameZh;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }
}
