package com.shenming.pandora.pojo;

/**
 * 图床实体类
 *
 * @author: 申铭
 * @create: 2021-05-08 10:03
 **/

public class ImgBed {

    private int id;
    // 图床类型
    private int type;
    // json字符串
    private String content;
    // saveOrUpdate
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
