<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/3/4
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/stuAdd" modelAttribute="student" method="post">
    学号：<form:input path="studentId"/><form:errors path="studentId"/><br>
    姓名：<form:input path="studentName"/><form:errors path="studentName" cssStyle="color: red"/><br>
    性别：<br>
        男<form:radiobutton path="gender" value="1"/><br>
        女<form:radiobutton path="gender" value="0"/><br>
    班级：<form:input path="className"/><form:errors path="className" cssStyle="color: red"/><br>
    <input type="submit" value="提交"/>
</form:form>

</body>
</html>
