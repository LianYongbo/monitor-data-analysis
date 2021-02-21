package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 创建角色入参对象中的路由对象
 *
 * @author Lian
 * @date 2021/2/16 22:46
 **/
public class RoleRoutingStandard {
    @ApiModelProperty(value = "路由编号", required = true)
    private String routingId;
    @ApiModelProperty(value = "路由包含按钮", required = true)
    private List<RoleButtonStandard> routingButton;

    public String getRoutingId() {
        return routingId;
    }

    public void setRoutingId(String routingId) {
        this.routingId = routingId;
    }

    public List<RoleButtonStandard> getRoutingButton() {
        return routingButton;
    }

    public void setRoutingButton(List<RoleButtonStandard> routingButton) {
        this.routingButton = routingButton;
    }
}
