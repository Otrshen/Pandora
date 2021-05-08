package com.shenming.pandora.service.imgbed;

import com.shenming.pandora.model.gitee.GiteeImgBed;

public interface GiteeImgBedService {
    /**
    * @Description: 上传文件
    * @Params: [giteeImgBed, filePath]
    * @return: boolean
    * @Author: 申铭
    * @Date: 2021/5/8
    */ 
    public String uploadFile(GiteeImgBed giteeImgBed, String filePath) throws Exception;
}
