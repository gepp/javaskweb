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
 
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/json2.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/json2.js"></script>	
 

<script language="javascript">
	function add() {
 		layer.confirm('您确定进行数据移植吗?', {
			btn : [ '确定', '取消' ]
		}, function(index) {
			try {
				layer.close(index);
					$.ajax({
						url : "${contextpath}/sjyz.htm?yzFlag="+$("#yzFlag").val(),
 						type : "post",
						success : function(data) {
 							if (data.status == 'success') {
 								
							} else {
								
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
 
	<div style="position: fixed; top: 10%; left: 30%">
		<table style="width: 100%">
			<tr>
				<td>driver</td>
				<td><input type="text" name="driver" id="driver" value="com.sybase.jdbc2.jdbc.SybDriver" style="width:600px"></input></td>
			</tr><tr>
				<td>url</td>
				<td><input type="text" name="url" id="url" value="jdbc:sybase:Tds:192.168.1.107:5000/liuan?charset=cp850&jconnect_version=3" style="width:600px"></input></td>
			</tr><tr>
				<td>username</td>
				<td><input type="text" name="username" id="username" value="sa" style="width:400px"></input></td>
				</tr><tr>
				<td>password</td>
				<td><input type="text" name="password" id="password" style="width:400px"></input></td>
			</tr>
			<tr>
				<td><input type="button" name="btn" value="测试sybase"
					class="btn" style="cursor: hand;" onclick="testDB();" /></td>
			</tr>
		</table>
		<table>
			<tr>

				<td style="height: 70px">是否需要编码转换：<b></b></td>
				<td>
					<div class="vocation">
						<select id="yzFlag" name="yzFlag" style="width: 80px">
							<option value="true">是</option>
							<option value="false">否</option>
						</select>
					</div>
				</td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					type="button" name="btn" value="数据移植" class="btn"
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
	var driver=$("#driver").val();
	var url=$("#url").val();
	var username=$("#username").val();
	var password=$("#password").val();
	
	$.ajax({
			url : "${ contextpath}/testDB.htm?driver="+driver+"&url="+url+"&username="+username+"&password="+password,
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