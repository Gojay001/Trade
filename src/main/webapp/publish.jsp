<%--
  Created by IntelliJ IDEA.
  User: Gojay
  Date: 2017/11/9
  Time: 15:34
  发布商品
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <title>发布商品</title>
</head>
<body>
    <form action="<%=basePath%>/api/goods/publishGoods" enctype="multipart/form-data" method="post">
        <input name="userId" type="hidden" value="5" />
        商品名称：<input name="name" type="text" placeholder="不能为空" /><br/>
        商品价格：<input name="price" type="text" /><br/>
        商品种类：<input name="catagory" type="text" placeholder="不能为空" /><br/>
        商品说明：<input name="detail" type="text" placeholder="不能为空" /><br/>
        商品图片：<br><input type="file" name="file"><br/>
        <input type="file" name="file"><br/>
        <input type="file" name="file"><br/>
        <button type="submit" name="submit">提交</button>
    </form>
</body>
</html>
