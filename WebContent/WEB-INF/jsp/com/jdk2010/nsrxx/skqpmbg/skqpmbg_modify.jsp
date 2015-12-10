<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>品目变更</title>
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
    <li><a href="#">品目变更</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">品目变更编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqPmbgForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqPmbg.id" placeholder="请输入id" value="${ skqPmbg.id}" />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqPmbg.nsrwjbm" placeholder="请输入纳税人微机编码" value="${ skqPmbg.nsrwjbm}" />
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			   <input  type="text" class="dfinput" id="jqbh" name="skqPmbg.jqbh" placeholder="请输入机器编号" value="${ skqPmbg.jqbh}" />
 			   </li>
 				       			 			   <li><label>原税目编码<b></b></label>
 			   <input  type="text" class="dfinput" id="ysmbm" name="skqPmbg.ysmbm" placeholder="请输入原税目编码" value="${ skqPmbg.ysmbm}" />
 			   </li>
 				       			 			   <li><label>变更税目编码<b></b></label>
 			   <input  type="text" class="dfinput" id="bgsmbm" name="skqPmbg.bgsmbm" placeholder="请输入变更税目编码" value="${ skqPmbg.bgsmbm}" />
 			   </li>
 				       			 			   <li><label>变更说明<b></b></label>
 			   <input  type="text" class="dfinput" id="bgsm" name="skqPmbg.bgsm" placeholder="请输入变更说明" value="${ skqPmbg.bgsm}" />
 			   </li>
 				       			 			   <li><label>申请时间<b></b></label>
 			   <input  type="text" class="dfinput" id="sqsj" name="skqPmbg.sqsj" placeholder="请输入申请时间" value="${ skqPmbg.sqsj}" />
 			   </li>
 				       			 			   <li><label>申请时间<b></b></label>
 			   <input  type="text" class="dfinput" id="clbz" name="skqPmbg.clbz" placeholder="请输入申请时间" value="${ skqPmbg.clbz}" />
 			   </li>
 				       			 			   <li><label>处理者<b></b></label>
 			   <input  type="text" class="dfinput" id="clz" name="skqPmbg.clz" placeholder="请输入处理者" value="${ skqPmbg.clz}" />
 			   </li>
 				       			 			   <li><label>处理意见<b></b></label>
 			   <input  type="text" class="dfinput" id="clyj" name="skqPmbg.clyj" placeholder="请输入处理意见" value="${ skqPmbg.clyj}" />
 			   </li>
 				       			 			   <li><label>处理意见<b></b></label>
 			   <input  type="text" class="dfinput" id="clsj" name="skqPmbg.clsj" placeholder="请输入处理意见" value="${ skqPmbg.clsj}" />
 			   </li>
 				       			 			   <li><label>处理意见<b></b></label>
 			   <input  type="text" class="dfinput" id="xzbs" name="skqPmbg.xzbs" placeholder="请输入处理意见" value="${ skqPmbg.xzbs}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqpmbg/list'"/></li>
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
 			$('#skqPmbgForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqPmbg.id':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.jqbh':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.ysmbm':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.bgsmbm':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.bgsm':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.sqsj':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.clbz':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.clz':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.clyj':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.clsj':'required;',
 			    	     			    	 			    		 			    			'skqPmbg.xzbs':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqpmbg/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqpmbg/list';
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
 