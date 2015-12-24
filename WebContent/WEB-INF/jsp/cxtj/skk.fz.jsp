<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>税控卡复制</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/layer/layer.js"></script>
	<%
	    HashMap hm = (HashMap) request.getAttribute("SKK");
	%>
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">税控卡复制</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<form method="post" action="${contextpath}/cxtj/skkFzInfo.htm" id="skkfzform" name="skkfzform">
			<ul class="seachform" style="padding-top: 10px; padding-left: 15px">

				<li><label style="width: 80px">机器编号</label><input type="text"
					name="jqbh" id="jqbh" class="scinput1" placeholder=""
					value="${SKK.jqbh }"></li>
				<li><label style="width: 80px">发票代码</label><input type="text"
					name="fpdm" id="fpdm" class="scinput1" placeholder=""
					value="${SKK.fpdm }"></li>
				<li><label style="width: 60px">发票起始号</label><input type="text"
					name="fpqsh" id="fpqsh" class="scinput1" placeholder=""
					value="${SKK.fpqsh }"></li>
				<li><label style="width: 60px">发票终止号</label><input type="text"
					name="fpjzh" id="fpjzh" class="scinput1" placeholder=""
					value="${SKK.fpjzh }"></li>
			</ul>

			<div style="align: center; margin-bottom: 20px">
				<br />
				<ul class="seachform" style="left: 35%; position: absolute;">
					<li><input name="" type="submit" id="table_refresh"
						class="scbtn1" value="查询" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn2" onclick="deleteInput();" value="清空" /></li>

				</ul>
				<br />
			</div>
		</form>
		
		<br/>
		<br/>

		<%
		    if (hm != null && !hm.isEmpty()) {
		        String sbfs = (String) hm.get("sbfs");
		        String mxsbfs = (String) hm.get("mxsbbz");
		%>

 		<div class="formtitle1">
			<span>纳税户信息</span>
		</div>
		<table class="tableEdit">
			<tr>
				<th width="20%">税控卡编号：</th>
				<td width="30%"><%=(String) hm.get("skkh")%>&nbsp;</td>
				<th width="20%">税控收款机编号：</th>
				<td width="30%"><%=(String) hm.get("jqbh")%>&nbsp;</td>
			</tr>
			<tr>
				<th>纳税人微机编码：</th>
				<td><%=(String) hm.get("nsrwjbm")%>&nbsp;</td>
				<th>纳税人识别号：</th>
				<td><%=(String) hm.get("nsrsbh")%>&nbsp;</td>
			</tr>
			<tr>
				<th>纳税人单位名称：</th>
				<td colspan="3"><%=(String) hm.get("nsrmc")%>&nbsp;</td>
			</tr>
			<tr>
				<th>应用启用日期：</th>
				<td><%=hm.get("kqyrq")%>&nbsp;</td>
				<th>应用有效日期：</th>
				<td><%=hm.get("kyxrq")%>&nbsp;</td>
			</tr>
			<tr>
				<th>主管分局代码：</th>
				<td><%=(String) hm.get("swjgbm")%>&nbsp;</td>
				<th>申报方式：</th>
				<td><%=sbfs%>&nbsp;</td>
			</tr>
		</table>
		<br />
	     <div class="formtitle1">
			<span>机器信息</span>
		</div>
		<table class="tableEdit">
			<tr>
				<th width="21%">开票截止日期：</th>
				<td width="29%"><%=hm.get("kpjzrq")%>&nbsp;</td>
				<th width="25%">单张发票开票金额限额(元)：</th>
				<td width="25%"><%=hm.get("dzkpxe")%>&nbsp;</td>
			</tr>
			<tr>
				<th>发票累计金额限额（元）：</th>
				<td><%=hm.get("yljkpxe")%>&nbsp;</td>
				<th>退票累计金额限额（元）：</th>
				<td><%=hm.get("yljtpxe")%>&nbsp;</td>
			</tr>
			<tr>
				<th>税种税目索引号：</th>
				<td><%=(String) hm.get("szsmsy")%>&nbsp;</td>
				<th>明细申报标志：</th>
				<td><%=mxsbfs%>&nbsp;</td>
			</tr>
		</table>
		<br />
		<div class="formtitle1">
			<span>发票信息</span>
		</div>
		<table class="tableEdit">
			<tr>
				<th width="10%">发票代码：</th>
				<td width="30%"><%=(String) hm.get("fpdm")%>&nbsp;</td>
				<th width="13%">发票起始号：</th>
				<td width="17%"><%=hm.get("fpqsh")%>&nbsp;</td>
				<th width="13%">发票终止号：</th>
				<td width="17%"><%=hm.get("fpjzh")%>&nbsp;</td>
			</tr>
		</table>
		<br />
	 <br />
		<div style="left: 25%;">
			<ul class="forminfo">
				<li>
				 <input name="" type="button" class="btn"
					value="复制税控卡"
					onclick="copyFcard();" />
				
				&nbsp;&nbsp; <input name="" type="button" class="btn"
					value="返回"
					onclick="window.location='${ contextpath}/cxtj/toSkkFz.htm'" />
					
					
				</li>
			</ul>
		</div>




	</div>

	<%
	    String nsrwjbm = (String) hm.get("nsrwjbm");
	        if (nsrwjbm.length() > 16) {
	            nsrwjbm = nsrwjbm.substring(0, nsrwjbm.length() - 2);
	        }
	%>
	<input type="hidden" id="TAXPAYER_NO" name="TAXPAYER_NO"  value="<%=nsrwjbm%>" />
 		<!-- 税控卡号--> 
 		<input type="hidden" id="FISCAL_CARD_NO" name="FISCAL_CARD_NO" value="<%=(String) hm.get("skkh")%>" /> 
 		<!-- 机器编号--> 
 		<input type="hidden" id="MACHINE_NO" name="MACHINE_NO" value="<%=(String) hm.get("jqbh")%>" /> 
 		<!-- 纳税户名称--> 
 		<input type="hidden" id="TAXPAYER_NAME" name="TAXPAYER_NAME" value="<%=(String) hm.get("nsrmc")%>" /> 
 		<!-- 申报截止时间-->
 		<input type="hidden" id="MAKE_END_DATE" name="MAKE_END_DATE" value="<%=hm.get("kpjzrq")%>" /> 
 		<!-- 单张发票开票限额--> 
 		<input type="hidden" id="MAKE_MAX_SINGLE" name="MAKE_MAX_SINGLE" 
 			   value="<%=Long.toString((long) (Double.parseDouble(hm.get("dzkpxe") + "") * 100))%>" />
 		<!-- 月累计最高开票限额--> 
 		<input type="hidden" id="MAKE_MAX_SUM" name="MAKE_MAX_SUM"
					value="<%=Long.toString((long) (Double.parseDouble(hm.get("yljkpxe") + "") * 100))%>" /> 
		<!-- 月累计最高退票限额--> 
		<input type="hidden" id="BACK_MAX_SUM" name="BACK_MAX_SUM"
					value="<%=Long.toString((long) (Double.parseDouble(hm.get("yljtpxe") + "") * 100))%>" />
		<!-- 明细申报标志--> 
		<input type="hidden" id="DECLARE_MAKE_TYPE" name="DECLARE_MAKE_TYPE" value="<%=mxsbfs%>" /> 
		<!-- 申报类型-->
		<input type="hidden" id="DECLARE_TYPE" name="DECLARE_TYPE" value="<%=sbfs%>" /> <!-- 税控卡有效时间--> 
		<input type="hidden" id="F_START_DATE" name="F_START_DATE" value="<%=hm.get("kqyrq")%>" /> 
		<!-- 税控卡截止时间--> 
		<input type="hidden" id="F_END_DATE" name="F_END_DATE" value="<%=hm.get("kyxrq")%>" /> 
		<!-- 主管科所--> 
		<input type="hidden" id="ORGAN_CODE" name="ORGAN_CODE" value="<%=(String) hm.get("swjgbm")%>" />
		<!-- 纳税人识别号--> 
		<input type="hidden" id="TAXPAYER_CODE" name="TAXPAYER_CODE" value="<%=(String) hm.get("nsrsbh")%>" /> 
		<!-- 发票代码--> 
		<input type="hidden" id="INVOICE_CODE" name="INVOICE_CODE" value="<%=(String) hm.get("fpdm")%>" />
		<!-- 发票起始号--> 
		<input type="hidden" id="INVOICE_START_NO" name="INVOICE_START_NO" value="<%=hm.get("fpqsh")%>" /> 
		<!-- 发票终止号--> 
		<input type="hidden" id="INVOICE_END_NO" name="INVOICE_END_NO" value="<%=hm.get("fpjzh")%>" />
		<!-- 税种税目索引--> <input type="hidden" id="SZSM_INDEX" name="SZSM_INDEX" value="<%=(String) hm.get("szsmsy")%>" /> 
		
		 
	 
		 <object classid="clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
			name="CopyFCApplet" width="1" height="1"
			codebase="http://java.sun.com/products/plugin/1.2.2/jinstall-1_2_2-win.cab#Version=1,2,2,0">
			<param name="java_code" value="com.jsdt.web.applet.TYFcCopylet.class" />
			<param name="java_codebase" value="<%=basePath%>" />
			<param name="java_archive" value="dtapplet.jar" />
			<param name="type" value="application/x-java-applet" />
			<param name="serverUrl" value="<%=basePath%>" />
			<comment> <EMBED type="application/x-java-applet"
				name="CopyFCApplet" width="1" height="1"
				pluginspage="http://java.sun.com/products/plugin/"
				java_code="com.jsdt.web.applet.TYFcCopylet.class" java_codebase="."
				java_archive="dtapplet.jar" serverUrl="<%=basePath%>" /> <noembed>

			</noembed> </comment>
		</object>
	<%
	    } 
	%>
	 
	<c:if test="${showFlag=='T' }">
		<table class="tableEdit">
			<tr>
				<th style="text-align:center">您好,暂时未查到相关记录,请确保相关信息正确！</th>
			</tr>
		</table>
	</c:if>

