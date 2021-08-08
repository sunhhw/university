package com.applets.university.common.exception;

import com.applets.university.common.api.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shw
 * @date 2020/11/29 16:24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public AjaxResult apiHandler(ApiException e) {
        if (e.getResultCode() != null) {
            return AjaxResult.failed(e.getResultCode());
        }
        return AjaxResult.failed(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public AjaxResult exceptionHandler(Exception e) {
        return AjaxResult.failed("系统异常");
    }

}