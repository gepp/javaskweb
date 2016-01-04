<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>数据移植</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
 

<script language="javascript">
	function add() {
 		layer.confirm('您确定进行数据移植吗?', {
			btn : [ '确定', '取消' ]
		}, function(index) {
			try {
				layer.close(index);
					$.ajax({
						url : "${contextpath}/sjyz.htm?yzFlag="+$("#yzFlag").val(),
 						type : "POST",
						success : function(data) {
 							if (data.status == 'success') {
							} else {
								sAlert('当前操作失败');
							}
	
						}
					});

							} catch (e) {
								//sAlert('当前操作失败');
								div_close();
							}
						}, function() {
	
						});
	}
	function test() {
		window.location.href = '${contextpath}/skqfpj/testInvoice.htm';
	}
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">数据移植功能</a></li>
		</ul>
	</div>
	<div style="position: fixed; top: 10%; left: 30%">
	<table style="width:100%">
	<tr>
<td><input type="button" name="btn" value="测试sybase" class="btn"
			style="cursor: hand;" onclick="testDB();" /></td>	</tr>
	<tr>
	
	<td style="height:70px">是否需要编码转换：<b></b></td>
	<td>
	<div class="vocation">
		<select id="yzFlag" name="yzFlag" style="width:80px">
			<option value="true">是</option>
			<option value="false">否</option>
		</select>
		</div>
	</td>
	<td >
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" name="btn" value="数据移植" class="btn"
			style="cursor: hand;" onclick="add();" />
	</td>
	</tr>
 
	</table>
	
	<div id="showDetail">
	  
	</div>


	</div>
</body>
</html>
<script type="text/javascript">
try{
var timer1 = setInterval(
 		function(){
  			$.ajax({
 				url : "${ contextpath}/getProcess.htm",
 				type : "post",
 				success : function(data) {
 					var arrayStr=str2json(data);
 					if(arrayStr!=null){
 					var str="";
 					for(var i=0;i<arrayStr.length;i++){
 						str=str+"<p>"+arrayStr[i]+"</p>";
 						if(arrayStr[i]=='=============移植结束============='){
 							alert("移植成功");
 						}
 					}
 					$("#showDetail").html(str);
 					}
 				}
 			});
 		},3000
 );
} catch (e) {
	 
}


function testDB(){
	$.ajax({
			url : "${ contextpath}/testDB.htm",
			type : "post",
			success : function(data) {
			 
				if(data.message==0){
					alert("连接数据库失败！");
				}else{
					alert("连接数据库成功！");
				}
			}
		});
}
</script>