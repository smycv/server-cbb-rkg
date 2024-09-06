package com.greatech.server.common.global;


import com.greatech.server.common.lang.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.beans.PropertyEditorSupport;
import java.util.Date;

/**
 * Controller 增强器
 * Spring 统一异常捕获处理返回
 */
@Slf4j
@RestControllerAdvice
@ResponseBody
public class GlobalControllerAdvice {



    /**
     * 接收日期的String 转 Date
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
        });
    }


    @ExceptionHandler(ErrorException.class)
    public <T> BaseResponse<T> errorException(ErrorException e) {
        e.printStackTrace();
        BaseResponse<T> baseResponse = new BaseResponse<T>(e.getGlobalResponseStatus());
        baseResponse.setHttpStatusCode(e.getHttpStatusValue());
        baseResponse.setTimestamp(DateUtils.getGMT8Time());
        baseResponse.getError().setMessage(e.getMessage());
        return baseResponse;
    }

    //400错误-参数类型不匹配
    @ExceptionHandler({TypeMismatchException.class})
    public <T> BaseResponse<T> requestTypeMismatch(TypeMismatchException e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        BaseResponse<T> baseResponse = new BaseResponse<T>(GlobalResponseStatus.PARAMTYPEMISMATCH_EXCEPTION);
        baseResponse.setHttpStatusCode(400);
        baseResponse.setTimestamp(DateUtils.getGMT8Time());
        baseResponse.getError().setMessage(e.getMessage());
        return baseResponse;
    }

    //400错误-参数缺失
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public <T> BaseResponse<T> requestMissingServletRequestParameter(MissingServletRequestParameterException e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        BaseResponse<T> baseResponse = new BaseResponse<T>(GlobalResponseStatus.PARAMMISSING_EXCEPTION);
        baseResponse.setHttpStatusCode(400);
        baseResponse.setTimestamp(DateUtils.getGMT8Time());
        baseResponse.getError().setMessage(e.getMessage());
        return baseResponse;
    }

    //500 valid-参数异常
    @ExceptionHandler({BindException.class})
    public <T> BaseResponse<T> BindException(BindException e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        BaseResponse<T> baseResponse = new BaseResponse<T>(GlobalResponseStatus.SERVICE_EXCEPTION);
        baseResponse.setHttpStatusCode(500);
        baseResponse.setTimestamp(DateUtils.getGMT8Time());
        baseResponse.getError().setMessage(e.getFieldError().getDefaultMessage());
        return baseResponse;
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    public <T> BaseResponse<T> exception(Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        BaseResponse<T> baseResponse = new BaseResponse<T>(GlobalResponseStatus.SERVICE_EXCEPTION);
        baseResponse.setHttpStatusCode(500);
        baseResponse.setTimestamp(DateUtils.getGMT8Time());
        baseResponse.getError().setMessage(e.getMessage());
        return baseResponse;
    }
}