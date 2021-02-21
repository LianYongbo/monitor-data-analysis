package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 创建角色出参对象中的路由对象
 *
 * @author Lian
 * @date 2021/2/20 23:33
 **/
public class RoleRoutingView {
    @ApiModelProperty(value = "路由编号", required = true)
    private String routingId;
    @ApiModelProperty(value = "路由模块名称", required = true)
    private String routingTitle;
    @ApiModelProperty(value = "路由地址", required = true)
    private String routingKey;
    @ApiModelProperty(value = "备注")
    private String routingRemark;
    @ApiModelProperty(value = "路由包含按钮", required = true)
    private List<RoleButtonView> routingButton;

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

    public String getRoutingRemark() {
        return routingRemark;
    }

    public void setRoutingRemark(String routingRemark) {
        this.routingRemark = routingRemark;
    }

    public List<RoleButtonView> getRoutingButton() {
        return routingButton;
    }

    public void setRoutingButton(List<RoleButtonView> routingButton) {
        this.routingButton = routingButton;
    }
}
