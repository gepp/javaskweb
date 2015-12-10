<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申报数据</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
	<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/layer/layer.js"></script>

</head>
<body>

<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">申报数据</a></li>
		</ul>
</div>
<div class="rightinfo">
		
					
							 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 				 			 			
																																																																																																																																																																																													 <div class="tools">
			<ul class="toolbar">
			<li class="click" id="table_add"><span><img src="${ contextpath }/res/images/t01.png" /></span>添加</li>
	        <li id="table_delete" ><span><img src="${ contextpath }/res/images/t03.png" /></span>删除</li>
	        <li  id="table_refresh"><span><img src="${ contextpath }/res/images/t04.png" /></span>查询</li>
			</ul>
		</div>
				
			 		<div class="formtitle1">
			<span>申报数据</span>
		</div>
		<table class="tablelist">
		<thead>
				<tr>
				<th><input type="checkbox" width="15px"  id="checkAll"/></th>
				
														   <th>id</th>
																			   <th>所属开始时间</th>
																			   <th>所属截止时间</th>
																			   <th>正常票份数</th>
																			   <th>退票份数</th>
																			   <th>废票份数</th>
																			   <th>正常票总金额</th>
																			   <th>退票总金额</th>
																			   <th>纳税人微机编码</th>
																			   <th>机器编号</th>
																			   <th>申报类型</th>
																			   <th>开票截止日期</th>
																			   <th>单张开票限额</th>
																			   <th>月累计开票限额</th>
																			   <th>月累计退票限额</th>
																			   <th>下载状态</th>
																			   <th>下载日期</th>
																			   <th>创建日期</th>
																			   <th>申报日期</th>
																			   <th>MAC</th>
													<th>操作</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.list}" var="item">
				 	
			       <tr>
						<td><input type="checkbox" name="subBox" value="${item.id}" /></td>
												 						<td>
															${ item.id}
													</td>	

						 												 						<td>
															${ item.sskssj}
													</td>	

						 												 						<td>
															${ item.ssjzsj}
													</td>	

						 												 						<td>
															${ item.zcpfs}
													</td>	

						 												 						<td>
															${ item.tpfs}
													</td>	

						 												 						<td>
															${ item.fpfs}
													</td>	

						 												 						<td>
															${ item.zcpzje}
													</td>	

						 												 						<td>
															${ item.tpzje}
													</td>	

						 												 						<td>
															${ item.nsrwjbm}
													</td>	

						 												 						<td>
															${ item.jqbh}
													</td>	

						 												 						<td>
															${ item.sblx}
													</td>	

						 												 						<td>
															${ item.kpjzsj}
													</td>	

						 												 						<td>
															${ item.dzkpxe}
													</td>	

						 												 						<td>
															${ item.yljkpxe}
													</td>	

						 												 						<td>
															${ item.yljtpxe}
													</td>	

						 												 						<td>
															${ item.xzzt}
													</td>	

						 												 						<td>
															${ item.xzrq}
													</td>	

						 												 						<td>
															${ item.cjrq}
													</td>	

						 												 						<td>
															${ item.sbrq}
													</td>	

						 												 						<td>
															${ item.mac}
													</td>	

						 													<td>
							<a href="${ contextpath }/skqsbsj/modify.htm?id=${item.id}" class="tablelink">编辑</a> 
							<a href="${ contextpath }/skqsbsj/view.htm?id=${item.id}"  class="tablelink">查看</a>
 				   </tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page href="${ contextpath}/skqsbsj/list?" data="pageList" />
		
</div>
</body>
</html>

<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$(document).ready(function(){
			table_init("${ contextpath}/skqsbsj","${ contextpath}/skqsbsj/list?");
		});
</script>

 