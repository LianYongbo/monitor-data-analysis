package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 调动工区内用户入参对象
 *
 * @author Lian
 * @date 2021/2/18 18:38
 **/
public class UserTransferStandard {
    @ApiModelProperty(value = "用户手机号", required = true)
    private String userMobile;
    @ApiModelProperty(value = "工区编号", required = true)
    private String workSpaceId;
    @ApiModelProperty(value = "是否调入用户", required = true, notes = "true是调入；false是调出")
    private Boolean workSpaceAdd;

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getWorkSpaceId() {
        return workSpaceId;
    }

    public void setWorkSpaceId(String workSpaceId) {
        this.workSpaceId = workSpaceId;
    }

    public Boolean getWorkSpaceAdd() {
        return workSpaceAdd;
    }

    public void setWorkSpaceAdd(Boolean workSpaceAdd) {
        this.workSpaceAdd = workSpaceAdd;
    }
}
