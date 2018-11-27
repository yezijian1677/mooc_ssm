<%--
  Created by IntelliJ IDEA.
  User: 16773
  Date: 2018/11/27
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科室列表</title>
    <link rel="stylesheet" type="text/css" href="../css/index.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/dept/list.do">
                慕课网科室管理
            </a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="jumbotron">
        <h1>Hello,  ${USER.username}</h1>
        <p>请小心的编辑科室记录，要是建了一个错误的就不好了。。。</p>
    </div>
    <div class="page-header">
        <h3><small>新建</small></h3>
    </div>
    <form class="form-horizontal" action="edit.do" method="post">
        <input class="id" name="id" type="hidden" value="${cate.id}">
        <input class="createTime" name="createTime" type="hidden" value="<fmt:formatDate value="${cate.createTime}" pattern="yyyy-MM-dd HH:mm"/>">

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">名称 ：</label>
            <div class="col-sm-8">
                <input name="name" class="form-control" id="name" value="${cate.name}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
<footer class="text-center" >
    copy@imooc
</footer>
</body>
</html>
