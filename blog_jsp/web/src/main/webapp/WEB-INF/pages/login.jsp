<%--
  Created by IntelliJ IDEA.
  User: 16773
  Date: 2019/3/2
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>关于-Kindem的博客</title>

    <!--Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!--Materialize-->
    <link href="lib/materialize/css/materialize.min.css" rel="stylesheet" media="screen,projection">

    <!--About Css-->
    <link href="css/login.css" rel="stylesheet">
</head>
<body>
<!--导航栏-->
<nav class="nav-extended cyan">
    <div class="nav-wrapper container">
        <a href="#" class="brand-logo">Kindem</a>
        <ul class="right">
            <li><a href="#"><i class="material-icons">search</i></a></li>
            <li><a href="#"><i class="material-icons hide-on-med-and-down">person</i></a></li>
        </ul>
        <ul class="left hide-on-large-only">
            <li><a href="#"><i class="material-icons">person</i></a></li>
        </ul>
    </div>
    <div class="nav-content container">
        <ul class="tabs tabs-transparent">
            <li class="tab"><a target="_blank" href="index.html">首页</a></li>
            <li class="tab"><a target="_blank" href="tag.html">标签</a></li>
            <li class="tab"><a target="_blank" href="#">归档</a></li>
            <li class="tab"><a href="#" class="active">关于</a></li>
        </ul>
    </div>
</nav>

<!--parallax-->
<div class="parallax-container">
    <div class="parallax"><img src="img/about_bg.png"></div>
    <div class="center white-text">
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <h3>Kindem</h3>
        <h4>一生想做浪漫Coder</h4>
    </div>
</div>

<form class="login-form">
    <div class="username">
        <input type="text" placeholder="USERNAME"/>
    </div>
    <div class="password">
        <input type="text" placeholder="PASSWORD"/>
    </div>
    <button class="login">
        <span>log in</span>
    </button>
</form>


<!--页脚-->
<footer class="page-footer cyan">
    <div class="container">
        <div class="row">
            <div class="col s12 m12 l4 xl4">
                <h4>Contact Me With</h4>
                <p>QQ: 461425614<br>邮箱: 461425614@qq.com</p>
                <br>
            </div>
            <div class="col s12 m12 l4 xl4">
                <h5>More</h5>
                <ul>
                    <li><a href="#" class="white-text">GitHub&nbsp;-&nbsp;FlyAndNotDown</a></li>
                    <li><a href="https://www.zhihu.com/people/wang-yu-zhi-ku-66/activities" class="white-text">知乎&nbsp;-&nbsp;亡与栀枯</a></li>
                    <li><a href="https://user.qzone.qq.com/461425614/infocenter" class="white-text">QZone&nbsp;-&nbsp;可见影子</a></li>
                </ul>
            </div>
            <div class="col s12 m12 l4 xl4">
                <h5>Donate</h5>
                <button type="button" class="btn cyan lighten-2 waves-effect donate-modal-trigger">请我喝一杯咖啡</button>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <div class="container">@ 2017 Copyright kindemh.cn<br>
            Frontend Framework By <a href="http://materializecss.com/about.html" class="white-text">Materialize</a></div>
    </div>
</footer>

<!--jQuery-->
<script src="lib/jQuery/jquery-3.2.1.min.js"></script>
<script src="lib/materialize/js/materialize.min.js"></script>

<!--About Js-->
<script src="js/about.js"></script>
</body>
</html>
