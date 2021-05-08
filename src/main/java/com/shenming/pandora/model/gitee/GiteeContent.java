package com.shenming.pandora.model.gitee;

import java.io.Serializable;

/**
 * @author: 申铭
 * @create: 2021-05-08 14:59
 **/

public class GiteeContent implements Serializable {

    private static final long serialVersionUID = -3223444952581971371L;

    private String download_url;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }
}
