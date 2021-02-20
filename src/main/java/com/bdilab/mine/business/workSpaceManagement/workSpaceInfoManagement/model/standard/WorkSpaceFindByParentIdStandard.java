package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据父组织编号查找工区入参对象
 *
 * @author Lian
 * @date 2021/2/18 18:29
 **/
public class WorkSpaceFindByParentIdStandard {
    @ApiModelProperty(value = "父组织编号", required = true)
    private String workSpaceParentId;

    public String getWorkSpaceParentId() {
        return workSpaceParentId;
    }

    public void setWorkSpaceParentId(String workSpaceParentId) {
        this.workSpaceParentId = workSpaceParentId;
    }
}
