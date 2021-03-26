package com.shenming.pandora.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push")
public class JiGuangController {

    /**
    * @Description: 注册极光推送设备ID
    * @Params: [id]
    * @return: java.lang.String
    * @Author: 申铭
    * @Date: 2021/3/19
    */
    @PostMapping("/registerId")
    public String registerId(@RequestParam String id) {
        return id;
    }
}
