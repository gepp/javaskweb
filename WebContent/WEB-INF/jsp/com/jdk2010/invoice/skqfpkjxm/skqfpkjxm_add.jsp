<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发票开具项目</title>
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
    <li><a href="#">发票开具项目</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发票开具项目添加</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  	<form action="" method="POST"  id="skqFpkjxmForm">
									 
					 			   <li><label>ID<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqFpkjxm.id" placeholder="请输入ID"  />
 			   </li>
 				       			 			   <li><label>发票开具ID<b></b></label>
 			   <input  type="text" class="dfinput" id="parentid" name="skqFpkjxm.parentid" placeholder="请输入发票开具ID"  />
 			   </li>
 				       			 			   <li><label>项目名称<b></b></label>
 			   <input  type="text" class="dfinput" id="xmmc" name="skqFpkjxm.xmmc" placeholder="请输入项目名称"  />
 			   </li>
 				       			 			   <li><label>小数位数<b></b></label>
 			   <input  type="text" class="dfinput" id="xsws" name="skqFpkjxm.xsws" placeholder="请输入小数位数"  />
 			   </li>
 				       			 			   <li><label>数量<b></b></label>
 			   <input  type="text" class="dfinput" id="sl" name="skqFpkjxm.sl" placeholder="请输入数量"  />
 			   </li>
 				       			 			   <li><label>单价<b></b></label>
 			   <input  type="text" class="dfinput" id="dj" name="skqFpkjxm.dj" placeholder="请输入单价"  />
 			   </li>
 				       			 			   <li><label>金额<b></b></label>
 			   <input  type="text" class="dfinput" id="je" name="skqFpkjxm.je" placeholder="请输入金额"  />
 			   </li>
 				       			 			   <li><label>税目编码<b></b></label>
 			   <input  type="text" class="dfinput" id="smbm" name="skqFpkjxm.smbm" placeholder="请输入税目编码"  />
 			   </li>
 				       			 			   <li><label>计税项目<b></b></label>
 			   <input  type="text" class="dfinput" id="jsxm" name="skqFpkjxm.jsxm" placeholder="请输入计税项目"  />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqfpkjxm/list'"/></li>
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
 			$('#skqFpkjxmForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqFpkjxm.id':'required;',
 			    	     			    	 			    		 			    			'skqFpkjxm.parentid':'required;',
 			    	     			    	 			    		 			    			'skqFpkjxm.xmmc':'required;',
 			    	     			    	 			    		 			    			'skqFpkjxm.xsws':'required;',
 			    	     			    	 			    		 			    			'skqFpkjxm.sl':'required;',
 			    	     			    	 			    		 			    			'skqFpkjxm.dj':'required;',
 			    	     			    	 			    		 			    			'skqFpkjxm.je':'required;',
 			    	     			    	 			    		 			    			'skqFpkjxm.smbm':'required;',
 			    	     			    	 			    		 			    			'skqFpkjxm.jsxm':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url:"${ contextpath}/skqfpkjxm/addaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqfpkjxm/list';
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
 