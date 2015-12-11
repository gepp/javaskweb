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
<title>机器信息</title>
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
			<li><a href="#">【${nsrwjbm }】机器信息列表</a></li>
		</ul>
	</div>
	<div class="rightinfo">

		<input type="hidden" value="${nsrwjbm }" name="nsrwjbm" id="nsrwjbm" />

		<div class="tools">
			<ul class="toolbar">
				<li onclick="add();"><span><img src="${contextpath }/res/images/t01.png" /></span>添加</li>
				<li><span><img src="${contextpath }/res/images/t03.png" /></span>删除</li>
				<li onclick="window.location='${ contextpath}/skqnsrxx/list.htm'"><span></span>返回纳税人列表</li>
			</ul>
		</div>

		<div class="formtitle1">
			<span>机器信息</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>
					<th>纳税人微机编码</th>
					<th>纳税人名称</th>
					<th>机器型号</th>
					<th>机器编号</th>
					<th>税控卡号</th>
					<th>用户卡号</th>
					<th>开票截止日期</th>
					<th>月累计开票限额</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">

					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>

						<td>${ item.nsrwjbm}</td>
						<td>${ item.nsrmc}</td>
						<td>${ item.jqxhmc}</td>
						<td>${ item.jqbh}</td>
						<td>${ item.skkh}</td>
						<td>${ item.yhkh}</td>
						<td>${ item.kpjzrq}</td>
						<td>${ item.yljkpxe}</td>
						<td>${ item.status==1?'启用':'停用'}</td>
						<td><a
							href="${ contextpath }/skqjqxx/modify.htm?id=${item.id}"
							class="tablelink">编辑</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
 
	</div>
</body>
</html>

<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	$(document).ready(
			function() {
				table_init("${ contextpath}/skqhymx",
						"${ contextpath}/skqhymx/list?hyId=${skqHy.id}");
			});
	function add() {
		window.location.href = "${ contextpath}/skqjqxx/add.htm?nsrwjbm=${nsrwjbm}";
	}
</script>

