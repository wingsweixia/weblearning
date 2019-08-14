<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<style>
    h1{
        width: 50%;
        height: 10%;
        margin-left:auto;
        margin-right:auto;
        text-align: center;
    }
    .menu{
        width: 40%;
        height: 10%;
        margin-left:auto;
        margin-right:auto;
        text-align: center;
        font-size: 24px;
    }
</style>
<body>
<h1>客户关系管理系统</h1>
<div class="menu">
    <a href="adduser.html" target="iframe_center">添加客户</a>&nbsp;&nbsp;
    <a href="customer?Method=selectCustomer&pageNum=1&pageSize=5" target="iframe_center">查询客户</a>&nbsp;&nbsp;
    <a href="searchCustomer.html" target="iframe_center">高级搜索</a>
</div>
<div style="width: 100%;height: 80%;margin: 0;padding: 0; ">
    <iframe scrolling='auto' frameborder='0' style="width: 100%;height: 100%;display: block" name="iframe_center"></iframe>
</div>
</body>
</html>
