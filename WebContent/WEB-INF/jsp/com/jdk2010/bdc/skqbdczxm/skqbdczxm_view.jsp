<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产主项目</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">不动产主项目</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">不动产主项目查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqBdczxmForm">
									 
					 			   <li><label>id<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdczxm.id}
   				</div>
 			   </li>
 				       			 			   <li><label>主项目ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdczxm.parentid}
   				</div>
 			   </li>
 				       			 			   <li><label>项目名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdczxm.xmmc}
   				</div>
 			   </li>
 				       			 			   <li><label>税务机关编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdczxm.zgswjg}
   				</div>
 			   </li>
 				       			 			   <li><label>创建者<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdczxm.cjz}
   				</div>
 			   </li>
 				       			 			   <li><label>创建时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdczxm.cjsj}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqBdczxm.nsrwjbm}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqbdczxm/list'"/></li>
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

 
 