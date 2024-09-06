package com.greatech.server.common.global;


import com.greatech.server.common.lang.DateUtils;
import org.springframework.http.HttpStatus;

public class SuccessResponse<T> extends BaseResponse<T> {

    public SuccessResponse() {
        super(GlobalResponseStatus.SUCCESS);
        setHttpStatusCode(HttpStatus.OK.value());
        setTimestamp(DateUtils.getGMT8Time());
    }

    public SuccessResponse(T data) {
        super(GlobalResponseStatus.SUCCESS, data);
        setHttpStatusCode(HttpStatus.OK.value());
        setTimestamp(DateUtils.getGMT8Time());
    }

    public static <T> SuccessResponse<T> success(T data) {
        return new SuccessResponse<T>(data);
    }

    public static <T> SuccessResponse<T> success() {
        return new SuccessResponse<T>();
    }
}
