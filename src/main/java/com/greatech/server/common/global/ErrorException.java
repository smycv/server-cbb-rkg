package com.greatech.server.common.global;

import org.springframework.http.HttpStatus;

public class ErrorException extends RuntimeException {

    private int httpStatusValue;

    private GlobalResponseStatus globalResponseStatus = GlobalResponseStatus.UNKNOWN_EXCEPTION;

    public ErrorException() {
        super(GlobalResponseStatus.UNKNOWN_EXCEPTION.getReasonPhrase());
    }

    public ErrorException(String message) {
        super(message);
    }

    public ErrorException(HttpStatus httpStatus, GlobalResponseStatus globalResponseStatus) {
        super(globalResponseStatus.getReasonPhrase());
        this.globalResponseStatus = globalResponseStatus;
        this.httpStatusValue = httpStatus.value();
    }

    public GlobalResponseStatus getGlobalResponseStatus() {
        return globalResponseStatus;
    }

    public void setGlobalResponseStatus(GlobalResponseStatus globalResponseStatus) {
        this.globalResponseStatus = globalResponseStatus;
    }

    public int getHttpStatusValue() {
        return httpStatusValue;
    }

    public void setHttpStatusValue(int httpStatusValue) {
        this.httpStatusValue = httpStatusValue;
    }
}
