package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 创建工区入参对象
 *
 * @author Lian
 * @date 2021/2/18 18:10
 **/
public class WorkSpaceCreateStandard {
    @ApiModelProperty(value = "工区名称", required = true)
    private String workSpaceName;
    @ApiModelProperty(value = "父组织编号", required = true)
    private String workSpaceParentId;
    @ApiModelProperty(value = "工区联系电话", required = true)
    private String workSpaceContact;
    @ApiModelProperty(value = "工区地址", required = true)
    private String workSpaceAddress;
    @ApiModelProperty(value = "备注")
    private String workSpaceRemark;

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

    public String getWorkSpaceRemark() {
        return workSpaceRemark;
    }

    public void setWorkSpaceRemark(String workSpaceRemark) {
        this.workSpaceRemark = workSpaceRemark;
    }
}
