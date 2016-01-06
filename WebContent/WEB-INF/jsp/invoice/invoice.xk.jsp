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
				<th>纳税人识别号</th>
				<td>${nsrxx.nsrsbh }</td>
				<th>&nbsp;</th>
				<td>&nbsp;</td>
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
				<input type="hidden" value="${hasInvoiceSize }" id="num" />
			<c:forEach var="hasInvoice" items="${cardInvoice }">
				<c:if test="${hasInvoice.FPDM!='00000000000000000000'}">
				<tr>
				<td>${hasInvoice.FPDM }</td>
				<td>${hasInvoice.JS }</td>
				<td>${hasInvoice.QSH }---${hasInvoice.JZH }</td>
				</tr>
				</c:if>
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
		<object classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
			name="writeInvoiceApplet" width="1" height="1"
			codebase="http://java.sun.com/products/plugin/1.2.2/jinstall-1_2_2-win.cab#Version=1,2,2,0">
			<param name="java_code" value="com.jsdt.web.applet.InvoiceWritelet.class" />
			<param name="java_codebase" value="<%=basePath%>" />
			<param name="java_archive" value="dtapplet.jar" />
			<param name="type" value="application/x-java-applet" />
			<param name="serverUrl" value="<%=basePath%>" />
			<comment> <EMBED type="application/x-java-applet"
				name="dtapplet" width="1" height="1"
				pluginspage="http://java.sun.com/products/plugin/"
				java_code="com.jsdt.web.applet.InvoiceWritelet.class" java_codebase="."
				java_archive="dtapplet.jar" serverUrl="<%=basePath%>" /> <noembed>

			</noembed> </comment>
		</object>
		
		 
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
		<ul class="forminfo">
			<!--  <li style="height:40px; padding-left:20px; font-size:16px;"><label style="font-size:16px;">选择厂商:</label>
		<input type="radio" name="sccs1" value="001" checked onclick="change_sccs(this.value);" />
              大唐
        <input type="radio" name="sccs1" value="002" onclick="change_sccs(this.value);"/>
              四通
		</li> -->
			<li id="dt"><label>&nbsp;</label><input name="" type="button"
				class="btn" value="发票写卡" onclick="fpxk();" id="fpxk_btn" />
				&nbsp;&nbsp; <input name="" type="button" class="btn" value="返 回"
				onclick="window.location='${ contextpath}/skqfpj/info.htm'" /></li>
			<li id="st" style="display:none;"><label>&nbsp;</label><input name="" type="button"
				class="btn" value="发票写卡" onclick="fpxkSt();" id="fpxk_btn" />
				&nbsp;&nbsp; <input name="" type="button" class="btn" value="返 回"
				onclick="window.location='${ contextpath}/skqfpj/info.htm'" /></li>
		</ul>
	</div>
	<!-- 用户卡号-->
	<input type="hidden" name="YHKH" id="YHKH" value="${jqxx.yhkh }" />
	<!-- 微机编码-->
	<input type="hidden" name="WJBM_${jqxx.yhkh }" id="WJBM_${jqxx.yhkh }"
		value="${OLD_WJBM }" />
	<!-- 税控卡号-->
	<input type="hidden" name="FISCAL_CARD_NO_${jqxx.yhkh }"
		id="FISCAL_CARD_NO_${jqxx.yhkh }" value="${jqxx.skkh }" />
	<!-- 机器编号-->
	<input type="hidden" name="MACHINE_NO_${jqxx.yhkh }"
		id="MACHINE_NO_${jqxx.yhkh }" value="${jqxx.jqbh }" /> 
	${hiddenFpj }
	${hiddenFpjSt }
	<form name="addForm" method="post"
		action="${contextpath }/skqfpj/updateXkbz.htm" target="iframe">
		<input type="hidden" name="fpqshInfoStr" value="${fpqshInfoStr }" />
		<input type="hidden" name="jqbh"  value="${jqxx.jqbh }"/>
	</form>
	<iframe src="" name="iframe" frameborder="0" width="0" height="0"></iframe>
</body>
</html>

<script type="text/javascript">
	 
	function fpxk() {
		var yhkh = document.getElementById('YHKH').value;
		var fpxi_0 = document.all('fpxi_' + yhkh + '_0').value;
		if (fpxi_0 != '') {
			
			layer.confirm('确定用户卡已插入！', {
			    btn: ['确定','取消'] 
			}, function(index){
				try {
					layer.close(index);
					ssAlert('发票写卡中，请等待……');
					var result = document.writeInvoiceApplet.write(yhkh);
					div_close();
					if (result == 1) {
						var frm = document.addForm;
						frm.submit();
						
						ssAlert('读卡中，请等待……');
						var result1 = document.dtapplet.read();
						div_close();
						if (result1 == 1) {
							window.location.href = '${contextpath}/skqfpj/info.htm';
						} else {
							div_close();
							alert('卡基本信息读取失败！');
						}
					} else {
						div_close();
						alert('发票写卡失败！');
						
					}
				} catch (e) {
					div_close();
					alert('发票写卡失败！');
				}
			}, function(){
			    
			});
			
			 
		} else {
			alert('无发票信息');
		}
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
	
	function fpxkSt(){
		var yhkh = document.getElementById('YHKH').value;
		var fpxi_0 = document.all('fpxi_' + yhkh + '_0').value;
		if (fpxi_0 != '') {
			
			layer.confirm('确定用户卡已插入！', {
			    btn: ['确定','取消'] 
			}, function(index){
				try {
					layer.close(index);
					ssAlert('发票写卡中，请等待……');
					var fpxkxx = '';
					for(var i=0;i<10;i++){
						var fpxi_st = document.all('fpxi_st_'+i).value;
						if(fpxi_st!=''){
							if(fpxkxx==''){
								fpxkxx = fpxkxx+fpxi_st;
							}
							else{
								fpxkxx = fpxkxx+"|"+fpxi_st;
							}
						}
					}
					//alert(fpxkxx);
					var sid = "FPXK_"+fpxkxx;
					var v = document.dsfxk.call(sid);
					
					if(v==1){
						div_close();
						//window.location.href = '${contextpath}/skqfpj/info.htm';
						alert('发票写卡成功！');
					}
					else{
						div_close();
						alert('发票写卡失败！');
					}
				} catch (e) {
					div_close();
					alert('发票写卡失败！');
				}
			}, function(){
			    
			});
			
			 
		} else {
			alert('无发票信息');
		}
	}
	 
</script>