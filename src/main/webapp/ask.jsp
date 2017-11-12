<%--
  Created by IntelliJ IDEA.
  User: Gojay
  Date: 2017/11/7
  Time: 13:52
  发布求购商品
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>发布求购商品</title>
</head>
<body>
    <form action="<%=basePath%>/api/goods/askGoods" method="post">
        <input name="userId" type="hidden" value="5" />
        商品名称：<input name="name" type="text" placeholder="不能为空" /><br/>
        商品价格：<input name="price" type="text" /><br/>
        商品种类：<input name="catagory" type="text" placeholder="不能为空" /><br/>
        商品说明：<input name="detail" type="text" placeholder="不能为空" /><br/>
        <button name="submit" type="submit">确认发布</button>
    </form>
</body>
</html>
