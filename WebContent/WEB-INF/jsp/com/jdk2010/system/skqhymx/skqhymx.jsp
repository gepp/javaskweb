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
<title>行业明细</title>
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
			<li><a href="#">【${skqHy.hymc }】行业明细</a></li>
		</ul>
	</div>
	<div class="rightinfo">



		<div class="tools">
			<ul class="toolbar">
				<li onclick="add();"><span><img
						src="${contextpath }/res/images/t01.png" /></span>添加</li>
				<li id="table_delete"><span><img
						src="${contextpath }/res/images/t03.png" /></span>删除</li>
				<li onclick="window.location='${ contextpath}/skqhy/list.htm'"><span></span>返回行业</li>
			</ul>
		</div>

		<div class="formtitle1">
			<span>行业明细</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>
					<th>行业编码</th>
					<th>行业明细编码</th>
					<th>行业明细名称</th>
					<th>行业明细简称</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${mapList}" var="item">

					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>

						<td>${ item.hybm}</td>

						<td>${ item.hymxbm}</td>

						<td>${ item.hymxmc}</td>

						<td>${ item.hymxjc}</td>

						<td>${ item.status==1?'启用':'停用'}</td>

						<td><a
							href="${ contextpath }/skqhymx/modify.htm?id=${item.id}"
							class="tablelink">编辑</a>
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
		window.location.href = "${ contextpath}/skqhymx/add.htm?hyId=${skqHy.id}";
	}
</script>

