<%--
  Created by IntelliJ IDEA.
  User: 陈浩
  Date: 2021/2/14
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--pom中要添加jstl的依赖-->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %><!--spring提供的表单标签库-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工修改</title>
</head>
<body>
<h1>修改员工（与添加页面差不多）</h1>
<!--表单标签可以实现将模型数据中的属性和HTML表单元素绑定，更加快捷编辑和表单回显
    modelAttribute：
        1）以前表单标签会从请求域中获取一个command对象，把command对象中的每一个属性对应显示出来
        2）可以用modelAttribute指定一个代替command对象
    pageContext.setAttribute:使用pageContext域空间，传入request.getContextPath()站点的根路径(当前项目路径)
    修改发送put请求，先声明为post再修改为put-->
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>

<form:form action="${ctp}/emp/${employee.id}" modelAttribute="employee" method="post">
    <input type="hidden" name="_method" value="put">
    <!--通过隐藏域为获取的id-->
    <input type="hidden" name="id" value="${employee.id}">
    <!--相当于之前form表单input中的name项
        path作用：当作原生的那么项，自动回显隐含模型中某个对象对应的这个属性的值
        springmvc认为，数据中表单的每一项都是要回显的
        path指定的是一个属性，这个属性是从隐含模型（请求域中取出的的某个对象中的属性）
        注意：请求域中必须有一个对象拥有这个属性command
        command用于设置需在EmployeeController中添加在请求域（必须要求否则会报错），
        且path中所使用到的属性command中也一定要求-->
    邮箱：<form:input path="email"/><br>
    性别：&nbsp;&nbsp;&nbsp;
         男<form:radiobutton path="gender" value="1"/>&nbsp;&nbsp;&nbsp;
         女<form:radiobutton path="gender" value="0"/><br>
        <!--items指明要遍历的集合(请求域中的数据):自动遍历，遍历出的每一个元素是一个department对象
            itemLabel="属性"：表示指定遍历出的这个对象的哪个属性是作为option标签体的值(也就是要显示的信息)
            itemValue="属性"：表示指定遍历出的这个对象的哪个属性是作为要提交的value值(也就是要提交的信息)
        -->
    部门：<form:select path="department.id"
                      items="${deps}"
                      itemLabel="departmentName"
                      itemValue="id"></form:select><br>
    <input type="submit" value="修改">
</form:form>

</body>
</html>
