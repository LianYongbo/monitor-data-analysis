package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.controller;

import com.bdilab.mine.business.userManagement.userInfoManagement.model.business.User;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.conversion.*;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.business.WorkSpace;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard.*;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.view.*;
import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.service.WorkSpaceInfoManagementService;
import com.bdilab.mine.response.HttpCode;
import com.bdilab.mine.response.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 工区管理模块
 * 工区信息管理子模块
 *
 * @author Lian
 * @date 2021/2/18 17:57
 **/
@RestController
@Api(value = "工区信息管理子模块")
public class WorkSpaceInfoManagementController {
    private final WorkSpaceCreateConversion workSpaceCreateConversion;
    private final WorkSpaceUpdateConversion workSpaceUpdateConversion;
    private final WorkSpaceDeleteConversion workSpaceDeleteConversion;
    private final WorkSpaceFindByParentIdConversion workSpaceFindByParentIdConversion;
    private final WorkSpaceFindByIdConversion workSpaceFindByIdConversion;
    private final WorkSpaceFindByNameConversion workSpaceFindByNameConversion;
    private final UserFindByWorkSpaceIdConversion userFindByWorkSpaceIdConversion;
    private final UserTransferConversion userTransferConversion;
    private final WorkSpaceInfoManagementService workSpaceInfoManagementService;

    public WorkSpaceInfoManagementController(WorkSpaceCreateConversion workSpaceCreateConversion, WorkSpaceUpdateConversion workSpaceUpdateConversion, WorkSpaceDeleteConversion workSpaceDeleteConversion, WorkSpaceFindByParentIdConversion workSpaceFindByParentIdConversion, WorkSpaceFindByIdConversion workSpaceFindByIdConversion, WorkSpaceFindByNameConversion workSpaceFindByNameConversion, UserFindByWorkSpaceIdConversion userFindByWorkSpaceIdConversion, UserTransferConversion userTransferConversion, WorkSpaceInfoManagementService workSpaceInfoManagementService) {
        this.workSpaceCreateConversion = workSpaceCreateConversion;
        this.workSpaceUpdateConversion = workSpaceUpdateConversion;
        this.workSpaceDeleteConversion = workSpaceDeleteConversion;
        this.workSpaceFindByParentIdConversion = workSpaceFindByParentIdConversion;
        this.workSpaceFindByIdConversion = workSpaceFindByIdConversion;
        this.workSpaceFindByNameConversion = workSpaceFindByNameConversion;
        this.userFindByWorkSpaceIdConversion = userFindByWorkSpaceIdConversion;
        this.userTransferConversion = userTransferConversion;
        this.workSpaceInfoManagementService = workSpaceInfoManagementService;
    }


