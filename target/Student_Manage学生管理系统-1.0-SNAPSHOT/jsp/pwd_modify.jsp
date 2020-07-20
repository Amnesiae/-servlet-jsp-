<%@ page import="utils.Constants" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/7/13
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" />
    <script type="text/javascript" src="../js/pwd_modify.js" charset="utf-8"></script>
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
       <span id="welcome_add">您所在的位置为密码修改页面</span>
    <div class="modify_page">
    <form action="user.do?method=modify" id="mod_form" method="post">
        <table id="mod_tab">
            <tr>
                <td class="mod_table_left">原密码</td>
                <td class="mod_table_right"><input type="password" name="oldPassword" id="oldPassword"><span class="mod_error"><span id="oldPasswordError"></span></span> </td>
            </tr>
            <tr>
                <td class="mod_table_left">新密码</td>
                <td  class="mod_table_right"><input type="password" name="newPassword" id="newPassword"><span class="mod_error"><span id="newPasswordError"></span> </span> </td>
            </tr>
            <tr>
                <td class="mod_table_left">确认新密码</td>
                <td  class="mod_table_right"><input type="password" name="confirmNewPassword" id="confirmNewPassword"> <span class="mod_error"><span id="confirmNewPasswordError"></span></span></td>
            </tr>
        </table>
        <button id="btn_mod1">提交</button>
        <input type="reset" value="重置" id="btn_mod2">
    </form>
    </div>
</div>
</body>
</html>
