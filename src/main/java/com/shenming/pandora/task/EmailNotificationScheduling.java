package com.shenming.pandora.task;

import com.shenming.pandora.domain.SubscribeEmail;
import com.shenming.pandora.pojo.Email;
import com.shenming.pandora.service.EmailService;
import com.shenming.pandora.service.JPushService;
import com.shenming.pandora.service.SubscribeEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailNotificationScheduling {

    @Autowired
    private EmailService emailService;
    @Autowired
    private SubscribeEmailService subscribeEmailService;
    @Autowired
    private JPushService jPushService;
    
    /** 
    * @Description: 定时任务
    * @Params: []
    * @return: void
    * @Author: 申铭
    * @Date: 2021/3/19
    */
//    @Scheduled(cron = "0/5 * * * * ?")
    @Scheduled(cron = "0 0/15 * * * ?")
    public void getUnreadEmailAndPush() {
        // 获取所有订阅邮箱
        List<SubscribeEmail> emails = subscribeEmailService.queryAllSubscribeEmail();

        for (SubscribeEmail email: emails) {
            String emailAddress = email.getEmailAddress();
            // 获取该订阅邮箱所有未读邮件
            ArrayList<Email> unreadEmails = emailService.getUnreadEmails(emailAddress);

            for (Email unreadEmail : unreadEmails) {
                // 判断是否已推送过此未读邮件
                if (emailService.findByMsgUID(unreadEmail.getMsgUID()) != null) { continue; }

                try {
                    String body = "《" + unreadEmail.getSubject() + "》";
                    jPushService.push(emailAddress, "你有一封未读邮件：", body);

                    // 推送成功后记录下，以避免下次重复推送
                    unreadEmail.setEmailAddress(email.getEmailAddress());
                    emailService.add(unreadEmail);
                } catch (Exception e) { }
            }
        }
    }
}
