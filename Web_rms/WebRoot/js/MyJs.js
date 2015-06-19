$(document).ready(function(){
	// 如果快捷添加文件按钮存在
	// 绑定选择事件
	if ($(".filePicker").length > 0) {
		// 绑定选择事件
		$(".filePicker").bind("click", function(e) {
			$("#fileImage").click();
		});
	}

	// 绑定继续添加点击事件
	$(".webuploader_pick").bind("click", function(e) {
		$("#fileImage").click();
	});

	// 如果快捷添加文件按钮存在
	if ($("#rapidAddImg").length > 0) {
		// 绑定添加点击事件
		$("#rapidAddImg").bind("click", function(e) {
			$("#fileImage").click();
		});
	}


	/**
	 * 点击file文件框选择文件之后触发的事件
	 * 
	 * @return
	 */
	$("#fileImage")
			.change(
					function() {
						// 获取文件是什么类型
						var location = $("#fileImage").val();
						var point = location.lastIndexOf(".");
						var type = location.substr(point);
						var selectValues=$("#Format option:selected").val();
						
						if(selectValues=="app"){
							if (type==".apk") {
							var file = $("#fileImage").get(0).files[0];
							if (file) {
								var fileSize = 0;
								fileSize = (Math.round(file.size * 100
										/ (1024 * 1024)) / 100)
										.toString()
										+ 'MB';
								$(".info").html(
										file.name + "您选择了"+1+"个文件  共" + fileSize);
							}

						} else {
							$(".info")
									.html(
											"<span style='color:red'>文件格式不正确</span>");
						}
					}else{
						if (type == ".jpg" || type == ".gif"
							|| type == ".JPG" || type == ".GIF"
							|| type == ".txt"||type==".rar"||type==".zip") {
						var file = $("#fileImage").get(0).files[0];
						if (file) {
							var fileSize = 0;
							
								fileSize = (Math.round(file.size * 100
										/ (1024 * 1024)) / 100)
										.toString()
										+ 'MB';
								$(".info").html(
										file.name + "您选择了"+1+"个文件  共" + fileSize);
						}

					} else {
						$(".info")
								.html(
										"<span style='color:red'>文件格式不正确</span>");
						}
					}
						
				});

/*
 * $(".upload_btn").bind("click",function(e) { // 这里的Edit是按钮的类型是Button而不是Submit
 * alert(Options.type); alert(Options.url); // 这里你可以弹出下你自己的url看看是不是对的
 * $("#uploadForm").ajaxSubmit(Options); // 这里的是你的form表单ID });
 */
	
	var Options = {
			beforeSubmit : checkout, // 提交表单前验证表单数据
			type : "POST",
			url : "upload",  // 请求的URL
			dataType : "json",
			success:function(data){
				// 将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
				// 得到的Tip是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来
				var tip=jQuery.parseJSON(data);
				alert(tip.message);
				$(".info").html("");
				$( "#uploadForm").resetForm();  // 提交成功后重置表单
			},
			error:function(){
				alert("系统异常，请稍后重试！");
			}
	};
	
	$(".upload_btn").click(function(){
		alert(Options.type);
		alert(Options.url); 
		$("#uploadForm").ajaxSubmit(Options);
	});
});
	
	function checkout() {
		var fileName=$("#fileName").val();
		var selectValues=$("#Format option:selected").val();
		if(fileName.length<=0){
			$("#fileNameMessage").html("文件名不能为空");
			return false;
		}else{
			$("#fileNameMessage").html("");
		}
		
		
		
		// 判断当前是否有文件需要上传
		if($("#fileImage").val() != "") {
			// 获取文件是什么类型
						var location = $("#fileImage").val();
						var point = location.lastIndexOf(".");
						var type = location.substr(point);
						
						if(selectValues=="app"){
							if (type == ".apk") {
							var file = $("#fileImage").get(0).files[0];
							if (file) {
								fileSize = (Math.round(file.size * 100
										/ (1024 * 1024)) / 100)
										.toString()
										+ 'MB';
								$(".info").html(
										file.name + "您选择了一个文件  共" + fileSize);
								return true;
							}

						} else {
							$(".info")
									.html(
											"<span style='color:red'>文件格式不正确</span>");
							return false;
						}
					}else{
							if (type == ".jpg" || type == ".gif"
								|| type == ".JPG" || type == ".GIF"
								|| type == ".txt"||type==".rar"||type==".zip") {
							var file = $("#fileImage").get(0).files[0];
							if (file) {
								var fileSize = 0;
								
								fileSize = (Math.round(file.size * 100
										/ (1024 * 1024)) / 100)
										.toString()
										+ 'MB';
								$(".info").html(
										file.name + "您选择了一个文件  共" + fileSize);
								return true;
							}

						} else {
							$(".info")
									.html(
											"<span style='color:red'>文件格式不正确</span>");
							return false;
						}
					}
						
						
			// 如果文件不等于空就执行上传a Ajax
			// $("#fileSubmit").click();
		}else{
			alert("请先选中文件再点击上传");
			return false;
		}
		return true;
	}
	

