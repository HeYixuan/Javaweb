/**
 * 鼠标离开文本框事件
 * 
 * @returns {Boolean}
 */
function Onblur() {
	var LoginName = $("#loginName").val();
	var Password = $("#password").val();
	if (LoginName.length == 0) {
		$("#message").html("用户名不能为空");
		return false;
	} else {
		$("#message").html("");
		if (Password.length == 0) {
			$("#message").html("密码不能为空");
			return false;
		} else {
			$("#message").html("");
			return true;
		}
	}
}

/**
 * 鼠标点击登录事件
 */
function Login() {
	var LoginName = $("#loginName").val();
	var Password = $("#password").val();

	if (LoginName.length == 0) {
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
	return true;
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
		var LoginName = $("#loginName").val();
		var Password = $("#password").val();

		if (LoginName.length == 0) {
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
		return true;
	}
};
