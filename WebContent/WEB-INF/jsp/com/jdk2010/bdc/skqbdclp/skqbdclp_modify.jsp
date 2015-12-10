<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产楼盘</title>
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
    <li><a href="#">不动产楼盘</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">不动产楼盘编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqBdclpForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqBdclp.id" placeholder="请输入id" value="${ skqBdclp.id}" />
 			   </li>
 				       			 			   <li><label>项目明细ID<b></b></label>
 			   <input  type="text" class="dfinput" id="parentid" name="skqBdclp.parentid" placeholder="请输入项目明细ID" value="${ skqBdclp.parentid}" />
 			   </li>
 				       			 			   <li><label>楼牌号<b></b></label>
 			   <input  type="text" class="dfinput" id="lpmc" name="skqBdclp.lpmc" placeholder="请输入楼牌号" value="${ skqBdclp.lpmc}" />
 			   </li>
 				       			 			   <li><label>楼层<b></b></label>
 			   <input  type="text" class="dfinput" id="lc" name="skqBdclp.lc" placeholder="请输入楼层" value="${ skqBdclp.lc}" />
 			   </li>
 				       			 			   <li><label>楼牌序号<b></b></label>
 			   <input  type="text" class="dfinput" id="lpxh" name="skqBdclp.lpxh" placeholder="请输入楼牌序号" value="${ skqBdclp.lpxh}" />
 			   </li>
 				       			 			   <li><label>面积<b></b></label>
 			   <input  type="text" class="dfinput" id="mj" name="skqBdclp.mj" placeholder="请输入面积" value="${ skqBdclp.mj}" />
 			   </li>
 				       			 			   <li><label>单价<b></b></label>
 			   <input  type="text" class="dfinput" id="dj" name="skqBdclp.dj" placeholder="请输入单价" value="${ skqBdclp.dj}" />
 			   </li>
 				       			 			   <li><label>类型<b></b></label>
 			   <input  type="text" class="dfinput" id="lx" name="skqBdclp.lx" placeholder="请输入类型" value="${ skqBdclp.lx}" />
 			   </li>
 				       			 			   <li><label>创建时间<b></b></label>
 			   <input  type="text" class="dfinput" id="cjsj" name="skqBdclp.cjsj" placeholder="请输入创建时间" value="${ skqBdclp.cjsj}" />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqBdclp.nsrwjbm" placeholder="请输入纳税人微机编码" value="${ skqBdclp.nsrwjbm}" />
 			   </li>
 				       			 			   <li><label>已开金额<b></b></label>
 			   <input  type="text" class="dfinput" id="ykje" name="skqBdclp.ykje" placeholder="请输入已开金额" value="${ skqBdclp.ykje}" />
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			   <input  type="text" class="dfinput" id="status" name="skqBdclp.status" placeholder="请输入状态" value="${ skqBdclp.status}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqbdclp/list'"/></li>
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
 			$('#skqBdclpForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqBdclp.id':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.parentid':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.lpmc':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.lc':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.lpxh':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.mj':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.dj':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.lx':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.cjsj':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.ykje':'required;',
 			    	     			    	 			    		 			    			'skqBdclp.status':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqbdclp/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqbdclp/list';
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
 