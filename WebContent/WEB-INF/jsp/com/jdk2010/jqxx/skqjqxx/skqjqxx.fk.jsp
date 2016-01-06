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
<script type="text/javascript" src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
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
				<th>纳税人识别号<b></b></th>
				<td>${nsrxx.nsrsbh }</td>
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
				<fmt:formatNumber value="${jqxx.dzkpxe}" type="currency" pattern="#0.00" var="dzkpxe"/>
				<td>${dzkpxe }</td>
			</tr>

			<tr>
				<th>月累计开票最高限额（元）<b></b></th>
				<fmt:formatNumber value="${jqxx.yljkpxe}" type="currency" pattern="#0.00" var="yljkpxe"/>
				<td>${yljkpxe }</td>
				<th>月累计退票最高限额（元）<b></b></th>
				<fmt:formatNumber value="${jqxx.yljtpxe}" type="currency" pattern="#0.00" var="yljtpxe"/>
				<td>${yljtpxe }</td>
			</tr>
			<tr>
				<th>状态<b></b></th>
				<td>${ jqxx.status==1?'正常':'注销'}</td>
				<th>税务机关<b></b></th>
				<td>${nsrxx.swjgmc }</td>
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
	<ul style=" left:30%;bottom:15px">

		<!--<li style="height:40px; padding-left:20px; font-size:16px;"><label style="font-size:16px;">选择厂商:</label>
		<input type="radio" name="sccs1" value="001" checked onclick="change_sccs(this.value);" />
              大唐
        <input type="radio" name="sccs1" value="002" onclick="change_sccs(this.value);"/>
              四通
		</li> -->
 
		<li id="dt"><label>&nbsp;</label> <input type="button" class="btn"
			name="btn1" onClick="writeFcard()" value=" 发税控卡  "
			style="cursor: hand;" id="fskk" /> &nbsp;&nbsp; <input type="button"
			class="btn" name="btn2" onClick="writeUcard()" value=" 发用户卡"
			style="cursor: hand;" id="fyhk" /> &nbsp;&nbsp; <input name=""
			type="button" class="btn" value="返回" id="fh" onclick="window.location='${ contextpath }/skqjqxx/list.htm?nsrwjbm=${jqxx.nsrwjbm}'" />
		</li>
		<li id="st" style="display:none;"><label>&nbsp;</label> <input type="button" class="btn"
			name="btn1" onClick="writeFcardSt()" value=" 发税控卡 "
			style="cursor: hand;" id="fskk" /> &nbsp;&nbsp; <input type="button"
			class="btn" name="btn2" onClick="writeUcardSt()" value=" 发用户卡 "
			style="cursor: hand;" id="fyhk" /> &nbsp;&nbsp; <input name=""
			type="button" class="btn" value="返回" id="fh" onclick="window.location='${ contextpath }/skqjqxx/list.htm?nsrwjbm=${jqxx.nsrwjbm}'" />
		</li>
	</ul>
	<br />
	<br />
	<object classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
			name="WriteFCApplet" width="1" height="1"
			codebase="http://java.sun.com/products/plugin/1.2.2/jinstall-1_2_2-win.cab#Version=1,2,2,0">
			<param name="java_code" value="com.jsdt.web.applet.TYFcWritelet.class" />
			<param name="java_codebase" value="<%=basePath%>" />
			<param name="java_archive" value="dtapplet.jar" />
			<param name="type" value="application/x-java-applet" />
			<param name="serverUrl" value="<%=basePath%>" />
			<comment> <EMBED type="application/x-java-applet"
				name="dtapplet" width="1" height="1"
				pluginspage="http://java.sun.com/products/plugin/"
				java_code="com.jsdt.web.applet.TYFcWritelet.class" java_codebase="."
				java_archive="dtapplet.jar" serverUrl="<%=basePath%>" /> <noembed>
			</noembed> </comment>
		</object>
	<object classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
			name="WriteUCApplet" width="1" height="1"
			codebase="http://java.sun.com/products/plugin/1.2.2/jinstall-1_2_2-win.cab#Version=1,2,2,0">
			<param name="java_code" value="com.jsdt.web.applet.TYUcWritelet.class" />
			<param name="java_codebase" value="<%=basePath%>" />
			<param name="java_archive" value="dtapplet.jar" />
			<param name="type" value="application/x-java-applet" />
			<param name="serverUrl" value="<%=basePath%>" />
			<comment> <EMBED type="application/x-java-applet"
				name="dtapplet" width="1" height="1"
				pluginspage="http://java.sun.com/products/plugin/"
				java_code="com.jsdt.web.applet.TYUcWritelet.class" java_codebase="."
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
	 
	<%
	SkqNsrxx nsrxx = (SkqNsrxx)request.getAttribute("nsrxx");
	SkqJqxx jqxx = (SkqJqxx)request.getAttribute("jqxx");
	%>
	<input type="hidden" name="TAXPAYER_NO" id="TAXPAYER_NO" value="${OLD_WJBM }" />
          <!-- 税控卡号-->
          <input type="hidden" name="FISCAL_CARD_NO" id="FISCAL_CARD_NO" value="${jqxx.skkh }" />
          <!-- 机器编号-->
          <input type="hidden" name="MACHINE_NO" id="MACHINE_NO" value="<%=jqxx.getJqbh() %>" />
          <!-- 用户卡有效时间-->
          <input type="hidden" name="U_START_DATE" id="U_START_DATE" value="<%=Util.toxkrq(jqxx.getKqyrq()) %>" />
          <!-- 用户卡截止时间-->
          <input type="hidden" name="U_END_DATE" id="U_END_DATE" value="<%=Util.toxkrq(jqxx.getKyxrq()) %>" />
          <!-- 纳税户名称-->
          <input type="hidden" name="TAXPAYER_NAME" id="TAXPAYER_NAME" value="${nsrmc }" />
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
          
          <%
          String swjgbm=nsrxx.getSwjgbm();
          if (swjgbm != null && !"".equals(swjgbm)) {
  				if(swjgbm.length()>8){
  					swjgbm=swjgbm.substring(3);
  				}
  		}

          %>
          <input type="hidden" name="ORGAN_CODE" id="ORGAN_CODE" value="<%=swjgbm %>" />
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
	 
	function writeUcard() {
		
		layer.confirm('确定发用户卡？', {
		    btn: ['确定','取消'] 
		}, function(index){
			try {
				layer.close(index);
				ssAlert('用户卡发卡中，请等待……');
				var v = document.WriteUCApplet.writeTYUserCard();
				div_close();
				if (v == 1) {
					alert("用户卡 发卡成功！！！您已完成注册登记！");
				} else {
					alert("用户卡  发卡失败！！！");
					
				}
			} catch (e) {
				div_close();
				alert("用户卡  发卡失败！！！");
			}
		}, function(){
		    
		});
		 
	}

	function writeFcard() {
		
		layer.confirm('确定发税控卡？', {
		    btn: ['确定','取消'] 
		}, function(index){
			try {
				layer.close(index);
				ssAlert('税控卡发卡中，请等待……');
				var result = document.WriteFCApplet.writeTYFiscalCard();
				div_close();
				if (result == 1) {
					alert("税控卡  发卡成功！！！");
				} else {
					div_close();
					alert("税控卡   发卡失败！！！");
					
				}
			} catch (e) {
				div_close();
				alert("税控卡   发卡失败！！！");
			}
		}, function(){
		    
		});
		 
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
	
	function writeFcardSt(){
		var jqbh = $("#MACHINE_NO").val();
		ssAlert('税控卡发卡中，请等待……');
		jQuery.ajax({
			url:"${ contextpath}/skqjqxx/getWriteFcardSt?jqbh="+jqbh,
			type: "POST",
			success: function(data){
				// 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
				if(data.status=='success'){
					var sid = "SKKXK_"+data.data.skkfk;
					alert(sid);
					var v = document.dsfxk.call(sid);
					if(v==1){
						div_close();
						alert("税控卡发卡成功！！！");
					}
					else{
						div_close();
						alert("税控卡发卡失败！！！");
						
					}		 
				}else{
					sAlert("组合税控卡写卡信息失败");
				}
			   
			}
		});
	}
	
	function writeUcardSt(){
		var jqbh = $("#MACHINE_NO").val();
		ssAlert('税控卡发卡中，请等待……');
		jQuery.ajax({
			url:"${ contextpath}/skqjqxx/getWriteUcardSt?jqbh="+jqbh,
			type: "POST",
			success: function(data){
				// 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
				if(data.status=='success'){
					var sid = "YHKXK_"+data.data.yhkfk;
					alert(sid);
					var v = document.dsfxk.call(sid);
					if(v==1){
						div_close();
						alert("用户卡发卡成功！！！");
					}
					else{
						div_close();
						alert("用户卡发卡失败！！！");
						
					}		 
				}else{
					sAlert("组合用户卡写卡信息失败");
				}
			   
			}
		});
	}
 
</script>


