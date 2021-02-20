package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

/**
 * 删除组织出参对象
 *
 * @author Lian
 * @date 2021/2/19 3:48
 **/
public class OrganizationDeleteView {
    @ApiModelProperty(value = "组织编号", required = true)
    private String organizationId;
    @ApiModelProperty(value = "组织是否被删除", required = true)
    private Boolean organizationDeleted;

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Boolean getOrganizationDeleted() {
        return organizationDeleted;
    }

    public void setOrganizationDeleted(Boolean organizationDeleted) {
        this.organizationDeleted = organizationDeleted;
    }
}
