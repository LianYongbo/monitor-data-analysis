package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据工区编号查找用户出参对象
 *
 * @author Lian
 * @date 2021/2/19 16:11
 **/
public class UserFindByWorkSpaceIdView {
    @ApiModelProperty(value = "用户手机号", required = true)
    private String userMobile;
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

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
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
}
