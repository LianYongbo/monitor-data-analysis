package com.bdilab.mine.business.userManagement.userInfoManagement.model.standard;

import com.bdilab.mine.util.VerifyIntegrity;
import io.swagger.annotations.ApiModelProperty;

/**
 * （非用户）注册申请入参对象
 *
 * @author Lian
 * @date 2021/2/16 17:20
 **/
public class UserRegisterStandard {
    private final VerifyIntegrity verifyIntegrity;

    public UserRegisterStandard(VerifyIntegrity verifyIntegrity) {
        this.verifyIntegrity = verifyIntegrity;
    }

    @ApiModelProperty(value = "用户手机号", required = true)
    private String userMobile;
    @ApiModelProperty(value = "用户密码", required = true)
    private String userPassword;
    @ApiModelProperty(value = "用户姓名", required = true)
    private String userName;
    @ApiModelProperty(value = "用户邮箱")
    private String userEmail;
    @ApiModelProperty(value = "用户备注")
    private String userRemark;
    @ApiModelProperty(value = "用户组织编号", required = true)
    private String userOrganizationId;

    /**
     * 校验用户手机号、用户密码、用户姓名、用户组织编号的完整性
     *
     * @return 四个属性中有为空或为Null，返回false；否则返回true
     */
    public Boolean verify() {
        return !verifyIntegrity.verify(this.userMobile) && !verifyIntegrity.verify(this.userPassword) && !verifyIntegrity.verify(this.userName) && !verifyIntegrity.verify(this.userOrganizationId);
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public String getUserOrganizationId() {
        return userOrganizationId;
    }

    public void setUserOrganizationId(String userOrganizationId) {
        this.userOrganizationId = userOrganizationId;
    }
}
