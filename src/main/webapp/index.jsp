<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<body>
    <h2>交易功能测试</h2>
    <hr/>
    <h3>用户测试</h3>
    <a href="register.jsp">用户注册</a><br/>
    <a href="localLogin.jsp">用户登录</a><br/>
    <a href="update.jsp">修改资料</a><br/>
    <hr/>
    <h3>商品测试</h3>
    <a href="publish.jsp">发布闲置商品</a><br>
    <a href="ask.jsp">发布求购商品</a><br/>
    <a href="<%=basePath%>/api/goods/listAskGoods/1">求购商品列表</a><br/>
    <a href="<%=basePath%>/api/goods/listPublishGoodsByTime/1">闲置商品列表（按时间）</a><br/>
    <a href="<%=basePath%>/api/goods/listPublishGoodsByView/1">闲置商品列表（按热度）</a><br/>
    <a href="<%=basePath%>/api/goods/listPublishGoodsByCatagory/book/1">闲置商品列表（按分类）</a><br/>
    <a href="<%=basePath%>/api/goods/listPublishGoodsByName/JAVA/1">闲置商品列表（模糊搜索）</a><br/>
    <a href="<%=basePath%>/api/goods/deleteGoods/3">下架商品</a><br/>
    <a href="<%=basePath%>/api/goods/getGoods/16">查询商品</a><br>
    <hr/>
    <h3>功能测试</h3>
    <a href="<%=basePath%>/api/button/starGoods/3/15">收藏商品</a><br/>
    <a href="<%=basePath%>/api/button/unstarGoods/3/15">取消收藏商品</a><br/>
    <a href="<%=basePath%>/api/button/orderGoods/3/15">预约商品</a><br/>
    <a href="<%=basePath%>/api/button/cancelOrderGoods/13">取消预约商品</a><br/>
    <a href="<%=basePath%>/api/button/finishTrade/13">确认完成交易</a><br/>
    <hr>
    <h3>个人中心</h3>
    <a href="<%=basePath%>/api/personal/showStar/3">我的收藏</a><br>
    <a href="<%=basePath%>/api/personal/showOrder/5">我的预约</a><br>
    <a href="<%=basePath%>/api/personal/showFinish/3">我已完成</a><br>
    <a href="<%=basePath%>/api/personal/showPublish/1">我的发布</a><br>
    <a href="<%=basePath%>/api/personal/showAsk/5">我的求购</a><br>
    <a href="<%=basePath%>/api/personal/showMessage/3">我的消息</a><br>
</body>
</html>
