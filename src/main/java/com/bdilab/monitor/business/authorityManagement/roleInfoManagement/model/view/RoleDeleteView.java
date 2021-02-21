package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Lian
 * @date 2021/2/20 23:45
 **/
public class RoleDeleteView {
    @ApiModelProperty(value = "角色是否被删除", required = true)
    private Boolean roleDeleted;

    public Boolean getRoleDeleted() {
        return roleDeleted;
    }

    public void setRoleDeleted(Boolean roleDeleted) {
        this.roleDeleted = roleDeleted;
    }
}
