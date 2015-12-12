<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"%>
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
					<li><a href="#tab1" class="selected">纳税人信息添加</a></li>
				</ul>
			</div>
			<div id="tab1" class="tabson">
				<form action="" method="POST" id="skqNsrxxForm">
					<ul class="forminfo">
						<table width="100%">
							<tr>
								<td>纳税人微机编码<b></b></td>
								<td><input type="text" class="dfinput" id="nsrwjbm"
									name="skqNsrxx.nsrwjbm" placeholder="请输入纳税人微机编码" /></td>
								<td>纳税人识别号<b></b></td>
								<td><input type="text" class="dfinput" id="nsrsbh"
									name="skqNsrxx.nsrsbh" placeholder="请输入纳税人识别号" /></td>
							</tr>

							<tr>
								<td>纳税人名称<b></b></td>
								<td><input type="text" class="dfinput" id="nsrmc"
									name="skqNsrxx.nsrmc" placeholder="请输入纳税人名称" /></td>
								<td>经营地址<b></b></td>
								<td><input type="text" class="dfinput" id="jydz"
									name="skqNsrxx.jydz" placeholder="请输入经营地址" /></td>
							</tr>

							<tr>
								<td>法人代表<b></b></td>
								<td><input type="text" class="dfinput" id="frdb"
									name="skqNsrxx.frdb" placeholder="请输入法人代表" /></td>
								<td>税收管理员<b></b></td>
								<td><input type="text" class="dfinput" id="ssgly"
									name="skqNsrxx.ssgly" placeholder="请输入联系方式" /></td>

							</tr>
							<tr>

								<td>办税员<b></b></td>
								<td><input type="text" class="dfinput" id="bsy"
									name="skqNsrxx.bsy" placeholder="请输入办税员" /></td>
								<td>月核定营业额<b></b></td>
								<td><input type="text" class="dfinput" id="yhde"
									name="skqNsrxx.yhde" placeholder="请输入月核定营业额" /></td>
							</tr>
							<tr>
								<td>行业编码<b></b></td>
								<input type="hidden" class="dfinput" id="hybm" name="skqNsrxx.hybm"
									placeholder="" />
								<td><input type="text" class="dfinput" id="hymc"
									name="hymc" placeholder="" readonly onclick="selectHy();" />
									<input type="button" value="选择" onclick="selectHy();"
									class="btn" /></td>
								<td>行业明细编码<b></b></td>
								<input type="hidden" class="dfinput" id="hymxbm" name="skqNsrxx.hymxbm"
									placeholder="" />
								<td><input type="text" class="dfinput" id="hymxmc" onclick="selecthymx();"
									name="hymxmc" placeholder="" readonly /> <input
									type="button" value="选择" onclick="selecthymx();"
									class="btn" /></td>
							</tr>

							<tr>
								<td>主管科(所)<b></b></td>
								<input type="hidden" name="skqNsrxx.swjgbm" id="swjgbm"
									class="scinput1" readonly value="${swjgbm}">
									<td><input type="text" class="dfinput" name="parentName"
										id="parentName" placeholder="" readonly onclick="selectParentOrganization();"/> <input
										type="button" value="选择" onclick="selectParentOrganization();"
										class="btn" /></td>
									<td>注册类型编码<b></b></td>
									<input type="hidden" class="dfinput" id="zclxbm"
										name="skqNsrxx.zclxbm"/>
									<td><input type="text" class="dfinput" id="zclxmc"
										name="zclxmc" placeholder="" readonly onclick="selectZclx();"/> <input
										type="button" value="选择" onclick="selectZclx();"
										class="btn" /></td>
							</tr>
							<tr>
								<td>征收方式<b></b></td>
								<td>
									<div class="vocation">
										<select name="skqNsrxx.zsfs" class="select1">
											<option value="1">查账征收</option>
											<option value="0">核定户</option>
										</select>
									</div>
								</td>
								<td>状态<b></b></td>
								<td>
									<div class="vocation">
										<select name="skqNsrxx.status" class="select1">
											<option value="1">启用</option>
											<option value="0">停用</option>
										</select>
									</div>
								</td>
							</tr>

						</table>
					</ul>
					<br />
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
						<input type="hidden" id="smbms" name="smbms" value=""/>
						<input type="hidden" id="hiddenStr" name="hiddenStr" value=""/>
						<tbody id="nsrszsmDiv">
							
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
			shade : 0,
			area : [ '580px', '90%' ],

			content : '${contextpath}/securityorganization/select.htm' //iframe的url
		});
	}

	function selectHy() {
		layer.open({
			type : 2,
			title : '选择行业编码【点击行选中】',
			shadeClose : true,
			shade : 0,
			area : [ '580px', '90%' ],

			content : '${contextpath}/skqhy/select.htm' //iframe的url
		});
	}
	
	function selectZclx() {
		layer.open({
			type : 2,
			title : '选择注册类型【点击行选中】',
			shadeClose : true,
			shade : 0,
			area : [ '580px', '90%' ],

			content : '${contextpath}/skqzclx/select.htm' //iframe的url
		});
	}
	
	function selectSzsm(){
		layer.open({
			type : 2,
			title : '选择注纳税人税种税目',
			shadeClose : true,
			shade : 0,
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
			shade : 0,
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
				'skqNsrxx.nsrwjbm' : 'required;',
				'skqNsrxx.nsrsbh' : 'required;',
				'skqNsrxx.nsrmc' : 'required;',
				'skqNsrxx.jydz' : 'required;',
				'skqNsrxx.frdb' : 'required;',
				'skqNsrxx.yhde' : 'required;',
				'skqNsrxx.bsy' : 'required;',
				'skqNsrxx.ssgly' : 'required;',

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
						shade:0,closeBtn: 0,time:1000
					}, function(){
						selectHy();
					});
					
					return false;
				}
				if(hymxbm==''){
					
					layer.msg('请选择行业明细！', {
						shade:0,closeBtn: 0,time:1000
					}, function(){
						selecthymx();
					});
					
					return false;
				}
				if(swjgbm==''){
					layer.msg('请选择税务机关！', {
						shade:0,closeBtn: 0,time:1000
					}, function(){
						selectParentOrganization();
					});
					
					return false;
				}
				if(zclxbm==''){
					layer.msg('请选择注册类型！', {
						shade:0,closeBtn: 0,time:1000
					}, function(){
						selectZclx();
					});
					return false;
				}
				if(hiddenStr==''){
					layer.msg('请选择纳税人税种税目！', {
						shade:0,closeBtn: 0,time:1000
					}, function(){
						selectSzsm();
					});
					return false;
				}
				
				
				$.ajax({
					url : "${ contextpath}/skqnsrxx/addaction",
					data : $(form).serialize(),
					type : "POST",
					success : function(data) {
						// 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
						me.holdSubmit(false);
						if (data.status == 'success') {
							layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
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
