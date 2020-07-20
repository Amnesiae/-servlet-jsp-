<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/7/12
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" type="text/css">
    <script type="text/javascript" >
    </script>
</head>
<body>
<div class="layout">
    <div id="title">学生信息管理系统</div>
    <br><br>
    <div id="line"><hr style="height: 1px" color="black"></div>

    <div class="left">
        <ul>
            <li style="margin-left: 120px">学生信息管理</li>
        </ul>
        <ul id="stuMess">
            <li><a href="${pageContext.request.contextPath}/jsp/addlist.jsp">添加学生信息</a></li>
            <li><a  href="${pageContext.request.contextPath}/jsp/user.do?method=query">学生信息查询</a></li>
        </ul>
        <ul>
            <li style="margin-left: 120px">密码修改管理</li>
        </ul>
        <ul id="deleteMess">
            <li style="margin-left: 150px"><a href="../jsp/pwd_modify.jsp">修改密码</a></li>
        </ul>

        <ul>
            <li style="margin-left: 120px">退出管理</li>
        </ul>
        <ul id="login_out">
            <li style="margin-left: 150px"><a href="${pageContext.request.contextPath}/jsp/log_out">退出登录</a></li>
        </ul>
    </div >
    <div class="rightText">
        <h3>上午好,${userSession.name}</h3>
        <p id="hello">欢迎来到学生管理系统</p>
    </div>
</div>
</body>
</html>
