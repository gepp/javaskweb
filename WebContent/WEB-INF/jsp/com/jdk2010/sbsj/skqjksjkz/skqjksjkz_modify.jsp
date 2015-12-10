<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>监控数据下载控制</title>
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
    <li><a href="#">监控数据下载控制</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">监控数据下载控制编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqJksjkzForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqJksjkz.id" placeholder="请输入id" value="${ skqJksjkz.id}" />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqJksjkz.nsrwjbm" placeholder="请输入纳税人微机编码" value="${ skqJksjkz.nsrwjbm}" />
 			   </li>
 				       			 			   <li><label>原因<b></b></label>
 			   <input  type="text" class="dfinput" id="tzyy" name="skqJksjkz.tzyy" placeholder="请输入原因" value="${ skqJksjkz.tzyy}" />
 			   </li>
 				       			 			   <li><label>限制时间<b></b></label>
 			   <input  type="text" class="dfinput" id="tzsj" name="skqJksjkz.tzsj" placeholder="请输入限制时间" value="${ skqJksjkz.tzsj}" />
 			   </li>
 				       			 			   <li><label>创建者<b></b></label>
 			   <input  type="text" class="dfinput" id="cjz" name="skqJksjkz.cjz" placeholder="请输入创建者" value="${ skqJksjkz.cjz}" />
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			   <input  type="text" class="dfinput" id="status" name="skqJksjkz.status" placeholder="请输入状态" value="${ skqJksjkz.status}" />
 			   </li>
 				       			 			   <li><label>开放时间<b></b></label>
 			   <input  type="text" class="dfinput" id="kfsj" name="skqJksjkz.kfsj" placeholder="请输入开放时间" value="${ skqJksjkz.kfsj}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqjksjkz/list'"/></li>
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
 			$('#skqJksjkzForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqJksjkz.id':'required;',
 			    	     			    	 			    		 			    			'skqJksjkz.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqJksjkz.tzyy':'required;',
 			    	     			    	 			    		 			    			'skqJksjkz.tzsj':'required;',
 			    	     			    	 			    		 			    			'skqJksjkz.cjz':'required;',
 			    	     			    	 			    		 			    			'skqJksjkz.status':'required;',
 			    	     			    	 			    		 			    			'skqJksjkz.kfsj':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqjksjkz/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqjksjkz/list';
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
 