package com.shenming.pandora.constant;

/**
 * 错误常量
 *
 * @author: 申铭
 * @create: 2021-03-23 16:55
 **/

public class ErrorContants {
    // 成功
    public static final String RESPONSE_STATUS_SUCCESS = "1";
    // 失败
    public static final String RESPONSE_STATUS_FAILURE = "-1";
    // 未知错误
    public static final String UNKNOWN = "-10000";

    // 参数错误
    public static final String PARAMETER_ERROR = "1001";
    // token失效
    public static final String ACCESSTOKEN_INVALID = "1450";
    // 已存该订阅人员
    public static final String EMAIL_EXISTED = "2000";
}
