<%--
  Created by IntelliJ IDEA.
  User: jianyuanhao
  Date: 16-8-18
  Time: 下午1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录状态</title>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${empty userName}">
            <span>您好&nbsp;&nbsp;您尚未登陆,不可删除记录&nbsp;<a href="/login">点击登陆</a></span>
        </c:when>
        <c:otherwise>
            <span>您好&nbsp;&nbsp;${userName} <a href="/login/logout">退出登录</a></span>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>

