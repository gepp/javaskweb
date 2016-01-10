<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
				window.location.href="${contextpath}/skqsbsj/sbsjdk.htm?sccs=001";
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

function change_sccs(val){
	if(val=='001'){
		jQuery("#dt").show();
		jQuery("#st").hide();
	}
	else{
		jQuery("#dt").hide();
		jQuery("#st").show();
	}
}

function jxdkSt(){
	var sccs = '002';
	var dk_sid = "USERINFO_1^2^3";
	var v = document.dsfxk.call(dk_sid);
	var result_arr = v.split('_');
	if(result_arr[0]==1){
		//div_close();
		//document.all('userinfo').value = result_arr[1];
		//alert(result_arr[1]);
		var userinfo_arr = result_arr[1].split('^');
		//alert(userinfo_arr);
		var WJBM = userinfo_arr[0];
		var JQBH = userinfo_arr[4];
		//alert(userinfo_arr[4]);
		//alert(WJBM);
		var SKKH = userinfo_arr[5];
		var dk_sid1 = "SJSBDK_"+WJBM+"^"+SKKH+"^"+JQBH;
		//alert(dk_sid1);
		var v1 = document.dsfxk.call(dk_sid1);
		var result_arr1 = v1.split('_');
		if(result_arr1[0]==1){
			//var dk_sid2 = "DJFPSYXX_"+WJBM;
			//alert(dk_sid2);
			//var v2 = document.dsfxk.call(dk_sid2);
			//var result_arr2 = v2.split('_');
			//if(result_arr1[0]==1){
				window.location.href = '${contextpath}/skqsbsj/sbsjdk.htm?sccs='+sccs+'&jqbh='+JQBH+'&dkxx='+result_arr1[1];
			//}
			//else{
				//window.location.href = '/javaskweb/sbsjServlet?method=sbsjdk&sccs='+sccs+'&jqbh='+JQBH+'&dkxx='+result_arr1[1];
			//}
			//alert(v2);
			
		}
		else{
			div_close();
			alert('申报信息读取失败！');
		}
	}
	else{
		div_close();
		alert('卡基本信息读取失败！');
	}
}

function sbhz(){
	var nsrwjbm = document.getElementById('nsrwjbm').value;
	window.location.href = '${contextpath}/skqsbsj/sbhzsj.htm?nsrwjbm='+nsrwjbm;
}

<%
String sbflag = request.getAttribute("sbflag").toString();
	 if ("1".equals(sbflag)) {%>
		setTimeout('sbhz()', 5000);
	<%}%>
	
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
		<span>机器编号为【${sbsj.jqbh }】申报信息</span>
	</div>
	<table class="tableEdit">
		<thead>
			<tr>
				<th>所属开始时间</th>
				<td>
				<fmt:formatDate value="${sbsj.sskssj }" pattern="yyyy-MM-dd" var="sskssj"/>
				${sskssj }
				</td>
				<th>所属结束时间</th>
				<td>
				<fmt:formatDate value="${sbsj.ssjzsj }" pattern="yyyy-MM-dd" var="ssjzsj"/>
				${ssjzsj }
				</td>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<tr>
				<th>正常票份数</th>
				<td>${sbsj.zcpfs }</td>
				<th>退票份数</th>
				<td>${sbsj.tpfs}</td>
				<th>废票份数</th>
				<td>${sbsj.fpfs}</td>
			</tr>
			<tr>
				<th>正常票金额（元）</th>
				<td>${sbsj.zcpzje }</td>
				<th>退票金额（元）</th>
				<td>${sbsj.tpzje}</td>
				<th>实际开票金额（元）</th>
				<td>${sbsj.zcpzje-sbsj.tpzje}</td>
			</tr>
		</thead>
	</table>
	
	
	 <div class="formtitle1">
		<span>机器编号为【${sbsj.jqbh }】阶段申报信息</span>
	</div>
	<c:forEach items="${alJdsb }" var="item">
	<table class="tableEdit">
		<thead>
			<tr>
				<th>所属开始时间</th>
				<td>
				<fmt:formatDate value="${item.sskssj }" pattern="yyyy-MM-dd" var="sskssj"/>
				${sskssj }
				</td>
				<th>所属结束时间</th>
				<td>
				<fmt:formatDate value="${item.ssjzsj }" pattern="yyyy-MM-dd" var="ssjzsj"/>
				${ssjzsj }
				</td>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<tr>
				<th>正常票份数</th>
				<td>${item.zcpfs }</td>
				<th>退票份数</th>
				<td>${item.tpfs}</td>
				<th>废票份数</th>
				<td>${item.fpfs}</td>
			</tr>
			<tr>
				<th>正常票金额（元）</th>
				<td>${item.zcpzje }</td>
				<th>退票金额（元）</th>
				<td>${item.tpzje}</td>
				<th>实际开票金额（元）</th>
				<td>${item.zcpzje-item.tpzje}</td>
			</tr>
		</thead>
	</table>
	<br/>
	</c:forEach>
	
	<br/>
	<br/>
	<div style="left: 25%;">
		<ul class="forminfo">
			<li style="width:50%;"><label>&nbsp;</label> 
			<%
 				if ("0".equals(sbflag)) {
 			%>
 				<!-- <label>选择厂商:
				<input type="radio" name="sccs1" value="001" checked onclick="change_sccs(this.value);" />
		              大唐
		        <input type="radio" name="sccs1" value="002" onclick="change_sccs(this.value);"/>
		              四通</label><br /><br /> -->
				<input id="dt" type="button" class="btn" name="addBtn" value="继续读卡" onClick="jxdk();"/>
				<input id="st" style="display:none;" type="button" class="btn" name="addBtn" value="四通继续读卡" onClick="jxdkSt();"/>
			 <%
			 	} else {
			 %> 系统正在计算汇总数据，请等待... <%
			 	}
			 %> 
 				
 				
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
	<input type="hidden" name="nsrwjbm" id="nsrwjbm" value="${nsrxx.nsrwjbm }"/>
</body>
</html>