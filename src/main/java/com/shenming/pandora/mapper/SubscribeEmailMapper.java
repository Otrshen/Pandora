package com.shenming.pandora.mapper;

import com.shenming.pandora.pojo.SubscribeEmail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubscribeEmailMapper {

    /** 
    * @Description: 添加订阅邮件
    * @Params: [email]
    * @return: void
    * @Author: 申铭
    * @Date: 2021/3/24
    */ 
    public void add(SubscribeEmail email);

    /**
    * @Description:  查询所有已订阅邮件人员
    * @Params: []
    * @return: java.util.List<com.shenming.pandora.pojo.SubscribeEmail>
    * @Author: 申铭
    * @Date: 2021/3/25
    */
    public List<SubscribeEmail> queryAll();

    /**
    * @Description: 根据邮件查找对应订阅人员
    * @Params:
    * @return:
    * @Author: 申铭
    * @Date: 2021/3/25
    */
    public SubscribeEmail findByEmail(String email);
}
