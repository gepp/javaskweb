<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>品目设置</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
	<style type="text/css">
.forminfo li label {
	width: 128px
}
</style>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">品目设置</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">品目设置查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqPmszForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.id}
   				</div>
 			   </li>
 				       			 			   <li><label>税种编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.szbm}
   				</div>
 			   </li>
 				       			 			   <li><label>税目编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.smbm}
   				</div>
 			   </li>
 				       			 			   <li><label>税目名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.smmc}
   				</div>
 			   </li>
 				       			 			   <li><label>税目简称<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.smjc}
   				</div>
 			   </li>
 				       			 			   <li><label>税率<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.sl}
   				</div>
 			   </li>
 				       			 			   <li><label>税目索引<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.smsy}
   				</div>
 			   </li>
 				       			 			   <li><label>票种编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.fpbm}
   				</div>
 			   </li>
 				       			 			   <li><label>核定户开票限额比例<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.hdkpbl}
   				</div>
 			   </li>
 				       			 			   <li><label>查账征收户开票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.czkpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>是否差额征收<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.cezs}
   				</div>
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			     <div class="control-group">
   			 		${ skqPmsz.status}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqpmsz/list'"/></li>
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

 
 