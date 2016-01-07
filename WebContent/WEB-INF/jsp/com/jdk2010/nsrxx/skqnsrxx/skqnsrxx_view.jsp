<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>纳税人信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript"
	src="${ contextpath }/res/js/jquery.idTabs.min.js"></script>
<link rel="stylesheet"
	href="${ contextpath }/res/js/validator-0.7.3/jquery.validator.css">
	<script type="text/javascript"
		src="${ contextpath }/res/js/validator-0.7.3/jquery.validator.js"></script>
	<script type="text/javascript"
		src="${ contextpath }/res/js/validator-0.7.3/local/zh_CN.js"></script>
	<link href="${ contextpath }/res/css/select.css" rel="stylesheet"
		type="text/css" />
	<script type="text/javascript"
		src="${ contextpath }/res/js/select-ui.min.js"></script>
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
			<li><a href="#">纳税人信息</a></li>
		</ul>
	</div>
	<div class="formbody">
		<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">纳税人基本信息</a></li>
					<li><a href="#tab2">机器基本信息</a></li>
					<li><a href="#tab3">发票领购信息</a></li>
				</ul>
			</div>
			<div id="tab1" class="tabson">

				<div class="formtitle1">
					<span>纳税人基本信息</span>
				</div>


				<table class="tableEdit">
					<tr>
						<th>纳税人微机编码<b></b></th>
						<td>${skqNsrxx.nsrwjbm }</td>
						<th>纳税人识别号<b></b></th>
						<td>${skqNsrxx.nsrsbh }</td>
					</tr>

					<tr>
						<th>纳税人名称<b></b></th>
						<td>${skqNsrxx.nsrmc }</td>
						<th>经营地址<b></b></th>
						<td>${skqNsrxx.jydz }</td>
					</tr>

					<tr>
						<th>法人代表<b></b></th>
						<td>${skqNsrxx.frdb }</td>
						<th>联系方式<b></b></th>
						<td>${skqNsrxx.ssgly }</td>

					</tr>
					<tr>

						<th>办税员<b></b></th>
						<td>${skqNsrxx.bsy }</td>
						<th>月核定营业额<b></b></th>
						<td>${skqNsrxx.yhde }</td>
					</tr>
					<tr>
						<th>行业编码<b></b></th>
						<td>${skqNsrxx.hymc }(${skqNsrxx.hybm })</td>
						<th>行业明细编码<b></b></th>
						<td>${skqNsrxx.hymxmc }(${skqNsrxx.hymxbm })</td>
					</tr>

					<tr>
						<th>税务机关编码<b></b></th>
						<td>${skqNsrxx.swjgmc }(${swjgbm})</td>
						<th>注册类型编码<b></b></th>
						<td>${skqNsrxx.zclxmc }(${skqNsrxx.zclxbm })</td>
					</tr>
					<tr>
						<th>征收方式<b></b></th>
						<td>${ skqNsrxx.zsfs==1?'查账征收':'核定户'}</td>
						<th>状态<b></b></th>
						<td>${ skqNsrxx.status==1?'启用':'停用'}</td>
					</tr>

				</table>
				<br />
				<div class="formtitle1">
					<span>纳税户税种税目</span>
				</div>

				<table class="tablelist">
					<thead>
						<tr>
							<th>税种编码</th>
							<th>税目编码</th>
							<th>税目名称</th>
							<th>税目简称</th>
							<th>税率</th>
						</tr>
					</thead>

					<tbody id="nsrszsmDiv">
						<c:forEach var="item" items="${nsrszsmList }">
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

			<div id="tab2" class="tabson">
				<c:forEach var="jqxx" items="${skqNsrxx.jqxxList }">
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
							<td>${jqxx.dzkpxe }</td>
						</tr>

						<tr>
							<th>月累计开票限额<b></b></th>
							<td>${jqxx.yljkpxe }</td>
							<th>月累计退票限额<b></b></th>
							<td>${jqxx.yljtpxe }</td>
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
				</c:forEach>
			</div>
			<div id="tab3" class="tabson">
				<div class="formtitle1">
					<span>发票领购信息</span>
				</div>

				<table class="tablelist">
					<thead>
						<tr>
							<th width="15%">领票日期</th>
							<th width="30%">发票名称</th>
							<th width="10%">发票单位</th>
							<th width="10%">机器编号</th>
							<th>发票号码起止</th>
							<th width="10%">下发状态</th>
						</tr>
					</thead>
					<tbody id="nsrszsmDiv">
						<c:forEach var="item" items="${alFpjmx }">
							<tr>
								<td>${item.fplgrq }</td>
								<td>${item.fpmc }</td>
								<td>${item.fpdw }</td>
								<td>${item.jqbh }</td>
								<td>${item.fpqsh }-${item.fpjzh }</td>
								<td>
								<c:if test="${item.fpxfzt==0 }">
									未下发
								</c:if>
								<c:if test="${item.fpxfzt==1}">
									已下发
								</c:if>
								
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
		<br /> <br />
		<div style="left: 25%;">
			<ul class="forminfo">
				<li>&nbsp;&nbsp; <input name="" type="button" class="btn"
					value="返回"
					onclick="window.location='${ contextpath}/skqnsrxx/listcxtj'" />
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
    $("#usual1 ul").idTabs(); 
</script>



