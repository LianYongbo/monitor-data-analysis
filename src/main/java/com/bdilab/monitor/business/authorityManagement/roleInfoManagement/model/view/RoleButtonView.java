package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

/**
 * 创建角色出参对象中的路由对象的按钮对象
 *
 * @author Lian
 * @date 2021/2/20 23:32
 **/
public class RoleButtonView {
    @ApiModelProperty(value = "按钮编号", required = true)
    private String buttonId;
    @ApiModelProperty(value = "按钮名称", required = true)
    private String buttonLabel;
    @ApiModelProperty(value = "按钮地址", required = true)
    private String buttonValue;
    @ApiModelProperty(value = "按钮对应接口url", required = true)
    private String buttonPattern;
    @ApiModelProperty(value = "备注")
    private String buttonRemark;

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public void setButtonLabel(String buttonLabel) {
        this.buttonLabel = buttonLabel;
    }

    public String getButtonValue() {
        return buttonValue;
    }

    public void setButtonValue(String buttonValue) {
        this.buttonValue = buttonValue;
    }

    public String getButtonPattern() {
        return buttonPattern;
    }

    public void setButtonPattern(String buttonPattern) {
        this.buttonPattern = buttonPattern;
    }

    public String getButtonRemark() {
        return buttonRemark;
    }

    public void setButtonRemark(String buttonRemark) {
        this.buttonRemark = buttonRemark;
    }
}
