package com.bdilab.monitor.business.authorityManagement.roleInfoManagement.model.business;

import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单业务对象
 *
 * @author Lian
 * @date 2021/2/20 23:06
 **/
public class Menu {
    @ApiModelProperty(value = "菜单编号", required = true)
    private String menuId;
    @ApiModelProperty(value = "菜单类型", required = true, notes = "1：路由；2：按钮")
    private Integer menuType;
    @ApiModelProperty(value = "路由模块名称", required = true)
    private String menuTitle;
    @ApiModelProperty(value = "路由地址", required = true)
    private String menuKey;
    @ApiModelProperty(value = "按钮名称", required = true)
    private String menuLabel;
    @ApiModelProperty(value = "按钮地址", required = true)
    private String menuValue;
    @ApiModelProperty(value = "按钮对应接口url", required = true)
    private String menuPattern;
    @ApiModelProperty(value = "父菜单编号", required = true)
    private String menuParentId;
    @ApiModelProperty(value = "备注")
    private String menuRemark;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public String getMenuValue() {
        return menuValue;
    }

    public void setMenuValue(String menuValue) {
        this.menuValue = menuValue;
    }

    public String getMenuPattern() {
        return menuPattern;
    }

    public void setMenuPattern(String menuPattern) {
        this.menuPattern = menuPattern;
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuRemark() {
        return menuRemark;
    }

    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark;
    }
}
