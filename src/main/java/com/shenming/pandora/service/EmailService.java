package com.shenming.pandora.service;

import com.shenming.pandora.pojo.Email;

import java.util.ArrayList;

public interface EmailService {

    /**
    * @Description:
    * @Params: [ticket]
    * @return: java.util.ArrayList<com.shenming.pandora.pojo.Email>
    * @Author: 申铭
    * @Date: 2021/3/25
    */
    public ArrayList<Email> getUnreadEmails(String ticket);

    /**
    * @Description: 添加已推送的邮件
    * @Params: [email]
    * @return: void
    * @Author: 申铭
    * @Date: 2021/3/26
    */
    public void add(Email email);

    /**
    * @Description:  根据msgUID查找邮件
    * @Params: [msgUID]
    * @return: com.shenming.pandora.pojo.Email
    * @Author: 申铭
    * @Date: 2021/3/26
    */
    public Email findByMsgUID(String msgUID);
}
