package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.dao;

import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.Workspace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkspaceDao {
    int deleteByPrimaryKey(String workspaceId);

    int insert(Workspace record);

    int insertSelective(Workspace record);

    Workspace selectByPrimaryKey(String workspaceId);

    Workspace selectByPrimaryKeyAndParentId(@Param("workspaceId") String workspaceId,@Param("parentId")String workspaceParentId);

    List<Workspace> selectFuzzyByNameAndParentId(@Param("name") String workspaceName,@Param("parentId")String workspaceParentId);

    List<Workspace> selectByParentId(@Param("parentId")String workspaceParentId);

    int updateByPrimaryKeySelective(Workspace record);

    int updateByPrimaryKey(Workspace record);
}