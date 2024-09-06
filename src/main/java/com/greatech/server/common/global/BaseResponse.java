package com.greatech.server.common.global;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description = "返回响应数据结构类")
public class BaseResponse<T> {

    @Schema(name = "协议代码", type = "int")
    int httpStatusCode;
    @Schema(name = "数据体", type = "T")
    T data;
    @Schema(name = "错误异常", type = "GlobalResponseError")
    GlobalResponseError error;
    @Schema(name = "时间戳", type = "Date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date timestamp;

    BaseResponse() {

    }

    public BaseResponse(GlobalResponseStatus globalResponseStatus, T data) {
        GlobalResponseError globalResponseError = new GlobalResponseError();
        globalResponseError.setCode(globalResponseStatus.getValue());
        globalResponseError.setMessage(globalResponseStatus.getReasonPhrase());
        this.error = globalResponseError;
        this.data = data;
    }

    public BaseResponse(GlobalResponseStatus globalResponseStatus) {
        GlobalResponseError globalResponseError = new GlobalResponseError();
        globalResponseError.setCode(globalResponseStatus.getValue());
        globalResponseError.setMessage(globalResponseStatus.getReasonPhrase());
        this.error = globalResponseError;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public GlobalResponseError getError() {
        return error;
    }

    public void setError(GlobalResponseError error) {
        this.error = error;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
