package com.shenming.pandora.service.imgbed.impl;

import com.shenming.pandora.mapper.ImgBedMapper;
import com.shenming.pandora.pojo.ImgBed;
import com.shenming.pandora.service.imgbed.ImgBedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 图床service
 *
 * @author: 申铭
 * @create: 2021-05-08 10:14
 **/

@Service
public class ImgBedServiceImpl implements ImgBedService {

    @Autowired
    private ImgBedMapper imgBedMapper;

    @Override
    public int addOrUpdate(ImgBed imgBed) {
        return imgBedMapper.addOrUpdate(imgBed);
    }

    @Override
    public ImgBed findByType(int type) {
        return imgBedMapper.findByType(type);
    }
}
