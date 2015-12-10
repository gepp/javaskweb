<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发票卷信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">发票卷信息</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发票卷信息查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqFpjForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpj.id}
   				</div>
 			   </li>
 				       			 			   <li><label>发票编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpj.fpbm}
   				</div>
 			   </li>
 				       			 			   <li><label>发票编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpj.fpdm}
   				</div>
 			   </li>
 				       			 			   <li><label>发票起始号码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpj.fpqsh}
   				</div>
 			   </li>
 				       			 			   <li><label>发票截止号码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpj.fpjzh}
   				</div>
 			   </li>
 				       			 			   <li><label>发票单位<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpj.fpdw}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpj.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>发票领购日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpj.fplgrq}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqfpj/list'"/></li>
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

 
 