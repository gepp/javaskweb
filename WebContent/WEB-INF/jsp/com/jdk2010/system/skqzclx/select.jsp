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
<title>注册类型选择</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/layer/layer.js"></script>

</head>
<body style="min-width: 300px">


	<div class="rightinfo">
		<div class="formtitle1">
			<span>行业</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th>编码</th>
					<th>名称</th>
					<th>注简称</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
				
					<tr  onclick="jumpToParent('${item.zclxbm}','${item.zclxmc }')">
					
						<td>${ item.zclxbm}</td>

						<td>${ item.zclxmc}</td>

						<td>${ item.zclxjc}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		 
		 
	</div>
</body>
</html>

<script type="text/javascript">
$('.tablelist tbody tr:odd').addClass('odd');
 
    function jumpToParent(zclxbm,zclxmc){
		parent.$('#zclxbm').val(zclxbm);
		parent.$("#zclxmc").val(zclxmc);
 		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}
	function closeWindow() {
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}
</script>

