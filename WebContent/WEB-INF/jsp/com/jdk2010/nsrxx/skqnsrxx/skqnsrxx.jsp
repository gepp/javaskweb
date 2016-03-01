<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>纳税人信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>

</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">纳税人信息</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<form method="post" action="${ contextpath}/skqnsrxx/list">
			<ul class="seachform" style="padding-top: 10px; padding-left: 15px">
				<%-- <li><label style="width: 85px">纳税人微机编码</label><input
					type="text" name="NSRWJBM" id="NSRWJBM" class="scinput1"
					placeholder="请输入纳税人微机编码" value="${NSRWJBM}"></li> --%>
				<li><label style="width: 80px">纳税人识别号</label><input type="text"
					name="NSRSBH" id="NSRSBH" class="scinput1" placeholder="请输入纳税人识别号"
					value="${NSRSBH}"></li>
				<%-- <li><label style="width: 60px">纳税人名称</label><input type="text"
					name="NSRMC" id="NSRMC" class="scinput1" placeholder="请输入纳税人名称"
					value="${NSRMC}"></li> --%>
				<li><label style="width: 50px">税务机关</label> <input
					type="hidden" name="SWJGBM" id="swjgbm" class="scinput1" readonly
					value="${SWJGBM}"> <input type="text" name="parentName"
						id="parentName" class="scinput1" readonly
						onclick="selectParentOrganization();" value="${parentName}">
							<input name="" type="button" class="scbtn" value="选择"
							onclick="selectParentOrganization();" /></li>

			</ul>
			<div style="align: center; margin-bottom: 20px">
				<br />
				<ul class="seachform" style="left: 35%; position: absolute;">
					<li><label>&nbsp;</label><input name="" type="submit"
						id="table_refresh" class="scbtn1" value="查询" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn2" onclick="deleteInput();" value="清空" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						id="table_add" class="scbtn" value="新增" /></li>

				</ul>
				<br />
			</div>
		</form>
		<br />
		<div class="formtitle1">
			<span>纳税户基本信息</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>
					<th>纳税人微机编码</th>
					<th>纳税人识别号</th>
					<th>纳税人名称</th>
					<th>税务机关编码</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="item">

					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>

						<td>${ item.nsrwjbm}</td>

						<td>${ item.nsrsbh}</td>

						<td>${ item.nsrmc}</td>


						<td>${ item.swjgbm}</td>
						<td>${ item.status==1?'正常':'停用'}</td>

						<td><a
							href="${ contextpath }/skqnsrxx/modify.htm?nsrwjbm=${item.nsrwjbm}"
							class="tablelink">纳税人信息维护</a> &nbsp;&nbsp;<a
							href="${ contextpath }/skqjqxx/list.htm?nsrwjbm=${item.nsrwjbm}"
							class="tablelink">机器信息维护</a> &nbsp;&nbsp;<a href="javascript:void(0)"
							class="tablelink" onclick="deleteNsrxx('${item.nsrwjbm}');">删除纳税人信息</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page
			href="${ contextpath}/skqnsrxx/list?NSRWJBM=${NSRWJBM}&NSRSBH=${NSRSBH}&NSRMC=${NSRMC}&SWJGBM=${SWJGBM}&parentName=${parentName }"
			data="pageList" />

	</div>
</body>
</html>

<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	function deleteInput() {
		$("#NSRWJBM").val("");
		$("#NSRSBH").val("");
		$("#NSRMC").val("");
		$("#swjgbm").val("");
		$("#parentName").val("");

	}
	$(document).ready(
			function() {
				table_init("${ contextpath}/skqnsrxx",
						"${ contextpath}/skqnsrxx/list?");
			});
	function selectParentOrganization() {
		layer.open({
			type : 2,
			title : '选择税务机关【点击行选中】',
			shadeClose : false,
			area : [ '580px', '90%' ],

			content : '${contextpath}/securityorganization/select.htm' //iframe的url
		});
	}
	function deleteNsrxx(nsrwjbm){
		layer.confirm('您确认删除微机编码：'+nsrwjbm+'<br/>如若删除，该纳税户相关机器信息也将删除！',function(index){
			//ajax提交删除数据
			jQuery.ajax({
						type: "post", 
						url:"${contextpath}/skqnsrxx/deleteNsrxx.htm", 
						dataType: "json",
						data:{action:'delete',"nsrwjbm":nsrwjbm},
						success: function (data) { 
							if(data.status=='success'){
								layer.alert('当前操作成功', {
									shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqnsrxx/list';
								});
							}else{
								layer.alert(data.message, {
									closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqnsrxx/list';
								});
							}
							
							 
						} 
				});
		});
	}
</script>

