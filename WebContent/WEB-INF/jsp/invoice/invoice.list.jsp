<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
<style type="text/css">
.forminfo li label {
	width: 128px
}
</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">发票购买</a></li>
		</ul>
	</div>
	<div class="formtitle1">
		<span>纳税户基本信息</span>
	</div>
	<table class="tableEdit">
		<thead>
			<tr>
				<th>纳税人识别号</th>
				<td>${nsrxx.nsrsbh }</td>
				<th>税务机关名称</th>
				<td>${nsrxx.swjgmc }</td>
			</tr>
			<tr>
				<th>纳税人名称</th>
				<td>${nsrxx.nsrmc }</td>
				<th>经营地址</th>
				<td>${nsrxx.jydz }</td>
			</tr>
			<tr>
				<th>机器编号</th>
				<td>${jqxx.jqbh }</td>
				<th>税控卡号</th>
				<td>${jqxx.skkh }</td>
			</tr>
		</thead>
	</table>
	<div class="formtitle1">
		<span>用户卡已有发票信息</span>
	</div>
	<table class="tablelist">
		<thead>
			<tr>
				<th>发票代码</th>
				<th>发票单位（卷）</th>
				<th>发票号码起止</th>
			</tr>
		</thead>

		<tbody id="nsrszsmDiv">
			<input type="hidden" value="${hasInvoiceSize }" id="num" />
			<c:forEach var="hasInvoice" items="${cardInvoice }">
				<c:if test="${hasInvoice.JS!='0'}">
				<tr>
				<td>${hasInvoice.FPDM }</td>
				<td>${hasInvoice.JS }</td>
				<td>${hasInvoice.QSH }---${hasInvoice.JZH }</td>
				</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<div class="formtitle1">
		<span>税控发票领购情况</span>
	</div>
	<table class="tablelist">
		<thead>
			<tr>
				<th width="10%">&nbsp;</th>
				<th width="15%">领票日期</th>
				<th width="15%">发票代码</th>
				<th width="15%">发票单位（卷）</th>
				<th>发票号码起止</th>
				<th width="12%">操作</th>
			</tr>
		</thead>

		<tbody id="nsrszsmDiv">
			<c:forEach var="noInvoice" items="${alFp }">
				<tr>
					<td><input type="checkbox" name="subBox" value="${noInvoice.fpqsh }~${noInvoice.fpdm}">&nbsp;</td>
					<td>${noInvoice.fplgrq }&nbsp;</td>
					<td>${noInvoice.fpdm }&nbsp;</td>
					<td>${noInvoice.fpdw }&nbsp;</td>
					<td>${noInvoice.fpqsh }&nbsp;---${noInvoice.fpjzh }</td>
					<td><a href="javascript:void(0)" onclick="deleteInvoice('${noInvoice.id}');" class="tablelink">删 除</a> &nbsp;</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<br/>
	<div style="left: 25%;">
		<ul class="forminfo">
			<li><label>&nbsp;</label><input name="" type="button"
				class="btn" value="发票增加" onclick="fplg();"/> &nbsp;&nbsp;
				<input name="" type="button" class="btn" value="发票领购确认"
				onclick="add();" />&nbsp;&nbsp;
				
				 <input name="" type="button" class="btn" value="返 回"
				onclick="window.location='${ contextpath}/skqfpj/toFpgm.htm'" /></li>
		</ul>
	</div>
	<input type="hidden" value="${nsrxx.nsrwjbm }" id="nsrwjbm"/>
	<input type="hidden" value="${jqxx.jqbh }" id="jqbh"/>
</body>
</html>
<script type="text/javascript">

function fplg(){
	var nsrwjbm = document.getElementById('nsrwjbm').value;
	var jqbh = document.getElementById('jqbh').value;
	layer.open({
		type : 2,
		title : '发票增加',
		shadeClose : true,
		area : [ '620px', '90%' ],
		content : '${contextpath}/skqfpj/add.htm?nsrwjbm='+nsrwjbm+'&jqbh='+jqbh
	});
 
}

function deleteInvoice(id){
	if(confirm('您确认删除这条数据么？')){
		//ajax提交删除数据
		jQuery.ajax({
					type: "post", 
					url: "${contextpath}/skqfpjmx/delete.htm", 
					dataType: "json",
					data:{action:'delete',ids:id},
					success: function (data) { 
						if(data.status=='success'){
							alert("删除成功");
							window.location.reload();
						}else{
							alert(data.message);
							window.location.reload();
							 
						}
						
						 
					} 
			});
	}
	 
}

function add(){
	if(confirm("确定选择的发票？")){
		var fpqshInfoStr="" ;
		var count=0;
		var checkbox = $("input[name='subBox']");
		checkbox.each(function() {
			if (this.checked) {
				if(fpqshInfoStr==''){
					fpqshInfoStr=this.value;
				}else{
					fpqshInfoStr=fpqshInfoStr+","+this.value;
				}
				count=count+1;
			}
		});
		if(count==0){
			alert('请选择发票！');
			return false;
		}
		
		else{
			var fpqshArr= new Array(); 
			fpqshArr = fpqshInfoStr.split(",");
			var num1 = fpqshArr.length;
			var num = $("#num").val()*1;
			var allcount = num+num1;
			if(allcount>10){
				alert('不能超过10卷！');
			}
			else{
				var nsrwjbm = $("#nsrwjbm").val();
				var jqbh =$("#jqbh").val();
			//	alert('${contextpath}/skqfpj/fpxk.htm?nsrwjbm='+nsrwjbm+'&jqbh='+jqbh+'&fpqshInfoStr='+fpqshInfoStr);
				window.location.href='${contextpath}/skqfpj/fpxk.htm?nsrwjbm='+nsrwjbm+'&jqbh='+jqbh+'&fpqshInfoStr='+fpqshInfoStr;
			}
		}
	
	}
	 
}




</script>