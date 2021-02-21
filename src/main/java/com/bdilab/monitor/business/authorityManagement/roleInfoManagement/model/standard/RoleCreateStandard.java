package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 创建角色入参对象
 *
 * @author Lian
 * @date 2021/2/16 22:02
 **/
public class RoleCreateStandard {
    @ApiModelProperty(value = "角色英文名称", required = true)
    private String roleName;
    @ApiModelProperty(value = "角色中文名称", required = true)
    private String roleNameZh;
    @ApiModelProperty(value = "备注")
    private String roleRemark;
    @ApiModelProperty(value = "角色包含路由", required = true)
    private List<RoleRoutingStandard> roleRouting;

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

    public List<RoleRoutingStandard> getRoleRouting() {
        return roleRouting;
    }

    public void setRoleRouting(List<RoleRoutingStandard> roleRouting) {
        this.roleRouting = roleRouting;
    }
}
