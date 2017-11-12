<%--
  Created by IntelliJ IDEA.
  User: Gojay
  Date: 2017/11/6
  Time: 16:11
  用户登录
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <form action="<%=basePath%>/api/user/signIn" method="post">
        用户名：<input name="username" type="text" placeholder="用户名" /><br/>
        密码：<input name="password" type="text" placeholder="密码" /><br/>
        <button name="submit" type="submit">提交</button><br/>
    </form>
</body>
</html>