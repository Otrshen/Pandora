<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图床配置</title>
</head>
<body>

<form action="/pandora/imgbed/setting/gitee" method="post">
    <p>owner：<input name="owner" type="text" placeholder="owner" value="${owner}"></p>
    <p>repo：<input name="repo" type="text" placeholder="repo" value="${repo}"></p>
    <p>path：<input name="path" type="text" placeholder="path" value="${path}"></p>
    <p>token：<input name="token" type="text" placeholder="token" value="${token}"></p>
    <button type="submit">提交</button>
</form>

</body>
</html>