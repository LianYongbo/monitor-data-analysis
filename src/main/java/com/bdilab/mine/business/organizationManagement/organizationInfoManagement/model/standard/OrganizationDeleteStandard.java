package com.bdilab.mine.business.organizationManagement.organizationInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 删除组织入参对象
 *
 * @author Lian
 * @date 2021/2/18 17:43
 **/
public class OrganizationDeleteStandard {
    @ApiModelProperty(value = "组织编号", required = true)
    private String organizationId;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }
}
