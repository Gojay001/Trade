login ();



function login() {
	var sub_log = document.getElementById('sub_log');
	var log_page = document.getElementById('log_page');
	var username = document.getElementById('sub_username');
	var password = document.getElementById('sub_password');

	sub_log.onclick = function() {
    	var url = "http://nmid.gojay.xin:8080/Trade/api/user/signIn";
    	$.ajax({
        	type: "post",
        	url: url,
        	data: {
            	"username": username.value,
              	"password": password.value,
        	},
        	dataType: "json",
        	success: function (data) {
        		if (data.statusCode == 200) {
        			log_page.style.display = 'none';
        		}
            	else {
            		username.value = "用户名或密码错误";
            	}
           	},
        	error: function (XMLHttpRequest, textStatus, errorThrown) {
            	alert("请求失败！");
        	}
    	});
		
	}
}