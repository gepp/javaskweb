<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产楼盘</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">不动产楼盘</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">不动产楼盘查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqBdclpForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.id}
   				</div>
 			   </li>
 				       			 			   <li><label>项目明细ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.parentid}
   				</div>
 			   </li>
 				       			 			   <li><label>楼牌号<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.lpmc}
   				</div>
 			   </li>
 				       			 			   <li><label>楼层<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.lc}
   				</div>
 			   </li>
 				       			 			   <li><label>楼牌序号<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.lpxh}
   				</div>
 			   </li>
 				       			 			   <li><label>面积<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.mj}
   				</div>
 			   </li>
 				       			 			   <li><label>单价<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.dj}
   				</div>
 			   </li>
 				       			 			   <li><label>类型<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.lx}
   				</div>
 			   </li>
 				       			 			   <li><label>创建时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.cjsj}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>已开金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.ykje}
   				</div>
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdclp.status}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqbdclp/list'"/></li>
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

 
 