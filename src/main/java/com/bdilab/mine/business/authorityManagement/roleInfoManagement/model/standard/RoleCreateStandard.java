package com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.standard;

import com.bdilab.mine.util.VerifyIntegrity;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 创建角色入参对象
 *
 * @author Lian
 * @date 2021/2/16 22:02
 **/
public class RoleCreateStandard {
    private final VerifyIntegrity verifyIntegrity;

    public RoleCreateStandard(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    @ApiModelProperty(value = "角色英文名称", required = true)
    private String roleName;
    @ApiModelProperty(value = "角色中文名称", required = true)
    private String roleNameZh;
    @ApiModelProperty(value = "备注")
    private String roleRemark;
    @ApiModelProperty(value = "角色包含路由", required = true)
    private List<RoleCreateRoutingStandard> roleRouting;

    /**
     * 校验角色英文名称、中文名称、角色包含路由的完整性
     *
     * @return 角色英文名称、角色中文名称中有为空或为Null，返回false，角色包含路由中的路由存在未通过验证的，返回false，备注为Null，返回false；否则返回true
     */
    public Boolean verify() {
        for (RoleCreateRoutingStandard roleCreateRoutingStandard : this.roleRouting) {
            if (!roleCreateRoutingStandard.verify()) {
                return false;
            }
        }
        return !verifyIntegrity.verify(this.roleName) && !verifyIntegrity.verify(this.roleNameZh) && this.roleRemark != null;
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

    public List<RoleCreateRoutingStandard> getRoleRouting() {
        return roleRouting;
    }

    public void setRoleRouting(List<RoleCreateRoutingStandard> roleRouting) {
        this.roleRouting = roleRouting;
    }
}
