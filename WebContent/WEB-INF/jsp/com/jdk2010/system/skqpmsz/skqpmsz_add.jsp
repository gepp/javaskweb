<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>品目设置</title>
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
</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">品目设置</a></li>
		</ul>
	</div>
	<div class="formbody">
		<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">品目设置添加</a></li>
				</ul>
			</div>
			<div id="tab1" class="tabson">
				<ul class="forminfo">
					<form action="" method="POST" id="skqPmszForm">


						<li><label>税种编码<b></b></label> <input type="text"
							class="dfinput" id="szbm" name="skqPmsz.szbm"
							placeholder="请输入税种编码" /></li>
						<li><label>税目编码<b></b></label> <input type="text"
							class="dfinput" id="smbm" name="skqPmsz.smbm"
							placeholder="请输入税目编码" /></li>
						<li><label>税目名称<b></b></label> <input type="text"
							class="dfinput" id="smmc" name="skqPmsz.smmc"
							placeholder="请输入税目名称" /></li>
						<li><label>税目简称<b></b></label> <input type="text"
							class="dfinput" id="smjc" name="skqPmsz.smjc"
							placeholder="请输入税目简称" /></li>
						<li><label>税率<b></b></label> <input type="text"
							class="dfinput" id="sl" name="skqPmsz.sl" placeholder="请输入税率" />
						</li>
						<li><label>税目索引<b></b></label> <input type="text"
							class="dfinput" id="smsy" name="skqPmsz.smsy"
							placeholder="请输入税目索引" /></li>
						<li><label>票种编码<b></b></label> <input type="text"
							class="dfinput" id="fpbm" name="skqPmsz.fpbm" placeholder="" 
							readonly onclick="selectFp();" /> <input type="button"
							value="选择票种" onclick="selectFp();" class="btn" /></li>
						<li><label>核定户开票限额比例<b></b></label> <input type="text"
							class="dfinput" id="hdkpbl" name="skqPmsz.hdkpbl"
							placeholder="请输入核定户开票限额比例" /></li>
						<li><label>查账征收户开票限额<b></b></label> <input type="text"
							class="dfinput" id="czkpxe" name="skqPmsz.czkpxe"
							placeholder="请输入查账征收户开票限额" /></li>
						<li><label>是否差额征收<b></b></label>
							<div class="vocation">
								<select name="skqPmsz.cezs" class="select1">
									<option value="1">是</option>
									<option value="0">否</option>
								</select>
							</div></li>
						<li><label>状态<b></b></label>
							<div class="vocation">
								<select name="skqPmsz.status" class="select1">
									<option value="1">启用</option>
									<option value="0">停用</option>
								</select>
							</div></li>

						<li><label>&nbsp;</label><input name="" type="submit"
							class="btn" value=" 确定" /> &nbsp;&nbsp; <input name=""
							type="button" class="btn" value="返回"
							onclick="window.location='${ contextpath}/skqpmsz/list'" /></li>
					</form>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>


<script type="text/javascript">

	function selectFp(){
		layer.open({
		    type: 2,
		    title: '选择发票票种【点击行选中】',
		    shadeClose: true,
		    shade: 0,
		    area: ['580px', '90%'],
		    
		    content: '${contextpath}/skqfp/select.htm' //iframe的url
		}); 
	}
	$(document)
			.ready(
					function() {
						$(".select1").uedSelect({
							width : 345
						});
						$('#skqPmszForm')
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
												'skqPmsz.szbm' : 'required;',
												'skqPmsz.smbm' : 'required;',
												'skqPmsz.smmc' : 'required;',
												'skqPmsz.smjc' : 'required;',
												'skqPmsz.sl' : 'required;',
												'skqPmsz.smsy' : 'required;',
												'skqPmsz.hdkpbl' : 'required;',
												'skqPmsz.czkpxe' : 'required;'
 
											},
											valid : function(form) {
												var me = this;
												// 提交表单之前，hold住表单，防止重复提交
												me.holdSubmit();
												$
														.ajax({
															url : "${ contextpath}/skqpmsz/addaction",
															data : $(form)
																	.serialize(),
															type : "POST",
															success : function(
																	data) {
																// 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
																me
																		.holdSubmit(false);
																if (data.status == 'success') {

																	layer
																			.alert(
																					'当前操作成功',
																					{
																						shade : 0,
																						closeBtn : 0
																					},
																					function() {
																						window.location.href = '${ contextpath}/skqpmsz/list';
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
