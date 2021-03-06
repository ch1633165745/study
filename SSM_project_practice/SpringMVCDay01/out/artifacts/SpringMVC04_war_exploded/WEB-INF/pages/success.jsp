<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/2/12
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>（map、model、modelMap）和ModelAndView可以通过哪四大域在页面调用</h1>
<!--在页面处获取域中的数据-->
pageContext:${pageScope.msg}<br/>
request:${requestScope.msg}<br/>
session:${sessionScope.msg}<br/>
application:${applicationScope.msg}<br/>
</body>
</html>
