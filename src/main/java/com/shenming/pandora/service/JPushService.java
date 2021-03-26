package com.shenming.pandora.service;

public interface JPushService {

    /*
    * @Description: 根据别名推送消息
    * @Params: 
    * @return: 
    * @Author: 申铭
    * @Date: 2021/3/25
    */ 
    public void push(String alias, String title, String body) throws Exception;

    public void deleteAlias(String alias);

}
