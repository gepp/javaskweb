<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申报核定户异常警告</title>
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
    <li><a href="#">申报核定户异常警告</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">申报核定户异常警告编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqSbhdhjgForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqSbhdhjg.id" placeholder="请输入id" value="${ skqSbhdhjg.id}" />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqSbhdhjg.nsrwjbm" placeholder="请输入纳税人微机编码" value="${ skqSbhdhjg.nsrwjbm}" />
 			   </li>
 				       			 			   <li><label>年份<b></b></label>
 			   <input  type="text" class="dfinput" id="year" name="skqSbhdhjg.year" placeholder="请输入年份" value="${ skqSbhdhjg.year}" />
 			   </li>
 				       			 			   <li><label>月份<b></b></label>
 			   <input  type="text" class="dfinput" id="month" name="skqSbhdhjg.month" placeholder="请输入月份" value="${ skqSbhdhjg.month}" />
 			   </li>
 				       			 			   <li><label>创建时间<b></b></label>
 			   <input  type="text" class="dfinput" id="cjsj" name="skqSbhdhjg.cjsj" placeholder="请输入创建时间" value="${ skqSbhdhjg.cjsj}" />
 			   </li>
 				       			 			   <li><label>处理标示<b></b></label>
 			   <input  type="text" class="dfinput" id="clbz" name="skqSbhdhjg.clbz" placeholder="请输入处理标示" value="${ skqSbhdhjg.clbz}" />
 			   </li>
 				       			 			   <li><label>处理时间<b></b></label>
 			   <input  type="text" class="dfinput" id="clz" name="skqSbhdhjg.clz" placeholder="请输入处理时间" value="${ skqSbhdhjg.clz}" />
 			   </li>
 				       			 			   <li><label>处理者<b></b></label>
 			   <input  type="text" class="dfinput" id="clsj" name="skqSbhdhjg.clsj" placeholder="请输入处理者" value="${ skqSbhdhjg.clsj}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqsbhdhjg/list'"/></li>
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
 			$('#skqSbhdhjgForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqSbhdhjg.id':'required;',
 			    	     			    	 			    		 			    			'skqSbhdhjg.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqSbhdhjg.year':'required;',
 			    	     			    	 			    		 			    			'skqSbhdhjg.month':'required;',
 			    	     			    	 			    		 			    			'skqSbhdhjg.cjsj':'required;',
 			    	     			    	 			    		 			    			'skqSbhdhjg.clbz':'required;',
 			    	     			    	 			    		 			    			'skqSbhdhjg.clz':'required;',
 			    	     			    	 			    		 			    			'skqSbhdhjg.clsj':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqsbhdhjg/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqsbhdhjg/list';
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
 