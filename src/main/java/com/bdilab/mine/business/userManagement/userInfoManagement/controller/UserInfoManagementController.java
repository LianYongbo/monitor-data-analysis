package com.bdilab.mine.business.userManagement.userInfoManagement.controller;

import com.bdilab.mine.business.userManagement.userInfoManagement.model.standard.*;
import com.bdilab.mine.response.HttpCode;
import com.bdilab.mine.response.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理模块
 * 用户信息管理子模块业务接口
 *
 * @author Lian
 * @date 2021/2/12 0:54
 **/
@RestController
@Api(value = "用户信息管理子模块")
public class UserInfoManagementController {

    /**
     * 入参：接口对应的入参对象
     * 业务对象：实现业务时用到的对象
     * 出参：接口对应的出参对象
     * <p>
     * 接口参数处理步骤
     * Step 1 ： 入参校验（在数据转换中完成）
     * Step 2 ： 入参数据结构转换（为业务对象）
     * Step 3 ： 调用服务层
     * Step 4 ： 业务对象校验
     * Step 5 ： 业务对象数据结构转换（为出参）
     * <p>
     * 非系统用户填写相关信息进行注册申请，审批由管理员完成。
     *
     * @param userRegisterStandard 注册申请（非用户）的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "（非用户）注册申请", notes = "非系统用户填写相关信息进行注册申请，审批由管理员完成。")
    @PostMapping(value = "/user/register")
    public HttpResponse userRegister(@RequestBody UserRegisterStandard userRegisterStandard) {
        if (userRegisterStandard.verify()) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员审批注册申请：通过或不通过。
     *
     * @param userApproveStandard 审批注册申请的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "审批注册申请", notes = "管理员审批注册申请。")
    @PostMapping(value = "/user/approve")
    public HttpResponse userApprove(@RequestBody UserApproveStandard userApproveStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员修改用户信息。
     *
     * @param userUpdateStandard 修改用户信息的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "修改用户信息", notes = "管理员修改用户信息。")
    @PostMapping(value = "/user/update")
    public HttpResponse userUpdate(@RequestBody UserUpdateStandard userUpdateStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员更改用户可用状态：可用或不可用。
     *
     * @param userEnabledStandard 修改用户可用状态的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "修改用户可用状态", notes = "管理员更改用户可用状态。")
    @PostMapping(value = "/user/enabled")
    public HttpResponse userEnabled(@RequestBody UserEnabledStandard userEnabledStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员更改用户锁定状态：锁定或未锁定。
     *
     * @param userLockedStandard 修改用户锁定状态的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "修改用户锁定状态", notes = "管理员更改用户锁定状态。")
    @PostMapping(value = "/user/locked")
    public HttpResponse userLocked(@RequestBody UserLockedStandard userLockedStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员删除用户：假删除。
     *
     * @param userDeleteStandard 删除用户的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "删除用户", notes = "管理员删除用户。")
    @PostMapping(value = "/user/delete")
    public HttpResponse userDelete(@RequestBody UserDeleteStandard userDeleteStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员根据手机号模糊查找用户。
     *
     * @param userFindByMobileStandard 根据手机号模糊查找用户的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据手机号模糊查找用户", notes = "管理员根据手机号模糊查找用户。")
    @PostMapping(value = "/user/find/mobile")
    public HttpResponse userFindByMobile(@RequestBody UserFindByMobileStandard userFindByMobileStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员根据姓名模糊查找用户。
     *
     * @param userFindByNameStandard 根据姓名模糊查找用户的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据姓名模糊查找用户", notes = "管理员根据姓名模糊查找用户。")
    @PostMapping(value = "/user/find/name")
    public HttpResponse userFindByName(@RequestBody UserFindByNameStandard userFindByNameStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员根据组织编号查找用户：可查询获得所有子节点的用户。
     *
     * @param userFindByOrganizationStandard 根据组织编号查找用户的入参对象。
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据组织编号查找用户", notes = "管理员根据组织编号查找用户。")
    @PostMapping(value = "/user/find/organizationId")
    public HttpResponse userFindByOrganizationId(@RequestBody UserFindByOrganizationStandard userFindByOrganizationStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }
}