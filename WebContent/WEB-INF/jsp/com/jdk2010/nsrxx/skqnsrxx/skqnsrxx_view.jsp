<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>纳税人信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">纳税人信息</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">纳税人信息查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqNsrxxForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.id}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人识别号<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.nsrsbh}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.nsrmc}
   				</div>
 			   </li>
 				       			 			   <li><label>经营地址<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.jydz}
   				</div>
 			   </li>
 				       			 			   <li><label>法人代表<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.frdb}
   				</div>
 			   </li>
 				       			 			   <li><label>注册类型编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.zclxbm}
   				</div>
 			   </li>
 				       			 			   <li><label>行业编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.hybm}
   				</div>
 			   </li>
 				       			 			   <li><label>行业明细编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.hymxbm}
   				</div>
 			   </li>
 				       			 			   <li><label>征收方式<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.zsfs}
   				</div>
 			   </li>
 				       			 			   <li><label>月核定营业额<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.yhde}
   				</div>
 			   </li>
 				       			 			   <li><label>税务机关编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.swjgbm}
   				</div>
 			   </li>
 				       			 			   <li><label>办税员<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.bsy}
   				</div>
 			   </li>
 				       			 			   <li><label>联系方式<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.ssgly}
   				</div>
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			     <div class="control-group">
   			 		${ skqNsrxx.status}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqnsrxx/list'"/></li>
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

 
 