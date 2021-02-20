package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 根据工区编号查找用户入参对象
 *
 * @author Lian
 * @date 2021/2/18 18:37
 **/
public class UserFindByWorkSpaceIdStandard {
    @ApiModelProperty(value = "工区编号", required = true)
    private String workSpaceId;

    public String getWorkSpaceId() {
        return workSpaceId;
    }

    public void setWorkSpaceId(String workSpaceId) {
        this.workSpaceId = workSpaceId;
    }
}
