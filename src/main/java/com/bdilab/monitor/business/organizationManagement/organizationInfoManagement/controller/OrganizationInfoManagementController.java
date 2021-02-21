package com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.controller;

import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.conversion.*;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.business.Organization;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.standard.*;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.view.OrganizationFindByIdView;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.view.OrganizationFindByNameView;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.model.view.OrganizationFindByParentIdView;
import com.bdilab.monitor.business.organizationManagement.organizationInfoManagement.service.OrganizationInfoManagementService;
import com.bdilab.monitor.response.HttpCode;
import com.bdilab.monitor.response.HttpResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 组织管理模块
 * 组织信息管理子模块业务接口
 *
 * @author Lian
 * @date 2021/2/18 17:29
 **/
@RestController
@Api(value = "组织信息管理子模块")
public class OrganizationInfoManagementController {
    private final OrganizationCreateConversion organizationCreateConversion;
    private final OrganizationUpdateConversion organizationUpdateConversion;
    private final OrganizationDeleteConversion organizationDeleteConversion;
    private final OrganizationFindByNameConversion organizationFindByNameConversion;
    private final OrganizationFindByParentIdConversion organizationFindByParentIdConversion;
    private final OrganizationFindByIdConversion organizationFindByIdConversion;
    private final OrganizationInfoManagementService organizationInfoManagementService;

    public OrganizationInfoManagementController(OrganizationInfoManagementService organizationInfoManagementService, OrganizationCreateConversion organizationCreateConversion, OrganizationUpdateConversion organizationCreateStandard, OrganizationUpdateConversion organizationUpdateConversion, OrganizationDeleteConversion organizationDeleteConversion, OrganizationFindByNameConversion organizationFindByNameConversion, OrganizationFindByParentIdConversion organizationFindByParentIdConversion, OrganizationFindByIdConversion organizationFindByIdConversion) {
        this.organizationInfoManagementService = organizationInfoManagementService;
        this.organizationCreateConversion = organizationCreateConversion;
        this.organizationUpdateConversion = organizationUpdateConversion;
        this.organizationDeleteConversion = organizationDeleteConversion;
        this.organizationFindByNameConversion = organizationFindByNameConversion;
        this.organizationFindByParentIdConversion = organizationFindByParentIdConversion;
        this.organizationFindByIdConversion = organizationFindByIdConversion;
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
     * 管理员创建组织。
     *
     * @param organizationCreateStandard 创建组织的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "创建组织", notes = "管理员创建组织。")
    @PostMapping(value = "/organization/create")
    public HttpResponse organizationCreate(@RequestBody OrganizationCreateStandard organizationCreateStandard) {
        Organization organizationConverted = organizationCreateConversion.conversion(organizationCreateStandard);
        if (organizationConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Organization organizationAfterCreation = organizationInfoManagementService.organizationCreate(organizationConverted);
        if (organizationAfterCreation == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Object data = organizationCreateConversion.conversion(organizationAfterCreation);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员修改组织信息。
     *
     * @param organizationUpdateStandard 修改组织信息的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "修改组织信息", notes = "管理员修改组织信息。")
    @PostMapping(value = "/organization/update")
    public HttpResponse organizationUpdate(@RequestBody OrganizationUpdateStandard organizationUpdateStandard) {
        Organization organizationConverted = organizationUpdateConversion.conversion(organizationUpdateStandard);
        if (organizationConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Organization organizationUpdated = organizationInfoManagementService.organizationUpdate(organizationConverted);
        if (organizationUpdated == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Object data = organizationUpdateConversion.conversion(organizationUpdated);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员删除组织：假删除。
     *
     * @param organizationDeleteStandard 删除组织的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "删除组织", notes = "管理员删除组织。")
    @PostMapping(value = "/organization/delete")
    public HttpResponse organizationDelete(@RequestBody OrganizationDeleteStandard organizationDeleteStandard) {
        Organization organizationConverted = organizationDeleteConversion.conversion(organizationDeleteStandard);
        if (organizationConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Organization organizationDeleted = organizationInfoManagementService.organizationDelete(organizationConverted);
        if (organizationDeleted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Object data = organizationDeleteConversion.conversion(organizationDeleted);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员根据名称查找组织。
     *
     * @param organizationFindByNameStandard 根据名称查找组织的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据名称查找组织", notes = "管理员根据名称查找组织。")
    @PostMapping(value = "/organization/find/name")
    public HttpResponse organizationFindByName(@RequestBody OrganizationFindByNameStandard organizationFindByNameStandard) {
        Organization organizationConverted = organizationFindByNameConversion.conversion(organizationFindByNameStandard);
        if (organizationConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<Organization> organizationsAfterSearching = organizationInfoManagementService.organizationFindByName(organizationConverted);
        if (organizationsAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<OrganizationFindByNameView> data = new ArrayList<>();
        for (Organization organization : organizationsAfterSearching) {
            OrganizationFindByNameView organizationFindByNameView = organizationFindByNameConversion.conversion(organization);
            if (organizationFindByNameView == null) {
                return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
            }
            data.add(organizationFindByNameView);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员根据编号查找组织。
     *
     * @param organizationFindByIdStandard 根据编号查找组织的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据编号查找组织", notes = "管理员根据编号查找组织。")
    @PostMapping(value = "/organization/find/id")
    public HttpResponse organizationFindById(@RequestBody OrganizationFindByIdStandard organizationFindByIdStandard) {
        Organization organizationConverted = organizationFindByIdConversion.conversion(organizationFindByIdStandard);
        if (organizationConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        Organization organizationsAfterSearching = organizationInfoManagementService.organizationFindById(organizationConverted);
        if (organizationsAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        OrganizationFindByIdView data = organizationFindByIdConversion.conversion(organizationsAfterSearching);
        if (data == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        return new HttpResponse(HttpCode.OK, data);
    }

    /**
     * 管理员根据父组织编号查找组织。
     *
     * @param organizationFindByParentIdStandard 根据父组织编号查找组织的入参对象
     * @return 状态码、状态信息、请求是否成功、出参对象
     */
    @ApiOperation(value = "根据父组织编号查找组织", notes = "管理员根据父组织编号查找组织。")
    @PostMapping(value = "/organization/find/parentId")
    public HttpResponse organizationFindByParentId(@RequestBody OrganizationFindByParentIdStandard organizationFindByParentIdStandard) {
        Organization organizationConverted = organizationFindByParentIdConversion.conversion(organizationFindByParentIdStandard);
        if (organizationConverted == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<Organization> organizationsAfterSearching = organizationInfoManagementService.organizationFindByParentId(organizationConverted);
        if (organizationsAfterSearching == null) {
            return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
        }
        List<OrganizationFindByParentIdView> data = new ArrayList<>();
        for (Organization organization : organizationsAfterSearching) {
            OrganizationFindByParentIdView organizationFindByParentIdView = organizationFindByParentIdConversion.conversion(organization);
            if (organizationFindByParentIdView == null) {
                return new HttpResponse(HttpCode.PARAMETER_ERROR, null);
            }
            data.add(organizationFindByParentIdView);
        }
        return new HttpResponse(HttpCode.OK, data);
    }
}
