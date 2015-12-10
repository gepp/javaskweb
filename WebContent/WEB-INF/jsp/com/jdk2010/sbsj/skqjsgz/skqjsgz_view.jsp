<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>计税规则</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">计税规则</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">计税规则查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqJsgzForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqJsgz.id}
   				</div>
 			   </li>
 				       			 			   <li><label>税务机关编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqJsgz.swjgbm}
   				</div>
 			   </li>
 				       			 			   <li><label>税目编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqJsgz.smbm}
   				</div>
 			   </li>
 				       			 			   <li><label>税目简称<b></b></label>
 			     <div class="control-group">
   			 		${ skqJsgz.smjc}
   				</div>
 			   </li>
 				       			 			   <li><label>特征标示<b></b></label>
 			     <div class="control-group">
   			 		${ skqJsgz.tzbs}
   				</div>
 			   </li>
 				       			 			   <li><label>计税规则<b></b></label>
 			     <div class="control-group">
   			 		${ skqJsgz.jsgz}
   				</div>
 			   </li>
 				       			 			   <li><label>启用标示<b></b></label>
 			     <div class="control-group">
   			 		${ skqJsgz.qybj}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqjsgz/list'"/></li>
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

 
 