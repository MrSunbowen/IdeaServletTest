<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<base href="<%=basePath%>">
<body>
<div>
    <form action="/login" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username" /><br>
        密码：<input type="password" name="password"/><br>
        文件：<input type="file" name="fileName"/>
        验证码：<img src="verifycode.jsp" alt="验证码">
        <input type="submit" value="提交"/>
    </form>

</div>
</body>
</html>