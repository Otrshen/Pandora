package com.shenming.pandora.controller;

import com.alibaba.fastjson.JSON;
import com.shenming.pandora.domain.SubscribeEmail;
import com.shenming.pandora.model.ResponseEntity;
import com.shenming.pandora.service.SubscribeEmailService;
import com.shenming.pandora.util.ResponseErrorUtil;
import com.shenming.pandora.util.exception.ClientException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;

@Api("邮件模块")
@RestController
@RequestMapping("/email")
public class EmailNotifyController {

    @Autowired
    private SubscribeEmailService subscribeEmailService;

    /**
    * @Description: 用于获取服务状态
    * @Params: []
    * @return: java.lang.String
    * @Author: 申铭
    * @Date: 2021/3/19
    */
    @ApiIgnore
    @RequestMapping("status")
    public HashMap<String, String> emailNotify() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("status", "1");
        return map;
    }

    /** 
    * @Description: 订阅邮件通知
    * @Params: []
    * @return: java.lang.String
    * @Author: 申铭
    * @Date: 2021/3/23
    */
    @PostMapping("/subscribe/notification")
    @ApiOperation(value = "订阅未读邮件通知", notes = "订阅未读邮件通知_notes")
    @ApiImplicitParams({@ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", example = "shenming@eetrust.com")})
    public String subscribeNotification(@RequestParam String email) {
        try {
            subscribeEmailService.addSubscribeEmail(email);
            HashMap<String, String> map = new HashMap();
            map.put("emailAddress", email);
            ResponseEntity entity = new ResponseEntity(map);
            return JSON.toJSONString(entity);
        } catch (ClientException e) {
            ResponseEntity entity = ResponseErrorUtil.convertException(e);
            return JSON.toJSONString(entity);
        }
    }

    /**
    * @Description: 获取所有订阅用户
    * @Params: []
    * @return: java.lang.String
    * @Author: 申铭
    * @Date: 2021/3/24
    */
    @ApiOperation(value = "获取所有订阅用户", produces = "application/json")
    @GetMapping("/subscribe/notification")
    public String queryAllSubscribeEmail() {
        List<SubscribeEmail> list = subscribeEmailService.queryAllSubscribeEmail();
        ResponseEntity entity = new ResponseEntity(list);

        return JSON.toJSONString(entity);
    }
}
