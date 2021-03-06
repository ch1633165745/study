<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/3/5
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="/subjectAdd" method="post" modelAttribute="subject">
        课程号：<form:input path="subjectId"/><br><form:errors path="subjectId"/><br>
        课程名<form:input path="subjectName"/><br><form:errors path="subjectName"/><br>
        <input type="submit"value="提交">
    </form:form>
</body>
</html>
