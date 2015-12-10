<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>限额变更</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">限额变更</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">限额变更查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqXebgForm">
									 
					 			   <li><label>ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.id}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.jqbh}
   				</div>
 			   </li>
 				       			 			   <li><label>剩余累计开票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.syljkpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>剩余累计退票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.syljtpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>申请累计开票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.sqljkpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>申请累计退票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.sqljtpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>申请累计退票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.pzljkpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>批准累计退票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.pzljtpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>变更说明<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.bgsm}
   				</div>
 			   </li>
 				       			 			   <li><label>申请时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.sqsj}
   				</div>
 			   </li>
 				       			 			   <li><label>处理标示<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.clbz}
   				</div>
 			   </li>
 				       			 			   <li><label>处理者<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.clz}
   				</div>
 			   </li>
 				       			 			   <li><label>处理意见<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.clyj}
   				</div>
 			   </li>
 				       			 			   <li><label>处理时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.clsj}
   				</div>
 			   </li>
 				       			 			   <li><label>下载标示<b></b></label>
 			     <div class="control-group">
   			 		${ skqXebg.xzbs}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqxebg/list'"/></li>
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

 
 