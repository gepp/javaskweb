<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产开票</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">不动产开票</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">不动产开票查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqBdckpForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.id}
   				</div>
 			   </li>
 				       			 			   <li><label>楼牌ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.parentid}
   				</div>
 			   </li>
 				       			 			   <li><label>楼牌号<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.lpmc}
   				</div>
 			   </li>
 				       			 			   <li><label>付款方名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.fkfmc}
   				</div>
 			   </li>
 				       			 			   <li><label>付款方代码<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.fkfdm}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.jqbh}
   				</div>
 			   </li>
 				       			 			   <li><label>开票金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.hjzje}
   				</div>
 			   </li>
 				       			 			   <li><label>款项性质<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.kxxz}
   				</div>
 			   </li>
 				       			 			   <li><label>发票代码<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.fpdm}
   				</div>
 			   </li>
 				       			 			   <li><label>发票号码<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.fphm}
   				</div>
 			   </li>
 				       			 			   <li><label>开票类型<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.kplx}
   				</div>
 			   </li>
 				       			 			   <li><label>开票日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.kprq}
   				</div>
 			   </li>
 				       			 			   <li><label>上传日期<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.scrq}
   				</div>
 			   </li>
 				       			 			   <li><label>项目ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.bdcid}
   				</div>
 			   </li>
 				       			 			   <li><label>子项目ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.bdczxmid}
   				</div>
 			   </li>
 				       			 			   <li><label>项目明细ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdckp.bdcxmmxid}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqbdckp/list'"/></li>
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

 
 