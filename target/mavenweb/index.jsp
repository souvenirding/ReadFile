<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/file" method="post">
    选择一个文件:
    <input type="file" name="uploadFile"/>
    <br/><br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
