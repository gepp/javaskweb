<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>汇总数据明细</title>
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
    <li><a href="#">汇总数据明细</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">汇总数据明细添加</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  	<form action="" method="POST"  id="skqHzsjmxForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqHzsjmx.id" placeholder="请输入id"  />
 			   </li>
 				       			 			   <li><label>申报汇总ID<b></b></label>
 			   <input  type="text" class="dfinput" id="parentid" name="skqHzsjmx.parentid" placeholder="请输入申报汇总ID"  />
 			   </li>
 				       			 			   <li><label>税目编码<b></b></label>
 			   <input  type="text" class="dfinput" id="smbm" name="skqHzsjmx.smbm" placeholder="请输入税目编码"  />
 			   </li>
 				       			 			   <li><label>开票金额<b></b></label>
 			   <input  type="text" class="dfinput" id="kpje" name="skqHzsjmx.kpje" placeholder="请输入开票金额"  />
 			   </li>
 				       			 			   <li><label>抵扣金额<b></b></label>
 			   <input  type="text" class="dfinput" id="dkje" name="skqHzsjmx.dkje" placeholder="请输入抵扣金额"  />
 			   </li>
 				       			 			   <li><label>月核定营业额<b></b></label>
 			   <input  type="text" class="dfinput" id="yhdyye" name="skqHzsjmx.yhdyye" placeholder="请输入月核定营业额"  />
 			   </li>
 				       			 			   <li><label>标示<b></b></label>
 			   <input  type="text" class="dfinput" id="flag" name="skqHzsjmx.flag" placeholder="请输入标示"  />
 			   </li>
 				       			 			   <li><label>申报金额<b></b></label>
 			   <input  type="text" class="dfinput" id="sbje" name="skqHzsjmx.sbje" placeholder="请输入申报金额"  />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqhzsjmx/list'"/></li>
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
 			$('#skqHzsjmxForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqHzsjmx.id':'required;',
 			    	     			    	 			    		 			    			'skqHzsjmx.parentid':'required;',
 			    	     			    	 			    		 			    			'skqHzsjmx.smbm':'required;',
 			    	     			    	 			    		 			    			'skqHzsjmx.kpje':'required;',
 			    	     			    	 			    		 			    			'skqHzsjmx.dkje':'required;',
 			    	     			    	 			    		 			    			'skqHzsjmx.yhdyye':'required;',
 			    	     			    	 			    		 			    			'skqHzsjmx.flag':'required;',
 			    	     			    	 			    		 			    			'skqHzsjmx.sbje':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url:"${ contextpath}/skqhzsjmx/addaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqhzsjmx/list';
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
 