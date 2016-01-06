<%@page import="com.jdk2010.tools.Util"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
    HashMap CARDINFO = (HashMap) request.getAttribute("CARDINFO");
	HashMap EF01 = (HashMap) CARDINFO.get("EF01");
	HashMap EF02 = (HashMap) CARDINFO.get("EF02");
	ArrayList EF03 = (ArrayList) CARDINFO.get("EF03");
	HashMap EF04 = (HashMap) CARDINFO.get("EF04");
	System.out.println(EF04);
	ArrayList EF05 = (ArrayList) CARDINFO.get("EF05");
	HashMap EF06 = (HashMap) CARDINFO.get("EF06");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>纳税人信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<link rel="stylesheet"
	href="${ contextpath }/res/js/validator-0.7.3/jquery.validator.css">
	<script type="text/javascript"
		src="${ contextpath }/res/js/validator-0.7.3/jquery.validator.js"></script>
	<script type="text/javascript"
		src="${ contextpath }/res/js/validator-0.7.3/local/zh_CN.js"></script>
	<link href="${ contextpath }/res/css/select.css" rel="stylesheet"
		type="text/css" />
	<script type="text/javascript"
		src="${ contextpath }/res/js/select-ui.min.js"></script>
	<style type="text/css">
.forminfo li label {
	width: 128px
}

.forminfo tr {
	height: 45px
}

