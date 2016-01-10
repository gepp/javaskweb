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
<script type="text/javascript" src="${contextpath }/res/js/jquery.js"></script>
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

</head>
<body style="min-width: 300px">



	<div class="rightinfo">

		<div class="formtitle1">
			<span>网络发票购买</span>
		</div>
		<ul class="forminfo">
			<form action="" method="post" id="skqFpjForm">
			<input type="hidden" value="${nsrxx.nsrwjbm }"  name="nsrwjbm" id="nsrwjbm"/>
				<li><label>发票编码<b></b></label>
					<div class="vocation">
						<select name="skqFpj.fpbm" class="select1">
							<c:forEach var="item" items="${fpList }">
								<option value="${item.fpbm }">${item.fpmc }</option>
							</c:forEach>
						</select>
					</div>
					&nbsp;<input type="checkbox" id="fpjy" name="fpjy" >发票校验</input>
					</li>
				<li><label>发票代码<b></b></label> <input type="text"
					class="dfinput" id="fpdm" name="skqFpj.fpdm" value="${fpdm }" maxlength="12"/>
					
					</li>
				<li><label>发票起始号码<b></b></label> <input type="text"
					class="dfinput" id="fpqsh" name="skqFpj.fpqsh"
					placeholder="请输入发票起始号码" onblur="change_sl();" maxlength="8"/></li>
				<li><label>发票截止号码<b></b></label> <input type="text"
					class="dfinput" id="fpjzh" name="skqFpj.fpjzh"
					placeholder="请输入发票截止号码" readonly  maxlength="8"/></li>
				<li><label>发票单位(卷)<b></b></label> <input type="text"
					class="dfinput" id="fpdw" name="skqFpj.fpdw" value="1"
					placeholder="请输入发票单位" onblur="change_sl();" maxlength="4"/></li>
				<li><label>发票数量<b></b></label> <input type="text"
					class="dfinput" id="fpsl" name="fpsl" placeholder="" readonly /></li>
				<li><label>每卷发票张数<b></b></label> <input type="text"
					class="dfinput" id="fpzs" name="fpzs" placeholder="" onblur="change_sl();" value="${FPZS }"/></li>
				<li><label>&nbsp;</label><input name="" type="submit"
					class="btn" value="确认发票领购" /> &nbsp;&nbsp; <input name=""
					type="button" class="btn" value="关闭" onclick="closeWindow();" /></li>
			</form>
		</ul>


	</div>
</body>
</html>

<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	function change_sl() {
		var fpqsh = $("#fpqsh").val()*1;
		var fpdw = $("#fpdw").val()*1;
		var fpzs = $("#fpzs").val()*1;
		if (fpqsh != '' && fpdw != '') {
			$("#fpsl").val(fpzs * fpdw);
			$("#fpjzh").val(fpqsh + fpzs * fpdw - 1);
		}
	}
	function closeWindow() {
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}
	$(document)
			.ready(
					function() {
						$(".select1").uedSelect({
							width : 320
						});
						$('#skqFpjForm')
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
												'skqFpj.fpdm' : 'required;length[1~12]',
												'skqFpj.fpqsh' : 'required;length[1~8]',
												'skqFpj.fpjzh' : 'required;length[1~8]',
												'skqFpj.fpdw' : 'required;length[1~4]'

											},
											valid : function(form) {
												var me = this;
												// 提交表单之前，hold住表单，防止重复提交
												me.holdSubmit();
												$
														.ajax({
															url : "${ contextpath}/skqfpj/addaction",
															data : $(form)
																	.serialize(),
															type : "POST",
															success : function(
																	data) {
																// 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
																me
																		.holdSubmit(false);
																if (data.status == 'success') {

																	layer.alert(
																					'当前操作成功',
																					{
																						closeBtn : 0
																					},
																					function() {
																						parent.window.location.href = '${ contextpath}/skqfpj/wlfplist.htm?nsrwjbm='+$("#nsrwjbm").val();
																						closeWindow();
																					});

																} else {
																	$("#fpjzh").val("");
																	$("#fpqsh").val("");
																	$("#fpsl").val("");
																	layer.alert(data.message);
																	
																}

															}
														});
											}
										});

					});
</script>

