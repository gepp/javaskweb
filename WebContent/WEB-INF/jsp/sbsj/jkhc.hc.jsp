<%@page import="java.text.DecimalFormat"%>
<%@page import="com.jdk2010.nsrxx.skqnsrxx.model.SkqNsrxx"%>
<%@page import="com.jdk2010.jqxx.skqjqxx.model.SkqJqxx"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.jdk2010.tools.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    int ENDMONTH = Constants.ENDMONTH;
			int ENDDAY = Constants.ENDDAY;
			HashMap hmJkhc = (HashMap) request.getAttribute("hmJkhc");
			SkqJqxx jqxx = (SkqJqxx) hmJkhc.get("jqxx");
			SkqNsrxx nsrxx = (SkqNsrxx) hmJkhc.get("nsrxx");
			String old_nsrwjbm = (String) hmJkhc.get("old_nsrwjbm");
			String kpjzrq = (String) hmJkhc.get("kpjzrq");
			String[] smxkArr = (String[]) hmJkhc.get("smxkArr");
			System.out.println(smxkArr);
			DecimalFormat dg = new DecimalFormat("0.00");
			String xckpjzrq = (String) hmJkhc.get("xckpjzrq");
			String QYRQ = (String) hmJkhc.get("QYRQ");
			String YXRQ = (String) hmJkhc.get("YXRQ");
			String MXSBBZ = (String) hmJkhc.get("MXSBBZ");
			String JQLX = (String) hmJkhc.get("JQLX");
			String JQSL = (String) hmJkhc.get("JQSL");
			String LXBS = (String) hmJkhc.get("LXBS");
			String YYBB = (String) hmJkhc.get("YYBB");
			String FCI = (String) hmJkhc.get("FCI");
			String MAC = (String) hmJkhc.get("MAC");
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			System.out.println(basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>监控回传信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/laydate/laydate.js"></script>
<script type="text/javascript" language="javascript">
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

	function div_close() {
		var bgObj = document.getElementById("bgDiv");
		var msgObj = document.getElementById("msgDiv");
		document.body.removeChild(bgObj);
		document.body.removeChild(msgObj);
	}
	
	function declareback(){
		var KPJZRQ = document.all('KPJZRQ').value;
		var MAKE_END_DATE = document.all('MAKE_END_DATE').value;
		var MAC=document.getElementById('MAC').value;

		 
		if(MAKE_END_DATE<=KPJZRQ){
			alert('申报日期必须大于  '+KPJZRQ);
		}
		else
	 
			if(MAC=='null'||MAC==''){
			alert('MAC为空，请重新插卡进行监控回传！');
		}
		 
		else{
			var frm = document.form1;
			if(validator(frm)){
				document.all('MAKE_MAX_SINGLE').value = document.all('MAKE_MAX_SINGLE1').value*100;
				document.all('MAKE_MAX_SUM').value = document.all('MAKE_MAX_SUM1').value*100;
				document.all('BACK_MAX_SUM').value = document.all('BACK_MAX_SUM1').value*100;
				
				sAlert('清零解锁中，请等待……');
				try{
					var v = document.DeclareBackApplet.declardBackData();
					
					if(v == 1){
						var JQBH = document.all('JQBH').value;
						var src = "${contextpath}/skqsbsj/updateKpxe.htm&kpjzrq="+document.all('MAKE_END_DATE').value+"&jqbh="+JQBH+"&dzkpxe="+document.all('MAKE_MAX_SINGLE1').value+"&yljkpxe="+document.all('MAKE_MAX_SUM1').value+"&yljtpxe="+document.all('BACK_MAX_SUM1').value+'&mac='+document.all('MAC').value;
						document.all('updateJZRQ').src = src;
						alert("清零解锁成功");
						window.close();
					}
					else{
						div_close()
						alert("清零解锁失败");
						
					}
				}
				catch(e){
					div_close()
					alert("清零解锁失败!");
				}
			}
		}
		
	}
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">监控回传信息</a></li>
		</ul>
	</div>
  <div class="formtitle1">
		<span><strong><font color="#FF0000">上次开票截止日期是：<%=kpjzrq%>,本次申报日期必须大于该日期</font></strong></span>
	</div>
	<table class="tableEdit">
		<thead>
			<tr>
				<th>下次申报截止日期：</th>
				<td>
				<input type="text" id="MAKE_END_DATE" name="MAKE_END_DATE" size="20"  class="input" value="<%=xckpjzrq %>" onclick="laydate()" />
				</td>
			</tr>
			<tr>
				<th>单笔开票最高限额（元）</th>
				<td><input type="text" name="MAKE_MAX_SINGLE1" size="20" class="input" value="<%=dg.format(jqxx.getDzkpxe()) %>" /></td>
			</tr>
			<tr>
				<th>月累计开票最高限额（元）</th>
				<td>
				<input type="text" value="<%=dg.format(Double.valueOf(jqxx.getYljkpxe())) %>" name="MAKE_MAX_SUM1" size="20"  class="input" />
				</td>
			</tr>
			<tr>
				<th>月累计退票最高限额（元）</th>
				<td>
 				<input type="text" name="BACK_MAX_SUM1" size="20"  class="input" value="<%=dg.format(jqxx.getYljtpxe()) %>" />
 				</td>
			</tr>
		</thead>
	</table>

	<br />
	<br />
	<div style="left: 25%;">
		<ul class="forminfo">
			<li><label>&nbsp;</label>
			<input type="button" name="addBtn" value="确 定" onClick="declareback();"/>
			<jsp:plugin name="DeclareBackApplet" type="applet" code="com.jsdt.web.applet.DeclareBacklet.class" codebase="." archive="dtapplet.jar" width="1" height="1">
			<jsp:params>  
			  <jsp:param name="serverUrl" value="<%=basePath%>"   />
			</jsp:params>
			</jsp:plugin>
			</li>
		</ul>
	</div>
	<iframe src="" name="updateJZRQ" frameborder="0" width="0" height="0"></iframe>
	<input type="hidden" id="TAXPAYER_NO" name="TAXPAYER_NO" value="<%=old_nsrwjbm%>" />
	${smStr}
	<input type="hidden" id="end_date" name="end_date" value=""/>
    <input type="hidden" id="MAKE_END_DATE_MONTH" name="MAKE_END_DATE_MONTH" size="20" class="input" value="<%=ENDMONTH%>"  onblur="changeDate();"/>
    <input type="hidden" id="MAKE_END_DATE_DAY" name="MAKE_END_DATE_DAY" size="20"  class="input" value="<%=ENDDAY%>" onblur="changeDate();"/>
    <input type="hidden" name="KPJZRQ" value="<%=kpjzrq%>" id="KPJZRQ" />
    <input type="hidden" name="MAKE_MAX_SINGLE" id="MAKE_MAX_SINGLE" />
    <input type="hidden" name="MAKE_MAX_SUM" id="MAKE_MAX_SUM" />
    <input type="hidden" name="BACK_MAX_SUM" id="BACK_MAX_SUM" />
     
    <input type="hidden" id="JQBH" name="JQBH" value="<%=jqxx.getJqbh() %>" />
    <input type="hidden" id="SKKH" name="SKKH" value="<%=jqxx.getSkkh() %>" />
    <input type="hidden" id="TAXPAYER_NAME" name="TAXPAYER_NAME" value="<%=nsrxx.getNsrmc().trim() %>">
    <input type="hidden" id="QYRQ" name="QYRQ" value="<%=QYRQ%>">
    <input type="hidden" id="YXRQ" name="YXRQ" value="<%=YXRQ%>">
    <input type="hidden" id="MXSBBZ" name="MXSBBZ" value="<%=MXSBBZ%>">
    <input type="hidden" id="JQLX" name="JQLX" value="<%=JQLX%>">
    <input type="hidden" id="JQSL" name="JQSL" value="<%=JQSL%>">
    <input type="hidden" id="LXBS" name="LXBS" value="<%=LXBS%>">
    <input type="hidden" id="YYBB" name="YYBB" value="<%=YYBB%>">
    <input type="hidden" id="FCI" name="FCI" value="<%=FCI%>">
    <input type="hidden" id="MAC" name="MAC" value="<%=MAC%>">
</body>
</html>