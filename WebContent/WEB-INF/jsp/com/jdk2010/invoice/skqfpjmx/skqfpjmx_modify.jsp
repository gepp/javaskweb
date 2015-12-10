<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发票卷明细</title>
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
    <li><a href="#">发票卷明细</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发票卷明细编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqFpjmxForm">
									 
					 			   <li><label>ID<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqFpjmx.id" placeholder="请输入ID" value="${ skqFpjmx.id}" />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqFpjmx.nsrwjbm" placeholder="请输入纳税人微机编码" value="${ skqFpjmx.nsrwjbm}" />
 			   </li>
 				       			 			   <li><label>发票编码<b></b></label>
 			   <input  type="text" class="dfinput" id="fpbm" name="skqFpjmx.fpbm" placeholder="请输入发票编码" value="${ skqFpjmx.fpbm}" />
 			   </li>
 				       			 			   <li><label>发票编码<b></b></label>
 			   <input  type="text" class="dfinput" id="fpdm" name="skqFpjmx.fpdm" placeholder="请输入发票编码" value="${ skqFpjmx.fpdm}" />
 			   </li>
 				       			 			   <li><label>发票起始号<b></b></label>
 			   <input  type="text" class="dfinput" id="fpqsh" name="skqFpjmx.fpqsh" placeholder="请输入发票起始号" value="${ skqFpjmx.fpqsh}" />
 			   </li>
 				       			 			   <li><label>发票截止号<b></b></label>
 			   <input  type="text" class="dfinput" id="fpjzh" name="skqFpjmx.fpjzh" placeholder="请输入发票截止号" value="${ skqFpjmx.fpjzh}" />
 			   </li>
 				       			 			   <li><label>发票单位<b></b></label>
 			   <input  type="text" class="dfinput" id="fpdw" name="skqFpjmx.fpdw" placeholder="请输入发票单位" value="${ skqFpjmx.fpdw}" />
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			   <input  type="text" class="dfinput" id="jqbh" name="skqFpjmx.jqbh" placeholder="请输入机器编号" value="${ skqFpjmx.jqbh}" />
 			   </li>
 				       			 			   <li><label>发票下发状态<b></b></label>
 			   <input  type="text" class="dfinput" id="fpxfzt" name="skqFpjmx.fpxfzt" placeholder="请输入发票下发状态" value="${ skqFpjmx.fpxfzt}" />
 			   </li>
 				       			 			   <li><label>发票领购状态<b></b></label>
 			   <input  type="text" class="dfinput" id="fplgzt" name="skqFpjmx.fplgzt" placeholder="请输入发票领购状态" value="${ skqFpjmx.fplgzt}" />
 			   </li>
 				       			 			   <li><label>明细上传状态<b></b></label>
 			   <input  type="text" class="dfinput" id="mxsczt" name="skqFpjmx.mxsczt" placeholder="请输入明细上传状态" value="${ skqFpjmx.mxsczt}" />
 			   </li>
 				       			 			   <li><label>发票领购日期<b></b></label>
 			   <input  type="text" class="dfinput" id="fplgrq" name="skqFpjmx.fplgrq" placeholder="请输入发票领购日期" value="${ skqFpjmx.fplgrq}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqfpjmx/list'"/></li>
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
 			$('#skqFpjmxForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqFpjmx.id':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.fpbm':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.fpdm':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.fpqsh':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.fpjzh':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.fpdw':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.jqbh':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.fpxfzt':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.fplgzt':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.mxsczt':'required;',
 			    	     			    	 			    		 			    			'skqFpjmx.fplgrq':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqfpjmx/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqfpjmx/list';
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
 