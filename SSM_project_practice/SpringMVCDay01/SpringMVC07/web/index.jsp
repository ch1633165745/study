<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/2/16
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  pageContext.setAttribute("ctp",request.getContextPath());
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!--文件上传-->
  <!--1、文件上传表单准备enctype="multipart/form-data"-->
  <!--2、到入jar包commons-fileupload和commons-io-->
  <!--3、springMVC配置文件中：编写配置，配置文件上传解析器（MultipartResolver）-->
  <!--4、文件上传请求处理
          @RequestParam("headerIMG") MultipartFile file，其封装了当前文件信息-->
  ${msg}
  <form action="${ctp}/upload" method="post" enctype="multipart/form-data">
    用户头像：<input type="file" name="headerIMG"/><br>
    用户名：<input type="text" name="username"/><br>
    <input type="submit" value="提交"/>
  </form>
  <a href="/test01">test01拦截器测试</a>
  </body>
</html>
