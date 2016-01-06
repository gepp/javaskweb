<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产项目明细</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">不动产项目明细</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">不动产项目明细查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqBdcxmmxForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.id}
   				</div>
 			   </li>
 				       			 			   <li><label>子项目ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.parentid}
   				</div>
 			   </li>
 				       			 			   <li><label>项目名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.xmmc}
   				</div>
 			   </li>
 				       			 			   <li><label>项目编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.xmbm}
   				</div>
 			   </li>
 				       			 			   <li><label>保障性普通住宅套数<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.bzxptzzts}
   				</div>
 			   </li>
 				       			 			   <li><label>非保障性普通住宅套数<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.fbzxptzzts}
   				</div>
 			   </li>
 				       			 			   <li><label>非普通住宅套数<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.fptzzts}
   				</div>
 			   </li>
 				       			 			   <li><label>别墅套数<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.bsts}
   				</div>
 			   </li>
 				       			 			   <li><label>商铺套数<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.spts}
   				</div>
 			   </li>
 				       			 			   <li><label>写字楼套数<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.xzlts}
   				</div>
 			   </li>
 				       			 			   <li><label>其他套数<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.qtts}
   				</div>
 			   </li>
 				       			 			   <li><label>保障性普通住宅面积<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.bzxptzzmj}
   				</div>
 			   </li>
 				       			 			   <li><label>非保障性普通住宅面积<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.fbzxptzzmj}
   				</div>
 			   </li>
 				       			 			   <li><label>非普通住宅面积<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.fptzzmj}
   				</div>
 			   </li>
 				       			 			   <li><label>别墅面积<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.bsmj}
   				</div>
 			   </li>
 				       			 			   <li><label>商铺面积<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.spmj}
   				</div>
 			   </li>
 				       			 			   <li><label>写字楼面积<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.xzlmj}
   				</div>
 			   </li>
 				       			 			   <li><label>其他面积<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.qtmj}
   				</div>
 			   </li>
 				       			 			   <li><label>创建者<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.cjz}
   				</div>
 			   </li>
 				       			 			   <li><label>创建时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.cjsj}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.nsrwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>主项目名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdcxmmx.zxmmc}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqbdcxmmx/list?nsrwjbm=${nsrwjbm}&bdcid=${bdcid}&bdczxmid=${bdczxmid}'"/></li>
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

 
 