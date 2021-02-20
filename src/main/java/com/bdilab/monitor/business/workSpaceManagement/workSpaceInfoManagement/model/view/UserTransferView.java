package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

/**
 * 调动工区内用户出参对象
 *
 * @author Lian
 * @date 2021/2/19 16:17
 **/
public class UserTransferView {
    @ApiModelProperty(value = "用户手机号", required = true)
    private String userMobile;
    @ApiModelProperty(value = "用户所属工区编号")
    private String userWorkSpaceId;
    @ApiModelProperty(value = "工区人数", required = true)
    private Integer workSpacePeopleNumber;

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserWorkSpaceId() {
        return userWorkSpaceId;
    }

    public void setUserWorkSpaceId(String userWorkSpaceId) {
        this.userWorkSpaceId = userWorkSpaceId;
    }

    public Integer getWorkSpacePeopleNumber() {
        return workSpacePeopleNumber;
    }

    public void setWorkSpacePeopleNumber(Integer workSpacePeopleNumber) {
        this.workSpacePeopleNumber = workSpacePeopleNumber;
    }
}
