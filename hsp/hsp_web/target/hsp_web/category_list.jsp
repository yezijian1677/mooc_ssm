<%--
  Created by IntelliJ IDEA.
  User: 16773
  Date: 2018/11/26
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>科室分类</title>
    <link rel="stylesheet" type="text/css" href="../css/index.css"/>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
</head>

<body>
<header>
    <div class="container">

        <c:forEach items="${cates}" var="cate" begin="1" end="2">
            <nav>
                <a href="${pageContext.request.contextPath}/dept/listByCateId.do?categoryId=${cate.id}" >${cate.name}</a>
            </nav>
        </c:forEach>
        <nav>
            <a href="${pageContext.request.contextPath}/category/list.do" >分类</a>
        </nav>

    </div>
</header>
<section class="banner">
    <div class="container">
        <div>
            <h1>科室</h1>
            <p>科室分类</p>
        </div>
    </div>
</section>
<section class="main">
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>名称</th>
                <th>创建时间</th>
                <th>最后修改时间</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${cates}" var="cate">
                <tr>
                    <td>${cate.name}</td>
                    <td><fmt:formatDate value="${cate.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                    <td><fmt:formatDate value="${cate.updateTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                    <td>

                        <a href="toEdit.do?id=${cate.id}">修改</a>&nbsp;&nbsp;
                        <a href="delete.do?id=${cate.id}">删除</a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>
<section class="page">
    <div class="container">
        <div id="fatie">
            <a href="toAdd.do"><button>新建</button></a>
        </div>
    </div>
</section>
<footer>
    copy@慕课网
</footer>
</body>
</html>