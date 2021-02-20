package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.dao;

import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkspaceUser;

public interface WorkspaceUserDao {
    int deleteByPrimaryKey(String id);

    int insert(WorkspaceUser record);

    int insertSelective(WorkspaceUser record);

    WorkspaceUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WorkspaceUser record);

    int updateByPrimaryKey(WorkspaceUser record);
}