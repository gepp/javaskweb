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
		 <div class="formtitle1">
						<span>机器基本信息</span>
					</div>
					<table class="tableEdit">
						<tr>
							<th>机器编号<b></b></th>
							<td>${jqxx.jqbh }</td>
							<th>机器型号编码<b></b></th>
							<td>${jqxx.jqxhbm }</td>
						</tr>

						<tr>
							<th>税控卡号<b></b></th>
							<td>${jqxx.skkh }</td>
							<th>用户卡号<b></b></th>
							<td>${jqxx.yhkh }</td>
						</tr>

						<tr>
							<th>卡启用日期<b></b></th>
							<td>${jqxx.kqyrq }</td>
							<th>卡有效日期<b></b></th>
							<td>${jqxx.kyxrq }</td>

						</tr>
						<tr>

							<th>申报方式<b></b></th>
							<td>${jqxx.sbfs }</td>
							<th>明细申报标志<b></b></th>
							<td>${jqxx.mxsbbz }</td>
						</tr>
						<tr>
							<th>开票截止日期<b></b></th>
							<td>${jqxx.kpjzrq }</td>
							<th>单张开票限额<b></b></th>
						  <fmt:formatNumber value="${jqxx.dzkpxe}" type="currency" pattern="#0.00" var="dzkpxe"/>
							<td>${dzkpxe }</td>
						</tr>

						<tr>
							<th>月累计开票限额<b></b></th>
						    <fmt:formatNumber value="${jqxx.yljkpxe}" type="currency" pattern="#0.00" var="yljkpxe"/>
							<td>${yljkpxe }</td>
							<th>月累计退票限额<b></b></th>
						    <fmt:formatNumber value="${jqxx.yljtpxe}" type="currency" pattern="#0.00" var="yljtpxe"/>
							<td>${yljtpxe }</td>
						</tr>
						<tr>
							<th>状态<b></b></th>
							<td>${ jqxx.status==1?'正常':'注销'}</td>
							<th>&nbsp;<b></b></th>
							<td>&nbsp;</td>
						</tr>

					</table>
					<br />
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

						<tbody id="nsrszsmDiv">
							<c:forEach var="item" items="${jqxx.jqszsmList }">
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


