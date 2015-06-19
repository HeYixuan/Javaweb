var pageCount = '';
var pageIndex=1;
$(document).ready(function(){
	var selectVal=$("#Format option:selected").val();
		$.ajax({
			type:"post",
			url:"FindList",
			dataType:"json",
			data:{"Format":selectVal},
			success:function(data){
				var datas=jQuery.parseJSON(data);
				
				var strtable = "<table class='table table-bordered data-table table-hover'>";
							strtable+="<tbody class='tbody'>";
							for(var i=0;i<datas.pageList.list.length;i++){
								
								strtable+="<tr>";
								strtable+="<td>"+datas.pageList.list[i].description+"  <a href="+"/Web_zihuan/Files/"+datas.pageList.list[i].url+">下载</a></td>";
								strtable+="</tr>";
							}
							strtable+="</tbody>";
							strtable+="</table>";
				
				var strPage="<a href='javascript:Flash(1)' id='first' class='first ui-corner-tl ui-corner-bl fg-button ui-button'>首页</a>";
				strPage+="<a onclick='Previous()' id='previous' class='previous fg-button ui-button'>上一页</a>"; 
				strPage+="<input type='hidden' id='pageCount' value='"+datas.pageList.pageCount+"'>";
				strPage+="<a onclick='Next()' id='next' class='next fg-button ui-button'>下一页</a>";
				strPage+="<a href='javascript:Flash("+datas.pageList.pageCount+")' id='last' class='last ui-corner-tr ui-corner-br fg-button ui-button'>末页</a>";
				
				
				
				$("#Page").html(strPage);
				$("#Mydiv").html(strtable);
				pageCount=$("#pageCount").val();
				
			
			},
			error:function(){
				alert("通讯有问题,请稍候刷新再试!");
			}
		});
});


	$("#Format").change(function(){
		var selectVal=$("#Format option:selected").val();
		$.ajax({
			type:"post",
			url:"FindList",
			dataType:"json",
			data:{"Format":selectVal},
			success:function(data){
				var datas=jQuery.parseJSON(data);
				
				var strtable = "<table class='table table-bordered data-table table-hover'>";
							strtable+="<tbody class='tbody'>";
							for(var i=0;i<datas.pageList.list.length;i++){
								
								strtable+="<tr>";
								strtable+="<td>"+datas.pageList.list[i].description+"  <a href="+"/Web_zihuan/Files/"+datas.pageList.list[i].url+">下载</a></td>";
								strtable+="</tr>";
							}
							strtable+="</tbody>";
							strtable+="</table>";
							
				var strPage="<a href='javascript:Flash(1)' id='first' class='first ui-corner-tl ui-corner-bl fg-button ui-button'>首页</a>";
				strPage+="<a onclick='Previous()' id='previous' class='previous fg-button ui-button'>上一页</a>"; 
				strPage+="<input type='hidden' id='pageCount' value='"+datas.pageList.pageCount+"'>";
				strPage+="<a onclick='Next()' id='next' class='next fg-button ui-button'>下一页</a>";
				strPage+="<a href='javascript:Flash("+datas.pageList.pageCount+")' id='last' class='last ui-corner-tr ui-corner-br fg-button ui-button'>末页</a>";
				
							
				
				$("#Page").html(strPage);
				$("#Mydiv").html(strtable);
				pageCount=$("#pageCount").val();
			
			},
			error:function(){
				alert("通讯有问题,请稍候刷新再试!");
			}
		});
	});
	
	
	
	function Flash(parms){
		var selectVal=$("#Format option:selected").val();
		$.ajax({
			type:"post",
			url:"FindList",
			dataType:"json",
			data:{"Format":selectVal,
				"pageIndex":parms
				},
			success:function(data){
				var datas=jQuery.parseJSON(data);
				
				var strtable = "<table class='table table-bordered data-table table-hover'>";
							strtable+="<tbody class='tbody'>";
							for(var i=0;i<datas.pageList.list.length;i++){
								strtable+="<tr>";
								strtable+="<td>"+datas.pageList.list[i].description+"  <a href="+"/Web_zihuan/Files/"+datas.pageList.list[i].url+">下载</a></td>";
								strtable+="</tr>";
							}
							strtable+="</tbody>";
							strtable+="</table>";
				
				var strPage="<a href='javascript:Flash(1)' id='first' class='first ui-corner-tl ui-corner-bl fg-button ui-button'>首页</a>";
				strPage+="<a onclick='Previous()' id='previous' class='previous fg-button ui-button'>上一页</a>"; 
				strPage+="<input type='hidden' id='pageCount' value='"+datas.pageList.pageCount+"'>";
				strPage+="<a onclick='Next()' id='next' class='next fg-button ui-button'>下一页</a>";
				strPage+="<a href='javascript:Flash("+datas.pageList.pageCount+")' id='last' class='last ui-corner-tr ui-corner-br fg-button ui-button'>末页</a>";
				
				
				$("#Page").html(strPage);
				$("#Mydiv").html(strtable);
				pageCount=$("#pageCount").val();
			
			},
			error:function(){
				alert("通讯有问题,请稍候刷新再试!");
			}
		});
		
	}
	
		
		function Next(){
			if(pageCount>+pageIndex){
				pageIndex++;
				Flash(pageIndex);
			}
			
		}
		
		function Previous(){
			pageIndex--;
			Flash(pageIndex);
			if((pageIndex--)<=1){
				pageIndex=1;
			}
		}
			