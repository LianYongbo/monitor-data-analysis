package com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.business;

import com.bdilab.mine.util.VerifyIntegrity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建角色业务对象中的路由对象的按钮对象
 *
 * @author Lian
 * @date 2021/2/18 12:30
 **/
public class RoleCreateButton {
    private VerifyIntegrity verifyIntegrity;

    public RoleCreateButton(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    @ApiModelProperty(value = "按钮编号", required = true)
    private String buttonId;
    @ApiModelProperty(value = "按钮名称", required = true)
    private String buttonLabel;
    @ApiModelProperty(value = "按钮地址", required = true)
    private String buttonValue;

    public RoleCreateButton() {

    }

    /**
     * 校验按钮编号、按钮名称、按钮地址完整性
     *
     * @return 三个属性中有为空或为Null，返回false；否则返回true
     */
    public Boolean verify() {
        return !verifyIntegrity.verify(this.buttonId) && !verifyIntegrity.verify(this.buttonLabel) && !verifyIntegrity.verify(this.buttonValue);
    }

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
}
