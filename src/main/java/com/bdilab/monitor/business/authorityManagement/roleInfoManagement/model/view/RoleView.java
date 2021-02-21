package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 创建角色出参对象
 *
 * @author Lian
 * @date 2021/2/20 23:29
 **/
public class RoleView {
    @ApiModelProperty(value = "角色编号", required = true)
    private String roleId;
    @ApiModelProperty(value = "角色英文名称", required = true)
    private String roleName;
    @ApiModelProperty(value = "角色中文名称", required = true)
    private String roleNameZh;
    @ApiModelProperty(value = "备注")
    private String roleRemark;
    @ApiModelProperty(value = "角色包含路由", required = true)
    private List<RoleRoutingView> roleRouting;

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

    public List<RoleRoutingView> getRoleRouting() {
        return roleRouting;
    }

    public void setRoleRouting(List<RoleRoutingView> roleRouting) {
        this.roleRouting = roleRouting;
    }
}
