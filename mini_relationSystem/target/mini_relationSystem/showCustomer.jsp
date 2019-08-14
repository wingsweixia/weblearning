<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/8/12
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询客户</title>
    <link href="CSS/customer.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="mainblock">
        <table class="infotable" style="width: auto;height: auto;">
            <caption>客户列表</caption>
            <tr>
                <td>客户名</td>
                <td>性别</td>
                <td>手机</td>
                <td>邮箱</td>
                <td>描述</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${pagebean.list}" var="user">
                <tr>
                    <td>
                        ${user.name}
                    </td>
                    <td>
                        ${user.gender}
                    </td>
                    <td>
                            ${user.tel}
                    </td>
                    <td>
                            ${user.eamil}
                    </td>
                    <td>
                            ${user.description}
                    </td>
                    <td>
                        <a href="customer?Method=editPrepare&pageNum=1&pageSize=5&tel=${user.tel}">编辑</a>
                        <a href="customer?Method=deleteCustomer&tel=${user.tel}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    <p>
        共${pagebean.totalPage}页/${pagebean.totalRecord}条记录&nbsp;&nbsp;
        <a href="customer?Method=selectCustomer&pageNum=1&pageSize=5">首页</a>
        <c:forEach var="i" begin="${pagebean.start}" end="${pagebean.end}" step="1">
            <c:choose>
                <c:when test="${i==pagebean.pageNum}">${i}</c:when>
                <c:otherwise><a href="customer?Method=selectCustomer&pageNum=${i}&pageSize=5">${i}</a></c:otherwise>
            </c:choose>
        </c:forEach>

        <a href="customer?Method=selectCustomer&pageNum=${pagebean.totalPage}&pageSize=5">末页</a>

    </p>
</div>
</body>
</html>
