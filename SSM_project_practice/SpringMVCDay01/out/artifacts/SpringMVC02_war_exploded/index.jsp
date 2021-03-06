<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/2/11
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!--使用REST风格的URL地址，发起图书的增删改查请求
  /book/1  GET：   查询1号图书
  /book/1  DELETE：删除1号图书
  /book/1  PUT：   修改1号图书
  /book    POST：  添加1号图书
  -->
  <!--发起get请求-->
  <a href="/book/1">查询图书</a>

  <!--发起delete请求的表单-->
  <form action="/book/1" method="post"><!--第一步，创建一个post表单-->
    <input name="_method" value="delete"/><!--表单中携带一个_method参数，其值为delete-->
    <input type="submit" value="删除1号图书"/>
  </form>

  <!--发起put请求的表单-->
  <form action="/book/1" method="post"><!--第一步，创建一个post表单-->
    <input name="_method" value="put"/><!--表单中携带一个_method参数，其值为put-->
    <input type="submit" value="修改1号图书"/>
  </form>

  <!--发起post请求的表单-->
    <form action="/book" method="post">
      <input type="submit" value="添加1号图书"/>
    </form>
  </body>
</html>
