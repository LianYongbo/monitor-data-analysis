package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.service.impl;

import com.bdilab.monitor.business.userManagement.userInfoManagement.model.business.User;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.dao.WorkspaceDao;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.dao.WorkspaceUserDao;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.Workspace;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.service.WorkSpaceInfoManagementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工区管理默模块
 * 工区信息管理子模块服务接口实现
 *
 * @author Lian
 * @date 2021/2/20 0:03
 **/
@Service
public class WorkSpaceInfoManagementServiceImpl implements WorkSpaceInfoManagementService {
    @Resource
    WorkspaceUserDao workspaceUserDao;
    @Resource
    WorkspaceDao workspaceDao;

    @Override
    public Workspace workSpaceCreate(Workspace workSpace) {
        return null;
    }

    @Override
    public Workspace workSpaceUpdate(Workspace workSpace) {
        return null;
    }

    @Override
    public List<User> userFindByWorkSpaceId(Workspace workSpace) {
        List<User> users = workspaceUserDao.selectByWorkspaceId(workSpace.getWorkspaceId());
        System.out.println(users);
        return users;
    }

    @Override
    public User userTransfer(User user, Workspace workSpace) {
        return null;
    }

    @Override
    public Workspace workSpaceDelete(Workspace workSpace) {
        return null;
    }

    @Override
    public List<Workspace> workSpaceFindByName(Workspace workSpace) {
        return workspaceDao.selectByNameAndParentId(workSpace.getWorkspaceName(),workSpace.getWorkspaceParentId());
//        return null;
    }

    @Override
    public Workspace workSpaceFindById(Workspace workSpace) {
        return null;
    }

    @Override
    public List<Workspace> workSpaceFindByParentId(Workspace workSpace) {
        return null;
    }
}