.dfinput {
	width: 240px
}
</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">纳税人信息</a></li>
		</ul>
	</div>
	<div class="formbody">
		<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">纳税人信息修改</a></li>
				</ul>
			</div>
			<div class="formtitle1">
					<span>纳税人信息</span>
				</div>
				<form action="" method="post" id="skqNsrxxForm">
						<input type="hidden" value="${skqNsrxx.id }" id="id" name="skqNsrxx.id" />
								<table class="tableEdit">							
								<tr>
								 <th>纳税人微机编码</th>
								 <td><input type="text" class="dfinput" id="nsrwjbm"
									name="skqNsrxx.nsrwjbm" value="<%=(String) EF02.get("NSRWJDM")%>" readonly /> </td>
								<th>纳税人名称<b></b></th>
								<td><input type="text" class="dfinput" id="nsrmc"
									name="skqNsrxx.nsrmc"    value="<%=(String) EF02.get("NSRMC")%>" /></td>
							</tr>
								<input type="hidden" class="dfinput" id="yhde"
									name="skqNsrxx.yhde" placeholder=""   value="100000"  />
									
							<tr>
								<th>纳税人识别号<b></b></th>
								<td>
								<input type="text" class="dfinput" id="nsrsbh"
									name="skqNsrxx.nsrsbh" value=""  /> <font color="red">如果不确定,请读取税控卡</font>
								</td>
							</tr>
							<tr>
								<th>所属行业<b></b></th>
								<input type="hidden" class="dfinput" id="hybm" name="skqNsrxx.hybm"
									placeholder=""   value="" />
								<td><input type="text" class="dfinput" id="hymc"  value="" 
									name="hymc" placeholder="" readonly onclick="selectHy();" />
									<input type="button" value="选择" onclick="selectHy();"
									class="btn" /></td>
								<th>经营项目<b></b></th>
								<input type="hidden" class="dfinput" id="hymxbm" name="skqNsrxx.hymxbm"   value="" 
									placeholder="" />
								<td><input type="text" class="dfinput" id="hymxmc"   value=""  onclick="selecthymx();"
									name="hymxmc" placeholder="" readonly /> <input
									type="button" value="选择" onclick="selecthymx();"
									class="btn" /></td>
							</tr>

							<tr>
								<th>主管税务机关<b></b></th>
								<input type="hidden" name="skqNsrxx.swjgbm" id="swjgbm"   value="${skqNsrxx.swjgbm }" 
									class="scinput1" readonly value="${swjgbm}">
									<td><input type="text" class="dfinput" name="parentName"   value="${skqNsrxx.swjgmc }" 
										id="parentName" placeholder="" readonly onclick="selectParentOrganization();"/> <input
										type="button" value="选择" onclick="selectParentOrganization();"
										class="btn" /></td>
									<th>注册类型<b></b></th>
									<input type="hidden" class="dfinput" id="zclxbm"   value="${skqNsrxx.zclxbm }" 
										name="skqNsrxx.zclxbm"/>
									<td><input type="text" class="dfinput" id="zclxmc"   value="${skqNsrxx.zclxmc }" 
										name="zclxmc" placeholder="" readonly onclick="selectZclx();"/> <input
										type="button" value="选择" onclick="selectZclx();"
										class="btn" /></td>
							</tr>
							 

						</table>
					<br />
					<div class="formtitle1">
					<span>机器信息</span>
					</div>
					<table class="tableEdit">
							<tr>
								 <th>机器编号</th>
								 <td><input type="text" class="dfinput" id="nsrwjbm"
									name="skqJqxx.jqbh" value="<%=(String) EF06.get("JQBH")%>" readonly /> </td>
								<th>机器型号</th>
								<td>
									<div class="vocation" >
										<select name="skqJqxx.jqxhbm" class="select1">
											<c:forEach var="jqxh" items="${jqxhList }">
											
												<option value="${jqxh.jqxhbm }">${jqxh.jqxhmc }</option>
											</c:forEach>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<th>税控卡号<b></b></th>
								<td>
								<input type="text" class="dfinput"
									name="skqJqxx.skkh" value="<%=(String) EF06.get("SKKH")%>" readonly />
								</td>
								<th>用户卡号<b></b></th>
								<td>
								<input type="text" class="dfinput" id="nsrsbh"
									name="skqJqxx.yhkh" value="<%=(String) EF06.get("SKKH")%>" /><font color="red">请填写正确的用户卡</font>
								</td>
								
							</tr>
							<tr>
								 <th>开票截止日期</th>
								 <td><input type="text" class="dfinput"  
									name="kpjzrq" value="<%=(String) EF01.get("KPJZRQ")%>" readonly /> </td>
								<th>单张发票开票金额限额<b></b></th>
								<td>
								<input type="text" class="dfinput" id="nsrsbh"
									name="skqJqxx.dzkpxe" value="<%=new BigDecimal((Long) EF01.get("DZLJJE")).divide(new BigDecimal(100))%>"  readonly/>
								</td>
							</tr>
							<tr>
								 <th>发票累计金额限额</th>
								 <td><input type="text" class="dfinput" id="nsrwjbm"
									name="skqJqxx.yljkpxe" value="<%=new BigDecimal((Long) EF01.get("YKPLJJE")).divide(new BigDecimal(100))%>" readonly /> </td>
								<th>退票累计金额限额<b></b></th>
								<td>
								<input type="text" class="dfinput" id="nsrsbh"
									name="skqJqxx.yljtpxe" value="<%=new BigDecimal((Long) EF01.get("YTPLJJE")).divide(new BigDecimal(100))%>" readonly />
								</td>
							</tr>
							
								<tr>
								 <th>应用启用日期</th>
								 <td><input type="text" class="dfinput" id="nsrwjbm"
									name="kqyrq" value="<%=(String) EF02.get("QYRQ")%>" readonly /> </td>
								<th>应用有效日期<b></b></th>
								<td>
								<input type="text" class="dfinput" id="nsrsbh"
									name="kyxrq" value="<%=(String) EF02.get("YXRQ")%>" readonly />
								</td>
							</tr>
							
						</table>
					<input type="hidden" name="MXSBBZ" value="<%=(String) EF01.get("MXSBBZ")%>" />
					<div class="formtitle1">
						<span>纳税户税种税目</span>
					</div>
					<div class="tools">
						<ul class="toolbar">
							<li class="click" onclick="selectSzsm();"><span><img
									src="${contextpath }/res/images/t01.png" /></span>添加</li>
							<li class="click" onclick="deleteSzsm();"><span><img
									src="${contextpath }/res/images/t03.png" /></span>清空</li>
						</ul>
					</div>
					<font color="red">机器将添加默认的与纳税人一样的税种税目！</font>
					<br/>
					<table class="tablelist">
						<thead>
							<tr>
								<th>税种编码</th>
								<th>税目编码</th>
								<th>税目名称</th>
								<th>税目简称</th>
								<th>税率</th>
 							</tr>
						</thead>
						<input type="hidden" id="smbms" name="smbms" value="${smbms }"/>
						<input type="hidden" id="hiddenStr" name="hiddenStr" value='${hiddenStr }'/>
						<tbody id="nsrszsmDiv">
							<c:forEach var="item" items="${nsrszsmList }">
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
					<br /> <br />
					<div style="left:25%;">
					<ul class="forminfo">
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value=" 确定" /> &nbsp;&nbsp; <input name=""
							type="button" class="btn" value="返回"
							onclick="window.location='${ contextpath}/skqnsrxx/list'" /></li>
					</ul>
					</div>
				</form>
				
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>


