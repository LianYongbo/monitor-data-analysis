package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据父组织编号查找工区出参对象
 *
 * @author Lian
 * @date 2021/2/19 16:04
 **/
public class WorkSpaceFindByParentIdView {
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

    public String getWorkSpaceRemark() {
        return workSpaceRemark;
    }

    public void setWorkSpaceRemark(String workSpaceRemark) {
        this.workSpaceRemark = workSpaceRemark;
    }
}
