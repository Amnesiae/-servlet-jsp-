<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/7/16
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/rollpage.js"></script>
</head>
<body>
<div id="paging-frame">
    <%--第一页的情况--%>
    <c:if test="${param.currentPage}==1">
            <span>
                <span id="totalPage">共${param.tatolCount}条记录</span>
                &nbsp;&nbsp;
                <span>首页/${param.totalPage}页</span>&nbsp;
                <a href="javascript:page_nav(document.forms[0],${param.currentPage+1});">下一页</a> &nbsp;
                <a href="javascript:page_nav(document.forms[0],${param.totalPage});">最后一页</a>
            </span>
    </c:if>
    <%--中间页的情况--%>
    <c:if test="${currentPage}>1&&${currentPage}<${tatolPage}">
            <span>
                <span id="totalPage2">共${totalCount}条记录</span>&nbsp;&nbsp;
                <span>${currentPage}/${totalPage}页</span>&nbsp;
                <a href="javascript:page_nav(document.forms[0],${currentPage-1});" >上一页</a>
                <a href="javascript:page_nav(document.forms[0],${currentPage+1});">下一页</a> &nbsp;
                <a href="javascript:page_nav(document.forms[0],${totalPage+1});">最后一页</a>
            </span>

    </c:if>
    <%--最后一页的情况--%>
    <c:if test="${currentPage}==${totalPage}">
            <span>
                <span id="totalPage3">共${totalCount}条记录</span>
                &nbsp;&nbsp;
                <span>首页/${totalPage}页</span>&nbsp;
                <a href="javascript:page_nav(document.forms[0],1);">首页</a> &nbsp;
                <a href="javascript:page_nav(document.forms[0],${param.currentPage-1});">上一页</a>
            </span>
    </c:if>
    <span id="jumpPage">
            <span>跳转至</span>
            <span><input type="text" class="jumpText" id="pageNum"/></span>页
            <span><input type="button" value="Go" class="btnGO" id="btn_go"></span>
        </span>
</div>
</body>
</html>
