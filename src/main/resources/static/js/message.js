$(function(){
	//查询所有
  	$("#xs").click(function(){
  		$.ajax({
	  		"type":"get",
	  		"dataType":"json",
	  		"url":"/message/all",
	  		"success":function(rep){
	  			$("#message_table tr").remove("");
		  		for (var i = 0; i < rep.length; i++) {
					$("#message_table").append(pj(rep[i]));
				}
	  		}	
	  	});
  	});
  	//修改前查询
  	$("#xgxx").click(function(){
  		var message={
  			"id":$("#id").html(),
  			"title":$("#title").val(),
			"content":$("#content").val()
  		};
  		$.ajax({
  			"type":"post",
  			"dataType":"json",
  			"data":message,
  			"url":"/message/cxyt"+id,
  			"success":function(rep){
  				
  			}
  		});
  	});
  	
  //修改	
  	$("#qrxg").click(function(){
  		var data={
  				"id":$("#id").html(),
				"title":$("#xiugai_title").val(),
				"content":$("#xiugai_content").val()
  		};
  		$.ajax({
  			"type":"post",
  			"dataType":"json",
  			"data":data,
  			"url":"/message/update",
  			"success":function(rep){
  				if(rep.code==1){
  					alert("修改成功");
  				}
  			}
  		});
  	});
  	
  	$("#qrtj").click(function(){
  		var message={
  				"title":$("#xiugai_title").val(),
  				"content":$("#xiugai_content").val()
  		};
  		$.ajax({
  			"type":"post",
  			"dataType":"json",
  			"data":message,
  			"url":"/message/add",
  			"success":function(rep){
  				alert("插入成功");
  				
  			}
  		});
  	});
  	
});


function pj(message){
  		var resoult="<tr>";
  		resoult+="<lable>"+message.id+"</lable>"
  		resoult+="<td id=\"title\">"+message.title+"</td>";
  		resoult+="<td id=\"content\">"+message.content+"</td>";
  		resoult+="<td>"+message.createTime+"</td>";
  		resoult+="<td><button onclick=\"aaa("+message.id+")\">修改</button><button onclick=\"bbb("+message.id+")\">删除</button></td>";
  		resoult+="</tr>";
  		
  		return resoult;
}

function aaa(id){
	 $.ajax({
			"type":"post",
			"dataType":"json",
			"url" : "/message/cxyt"+id,
			"success" : function(rep){
				
				$("#id").html(rep.id);
				$("#xiugai_title").val(rep.title);
				$("#xiugai_content").val(rep.content);
				
				
			}
		});

}
function bbb(id){
	 $.ajax({
			"type":"post",
			"dataType":"json",
			"url" : "/message/delete"+id,
			"success" : function(rep){
				alert("删除成功");
			}
		});
}
  	
  	
  	