<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>汇总数据</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">汇总数据</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">汇总数据查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqHzsjForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.id}
   				</div>
 			   </li>
 				       			 			   <li><label>年<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.year}
   				</div>
 			   </li>
 				       			 			   <li><label>月<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.month}
   				</div>
 			   </li>
 				       			 			   <li><label>正常票份数<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.zcpfs}
   				</div>
 			   </li>
 				       			 			   <li><label>退票份数<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.tpfs}
   				</div>
 			   </li>
 				       			 			   <li><label>废票份数<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.fpfs}
   				</div>
 			   </li>
 				       			 			   <li><label>正常票总金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.zcpzje}
   				</div>
 			   </li>
 				       			 			   <li><label>退票总金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.tpzje}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>汇总日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.hzrq}
   				</div>
 			   </li>
 				       			 			   <li><label>处理标志<b></b></label>
 			     <div class="control-group">
   			 		${ skqHzsj.clbz}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqhzsj/list'"/></li>
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

 
 