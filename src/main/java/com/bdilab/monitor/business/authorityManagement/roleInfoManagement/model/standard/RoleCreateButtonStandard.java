package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard;

import com.bdilab.monitor.util.VerifyIntegrity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建角色入参对象中的路由对象的按钮对象
 *
 * @author Lian
 * @date 2021/2/16 23:13
 **/
public class RoleCreateButtonStandard {
    private final VerifyIntegrity verifyIntegrity;

    public RoleCreateButtonStandard(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    @ApiModelProperty(value = "按钮编号", required = true)
    private String buttonId;

    /**
     * 校验按钮编号完整性
     *
     * @return 属性为空或为Null，返回false；否则返回true
     */
    public Boolean verify() {
        return !verifyIntegrity.verify(this.buttonId);
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }
}
