package com.applets.university.common.exception;

import com.applets.university.common.api.ResultCode;

/**
 * @author shw
 * @date 2020/11/29 16:24
 */
public class ApiException extends RuntimeException {

    private ResultCode resultCode;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }
}