<script type="text/javascript">
	function selectParentOrganization() {
		layer.open({
			type : 2,
			title : '选择税务机关【点击行选中】',
			shadeClose : true,
			area : [ '580px', '90%' ],

			content : '${contextpath}/securityorganization/select.htm' //iframe的url
		});
	}

	function selectHy() {
		layer.open({
			type : 2,
			title : '选择行业编码【点击行选中】',
			shadeClose : true,
			area : [ '580px', '90%' ],

			content : '${contextpath}/skqhy/select.htm' //iframe的url
		});
	}
	
	function selectZclx() {
		layer.open({
			type : 2,
			title : '选择注册类型【点击行选中】',
			shadeClose : true,
			area : [ '580px', '90%' ],

			content : '${contextpath}/skqzclx/select.htm' //iframe的url
		});
	}
	
	function selectSzsm(){
		layer.open({
			type : 2,
			title : '选择注册类型【点击行选中】',
			shadeClose : true,
			area : [ '580px', '90%' ],
			content : '${contextpath}/skqpmsz/select.htm?smbms='+$("#smbms").val() //iframe的url
		});
	}
	
	function deleteSzsm(){
		$("#smbms").val("");
		$("#hiddenStr").val("");
		$("#nsrszsmDiv").html("");
	}
	
	function selecthymx(){
		var hybm=$("#hybm").val();
		if(hybm==''){
			sAlert("请先选择行业！");
			return false;
		}
		layer.open({
			type : 2,
			title : '选择行业编码【点击行选中】',
			shadeClose : true,
			area : [ '580px', '90%' ],

			content : '${contextpath}/skqhymx/select.htm?hybm='+hybm //iframe的url
		});
	}

	$(document).ready(function() {
		$(".select1").uedSelect({
			width : 240
		});
		$('#skqNsrxxForm').on("click", ".doSubmit", function(e) {
			var a = $(e.delegateTarget).trigger("validate");
		}).validator({
			fields : {
  				'skqNsrxx.nsrsbh' : 'required;',
  				 
			},
			valid : function(form) {
				var me = this;
				// 提交表单之前，hold住表单，防止重复提交
				//me.holdSubmit();
				
				var hybm=$("#hybm").val();
				var hymxbm=$("#hymxbm").val();
				var swjgbm=$("#swjgbm").val();
				var zclxbm=$("#zclxbm").val();
				var hiddenStr=$("#hiddenStr").val();
				if(hybm==''){
					layer.msg('请选择行业！', {
						closeBtn: 0,time:1000
					}, function(){
						selectHy();
					});
					
					return false;
				}
				if(hymxbm==''){
					
					layer.msg('请选择行业明细！', {
						closeBtn: 0,time:1000
					}, function(){
						selecthymx();
					});
					
					return false;
				}
				if(swjgbm==''){
					layer.msg('请选择税务机关！', {
						closeBtn: 0,time:1000
					}, function(){
						selectParentOrganization();
					});
					
					return false;
				}
				if(zclxbm==''){
					layer.msg('请选择注册类型！', {
						closeBtn: 0,time:1000
					}, function(){
						selectZclx();
					});
					return false;
				}
				if(hiddenStr==''){
					layer.msg('请选择纳税人税种税目！', {
						closeBtn: 0,time:1000
					}, function(){
						selectSzsm();
					});
					return false;
				}
				
				
				$.ajax({
					url : "${ contextpath}/saveNsrxx",
					data : $(form).serialize(),
					type : "POST",
					success : function(data) {
						// 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
						me.holdSubmit(false);
						if (data.status == 'success') {
							layer.alert('当前操作成功', {
								closeBtn: 0
							}, function(){
								window.location.href='${ contextpath}/skqnsrxx/list';
							});
						 
						} else {
							sAlert('当前操作失败');
						}

					}
				});
			}
		});

	});
</script>
