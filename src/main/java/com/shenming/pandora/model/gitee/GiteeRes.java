package com.shenming.pandora.model.gitee;

import java.io.Serializable;

/**
 * gitee Api 返回解析类
 *
 * @author: 申铭
 * @create: 2021-05-08 14:46
 **/

public class GiteeRes implements Serializable {

    private static final long serialVersionUID = -7765804116494694762L;

    private GiteeContent content;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public GiteeContent getContent() {
        return content;
    }

    public void setContent(GiteeContent content) {
        this.content = content;
    }
}
