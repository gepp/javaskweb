<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>机器信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<style type="text/css">
.forminfo li label {
	width: 128px
}

.forminfo tr {
	height: 45px
}
</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">机器信息</a></li>
		</ul>
	</div>
	<div class="formbody">
		<div id="usual1" class="usual">
			<div class="formtitle1">
				<span>机器信息</span>
			</div>
			<div id="tab1" class="tabson">
				<ul class="forminfo">
					<form action="" method="POST" id="skqJqxxForm">
						<table width="100%">
							<tr>
								<th style="width: 10%">纳税人微机编码</th>
								<td style="width:18%">${skqJqxx.nsrwjbm}</td>
								<th style="width: 10%">机器型号编码</th>
								<td>${ skqJqxx.jqxhbm}</td>
								<th style="width: 10%">机器编号</th>
								<td>${ skqJqxx.jqbh}</td>
							</tr>
							<tr>
								<th style="width: 10%">税控卡号</th>
								<td>${ skqJqxx.skkh}</td>
								<th style="width: 10%">用户卡号</th>
								<td>${ skqJqxx.yhkh}</td>
								<th style="width: 10%">卡启用日期</th>
								<td><fmt:formatDate value="${skqJqxx.kqyrq }"   pattern="yyyy-MM-dd"/></td>
							</tr>
							<tr>
								<th style="width: 10%">卡有效日期</th>
								<td><fmt:formatDate value="${skqJqxx.kyxrq }"   pattern="yyyy-MM-dd"/></td>
								<th style="width: 10%">申报方式</th>
								<td>${ skqJqxx.sbfs}</td>
								<th style="width: 10%">明细申报标志</th>
								<td>${ skqJqxx.mxsbbz}</td>
							</tr>
							<tr>
								<th style="width: 10%">开票截止日期</th>
								<td><fmt:formatDate value="${skqJqxx.kpjzrq }"   pattern="yyyy-MM-dd"/></td>
								<th style="width: 10%">单张开票限额</th>
								<td>${ skqJqxx.dzkpxe}</td>
								<th style="width: 10%">月累计开票限额</th>
								<td>${ skqJqxx.yljkpxe}</td>
							</tr>
							<tr>
								<th style="width: 10%">月累计退票限额</th>
								<td>${ skqJqxx.yljtpxe}</td>
								<th style="width: 10%">状态</th>
								<td>${ skqJqxx.status==1?'启用':'停用'}</td>
								<th style="width: 10%">&nbsp;</th>
								<td>&nbsp;</td>
							</tr>

						</table>

					</form>
				</ul>
			</div>
			<div class="formtitle1">
		<span>机器税种税目</span>
	</div>
	<table class="tablelist">
		<thead>
			<tr>
				<th>税种编码</th>
				<th>税目编码</th>
				<th>税目名称</th>
				<th>经营项目内容</th>
				<th>税率</th>
			</tr>
		</thead>
		<input type="hidden" id="smbms" name="smbms" value="${smbms }" />
		<input type="hidden" id="hiddenStr" name="hiddenStr"
			value="${hiddenStr }" />
		<tbody id="nsrszsmDiv">
			<c:forEach var="item" items="${jqszsmList }">
				<tr>
					<td>${item.szbm }</td>
					<td>${item.smbm }</td>
					<td>${item.smmc }</td>
					<td>${item.smjc }</td>
					<td>${item.sl }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		</div>
	</div>
	<br />
	
	<br />
	<br />
	<ul>
		<li><label>&nbsp;</label> <input name="" type="button"
			class="btn" value="返回"
			onclick="window.location='${ contextpath}/skqjqxx/listcxtj.htm'" /></li>
	</ul>
	<br />
	<br />
</body>
</html>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
</script>


