package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.view;

import io.swagger.annotations.ApiModelProperty;

/**
 * 删除工区出参对象
 *
 * @author Lian
 * @date 2021/2/19 16:02
 **/
public class WorkSpaceDeleteView {
    @ApiModelProperty(value = "工区编号", required = true)
    private String workSpaceId;
    @ApiModelProperty(value = "工区是否被删除", required = true)
    private Boolean workSpaceDeleted;

    public String getWorkSpaceId() {
        return workSpaceId;
    }

    public void setWorkSpaceId(String workSpaceId) {
        this.workSpaceId = workSpaceId;
    }

    public Boolean getWorkSpaceDeleted() {
        return workSpaceDeleted;
    }

    public void setWorkSpaceDeleted(Boolean workSpaceDeleted) {
        this.workSpaceDeleted = workSpaceDeleted;
    }
}
