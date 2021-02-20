package com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.standard;

import com.bdilab.mine.util.VerifyIntegrity;
import io.swagger.annotations.ApiModelProperty;

import javax.management.relation.Role;
import java.util.List;

/**
 * 创建角色入参对象中的路由对象
 *
 * @author Lian
 * @date 2021/2/16 22:46
 **/
public class RoleCreateRoutingStandard {
    private final VerifyIntegrity verifyIntegrity;

    public RoleCreateRoutingStandard(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    @ApiModelProperty(value = "路由编号", required = true)
    private String routingId;
    @ApiModelProperty(value = "路由包含按钮", required = true)
    private List<RoleCreateButtonStandard> routingButton;

    /**
     * 校验路由编号、路由包含按钮的完整性
     *
     * @return 属性为空或为Null，返回false,路由包含按钮中的按钮存在未通过验证的，也返回false；否则返回true
     */
    public Boolean verify() {
        for (RoleCreateButtonStandard roleCreateButtonStandard : this.routingButton) {
            if (!roleCreateButtonStandard.verify()) {
                return false;
            }
        }
        return !verifyIntegrity.verify(this.routingId);
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public List<RoleCreateButtonStandard> getRoutingButton() {
        return routingButton;
    }

    public void setRoutingButton(List<RoleCreateButtonStandard> routingButton) {
        this.routingButton = routingButton;
    }
}
