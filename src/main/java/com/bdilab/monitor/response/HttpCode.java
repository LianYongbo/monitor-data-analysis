package com.bdilab.monitor.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * http状态码
 *
 * @author Lian
 * @date 2021/2/12 1:19
 **/
public enum HttpCode {
    /**
     * 请求成功，返回状态码200
     */
    OK(200, "请求成功", true),
    /**
     * 参数错误，请求失败，返回状态码1001
     */
    PARAMETER_ERROR(1001, "参数错误", false),
    /**
     * 请求未授权，请求失败，返回状态码1002
     */
    UNAUTHORIZED(1002, "请求未授权", false),
    /**
     * 请求被禁止，请求失败，返回状态码1003
     */
    FORBIDDEN(1003, "请求被禁止", false),
    /**
     * 资源不存在，请求失败，返回状态码404
     */
    NOT_FOUND(404, "资源不存在", false);
    @ApiModelProperty(value = "状态码", required = true)
    private int code;
    @ApiModelProperty(value = "状态信息", required = true)
    private String message;
    @ApiModelProperty(value = "请求是否成功", required = true)
    private boolean successful;

    HttpCode(int code, String message, boolean successful) {
        this.code = code;
        this.message = message;
        this.successful = successful;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
