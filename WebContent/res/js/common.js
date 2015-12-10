function sAlert(msg){
	layer.alert(msg,{shade: 0}
	);
}
function sMsg(msg){
	layer.msg(msg,{shade: 0});
}
 

function sOpen(url){
	setTimeout(
     		function(){
     			window.location.href=url;
     		},1200
     );
}
function closeChild(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}
function table_init(action_base_url,action_query_url){
	//action_base_url是action的url action_query_url是查询的URL
	  $("#checkAll").click(function() {
 		    $('input[name="subBox"]').prop("checked",$("#checkAll").prop("checked"));
		  });
 
	//删除按钮业务处理
	$("#table_delete").click(
		function()
		{
			var del_ids="" ;
			var count=0;
			var checkbox = $("input[name='subBox']");
			checkbox.each(function() {
				if (this.checked) {
					del_ids += this.value+",";
					count=count+1;
				}
			});
			if(count==0){
				sAlert('请选择要删除的数据！');
			}
			
			else{
				layer.confirm('您确认删除您所选择的'+count+'条数据么？',{shade: 0},function(index){
					//ajax提交删除数据
					jQuery.ajax({
								type: "post", 
								url: action_base_url+"/delete", 
								dataType: "json",
								data:{action:'delete',ids:del_ids},
								success: function (data) { 
									if(data.status=='success'){
										layer.alert('当前操作成功', {
											shade:0,closeBtn: 0
										}, function(){
											window.location.href=action_query_url;
										});
									}else{
										layer.alert(data.message, {
											shade:0,closeBtn: 0
										}, function(){
											window.location.href=action_query_url;
										});
									}
									
									 
								} 
						});
				});
			 
			}
		}
	);
	
	 
	
	//修改按钮业务处理
	$("#table_edit").click(
		function()
		{
			var a=0;
			var id="" ;
			var checkbox = $("input[name='subBox']");
			checkbox.each(function() {
				if (this.checked) {
					id = this.value;
					a++;
				}
			});
			if(id==""){
				layer.alert("请选择要修改的记录!");
			}else{
			if(a!=1){
				layer.alert("请选择一条要修改的记录!");
			}else{
				window.location.href=action_base_url+"/modify?id="+id;
				}
			}
		}
	);
	
	//新增按钮业务处理
	$("#table_add").click(
			function()
			{
				window.location.href=action_base_url+"/add";
			}
	);
	//刷新按钮业务处理
	$("#table_refresh").click(
			function()
			{
				window.location.href=action_query_url;
			}
	);
	$(".modifyIcon").click(
			function(){
				 
				window.location.href=action_base_url+"/modify?id="+$(this).attr("value");
			}
	);
	$(".deleteIcon").click(
			function(){
				var id=($(this).attr("value"));
				layer.confirm('您确认删除您所选择的这条数据么？',function(index){
					//ajax提交删除数据
					$.ajax({
								type: "post", 
								url: action_base_url+"/delete", 
								dataType: "json",
								data:{action:'delete',ids:id},
								success: function (data) { 
									layer.alert(data.message);
									sOpen(action_query_url);
								} 
						});
				});
			}
	);
	
}
function json2str(j){
	return JSON.stringify(j);
}
function str2json(s){
	return JSON.parse(s);
}
