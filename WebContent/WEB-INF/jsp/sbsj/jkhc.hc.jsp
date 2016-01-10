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
			String smxkArr1 = (String)request.getAttribute("smxkArr1");
			String NSRSBH = (String)request.getAttribute("NSRSBH");
			HashMap hmJkhc = (HashMap) request.getAttribute("hmJkhc");
			SkqJqxx jqxx = (SkqJqxx) hmJkhc.get("jqxx");
			SkqNsrxx nsrxx = (SkqNsrxx) hmJkhc.get("nsrxx");
			String old_nsrwjbm = (String) hmJkhc.get("old_nsrwjbm");
			String kpjzrq = (String) hmJkhc.get("kpjzrq");
			String[] smxkArr = (String[]) hmJkhc.get("smxkArr");
			System.out.println(smxkArr);
			DecimalFormat dg = new DecimalFormat("0.00");
			String xckpjzrq = (String) hmJkhc.get("xckpjzrq");
			System.out.println("xckpjzrq:"+xckpjzrq);
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
			String nsrmc=nsrxx.getNsrmc();
			if(nsrmc.length()>20){
				nsrmc=nsrmc.substring(0,20);
			}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>清零解锁信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/laydate/laydate.js"></script>
<script type="text/javascript" language="javascript">
	function declareback() {
		var KPJZRQ = document.all('KPJZRQ').value;
		var MAKE_END_DATE = document.all('MAKE_END_DATE').value;
		MAKE_END_DATE=MAKE_END_DATE.replace(new RegExp(/(-)/g),'');
		var MAC = document.getElementById('MAC').value;
		if(KPJZRQ==''){
			alert('请选择开票截止日期  ' + KPJZRQ);
			return false;
		}
		
		if (MAKE_END_DATE <= KPJZRQ) {
			alert('申报日期必须大于  ' + KPJZRQ);
			return false;
		} else

		if (MAC == 'null' || MAC == '') {
			alert('MAC为空，请重新插卡进行清零解锁！');
			return false;
		}

		else {
			var frm = document.form1;
				document.all('MAKE_MAX_SINGLE').value = document
						.all('MAKE_MAX_SINGLE1').value * 100;
				document.all('MAKE_MAX_SUM').value = document
						.all('MAKE_MAX_SUM1').value * 100;
				document.all('BACK_MAX_SUM').value = document
						.all('BACK_MAX_SUM1').value * 100;
				ssAlert('清零解锁中，请等待……');
				try {
					var JQBH = document.all('JQBH').value;
					var src = "${contextpath}/skqsbsj/updateKpxe.htm?kpjzrq="
						+ document.all('MAKE_END_DATE').value
						+ "&jqbh="
						+ JQBH
						+ "&dzkpxe="
						+ document.all('MAKE_MAX_SINGLE1').value
						+ "&yljkpxe="
						+ document.all('MAKE_MAX_SUM1').value
						+ "&yljtpxe="
						+ document.all('BACK_MAX_SUM1').value
						+ '&mac='
						+ document.all('MAC').value;
				 
					
					var v = document.DeclareBackApplet.declardBackData();

					if (v == 1) {
						document.updateForm.action=src;
						
						document.updateForm.submit();
						alert("清零解锁成功");
						div_close();
						window.location.href='${contextpath}/skqsbsj/toJkhc.htm';
						window.close();
					} else {
						div_close();
						alert("清零解锁失败");

					}
				} catch (e) {
					div_close();
					alert("清零解锁失败!");
				}
		}

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
	
	function declarebackSt() {
		var KPJZRQ = document.all('KPJZRQ').value;
		var MAKE_END_DATE = document.all('MAKE_END_DATE').value;
		MAKE_END_DATE=MAKE_END_DATE.replace(new RegExp(/(-)/g),'');
		var MAC = document.getElementById('MAC').value;
		if(KPJZRQ==''){
			alert('请选择开票截止日期  ' + KPJZRQ);
			return false;
		}
		
		if (MAKE_END_DATE <= KPJZRQ) {
			alert('申报日期必须大于  ' + KPJZRQ);
			return false;
		} else

		if (MAC == 'null' || MAC == '') {
			alert('MAC为空，请重新插卡进行清零解锁！');
			return false;
		}

		else {
			//alert(111);
			var frm = document.form1;
				document.all('MAKE_MAX_SINGLE').value = document
						.all('MAKE_MAX_SINGLE1').value * 100;
				document.all('MAKE_MAX_SUM').value = document
						.all('MAKE_MAX_SUM1').value * 100;
				document.all('BACK_MAX_SUM').value = document
						.all('BACK_MAX_SUM1').value * 100;
				ssAlert('清零解锁中，请等待……');
				try {
					var JQBH = document.all('JQBH').value;
					var src = "${contextpath}/skqsbsj/updateKpxe.htm?kpjzrq="
						+ document.all('MAKE_END_DATE').value
						+ "&jqbh="
						+ JQBH
						+ "&dzkpxe="
						+ document.all('MAKE_MAX_SINGLE1').value
						+ "&yljkpxe="
						+ document.all('MAKE_MAX_SUM1').value
						+ "&yljtpxe="
						+ document.all('BACK_MAX_SUM1').value
						+ '&mac='
						+ document.all('MAC').value;
					//alert(src);
					var MAKE_MAX_SINGLE = document.all('MAKE_MAX_SINGLE').value;
					//alert(MAKE_MAX_SINGLE);
					var MAKE_MAX_SUM = document.all('MAKE_MAX_SUM').value;
					var BACK_MAX_SUM = document.all('BACK_MAX_SUM').value;
					var TAXPAYER_NO = document.all('TAXPAYER_NO').value;
					//var JQBH = document.all('JQBH').value;
					var SKKH = document.all('SKKH').value;
					//var MAC = document.all('MAC').value;
					var smxkArr1 = document.all('smxkArr1').value;
					//alert(smxkArr1);
					//var KPJZRQ = document.all('MAKE_END_DATE').value;
					var NSRSBH = document.all('NSRSBH').value;
					
					
					//var v = document.DeclareBackApplet.declardBackData();
					var sid = "JKHCXK_"+TAXPAYER_NO+"^"+SKKH+"^"+JQBH+"^"+MAKE_END_DATE+"^"+MAKE_MAX_SINGLE+"^"+MAKE_MAX_SUM+"^"+BACK_MAX_SUM+"^"+MAC+"^"+smxkArr1+"^"+NSRSBH;
					alert(sid);
					var v = document.dsfxk.call(sid);
					if (v == 1) {
						document.updateForm.action=src;
						
						document.updateForm.submit();
						alert("清零解锁成功");
						div_close();
						window.location.href='${contextpath}/skqsbsj/toJkhc.htm';
						window.close();
					} else {
						div_close();
						alert("清零解锁失败");

					}
				} catch (e) {
					div_close();
					alert("清零解锁失败!");
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
			<li><a href="#">清零解锁信息</a></li>
		</ul>
	</div>
  <div class="formtitle1">
		<span><strong><font color="#FF0000">上次开票截止日期是：<%=kpjzrq%>,本次申报日期必须大于该日期</font></strong></span>
	</div>
	<table class="tableEdit">
		<thead>
			<tr>
				<th style="width:15%">下次申报截止日期：</th>
				<td>
				<input type="text" id="MAKE_END_DATE" name="MAKE_END_DATE" size="20"  class="input" value="<%=xckpjzrq %>" onclick="laydate({format: 'YYYYMMDD'})" />
				</td>
			</tr>
			<tr>
				<th>单笔开票最高限额（元）</th>
				<td><input type="text" name="MAKE_MAX_SINGLE1" style="border:1px" size="20" class="input" value="<%=dg.format(jqxx.getDzkpxe()) %>" /></td>
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
			<!-- <li style="height:40px; padding-left:20px; font-size:16px;"><label style="font-size:16px;">选择厂商:</label>
		<input type="radio" name="sccs1" value="001" checked onClick="change_sccs('001');" />
              大唐
        <input type="radio" name="sccs1" value="002" onClick="change_sccs('002');"/>
              四通
		</li> -->
			<li><label>&nbsp;</label>
			<input type="button" id="dt" class="btn" name="addBtn" value="确 定" onClick="declareback();"/>
			<input type="button" id="st" style="display:none;" class="btn" name="addBtn1" value="四通确定" onClick="declarebackSt();"/>
		 	</li>
		<object classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
			name="DeclareBackApplet" width="1" height="1"
			codebase="http://java.sun.com/products/plugin/1.2.2/jinstall-1_2_2-win.cab#Version=1,2,2,0">
			<param name="java_code" value="com.jsdt.web.applet.DeclareBacklet.class" />
			<param name="java_codebase" value="<%=basePath%>" />
			<param name="java_archive" value="dtapplet.jar" />
			<param name="type" value="application/x-java-applet" />
			<param name="serverUrl" value="<%=basePath%>" />
			<comment> <EMBED type="application/x-java-applet"
				name="DeclareBackApplet" width="1" height="1"
				pluginspage="http://java.sun.com/products/plugin/"
				java_code="com.jsdt.web.applet.DeclareBacklet.class" java_codebase="."
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
    <input type="hidden" id="TAXPAYER_NAME" name="TAXPAYER_NAME" value="<%=nsrmc.trim() %>">
    <input type="hidden" id="QYRQ" name="QYRQ" value="<%=QYRQ%>">
    <input type="hidden" id="YXRQ" name="YXRQ" value="<%=YXRQ%>">
    <input type="hidden" id="MXSBBZ" name="MXSBBZ" value="<%=MXSBBZ%>">
    <input type="hidden" id="JQLX" name="JQLX" value="<%=JQLX%>">
    <input type="hidden" id="JQSL" name="JQSL" value="<%=JQSL%>">
    <input type="hidden" id="LXBS" name="LXBS" value="<%=LXBS%>">
    <input type="hidden" id="YYBB" name="YYBB" value="<%=YYBB%>">
    <input type="hidden" id="FCI" name="FCI" value="<%=FCI%>">
    <input type="hidden" id="MAC" name="MAC" value="<%=MAC%>">
    <input type="hidden" id="smxkArr1" name="smxkArr1" value="<%=smxkArr1%>" />
    <input type="hidden" id="NSRSBH" name="NSRSBH" value="<%=NSRSBH%>">
    <form name="updateForm" src="" method="post" action="" id="updateForm">
    </form>
</body>
</html>