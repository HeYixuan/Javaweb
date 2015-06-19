

	function onLoad(){
	    //获取每一行每第二个td
	    var numId=$(".tbody tr td:nth-child(2)").each(function(){
	            });
	    numId.dblclick(function(){
	        var tdIns=$(this);
	        var tdpar=$(this).parents("tr");

	        var tdId=$(this).attr("id");
	        /*alert(tdId);*/
	        tdpar.css("backgroundColor","yellow");

	        if(tdIns.children("input").length>0){
	            return false;
	        }

	       
	        var text = $(this).html();
	        var inputIns = $("<input type='text'/>"); //需要插入的输入框代码 
	        inputIns.width(tdIns.width);//设置input与td宽度一致 
	        inputIns.height("36px");
	        inputIns.val(tdIns.html());//将本来单元格td内容copy到插入的文本框input中
	        
	        /*alert(tdId);*/
	        tdIns.html(""); //删除原来单元格td内容 

	        inputIns.appendTo(tdIns).focus().select(); //将需要插入的输入框代码插入dom节点中 

	        inputIns.click(function(){
	            return false;
	        }); 

	        //处理Enter和Esc事件   
	        inputIns.blur(function(){   
	        var inputText = $(this).val();  
	        tdIns.html(inputText);  
	        tdpar.css("background-color","white");
	                // tdIns.html(text);  
	        alert(tdId);
		        $.ajax({
		            type:"post",
		            url:"AjaxList",
		            data:{
		            	"loginName":tdIns.html(),
		            	"id":tdId
		            	},
			        success:function(data){
			        	alert(data);
			        },
			        error : function() {
						alert("通讯有问题,请稍候刷新...");
					}
		        });
	        }); 

	    });
	}
	
$(document).ready(function() {
    // Stuff to do as soon as the DOM is ready;
	  
	/*var numId = $(".tbody td");*/  //获取每一行每一个td

    //获取每一行每第二个td
	
    var numId=$(".tbody tr td:nth-child(2)").each(function(){
            });
    numId.dblclick(function(){
        var tdIns=$(this);
        var tdpar=$(this).parents("tr");

        var tdId=$(this).attr("id");
        /*alert(tdId);*/
        tdpar.css("backgroundColor","yellow");

        if(tdIns.children("input").length>0){
            return false;
        }

       
        var text = $(this).html();
        var inputIns = $("<input type='text'/>"); //需要插入的输入框代码 
        inputIns.width(tdIns.width);//设置input与td宽度一致 
        inputIns.height("36px");
        inputIns.val(tdIns.html());//将本来单元格td内容copy到插入的文本框input中
        
        /*alert(tdId);*/
        tdIns.html(""); //删除原来单元格td内容 

        inputIns.appendTo(tdIns).focus().select(); //将需要插入的输入框代码插入dom节点中 

        inputIns.click(function(){
            return false;
        }); 

        //处理Enter和Esc事件   
        inputIns.blur(function(){   
        var inputText = $(this).val();  
        tdIns.html(inputText);  
        tdpar.css("background-color","white");
                // tdIns.html(text);  
        alert(tdId);
	        $.ajax({
	            type:"post",
	            url:"AjaxList",
	            data:{
	            	"loginName":tdIns.html(),
	            	"id":tdId
	            	},
		        success:function(data){
		        	alert(data);
		        },
		        error : function() {
					alert("通讯有问题,请稍候刷新...");
				}
	        });
        }); 

    });
});