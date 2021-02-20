package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.service.impl;

import com.bdilab.mine.business.userManagement.userInfoManagement.model.business.User;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.service.WorkSpaceInfoManagementService;
import org.springframework.stereotype.Service;

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
    @Override
    public WorkSpace workSpaceCreate(WorkSpace workSpace) {
        return null;
    }

    @Override
    public WorkSpace workSpaceUpdate(WorkSpace workSpace) {
        return null;
    }

    @Override
    public List<User> userFindByWorkSpaceId(WorkSpace workSpace) {
        return null;
    }

    @Override
    public User userTransfer(User user, WorkSpace workSpace) {
        return null;
    }

    @Override
    public WorkSpace workSpaceDelete(WorkSpace workSpace) {
        return null;
    }

    @Override
    public List<WorkSpace> workSpaceFindByName(WorkSpace workSpace) {
        return null;
    }

    @Override
    public WorkSpace workSpaceFindById(WorkSpace workSpace) {
        return null;
    }

    @Override
    public List<WorkSpace> workSpaceFindByParentId(WorkSpace workSpace) {
        return null;
    }
}
