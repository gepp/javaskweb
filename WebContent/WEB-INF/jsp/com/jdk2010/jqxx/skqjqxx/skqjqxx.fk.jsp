<%@page import="com.jdk2010.tools.Constants"%>
<%@page import="com.jdk2010.tools.Util"%>
<%@page import="com.jdk2010.jqxx.skqjqxx.model.SkqJqxx"%>
<%@page import="com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发卡</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<style type="text/css">
.forminfo li label {
	width: 128px
}

.forminfo tr {
	height: 45px
}
</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">基本信息</a></li>
		</ul>
	</div>
	<div class="formbody">
		<div class="formtitle1">
			<span>基本信息</span>
		</div>
		<table class="tableEdit">
			<tr>
				<th>纳税人微机编码<b></b></th>
				<td>${jqxx.nsrwjbm }</td>
				<th>纳税人名称<b></b></th>
				<td>${nsrxx.nsrmc }</td>
			</tr>
			<tr>
				<th>机器编号<b></b></th>
				<td>${jqxx.jqbh }</td>
				<th>机器型号编码<b></b></th>
				<td>${jqxx.jqxhbm }</td>
			</tr>

			<tr>
				<th>税控卡号<b></b></th>
				<td>${jqxx.skkh }</td>
				<th>用户卡号<b></b></th>
				<td>${jqxx.yhkh }</td>
			</tr>

			<tr>
				<th>卡启用日期<b></b></th>
				<td>${jqxx.kqyrq }</td>
				<th>卡有效日期<b></b></th>
				<td>${jqxx.kyxrq }</td>

			</tr>

			<tr>
				<th>开票截止日期<b></b></th>
				<td>${jqxx.kpjzrq }</td>
				<th>单笔开票最高限额（元）<b></b></th>
				<td>${jqxx.dzkpxe }</td>
			</tr>

			<tr>
				<th>月累计开票最高限额（元）<b></b></th>
				<td>${jqxx.yljkpxe }</td>
				<th>月累计退票最高限额（元）<b></b></th>
				<td>${jqxx.yljtpxe }</td>
			</tr>
			<tr>
				<th>状态<b></b></th>
				<td>${ jqxx.status==1?'正常':'注销'}</td>
				<th>&nbsp;<b></b></th>
				<td>&nbsp;</td>
			</tr>

		</table>
		<br />
		<div class="formtitle1">
			<span>机器税种税目</span>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th>税种编码</th>
					<th>税目编码</th>
					<th>税目名称</th>
					<th>经营项目内容</th>
					<th>税率</th>
				</tr>
			</thead>

			<tbody id="nsrszsmDiv">
				<c:forEach var="item" items="${jqxx.jqszsmList }">
					<tr>
						<td>${item.szbm }</td>
						<td>${item.smbm }</td>
						<td>${item.smmc }</td>
						<td>${item.smjc }</td>
						<td>${item.sl }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br />
	<ul style="position:fixed;left:30%;bottom:15px">
		<li><label>&nbsp;</label> <input type="button" class="btn"
			name="btn1" onClick="writeFcard()" value=" 发税控卡 "
			style="cursor: hand;" id="fskk" /> &nbsp;&nbsp; <input type="button"
			class="btn" name="btn2" onClick="writeUcard()" value=" 发用户卡 "
			style="cursor: hand;" id="fyhk" /> &nbsp;&nbsp; <input name=""
			type="button" class="btn" value="返回" id="fh"
			onclick="window.location='${ contextpath }/skqjqxx/list.htm?nsrwjbm=${jqxx.nsrwjbm}'" />
		</li>
	</ul>
	<br />
	<br />
	<jsp:plugin name="WriteFCApplet" type="applet"
		code="com.jsdt.web.applet.TYFcWritelet.class" codebase="."
		archive="dtapplet.jar" width="1" height="1">
		<jsp:params>
			<jsp:param name="serverUrl" value="<%=basePath%>" />
		</jsp:params>
	</jsp:plugin>
	<jsp:plugin name="WriteUCApplet" type="applet"
		code="com.jsdt.web.applet.TYUcWritelet.class" codebase="."
		archive="dtapplet.jar" width="1" height="1">
		<jsp:params>
			<jsp:param name="serverUrl" value="<%=basePath%>" />
		</jsp:params>
	</jsp:plugin>
	<%
	SkqNsrxx nsrxx = (SkqNsrxx)request.getAttribute("nsrxx");
	SkqJqxx jqxx = (SkqJqxx)request.getAttribute("jqxx");
	%>
	<input type="hidden" name="TAXPAYER_NO" id="TAXPAYER_NO" value="${nsrxx.nsrwjbm }" />
          <!-- 税控卡号-->
          <input type="hidden" name="FISCAL_CARD_NO" id="FISCAL_CARD_NO" value="${jqxx.skkh }" />
          <!-- 机器编号-->
          <input type="hidden" name="MACHINE_NO" id="MACHINE_NO" value="<%=jqxx.getJqbh() %>" />
          <!-- 用户卡有效时间-->
          <input type="hidden" name="U_START_DATE" id="U_START_DATE" value="<%=Util.toxkrq(jqxx.getKqyrq()) %>" />
          <!-- 用户卡截止时间-->
          <input type="hidden" name="U_END_DATE" id="U_END_DATE" value="<%=Util.toxkrq(jqxx.getKyxrq()) %>" />
          <!-- 纳税户名称-->
          <input type="hidden" name="TAXPAYER_NAME" id="TAXPAYER_NAME" value="<%=nsrxx.getNsrmc().trim() %>" />
          <!-- 申报截止时间-->
          <input type="hidden" name="MAKE_END_DATE" id="MAKE_END_DATE" value="<%=Util.toxkrq(jqxx.getKpjzrq()) %>" />
          <!-- 单张发票开票限额-->
          <input type="hidden" name="MAKE_MAX_SINGLE" id="MAKE_MAX_SINGLE" value="<%=(long)(jqxx.getDzkpxe()*100)%>" />
          <!-- 月累计最高开票限额-->
          <input type="hidden" name="MAKE_MAX_SUM" id="MAKE_MAX_SUM" value="<%=(long)(jqxx.getYljkpxe()*100)%>" />
          <!-- 月累计最高退票限额-->
          <input type="hidden" name="BACK_MAX_SUM" id="BACK_MAX_SUM" value="<%=(long)(jqxx.getYljtpxe()*100)%>" />
          <!-- 明细申报标志-->
          <input type="hidden" name="DECLARE_MAKE_TYPE" id="DECLARE_MAKE_TYPE" value="<%=jqxx.getMxsbbz() %>" />
          <!-- 申报类型-->
          <input type="hidden" name="DECLARE_TYPE" id="DECLARE_TYPE" value="<%=jqxx.getSbfs() %>" />
          <!-- 税控卡有效时间-->
          <input type="hidden" name="F_START_DATE" id="F_START_DATE" value="<%=Util.toxkrq(jqxx.getKqyrq()) %>" />
          <!-- 税控卡截止时间-->
          <input type="hidden" name="F_END_DATE" id="F_END_DATE" value="<%=Util.toxkrq(jqxx.getKyxrq()) %>" />
          <!-- 主管科所-->
          <input type="hidden" name="ORGAN_CODE" id="ORGAN_CODE" value="${nsrxx.swjgbm }" />
          <!-- 纳税人识别号-->
          <input type="hidden" name="TAXPAYER_CODE" id="TAXPAYER_CODE" value="<%=nsrxx.getNsrsbh() %>" />
          <!-- 下次申报月-->
          <input type="hidden" name="MAKE_END_DATE_MONTH" id="MAKE_END_DATE_MONTH" value="<%=Constants.ENDMONTH %>" />
          <!-- 下次申报日-->
          <input type="hidden" name="MAKE_END_DATE_DAY" id="MAKE_END_DATE_DAY" value="<%=Constants.ENDDAY %>" />
			
		  ${smStr }
