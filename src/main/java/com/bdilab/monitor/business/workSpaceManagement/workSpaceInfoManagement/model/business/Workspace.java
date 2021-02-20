package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business;

import io.swagger.annotations.ApiModelProperty;

/**
 * 工区业务对象
 *
 * @author Lian
 * @date 2021/2/19 15:34
 **/
public class Workspace {
    @ApiModelProperty(value = "工区编号", required = true)
    private String workspaceId;
    @ApiModelProperty(value = "工区名称", required = true)
    private String workspaceName;
    @ApiModelProperty(value = "父组织编号", required = true)
    private String workspaceParentId;
    @ApiModelProperty(value = "工区联系电话", required = true)
    private String workspaceContact;
    @ApiModelProperty(value = "工区地址", required = true)
    private String workspaceAddress;
    @ApiModelProperty(value = "工区人数", required = true)
    private Integer workspacePeopleNumber;
    @ApiModelProperty(value = "工区是否被删除", required = true)
    private Boolean workspaceDeleted;
    @ApiModelProperty(value = "备注")
    private String workspaceRemark;

    public String getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

    public String getWorkspaceName() {
        return workspaceName;
    }

    public void setWorkspaceName(String workspaceName) {
        this.workspaceName = workspaceName;
    }

    public String getWorkspaceParentId() {
        return workspaceParentId;
    }

    public void setWorkspaceParentId(String workspaceParentId) {
        this.workspaceParentId = workspaceParentId;
    }

    public String getWorkspaceContact() {
        return workspaceContact;
    }

    public void setWorkspaceContact(String workspaceContact) {
        this.workspaceContact = workspaceContact;
    }

    public String getWorkspaceAddress() {
        return workspaceAddress;
    }

    public void setWorkspaceAddress(String workspaceAddress) {
        this.workspaceAddress = workspaceAddress;
    }

    public Integer getWorkspacePeopleNumber() {
        return workspacePeopleNumber;
    }

    public void setWorkspacePeopleNumber(Integer workspacePeopleNumber) {
        this.workspacePeopleNumber = workspacePeopleNumber;
    }

    public Boolean getWorkspaceDeleted() {
        return workspaceDeleted;
    }

    public void setWorkspaceDeleted(Boolean workspaceDeleted) {
        this.workspaceDeleted = workspaceDeleted;
    }

    public String getWorkspaceRemark() {
        return workspaceRemark;
    }

    public void setWorkspaceRemark(String workspaceRemark) {
        this.workspaceRemark = workspaceRemark;
    }
}
