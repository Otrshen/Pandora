package com.shenming.pandora.mapper;

import com.shenming.pandora.pojo.Email;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EmailMapper {

    public void add(Email email);

    public Email findByMsgUID(String msgUID);
}
