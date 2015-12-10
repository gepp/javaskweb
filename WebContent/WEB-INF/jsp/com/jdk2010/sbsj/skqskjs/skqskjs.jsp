<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申报汇总数据税款计算</title>
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
			<li><a href="#">申报汇总数据税款计算</a></li>
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
			<span>申报汇总数据税款计算</span>
		</div>
		<table class="tablelist">
		<thead>
				<tr>
				<th><input type="checkbox" width="15px"  id="checkAll"/></th>
				
														   <th>ID</th>
																			   <th>申报汇总ID</th>
																			   <th>税种编码</th>
																			   <th>税目编码</th>
																			   <th>计税金额</th>
																			   <th>税率</th>
																			   <th>应计税额</th>
																			   <th>处理方式</th>
																			   <th>处理标示</th>
																			   <th>申报时间</th>
																			   <th>申报文档号</th>
																			   <th>票表比对</th>
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
															${ item.parentid}
													</td>	

						 												 						<td>
															${ item.szbm}
													</td>	

						 												 						<td>
															${ item.smbm}
													</td>	

						 												 						<td>
															${ item.jsje}
													</td>	

						 												 						<td>
															${ item.sl}
													</td>	

						 												 						<td>
															${ item.yjse}
													</td>	

						 												 						<td>
															${ item.clfs}
													</td>	

						 												 						<td>
															${ item.clbs}
													</td>	

						 												 						<td>
															${ item.sbsj}
													</td>	

						 												 						<td>
															${ item.sbwdh}
													</td>	

						 												 						<td>
															${ item.pbbd}
													</td>	

						 													<td>
							<a href="${ contextpath }/skqskjs/modify.htm?id=${item.id}" class="tablelink">编辑</a> 
							<a href="${ contextpath }/skqskjs/view.htm?id=${item.id}"  class="tablelink">查看</a>
 				   </tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page href="${ contextpath}/skqskjs/list?" data="pageList" />
		
</div>
</body>
</html>

<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$(document).ready(function(){
			table_init("${ contextpath}/skqskjs","${ contextpath}/skqskjs/list?");
		});
</script>

 