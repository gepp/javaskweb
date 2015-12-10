<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发票开具项目</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">发票开具项目</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发票开具项目查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqFpkjxmForm">
									 
					 			   <li><label>ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkjxm.id}
   				</div>
 			   </li>
 				       			 			   <li><label>发票开具ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkjxm.parentid}
   				</div>
 			   </li>
 				       			 			   <li><label>项目名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkjxm.xmmc}
   				</div>
 			   </li>
 				       			 			   <li><label>小数位数<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkjxm.xsws}
   				</div>
 			   </li>
 				       			 			   <li><label>数量<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkjxm.sl}
   				</div>
 			   </li>
 				       			 			   <li><label>单价<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkjxm.dj}
   				</div>
 			   </li>
 				       			 			   <li><label>金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkjxm.je}
   				</div>
 			   </li>
 				       			 			   <li><label>税目编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkjxm.smbm}
   				</div>
 			   </li>
 				       			 			   <li><label>计税项目<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkjxm.jsxm}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqfpkjxm/list'"/></li>
 	</form>
  </ul>
 </div>
 </div>  
</div>
</body>
</html>
  <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

 
 