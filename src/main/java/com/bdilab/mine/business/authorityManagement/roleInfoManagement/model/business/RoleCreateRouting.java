package com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.business;

import com.bdilab.mine.util.VerifyIntegrity;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 创建角色业务对象中的路由对象
 *
 * @author Lian
 * @date 2021/2/18 12:28
 **/
public class RoleCreateRouting {
    private VerifyIntegrity verifyIntegrity;

    public RoleCreateRouting(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    @ApiModelProperty(value = "路由编号", required = true)
    private String routingId;
    @ApiModelProperty(value = "路由模块名称", required = true)
    private String routingTitle;
    @ApiModelProperty(value = "路由地址", required = true)
    private String routingKey;
    @ApiModelProperty(value = "路由包含按钮", required = true)
    private List<RoleCreateButton> routingButton;

    public RoleCreateRouting() {

    }

    /**
     * 校验路由编号、路由模块名称、路由地址、路由包含按钮的完整性
     *
     * @return 三个属性中有为空或为Null，返回false,路由包含按钮中的按钮存在未通过验证的，也返回false；否则返回true
     */
    public Boolean verify() {
        for (RoleCreateButton roleCreateButton : this.routingButton) {
            if (!roleCreateButton.verify()) {
                return false;
            }
        }
        return !verifyIntegrity.verify(this.routingId) && !verifyIntegrity.verify(routingTitle) && !verifyIntegrity.verify(this.routingKey);
    }

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public String getRoutingTitle() {
        return routingTitle;
    }

    public void setRoutingTitle(String routingTitle) {
        this.routingTitle = routingTitle;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public List<RoleCreateButton> getRoutingButton() {
        return routingButton;
    }

    public void setRoutingButton(List<RoleCreateButton> routingButton) {
        this.routingButton = routingButton;
    }
}
