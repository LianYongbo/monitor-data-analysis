package com.bdilab.mine.business.userManagement.userInfoManagement.model.business;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 用户信息管理子模块业务中的用户对象
 *
 * @author Lian
 * @date 2021/2/12 2:02
 **/
public class User {
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
    @ApiModelProperty(value = "用户所属组织编号", required = true)
    private String userOrganizationId;
    @ApiModelProperty(value = "用户所属工区编号")
    private String userWorkSpaceId;
    @ApiModelProperty(value = "用户是否可用", required = true)
    private Boolean userEnabled;
    @ApiModelProperty(value = "用户是否被锁定", required = true)
    private Boolean userLocked;
    @ApiModelProperty(value = "用户是否被删除", required = true)
    private Boolean userDeleted;
    @ApiModelProperty(value = "注册申请是否被审批", required = true)
    private Boolean userProcessed;
    @ApiModelProperty(value = "注册申请是否已通过", required = true)
    private Boolean userPassed;

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

    public String getUserWorkSpaceId() {
        return userWorkSpaceId;
    }

    public void setUserWorkSpaceId(String userWorkSpaceId) {
        this.userWorkSpaceId = userWorkSpaceId;
    }

    public Boolean getUserEnabled() {
        return userEnabled;
    }

    public void setUserEnabled(Boolean userEnabled) {
        this.userEnabled = userEnabled;
    }

    public Boolean getUserLocked() {
        return userLocked;
    }

    public void setUserLocked(Boolean userLocked) {
        this.userLocked = userLocked;
    }

    public Boolean getUserDeleted() {
        return userDeleted;
    }

    public void setUserDeleted(Boolean userDeleted) {
        this.userDeleted = userDeleted;
    }

    public Boolean getUserProcessed() {
        return userProcessed;
    }

    public void setUserProcessed(Boolean userProcessed) {
        this.userProcessed = userProcessed;
    }

    public Boolean getUserPassed() {
        return userPassed;
    }

    public void setUserPassed(Boolean userPassed) {
        this.userPassed = userPassed;
    }
}
