<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申报汇总数据税款计算</title>
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
    <li><a href="#">申报汇总数据税款计算</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">申报汇总数据税款计算添加</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  	<form action="" method="POST"  id="skqSkjsForm">
									 
					 			   <li><label>ID<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqSkjs.id" placeholder="请输入ID"  />
 			   </li>
 				       			 			   <li><label>申报汇总ID<b></b></label>
 			   <input  type="text" class="dfinput" id="parentid" name="skqSkjs.parentid" placeholder="请输入申报汇总ID"  />
 			   </li>
 				       			 			   <li><label>税种编码<b></b></label>
 			   <input  type="text" class="dfinput" id="szbm" name="skqSkjs.szbm" placeholder="请输入税种编码"  />
 			   </li>
 				       			 			   <li><label>税目编码<b></b></label>
 			   <input  type="text" class="dfinput" id="smbm" name="skqSkjs.smbm" placeholder="请输入税目编码"  />
 			   </li>
 				       			 			   <li><label>计税金额<b></b></label>
 			   <input  type="text" class="dfinput" id="jsje" name="skqSkjs.jsje" placeholder="请输入计税金额"  />
 			   </li>
 				       			 			   <li><label>税率<b></b></label>
 			   <input  type="text" class="dfinput" id="sl" name="skqSkjs.sl" placeholder="请输入税率"  />
 			   </li>
 				       			 			   <li><label>应计税额<b></b></label>
 			   <input  type="text" class="dfinput" id="yjse" name="skqSkjs.yjse" placeholder="请输入应计税额"  />
 			   </li>
 				       			 			   <li><label>处理方式<b></b></label>
 			   <input  type="text" class="dfinput" id="clfs" name="skqSkjs.clfs" placeholder="请输入处理方式"  />
 			   </li>
 				       			 			   <li><label>处理标示<b></b></label>
 			   <input  type="text" class="dfinput" id="clbs" name="skqSkjs.clbs" placeholder="请输入处理标示"  />
 			   </li>
 				       			 			   <li><label>申报时间<b></b></label>
 			   <input  type="text" class="dfinput" id="sbsj" name="skqSkjs.sbsj" placeholder="请输入申报时间"  />
 			   </li>
 				       			 			   <li><label>申报文档号<b></b></label>
 			   <input  type="text" class="dfinput" id="sbwdh" name="skqSkjs.sbwdh" placeholder="请输入申报文档号"  />
 			   </li>
 				       			 			   <li><label>票表比对<b></b></label>
 			   <input  type="text" class="dfinput" id="pbbd" name="skqSkjs.pbbd" placeholder="请输入票表比对"  />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqskjs/list'"/></li>
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
 			$('#skqSkjsForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqSkjs.id':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.parentid':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.szbm':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.smbm':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.jsje':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.sl':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.yjse':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.clfs':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.clbs':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.sbsj':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.sbwdh':'required;',
 			    	     			    	 			    		 			    			'skqSkjs.pbbd':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url:"${ contextpath}/skqskjs/addaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqskjs/list';
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
 