    /**
     * 入参：接口对应的入参对象
     * 业务对象：实现业务时用到的对象
     * 出参：接口对应的出参对象
     * <p>
     * 接口参数处理步骤
     * Step 1 ： 入参校验（在数据转换中完成）
     * Step 2 ： 入参数据结构转换（为业务对象）
     * Step 3 ： 调用服务层
     * Step 4 ： 业务对象校验（在数据转换中完成）
     * Step 5 ： 业务对象数据结构转换（为出参）
     * <p>
     * 管理员创建工区。
     *
     * @param workSpaceCreateStandard 创建工区的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "创建工区", notes = "管理员创建工区。")
    @PostMapping(value = "/workSpace/create")
    public HttpResponse workSpaceCreate(@RequestBody WorkSpaceCreateStandard workSpaceCreateStandard) {
        WorkSpace workSpaceConverted = workSpaceCreateConversion.conversion(workSpaceCreateStandard);
        if (workSpaceConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        WorkSpace workSpaceAfterCreation = workSpaceInfoManagementService.workSpaceCreate(workSpaceConverted);
        if (workSpaceAfterCreation == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        WorkSpaceCreateView data = workSpaceCreateConversion.conversion(workSpaceAfterCreation);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员修改工区信息。
     *
     * @param workSpaceUpdateStandard 修改工区信息的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "修改工区信息", notes = "管理员修改工区信息。")
    @PostMapping(value = "/workSpace/update")
    public HttpResponse workSpaceUpdate(@RequestBody WorkSpaceUpdateStandard workSpaceUpdateStandard) {
        WorkSpace workSpaceConverted = workSpaceUpdateConversion.conversion(workSpaceUpdateStandard);
        if (workSpaceConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        WorkSpace workSpaceUpdated = workSpaceInfoManagementService.workSpaceUpdate(workSpaceConverted);
        if (workSpaceUpdated == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        WorkSpaceUpdateView data = workSpaceUpdateConversion.conversion(workSpaceUpdated);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员根据工区编号查找用户。
     *
     * @param userFindByWorkSpaceIdStandard 根据工区编号查找用户的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据工区编号查找用户", notes = "管理员根据工区编号查找用户。")
    @PostMapping(value = "/workSpace/user/find/workSpaceId")
    public HttpResponse userFindByWorkSpaceId(@RequestBody UserFindByWorkSpaceIdStandard userFindByWorkSpaceIdStandard) {
        WorkSpace workSpaceConverted = userFindByWorkSpaceIdConversion.conversion(userFindByWorkSpaceIdStandard);
        if (workSpaceConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<User> usersAfterSearching = workSpaceInfoManagementService.userFindByWorkSpaceId(workSpaceConverted);
        if (usersAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<UserFindByWorkSpaceIdView> data = new ArrayList<>();
        for (User user : usersAfterSearching) {
            UserFindByWorkSpaceIdView userFindByWorkSpaceIdView = userFindByWorkSpaceIdConversion.conversion(user);
            if (userFindByWorkSpaceIdView == null) {
                return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
            }
            data.add(userFindByWorkSpaceIdView);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员调动工区内用户。
     *
     * @param userTransferStandard 调动工区内用户的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "调动工区内用户", notes = "管理员调动工区内用户。")
    @PostMapping(value = "/workSpace/user/transfer")
    public HttpResponse userTransfer(@RequestBody UserTransferStandard userTransferStandard) {
        WorkSpace workSpaceConverted = userTransferConversion.conversionToWorkSpace(userTransferStandard);
        User userConverted = userTransferConversion.conversionToUser(userTransferStandard);
        Boolean isAdd = userTransferConversion.isAdd(userTransferStandard);
        if (workSpaceConverted == null || userConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        User userAfterTransfer = workSpaceInfoManagementService.userTransfer(userConverted, workSpaceConverted, isAdd);
        if (userAfterTransfer == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        UserTransferView data = userTransferConversion.conversion(userAfterTransfer);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员删除工区：假删除。
     *
     * @param workSpaceDeleteStandard 删除工区的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "删除工区", notes = "管理员删除工区。")
    @PostMapping(value = "/workSpace/delete")
    public HttpResponse workSpaceDelete(@RequestBody WorkSpaceDeleteStandard workSpaceDeleteStandard) {
        WorkSpace workSpaceConverted = workSpaceDeleteConversion.conversion(workSpaceDeleteStandard);
        if (workSpaceConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        WorkSpace workSpaceDeleted = workSpaceInfoManagementService.workSpaceDelete(workSpaceConverted);
        if (workSpaceDeleted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        WorkSpaceDeleteView data = workSpaceDeleteConversion.conversion(workSpaceDeleted);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员根据工区名称查找工区。
     *
     * @param workSpaceFindByNameStandard 根据工区名称查找工区的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据工区名称查找工区", notes = "管理员根据工区名称查找工区。")
    @PostMapping(value = "/workSpace/find/name")
    public HttpResponse workSpaceFindByName(@RequestBody WorkSpaceFindByNameStandard workSpaceFindByNameStandard) {
        WorkSpace workSpaceConverted = workSpaceFindByNameConversion.conversion(workSpaceFindByNameStandard);
        if (workSpaceConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<WorkSpace> workSpacesAfterSearching = workSpaceInfoManagementService.workSpaceFindByName(workSpaceConverted);
        if (workSpacesAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<WorkSpaceFindByNameView> data = new ArrayList<>();
        for (WorkSpace workSpace : workSpacesAfterSearching) {
            WorkSpaceFindByNameView workSpaceFindByNameView = workSpaceFindByNameConversion.conversion(workSpace);
            if (workSpace == null) {
                return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
            }
            data.add(workSpaceFindByNameView);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员根据工区编号查找工区。
     *
     * @param workSpaceFindByIdStandard 根据工区编号查找工区的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据工区编号查找工区", notes = "管理员根据工区编号查找工区。")
    @PostMapping(value = "/workSpace/find/id")
    public HttpResponse workSpaceFindById(@RequestBody WorkSpaceFindByIdStandard workSpaceFindByIdStandard) {
        WorkSpace workSpaceConverted = workSpaceFindByIdConversion.conversion(workSpaceFindByIdStandard);
        if (workSpaceConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        WorkSpace workSpacesAfterSearching = workSpaceInfoManagementService.workSpaceFindById(workSpaceConverted);
        if (workSpacesAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        WorkSpaceFindByIdView data = workSpaceFindByIdConversion.conversion(workSpacesAfterSearching);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员根据父组织编号查找工区。
     *
     * @param workSpaceFindByParentIdStandard 根据父组织编号查找工区的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据父组织编号查找工区", notes = "管理员根据父组织编号查找工区。")
    @PostMapping(value = "/workSpace/find/parentId")
    public HttpResponse workSpaceFindByParentId(@RequestBody WorkSpaceFindByParentIdStandard workSpaceFindByParentIdStandard) {
        WorkSpace workSpaceConverted = workSpaceFindByParentIdConversion.conversion(workSpaceFindByParentIdStandard);
        if (workSpaceConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<WorkSpace> workSpacesAfterSearching = workSpaceInfoManagementService.workSpaceFindByParentId(workSpaceConverted);
        if (workSpacesAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<WorkSpaceFindByParentIdView> data = new ArrayList<>();
        for (WorkSpace workSpace : workSpacesAfterSearching) {
            WorkSpaceFindByParentIdView workSpaceFindByParentIdView = workSpaceFindByParentIdConversion.conversion(workSpace);
            if (workSpace == null) {
                return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
            }
            data.add(workSpaceFindByParentIdView);
        }
        return new HttpResponse(HttpCode.OK, data);
    }
}
