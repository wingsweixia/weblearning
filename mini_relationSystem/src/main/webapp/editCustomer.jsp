<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/8/13
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑客户信息</title>
    <link href="CSS/customer.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="mainblock">
    <form method="post" action="customer?Method=editCustomer">

        <table class="infotable" style="width: auto;height: auto;">
            <caption>编辑客户信息</caption>
            <c:forEach items="${pagebean.list}" var="user">
                <input type="hidden" name="oritel" value="${user.tel}">
                <tr><td>客户名称：</td><td><input type="text" name="username" value="${user.name}"></td></tr>
                <tr><td>客户性别：</td><td><input type="text" value="${user.gender}" name="gender">&nbsp;&nbsp;
                    </td></tr>
                <tr><td>手机：</td><td><input type="text" name="tel" value="${user.tel}"></td></tr>
                <tr><td>邮箱：</td><td><input type="text" name="email" value="${user.eamil}"></td></tr>
                <tr><td>描述：</td><td><textarea name="des">${user.description}</textarea></td></tr>
                <tr><td><input type="reset" value="提交重置"></td><td><input type="submit" value="提交"></td></tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
