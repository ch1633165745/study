<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/3/4
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellpadding="5px" cellspacing="0">
    <tr>
        <td>课程编号</td>
        <td>课程名</td>
    </tr>
    <c:forEach items="${allSub}" var="sub">
        <tr>
            <td>${sub.subjectId}</td>
            <td>${sub.subjectName}</td>
        </tr>
    </c:forEach>
</table>
<a href="/toAddSub">添加课程</a>
</body>
</html>
