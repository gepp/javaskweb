<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产项目明细</title>
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
			<li><a href="#">不动产项目明细</a></li>
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
			<span>不动产项目明细</span>
		</div>
		<table class="tablelist">
		<thead>
				<tr>
				<th><input type="checkbox" width="15px"  id="checkAll"/></th>
				
														   <th>id</th>
																			   <th>子项目ID</th>
																			   <th>项目名称</th>
																			   <th>项目编码</th>
																			   <th>保障性普通住宅套数</th>
																			   <th>非保障性普通住宅套数</th>
																			   <th>非普通住宅套数</th>
																			   <th>别墅套数</th>
																			   <th>商铺套数</th>
																			   <th>写字楼套数</th>
																			   <th>其他套数</th>
																			   <th>保障性普通住宅面积</th>
																			   <th>非保障性普通住宅面积</th>
																			   <th>非普通住宅面积</th>
																			   <th>别墅面积</th>
																			   <th>商铺面积</th>
																			   <th>写字楼面积</th>
																			   <th>其他面积</th>
																			   <th>创建者</th>
																			   <th>创建时间</th>
																			   <th>纳税人微机编码</th>
																			   <th>主项目名称</th>
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
															${ item.xmmc}
													</td>	

						 												 						<td>
															${ item.xmbm}
													</td>	

						 												 						<td>
															${ item.bzxptzzts}
													</td>	

						 												 						<td>
															${ item.fbzxptzzts}
													</td>	

						 												 						<td>
															${ item.fptzzts}
													</td>	

						 												 						<td>
															${ item.bsts}
													</td>	

						 												 						<td>
															${ item.spts}
													</td>	

						 												 						<td>
															${ item.xzlts}
													</td>	

						 												 						<td>
															${ item.qtts}
													</td>	

						 												 						<td>
															${ item.bzxptzzmj}
													</td>	

						 												 						<td>
															${ item.fbzxptzzmj}
													</td>	

						 												 						<td>
															${ item.fptzzmj}
													</td>	

						 												 						<td>
															${ item.bsmj}
													</td>	

						 												 						<td>
															${ item.spmj}
													</td>	

						 												 						<td>
															${ item.xzlmj}
													</td>	

						 												 						<td>
															${ item.qtmj}
													</td>	

						 												 						<td>
															${ item.cjz}
													</td>	

						 												 						<td>
															${ item.cjsj}
													</td>	

						 												 						<td>
															${ item.nsrwjbm}
													</td>	

						 												 						<td>
															${ item.zxmmc}
													</td>	

						 													<td>
							<a href="${ contextpath }/skqbdcxmmx/modify.htm?id=${item.id}" class="tablelink">编辑</a> 
							<a href="${ contextpath }/skqbdcxmmx/view.htm?id=${item.id}"  class="tablelink">查看</a>
 				   </tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page href="${ contextpath}/skqbdcxmmx/list?" data="pageList" />
		
</div>
</body>
</html>

<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$(document).ready(function(){
			table_init("${ contextpath}/skqbdcxmmx","${ contextpath}/skqbdcxmmx/list?");
		});
</script>

 