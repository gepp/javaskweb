<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>纳税人信息</title>
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
    <li><a href="#">纳税人信息</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">纳税人信息编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqNsrxxForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqNsrxx.id" placeholder="请输入id" value="${ skqNsrxx.id}" />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqNsrxx.nsrwjbm" placeholder="请输入纳税人微机编码" value="${ skqNsrxx.nsrwjbm}" />
 			   </li>
 				       			 			   <li><label>纳税人识别号<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrsbh" name="skqNsrxx.nsrsbh" placeholder="请输入纳税人识别号" value="${ skqNsrxx.nsrsbh}" />
 			   </li>
 				       			 			   <li><label>纳税人名称<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrmc" name="skqNsrxx.nsrmc" placeholder="请输入纳税人名称" value="${ skqNsrxx.nsrmc}" />
 			   </li>
 				       			 			   <li><label>经营地址<b></b></label>
 			   <input  type="text" class="dfinput" id="jydz" name="skqNsrxx.jydz" placeholder="请输入经营地址" value="${ skqNsrxx.jydz}" />
 			   </li>
 				       			 			   <li><label>法人代表<b></b></label>
 			   <input  type="text" class="dfinput" id="frdb" name="skqNsrxx.frdb" placeholder="请输入法人代表" value="${ skqNsrxx.frdb}" />
 			   </li>
 				       			 			   <li><label>注册类型编码<b></b></label>
 			   <input  type="text" class="dfinput" id="zclxbm" name="skqNsrxx.zclxbm" placeholder="请输入注册类型编码" value="${ skqNsrxx.zclxbm}" />
 			   </li>
 				       			 			   <li><label>行业编码<b></b></label>
 			   <input  type="text" class="dfinput" id="hybm" name="skqNsrxx.hybm" placeholder="请输入行业编码" value="${ skqNsrxx.hybm}" />
 			   </li>
 				       			 			   <li><label>行业明细编码<b></b></label>
 			   <input  type="text" class="dfinput" id="hymxbm" name="skqNsrxx.hymxbm" placeholder="请输入行业明细编码" value="${ skqNsrxx.hymxbm}" />
 			   </li>
 				       			 			   <li><label>征收方式<b></b></label>
 			   <input  type="text" class="dfinput" id="zsfs" name="skqNsrxx.zsfs" placeholder="请输入征收方式" value="${ skqNsrxx.zsfs}" />
 			   </li>
 				       			 			   <li><label>月核定营业额<b></b></label>
 			   <input  type="text" class="dfinput" id="yhde" name="skqNsrxx.yhde" placeholder="请输入月核定营业额" value="${ skqNsrxx.yhde}" />
 			   </li>
 				       			 			   <li><label>税务机关编码<b></b></label>
 			   <input  type="text" class="dfinput" id="swjgbm" name="skqNsrxx.swjgbm" placeholder="请输入税务机关编码" value="${ skqNsrxx.swjgbm}" />
 			   </li>
 				       			 			   <li><label>办税员<b></b></label>
 			   <input  type="text" class="dfinput" id="bsy" name="skqNsrxx.bsy" placeholder="请输入办税员" value="${ skqNsrxx.bsy}" />
 			   </li>
 				       			 			   <li><label>联系方式<b></b></label>
 			   <input  type="text" class="dfinput" id="ssgly" name="skqNsrxx.ssgly" placeholder="请输入联系方式" value="${ skqNsrxx.ssgly}" />
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			   <input  type="text" class="dfinput" id="status" name="skqNsrxx.status" placeholder="请输入状态" value="${ skqNsrxx.status}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqnsrxx/list'"/></li>
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
 			$('#skqNsrxxForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqNsrxx.id':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.nsrsbh':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.nsrmc':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.jydz':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.frdb':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.zclxbm':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.hybm':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.hymxbm':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.zsfs':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.yhde':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.swjgbm':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.bsy':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.ssgly':'required;',
 			    	     			    	 			    		 			    			'skqNsrxx.status':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqnsrxx/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	sAlert('当前操作成功');
 			                	sOpen('${ contextpath}/skqnsrxx/list');
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
 