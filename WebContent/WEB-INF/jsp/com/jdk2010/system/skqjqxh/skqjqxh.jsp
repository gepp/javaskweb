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
<title>机器型号</title>
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
			<li><a href="#">机器型号</a></li>
		</ul>
	</div>
	<div class="rightinfo">



		<ul class="seachform1">
			<li class="sarchbtn"><label>&nbsp;</label> <input name=""
				type="button" class="scbtn1" value="新增 " id="table_add" /> <input
				name="" type="submit" class="scbtn" value="查询" id="table_refresh" />
				<input name="" type="button" class="scbtn2" value="批量删除"
				id="table_delete" /></li>
		</ul>

		<div class="formtitle1">
			<span>机器型号</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>

					<th>机器型号编码</th>
					<th>机器型号名称</th>
					<th>生产厂商</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="item">

					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>

						<td>${ item.jqxhbm}</td>

						<td>${ item.jqxhmc}</td>

						<td>${ item.sccs}</td>

						<td>${ item.status==1?'启用':'停用'}</td>

						<td><a
							href="${ contextpath }/skqjqxh/modify.htm?id=${item.id}"
							class="tablelink">编辑</a> <a
							href="${ contextpath }/skqjqxh/view.htm?id=${item.id}"
							class="tablelink">查看</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page href="${ contextpath}/skqjqxh/list?" data="pageList" />

	</div>
</body>
</html>

<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	$(document).ready(function() {
		table_init("${ contextpath}/skqjqxh", "${ contextpath}/skqjqxh/list?");
	});
</script>

