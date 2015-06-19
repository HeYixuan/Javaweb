/**
 * 鼠标离开文本框事件
 * 
 * @returns {Boolean}
 */


function Onblur() {

	var LoginName = $("#loginName").val();
	var Password = $("#password").val();
	var SurePassword = $("#sure_password").val();
	var Email = $("#email").val();

	/*var EmailReg = /^(([a-z,A-Z,0-9_-]{6,11})@([a-z,A-Z]{2,4}|126|163|189)\.([a-z,A-Z]{2,3}))$/i;*/
	var EmailReg = /^(([a-z,A-Z,0-9_-]{1,11})@([a-z,A-Z，0-9]{2,4}|126|163|189)\.([a-z,A-Z]{2,3}))$/i;

	if (LoginName.length == 0) {
		$("#message").html("用户名不能为空");
		return false;
	} else if (LoginName.length < 6 || LoginName.length > 16) {
		$("#message").html("用户名长度小于6位或大于16位");
		return false;
	} else {
		$("#message").html("");
	}

	if (Password.length == 0) {
		$("#message").html("密码不能为空");
		return false;
	} else if (Password.length < 6 || Password.length > 16) {
		$("#message").html("密码长度小于6位或大于16位");
		return false;
	} else {
		$("#message").html("");
	}

	if (SurePassword.length == 0) {
		$("#message").html("密码不能为空");
		return false;
	} else if (SurePassword.length < 6 || SurePassword.length > 16) {
		$("#message").html("密码长度小于6位或大于16位");
		return false;
	} else if (SurePassword != Password) {
		$("#message").html("密码不一致");
		return false;
	} else {
		$("#message").html("");
	}

	if (Email.length == 0) {
		$("#message").html("邮箱不能为空");
		return false;
	} else if (!EmailReg.test(Email)) {
		$("#message").html("邮箱格式不正确      例:123456@126.com");
		return false;
	} else {
		$("#message").html("");
	}
}

/**
 * 鼠标点击登录事件
 */
function Login() {
	/*
	 * var LoginName = $("#loginName").val(); var Password =
	 * $("#password").val();
	 */

	var LoginName = $("#loginName").val();
	var Password = $("#password").val();
	var SurePassword = $("#sure_password").val();
	var Email = $("#email").val();

	var EmailReg = /^(([a-z,A-Z,0-9_-]{6,11})@([a-z,A-Z]{2,4}|126|163|189)\.([a-z,A-Z]{2,3}))$/i;

	if (LoginName.length == 0) {
		$("#message").html("用户名不能为空");
		return false;
	} else if (LoginName.length < 6 || LoginName.length > 16) {
		$("#message").html("用户名长度小于6位或大于16位");
		return false;
	} else {
		$("#message").html("");
	}

	if (Password.length == 0) {
		$("#message").html("密码不能为空");
		return false;
	} else if (Password.length < 6 || Password.length > 16) {
		$("#message").html("密码长度小于6位或大于16位");
		return false;
	} else {
		$("#message").html("");
	}

	if (SurePassword.length == 0) {
		$("#message").html("密码不能为空");
		return false;
	} else if (SurePassword.length < 6 || SurePassword.length > 16) {
		$("#message").html("密码长度小于6位或大于16位");
		return false;
	} else if (SurePassword != Password) {
		$("#message").html("密码不一致");
		return false;
	} else {
		$("#message").html("");
	}

	if (Email.length == 0) {
		$("#message").html("邮箱不能为空");
		return false;
	} else if (!EmailReg.test(Email)) {
		$("#message").html("邮箱格式不正确      例:123456@126.com");
		return false;
	} else {
		$("#message").html("");
		
		$.ajax({
			type : "POST",
			url:"Register.action",
			dataType:"text",
			data:{
				"user.loginName":LoginName,
				"user.password":Password,
				"sure_password":Password,
				"user.email":Email
			},
			success:function(data){
				/*alert(data);*/
				$("#message").html(data);
			},
			error:function(){
				alert("通讯有问题,请稍候尝试...");
			}
			
		});
	}
	/*LoginForm.submit();
	return true;*/
}

/**
 * 获取键盘按下事件
 */
document.onkeydown = function(event) {
	var e = event || window.event || arguments.callee.caller.arguments[0];
	if (e && e.keyCode == 27) { // 按下 Esc
		// 处理事件
	}
	if (e && e.keyCode == 113) { // 按下F2
		// 处理事件
	}
	if (e && e.keyCode == 13) { // Enter事件
		// 处理事件
		/*
		 * var LoginName = $("#loginName").val(); var Password =
		 * $("#password").val();
		 */

	/*	if (LoginName.length == 0) {
			$("#message").html("用户名不能为空");
			return false;
		} else {
			$("#message").html("");
		}

		if (Password.length == 0) {
			$("#message").html("密码不能为空");
			return false;
		} else {
			$("#message").html("");
		}
		LoginForm.submit();
		return true;*/
	}
};
