package com.shenming.pandora.service.imgbed.impl;

import com.alibaba.fastjson.JSON;
import com.shenming.pandora.model.gitee.GiteeImgBed;
import com.shenming.pandora.model.gitee.GiteeRes;
import com.shenming.pandora.service.imgbed.GiteeImgBedService;
import com.shenming.pandora.util.FileUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

/**
 * gitee图床网络请求
 *
 * @author: 申铭
 * @create: 2021-05-08 13:59
 **/

@Service
public class GiteeImgBedServiceImpl implements GiteeImgBedService {

    @Override
    public String uploadFile(GiteeImgBed giteeImgBed, String filePath) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        File file = new File(filePath);
        String fileName = file.getName();

        String path = giteeImgBed.getPath() + "/" + fileName;
        String content = FileUtil.encodeBase64File(filePath);
        String message = "Upload " + fileName;

        String url = "https://gitee.com/api/v5/repos/" + giteeImgBed.getOwner() + "/" + giteeImgBed.getRepo() + "/contents/" + path;

        MultiValueMap<String, String> requestMap= new LinkedMultiValueMap();
        requestMap.add("access_token", giteeImgBed.getToken());
        requestMap.add("content", content);
        requestMap.add("message", message);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "multipart/form-data");

        HttpEntity requestEntity = new HttpEntity(requestMap,headers);
        String resStr = restTemplate.postForObject(url ,requestEntity, String.class);
        GiteeRes res = JSON.parseObject(resStr, GiteeRes.class);
        return res.getContent().getDownload_url();
    }
}
