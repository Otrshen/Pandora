package com.shenming.pandora.model;

import java.io.Serializable;

/**
 * 详细错误描述
 *
 * @author: 申铭
 * @create: 2021-03-23 17:00
 **/

public class ErrorEntity extends ResponseEntity implements Serializable {

    private static final long serialVersionUID = 1462978001846357682L;

    // 错误码
    private String code;
    // 错误信息
    private String message;
    // 错误数据
    private String errorData;

    public ErrorEntity() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorData() {
        return errorData;
    }

    public void setErrorData(String errorData) {
        this.errorData = errorData;
    }
}
