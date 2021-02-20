package com.bdilab.monitor.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * http响应
 *
 * @author Lian
 * @date 2021/2/12 1:31
 **/
public class HttpResponse {
    @ApiModelProperty(value = "状态码", required = true)
    private int code;
    @ApiModelProperty(value = "状态信息", required = true)
    private String message;
    @ApiModelProperty(value = "请求是否成功", required = true)
    private boolean successful;
    @ApiModelProperty(value = "展示数据", required = true)
    private Object data;

    public HttpResponse(HttpCode httpCode, Object data) {
        this.code = httpCode.getCode();
        this.message = httpCode.getMessage();
        this.successful = httpCode.isSuccessful();
        this.data = data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
