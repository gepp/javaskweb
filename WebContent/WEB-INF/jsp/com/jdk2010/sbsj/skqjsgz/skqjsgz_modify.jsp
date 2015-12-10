<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>计税规则</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<link rel="stylesheet" href="${ contextpath }/res/js/validator-0.7.3/jquery.validator.css">
<script type="text/javascript" src="${ contextpath }/res/js/validator-0.7.3/jquery.validator.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/validator-0.7.3/local/zh_CN.js"></script>
		<link href="${ contextpath }/res/css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ contextpath }/res/js/select-ui.min.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">计税规则</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">计税规则编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqJsgzForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqJsgz.id" placeholder="请输入id" value="${ skqJsgz.id}" />
 			   </li>
 				       			 			   <li><label>税务机关编码<b></b></label>
 			   <input  type="text" class="dfinput" id="swjgbm" name="skqJsgz.swjgbm" placeholder="请输入税务机关编码" value="${ skqJsgz.swjgbm}" />
 			   </li>
 				       			 			   <li><label>税目编码<b></b></label>
 			   <input  type="text" class="dfinput" id="smbm" name="skqJsgz.smbm" placeholder="请输入税目编码" value="${ skqJsgz.smbm}" />
 			   </li>
 				       			 			   <li><label>税目简称<b></b></label>
 			   <input  type="text" class="dfinput" id="smjc" name="skqJsgz.smjc" placeholder="请输入税目简称" value="${ skqJsgz.smjc}" />
 			   </li>
 				       			 			   <li><label>特征标示<b></b></label>
 			   <input  type="text" class="dfinput" id="tzbs" name="skqJsgz.tzbs" placeholder="请输入特征标示" value="${ skqJsgz.tzbs}" />
 			   </li>
 				       			 			   <li><label>计税规则<b></b></label>
 			   <input  type="text" class="dfinput" id="jsgz" name="skqJsgz.jsgz" placeholder="请输入计税规则" value="${ skqJsgz.jsgz}" />
 			   </li>
 				       			 			   <li><label>启用标示<b></b></label>
 			   <input  type="text" class="dfinput" id="qybj" name="skqJsgz.qybj" placeholder="请输入启用标示" value="${ skqJsgz.qybj}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqjsgz/list'"/></li>
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

 
 <script type="text/javascript">

 
 	$(document).ready(
 		function(){
 		  $(".select1").uedSelect({
				width : 345			  
			});
 			$('#skqJsgzForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqJsgz.id':'required;',
 			    	     			    	 			    		 			    			'skqJsgz.swjgbm':'required;',
 			    	     			    	 			    		 			    			'skqJsgz.smbm':'required;',
 			    	     			    	 			    		 			    			'skqJsgz.smjc':'required;',
 			    	     			    	 			    		 			    			'skqJsgz.tzbs':'required;',
 			    	     			    	 			    		 			    			'skqJsgz.jsgz':'required;',
 			    	     			    	 			    		 			    			'skqJsgz.qybj':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqjsgz/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqjsgz/list';
								});
 			                }else{
 			                	sAlert('当前操作失败');
 			                }
 			               
 			            }
 			        });
 			    }
 			})
 			;
 		 
 		}		
 	);
 </script>
 