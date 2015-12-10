<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建筑安装项目</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">建筑安装项目</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">建筑安装项目查看</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqJzazForm">
									 
					 			   <li><label>ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.id}
   				</div>
 			   </li>
 				       			 			   <li><label>上级项目ID<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.parentid}
   				</div>
 			   </li>
 				       			 			   <li><label>项目代码<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.xmdm}
   				</div>
 			   </li>
 				       			 			   <li><label>项目名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.xmmc}
   				</div>
 			   </li>
 				       			 			   <li><label>税务机关编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.zgswjg}
   				</div>
 			   </li>
 				       			 			   <li><label>甲方微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.jfwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>甲方名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.jfmc}
   				</div>
 			   </li>
 				       			 			   <li><label>乙方微机编码<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.yfwjbm}
   				</div>
 			   </li>
 				       			 			   <li><label>乙方名称<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.yfmc}
   				</div>
 			   </li>
 				       			 			   <li><label>项目类型<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.xmlx}
   				</div>
 			   </li>
 				       			 			   <li><label>合同性质<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.htxz}
   				</div>
 			   </li>
 				       			 			   <li><label>工程款<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.gck}
   				</div>
 			   </li>
 				       			 			   <li><label>甲供材<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.jgc}
   				</div>
 			   </li>
 				       			 			   <li><label>创建者<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.cjz}
   				</div>
 			   </li>
 				       			 			   <li><label>创建时间<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.cjsj}
   				</div>
 			   </li>
 				       			 			   <li><label>登记已开金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.ykje}
   				</div>
 			   </li>
 				       			 			   <li><label>纳税人性质<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.nsrxz}
   				</div>
 			   </li>
 				       			 			   <li><label>待抵扣金额<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.ddkje}
   				</div>
 			   </li>
 				       			 			   <li><label>项目状态<b></b></label>
 			     <div class="control-group">
   			 		${ skqJzaz.xmzt}
   				</div>
 			   </li>
 				        			<li><label>&nbsp;</label>
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqjzaz/list'"/></li>
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

 
 