package com.shenming.pandora.model.gitee;

/**
 * gitee图床
 *
 * @author: 申铭
 * @create: 2021-05-08 10:24
 **/

public class GiteeImgBed {
    // 仓库所属空间地址(企业、组织或个人的地址path)
    private String owner;
    // 仓库路径(path)
    private String repo;
    // 文件的路径
    private String path;
    // 用户授权码
    private String token;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
