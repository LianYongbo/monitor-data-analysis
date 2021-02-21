package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.dao;

import com.bdilab.monitor.business.userManagement.userInfoManagement.model.business.User;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkspaceUser;

import java.util.List;


public interface WorkspaceUserDao {
    int deleteByPrimaryKey(String id);

    int insert(WorkspaceUser record);

    int insertSelective(WorkspaceUser record);

    WorkspaceUser selectByPrimaryKey(String id);

    List<User> selectByWorkspaceId(String workspaceId);

    int updateByPrimaryKeySelective(WorkspaceUser record);

    int updateByPrimaryKey(WorkspaceUser record);
}