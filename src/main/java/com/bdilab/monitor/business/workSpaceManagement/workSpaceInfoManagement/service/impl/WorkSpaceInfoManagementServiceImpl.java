package com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.service.impl;

import com.bdilab.monitor.business.userManagement.userInfoManagement.model.business.User;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.service.WorkSpaceInfoManagementService;
import com.bdilab.monitor.business.workSpaceManagement.workSpaceInfoManagement.verification.WorkSpaceInfoManagementVerifyIntegrity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    private final WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity;

    public WorkSpaceInfoManagementServiceImpl(WorkSpaceInfoManagementVerifyIntegrity workSpaceInfoManagementVerifyIntegrity) {
        this.workSpaceInfoManagementVerifyIntegrity = workSpaceInfoManagementVerifyIntegrity;
    }

    @Override
    public WorkSpace workSpaceCreate(WorkSpace workSpace) {
        int type = 1;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyCreate(workSpace, type)) {
            System.out.println("创建工区接口 - 创建工区服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        workSpace.setWorkSpacePeopleNumber(0);
        workSpace.setWorkSpaceDeleted(false);
        return workSpace;
    }

    @Override
    public WorkSpace workSpaceUpdate(WorkSpace workSpace) {
        int type = 1;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyUpdate(workSpace, type)) {
            System.out.println("修改工区信息接口 - 创建工区服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        workSpace.setWorkSpacePeopleNumber(0);
        workSpace.setWorkSpaceDeleted(false);
        workSpace.setWorkSpaceParentId("2");
        return workSpace;
    }

    @Override
    public List<User> userFindByWorkSpaceId(WorkSpace workSpace) {
        if (!workSpaceInfoManagementVerifyIntegrity.verifyFindByWorkSpaceIdWorkSpace(workSpace)) {
            System.out.println("根据工区编号查找工区内用户接口 - 根据工区编号查找工区内用户服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUserMobile("1");
        user.setUserName("1");
        user.setUserEmail("1");
        user.setUserOrganizationId("1");
        user.setUserWorkSpaceId(workSpace.getWorkSpaceId());
        user.setUserRemark("无");
        users.add(user);
        return users;
    }

    @Override
    public User userTransfer(User user, WorkSpace workSpace, Boolean isAdd) {
        if (!workSpaceInfoManagementVerifyIntegrity.verifyTransferWorkSpace(workSpace) || !workSpaceInfoManagementVerifyIntegrity.verifyTransferUserMobile(user) || isAdd == null) {
            System.out.println("调动工区内用户接口 - 调动工区内用户服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        user.setUserWorkSpaceId("2");
        if (isAdd) {
            user.setUserWorkSpaceId(workSpace.getWorkSpaceId());
        } else {
            if (workSpace.getWorkSpaceId().equals(user.getUserWorkSpaceId())) {
                user.setUserWorkSpaceId("");
            }
        }
        return user;
    }

    @Override
    public WorkSpace workSpaceDelete(WorkSpace workSpace) {
        int type = 1;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyDelete(workSpace, type)) {
            System.out.println("删除工区接口 - 删除工区服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        workSpace.setWorkSpaceDeleted(true);
        return workSpace;
    }

    @Override
    public List<WorkSpace> workSpaceFindByName(WorkSpace workSpace) {
        int type = 1;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyFindByName(workSpace, type)) {
            System.out.println("根据名称查找工区接口 - 根据名称查找工区服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        List<WorkSpace> workSpaces = new ArrayList<>();
        workSpace.setWorkSpaceId("1");
        workSpace.setWorkSpaceAddress("1");
        workSpace.setWorkSpaceContact("1");
        workSpace.setWorkSpacePeopleNumber(0);
        workSpace.setWorkSpaceRemark("无");
        workSpaces.add(workSpace);
        return workSpaces;
    }

    @Override
    public WorkSpace workSpaceFindById(WorkSpace workSpace) {
        int type = 1;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyFindById(workSpace, type)) {
            System.out.println("根据编号查找工区接口 - 根据编号查找工区服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        workSpace.setWorkSpaceName("未来城");
        workSpace.setWorkSpaceAddress("1");
        workSpace.setWorkSpaceContact("1");
        workSpace.setWorkSpacePeopleNumber(0);
        workSpace.setWorkSpaceRemark("无");
        return workSpace;
    }

    @Override
    public List<WorkSpace> workSpaceFindByParentId(WorkSpace workSpace) {
        int type = 1;
        if (!workSpaceInfoManagementVerifyIntegrity.verifyFindByParentId(workSpace, type)) {
            System.out.println("根据父组织编号查找工区接口 - 根根据父组织编号查找工区服务 - " + new Date() + " - 业务对象有误！");
            return null;
        }
        List<WorkSpace> workSpaces = new ArrayList<>();
        workSpace.setWorkSpaceId("1");
        workSpace.setWorkSpaceName("未来城工区");
        workSpace.setWorkSpaceAddress("1");
        workSpace.setWorkSpaceContact("1");
        workSpace.setWorkSpacePeopleNumber(0);
        workSpace.setWorkSpaceRemark("无");
        workSpaces.add(workSpace);
        return workSpaces;
    }
}
