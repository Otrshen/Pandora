package com.shenming.pandora.model;

import com.shenming.pandora.constant.ErrorContants;

import java.io.Serializable;

/**
 * 请求返回类
 *
 * @author: 申铭
 * @create: 2021-03-23 16:01
 **/

public class ResponseEntity implements Serializable {

    private static final long serialVersionUID = -7229918201502810609L;

    // 结果是否成功
    private String status = ErrorContants.RESPONSE_STATUS_SUCCESS;

    private Object data;

    public ResponseEntity() {}

    public ResponseEntity(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
