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
<title>菜单管理</title>
<link href="${contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
	<link href="${contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${contextpath }/res/js/common.js"></script>
<script type="text/javascript" src="${contextpath }/res/js/layer/layer.js"></script>

</head>
<body>

	<div class="place" style="">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">菜单管理</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		 

		<div class="formtitle1">
			<span>菜单管理</span>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" id="checkAll" /></th>
					<th>菜单名称</th>
					<th>菜单编码</th>
					<th>排序号</th>
					<th>跳转链接</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${menuList}" varStatus="idx">
					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>
						<td>${item.name }</td>
						<td>${item.code }</td>
						<td>${item.orderlist }</td>
						<td>${item.url }</td>
						<td>${item.status==0?'停用':'启用' }</td>
						<td><a href="${contextpath }/securitymenu/modify.htm?id=${item.id}"
							class="tablelink">编辑</a> <a
							href="${contextpath }/securitymenu/view.htm?id=${item.id}"
							class="tablelink">查看</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

 
 
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$(document).ready(function(){
			table_init("${contextpath}/securitymenu","${contextpath}/securitymenu/list?");
		});
	</script>

</body>

</html>
