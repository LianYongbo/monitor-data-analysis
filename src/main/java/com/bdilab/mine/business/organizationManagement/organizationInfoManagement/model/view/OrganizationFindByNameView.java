package com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据名称查找组织业务对象
 *
 * @author Lian
 * @date 2021/2/19 10:52
 **/
public class OrganizationFindByNameView {
    @ApiModelProperty(value = "组织编号", required = true)
    private String organizationId;
    @ApiModelProperty(value = "组织名称", required = true)
    private String organizationName;
    @ApiModelProperty(value = "父组织编号", required = true)
    private String organizationParentId;
    @ApiModelProperty(value = "组织联系电话", required = true)
    private String organizationContact;
    @ApiModelProperty(value = "组织地址", required = true)
    private String organizationAddress;
    @ApiModelProperty(value = "备注")
    private String organizationRemark;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationParentId() {
        return organizationParentId;
    }

    public void setOrganizationParentId(String organizationParentId) {
        this.organizationParentId = organizationParentId;
    }

    public String getOrganizationContact() {
        return organizationContact;
    }

    public void setOrganizationContact(String organizationContact) {
        this.organizationContact = organizationContact;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public String getOrganizationRemark() {
        return organizationRemark;
    }

    public void setOrganizationRemark(String organizationRemark) {
        this.organizationRemark = organizationRemark;
    }
}
