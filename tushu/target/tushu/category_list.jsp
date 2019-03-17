<%--
  Created by IntelliJ IDEA.
  User: 16773
  Date: 2019/3/16
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>分类列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>

<body>
<header>
    <div class="container">
        <nav>
            <a href="${pageContext.request.contextPath}/book/list.do" >分类</a>
        </nav>

    </div>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>图书</h1>
            <p>图书分类列表</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>名称</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${LIST}" var="list">
                <tr>
                    <td>${list.id}</td>
                    <td>${list.name}</td>
                    <td>${list.createTime}</td>
                    <td>${list.updateTime}</td>
                    <td><a href="${pageContext.request.contextPath}/category/toEdit.do?id=${list.id}">编辑</a>&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/category/delete.do?id=${list.id}">删除</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="${pageContext.request.contextPath}/category/toAdd.do"><button>新建</button></a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>