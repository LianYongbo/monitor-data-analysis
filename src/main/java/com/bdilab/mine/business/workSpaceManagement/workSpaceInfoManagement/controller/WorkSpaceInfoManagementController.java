package com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.controller;

import com.bdilab.mine.business.workSpaceManagement.workSpaceInfoManagement.model.standard.*;
import com.bdilab.mine.response.HttpCode;
import com.bdilab.mine.response.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
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
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
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
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
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
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
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
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
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
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
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
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
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
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }
}
