<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>限额变更</title>
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
    <li><a href="#">限额变更</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">限额变更编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqXebgForm">
									 
					 			   <li><label>ID<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqXebg.id" placeholder="请输入ID" value="${ skqXebg.id}" />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqXebg.nsrwjbm" placeholder="请输入纳税人微机编码" value="${ skqXebg.nsrwjbm}" />
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			   <input  type="text" class="dfinput" id="jqbh" name="skqXebg.jqbh" placeholder="请输入机器编号" value="${ skqXebg.jqbh}" />
 			   </li>
 				       			 			   <li><label>剩余累计开票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="syljkpxe" name="skqXebg.syljkpxe" placeholder="请输入剩余累计开票限额" value="${ skqXebg.syljkpxe}" />
 			   </li>
 				       			 			   <li><label>剩余累计退票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="syljtpxe" name="skqXebg.syljtpxe" placeholder="请输入剩余累计退票限额" value="${ skqXebg.syljtpxe}" />
 			   </li>
 				       			 			   <li><label>申请累计开票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="sqljkpxe" name="skqXebg.sqljkpxe" placeholder="请输入申请累计开票限额" value="${ skqXebg.sqljkpxe}" />
 			   </li>
 				       			 			   <li><label>申请累计退票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="sqljtpxe" name="skqXebg.sqljtpxe" placeholder="请输入申请累计退票限额" value="${ skqXebg.sqljtpxe}" />
 			   </li>
 				       			 			   <li><label>申请累计退票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="pzljkpxe" name="skqXebg.pzljkpxe" placeholder="请输入申请累计退票限额" value="${ skqXebg.pzljkpxe}" />
 			   </li>
 				       			 			   <li><label>批准累计退票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="pzljtpxe" name="skqXebg.pzljtpxe" placeholder="请输入批准累计退票限额" value="${ skqXebg.pzljtpxe}" />
 			   </li>
 				       			 			   <li><label>变更说明<b></b></label>
 			   <input  type="text" class="dfinput" id="bgsm" name="skqXebg.bgsm" placeholder="请输入变更说明" value="${ skqXebg.bgsm}" />
 			   </li>
 				       			 			   <li><label>申请时间<b></b></label>
 			   <input  type="text" class="dfinput" id="sqsj" name="skqXebg.sqsj" placeholder="请输入申请时间" value="${ skqXebg.sqsj}" />
 			   </li>
 				       			 			   <li><label>处理标示<b></b></label>
 			   <input  type="text" class="dfinput" id="clbz" name="skqXebg.clbz" placeholder="请输入处理标示" value="${ skqXebg.clbz}" />
 			   </li>
 				       			 			   <li><label>处理者<b></b></label>
 			   <input  type="text" class="dfinput" id="clz" name="skqXebg.clz" placeholder="请输入处理者" value="${ skqXebg.clz}" />
 			   </li>
 				       			 			   <li><label>处理意见<b></b></label>
 			   <input  type="text" class="dfinput" id="clyj" name="skqXebg.clyj" placeholder="请输入处理意见" value="${ skqXebg.clyj}" />
 			   </li>
 				       			 			   <li><label>处理时间<b></b></label>
 			   <input  type="text" class="dfinput" id="clsj" name="skqXebg.clsj" placeholder="请输入处理时间" value="${ skqXebg.clsj}" />
 			   </li>
 				       			 			   <li><label>下载标示<b></b></label>
 			   <input  type="text" class="dfinput" id="xzbs" name="skqXebg.xzbs" placeholder="请输入下载标示" value="${ skqXebg.xzbs}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqxebg/list'"/></li>
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
 			$('#skqXebgForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqXebg.id':'required;',
 			    	     			    	 			    		 			    			'skqXebg.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqXebg.jqbh':'required;',
 			    	     			    	 			    		 			    			'skqXebg.syljkpxe':'required;',
 			    	     			    	 			    		 			    			'skqXebg.syljtpxe':'required;',
 			    	     			    	 			    		 			    			'skqXebg.sqljkpxe':'required;',
 			    	     			    	 			    		 			    			'skqXebg.sqljtpxe':'required;',
 			    	     			    	 			    		 			    			'skqXebg.pzljkpxe':'required;',
 			    	     			    	 			    		 			    			'skqXebg.pzljtpxe':'required;',
 			    	     			    	 			    		 			    			'skqXebg.bgsm':'required;',
 			    	     			    	 			    		 			    			'skqXebg.sqsj':'required;',
 			    	     			    	 			    		 			    			'skqXebg.clbz':'required;',
 			    	     			    	 			    		 			    			'skqXebg.clz':'required;',
 			    	     			    	 			    		 			    			'skqXebg.clyj':'required;',
 			    	     			    	 			    		 			    			'skqXebg.clsj':'required;',
 			    	     			    	 			    		 			    			'skqXebg.xzbs':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqxebg/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqxebg/list';
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
 