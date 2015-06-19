(function($) {
	$("#btn")
			.click(
					function() {
						
						/*var loginName=$('#username').val();
						var password=$('#password').val();
						var email=$('#email').val();*/

						
						var Username = $("#Username").val();
						var Password = $("#Password").val();
						var Email = $("#Email").val();
						var EmailReg = /^(([a-z,A-Z,0-9_-]{6,11})@([a-z,A-Z]{2,4}|126|163|189)\.([a-z,A-Z]{2,3}))$/i;
						
						if (Username.length == 0) {
							$("#UsernameMessage").html("用户名不能为空");
							return false;
						}else if (Username.length < 6 || Username.length > 14) {
							$("#UsernameMessage").html("用户名长度错误");
							return false;
						} else {
							$("#UsernameMessage").html("");
						}

						if (Password.length == 0) {
							$("#PasswordMessage").html("密码不能为空");
							return false;
						}else if (Password.length < 6 || Password.length > 14) {
							$("#PasswordMessage").html("密码长度错误");
							return false;
						} else {
							$("#PasswordMessage").html("");
						}
						
						if(Email.length==0){
							$("#EmailMessage").html("邮箱不能为空");
							return false;
						}else if(!EmailReg.test(Email)){
							$("#EmailMessage").html("邮箱格式 例:name@126.com");
							return false;
						}else{
							$("#EmailMessage").html("");
							
							$.ajax({
								type : "POST",
								url : "ajaxUpdate.action",
								dataType : "json",
								data : {
									"user.loginName" : $("#Username").val(),
									"user.password" : $("#Password").val(),
									"user.email" : $("#Email").val(),
								},
								success : function(data) {// 回调函数
										alert(data);
								}

							}); 
						}
						
						 //END Ajax
						
					});
})(jQuery);