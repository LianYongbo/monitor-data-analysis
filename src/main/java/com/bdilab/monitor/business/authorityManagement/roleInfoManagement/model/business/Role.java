package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business;

import com.bdilab.monitor.util.VerifyIntegrity;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 角色业务对象
 *
 * @author Lian
 * @date 2021/2/18 12:23
 **/
public class Role {
    private VerifyIntegrity verifyIntegrity;

    public Role(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    @ApiModelProperty(value = "角色编号", required = true)
    private String roleId;
    @ApiModelProperty(value = "角色英文名称", required = true)
    private String roleName;
    @ApiModelProperty(value = "角色中文名称", required = true)
    private String roleNameZh;
    @ApiModelProperty(value = "备注")
    private String roleRemark;
    @ApiModelProperty(value = "角色包含路由", required = true)
    private List<RoleCreateRouting> roleRouting;

    public Role() {
    }

    /**
     * 校验角色编号、角色英文名称、中文名称、角色包含路由的完整性
     *
     * @return 三个属性中有为空或为Null，返回false，角色包含路由中的路由存在未通过验证的，也返回false；否则返回true
     */
    public Boolean verify() {
        for (RoleCreateRouting roleCreateRouting : this.roleRouting) {
            if (roleCreateRouting.verify()) {
                return false;
            }
        }
        return !verifyIntegrity.verify(this.roleId) && !verifyIntegrity.verify(this.roleName) && !verifyIntegrity.verify(this.roleNameZh);
    }

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

    public List<RoleCreateRouting> getRoleRouting() {
        return roleRouting;
    }

    public void setRoleRouting(List<RoleCreateRouting> roleRouting) {
        this.roleRouting = roleRouting;
    }
}
