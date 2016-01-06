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
<title>无标题文档</title>
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
		layer.confirm('确定用户卡已插入！', {
			btn : [ '确定', '取消' ]
		}, function(index) {
			try {
				layer.close(index);
				ssAlert('读卡中，请等待……');
				var result = document.dtapplet.read();
				if (result == 1) {
					window.location.href = '${contextpath}/skqfpj/info.htm';
				} else {
					div_close();
					alert('卡基本信息读取失败！');

				}
			} catch (e) {
				div_close();
				alert('卡基本信息读取失败！');
			}
		}, function() {

		});
	}
	function test() {
		window.location.href = '${contextpath}/skqfpj/testInvoice.htm';
	}
	
	function change_sccs(val){
		if(val=='001'){
			$("#dt").show();
			$("#st").hide();
		}
		else{
			$("#dt").hide();
			$("#st").show();
		}
	}
	
	function addSt(){
		layer.confirm('确定用户卡已插入！', {
			btn : [ '确定', '取消' ]
		}, function(index) {
			try {
				layer.close(index);
				ssAlert('读卡中，请等待……');
				
				var dk_sid = "USERINFO_1^2^3";
				var v = document.dsfxk.call(dk_sid);
				var result_arr = v.split('_');
				if(result_arr[0]==1){
					//document.all('userinfo').value = result_arr[1];
					var userinfo_arr = result_arr[1].split('^');
					var WJBM = userinfo_arr[0];
					var JQBH = userinfo_arr[4];
					var SKKH = userinfo_arr[5];
					var dk_sid1 = "FPDK_"+WJBM+"^"+SKKH+"^"+JQBH;
					var v = document.dsfxk.call(dk_sid1);
					var result_arr_1 = v.split('_');
					if(result_arr_1[0]==1){
						if(result_arr_1.length==1){
							result_arr_1[1] = "";
						}
						
						window.location.href = '${contextpath}/skqfpj/infoSt.htm?userinfo='+result_arr[1]+'&dkxx='+result_arr_1[1];
					}
					else{
						div_close();
						alert('发票信息读取失败！');
					}
				}
				else{
					div_close();
					alert('卡基本信息读取失败！');
				}
			} catch (e) {
				div_close();
				alert('卡基本信息读取失败！');
			}
		}, function() {

		});
	}
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">发票购买</a></li>
		</ul>
	</div>
	<div style="position: fixed; top: 30%; left: 46%">
		<!-- <label style="font-size:16px;">选择厂商:
		<input type="radio" name="sccs1" value="001" checked onclick="change_sccs(this.value);" />
              大唐
        <input type="radio" name="sccs1" value="002" onclick="change_sccs(this.value);"/>
              四通</label><br /><br /> -->
	 
		<input type="hidden" name="userinfo" /> 
		<input type="button" id="dt" name="btn" value=" 读 卡 " class="btn" style="cursor: hand;" onclick="add();" />
		<input type="button" id="st" style="display:none;" name="btn" value=" 读 卡 " class="btn" style="cursor: hand;" onclick="addSt();" />
		 

		<object classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
			name="dtapplet" width="1" height="1"
			codebase="http://java.sun.com/products/plugin/1.2.2/jinstall-1_2_2-win.cab#Version=1,2,2,0">
			<param name="java_code" value="com.jsdt.web.applet.TYUcReadlet.class" />
			<param name="java_codebase" value="<%=basePath%>" />
			<param name="java_archive" value="dtapplet.jar" />
			<param name="type" value="application/x-java-applet" />
			<param name="serverUrl" value="<%=basePath%>" />
			<comment> <EMBED type="application/x-java-applet"
				name="dtapplet" width="1" height="1"
				pluginspage="http://java.sun.com/products/plugin/"
				java_code="com.jsdt.web.applet.TYUcReadlet.class" java_codebase="."
				java_archive="dtapplet.jar" serverUrl="<%=basePath%>" /> <noembed>

			</noembed> </comment>
		</object>
		
		<object classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
			name="dsfxk" width="1" height="1"
			codebase="http://java.sun.com/products/plugin/1.2.2/jinstall-1_2_2-win.cab#Version=1,2,2,0">
			<param name="java_code" value="com.jsdt.web.applet.CallExe.class" />
			<param name="java_codebase" value="<%=basePath%>" />
			<param name="java_archive" value="dtapplet.jar" />
			<param name="type" value="application/x-java-applet" />
			<param name="serverUrl" value="<%=basePath%>" />
			<comment> <EMBED type="application/x-java-applet"
				name="dtapplet" width="1" height="1"
				pluginspage="http://java.sun.com/products/plugin/"
				java_code="com.jsdt.web.applet.CallExe.class" java_codebase="."
				java_archive="dtapplet.jar" serverUrl="<%=basePath%>" /> <noembed>
			</noembed> </comment>
		</object>
	</div>
</body>
</html>