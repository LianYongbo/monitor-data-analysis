package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.dao;

import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.Workspace;

public interface WorkspaceDao {
    int deleteByPrimaryKey(String workspaceId);

    int insert(Workspace record);

    int insertSelective(Workspace record);

    Workspace selectByPrimaryKey(String workspaceId);

    int updateByPrimaryKeySelective(Workspace record);

    int updateByPrimaryKey(Workspace record);
}