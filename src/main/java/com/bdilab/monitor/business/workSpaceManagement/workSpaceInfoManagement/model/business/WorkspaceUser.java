package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business;

import io.swagger.annotations.ApiModelProperty;

public class WorkspaceUser{
    @ApiModelProperty(value = "id", required = true)
    private String id;
    @ApiModelProperty(value = "工区编号", required = true)
    private String fkWorkspaceId;
    @ApiModelProperty(value = "用户手机号", required = true)
    private String fkUserMobile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkWorkspaceId() {
        return fkWorkspaceId;
    }

    public void setFkWorkspaceId(String fkWorkspaceId) {
        this.fkWorkspaceId = fkWorkspaceId;
    }

    public String getFkUserMobile() {
        return fkUserMobile;
    }

    public void setFkUserMobile(String fkUserMobile) {
        this.fkUserMobile = fkUserMobile;
    }
}