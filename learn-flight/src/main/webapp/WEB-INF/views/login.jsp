
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaolongmeng
  Date: 16-8-18
  Time: 下午4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body onload='document.f.username.focus();'>
<h3>请输入用户名与密码</h3>
<form name='f' method="post" action="/login" align="center">
    <table>
        <tr>
            <td>用户名:</td><td><input type='text' name='username'></td>
        </tr>
        <tr>
            <td>密码:</td><td><input type='password' name='password'/></td>
        </tr>
        <tr><td colspan='2'>
            <input name="submit" type="submit" value="登录"/>
        </td></tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </table>
</form>
</body>
</html>