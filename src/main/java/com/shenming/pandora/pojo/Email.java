package com.shenming.pandora.pojo;

/*
    "dateTime": 1615433295000,
    "subject": "【培训时间微调】2021年3月上旬-4.4培训预告~",
    "receiveDateString": "2021-03-11",
    "seen": "Y",
    "url": "http://117.107.197.44:80/safemail/portal/AuthLoginMail.xhtm?method=showUnreadMail&msgnum=1138&title=%E3%80%90%E5%9F%B9%E8%AE%AD%E6%97%B6%E9%97%B4%E5%BE%AE%E8%B0%83%E3%80%912021%E5%B9%B43%E6%9C%88%E4%B8%8A%E6%97%AC-4.4%E5%9F%B9%E8%AE%AD%E9%A2%84%E5%91%8A%7E/&ticket=shenyn@eetrust.com&authMethod=mw",
    "msgUID": "1138"
* */

import java.io.Serializable;

public class Email implements Serializable {

    private static final long serialVersionUID = -4087474994081093915L;

    // 邮件ID
    private String msgUID;
    // 邮件主题
    private String subject;
    // 是否已阅读 Y:已阅读 N:未阅读
    private String seen;
    // 邮箱地址
    private String emailAddress;

    public String getMsgUID() {
        return msgUID;
    }

    public void setMsgUID(String msgUID) {
        this.msgUID = msgUID;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSeen() {
        return seen;
    }

    public void setSeen(String seen) {
        this.seen = seen;
    }

    @Override
    public String toString() {
        return "Email{" +
                "subject='" + subject + '\'' +
                ", seen='" + seen + '\'' +
                '}';
    }
}
