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
<%--<html>--%>
<%--<head>--%>
    <%--<title>首页</title>--%>
    <%--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/util.css"/>--%>
<%--</head>--%>
<%--<table align="center" border="1" cellspacing="0" cellpadding="1" width="80%">--%>
<%--<body>--%>
<%--<jsp:include page="loginstatus.jsp"/>--%>

<%--<jsp:include page="files_upload.jsp"/>--%>

<%--<jsp:include page="filesdiff_list.jsp"/>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>

<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/util.css"/>
</head>
<body>
<table align="center" border="1" cellspacing="0" cellpadding="1" width="80%">

    <%--<table align="center" border="0" cellpadding="0">--%>
        <%--<tr>--%>
            <%--<td height="50" width="150" align="center">用户</td>--%>
            <%--<td width="150" align="center">访问路径</td>--%>
            <%--<td width="150" align="center">访问次数</td>--%>
        <%--</tr>--%>
    <jsp:include page="loginstatus.jsp" />

    <jsp:include page="filesupload.jsp"/>

    <jsp:include page="filesdiffshow.jsp"/>
</table>
</body>
</html>
