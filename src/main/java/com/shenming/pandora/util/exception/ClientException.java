package com.shenming.pandora.util.exception;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * 自定义异常
 *
 * @author: 申铭
 * @create: 2021-03-23 17:23
 **/

public class ClientException extends Exception {

    private static final long serialVersionUID = -8433565029896992237L;

    // 错误码
    private String code;
    // 错误数据
    private Map<String,Object> data;

    public ClientException(String code, String info) {
        super(info);

        this.code = code;
    }

    public ClientException(String code, String info, Map<String, Object> data) {
        super(info);

        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
