package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.service;

import com.bdilab.mine.business.userManagement.userInfoManagement.model.business.User;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;

import java.util.List;

/**
 * 工区管理默模块
 * 工区信息管理子模块服务接口
 *
 * @author Lian
 * @date 2021/2/19 22:50
 **/
public interface WorkSpaceInfoManagementService {
    /**
     * 创建工区
     *
     * @param workSpace 包含基本信息的工区业务对象
     * @return 创建的工区的基本信息
     */
    WorkSpace workSpaceCreate(WorkSpace workSpace);

    /**
     * 修改工区信息
     *
     * @param workSpace 包含基本信息的工区业务对象
     * @return 修改的工区的基本信息
     */
    WorkSpace workSpaceUpdate(WorkSpace workSpace);

    /**
     * @param workSpace 包含工区编号的工区业务对象
     * @return 符合该工区编号的工区内的用户集合
     */
    List<User> userFindByWorkSpaceId(WorkSpace workSpace);

    User userTransfer(User user, WorkSpace workSpace);

    /**
     * 删除工区
     *
     * @param workSpace 包含工区编号的工区业务对象
     * @return 删除后的信息
     */
    WorkSpace workSpaceDelete(WorkSpace workSpace);

    /**
     * 根据名称查找工区
     *
     * @param workSpace 包含工区名称的工区业务对象
     * @return 符合该名称的工区集合
     */
    List<WorkSpace> workSpaceFindByName(WorkSpace workSpace);

    /**
     * 据编号查找工区
     *
     * @param workSpace 包含工区编号的工区业务对象
     * @return 符合该编号的工区
     */
    WorkSpace workSpaceFindById(WorkSpace workSpace);

    /**
     * 根据父组织编号查找工区
     *
     * @param workSpace 包含父组织编号的工区业务对象
     * @return 符合该父组织编号的工区集合
     */
    List<WorkSpace> workSpaceFindByParentId(WorkSpace workSpace);
}
