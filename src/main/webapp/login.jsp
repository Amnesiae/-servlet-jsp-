<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/7/10
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body class="body">
<div id="main">
    <div class="lg_layout">
        <div class="lg_left">
            <p>用户登录</p>
            <p>USER LOGIN</p>
        </div>
        <div class="lg_center">
            <div class="lg_form">
                <form action="${pageContext.request.contextPath}/login.do" method="post">
                    <div id="login_error">${error}</div>
                    <table>
                        <tr>
                            <td class="td_left"><label for="username">用户名</label></td>
                            <td class="td_right"><input type="text" name="username" id="username" placeholder="请输入用户名">
                            </td>
                        </tr>
                        <tr>
                            <td class="td_left"><label for="password">密码</label></td>
                            <td class="td_right"><input type="password" name="password" id="password"
                                                        placeholder="请输入密码"></td>
                        </tr>
                    </table>
                    <input id="btn_sub" type="submit" value="登录">
                    <input id="btn_sub1" type="reset" value="重置">
                </form>
            </div>
        </div>

    </div>


</div>


</body>
</html>
