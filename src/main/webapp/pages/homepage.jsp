<%--
  Created by IntelliJ IDEA.
  User: Gojay
  Date: 2017/11/11
  Time: 21:05
  首页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/homepage.css">
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <link rel="stylesheet" type="text/css" href="../css/reast.css">
    <link rel="stylesheet" type="text/css" href="../css/head&footer.css">
    <title>邮货</title>
</head>
<body>
<!--登录页面-->
<div id="log_page" style="display: none;">
    <div class="mask" id="mask" onselectstart="return false"></div>

    <div class="dialog" id="dialogMove" onselectstart='return false;'>

        <div class="title" id="dialogDrag"  onselectstart="return false;" >
            登录通行证
            <a class="closebutton" href="javascript:hideDialog();"></a>
        </div>

        <div class="content">
            <div class="login pt">
                <input class="input username" type="input" placeholder="手机/邮箱/用户名" value="" id="sub_username" />
            </div>

            <div class="login pt">
                <input class="input password" type="password" placeholder="密码" value="" id="sub_password" />
            </div>

            <div class="login">
                <a href="#">忘记密码</a>
            </div>

            <div>
                <a class="submit" href="#" id="sub_log">登录</a>
            </div>

            <div class="login">
                <a href="#">立即注册</a>
            </div>
        </div>

    </div>
</div>


<!--头部-->
<div id="header">
    <div class="top-nav">
        <h1>邮货</h1>
        <p><a href="##">重庆邮电大学二手交易平台</p>
        <ul class="nav-slider">
            <li>
                <a href="##">首页</a>
            </li>
            <li>
                <a href="http://nmid.gojay.xin:8080/Trade/publish.jsp">发布闲置</a>
            </li>
            <li>
                <a href="http://nmid.gojay.xin:8080/Trade/ask.jsp">发布求购</a>
            </li>
            <li>
                <a href="http://nmid.gojay.xin:8080/Trade/index.jsp">个人中心</a>
            </li>
        </ul>
    </div>

    <!--登录栏-->
    <div class="login">
        <span><a href="http://nmid.gojay.xin:8080/Trade/pages/signUp.jsp">注册</a></span>
        <span><a href="javascript:showDialog();" id="login">登录</a></span>
    </div>
</div>
<!--头部结尾-->


<!--主要部分-->
<div id="main">

    <!--上半部分-->
    <div class="main-top">

        <!--商品分类-->
        <div class="goods-list">
            <ul>
                <li>
                    <img src="../images/photo.png">
                    <span>
						<a href="##">数码产品</a>
						<a href="##">手机</a>
						<a href="##">笔记本电脑</a>
						<a href="##">平板电脑</a>
					</span>
                </li>
                <hr>
                <li>
                    <img src="../images/computer.png">
                    <span>
						<a href="##">家电</a>
						<a href="##">电热水壶</a>
						<a href="##">榨汁机</a>
						<a href="##">吹风机</a>
						<a href="##">饮水机</a>
					</span>
                </li>
                <hr>
                <li>
                    <img src="../images/clothes.png">
                    <span>
						<a href="##">服饰鞋帽</a>
						<a href="##">鞋子</a>
						<a href="##">上衣</a>
						<a href="##">吹风机</a>
						<a href="##">裤子</a>
					</span>
                </li>
                <hr>
                <li>
                    <img src="../images/other.png">
                    <span>
						<a href="##">日用品</a>
						<a href="##">洗衣液</a>
						<a href="##">洗衣皂</a>
						<a href="##">二手化妆品</a>
					</span>
                </li>
                <hr>
                <li>
                    <img src="../images/book.png">
                    <span>
						<a href="##">书</a>
						<a href="##">教材</a>
						<a href="##">计算机类丛书</a>
						<a href="##">雅思托福词汇</a>
					</span>
                </li>
            </ul>
            <div class="list-box">
                <div></div>
            </div>

        </div>
        <!--banner-->
        <div class="banner">
            <div class="banner-container">
                <img src="../images/banner1.png">
            </div>
        </div>
        <!--登录-->
        <div class="sign">
            <!--头像-->
            <div class="avater">
                <div class="avater-detail">
                    <img src="../images/avatar.png">
                </div>
                <span>你好！橘子 同学</span>
            </div>

            <!--发布-->
            <div class="publish">
                <div class="publish-bar">
                    <img src="../images/sign-1.png">
                    <span><a href="##">发布闲置</a></span>
                </div>
                <div class="publish-bar">
                    <img src="../images/sign-2.png">
                    <span><a href="##">发布求购</a></span>
                </div>
            </div>
        </div>
    </div>
    <!--上半部分结尾-->

    <!--下半部分-->
    <div class="main-bottom">
        <div class="bottom-wrapper">
            <!--标题-->
            <div class="bottom-title">
                <p><a href="##">热度</a></p>
                <p><a href="##">发起时间</a></p>
            </div>

            <!--商品列表-->
            <div class="goods-content">
                <ul>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-1.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-2.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-3.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-4.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-5.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                </ul>
                <ul>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-3.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-5.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-1.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-4.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                    <li>
                        <div class="goods-detail">
                            <img src="../images/goods-2.png">
                            <p><a href="##">七成新国行iPhoneX</a></p>
                            <p>售价：<span>1200</span></p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>

        <!--分页栏-->
        <div id="pagebar">
            <ul id="number">
                <li>首页</li>
                <li>上一页</li>
                <li id="select"></li>
                <li id="select"></li>
                <li id="select"></li>
                <li>下一页</li>
                <li>尾页</li>
                <input type="type" id="search">
                <input type="button" value="跳转" id="btn">
            </ul>
        </div>
    </div>
    <!--下半部分结尾-->
</div>
<!--主要部分结尾-->


<!--底部-->
<div id="footer">
    <p>版权所有|重庆邮电大学|重庆市南岸区崇文路2号|400065|渝ICP备：17002788号-1</p>
    <p>
        <a href="##">
            <img src="../images/plice.png">
        </a>
        渝公网安备 50010802001309号
    </p>
</div>
<!--底部结尾-->
<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/pagebar.js"></script>
<script type="text/javascript" src="../js/log.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
</body>
</html>