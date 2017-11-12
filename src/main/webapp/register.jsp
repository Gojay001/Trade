<%--
  Created by IntelliJ IDEA.
  User: Gojay
  Date: 2017/11/6
  Time: 13:52
  用户注册
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form name="signUp" method="post" action="<%=basePath%>/api/user/signUp">
        用户名：<input name="username" type="text" placeholder="不超过11个字符" /><br/>
        用户昵称：<input name="nickname" type="text" placeholder="不超过22个字符" /><br/>
        密码：<input name="password" type="password" placeholder="不超过22个字符" /><br/>
        用户电话：<input name="tel" type="text" placeholder="请输入正确的手机号" /><br/>
        用户QQ：<input name="qq" type="text" placeholder="请输入正确的QQ"><br/>
        用户邮箱：<input name="email" type="text" placeholder="请输入正确的邮箱" /><br/>
        用户地址：<input name="address" type="text" placeholder="地址不能为空" /><br/>
        <button name="submit" type="submit">提交</button>
    </form>
</body>
</html>
