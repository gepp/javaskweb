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
<title>查看详细</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>

</head>
<body style="min-width:300px">

	 
	<div class="rightinfo">
		<div class="formtitle1">
			<span>申报数据明细信息</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					 <th width="*">税目编码</th>
			        <th width="40%">税目名称</th>
			        <th width="20%">开票金额</th>
			        <th width="20%">开票类型</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${detailList}" var="item">
					<tr >
						<td>${ item.smbm}</td>
						<td>${ item.smmc}</td>
						<td>${ item.je}</td>
						<td>${ item.kplx==1?'正常票金额':'退票金额'}</td>
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
				table_init("${ contextpath}/securityorganization",
						"${ contextpath}/securityorganization/list?");
			});
	
	function jumpToParent(id,name,code){

		parent.$('#parentId').val(id);
		parent.$("#swjgbm").val(code);
		parent.$('#parentName').val($.trim(name));
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}
</script>

