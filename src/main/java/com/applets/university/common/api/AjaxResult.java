package com.applets.university.common.api;

/**
 * @author shw
 * @date 2020/11/29 15:46
 */
public class AjaxResult<T> {

    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;

    public AjaxResult() {
    }

    public AjaxResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 操作成功
     */
    public static <T> AjaxResult<T> success(T data) {
        return new AjaxResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> AjaxResult<T> success() {
        return new AjaxResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> AjaxResult<T> success(T data,String message) {
        return new AjaxResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 操作失败
     */
    public static <T> AjaxResult<T> failed (){
        return new AjaxResult<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }

    public static <T> AjaxResult<T> failed (String message){
        return new AjaxResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> AjaxResult<T> failed (ResultCode resultCode){
        return new AjaxResult<T>(resultCode.getCode(), resultCode.getMessage(), null);
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}