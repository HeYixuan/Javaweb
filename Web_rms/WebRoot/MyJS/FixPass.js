/**
 * 鼠标离开文本框事件
 * 
 * @returns {Boolean}
 */
function Onblur() {
	var Password = $("#Password").val();
	var NewPass = $("#new_pass").val();
	var SurePassword = $("#sure_password").val();
	
	if (Password.length == 0) {
		$("#PasswordMessage").html("密码不能为空");
		return false;
	} else if (Password.length < 6 || Password.length > 16) {
		$("#PasswordMessage").html("密码长度小于6位或大于16位");
		return false;
	} else {
		$("#PasswordMessage").html("");
	}

	if (NewPass.length == 0) {
		$("#NewPassMessage").html("密码不能为空");
		return false;
	} else if (NewPass.length < 6 || NewPass.length > 16) {
		$("#NewPassMessage").html("密码长度小于6位或大于16位");
		return false;
	} else {
		$("#NewPassMessage").html("");
	}

	if (SurePassword.length == 0) {
		$("#SurePassMessage").html("密码不能为空");
		return false;
	} else if (SurePassword.length < 6 || SurePassword.length > 16) {
		$("#SurePassMessage").html("密码长度小于6位或大于16位");

	} else if (SurePassword != NewPass) {
		$("#SurePassMessage").html("两次密码不一致");
		return false;
	} else {
		$("#SurePassMessage").html("");
	}
}

/**
 * 鼠标点击修改密码事件
 */
function UpdatePass() {
	var Password = $("#Password").val();
	var NewPass = $("#new_pass").val();
	var SurePassword = $("#sure_password").val();

	if (Password.length == 0) {
		$("#PasswordMessage").html("密码不能为空");
		return false;
	} else if (Password.length < 6 || Password.length > 16) {
		$("#PasswordMessage").html("密码长度小于6位或大于16位");
		return false;
	} else {
		$("#PasswordMessage").html("");
	}

	if (NewPass.length == 0) {
		$("#NewPassMessage").html("密码不能为空");
		return false;
	} else if (NewPass.length < 6 || NewPass.length > 16) {
		$("#NewPassMessage").html("密码长度小于6位或大于16位");
		return false;
	} else {
		$("#NewPassMessage").html("");
	}

	if (SurePassword.length == 0) {
		$("#SurePassMessage").html("密码不能为空");
		return false;
	} else if (SurePassword.length < 6 || SurePassword.length > 16) {
		$("#SurePassMessage").html("密码长度小于6位或大于16位");
		return false;
	} else if (SurePassword != NewPass) {
		$("#SurePassMessage").html("两次密码不一致");
		return false;
	} else {
		$("#SurePassMessage").html("");
		
		$.ajax({
			type:"POST",
			dataType:"text",
			url:"UpdatePass.action",
			data:{
				"Password":Password,
				"new_pass":NewPass,
				"sure_password":SurePassword
			},
			success:function(data){
				alert(data);
			},
			error:function(){
				alert("通讯有问题,请稍候尝试...");
			}
		});
	}
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

	}
};
