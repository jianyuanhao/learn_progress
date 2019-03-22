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
    <title>Title</title>
</head>
<body>
<div>
    <h3 align="center">最近2条历史对比结果</h3>
    <div >
        <c:choose>
            <c:when test="${compareInfoCount>0}">
                <div>
                   <table align="center" border="1" cellpadding="0">
                        <tr>
                            <td height="50" width="150" align="center">源文件内容</td>
                            <td height="50" width="150" align="center">目标文件内容</td>
                            <td height="50" width="150" align="center">差异</td>
                            <td height="50" width="150" align="center">对比时间</td>
                            <c:if test="${! empty userName}">
                                <td>操作</td>
                            </c:if>
                        </tr>

                        <c:forEach var="compareInfo" items="${compareInfos}">
                            <tr>
                                <td>${compareInfo.getSourceContext()}</td>
                                <td>${compareInfo.getTargetContext()}</td>
                                <td>${compareInfo.getDiffContext()}</td>
                                <td>${compareInfo.getCompareTimeString()}</td>
                                <c:if test="${! empty userName}">
                                    <td ><a href="/delete/${compareInfo.getId()}">删除</a></td>
                                </c:if>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div>
                    <c:choose>
                        <c:when test="${pageNum==0 && compareInfoCount>pageNum*pageSize+pageSize}">
                            <span><a href="/?pageNum=${pageNum+1}" >点击查看更多</a></span>
                        </c:when>
                        <c:when test="${pageNum>0 && compareInfoCount<=pageNum*pageSize+pageSize}">
                            <span><a href="/?pageNum=${pageNum-1}">上一页</a> </span>
                        </c:when>
                        <c:when test="${pageNum>0 && compareInfoCount>pageNum*pageSize+pageSize}">
                            <span><a href="/?pageNum=${pageNum-1}">上一页</a>&nbsp;&nbsp;<a href="/?pageNum=${pageNum+1}">下一页</a> </span>
                        </c:when>
                    </c:choose>
                </div>
            </c:when>
            <c:otherwise>
                <span>暂无历史对比数据</span>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
