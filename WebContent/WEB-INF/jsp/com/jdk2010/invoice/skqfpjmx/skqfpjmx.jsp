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
<title>发票卷明细</title>
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
 <link rel="stylesheet" type="text/css" href="${ contextpath }/res/js/googlesuggest/autocomplete.css" />	
 <script language="javascript" type="text/javascript" src="${ contextpath }/res/js/My97DatePicker/WdatePicker.js"></script>
 
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">发票领购查询</a></li>
		</ul>
	</div>
	<div class="rightinfo">



		<form method="post" action="${ contextpath}/skqfpjmx/list.htm">
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
				<li><label style="width: 60px">开始时间</label><input type="text"
					name="startTime" id="startTime" class="scinput1"
					placeholder="请输入开始时间" value="${startTime}" onfocus="WdatePicker({isShowWeek:true})"></li>
				<li><label style="width: 60px">截止时间</label><input type="text"
					name="endTime" id="endTime" class="scinput1" placeholder="请输入截止时间"
					 value="${endTime}" onfocus="WdatePicker({isShowWeek:true})"></li>
						
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
					<li><label>&nbsp;</label><input name="" type="submit"
						class="scbtn1" value="查询" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn2" onclick="deleteInput();" value="清空" /></li>

				</ul>
				<br />
			</div>
		</form>

		<div class="formtitle1">
			<span>发票卷明细</span>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input type="checkbox" width="15px" id="checkAll" /></th>

					<th>纳税人识别号</th>
					<th>纳税人名称</th>
					<th>发票编码</th>
					<th>发票代码</th>
					<th>发票号码起止</th>
					<th>发票单位</th>
					<th>机器编号</th>
					<th>发票领购日期</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="item">

					<tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>

						<td>${ item.nsrsbh}</td>

						<td>${ item.nsrmc}</td>
						
						<td>${ item.fpbm}</td>

						<td>${ item.fpdm}</td>

						<td>${ item.fpqsh}-${ item.fpjzh}</td>


						<td>${ item.fpdw}</td>

						<td>${ item.jqbh}</td>


						<td>${ item.fplgrq}</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page
			href="${ contextpath}/skqfpjmx/list.htm?NSRSBH=${NSRSBH }&JQBH=${JQBH }&startTime=${startTime }&endTime=${endTime }&SWJGBM=${SWJGBM }&parentName=${parentName }"
			data="pageList" />

	</div>
</body>
</html>

<script type="text/javascript">
		
jQuery(document).ready(function() {
	jQuery('.tablelist tbody tr:odd').addClass('odd');
	 
});

		
	
	function selectParentOrganization() {
		layer.open({
			type : 2,
			title : '选择税务机关【点击行选中】',
			shadeClose : false,
			area : [ '580px', '90%' ],

			content : '${contextpath}/securityorganization/select.htm' //iframe的url
		});
	}
 
	
	function deleteInput(){
		jQuery("#NSRSBH").val("");
		jQuery("#JQBH").val("");
		jQuery("#startTime").val("");
		jQuery("#endTime").val("");
		jQuery("#swjgbm").val("");
		jQuery("#parentName").val("");
		
	}
</script>

