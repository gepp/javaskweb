<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
    String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			System.out.println(basePath);
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
<script type="text/javascript">
	//more javascript from http://www.smallrain.net
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

	function fpxk() {
		document.getElementById('fpxk_btn').disabled = true;
		var yhkh = document.all('YHKH').value;
		var fpxi_0 = document.all('fpxi_' + yhkh + '_0').value;
		if (fpxi_0 != '') {
			if (confirm('确认用户卡已插入！')) {
				sAlert('发票写卡中，请等待……');
				try {
					var result = document.writeInvoiceApplet.write(yhkh);
					if (result == 1) {
						div_close();
						var frm = document.addForm;
						frm.submit();
						alert('发票写卡成功！');
						sAlert('读卡中，请等待……');
						var result1 = document.dtapplet.read();
						window.location = '${contextpath}/skqfpj/info.htm';
						if (result1 == 1) {
							window.location.href = '${contextpath}/skqfpj/info.htm';
						} else {
							div_close();
							alert('卡基本信息读取失败！');
							document.getElementById('fpxk_btn').disabled = true;
						}
						//window.location='${contextpath}/skqfpj/info.htm';

					} else {
						div_close();
						alert('发票写卡失败！');
						document.getElementById('fpxk_btn').disabled = false;
					}
				} catch (err) {
					div_close();
					alert('发票写卡失败！');
					document.getElementById('fpxk_btn').disabled = true;
				}
			}
		} else {
			alert('无发票信息');
		}
	}
	function div_close() {
		var bgObj = document.getElementById("bgDiv");
		var msgObj = document.getElementById("msgDiv");
		document.body.removeChild(bgObj);
		document.body.removeChild(msgObj);
	}

</script>

</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">发票领购</a></li>
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
			<tr>
				<th>机器编号</th>
				<td>${jqxx.jqbh }</td>
				<th>税控卡号</th>
				<td>${jqxx.skkh }</td>
			</tr>
		</thead>
	</table>
	<div class="formtitle1">
		<span>用户卡已有发票信息</span>
	</div>
	<table class="tablelist">
		<thead>
			<tr>
				<th>发票代码</th>
				<th>发票单位（卷）</th>
				<th>发票号码起止</th>

			</tr>
		</thead>

		<tbody id="nsrszsmDiv">
			<input type="hidden" value="${fn:length(cardInvoice)}" id="num" />
			<c:set var="num" value="${fn:length(cardInvoice)}"></c:set>
			<c:forEach var="hasInvoice" items="${cardInvoice }"
				varStatus="status">
				<td>${hasInvoice.FPDM }</td>
				<td>${hasInvoice.JS }</td>
				<td>${hasInvoice.QSH }---${hasInvoice.JZH }</td>
			</c:forEach>
		</tbody>
	</table>
	<div class="formtitle1">
		<span>税控发票领购情况</span>
	</div>
	<table class="tablelist">
		<thead>
			<tr>
				<th>领票日期</th>
				<th>发票代码</th>
				<th>发票单位（卷）</th>
				<th>发票号码起止</th>
			</tr>
		</thead>

		<tbody id="nsrszsmDiv">
			<c:set var="num1" value="${fn:length(alFp)}"></c:set>
			<c:forEach var="noInvoice" items="${alFp }" varStatus="status">
				<tr>
					<td>${noInvoice.fplgrq }&nbsp;</td>
					<td>${noInvoice.fpdm }&nbsp;</td>
					<td>${noInvoice.fpdw }&nbsp;</td>
					<td>${noInvoice.fpqsh }&nbsp;---${noInvoice.fpjzh }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />

	<div style="left: 25%;">
		<jsp:plugin name="writeInvoiceApplet" type="applet"
			code="com.jsdt.web.applet.InvoiceWritelet.class" codebase="."
			archive="dtapplet.jar" width="1" height="1">
			<jsp:params>
				<jsp:param name="serverUrl" value="<%=basePath%>" />
			</jsp:params>
		</jsp:plugin>
		<jsp:plugin name="dtapplet" type="applet" archive="dtapplet.jar"
			codebase="." code="com.jsdt.web.applet.TYUcReadlet.class" height="1"
			width="1">
			<jsp:params>
				<jsp:param name="serverUrl" value="<%=basePath%>" />
			</jsp:params>
		</jsp:plugin>
		<ul class="forminfo">
			<li><label>&nbsp;</label><input name="" type="button"
				class="btn" value="发票写卡" onclick="fpxk();" id="fpxk_btn" />
				&nbsp;&nbsp; <input name="" type="button" class="btn" value="返 回"
				onclick="window.location='${ contextpath}/skqfpj/info.htm'" /></li>
		</ul>
	</div>
	<!-- 用户卡号-->
	<input type="hidden" name="YHKH" id="YHKH" value="${jqxx.yhkh }" />
	<!-- 微机编码-->
	<input type="hidden" name="WJBM_${jqxx.yhkh }" id="WJBM_${jqxx.yhkh }"
		value="${jqxx.nsrwjbm }" />
	<!-- 税控卡号-->
	<input type="hidden" name="FISCAL_CARD_NO_${jqxx.yhkh }"
		id="FISCAL_CARD_NO_${jqxx.yhkh }" value="${jqxx.skkh }" />
	<!-- 机器编号-->
	<input type="hidden" name="MACHINE_NO_${jqxx.yhkh }"
		id="MACHINE_NO_${jqxx.yhkh }" value="${jqxx.jqbh }" /> ${hiddenFpj }

	<form name="addForm" method="post"
		action="${contextpath }/skqfpj/updateXkbz.htm" target="iframe">
		<input type="hidden" name="fpqshInfoStr" value="${fpqshInfoStr }" />
	</form>
</body>
</html>