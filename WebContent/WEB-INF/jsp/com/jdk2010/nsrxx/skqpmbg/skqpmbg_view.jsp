<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>品目变更</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">品目变更</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">品目变更查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqPmbgForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.id}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.jqbh}
   				</div>
 			   </li>
 				       			 			   <li><label>原税目编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.ysmbm}
   				</div>
 			   </li>
 				       			 			   <li><label>变更税目编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.bgsmbm}
   				</div>
 			   </li>
 				       			 			   <li><label>变更说明<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.bgsm}
   				</div>
 			   </li>
 				       			 			   <li><label>申请时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.sqsj}
   				</div>
 			   </li>
 				       			 			   <li><label>申请时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.clbz}
   				</div>
 			   </li>
 				       			 			   <li><label>处理者<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.clz}
   				</div>
 			   </li>
 				       			 			   <li><label>处理意见<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.clyj}
   				</div>
 			   </li>
 				       			 			   <li><label>处理意见<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.clsj}
   				</div>
 			   </li>
 				       			 			   <li><label>处理意见<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmbg.xzbs}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqpmbg/list'"/></li>
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

 
 