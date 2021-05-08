package com.shenming.pandora.service.impl;

import com.shenming.pandora.pojo.SubscribeEmail;
import com.shenming.pandora.mapper.SubscribeEmailMapper;
import com.shenming.pandora.service.JPushService;
import com.shenming.pandora.service.SubscribeEmailService;
import com.shenming.pandora.util.exception.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订阅邮箱通知服务类
 *
 * @author: 申铭
 * @create: 2021-03-26 14:55
 **/

@Service
public class SubscribeEmailServiceImpl implements SubscribeEmailService {

    @Autowired
    private JPushService jPushService;
    @Autowired
    private SubscribeEmailMapper subscribeEmailMapper;

    @Override
    public void addSubscribeEmail(String email)  throws ClientException {
        SubscribeEmail tEmail = subscribeEmailMapper.findByEmail(email);
        if (tEmail == null) {
            SubscribeEmail subscribeEmail = new SubscribeEmail();
            subscribeEmail.setEmailAddress(email);
            subscribeEmailMapper.add(subscribeEmail);
        } else {
            // 删除该邮箱之前绑定的别名
            jPushService.deleteAlias(email);
//            throw new ClientException(ErrorContants.EMAIL_EXISTED, "此邮箱已订阅通知");
        }
    }

    @Override
    public List<SubscribeEmail> queryAllSubscribeEmail() {
        return subscribeEmailMapper.queryAll();
    }
}
