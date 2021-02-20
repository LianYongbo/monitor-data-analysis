package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business;

import io.swagger.annotations.ApiModelProperty;


public class UserRole{
    @ApiModelProperty(value="id",required = true)
    private String id;
    @ApiModelProperty(value="用户手机号",required = true)
    private String fkUserMobile;
    @ApiModelProperty(value="角色编号",required = true)
    private String fkRoleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkUserMobile() {
        return fkUserMobile;
    }

    public void setFkUserMobile(String fkUserMobile) {
        this.fkUserMobile = fkUserMobile;
    }

    public String getFkRoleId() {
        return fkRoleId;
    }

    public void setFkRoleId(String fkRoleId) {
        this.fkRoleId = fkRoleId;
    }
}