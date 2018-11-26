<%--
  Created by IntelliJ IDEA.
  User: 16773
  Date: 2018/11/14
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理</title>
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="lib/jquery-3.3.1/jquery-3.3.1.min.js">
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>管理平台 <small>用户数据管理</small></h1>
            </div>
        </div>
        <div class="row">
            <div class="jumbotron">
                <h1>Mybatis基础入门</h1>
                <p>通过项目来完成基础部分学习</p>
                <p><a href="#" class="btn btn-primary btn-lg" role="button">查看更多</a></p>
            </div>
        </div>
        <div class="row">
            <table class="table table-hover table-striped">
                <tr>
                    <th>用户编号</th>
                    <th>登录账号</th>
                    <th>用户昵称</th>
                    <th>邮箱</th>
                    <th>联系方式</th>
                    <th>账号创建时间</th>
                    <th>用户状态</th>
                    <th>操作</th>
                </tr>
                <c:forEach var="user" items="${usersList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.nickname}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.createTime}</td>
                    <c:if test="${user.userStatus == 0}">
                        <td>正常</td>
                    </c:if>
                    <c:if test="${user.userStatus == 1}">
                        <td>锁定</td>
                    </c:if>
                    <c:if test="${user.userStatus == 2}">
                        <td>删除</td>
                    </c:if>
                    <td>
                        <a href="${pageContext.request.contextPath}/detail?id {user.id}">查看</a>
                        <a href="#">修改</a>
                        <a href="#">删除</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
