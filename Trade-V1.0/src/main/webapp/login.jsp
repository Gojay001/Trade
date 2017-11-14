<%--
  Created by IntelliJ IDEA.
  User: Gojay
  Date: 2017/11/7
  Time: 23:50
  交互注册页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form id="form">
        用户名：<input name="username" type="text" placeholder="不超过11个字符" class="input1" /><br/>
        用户昵称：<input name="nickname" type="text" placeholder="不超过22个字符" class="input2" /><br/>
        密码：<input name="password" type="password" placeholder="不超过22个字符" class="input3" /><br/>
        用户电话：<input name="tel" type="text" placeholder="请输入正确的手机号" class="input4" /><br/>
        用户QQ：<input name="qq" type="text" placeholder="请输入正确的QQ" class="input5" /><br/>
        用户邮箱：<input name="email" type="text" placeholder="请输入正确的邮箱" class="input6" /><br/>
        用户地址：<input name="address" type="text" placeholder="地址不能为空" class="input7" /><br/>
    </form>
    <button id="submit" type="submit">注册</button>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="UTF-8">
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
                "address":  inputs[6].value
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
                alert(data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("请求失败！");
            }
        });
    }
</script>
</body>
</html>