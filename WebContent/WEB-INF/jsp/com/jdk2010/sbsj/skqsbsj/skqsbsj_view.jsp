<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申报数据</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">申报数据</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">申报数据查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqSbsjForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.id}
   				</div>
 			   </li>
 				       			 			   <li><label>所属开始时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.sskssj}
   				</div>
 			   </li>
 				       			 			   <li><label>所属截止时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.ssjzsj}
   				</div>
 			   </li>
 				       			 			   <li><label>正常票份数<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.zcpfs}
   				</div>
 			   </li>
 				       			 			   <li><label>退票份数<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.tpfs}
   				</div>
 			   </li>
 				       			 			   <li><label>废票份数<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.fpfs}
   				</div>
 			   </li>
 				       			 			   <li><label>正常票总金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.zcpzje}
   				</div>
 			   </li>
 				       			 			   <li><label>退票总金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.tpzje}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.jqbh}
   				</div>
 			   </li>
 				       			 			   <li><label>申报类型<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.sblx}
   				</div>
 			   </li>
 				       			 			   <li><label>开票截止日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.kpjzsj}
   				</div>
 			   </li>
 				       			 			   <li><label>单张开票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.dzkpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>月累计开票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.yljkpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>月累计退票限额<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.yljtpxe}
   				</div>
 			   </li>
 				       			 			   <li><label>下载状态<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.xzzt}
   				</div>
 			   </li>
 				       			 			   <li><label>下载日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.xzrq}
   				</div>
 			   </li>
 				       			 			   <li><label>创建日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.cjrq}
   				</div>
 			   </li>
 				       			 			   <li><label>申报日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.sbrq}
   				</div>
 			   </li>
 				       			 			   <li><label>MAC<b></b></label>
 			     <div class="control-group">
   			 		${ skqSbsj.mac}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqsbsj/list'"/></li>
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

 
 