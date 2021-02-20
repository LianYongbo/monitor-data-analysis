package com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据名称查找组织入参对象
 *
 * @author Lian
 * @date 2021/2/18 17:47
 **/
public class OrganizationFindByNameStandard {
    @ApiModelProperty(value = "组织名称", required = true)
    private String organizationName;
    @ApiModelProperty(value = "父组织编号", required = true)
    private String organizationParentId;

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
}
