<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建筑安装项目</title>
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
			<li><a href="#">建筑安装项目</a></li>
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
			<span>建筑安装项目</span>
		</div>
		<table class="tablelist">
		<thead>
				<tr>
				<th><input type="checkbox" width="15px"  id="checkAll"/></th>
				
														   <th>ID</th>
																			   <th>上级项目ID</th>
																			   <th>项目代码</th>
																			   <th>项目名称</th>
																			   <th>税务机关编码</th>
																			   <th>甲方微机编码</th>
																			   <th>甲方名称</th>
																			   <th>乙方微机编码</th>
																			   <th>乙方名称</th>
																			   <th>项目类型</th>
																			   <th>合同性质</th>
																			   <th>工程款</th>
																			   <th>甲供材</th>
																			   <th>创建者</th>
																			   <th>创建时间</th>
																			   <th>登记已开金额</th>
																			   <th>纳税人性质</th>
																			   <th>待抵扣金额</th>
																			   <th>项目状态</th>
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
															${ item.xmdm}
													</td>	

						 												 						<td>
															${ item.xmmc}
													</td>	

						 												 						<td>
															${ item.zgswjg}
													</td>	

						 												 						<td>
															${ item.jfwjbm}
													</td>	

						 												 						<td>
															${ item.jfmc}
													</td>	

						 												 						<td>
															${ item.yfwjbm}
													</td>	

						 												 						<td>
															${ item.yfmc}
													</td>	

						 												 						<td>
															${ item.xmlx}
													</td>	

						 												 						<td>
															${ item.htxz}
													</td>	

						 												 						<td>
															${ item.gck}
													</td>	

						 												 						<td>
															${ item.jgc}
													</td>	

						 												 						<td>
															${ item.cjz}
													</td>	

						 												 						<td>
															${ item.cjsj}
													</td>	

						 												 						<td>
															${ item.ykje}
													</td>	

						 												 						<td>
															${ item.nsrxz}
													</td>	

						 												 						<td>
															${ item.ddkje}
													</td>	

						 												 						<td>
															${ item.xmzt}
													</td>	

						 													<td>
							<a href="${ contextpath }/skqjzaz/modify.htm?id=${item.id}" class="tablelink">编辑</a> 
							<a href="${ contextpath }/skqjzaz/view.htm?id=${item.id}"  class="tablelink">查看</a>
 				   </tr>
				</c:forEach>
			</tbody>
		</table>
		<page:page href="${ contextpath}/skqjzaz/list?" data="pageList" />
		
</div>
</body>
</html>

<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		$(document).ready(function(){
			table_init("${ contextpath}/skqjzaz","${ contextpath}/skqjzaz/list?");
		});
</script>

 