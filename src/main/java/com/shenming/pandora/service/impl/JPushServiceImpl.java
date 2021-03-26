package com.shenming.pandora.service.impl;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosAlert;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.shenming.pandora.service.JPushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JPushServiceImpl implements JPushService {
    private static final Logger logger = LoggerFactory.getLogger(JPushServiceImpl.class);

    @Value("${jpush_app_key}")
    private String appKey;

    @Value("${jpush_master_secret}")
    private String masterSecret;

    @Override
    public void push(String alias, String title, String body) throws Exception {
        JPushClient client = new JPushClient(masterSecret, appKey);
        PushPayload payload = this.buildPushObject_ios_alert(alias, title, body);
        try {
            PushResult result = client.sendPush(payload);
            if (result.statusCode == 0) {
                logger.info(body + " 推送成功");
            }
        } catch (APIConnectionException e) {
            logger.error(body + " 推送失败：Connection error. Should retry later. ", e);
            throw e;
        } catch (APIRequestException e) {
            logger.error(body + " 推送失败：Error response from JPush server. Should review and fix it. ", e);
            throw e;
        }
    }

    @Override
    public void deleteAlias(String alias) {
        JPushClient client = new JPushClient(masterSecret, appKey);
        try {
            client.deleteAlias(alias, null);
        } catch (Exception e) {
            logger.error("deleteAlias: " + e);
        }
    }

    public PushPayload buildPushObject_ios_alert(String alias, String title, String body) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(IosAlert.newBuilder()
                                        .setTitleAndBody(title, null, body)
                                        .build())
                                .setBadge(1)
                                .setSound("happy")
                                .addExtra("from", "JPush")
                                .build())
                        .build())
                .setOptions(Options.newBuilder()
                        .setApnsProduction(false)
                        .build())
                .build();
    }

}
