package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据父组织编号查找组织入参对象
 *
 * @author Lian
 * @date 2021/2/18 17:53
 **/
public class OrganizationFindByParentIdStandard {
    @ApiModelProperty(value = "父组织编号", required = true)
    private String organizationParentId;

    public String getOrganizationParentId() {
        return organizationParentId;
    }

    public void setOrganizationParentId(String organizationParentId) {
        this.organizationParentId = organizationParentId;
    }
}
