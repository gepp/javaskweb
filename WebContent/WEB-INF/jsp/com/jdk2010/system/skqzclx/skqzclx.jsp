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
<title>注册类型</title>
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
			<li><a href="#">注册类型</a></li>
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
			<span>注册类型</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>
					<th>注册类型编码</th>
					<th>注册类型名称</th>
					<th>注册类型简称</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="item">

					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>

						<td>${ item.zclxbm}</td>

						<td>${ item.zclxmc}</td>

						<td>${ item.zclxjc}</td>

						<td>${ item.status==1?'启用':'停用'}</td>

						<td><a
							href="${ contextpath }/skqzclx/modify.htm?id=${item.id}"
							class="tablelink">编辑</a> <a
							href="${ contextpath }/skqzclx/view.htm?id=${item.id}"
							class="tablelink">查看</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page href="${ contextpath}/skqzclx/list?" data="pageList" />

	</div>
</body>
</html>

<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$(document).ready(function(){
			table_init("${ contextpath}/skqzclx","${ contextpath}/skqzclx/list?");
		});
</script>

