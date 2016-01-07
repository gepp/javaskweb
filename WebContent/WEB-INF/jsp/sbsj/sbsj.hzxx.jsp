<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
function jxdk() {
	layer.confirm('确定用户卡已插入！', {
		btn : [ '确定', '取消' ]
	}, function(index) {
		try {
			layer.close(index);
			ssAlert('读卡中，请等待……');
			var result = document.dtapplet.read();
			if (result == 1) {
				div_close();
				window.location.href="${contextpath}/skqsbsj/jkhcdk.htm";
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

 
 
 
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">自然月申报数据</a></li>
		</ul>
	</div>
	 <div class="formtitle1">
		<span>纳税户基本信息</span>
	</div>
	<table class="tableEdit">
		<thead>
			<tr>
				<th>纳税人微机编码</th>
				<td>${nsrxx.nsrwjbm }</td>
				<th>纳税人识别号</th>
				<td>${nsrxx.nsrsbh }</td>
			</tr>
			<tr>
				<th>纳税人名称</th>
				<td>${nsrxx.nsrmc }</td>
				<th>经营地址</th>
				<td>${nsrxx.jydz }</td>
			</tr>
		</thead>
	</table>
	 <div class="formtitle1">
		<span>纳税人识别号为【${nsrxx.nsrsbh }】申报汇总信息</span>
	</div>
	<table class="tableEdit">
		<thead>
			<tr>
				<th>年份</th>
				<td>
				${sbhz.year }
				</td>
				<th>月份</th>
				<td>
				${sbhz.month }
				</td>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<tr>
				<th>正常票份数</th>
				<td>${sbhz.zcpfs }</td>
				<th>退票份数</th>
				<td>${sbhz.tpfs}</td>
				<th>废票份数</th>
				<td>${sbhz.fpfs}</td>
			</tr>
			<tr>
				<th>正常票金额（元）</th>
				<td><font color="red">${sbhz.zcpzje }</font></td>
				<th>退票金额（元）</th>
				<td><font color="red">${sbhz.tpzje}</font></td>
				<th>实际开票金额（元）</th>
				<td><font color="red">${sbhz.zcpzje-sbhz.tpzje}</font></td>
			</tr>
		</thead>
	</table>
	<div class="formtitle1">
		<span>税款信息</span>
	</div>

	<table class="tablelist">
		<thead>
			<tr>
				<td width="15%">税目编码：</td>
				<td width="20%">税目名称：</td>
				<td width="15%">税率(%)</td>
				<td width="15%">税款(元)</td>
				<td width="*">&nbsp;</td>
			</tr>
		</thead>

		<tbody id="nsrszsmDiv">
			<c:forEach var="item" items="${alSbsjzb }">
				<tr>
					<td>${item.smbm }</td>
					<td>${item.smmc }</td>
					<td>${item.sl }</td>
					<td>${item.je }</td>
					<td>&nbsp;</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br/>
	<br/>
	<div style="left: 25%;">
		<ul class="forminfo">
			<li><label>&nbsp;</label>
			<input type="button" class="btn" name="addBtn" value="监控回传" onClick="jxdk();"/>
		</li>
		</ul>
	</div>
 
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
	<input type="hidden" name="nsrwjbm" id="nsrwjbm" value="${nsrxx.nsrwjbm }"/>
</body>
</html>