</body>

</html>

<link rel="stylesheet"
	href="${ contextpath }/res/js/validator-0.7.3/jquery.validator.css">
	<script type="text/javascript"
		src="${ contextpath }/res/js/validator-0.7.3/jquery.validator.js"></script>
	<script type="text/javascript"
		src="${ contextpath }/res/js/validator-0.7.3/local/zh_CN.js"></script>
<script type="text/javascript">
	

	 function copyFcard(){
			layer.confirm('确定发税控卡？', {
			    btn: ['确定','取消'] 
			}, function(index){
				try {
					layer.close(index);
					ssAlert('税控卡复制中，请等待……');
					var v = document.CopyFCApplet.copyTYFiscalCard();
					div_close();
					if (v == 1) {
						alert("税控卡 复制成功！！！");
					} else {
						alert("税控卡  复制失败！！！");
						
					}
				} catch (e) {
					alert("税控卡  复制失败！！！");
				}
			}, function(){
			    
		});
	 }
	 
	
	$(document).ready(function() {
		$('#skkfzform').on("click", ".doSubmit", function(e) {
			var a = $(e.delegateTarget).trigger("validate");
		}).validator({
			fields : {
				
			},
			valid : function(form) {
				var me = this;
				// 提交表单之前，hold住表单，防止重复提交
				var jqbh = document.getElementById('jqbh').value;
				//alert(jqbh);
				var fpdm = document.getElementById('fpdm').value;
				//alert(fpdm);
				var fpqsh = document.getElementById('fpqsh').value;
				//alert(fpqsh);
				var fpjzh = document.getElementById('fpjzh').value;
				//alert(fpjzh);
				if(jqbh==''||fpdm==''||fpqsh==''||fpjzh==''){
					sAlert('请输入机器编号，发票代码，发票起始号和发票终止号');
					return false;
				}
				
				window.location.href='${contextpath}/cxtj/skkFzInfo.htm?jqbh='+jqbh+'&fpdm='+fpdm+'&fpqsh='+fpqsh+'&fpjzh='+fpjzh;
			}
		});

	});
	
	function deleteInput(){
		document.getElementById('jqbh').value='';
		//alert(jqbh);
		document.getElementById('fpdm').value='';
		//alert(fpdm);
		document.getElementById('fpqsh').value='';
		//alert(fpqsh);
	    document.getElementById('fpjzh').value='';
	}
</script>

