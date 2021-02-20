package com.bdilab.mine.business.userManagement.userInfoManagement.model.standard;

import io.swagger.annotations.ApiModelProperty;

/**
 * 审批注册申请入参对象
 *
 * @author Lian
 * @date 2021/2/16 17:58
 **/
public class UserApproveStandard {
    @ApiModelProperty(value = "用户手机号", required = true)
    private String userMobile;
}
