package com.shenming.pandora.constant;

/**
 * 图床类型
 *
 * @author: 申铭
 * @create: 2021-05-08 10:05
 **/

public enum ImgBedType {
    // gitee
    GITEE(1);

    private int value;

    private ImgBedType(int type) {
        this.value = type;
    }

    public int getValue() {
        return value;
    }
}
