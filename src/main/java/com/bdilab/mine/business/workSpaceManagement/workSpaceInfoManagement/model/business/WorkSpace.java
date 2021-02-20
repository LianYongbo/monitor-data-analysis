package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.business;

import io.swagger.annotations.ApiModelProperty;

/**
 * 工区业务对象
 *
 * @author Lian
 * @date 2021/2/19 15:34
 **/
public class WorkSpace {
    @ApiModelProperty(value = "工区编号", required = true)
    private String workSpaceId;
    @ApiModelProperty(value = "工区名称", required = true)
    private String workSpaceName;
    @ApiModelProperty(value = "父组织编号", required = true)
    private String workSpaceParentId;
    @ApiModelProperty(value = "工区联系电话", required = true)
    private String workSpaceContact;
    @ApiModelProperty(value = "工区地址", required = true)
    private String workSpaceAddress;
    @ApiModelProperty(value = "工区人数", required = true)
    private Integer workSpacePeopleNumber;
    @ApiModelProperty(value = "工区是否被删除", required = true)
    private Boolean workSpaceDeleted;
    @ApiModelProperty(value = "备注")
    private String workSpaceRemark;

    public String getWorkSpaceId() {
        return workSpaceId;
    }

    public void setWorkSpaceId(String workSpaceId) {
        this.workSpaceId = workSpaceId;
    }

    public String getWorkSpaceName() {
        return workSpaceName;
    }

    public void setWorkSpaceName(String workSpaceName) {
        this.workSpaceName = workSpaceName;
    }

    public String getWorkSpaceParentId() {
        return workSpaceParentId;
    }

    public void setWorkSpaceParentId(String workSpaceParentId) {
        this.workSpaceParentId = workSpaceParentId;
    }

    public String getWorkSpaceContact() {
        return workSpaceContact;
    }

    public void setWorkSpaceContact(String workSpaceContact) {
        this.workSpaceContact = workSpaceContact;
    }

    public String getWorkSpaceAddress() {
        return workSpaceAddress;
    }

    public void setWorkSpaceAddress(String workSpaceAddress) {
        this.workSpaceAddress = workSpaceAddress;
    }

    public Integer getWorkSpacePeopleNumber() {
        return workSpacePeopleNumber;
    }

    public void setWorkSpacePeopleNumber(Integer workSpacePeopleNumber) {
        this.workSpacePeopleNumber = workSpacePeopleNumber;
    }

    public Boolean getWorkSpaceDeleted() {
        return workSpaceDeleted;
    }

    public void setWorkSpaceDeleted(Boolean workSpaceDeleted) {
        this.workSpaceDeleted = workSpaceDeleted;
    }

    public String getWorkSpaceRemark() {
        return workSpaceRemark;
    }

    public void setWorkSpaceRemark(String workSpaceRemark) {
        this.workSpaceRemark = workSpaceRemark;
    }
}
