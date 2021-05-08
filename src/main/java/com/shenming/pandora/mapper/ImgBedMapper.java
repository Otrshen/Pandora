package com.shenming.pandora.mapper;

import com.shenming.pandora.pojo.ImgBed;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ImgBedMapper {
    /**
    * @Description: 添加图床 
    * @Params: [imgBed]
    * @return: int
    * @Author: 申铭
    * @Date: 2021/5/8
    */ 
    public int addOrUpdate(ImgBed imgBed);

    /**
    * @Description: 根据type查询图床
    * @Params: [type]
    * @return: com.shenming.pandora.pojo.ImgBed
    * @Author: 申铭
    * @Date: 2021/5/8
    */ 
    public ImgBed findByType(int type);
}
