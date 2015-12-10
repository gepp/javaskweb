<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>机器信息</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">机器信息</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">机器信息查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqJqxxForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.id}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>机器型号编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.jqxhbm}
   				</div>
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.jqbh}
   				</div>
 			   </li>
 				       			 			   <li><label>税控卡号<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.skkh}
   				</div>
 			   </li>
 				       			 			   <li><label>用户卡号<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.yhkh}
   				</div>
 			   </li>
 				       			 			   <li><label>卡启用日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.kqyrq}
   				</div>
 			   </li>
 				       			 			   <li><label>卡有效日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.kyxrq}
   				</div>
 			   </li>
 				       			 			   <li><label>申报方式<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.sbfs}
   				</div>
 			   </li>
 				       			 			   <li><label>明细申报标志<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.mxsbbz}
   				</div>
 			   </li>
 				       			 			   <li><label>开票截止日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.kpjzrq}
   				</div>
 			   </li>
 				       			 			   <li><label>单张开票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.dzkpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>月累计开票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.yljkpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>月累计开票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.yljtpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			     <div class="control-group">
   			 		${ skqJqxx.status}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqjqxx/list'"/></li>
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

 
 