</body>
</html>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	function sAlert(str) {
		var msgw, msgh, bordercolor;
		msgw = 400;//提示窗口的宽度
		msgh = 100;//提示窗口的高度
		titleheight = 25 //提示窗口标题高度
		bordercolor = "#c51100";//提示窗口的边框颜色
		titlecolor = "#c51100";//提示窗口的标题颜色

		var sWidth, sHeight;
		sWidth = screen.width;
		sHeight = screen.height;

		var bgObj = document.createElement("div");
		bgObj.setAttribute('id', 'bgDiv');
		bgObj.style.position = "absolute";
		bgObj.style.top = "0";
		bgObj.style.background = "#cccccc";
		bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
		bgObj.style.opacity = "0.6";
		bgObj.style.left = "0";
		bgObj.style.width = sWidth + "px";
		bgObj.style.height = sHeight + "px";
		bgObj.style.zIndex = "10000";
		document.body.appendChild(bgObj);

		var msgObj = document.createElement("div")
		msgObj.setAttribute("id", "msgDiv");
		msgObj.setAttribute("align", "center");
		msgObj.style.background = "white";
		msgObj.style.border = "1px solid " + bordercolor;
		msgObj.style.position = "absolute";
		msgObj.style.left = "50%";
		msgObj.style.top = "50%";
		msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
		msgObj.style.marginLeft = "-225px";
		msgObj.style.marginTop = -75 + document.documentElement.scrollTop
				+ "px";
		msgObj.style.width = msgw + "px";
		msgObj.style.height = msgh + "px";
		msgObj.style.textAlign = "center";
		msgObj.style.lineHeight = "25px";
		msgObj.style.zIndex = "10001";

		var title = document.createElement("h4");
		title.setAttribute("id", "msgTitle");
		title.setAttribute("align", "right");
		title.style.margin = "0";
		title.style.padding = "3px";
		title.style.background = bordercolor;
		title.style.filter = "progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
		title.style.opacity = "0.75";
		title.style.border = "1px solid " + bordercolor;
		title.style.height = "18px";
		title.style.font = "12px Verdana, Geneva, Arial, Helvetica, sans-serif";
		title.style.color = "white";
		title.style.cursor = "pointer";
		/*title.innerHTML="关闭";
		title.onclick=function(){
		document.body.removeChild(bgObj);
		document.getElementById("msgDiv").removeChild(title);
		document.body.removeChild(msgObj);
		     }*/
		document.body.appendChild(msgObj);
		document.getElementById("msgDiv").appendChild(title);
		var txt = document.createElement("p");
		txt.style.margin = "1em 0"
		txt.setAttribute("id", "msgTxt");
		txt.innerHTML = str;
		document.getElementById("msgDiv").appendChild(txt);
	}
	function writeUcard() {
		//alert(document.getElementById("TAXPAYER_NO").value);
		document.getElementById('fyhk').disabled = true;
		if (confirm('确定发用户卡？')) {
			sAlert('用户卡发卡中，请等待……');
			try {
				var v = document.WriteUCApplet.writeTYUserCard();
				//	var cno = document.getElementById("FISCAL_CARD_NO").value;
				if (v == 1) {
					div_close();
					alert("用户卡 发卡成功！！！您已完成注册登记！");
					document.getElementById('fyhk').disabled = true;
 					document.getElementById('fh').disabled = true;
				} else {
					div_close();
					alert("用户卡  发卡失败！！！");
					document.getElementById('fyhk').disabled = false;
				}
			} catch (err) {
				div_close();
				alert("用户卡  发卡失败！！！");
				document.getElementById('fyhk').disabled = false;
			}
		}
	}

	function writeFcard() {
		document.getElementById('fskk').disabled = true;
		if (confirm("确定发税控卡？")) {
			sAlert('税控卡发卡中，请等待……');
			try {
				var v = document.WriteFCApplet.writeTYFiscalCard();
				//alert(v);
				//var cno = document.getElementById("FISCAL_CARD_NO").value;
				if (v == 1) {
					div_close();
					alert("税控卡  发卡成功！！！");
					document.getElementById('fskk').disabled = true;
					document.getElementById('fh').disabled = true;
					document.getElementById('fyhk').disabled = false;
 				} else {
					div_close();
					alert("税控卡   发卡失败！！！");
					document.getElementById('fskk').disabled = false;
				}
			} catch (err) {
				div_close();
				alert("税控卡   发卡失败！！！");
				document.getElementById('fskk').disabled = false;
			}
		}
	}

	function div_close() {
		var bgObj = document.getElementById("bgDiv");
		var msgObj = document.getElementById("msgDiv");
		document.body.removeChild(bgObj);
		document.body.removeChild(msgObj);
	}
</script>

