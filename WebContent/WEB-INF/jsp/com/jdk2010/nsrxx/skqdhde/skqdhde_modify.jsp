<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>单户定额调整</title>
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
    <li><a href="#">单户定额调整</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">单户定额调整编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqDhdeForm">
									 
					 			   <li><label>ID<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqDhde.id" placeholder="请输入ID" value="${ skqDhde.id}" />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqDhde.nsrwjbm" placeholder="请输入纳税人微机编码" value="${ skqDhde.nsrwjbm}" />
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			   <input  type="text" class="dfinput" id="jqbh" name="skqDhde.jqbh" placeholder="请输入机器编号" value="${ skqDhde.jqbh}" />
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			   <input  type="text" class="dfinput" id="dzkpxe" name="skqDhde.dzkpxe" placeholder="请输入机器编号" value="${ skqDhde.dzkpxe}" />
 			   </li>
 				       			 			   <li><label>月累计开票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="yljkpxe" name="skqDhde.yljkpxe" placeholder="请输入月累计开票限额" value="${ skqDhde.yljkpxe}" />
 			   </li>
 				       			 			   <li><label>月累计开票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="yljtpxe" name="skqDhde.yljtpxe" placeholder="请输入月累计开票限额" value="${ skqDhde.yljtpxe}" />
 			   </li>
 				       			 			   <li><label>启用标示<b></b></label>
 			   <input  type="text" class="dfinput" id="qybz" name="skqDhde.qybz" placeholder="请输入启用标示" value="${ skqDhde.qybz}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqdhde/list'"/></li>
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
 			$('#skqDhdeForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqDhde.id':'required;',
 			    	     			    	 			    		 			    			'skqDhde.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqDhde.jqbh':'required;',
 			    	     			    	 			    		 			    			'skqDhde.dzkpxe':'required;',
 			    	     			    	 			    		 			    			'skqDhde.yljkpxe':'required;',
 			    	     			    	 			    		 			    			'skqDhde.yljtpxe':'required;',
 			    	     			    	 			    		 			    			'skqDhde.qybz':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqdhde/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqdhde/list';
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
 