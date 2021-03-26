package com.shenming.pandora.domain;

/**
 * 订阅的邮箱
 *
 * @author: 申铭
 * @create: 2021-03-24 15:02
 **/

public class SubscribeEmail {

    private int id;
    private String emailAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
