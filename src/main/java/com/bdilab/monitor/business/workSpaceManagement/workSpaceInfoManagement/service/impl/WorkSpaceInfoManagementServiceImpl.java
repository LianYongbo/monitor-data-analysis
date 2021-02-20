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
        user.setUserMobile("16603761876");
        user.setUserName("小明");
        user.setUserEmail("8@qq.com");
        user.setUserOrganizationId("1");
        user.setUserWorkSpaceId(workSpace.getWorkSpaceId());
        user.setUserRemark("无");
        User user1 = new User();
        user1.setUserMobile("16603761721A");
        user1.setUserName("李华");
        user1.setUserEmail("6@qq.com");
        user1.setUserOrganizationId("1");
        user1.setUserWorkSpaceId(workSpace.getWorkSpaceId());
        user1.setUserRemark("无");
        users.add(user);
        users.add(user1);
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
        workSpace.setWorkSpaceAddress("未来城");
        workSpace.setWorkSpaceContact("4233081");
        workSpace.setWorkSpacePeopleNumber(0);
        workSpace.setWorkSpaceRemark("无");
        WorkSpace workSpace1 = new WorkSpace();
        workSpace1.setWorkSpaceId("1");
        workSpace1.setWorkSpaceAddress("未来城A");
        workSpace1.setWorkSpaceContact("4233081A");
        workSpace1.setWorkSpacePeopleNumber(0);
        workSpace1.setWorkSpaceRemark("无");
        workSpace1.setWorkSpaceName(workSpace.getWorkSpaceName());
        workSpace1.setWorkSpaceParentId(workSpace.getWorkSpaceParentId());
        workSpaces.add(workSpace);
        workSpaces.add(workSpace1);
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
        workSpace.setWorkSpaceAddress("未来城");
        workSpace.setWorkSpaceContact("4233081");
        workSpace.setWorkSpacePeopleNumber(0);
        workSpace.setWorkSpaceRemark("无");
        workSpaces.add(workSpace);
        WorkSpace workSpace1 = new WorkSpace();
        workSpace1.setWorkSpaceId("2");
        workSpace1.setWorkSpaceAddress("未来城A");
        workSpace1.setWorkSpaceContact("4233081A");
        workSpace1.setWorkSpacePeopleNumber(0);
        workSpace1.setWorkSpaceRemark("无");
        workSpace1.setWorkSpaceName("未来城工区A");
        workSpace1.setWorkSpaceParentId(workSpace.getWorkSpaceParentId());
        workSpaces.add(workSpace1);
        return workSpaces;
    }
}
