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
    <title>文件上传</title>
</head>
<body>
<div>
    <form method="post" enctype="multipart/form-data">
        <table align="center" border="1" cellspacing="0" cellpadding="1" width="80%">
            <tr>
                <td><label>源文件:</label></td>
                <td><input name="source" type="file"/></td>
            </tr>
            <tr>
                <td><label>目标文件:</label></td>
                <td><input name="target" type="file"/></td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
