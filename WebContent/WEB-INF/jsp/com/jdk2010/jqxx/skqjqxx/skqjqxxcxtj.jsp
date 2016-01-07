
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
<title>机器信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/googlesuggest/prototype.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/googlesuggest/autocomplete.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/googlesuggest/so.js"></script>
<link rel="stylesheet" type="text/css" href="${ contextpath }/res/js/googlesuggest/autocomplete.css" />	

</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">机器信息</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<form method="post" action="${ contextpath}/skqjqxx/listcxtj.htm">
			<ul class="seachform" style="padding-top: 10px; padding-left: 15px">
				<li><label style="width: 80px">纳税人识别号</label><input type="text"
					name="NSRSBH" id="NSRSBH" class="scinput1" placeholder="请输入纳税人识别号"
					value="${NSRSBH}">
				 <script type="text/javascript">
					new CAPXOUS.AutoComplete("NSRSBH", function() {
						if(this.text.value.length>=3){
			        		return "${ contextpath}/skqbdc/hqmc?keyword=" + this.text.value;
						}
			    	});
				
			</script>
					
					</li>
				<li><label style="width: 80px">机器编号</label><input type="text"
					name="JQBH" id="JQBH" class="scinput1" placeholder="请输入机器编号"
					value="${JQBH}"></li>
				<li><label style="width: 60px">税控卡号</label><input type="text"
					name="SKKH" id="SKKH" class="scinput1" placeholder="请输入税控卡号"
					value="${SKKH}"></li>
				<li><label style="width: 60px">用户卡号</label><input type="text"
					name="YHKH" id="YHKH" class="scinput1" placeholder="请输入用户卡号"
					value="${YHKH}"></li>
				
			</ul>
			<ul class="seachform" style="padding-top: 10px; padding-left: 15px">
			<li><label style="width: 85px">税务机关</label> <input
					type="hidden" name="SWJGBM" id="swjgbm" class="scinput1" readonly
					value="${SWJGBM}"> <input type="text" name="parentName"
						id="parentName" class="scinput1" readonly style="width:350px"
						onclick="selectParentOrganization();" value="${parentName}">
							<input name="" type="button" class="scbtn" value="选择"
							onclick="selectParentOrganization();" /></li>
			</ul>
			 
			<div style="align: center; margin-bottom: 20px">
				<br />
				<ul class="seachform" style="left: 35%; position: absolute;">
					<li><input name="" type="submit" id="table_refresh"
						class="scbtn1" value="查询" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn2" onclick="deleteInput();" value="清空" /></li>
					</li>

				</ul>
				<br />
			</div>
		</form>




		<div class="formtitle1">
			<span>机器信息</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>

					<th>纳税人识别号</th>
					<th>纳税人名称</th>
					<th>机器型号编码</th>
					<th>机器编号</th>
					<th>税控卡号</th>
					<th>用户卡号</th>
					<th>卡启用日期</th>
					<th>卡有效日期</th>
					<th>开票截止日期</th>
					<th>单张开票限额</th>
					<th>月累计开票限额</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="item">

					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>

						<td>${ item.nsrsbh}</td>
						<td>${ item.nsrmc}</td>
						
						<td>${ item.jqxhbm}</td>

						<td>${ item.jqbh}</td>

						<td>${ item.skkh}</td>

						<td>${ item.yhkh}</td>

						<td><fmt:formatDate value="${item.kqyrq }"
								pattern="yyyy-MM-dd" /></td>

						<td><fmt:formatDate value="${item.kyxrq }"
								pattern="yyyy-MM-dd" /></td>


						<td><fmt:formatDate value="${item.kpjzrq }"
								pattern="yyyy-MM-dd" /></td>

						<td>${ item.dzkpxe}</td>

						<td>${ item.yljkpxe}</td>


						<td>${ item.status==1?'启用':'停用'}</td>

						<td><a
							href="${ contextpath }/skqjqxx/view.htm?jqbh=${item.jqbh}"
							class="tablelink">查看</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page
			href="${ contextpath}/skqjqxx/listcxtj.htm?NSRWJBM=${NSRWJBM }&JQBH=${JQBH }&YHKH=${YHKH }&SKKH=${SKKH }&SWJGBM=${SWJGBM }&parentName=${parentName }"
			data="pageList" />

	</div>
</body>
</html>

<script type="text/javascript">
	function deleteInput() {
		jQuery("#NSRSBH").val("");
 		jQuery("#JQBH").val("");
		jQuery("#YHKH").val("");
		jQuery("#SKKH").val("");
	}
	function selectParentOrganization() {
		layer.open({
			type : 2,
			title : '选择税务机关【点击行选中】',
			shadeClose : false,
			area : [ '580px', '90%' ],
			content : '${contextpath}/securityorganization/select.htm' //iframe的url
		});
	}
	$('.tablelist tbody tr:odd').addClass('odd');
	$(document).ready(
			function() {
				table_init("${ contextpath}/skqjqxx",
						"${ contextpath}/skqjqxx/listcxtj?");
			});
</script>

