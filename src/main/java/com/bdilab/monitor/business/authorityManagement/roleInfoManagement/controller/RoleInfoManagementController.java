package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.controller;

import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.conversion.RoleCreateUpdateConversion;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.conversion.RoleDeleteConversion;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.conversion.RoleFindByNameZhConversion;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.conversion.RoleViewConversion;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Menu;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business.Role;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleCreateStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleDeleteStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleFindByNameZhStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.standard.RoleUpdateStandard;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view.RoleDeleteView;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.view.RoleView;
import com.bdilab.monitor.business.authorityManagement.roleInfoManagement.service.RoleInfoManagementService;
import com.bdilab.monitor.response.HttpCode;
import com.bdilab.monitor.response.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    private final RoleDeleteConversion roleDeleteConversion;
    private final RoleFindByNameZhConversion roleFindByNameZhConversion;
    private final RoleViewConversion roleViewConversion;
    private final RoleCreateUpdateConversion roleCreateUpdateConversion;
    private final RoleInfoManagementService roleInfoManagementService;

    public RoleInfoManagementController(RoleCreateUpdateConversion roleCreateUpdateConversion, RoleDeleteConversion roleDeleteConversion, RoleFindByNameZhConversion roleFindByNameZhConversion, RoleViewConversion roleViewConversion, RoleInfoManagementService roleInfoManagementService) {
        this.roleCreateUpdateConversion = roleCreateUpdateConversion;
        this.roleDeleteConversion = roleDeleteConversion;
        this.roleFindByNameZhConversion = roleFindByNameZhConversion;
        this.roleViewConversion = roleViewConversion;
        this.roleInfoManagementService = roleInfoManagementService;
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
     * 管理员创建角色。
     *
     * @param roleCreateStandard 创建角色的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "创建角色", notes = "管理员创建角色。")
    @PostMapping(value = "/role/create")
    public HttpResponse roleCreate(@RequestBody RoleCreateStandard roleCreateStandard) {
        Role roleConverted = roleCreateUpdateConversion.conversionToRole(roleCreateStandard);
        List<Menu> menusConverted = roleCreateUpdateConversion.conversionToMenu(roleCreateStandard);
        if (roleConverted == null || menusConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Role roleAfterCreation = roleInfoManagementService.roleCreate(roleConverted, menusConverted);
        List<Menu> menusRoutingAfterSearching = roleInfoManagementService.routingFindByRoleId(roleAfterCreation);
        List<Menu> menusButtonAfterSearching = roleInfoManagementService.buttonFindByRoleId(roleAfterCreation);
        if (roleAfterCreation == null || menusRoutingAfterSearching == null || menusButtonAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        RoleView data = roleViewConversion.conversion(roleAfterCreation, menusRoutingAfterSearching, menusButtonAfterSearching);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
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
        Role roleConverted = roleCreateUpdateConversion.conversionToRole(updateStandard);
        List<Menu> menusConverted = roleCreateUpdateConversion.conversionToMenu(updateStandard);
        if (roleConverted == null || menusConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Role roleAfterCreation = roleInfoManagementService.roleUpdate(roleConverted, menusConverted);
        List<Menu> menusRoutingAfterSearching = roleInfoManagementService.routingFindByRoleId(roleAfterCreation);
        List<Menu> menusButtonAfterSearching = roleInfoManagementService.buttonFindByRoleId(roleAfterCreation);
        if (roleAfterCreation == null || menusRoutingAfterSearching == null || menusButtonAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        RoleView data = roleViewConversion.conversion(roleAfterCreation, menusRoutingAfterSearching, menusButtonAfterSearching);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员删除角色。
     *
     * @param roleDeleteStandard 删除角色的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "删除角色", notes = "管理员删除角色。")
    @PostMapping(value = "/role/delete")
    public HttpResponse roleDelete(@RequestBody RoleDeleteStandard roleDeleteStandard) {
        Role roleConverted = roleDeleteConversion.conversion(roleDeleteStandard);
        if (roleConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Role roleAfterDelete = roleInfoManagementService.roleDelete(roleConverted);
        if (roleAfterDelete != null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        RoleDeleteView data = roleDeleteConversion.conversion((Role) null);
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员获取所有的角色信息。
     *
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "获取所有的角色信息", notes = "管理员获取所有的角色信息。")
    @GetMapping(value = "/role/find/all")
    public HttpResponse roleFindAll() {
        List<Role> rolesAfterSearching = roleInfoManagementService.roleFindAll();
        if (rolesAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<Menu> menusRoutingAfterSearching = new ArrayList<>();
        List<Menu> menusButtonAfterSearching = new ArrayList<>();
        for (Role role : rolesAfterSearching) {
            List<Menu> routings = roleInfoManagementService.routingFindByRoleId(role);
            List<Menu> button = roleInfoManagementService.buttonFindByRoleId(role);
            menusRoutingAfterSearching.addAll(routings);
            menusButtonAfterSearching.addAll(button);
        }
        List<RoleView> data = new ArrayList<>();
        for (Role role : rolesAfterSearching) {
            RoleView roleView = roleViewConversion.conversion(role, menusRoutingAfterSearching, menusButtonAfterSearching);
            if (roleView == null) {
                return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
            }
            data.add(roleView);
        }
        return new HttpResponse(HttpCode.OK, data);
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
        Role roleConverted = roleFindByNameZhConversion.conversion(roleFindByNameZhStandard);
        if (roleConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<Role> rolesAfterSearching = roleInfoManagementService.roleFindByNameZh(roleConverted);
        if (rolesAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<Menu> menusRoutingAfterSearching = new ArrayList<>();
        List<Menu> menusButtonAfterSearching = new ArrayList<>();
        for (Role role : rolesAfterSearching) {
            List<Menu> routings = roleInfoManagementService.routingFindByRoleId(role);
            List<Menu> button = roleInfoManagementService.buttonFindByRoleId(role);
            menusRoutingAfterSearching.addAll(routings);
            menusButtonAfterSearching.addAll(button);
        }
        List<RoleView> data = new ArrayList<>();
        for (Role role : rolesAfterSearching) {
            RoleView roleView = roleViewConversion.conversion(role, menusRoutingAfterSearching, menusButtonAfterSearching);
            if (roleView == null) {
                return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
            }
            data.add(roleView);
        }
        return new HttpResponse(HttpCode.OK, data);
    }
}
