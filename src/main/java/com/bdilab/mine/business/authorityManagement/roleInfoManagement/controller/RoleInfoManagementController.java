package com.bdilab.mine.business.authorityManagement.roleInfoManagement.controller;

import com.bdilab.mine.business.authorityManagement.roleInfoManagement.conversion.RoleCreateConversion;
import com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.business.Role;
import com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.standard.RoleCreateStandard;
import com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.standard.RoleDeleteStandard;
import com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.standard.RoleFindByNameZhStandard;
import com.bdilab.mine.business.authorityManagement.roleInfoManagement.model.standard.RoleUpdateStandard;
import com.bdilab.mine.response.HttpCode;
import com.bdilab.mine.response.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限管理模块
 * 角色信息管理子模块业务接口
 *
 * @author Lian
 * @date 2021/2/16 21:56
 **/
@RestController
@Api(value = "角色信息管理子模块")
public class RoleInfoManagementController {
    private final RoleCreateConversion roleCreateConversion;

    public RoleInfoManagementController(RoleCreateConversion roleCreateConversion) {
        this.roleCreateConversion = roleCreateConversion;
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
     * Step 4 ： 业务对象校验
     * Step 5 ： 业务对象数据结构转换（为出参）
     * <p>
     * 管理员创建角色。
     *
     * @param roleCreateStandard 创建角色的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "创建角色", notes = "管理员创建角色。")
    @PostMapping(value = "/role/create")
    public HttpResponse roleCreate(@RequestBody RoleCreateStandard roleCreateStandard) {
        Role role = roleCreateConversion.conversion(roleCreateStandard);
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员修改角色信息。
     *
     * @param updateStandard 修改角色信息的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "修改角色信息", notes = "管理员修改角色信息。")
    @PostMapping(value = "/role/update")
    public HttpResponse roleUpdate(@RequestBody RoleUpdateStandard updateStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员删除角色：假删除。
     *
     * @param roleDeleteStandard 删除角色的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "删除角色", notes = "管理员删除角色。")
    @PostMapping(value = "/role/delete")
    public HttpResponse roleDelete(@RequestBody RoleDeleteStandard roleDeleteStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员获取所有的角色信息。
     *
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "获取所有的角色信息", notes = "管理员获取所有的角色信息。")
    @GetMapping(value = "/role/find/all")
    public HttpResponse roleFindAll() {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }

    /**
     * 管理员根据中文名称查找角色。
     *
     * @param roleFindByNameZhStandard 根据中文名称查找角色的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据中文名称查找角色", notes = "管理员根据中文名称查找角色。")
    @PostMapping(value = "/role/find/nameZh")
    public HttpResponse roleFindByNameZh(@RequestBody RoleFindByNameZhStandard roleFindByNameZhStandard) {
        Object data = "";
        return new HttpResponse(HttpCode.PARAMETER_ERROR, data);
    }
}
