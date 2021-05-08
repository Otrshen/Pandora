package com.shenming.pandora.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

/**
 * 操作文件工具类
 *
 * @author: 申铭
 * @create: 2021-05-08 14:35
 **/

public class FileUtil {
    /**
    * @Description: 将文件转成base64字符串
    * @Params: [path]
    * @return: java.lang.String
    * @Author: 申铭
    * @Date: 2021/5/8
    */ 
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[inputFile.available()];
        inputFile.read(buffer);
        inputFile.close();
        return Base64.getEncoder().encodeToString(buffer);
    }
}
