package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 删除工区入参对象
 *
 * @author Lian
 * @date 2021/2/18 18:12
 **/
public class WorkSpaceDeleteStandard {
    @ApiModelProperty(value = "工区编号", required = true)
    private String workSpaceId;

    public String getWorkSpaceId() {
        return workSpaceId;
    }

    public void setWorkSpaceId(String workSpaceId) {
        this.workSpaceId = workSpaceId;
    }
}
