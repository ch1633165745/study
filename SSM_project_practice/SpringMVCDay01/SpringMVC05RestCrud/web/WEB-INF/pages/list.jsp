<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/2/12
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--pom中要添加jstl的依赖-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!--设置项目绝对路径-->
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<head>
    <title>员工列表</title>
    <script type="text/javascript" src="${ctp}/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<h1>员工列表</h1>
<table border="1" cellpadding="5px" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>邮箱</th>
        <th>生日</th>
        <th>性别</th>
        <th>部门名</th>
        <th>操作</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
        <td>${emp.id}</td>
        <td>${emp.lastName}</td>
        <td>${emp.email}</td>
        <td>${emp.birth}</td>
        <td>${emp.gender==0?"女":"男"}</td>
        <td>${emp.department.departmentName}</td>
        <td>
            <a href="${ctp}/emp/${emp.id}">EDIT</a>
        </td>
        <td>
            <a href="${ctp}/emp/${emp.id}" class="delBtn">DELETE</a>
        </td>
        </tr>
    </c:forEach>
</table>
<a href="${ctp}/toaddpage">添加员工</a>
<form id="deleteForm" action="${ctp}/emp/${emp.id}" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <script type="text/javascript">
        $(function (){
            alert("hahah");
           $(".delBtn").click(function (){
               $("#deleteForm").attr("action",this.href);
               $("#deleteForm").submit();
              return false;//禁止页面跳转
           });
        });
    </script>
</form>
</body>
</html>
