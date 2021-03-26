package com.shenming.pandora.util;

import com.alibaba.fastjson.JSON;
import com.shenming.pandora.constant.ErrorContants;
import com.shenming.pandora.model.ErrorEntity;
import com.shenming.pandora.model.ResponseEntity;
import com.shenming.pandora.util.exception.ClientException;

/**
 * 网路请求返回工具类，转json,以及记录日志
 *
 * @author: 申铭
 * @create: 2021-03-23 17:16
 **/

public class ResponseErrorUtil {
    /**
    * @Description: 将ClientException转换为ResponseEntity
    * @Params: [e]
    * @return: com.shenming.pandora.model.ResponseEntity
    * @Author: 申铭
    * @Date: 2021/3/24
    */
    static public ResponseEntity convertException(ClientException e) {
        ErrorEntity entity = new ErrorEntity();
        entity.setStatus(ErrorContants.RESPONSE_STATUS_FAILURE);
        entity.setCode(e.getCode());
        entity.setMessage(e.getMessage());
        entity.setErrorData(JSON.toJSONString(e.getData()));
        return entity;
    }

    static public ResponseEntity convertException(Exception e) {
        ErrorEntity entity = new ErrorEntity();
        entity.setStatus(ErrorContants.RESPONSE_STATUS_FAILURE);
        entity.setCode(ErrorContants.UNKNOWN);
        entity.setMessage(e.getMessage());
        return entity;
    }
}
