<%@page import="com.jdk2010.tools.Util"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    HashMap CARDINFO = (HashMap) request.getAttribute("CARDINFO");
	HashMap EF01 = (HashMap) CARDINFO.get("EF01");
	HashMap EF02 = (HashMap) CARDINFO.get("EF02");
	ArrayList EF03 = (ArrayList) CARDINFO.get("EF03");
	HashMap EF04 = (HashMap) CARDINFO.get("EF04");
	System.out.println(EF04);
	ArrayList EF05 = (ArrayList) CARDINFO.get("EF05");
	HashMap EF06 = (HashMap) CARDINFO.get("EF06");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
			<li><a href="#">用户卡信息</a></li>
		</ul>
	</div>
	<div class="formbody">
		<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">EF01</a></li>
					<li><a href="#tab2">EF02</a></li>
					<li><a href="#tab3">EF03</a></li>
					<li><a href="#tab4">EF04</a></li>
					<li><a href="#tab5">EF05</a></li>
					<li><a href="#tab6">EF06</a></li>
				</ul>
			</div>
			<div id="tab1" class="tabson">

				<div class="formtitle1">
					<span>纳税人基本信息</span>
				</div>


				<table class="tableEdit">
					<tr>
						<th>开票截止日期：</th>
						<td><%=(String) EF01.get("KPJZRQ")%>&nbsp;</td>
						<th>单张发票开票金额限额：</th>
						<td><%=new BigDecimal((Long) EF01.get("DZLJJE"))
					.divide(new BigDecimal(100))%>&nbsp;</td>
					</tr>
					<tr>
						<th>发票累计金额限额：</th>
						<td><%=new BigDecimal((Long) EF01.get("YKPLJJE"))
					.divide(new BigDecimal(100))%>&nbsp;</td>
						<th>退票累计金额限额：</th>
						<td><%=new BigDecimal((Long) EF01.get("YTPLJJE"))
					.divide(new BigDecimal(100))%>&nbsp;</td>
					</tr>
					<tr>
						<th>税种税目索引号：</th>
						<td><%=(String) EF01.get("SZSMINDE")%>&nbsp;</td>
						<th>明细申报标志：</th>
						<td><%=(String) EF01.get("MXSBBZ")%>&nbsp;</td>
					</tr>

				</table>


			</div>

			<div id="tab2" class="tabson">
				<table class="tableEdit">
					<tr>
						<th>卡类型标志：</th>
						<td><%=(String) EF02.get("JQLX")%>&nbsp;</td>
						<th>税控收款机数量：
						</td>
						<td><%=(String) EF02.get("JQSL")%>&nbsp;</td>
					</tr>
					<tr>
						<th>纳税人编码：</th>
						<td><%=(String) EF02.get("NSRWJDM")%>&nbsp;</td>
						<th>纳税人名称：</th>
						<td><%=(String) EF02.get("NSRMC")%>&nbsp;</td>
					</tr>
					<tr>
						<th>应用启用日期：</th>
						<td><%=(String) EF02.get("QYRQ")%>&nbsp;</td>
						<th>应用有效日期：</th>
						<td><%=(String) EF02.get("YXRQ")%>&nbsp;</td>
					</tr>
					<tr>
						<th>应用类型标识：</th>
						<td><%=(String) EF02.get("LXBS")%>&nbsp;</td>
						<th>应用版本：</th>
						<td><%=(String) EF02.get("YYBB")%>&nbsp;</td>
					</tr>
					<tr>
						<th>发卡方自定义FCI数据：</th>
						<td><%=(String) EF02.get("FCI")%>&nbsp;</td>
						<th>&nbsp;</th>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			<div id="tab3" class="tabson">
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
					<tbody>
						<%
						    if (EF03 != null && EF03.size() > 0) {
										Iterator it = EF03.iterator();
										while (it.hasNext()) {
											HashMap hm = (HashMap) it.next();
						%>
						<tr>
							<td align="center"><%=(String) hm.get("SZSMINDEX")%>&nbsp;</td>
							<td align="center"><%=(String) hm.get("SZSMDM")%>&nbsp;</td>
							<td align="center"><%=(String) hm.get("ZWMC")%>&nbsp;</td>
							<td align="center"><%=(String) hm.get("EWMC")%>&nbsp;</td>
							<td align="center"><%=(Integer) hm.get("SL")%>&nbsp;</td>
						</tr>
						<%
						    }
									}
						%>
					</tbody>
				</table>
			</div>
			<div id="tab4" class="tabson">
				<table class="tableEdit">
					<%
					    if (EF04 != null && !EF04.isEmpty()) {
					%>
					<tr>
						<td>开始时间：</td>
						<th><%=(String) EF04.get("startdate")%>&nbsp;</th>
						<td>截止时间：</td>
						<th><%=(String) EF04.get("enddate")%>&nbsp;</th>
					</tr>
					<tr>
						<th>税控卡号：</th>
						<td><%=(String) EF04.get("fiscalno")%>&nbsp;</td>
						<th>正常票份数：</th>
						<td><%=(String) EF04.get("normalcnt")%>&nbsp;</td>
					</tr>
					<tr>
						<th>退票份数：</th>
						<td><%=(String) EF04.get("backcnt")%>&nbsp;</td>
						<th>废票份数：</th>
						<td><%=(String) EF04.get("deposecnt")%>&nbsp;</td>
					</tr>
					<tr>
						<th>税目索引1：</th>
						<td><%=(String) EF04.get("index1")%>&nbsp;</td>
						<th>税目索引2：</th>
						<td><%=(String) EF04.get("index2")%>&nbsp;</td>
					</tr>
					<tr>
						<th>税目索引3：</th>
						<td><%=(String) EF04.get("index3")%>&nbsp;</td>
						<th>税目索引4：</th>
						<td><%=(String) EF04.get("index4")%>&nbsp;</td>
					</tr>
					<tr>
						<th>税目索引5：</th>
						<td><%=(String) EF04.get("index5")%>&nbsp;</td>
						<th>税目索引6：</th>
						<td><%=(String) EF04.get("index6")%>&nbsp;</td>
					</tr>
					<tr>
						<th>正常票金额1：</th>
						<td><%=(String) EF04.get("normalsum1")%>&nbsp;</td>
						<th>正常票金额2：</th>
						<td><%=(String) EF04.get("normalsum2")%>&nbsp;</td>
					</tr>
					<tr>
						<th>正常票金额3：</th>
						<td><%=(String) EF04.get("normalsum3")%>&nbsp;</td>
						<th>正常票金额4：</th>
						<td><%=(String) EF04.get("normalsum4")%>&nbsp;</td>
					</tr>
					<tr>
						<th>正常票金额5：</th>
						<td><%=(String) EF04.get("normalsum5")%>&nbsp;</td>
						<th>正常票金额6：</th>
						<td><%=(String) EF04.get("normalsum6")%>&nbsp;</td>
					</tr>
					<tr>
						<th>退票金额1：</th>
						<td><%=(String) EF04.get("backsum1")%>&nbsp;</td>
						<th>退票金额2：</th>
						<td><%=(String) EF04.get("backsum2")%>&nbsp;</td>
					</tr>
					<tr>
						<th>退票金额3：</th>
						<td><%=(String) EF04.get("backsum3")%>&nbsp;</td>
						<th>退票金额4：</th>
						<td><%=(String) EF04.get("backsum4")%>&nbsp;</td>
					</tr>
					<tr>
						<th>退票金额5：</th>
						<td><%=(String) EF04.get("backsum5")%>&nbsp;</td>
						<th>退票金额6：</th>
						<td><%=(String) EF04.get("backsum6")%>&nbsp;</td>
					</tr>
					<tr>
						<th>正常票总金额：</th>
						<td><%=(String) EF04.get("normalsum")%>&nbsp;</td>
						<th>退票总金额：</th>
						<td><%=(String) EF04.get("backsum")%>&nbsp;</td>
					</tr>
					<tr>
						<th>状态：</th>
						<td><%=(String) EF04.get("state")%>&nbsp;</td>
						<th>MAC：</th>
						<td><%=(String) EF04.get("mac")%>&nbsp;</td>
					</tr>
					<%
					    }
					%>
				</table>
			</div>
			<div id="tab5" class="tabson">
				<table class="tablelist">
					<thead>
						<tr>
							<th>发票代码</th>
							<th>发票起始号</th>
							<th>发票终止号</th>
							<th>发票卷数</th>
						</tr>
					</thead>
					<tbody>
						<%
						    if (EF05 != null && EF05.size() > 0) {
										Iterator it = EF05.iterator();
										while (it.hasNext()) {
											HashMap hm = (HashMap) it.next();
											int JS = (Integer) hm.get("JS");
											if (JS > 0) {
						%>
						<tr>
							<td align="center"><%=(String) hm.get("FPDM")%>&nbsp;</td>
							<td align="center"><%=Util.fpIntToString((Integer) hm.get("QSH"))%>&nbsp;</td>
							<td align="center"><%=Util.fpIntToString((Integer) hm.get("JZH"))%>&nbsp;</td>
							<td align="center"><%=(Integer) hm.get("JS")%>&nbsp;</td>
						</tr>
						<%
						    }
										}
									}
						%>
					</tbody>
				</table>
			</div>
			<div id="tab6" class="tabson">
				<table class="tableEdit">
					<tr>
						<th>机器编号：</th>
						<td><%=(String) EF06.get("JQBH")%>&nbsp;</td>
						<th>税控卡编号：</th>
						<td><%=(String) EF06.get("SKKH")%>&nbsp;</td>
					</tr>
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

