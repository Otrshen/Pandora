package com.shenming.pandora.service.impl;

import com.alibaba.fastjson.JSON;
import com.shenming.pandora.mapper.EmailMapper;
import com.shenming.pandora.pojo.Email;
import com.shenming.pandora.pojo.EmailRes;
import com.shenming.pandora.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${email_ip}")
    private String emailIp;
    @Value("${email_port}")
    private String emailPort;

    @Autowired
    private EmailMapper emailMapper;

    @Override
    public ArrayList<Email> getUnreadEmails(String ticket) {
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> requestMap= new LinkedMultiValueMap();
        requestMap.add("ip", emailIp);
        requestMap.add("port", emailPort);
        requestMap.add("ticket", ticket);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity requestEntity = new HttpEntity(requestMap,headers);
        String eamilsStr = restTemplate.postForObject("http://portal.eetrust.com/admin/email.do?method=unreadEmail",requestEntity, String.class);
        EmailRes emailRes = (EmailRes) JSON.parseObject(eamilsStr, EmailRes.class);

        ArrayList<Email> emails = emailRes.getMails();
        ArrayList<Email> tmpEmails = new ArrayList();

        for (Email email : emails) {
            if (email.getSeen().equals("N")) {
                tmpEmails.add(email);
            }
        }

        return tmpEmails;
    }

    @Override
    public void add(Email email) {
        emailMapper.add(email);
    }

    @Override
    public Email findByMsgUID(String msgUID) {
        return emailMapper.findByMsgUID(msgUID);
    }

}
