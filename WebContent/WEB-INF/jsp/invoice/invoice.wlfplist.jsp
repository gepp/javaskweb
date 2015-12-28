<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
			<li><a href="#">网络发票购买</a></li>
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
				<th>税务机关名称</th>
				<td>${nsrxx.swjgmc }</td>
			</tr>
			<tr>
				<th>纳税人名称</th>
				<td>${nsrxx.nsrmc }</td>
				<th>&nbsp;</th>
				<td>&nbsp;</td>
			</tr>
			 
		</thead>
	</table>
	 
	<div class="formtitle1">
		<span>税控发票领购情况</span>
	</div>
	<table class="tablelist">
		<thead>
			<tr>
				<th width="15%">领票日期</th>
				<th width="15%">发票代码</th>
				<th width="15%">发票单位（卷）</th>
				<th>发票号码起止</th>
				<th width="12%">操作</th>
			</tr>
		</thead>

		<tbody id="nsrszsmDiv">
			<c:forEach var="noInvoice" items="${alFp }">
				<tr>
 					<td>${noInvoice.fplgrq }&nbsp;</td>
					<td>${noInvoice.fpdm }&nbsp;</td>
					<td>${noInvoice.fpdw }&nbsp;</td>
					<td>${noInvoice.fpqsh }&nbsp;---${noInvoice.fpjzh }</td>
					<td><a href="javascript:void(0)" onclick="deleteInvoice('${noInvoice.id}');" class="tablelink">删 除</a> &nbsp;</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<br/>
	<div style="left: 25%;">
		<ul class="forminfo">
			<li><label>&nbsp;</label><input name="" type="button"
				class="btn" value="发票增加" onclick="fplg();"/> 
				 <input name="" type="button" class="btn" value="返 回"
				onclick="window.location='${ contextpath}/skqfpj/wlfpgmImport.htm'" /></li>
		</ul>
	</div>
	<input type="hidden" value="${nsrxx.nsrwjbm }" id="nsrwjbm"/>
	<input type="hidden" value="${jqxx.jqbh }" id="jqbh"/>
</body>
</html>
<script type="text/javascript">

function fplg(){
	var nsrwjbm = document.getElementById('nsrwjbm').value;
	var jqbh = document.getElementById('jqbh').value;
	layer.open({
		type : 2,
		title : '发票增加',
		shadeClose : true,
		area : [ '620px', '90%' ],
		content : '${contextpath}/skqfpj/addWlkp.htm?nsrwjbm='+nsrwjbm+'&jqbh='+jqbh
	});
 
}

function deleteInvoice(id){
	layer.confirm('您确认删除这条数据么？',function(index){
		//ajax提交删除数据
		jQuery.ajax({
					type: "post", 
					url: "${contextpath}/skqfpjmx/delete.htm", 
					dataType: "json",
					data:{action:'delete',ids:id},
					success: function (data) { 
						if(data.status=='success'){
							layer.alert('删除成功', {
								closeBtn: 0
							}, function(){
								window.location.href=window.location.href = '${ contextpath}/skqfpj/wlfplist.htm?nsrwjbm=${nsrxx.nsrwjbm}';
							});
						}else{
							layer.alert(data.message, {
								closeBtn: 0
							}, function(){
								window.location.href=window.location.href = '${ contextpath}/skqfpj/wlfplist.htm?nsrwjbm=${nsrxx.nsrwjbm}';
							});
						}
						
						 
					} 
			});
	});
}

 




</script>