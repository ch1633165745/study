<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/2/10
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/hello">hello发送请求</a><br>
  <a href="/antTest01">精确请求地址-antTest01发送请求</a><br>
  <a href="/antTest02">模糊？请求地址-antTest02发送请求</a><br>
  <a href="/antTest03">模糊*请求地址-antTest03发送请求</a><br>
  <a href="/antTest04">模糊/*请求地址-antTest04发送请求</a><br>
  <a href="/antTest05">模糊/**请求地址-antTest05发送请求</a><br>
  <a href="/user/admin">{}占位符发送请求</a><br>

  </body>
</html>
