package com.shenming.pandora.controller;

import com.alibaba.fastjson.JSON;
import com.shenming.pandora.constant.ErrorContants;
import com.shenming.pandora.constant.ImgBedType;
import com.shenming.pandora.model.gitee.GiteeImgBed;
import com.shenming.pandora.model.ResponseEntity;
import com.shenming.pandora.pojo.ImgBed;
import com.shenming.pandora.service.imgbed.GiteeImgBedService;
import com.shenming.pandora.service.imgbed.ImgBedService;
import com.shenming.pandora.util.ResponseErrorUtil;
import com.shenming.pandora.util.exception.ClientException;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;

/**
 * 图床
 *
 * @author: 申铭
 * @create: 2021-05-06 16:17
 **/

@Api("图床模块")
@Controller
@RequestMapping("/imgbed")
public class ImgBedController {

    // 上传路径
    @Value("${imgbed_upload_path}")
    private String uploadPath;

    @Autowired
    private ImgBedService imgBedService;
    @Autowired
    private GiteeImgBedService giteeImgBedService;

    private static final Logger log = LoggerFactory.getLogger(ImgBedController.class);

    /**
     * @Description: 图床设置页面
     * @Params: []
     * @return: java.lang.String
     * @Author: 申铭
     * @Date: 2021/5/8
     */
    @GetMapping(value = "/config/gitee")
    public String config(Model m) {
        ImgBed imgBed = imgBedService.findByType(1);
        GiteeImgBed giteeImgBed = JSON.parseObject(imgBed.getContent(), GiteeImgBed.class);
        m.addAttribute("owner", giteeImgBed.getOwner());
        m.addAttribute("repo", giteeImgBed.getRepo());
        m.addAttribute("path", giteeImgBed.getPath());
        m.addAttribute("token", giteeImgBed.getToken());
        return "ImgBedConfig";
    }

    /**
     * @Description: 设置gitee图床参数
     * @Params: [owner, repo, path, token, m]
     * @return: java.lang.String
     * @Author: 申铭
     * @Date: 2021/5/8
     */
    @PostMapping(value = "/setting/gitee")
    public String config(@RequestParam String owner, @RequestParam String repo, @RequestParam String path, @RequestParam String token, Model m) {
        GiteeImgBed giteeImgBed = new GiteeImgBed();
        giteeImgBed.setOwner(owner);
        giteeImgBed.setRepo(repo);
        giteeImgBed.setPath(path);
        giteeImgBed.setToken(token);

        ImgBed imgBed = new ImgBed();
        imgBed.setType(ImgBedType.GITEE.getValue());
        imgBed.setContent(JSON.toJSONString(giteeImgBed));

        int flag = imgBedService.addOrUpdate(imgBed);
        if (flag == 1) {
            m.addAttribute("result", "设置成功");
        } else {
            m.addAttribute("result", "设置失败");
        }

        return "ImgBedResult";
    }

    /**
     * @Description: 上传图片
     * @Params: [file, type]
     * @return: java.lang.String
     * @Author: 申铭
     * @Date: 2021/5/8
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam int type) {
        // 目前仅支持gitee图床
        if (type != ImgBedType.GITEE.getValue()) {
            ClientException e = new ClientException(ErrorContants.PARAMETER_ERROR, "不支持此类型");
            return JSON.toJSONString(ResponseErrorUtil.convertException(e));
        }

        // 查询图床参数
        ImgBed imgBed = imgBedService.findByType(type);
        GiteeImgBed giteeImgBed = JSON.parseObject(imgBed.getContent(), GiteeImgBed.class);

        return this.upload(file, giteeImgBed.getOwner(), giteeImgBed.getRepo(), giteeImgBed.getPath(), giteeImgBed.getToken());
    }

    /**
    * @Description: gitee图片上传方法
    * @Params: [file, owner, repo, path, token]
    * @return: java.lang.String
    * @Author: 申铭
    * @Date: 2021/5/8
    */ 
    @PostMapping(value = "/upload/gitee")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, @RequestParam String owner, @RequestParam String repo, @RequestParam String path, @RequestParam String token) {
        String filePath = "";
        try {
            filePath = this.upload(file);
        } catch (ClientException e) {
            return JSON.toJSONString(ResponseErrorUtil.convertException(e));
        } catch (Exception e) {
            return JSON.toJSONString(ResponseErrorUtil.convertException(e));
        }

        GiteeImgBed giteeImgBed = new GiteeImgBed();
        giteeImgBed.setOwner(owner);
        giteeImgBed.setRepo(repo);
        giteeImgBed.setPath(path);
        giteeImgBed.setToken(token);

        try {
            String url = giteeImgBedService.uploadFile(giteeImgBed, filePath);
            HashMap<String, String> map = new HashMap();
            map.put("message", "上传成功");
            map.put("url", url);
            ResponseEntity entity = new ResponseEntity(map);
            return JSON.toJSONString(entity);
        } catch (Exception e) {
            return JSON.toJSONString(ResponseErrorUtil.convertException(e));
        }
    }

    /**
    * @Description: 保存上传文件
    * @Params: [file]
    * @return: java.lang.String
    * @Author: 申铭
    * @Date: 2021/5/8
    */
    private String upload(MultipartFile file) throws ClientException, Exception {
        if (file.isEmpty()) {
            throw new ClientException(ErrorContants.PARAMETER_ERROR, "文件为空");
        }

        String fileName = file.getOriginalFilename();
        log.info("上传文件名：" + fileName);

        File dest = new File(uploadPath + fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        file.transferTo(dest);

        return dest.getAbsolutePath();
    }
}
