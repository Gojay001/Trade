<%--
  Created by IntelliJ IDEA.
  User: Gojay
  Date: 2017/11/12
  Time: 12:15
  注册页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/homepage.css">
    <link rel="stylesheet" type="text/css" href="../css/signUp.css">
    <link rel="stylesheet" type="text/css" href="../css/reast.css">
    <link rel="stylesheet" type="text/css" href="../css/head&footer.css">
    <link rel="stylesheet" type="text/css" href="../css/login.css">
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
                <a href="##">发布闲置</a>
            </li>
            <li>
                <a href="##">发布求购</a>
            </li>
            <li>
                <a href="##">个人中心</a>
            </li>
        </ul>
    </div>

    <!--登录栏-->
    <div class="login">
        <span><a href="##">注册</a></span>
        <span><a href="javascript:showDialog();" id="login">登录</a></span>
    </div>
</div>
<!--头部结尾-->


<!--主要部分-->
<div id="signUp">
    <form id="form">
        姓名:<input type="text"><br>
        昵称:<input type="text"><br>
        密码:<input type="text"><br>
        电话:<input type="text"><br>
        QQ:<input type="text" class="qq"><br>
        邮箱:<input type="text"><br>
        地址:<input type="text"><br>
    </form>
    <button id="submit" type="submit" class="submit">注册</button>
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
<script type="text/javascript" src="../js/log.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<script type="text/javascript">
    var btn = document.getElementById('submit');
    var form = document.getElementById('form');
    var inputs = form.getElementsByTagName('input');
    btn.onclick = function() {
        var url = "http://nmid.gojay.xin:8080/Trade/api/user/signUp";
        $.ajax({
            type: "post",
            url: url,
            data: {
                "username": inputs[0].value,
                "nickname":  inputs[1].value,
                "password":  inputs[2].value,
                "tel":  inputs[3].value,
                "qq":  inputs[4].value,
                "email":  inputs[5].value,
                "address":  inputs[6].value,
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
                if (data.statusCode == 200) {
                    alert('注册成功');
                }
                else{
                    alert('注册失败');
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    }
</script>
</body>
</html>