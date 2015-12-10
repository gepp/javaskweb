<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申报查账征收户异常警告</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">申报查账征收户异常警告</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">申报查账征收户异常警告查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqSbczzshjgForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.id}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>年份<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.year}
   				</div>
 			   </li>
 				       			 			   <li><label>月份<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.month}
   				</div>
 			   </li>
 				       			 			   <li><label>开票税款<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.kpsk}
   				</div>
 			   </li>
 				       			 			   <li><label>申报税款<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.sbsk}
   				</div>
 			   </li>
 				       			 			   <li><label>创建时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.clbz}
   				</div>
 			   </li>
 				       			 			   <li><label>处理标示<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.cjsj}
   				</div>
 			   </li>
 				       			 			   <li><label>处理时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.clsj}
   				</div>
 			   </li>
 				       			 			   <li><label>处理者<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbczzshjg.clz}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqsbczzshjg/list'"/></li>
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

 
 