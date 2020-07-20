<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/7/12
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="../js/userlist.js">
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" />
<html>
<head>
    <title>Title</title>
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

<div class="right">
    <form  id="form_id"  action="${pageContext.request.contextPath}/jsp/user.do?method=query" method="get">
        <table id="serTab">
            <tr>
                <td><input hidden name="method" value="query"></td>
                <td class="tab_left">按姓名查询</td>
                <td id="range"><input type="text" name="nameSer" class="tab_right"></td>
                <td class="tab_left">按编号查询</td>
                <td ><input type="text" name="idSer" class="tab_right"></td>
                <td><input type="hidden" name="pageIndex" value="1"/></td>
                <td ><input type="submit" value="查询" id="btn_sub"></td>
            </tr>
        </table>
    </form>
    <br>
    <hr  style="height: 1px" color="black">
</div>
<div class="right_tab">
    <table  id="listTable">
        <tr>
            <td>学生id</td>
            <td>学生姓名</td>
            <td>学生性别</td>
            <td>学生邮箱</td>
            <td>学生年龄</td>
            <td>学生住址</td>
            <td>操作</td>
        </tr>
<c:forEach var="student" items="${studentList }" varStatus="status">
    <tr>
        <td><span>${student.id }</span></td>
        <td><span>${student.name }</span></td>
        <td><span>${student.sex}</span></td>
        <td><span>${student.email }</span></td>
        <td><span>${student.age}</span></td>
        <td><span>${student.address}</span></td>
        <td><span><a href="${pageContext.request.contextPath}/jsp/user.do?method=delete&id=${student.id}" onclick="return confirm('确定删除该用户吗')">删除用户</a></span></td>
    </tr>
</c:forEach>
    </table>
</div>
</div>
</body>
</html>
