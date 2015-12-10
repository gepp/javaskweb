<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产开票</title>
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
			<li><a href="#">不动产开票</a></li>
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
			<span>不动产开票</span>
		</div>
		<table class="tablelist">
		<thead>
				<tr>
				<th><input type="checkbox" width="15px"  id="checkAll"/></th>
				
														   <th>id</th>
																			   <th>楼牌ID</th>
																			   <th>楼牌号</th>
																			   <th>付款方名称</th>
																			   <th>付款方代码</th>
																			   <th>纳税人微机编码</th>
																			   <th>机器编号</th>
																			   <th>开票金额</th>
																			   <th>款项性质</th>
																			   <th>发票代码</th>
																			   <th>发票号码</th>
																			   <th>开票类型</th>
																			   <th>开票日期</th>
																			   <th>上传日期</th>
																			   <th>项目ID</th>
																			   <th>子项目ID</th>
																			   <th>项目明细ID</th>
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
															${ item.lpmc}
													</td>	

						 												 						<td>
															${ item.fkfmc}
													</td>	

						 												 						<td>
															${ item.fkfdm}
													</td>	

						 												 						<td>
															${ item.nsrwjbm}
													</td>	

						 												 						<td>
															${ item.jqbh}
													</td>	

						 												 						<td>
															${ item.hjzje}
													</td>	

						 												 						<td>
															${ item.kxxz}
													</td>	

						 												 						<td>
															${ item.fpdm}
													</td>	

						 												 						<td>
															${ item.fphm}
													</td>	

						 												 						<td>
															${ item.kplx}
													</td>	

						 												 						<td>
															${ item.kprq}
													</td>	

						 												 						<td>
															${ item.scrq}
													</td>	

						 												 						<td>
															${ item.bdcid}
													</td>	

						 												 						<td>
															${ item.bdczxmid}
													</td>	

						 												 						<td>
															${ item.bdcxmmxid}
													</td>	

						 													<td>
							<a href="${ contextpath }/skqbdckp/modify.htm?id=${item.id}" class="tablelink">编辑</a> 
							<a href="${ contextpath }/skqbdckp/view.htm?id=${item.id}"  class="tablelink">查看</a>
 				   </tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page href="${ contextpath}/skqbdckp/list?" data="pageList" />
		
</div>
</body>
</html>

<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$(document).ready(function(){
			table_init("${ contextpath}/skqbdckp","${ contextpath}/skqbdckp/list?");
		});
</script>

 