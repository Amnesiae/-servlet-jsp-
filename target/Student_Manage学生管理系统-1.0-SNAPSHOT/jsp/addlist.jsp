<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/7/14
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <script type="text/javascript" rel="script" src="../js/studentAdd.js" charset="utf-8"></script>
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
            <li><a href="">添加学生信息</a></li>
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

    <div class="add_right">
            <span id="welcome_add">您所在的位置为添加用户页面</span>
    <form action="user.do?method=add" method="post" id="add_form">

        <label style="margin-left: 400px">学生性别</label>
        <span style="margin-left: 60px; margin-right: 10px">男</span><input  type="radio" name="sex" value="男" checked>
        <span style="margin-left: 60px;margin-right: 10px">女</span><input   type="radio" name="sex" value="女">

            <table class="add_tab">
                <tr>
                    <td class="add_table_left">学生真实姓名</td>
                    <td><input class="add_table_right" id="stuName" type="text" name="name" autocomplete="off"> <span class="error" ><span id="nameError"></span></span></td>
                </tr>

                <tr>
                    <td class="add_table_left">学生邮箱</td>
                    <td><input  class="add_table_right" type="text" name="email" id="stuEmail" autocomplete="off"> <span class="error"><span id="emailError"></span></span></td>
                </tr>


                <tr>
                    <td class="add_table_left">学生年龄</td>
                    <td ><input class="add_table_right" type="text" name="age" id="stuAge" autocomplete="off"> <span class="error"><span id="ageError"></span></span></td>
                </tr>
                <tr>
                    <td class="add_table_left">学生地址</td>
                    <td ><input class="add_table_right" type="text" id="stuAddress" name="address" autocomplete="off"> <span class="error"><span id="addressError"></span></span></td>
                </tr>
                <tr>
                    <td class="add_table_left">用户名</td>
                    <td ><input class="add_table_right" type="text" name="username" id="stuUsername" autocomplete="off"> <span class="error"><span id="usernameError"></span></span></td>
                </tr>
                <tr>
                    <td class="add_table_left">密码</td>
                    <td ><input class="add_table_right" type="password" name="password" id="stuPassword" > <span class="error"><span id="passwordError"></span></span></td>
                </tr>
                <tr>
                    <td class="add_table_left">确认密码</td>
                    <td ><input class="add_table_right" type="password"  id="stuConfirmPassword"> <span class="error"><span id="passwordConfirmError"></span></span></td>
                </tr>

            </table>
             <button id="add_btn1" type="button">注册</button>
            <input id="add_btn2"  type="reset" value="重置">
    </form>
</div>


</div>
</body>
</html>