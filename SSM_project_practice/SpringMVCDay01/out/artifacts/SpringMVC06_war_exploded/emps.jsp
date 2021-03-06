<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/2/16
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--设置相对路径，当前工程下-->
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/webjars/jquery/3.3.1-2/jquery.min.js"></script>
</head>
<body>
<%=new Date()%>>
<a href="${ctp}/getallajax">ajax获取所有员工</a><br>
<div>

</div>
<script type="text/javascript">
    $("a:first").click(function (){//绑定单击事件
        //1、发送ajax请求，获取所有员工
        $.ajax({
            url:"${ctp}/getallajax",//地址
            type:"GET",//请求方式
            success:function (data){//成功后执行的操作
                $("div").empty();//每次执行前清空一下div
                //console.log(data)//成功后向控制台打印日期
                $.each(data,function (){//遍历输出到div中
                    var empInfo=this.lastName+"--->"+this.birth+"---->"+this.gender;
                   $("div").append(empInfo+"<br/>");
                });
            }
        });
        return false;//禁止页面跳转
    });
</script>
</body>
</html>
