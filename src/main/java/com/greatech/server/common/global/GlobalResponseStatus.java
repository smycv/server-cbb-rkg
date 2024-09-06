package com.greatech.server.common.global;

public enum GlobalResponseStatus {
    //请求成功
    SUCCESS(0, " "),
    //
    UNKNOWN_EXCEPTION(-1, "未知异常"),
    //
    UNAUTHORIZED_EXCEPTION(10, "未认证，权限禁止操作！"),
    INSUFFICIENT_PRIVILEGES_EXCEPTION(11, "已认证，权限不足！"),

    ONLY_ADMIN_PRIVILEGES_EXCEPTION(11, "已认证，权限不足！当前接口仅允许超级管理员调用"),
    //
    PARAMTYPEMISMATCH_EXCEPTION(20, "参数类型异常！"),
    PARAMMISSING_EXCEPTION(21, "参数缺失异常！"),
    PARAMISNULL_EXCEPTION(22, "参数为空异常！"),
    ORDERPARAM_EXCEPTION(23, "排序参数异常！"),

    PAGE_EXCEPTION(24, "分页页数参数异常！"),
    PAGE_SIZE_EXCEPTION(25, "分页大小参数异常！"),

    SERVICE_EXCEPTION(30, "服务执行异常！"),
    DATABASE_EXCEPTION(31, "数据库执行异常！"),

    //login
    SMSERROR_EXCEPTION(1000, "短信验证码错误，请您重新输入！"),
    SMSSEND_EXCEPTION(1001, "短信验证码发送失败，请您再次尝试！"),
    KAPTCHAERROR_EXCEPTION(1002, "kaptcha验证码错误，请您重新输入！"),
    CAPTCHAIOERROR_EXCEPTION(1003, "Captcha验证码生成IO错误！"),
    CAPTCHAERROR_EXCEPTION(1004, "Captcha验证码填写错误，请您重新输入！"),
    CAPTCHAEXPIREDERROR_EXCEPTION(1005, "Captcha验证码过期，请您重新获取验证码！"),
    APPID_NOT_MATCH_ACCOUNT(1011, "登录账户所属应用与指定应用不匹配"),
    LOGIN_APPID_NULL(1012, "请指定应用ID"),
    LOGIN_ADMIN_REQUIRED(1013, "仅允许管理员账户登录"),

    //account
    ACCOUNTNOTEXIST_EXCEPTION(2000, "账号不存在！"),
    USERINFONOTEXIST_EXCEPTION(2001, "用户信息不存在！"),
    ISNOTMOBILENUMBER_EXCEPTION(2002, "请输入合规手机号！"),
    CELLPHONEISNULL_EXCEPTION(2003, "手机号为空！"),
    CELLPHONEEXIST_EXCEPTION(2004, "手机号已存在！"),
    EMAILEXIST_EXCEPTION(2005, "邮箱已存在！"),
    ACCOUNTISONLINE_EXCEPTION(2006, "用户已经在线！"),
    AUTHENTICATIONTOKENISNULL_EXCEPTION(2007, "令牌为空！"),
    AUTHENTICATIONFAILURE_EXCEPTION(2008, "身份验证失败！"),
    GETAUTHENTICATION_EXCEPTION(2010, "获取用户信息异常！"),
    NEWPASSWORDISNULL_EXCEPTION(2040, "新密码为空！"),
    NEWPASSWORD_NOT_EQUALS_COPY_EXCEPTION(2041, "新密码与重复密码不一致！"),
    OLDPASSOWRD_ERROR_EXCEPTION(2042, "旧密码错误"),


    //application
    APPLICATIONNAMEEXIST_EXCEPTION(3001, "应用名已存在！"),
    APPLICATIONCODEEXIST_EXCEPTION(3002, "应用标识已存在！"),
    APPADMINCOUNT_CREATE_EXCEPTION(3003, "生成对应应用管理员账户异常！"),

    ACCOUNT_SUCCESS_USER_FAILED(3010, "创建账户时生成对应用户失败！"),

    PERMISSIONNAMEEXIST_EXCEPTION(3020, "权限名已存在！"),
    PERMISSIONCODEEXIST_EXCEPTION(3021, "权限标识已存在！"),
    PERMISSIONDONTDENYEXIST_EXCEPTION(3021, "匿名注册不是被拒绝的！"),

    //policy
    POLICYPROPERTYVALUE_EXCEPTION(6001, "策略标识不能修改！"),
    POLICYCODEISEXIST_EXCEPTION(6002, "策略标识不能重名！"),
    POLICYCODEISNOTEXIST_EXCEPTION(6003, "策略标识不能为空！"),
    POLICYNAMEISEXIST_EXCEPTION(6004, "策略名字不能重名！"),

    //org
    ORGNAMEEXIST_EXCEPTION(4001, "组织名已存在！"),
    //org
    ORGAPPID_EXCEPTION(4002, "组织归属APPID与请求不匹配！"),

    //role
    ROLENAMEEXIST_EXCEPTION(6001, "角色名已存在！"),

    //action
    ACTIONNAMEEXIST_EXCEPTION(5001, "操作名已存在！"),

    //resource
    RESOURCENAMEEXIST_EXCEPITON(7001, "资源名称已存在！"),
    RESOURCECODEEXIST_EXCEPITON(7002, "资源标识已存在！"),
    RESOURCEEXIST_EXCEPITON(7003, "资源已存在！"),

    //user
    USERNAMEEXIST_EXCEPITON(8001, "用户名称已存在！");

    private final int value;
    private final String reasonPhrase;

    GlobalResponseStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
