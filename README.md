# Pandora

下载代码，本地部署服务。

使用`mysql`数据库，`sql`语句存放在 `mysql文件夹` -> `pandora.sql`。

## Gitee图床

> 方式一不保存`repo`等数据，可实现不同图片上传至不同仓库；方式二一次配置参数，多次使用，不具有灵活性。

> **所有请求添加请求头，`AccessToken`:`shenming`。**

### 方式一

名称 | 内容
---|---
请求方式 | POST
Api | http://192.168.1.51:8886/pandora/imgbed/upload/gitee

请求参数：

参数名 | 类型 | 描述
---|---|---
file | formData | 文件
token | String | 用户授权码
owner | String | 仓库所属空间地址(企业、组织或个人的地址path)
repo | String | 仓库路径
path | String | 文件的路径

成功返回：

```
{
    "data": {
        "message": "上传成功",
        "url": "https://gitee.com/otrshen/test-img/raw/master/test11/create_pch.jpg"
    },
    "status": "1"
}
```

失败返回：

```
{
    "message": "xxxx",
    "status": "-1"
}
```

MWeb使用示例：

<img src="https://gitee.com/otrshen/blogimg/raw/master/pandora/16204677550453.jpg" width="600">

### 方式二

#### 1. 设置参数接口

地址：http://192.168.1.51:8886/pandora/imgbed/config/gitee

访问此地址，设置 `owner`、`repo`、`path`、`token`参数。

参数 | 描述
---|---
token | 用户授权码
owner | 仓库所属空间地址(企业、组织或个人的地址path)
repo | 仓库路径
path | 文件的路径

#### 2. 调用上传接口

名称 | 内容
---|---
请求方式 | POST
Api | http://192.168.1.51:8886/pandora/imgbed/upload

请求参数：

参数名 | 类型 | 描述
---|---|---
file | formData | 文件
type | int | 类型(1即表示Gitee，目前仅支持Gitee图床)

成功返回：

```
{
    "data": {
        "message": "上传成功",
        "url": "https://gitee.com/otrshen/test-img/raw/master/test11/create_pch.jpg"
    },
    "status": "1"
}
```

失败返回：

```
{
    "message": "xxxx",
    "status": "-1"
}
```

MWeb使用示例：

<img src="https://gitee.com/otrshen/blogimg/raw/master/pandora/16204675115211.jpg" width="600">

## 邮件通知

此功能废弃