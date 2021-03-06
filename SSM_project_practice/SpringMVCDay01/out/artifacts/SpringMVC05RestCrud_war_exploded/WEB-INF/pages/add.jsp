<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/2/14
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--pom中要添加jstl的依赖-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
    <h1>添加员工</h1>
    <form>
        姓名：<input type="text" name="lastname"/><br>
        邮箱：<input type="text" name="email"/><br>
        性别：<br>
             男<input type="radio" name="gender" value="1"/><br>
             女<input type="radio" name="gender" value="0"/><br>
        部门：<select name="department.id">
                <c:forEach items="${deps}" var="deptItem"><!--循环遍历-->
                    <!--遍历输出id(要提交的值)>和部门名(要展示的信息)-->
                    <option value="${deptItem.id}">${deptItem.departmentName}</option>
                </c:forEach>
              </select>
    <input type="submit" value="提交">
    </form>
</body>
</html>
