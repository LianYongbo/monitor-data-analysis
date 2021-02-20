package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据工区编号查找工区入参对象
 *
 * @author Lian
 * @date 2021/2/18 18:28
 **/
public class WorkSpaceFindByIdStandard {
    @ApiModelProperty(value = "工区编号", required = true)
    private String workSpaceId;
    @ApiModelProperty(value = "父组织编号", required = true)
    private String workSpaceParentId;

    public String getWorkSpaceId() {
        return workSpaceId;
    }

    public void setWorkSpaceId(String workSpaceId) {
        this.workSpaceId = workSpaceId;
    }

    public String getWorkSpaceParentId() {
        return workSpaceParentId;
    }

    public void setWorkSpaceParentId(String workSpaceParentId) {
        this.workSpaceParentId = workSpaceParentId;
    }
}
