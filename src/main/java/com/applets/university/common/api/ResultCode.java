package com.applets.university.common.api;

/**
 * @author shw
 * @date 2020/11/29 15:52
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(200,"操作成功"),
    /**
     * 失败
     */
    FAILED(500,"操作失败"),

    /**
     * 没有认证
     */
    UNAUTHENTICATION(401,"未登录或登陆过期");


    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}