package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据名称查找工区入参对象
 *
 * @author Lian
 * @date 2021/2/18 18:26
 **/
public class WorkSpaceFindByNameStandard {
    @ApiModelProperty(value = "工区名称", required = true)
    private String workSpaceName;
    @ApiModelProperty(value = "父组织编号", required = true)
    private String workSpaceParentId;

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
}
