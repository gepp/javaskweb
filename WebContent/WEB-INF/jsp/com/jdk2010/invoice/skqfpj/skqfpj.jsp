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
<title>发票卷信息</title>
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
			<li><a href="#">发票卷信息</a></li>
		</ul>
	</div>
	<div class="rightinfo">



		 

		<div class="formtitle1">
			<span>发票领购信息</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>
					<th>纳税人微机编码</th>
					<th>纳税人名称</th>
					<th>发票领购日期</th>
					<th>发票名称</th>
					<th>发票编码</th>
					<th>发票号码起止</th>
					<th>发票单位</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="item">

					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>
						<td>${ item.id}</td>

						<td>${ item.fpbm}</td>

						<td>${ item.fpdm}</td>

						<td>${ item.fpqsh}</td>

						<td>${ item.fpjzh}</td>

						<td>${ item.fpdw}</td>

						<td>${ item.nsrwjbm}</td>

						<td>${ item.fplgrq}</td>

						<td><a
							href="${ contextpath }/skqfpj/modify.htm?id=${item.id}"
							class="tablelink">编辑</a> <a
							href="${ contextpath }/skqfpj/view.htm?id=${item.id}"
							class="tablelink">查看</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page href="${ contextpath}/skqfpj/list?" data="pageList" />

	</div>
</body>
</html>

<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$(document).ready(function(){
			table_init("${ contextpath}/skqfpj","${ contextpath}/skqfpj/list?");
		});
</script>

