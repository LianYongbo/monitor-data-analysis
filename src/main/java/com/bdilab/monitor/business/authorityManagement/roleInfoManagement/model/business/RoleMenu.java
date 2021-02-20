package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business;

import io.swagger.annotations.ApiModelProperty;

public class RoleMenu {
    @ApiModelProperty(value="id",required = true)
    private String id;
    @ApiModelProperty(value="角色编号",required = true)
    private String fkRoleId;
    @ApiModelProperty(value="菜单编号",required = true)
    private String fkMenuId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkRoleId() {
        return fkRoleId;
    }

    public void setFkRoleId(String fkRoleId) {
        this.fkRoleId = fkRoleId;
    }

    public String getFkMenuId() {
        return fkMenuId;
    }

    public void setFkMenuId(String fkMenuId) {
        this.fkMenuId = fkMenuId;
    }
}