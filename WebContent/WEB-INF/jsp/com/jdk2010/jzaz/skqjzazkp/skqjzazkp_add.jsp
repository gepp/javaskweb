<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建筑安装开票</title>
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
    <li><a href="#">建筑安装开票</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">建筑安装开票添加</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  	<form action="" method="POST"  id="skqJzazkpForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqJzazkp.id" placeholder="请输入id"  />
 			   </li>
 				       			 			   <li><label>项目ID<b></b></label>
 			   <input  type="text" class="dfinput" id="parentid" name="skqJzazkp.parentid" placeholder="请输入项目ID"  />
 			   </li>
 				       			 			   <li><label>款项性质<b></b></label>
 			   <input  type="text" class="dfinput" id="kxxz" name="skqJzazkp.kxxz" placeholder="请输入款项性质"  />
 			   </li>
 				       			 			   <li><label>发票代码<b></b></label>
 			   <input  type="text" class="dfinput" id="fpdm" name="skqJzazkp.fpdm" placeholder="请输入发票代码"  />
 			   </li>
 				       			 			   <li><label>发票号码<b></b></label>
 			   <input  type="text" class="dfinput" id="fphm" name="skqJzazkp.fphm" placeholder="请输入发票号码"  />
 			   </li>
 				       			 			   <li><label>开票类型<b></b></label>
 			   <input  type="text" class="dfinput" id="kplx" name="skqJzazkp.kplx" placeholder="请输入开票类型"  />
 			   </li>
 				       			 			   <li><label>开票金额<b></b></label>
 			   <input  type="text" class="dfinput" id="hjzje" name="skqJzazkp.hjzje" placeholder="请输入开票金额"  />
 			   </li>
 				       			 			   <li><label>开票日期<b></b></label>
 			   <input  type="text" class="dfinput" id="kprq" name="skqJzazkp.kprq" placeholder="请输入开票日期"  />
 			   </li>
 				       			 			   <li><label>上传日期<b></b></label>
 			   <input  type="text" class="dfinput" id="scrq" name="skqJzazkp.scrq" placeholder="请输入上传日期"  />
 			   </li>
 				       			 			   <li><label>JSXM<b></b></label>
 			   <input  type="text" class="dfinput" id="jsxm" name="skqJzazkp.jsxm" placeholder="请输入JSXM"  />
 			   </li>
 				       			 			   <li><label>SFDK<b></b></label>
 			   <input  type="text" class="dfinput" id="sfdk" name="skqJzazkp.sfdk" placeholder="请输入SFDK"  />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqjzazkp/list'"/></li>
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
 			$('#skqJzazkpForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqJzazkp.id':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.parentid':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.kxxz':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.fpdm':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.fphm':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.kplx':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.hjzje':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.kprq':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.scrq':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.jsxm':'required;',
 			    	     			    	 			    		 			    			'skqJzazkp.sfdk':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url:"${ contextpath}/skqjzazkp/addaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqjzazkp/list';
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
 