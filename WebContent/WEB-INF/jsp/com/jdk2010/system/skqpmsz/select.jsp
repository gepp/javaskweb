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
<title>纳税人税种税目选择</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/json2.js"></script>

</head>
<body style="min-width: 300px">


	<div class="rightinfo">
		<div class="formtitle1">
			<span>角色</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>
					<th>税种编码</th>
					<th>税目编码</th>
					<th>税目名称</th>
					<th>税目简称</th>
					<th>税率</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<c:set var="itemPro" value=",${item.smbm }," />
						<td><input type="checkbox" name="subBox" value="${item.smbm}" <c:if test="${fn:contains(smbms,itemPro)}">checked</c:if>
							smValues='{"szbm":"${item.szbm}","smbm":"${item.smbm }","smmc":"${item.smmc }","smjc":"${item.smjc }","sl":"${item.sl }" }' /></td>
						<td>${ item.szbm}</td>
						<td>${ item.smbm}</td>
						<td>${ item.smmc}</td>
						<td>${ item.smjc}</td>
						<td>${ item.sl}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <br /> <br />
		<div style="position: fixed; left:25%;bottom:25px;">
			<input name="" type="submit" class="btn" value=" 确定"
				onclick="jumpToParent();" /> &nbsp;&nbsp; <input name=""
				type="button" class="btn" value="关闭" onclick="closeWindow();" />
		</div>
	</div>
</body>
</html>

<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	$(document).ready(function(){
		table_init("${ contextpath}/skqhy","${ contextpath}/skqhy/list?");
	});
	function jumpToParent() {
		var smbms = "";
		var count = 0;
		var checkbox = $("input[name='subBox']");
		var tdstr = "";
		var hiddenStr="";
		checkbox.each(function() {
			if (this.checked) {
				smbms += this.value + ",";
				count = count + 1;
				var smValues=$(this).attr("smValues");
				hiddenStr=hiddenStr+"~"+smValues;
				var jsonObj=str2json(smValues);
				tdstr=tdstr+"<tr><td>"+jsonObj.szbm+"</td><td>"+jsonObj.smbm+"</td><td>"+jsonObj.smmc+"</td><td>"+jsonObj.smjc+"</td><td>"+jsonObj.sl+"</td></tr>";
			}
		});
		if (count == 0) {
			sAlert('请选择需要绑定的税种税目！');
			return false;
		} else {
			if(smbms.length>0){
				smbms=","+smbms;
			}
			 
			parent.$('#smbms').val(smbms);
			parent.$('#hiddenStr').val(hiddenStr);
			parent.$("#nsrszsmDiv").html(tdstr);
		}
		closeWindow();
	}
	function closeWindow() {
		var index = parent.layer.getFrameIndex(window.name);
		parent.layer.close(index);
	}
</script>

