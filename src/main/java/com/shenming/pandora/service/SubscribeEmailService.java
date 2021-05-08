package com.shenming.pandora.service;

import com.shenming.pandora.pojo.SubscribeEmail;
import com.shenming.pandora.util.exception.ClientException;

import java.util.List;

public interface SubscribeEmailService {

    /**
     * @Description: 添加订阅邮箱
     * @Params: [email]
     * @return: void
     * @Author: 申铭
     * @Date: 2021/3/24
     */
    public void addSubscribeEmail(String email) throws ClientException;

    /**
     * @Description: 查询所有已订阅通知的邮箱
     * @Params: []
     * @return: java.util.List<com.shenming.pandora.pojo.SubscribeEmail>
     * @Author: 申铭
     * @Date: 2021/3/24
     */
    public List<SubscribeEmail> queryAllSubscribeEmail();
}
