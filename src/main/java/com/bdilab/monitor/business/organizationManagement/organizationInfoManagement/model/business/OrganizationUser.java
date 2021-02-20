package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business;

import io.swagger.annotations.ApiModelProperty;

/**
 * organization_user
 * @author 
 */
public class OrganizationUser {
    @ApiModelProperty(value = "id", required = true)
    private String id;
    @ApiModelProperty(value = "用户手机号", required = true)
    private String fkUserUserMobile;
    @ApiModelProperty(value = "组织编号", required = true)
    private String fkOrganizationId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkUserUserMobile() {
        return fkUserUserMobile;
    }

    public void setFkUserUserMobile(String fkUserUserMobile) {
        this.fkUserUserMobile = fkUserUserMobile;
    }

    public String getFkOrganizationId() {
        return fkOrganizationId;
    }

    public void setFkOrganizationId(String fkOrganizationId) {
        this.fkOrganizationId = fkOrganizationId;
    }
}