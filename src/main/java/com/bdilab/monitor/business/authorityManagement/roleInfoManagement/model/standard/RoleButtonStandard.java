package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 创建角色入参对象中的路由对象的按钮对象
 *
 * @author Lian
 * @date 2021/2/16 23:13
 **/
public class RoleButtonStandard {
    @ApiModelProperty(value = "按钮编号", required = true)
    private String buttonId;

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }
}
