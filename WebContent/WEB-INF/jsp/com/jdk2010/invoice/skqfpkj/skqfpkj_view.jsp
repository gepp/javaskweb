<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发票开具</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">发票开具</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发票开具查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqFpkjForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.id}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.jqbh}
   				</div>
 			   </li>
 				       			 			   <li><label>开票日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.kprq}
   				</div>
 			   </li>
 				       			 			   <li><label>开票类型<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.kplx}
   				</div>
 			   </li>
 				       			 			   <li><label>发票代码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.fpdm}
   				</div>
 			   </li>
 				       			 			   <li><label>发票号码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.fphm}
   				</div>
 			   </li>
 				       			 			   <li><label>开票金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.hjzje}
   				</div>
 			   </li>
 				       			 			   <li><label>原发票号码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.yfphm}
   				</div>
 			   </li>
 				       			 			   <li><label>付款单位<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.fkdw}
   				</div>
 			   </li>
 				       			 			   <li><label>收款员<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.sky}
   				</div>
 			   </li>
 				       			 			   <li><label>项目数<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.xms}
   				</div>
 			   </li>
 				       			 			   <li><label>税控码<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.skm}
   				</div>
 			   </li>
 				       			 			   <li><label>确认标志<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.qrbz}
   				</div>
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.status}
   				</div>
 			   </li>
 				       			 			   <li><label>上传时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.scsj}
   				</div>
 			   </li>
 				       			 			   <li><label>备注<b></b></label>
 			     <div class="control-group">
   			 		${ skqFpkj.bz}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqfpkj/list'"/></li>
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

 
 