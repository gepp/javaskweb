<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>纳税人税种税目</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">纳税人税种税目</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">纳税人税种税目查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqNsrszsmForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrszsm.id}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrszsm.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>税种编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrszsm.szbm}
   				</div>
 			   </li>
 				       			 			   <li><label>税种编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrszsm.smbm}
   				</div>
 			   </li>
 				       			 			   <li><label>税种编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrszsm.smmc}
   				</div>
 			   </li>
 				       			 			   <li><label>税种编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrszsm.smjc}
   				</div>
 			   </li>
 				       			 			   <li><label>税率<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrszsm.sl}
   				</div>
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrszsm.status}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqnsrszsm/list'"/></li>
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

 
 