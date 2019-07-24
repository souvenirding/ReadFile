<%--
  Created by IntelliJ IDEA.
  User: 丁
  Date: 2019/7/24 0024
  Time: 15:08:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>列表</title>
</head>
<link href="${pageContext.request.contextPath}/bootstrap-dist/css/bootstrap.min.css"
      rel="stylesheet">
<body>
<table class="table table-hover">
    <tr class="active">
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>

    </tr>
    <c:forEach items="${studentlist }" var="student">
        <tr class="success">
            <td>${student.id }</td>
            <td>${student.studentname }</td>
            <td>${student.studentage }</td>
            <td>${student.studentsex }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
