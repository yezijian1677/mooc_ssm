<%--
  Created by IntelliJ IDEA.
  User: 16773
  Date: 2018/11/25
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="login">
    <div class="header">
        <h1>
            <a href="login.do">登录</a>
        </h1>
        <button></button>
    </div>
    <form action="login.do" method="post">
        <div class="name">
            <input type="text" id="name" name="username">
            <p></p>
        </div>
        <div class="pwd">
            <input type="password" id="pwd" name="password">
            <p></p>
        </div>
        <div class="btn-red">
            <input type="submit" value="登录" id="login-btn">
        </div>
    </form>
</div>
</body>
</html>