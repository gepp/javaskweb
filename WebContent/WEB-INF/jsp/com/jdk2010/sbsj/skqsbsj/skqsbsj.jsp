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
<title>申报数据</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/laydate/laydate.js"></script>
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">申报数据</a></li>
		</ul>
	</div>
	<div class="rightinfo">



		<form method="post" action="${ contextpath}/skqsbsj/list.htm">
			<ul class="seachform" style="padding-top: 10px; padding-left: 15px">
				<li><label style="width: 85px">纳税人微机编码</label><input
					type="text" name="NSRWJBM" id="NSRWJBM" class="scinput1"
					placeholder="请输入纳税人微机编码" value="${NSRWJBM}"></li>
				<li><label style="width: 80px">机器编号</label><input type="text"
					name="JQBH" id="JQBH" class="scinput1" placeholder="请输入机器编号"
					value="${JQBH}"></li>
				<li><label style="width: 60px">开始时间</label><input type="text"
					name="startTime" id="startTime" class="scinput1"
					placeholder="请输入开始时间" value="${startTime}" onclick="laydate()"></li>
				<li><label style="width: 60px">截止时间</label><input type="text"
					name="endTime" id="endTime" class="scinput1" placeholder="请输入截止时间"
					onclick="laydate()" value="${endTime}"></li>
				</ul>
				<ul class="seachform" style="padding-top: 10px; padding-left: 15px">
				<li><label style="width: 85px">税务机关</label> <input
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
						class="scbtn1" value="查询" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn2" onclick="deleteInput();" value="清空" /></li>

				</ul>
				<br />
			</div>
		</form>


		<div class="formtitle1">
			<span>申报数据</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>
					<th>纳税人微机编码</th>
					<th>纳税人名称</th>
					<th>机器编号</th>
					<th>开始时间</th>
					<th>截止时间</th>
					<th>正常票份数</th>
					<th>退票份数</th>
					<th>废票份数</th>
					<th>正常票总金额</th>
					<th>退票总金额</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="item">

					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>

						<td>${ item.nsrwjbm}</td>

						<td>${ item.nsrmc}</td>

						<td>${ item.jqbh}</td>


						<td>${ item.sskssj}</td>

						<td>${ item.ssjzsj}</td>

						<td>${ item.zcpfs}</td>

						<td>${ item.tpfs}</td>

						<td>${ item.fpfs}</td>

						<td>${ item.zcpzje}</td>

						<td>${ item.tpzje}</td>

						<td><a href="${ contextpath }/skqsbsj/view.htm?id=${item.id}"
							class="tablelink">查看</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page
			href="${ contextpath}/skqsbsj/list?NSRWJBM=${NSRWJBM }&JQBH=${JQBH }&YHKH=${YHKH }&SKKH=${SKKH }&SWJGBM=${SWJGBM }&parentName=${parentName }"
			data="pageList" />

	</div>
</body>
</html>

<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	$(document).ready(function() {
		table_init("${ contextpath}/skqsbsj", "${ contextpath}/skqsbsj/list?");
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
	function deleteInput(){
		$("#NSRWJBM").val("");
		$("#JQBH").val("");
		$("#startTime").val("");
		$("#endTime").val("");
		$("#swjgbm").val("");
		$("#parentName").val("");
		
	}
</script>

