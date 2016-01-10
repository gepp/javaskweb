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
<title>发票开具查询</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/googlesuggest/prototype.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/googlesuggest/autocomplete.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/googlesuggest/so.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ contextpath }/res/js/googlesuggest/autocomplete.css" />
 <script language="javascript" type="text/javascript" src="${ contextpath }/res/js/My97DatePicker/WdatePicker.js"></script>
<style type="text/css" mce_bogus="1">
table {
	empty-cells: show;
	border-collapse: collapse;
	margin: 0 auto;
}
table th {
	white-space: nowrap;
}
table td {
	white-space: nowrap;padding-right:2px
}
</style> 
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">发票开具</a></li>
		</ul>
	</div>
	<div class="rightinfo">



		<form method="post" action="${ contextpath}/skqfpkj/list.htm">
			<ul class="seachform" style="padding-top: 10px; padding-left: 15px">
				<li><label style="width: 80px">纳税人识别号</label><input type="text"
					name="NSRSBH" id="NSRSBH" class="scinput1" placeholder="请输入纳税人识别号"
					value="${NSRSBH}" maxlength="22"> <script
							type="text/javascript">
						new CAPXOUS.AutoComplete("NSRSBH", function() {
							if (this.text.value.length >= 3) {
								return "${ contextpath}/skqbdc/hqmc?keyword="
										+ this.text.value;
							}
						});
					</script></li>
				<li><label style="width: 60px">纳税人名称</label><input type="text"
					name="NSRMC" id="NSRMC" class="scinput1" placeholder="请输入纳税人名称"
					value="${NSRMC}"></li>
				<li><label style="width: 50px">税务机关</label> <input
					type="hidden" name="SWJGBM" id="swjgbm" class="scinput1" readonly
					value="${SWJGBM}"> <input type="text" name="parentName"
						style="width: 350px" id="parentName" class="scinput1" readonly
						onclick="selectParentOrganization();" value="${parentName}">
							<input name="" type="button" class="scbtn" value="选择"
							onclick="selectParentOrganization();" /></li>

			</ul>
			<ul class="seachform" style="padding-top: 10px; padding-left: 15px">
			<li><label style="width: 60px">开始时间</label><input type="text"
					name="startTime" id="startTime" class="scinput1"
					placeholder="请输入开始时间" value="${startTime}" onfocus="WdatePicker({isShowWeek:true})"></li>
				<li><label style="width: 60px">截止时间</label><input type="text"
					name="endTime" id="endTime" class="scinput1" placeholder="请输入截止时间"
					 value="${endTime}" onfocus="WdatePicker({isShowWeek:true})"></li>
			
			</ul>
			<div style="align: center; margin-bottom: 20px">
				<br />
				<ul class="seachform" style="left: 35%; position: absolute;">
					<li><label>&nbsp;</label><input name="" type="submit"
						id="table_refresh" class="scbtn1" value="查询" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn2" onclick="deleteInput();" value="清空" /></li>
					<li><label>&nbsp;</label><input name="" type="button"
						class="scbtn3" onclick="download();" value="excel下载" /></li>


				</ul>
				<br />
			</div>
		</form>

		<div class="formtitle1">
			<span>发票开具</span>
		</div>
		<div style="width:100%; overflow-x:auto;">
		<table class="tablelist">
			<thead>
				<tr>
  					<th>纳税人识别号</th>
 					<th>纳税人名称</th>
					<th>机器编号</th>
					<th>开票日期</th>
					<th>开票类型</th>
					<th>发票代码</th>
					<th>发票号码</th>
					<th>开票金额</th>
					<th>原发票号码</th>
					<th>付款单位</th>
 				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="item">

					<tr>
 						<td>${ item.nsrsbh}</td>
						<td>${ item.nsrmc}</td>
						<td>${ item.jqbh}</td>
						<fmt:formatDate value="${item.kprq }" var="kprq" pattern="yyyy-MM-dd"/>
						<td>${kprq}</td>

						<td>${ item.kplx=='1'?'正常票':(item.kplx=='2'?'退票':'废票')}</td>

						<td>${ item.fpdm}</td>

						<td>${ item.fphm}</td>

						<td>${ item.hjzje}</td>

						<td>${ item.yfphm}</td>

						<td>${ item.fkdw}</td>
 						 
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<page:page href="${ contextpath}/skqfpkj/list.htm?NSRSBH=${NSRSBH }&startTime=${startTime }&endTime=${endTime }&SWJGBM=${SWJGBM }&parentName=${parentName }&NSRMC=${NSRMC }" data="pageList" />
	
	</div>
</body>
</html>

<script type="text/javascript">
jQuery('.tablelist tbody tr:odd').addClass('odd');
function deleteInput() {
	jQuery("#NSRWJBM").val("");
	jQuery("#NSRSBH").val("");
	jQuery("#NSRMC").val("");
	jQuery("#swjgbm").val("");
	jQuery("#parentName").val("");
	jQuery("#startTime").val("");
	jQuery("#endTime").val("");

}

function selectParentOrganization() {
	layer.open({
		type : 2,
		title : '选择税务机关【点击行选中】',
		shadeClose : true,
		area : [ '580px', '90%' ],

		content : '${contextpath}/securityorganization/select.htm' //iframe的url
	});
}

  function download(){
	  var NSRSBH=jQuery("#NSRSBH").val();
	  var SWJGBM=jQuery("#swjgbm").val();
	  if(NSRSBH==''){
		  alert('请填写纳税人识别号');
		  return false;
	  }
	  
 	  var startTime=jQuery("#startTime").val();
	  var endTime=jQuery("#endTime").val();
	  if(startTime==''){
		  alert('请填写起始时间');
		  return false;
	  }
	  
	  if(endTime==''){
		  alert('请填写截止');
		  return false;
	  }
	  
        var url="${contextpath}/skqfpkj/exportExcel.htm?NSRSBH="+NSRSBH+"&SWJGBM="+SWJGBM+"&startTime="+startTime+"&endTime="+endTime;
	        window.location.href=url;
    }
</script>

