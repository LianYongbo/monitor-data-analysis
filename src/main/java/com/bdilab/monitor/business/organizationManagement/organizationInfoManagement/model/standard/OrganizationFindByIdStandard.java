package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据编号查找组织入参对象
 *
 * @author Lian
 * @date 2021/2/18 17:50
 **/
public class OrganizationFindByIdStandard {
    @ApiModelProperty(value = "组织编号", required = true)
    private String organizationId;
    @ApiModelProperty(value = "父组织编号", required = true)
    private String organizationParentId;

    public String getOrganizationParentId() {
        return organizationParentId;
    }

    public void setOrganizationParentId(String organizationParentId) {
        this.organizationParentId = organizationParentId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
