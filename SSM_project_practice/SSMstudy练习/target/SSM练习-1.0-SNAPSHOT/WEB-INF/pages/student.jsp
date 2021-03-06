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
    <table id="stu" border="1" cellpadding="5px" cellspacing="0">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>班级</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
    <c:forEach items="${allStu}" var="stu">
        <tr>
            <th>${stu.studentId}</th>
            <th>${stu.studentName}</th>
            <th>${stu.gender}</th>
            <th>${stu.className}</th>
            <th><a>修改</a></th>
            <th><a>删除</a></th>
        </tr>
    </c:forEach>
    </table>
    <a href="/toAddStu">添加学生</a>
</body>
</html>
