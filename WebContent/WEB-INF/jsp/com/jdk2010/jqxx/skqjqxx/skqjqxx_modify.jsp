<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>机器信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/laydate/laydate.js"></script>
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
			<li><a href="#">${nsrwjbm }-机器信息</a></li>
		</ul>
	</div>
	<div class="formbody">
		<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">机器信息修改</a></li>
				</ul>
			</div>
			<div id="tab1" class="tabson">
				<ul class="forminfo">
					<form action="" method="post" id="skqJqxxForm">
						<input type="hidden" value="${nsrwjbm }" name="skqJqxx.nsrwjbm"
							id="nsrwjbm" /> <input type="hidden" value="${skqJqxx.id }"
							name="skqJqxx.id" id="id" />
						<table width="100%">
							<tr>
								<td>机器编号</td>

								<td>${skqJqxx.jqbh } <input type="hidden" class="dfinput"
									id="jqbh" name="skqJqxx.jqbh" placeholder="请输入机器编号"
									value="${skqJqxx.jqbh }" /></td>
								<td>用户卡号</td>
								<td>${skqJqxx.yhkh } <input type="hidden" class="dfinput"
									id="yhkh" name="skqJqxx.yhkh" placeholder="请输入用户卡号"
									value="${skqJqxx.yhkh }" maxlength="16"/></td>

							</tr>
							<tr>
								<td>税控卡号</td>
								<td>${skqJqxx.skkh }<input type="hidden" class="dfinput"
									id="skkh" name="skqJqxx.skkh" placeholder="请输入税控卡号"
									value="${skqJqxx.skkh }" maxlength="16"/></td>
								<td>机器型号编码</td>
								<td>
									<div class="vocation" style="margin-top: 10px">
										<select name="skqJqxx.jqxhbm" class="select1">
											<c:forEach var="jqxh" items="${jqxhList }">
												<option value="${jqxh.jqxhbm }"
													<c:if test="${ skqJqxx.jqxhbm==jqxh.jqxhbm}">selected</c:if>>${jqxh.jqxhmc
													}</option>
											</c:forEach>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td>卡启用日期</td>
								<td><input type="text" class="dfinput" id="kqyrq"
									name="skqJqxx.kqyrq" onclick="laydate()"
									value='<fmt:formatDate value="${skqJqxx.kqyrq }"   pattern="yyyy-MM-dd"/>'></input></td>
								<td>卡有效日期</td>
								<td><input type="text" class="dfinput" id="kyxrq"
									name="skqJqxx.kyxrq" placeholder="请输入卡有效日期" onclick="laydate()"
									value='<fmt:formatDate value="${skqJqxx.kyxrq }"   pattern="yyyy-MM-dd"/>' /></td>
							</tr>

							<input type="hidden" class="dfinput" id="sbfs"
								name="skqJqxx.sbfs" value="1" />
							<!--1申报明细  0不申报明细  -->
							<input type="hidden" class="dfinput" id="mxsbbz"
								name="skqJqxx.mxsbbz" value="1" />
							<tr>
								<td>开票截止日期</td>
								<td><input type="text" class="dfinput" id="kpjzrq"
									name="skqJqxx.kpjzrq" placeholder="请输入开票截止日期"
									onclick="laydate()"
									value='<fmt:formatDate value="${skqJqxx.kpjzrq }"   pattern="yyyy-MM-dd"/>' /></td>
								<td>单张开票限额</td>
								<td>
								<fmt:formatNumber value="${skqJqxx.dzkpxe }" type="currency" pattern="#0.00" var="dzkpxe"/>
						 
								<input type="text" class="dfinput" id="dzkpxe"
									name="skqJqxx.dzkpxe" placeholder="请输入单张开票限额" maxlength="8"
									value="${dzkpxe }" /></td>
							</tr>
							<tr>
								<td>月累计开票限额</td>
								<fmt:formatNumber value="${skqJqxx.yljkpxe }" type="currency" pattern="#0.00" var="yljkpxe"/>
								<td><input type="text" class="dfinput" id="yljkpxe"
									name="skqJqxx.yljkpxe" placeholder="请输入月累计开票限额" maxlength="8"
									value="${yljkpxe }" /></td>
								<td>月累计退票限额</td>
								<fmt:formatNumber value="${skqJqxx.yljtpxe }" type="currency" pattern="#0.00" var="yljtpxe"/>
								<td><input type="text" class="dfinput" id="yljtpxe" maxlength="8"
									name="skqJqxx.yljtpxe" placeholder="请输入月累计退票限额"
									value="${yljtpxe }" /></td>
							</tr>
							<tr>
								<td>状态</td>
								<td>
									<div class="vocation">
										<select name="skqJqxx.status" class="select1">
											<option value="1"
												<c:if test="${ skqJqxx.status==1}">selected</c:if>>启用</option>
											<option value="0"
												<c:if test="${ skqJqxx.status==0}">selected</c:if>>停用</option>
										</select>
									</div>
								</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</table>
				</ul>
				<br />
				<div class="formtitle1">
					<span>机器税种税目</span>
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
							<th>经营项目内容</th>
							<th>税率</th>
						</tr>
					</thead>
					<input type="hidden" id="smbms" name="smbms" value="${smbms }" />
					<input type="hidden" id="hiddenStr" name="hiddenStr"
						value='${hiddenStr }' />
					<tbody id="nsrszsmDiv">
						<c:forEach var="item" items="${jqszsmList }">
							<tr>
								<td>${item.szbm }</td>
								<td>${item.smbm }</td>
								<td>${item.smmc }</td>
								<td><input type="text" name="${item.smbm }smjc" value="${item.smjc }" style="height:40px;padding-left:5px"/></td>
								<td>${item.sl }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br /> <br />
				<div style="left: 25%;">
					<ul class="forminfo">
						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value=" 确定" /> &nbsp;&nbsp; <input name=""
							type="button" class="btn" value="返回"
							onclick="window.location='${ contextpath}/skqjqxx/list.htm?nsrwjbm=${skqJqxx.nsrwjbm }'" /></li>
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
	function deleteSzsm() {
		$("#smbms").val("");
		$("#hiddenStr").val("");
		$("#nsrszsmDiv").html("");
	}
	function selectSzsm() {
		layer
				.open({
					type : 2,
					title : '选择机器税种税目',
					shadeClose : true,
					area : [ '580px', '90%' ],
					content : '${contextpath}/skqpmsz/selectJqszsm.htm?nsrwjbm=${skqJqxx.nsrwjbm}&smbms='
							+ $("#smbms").val() //iframe的url
				});
	}
	$(document)
			.ready(
					function() {
						$(".select1").uedSelect({
							width : 240
						});
						$('#skqJqxxForm')
								.on(
										"click",
										".doSubmit",
										function(e) {
											var a = $(e.delegateTarget)
													.trigger("validate");
										})
								.validator(
										{
											fields : {
												'skqJqxx.kqyrq' : 'required;',
												'skqJqxx.kyxrq' : 'required;',
												'skqJqxx.sbfs' : 'required;',
												'skqJqxx.mxsbbz' : 'required;',
												'skqJqxx.kpjzrq' : 'required;',
												'skqJqxx.dzkpxe' : 'required;range[~42000000]',
												'skqJqxx.yljkpxe' : 'required;range[~42000000]',
												'skqJqxx.yljtpxe' : 'required;range[~42000000]'
											},
											valid : function(form) {
												var me = this;
												 
 												var hiddenStr = $("#hiddenStr")
														.val();
												if (hiddenStr == '') {
													layer.msg('请选择机器税种税目！', {
														closeBtn : 0,
														time : 1000
													}, function() {
														selectSzsm();
													});
													return false;
												}

												$.ajax({
															url : "${ contextpath}/skqjqxx/modifyaction",
															data : $(form)
																	.serialize(),
															type : "POST",
															success : function(
																	data) {
																// 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
																me.holdSubmit(false);
																if (data.status == 'success') {

																	layer.alert(
																					'当前操作成功',
																					{
																						closeBtn : 0
																					},
																					function() {
																						window.location.href = '${ contextpath}/skqjqxx/list.htm?nsrwjbm=${skqJqxx.nsrwjbm}';
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
