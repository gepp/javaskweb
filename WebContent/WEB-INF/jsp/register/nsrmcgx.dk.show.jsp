<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
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
	layer.confirm('确定税控卡已插入！', {
		btn : [ '确定', '取消' ]
	}, function(index) {
		try {
			layer.close(index);
			ssAlert('读卡中，请等待……');
			var result = document.dtapplet.updateFCName();
			if (result == 1) {
				alert('纳税户名称更新成功！请重新发行用户卡,确保纳税户名称一致！！');
				window.location.href='${contextpath}/taxpayer/toImport.htm';
			} else {
				div_close();
				alert('纳税户名称更新失败！');

			}
		} catch (e) {
			div_close();
			alert('纳税户名称更新失败！');
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
			<li><a href="#">税控卡信息读取</a></li>
		</ul>
	</div>
	 <div class="formtitle1">
		<span>纳税户基本信息</span>
	</div>
	<table class="tableEdit">
		<thead>
			<tr>
				<th>税控卡号</th>
				<td>${EF02.SKKH }</td>
				<th>机器编号</th>
				<td>${nsrxx.JQBH }</td>
			</tr>
			<tr>
				<th>纳税人编码</th>
				<td>${EF02.NSRWJDM }</td>
				<th>纳税人识别号</th>
				<td>${EF02.NSRSBH }</td>
			</tr>
			<tr>
				<th>原纳税人名称</th>
				<td>${EF02.NSRMC }</td>
				<th>更新后纳税人名称</th>
				<td><font color="red">${nsrmc }</font></td>
			</tr>
		</thead>
	</table>
	<br/>
	<br/>
	<div style="left: 25%;">
		<ul class="forminfo">
			<li><label>&nbsp;</label><input name="" type="button"
				class="btn" value="更 新 " onclick="add();" /> &nbsp;&nbsp; <input
				name="" type="button" class="btn" value="返 回"
				onclick="window.location='${ contextpath}/taxpayer/toImport.htm'" /></li>
		</ul>
	</div>
 
	<object classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
			name="dtapplet" width="1" height="1"
			codebase="http://java.sun.com/products/plugin/1.2.2/jinstall-1_2_2-win.cab#Version=1,2,2,0">
			<param name="java_code" value="com.jsdt.web.applet.UpdateFClet.class" />
			<param name="java_codebase" value="<%=basePath%>" />
			<param name="java_archive" value="dtapplet.jar" />
			<param name="type" value="application/x-java-applet" />
			<param name="serverUrl" value="<%=basePath%>" />
			<comment> <EMBED type="application/x-java-applet"
				name="dtapplet" width="1" height="1"
				pluginspage="http://java.sun.com/products/plugin/"
				java_code="com.jsdt.web.applet.UpdateFClet.class" java_codebase="."
				java_archive="dtapplet.jar" serverUrl="<%=basePath%>" /> <noembed>

			</noembed> </comment>
		</object>
	
	<input type="hidden" name="new_name" id="new_name" value="${nsrmc }" />
</body>
</html>