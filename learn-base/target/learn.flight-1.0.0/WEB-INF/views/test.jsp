<table align="center" border="1" cellspacing="0" cellpadding="1" width="80%">
    <tr>
        <td align="center">源文件内容</td>
        <td align="center">目标文件内容</td>
        <td align="center">差异</td>
        <td align="center">对比时间</td>
        <c:choose>
            <c:when test="${sessionScope.username!=null}">
                <td align="center">操作</td>
            </c:when>
        </c:choose>
    </tr>
    <c:forEach var="content" items="${customDiff.content_list}">
        <tr>
            <td>
                <table>
                    <c:forEach var="source" items="${content.source_content}">
                        <tr><td>
                            <c:out value="${source}"/>
                        </td></tr>
                    </c:forEach>
                </table>
            </td>
            <td>
                <table>
                    <c:forEach var="source" items="${content.target_content}">
                        <tr><td>
                            <c:out value="${source}"/>
                        </td></tr>
                    </c:forEach>
                </table>
            </td>
            <td>
                <table>
                    <c:forEach var="source" items="${content.differ_content}">
                        <tr><td>
                            <c:out value="${source}"/>
                        </td></tr>
                    </c:forEach>
                </table>
            </td>
            <td align="center">
                <c:out value="${content.create_time}"/>
            </td>
            <c:choose>
                <c:when test="${sessionScope.username!=null}">
                    <td align="center"><a href="<c:out value="${path}"/>/diff/delete?id=<c:out value="${content.id}"/>" onclick="delcfm()">删除</a></td>
                </c:when>
            </c:choose>
        </tr>
    </c:forEach>
</table>