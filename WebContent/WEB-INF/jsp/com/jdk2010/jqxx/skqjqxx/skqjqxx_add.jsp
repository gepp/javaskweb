<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>机器信息</title>
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
    <li><a href="#">机器信息</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">机器信息添加</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  	<form action="" method="POST"  id="skqJqxxForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqJqxx.id" placeholder="请输入id"  />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqJqxx.nsrwjbm" placeholder="请输入纳税人微机编码"  />
 			   </li>
 				       			 			   <li><label>机器型号编码<b></b></label>
 			   <input  type="text" class="dfinput" id="jqxhbm" name="skqJqxx.jqxhbm" placeholder="请输入机器型号编码"  />
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			   <input  type="text" class="dfinput" id="jqbh" name="skqJqxx.jqbh" placeholder="请输入机器编号"  />
 			   </li>
 				       			 			   <li><label>税控卡号<b></b></label>
 			   <input  type="text" class="dfinput" id="skkh" name="skqJqxx.skkh" placeholder="请输入税控卡号"  />
 			   </li>
 				       			 			   <li><label>用户卡号<b></b></label>
 			   <input  type="text" class="dfinput" id="yhkh" name="skqJqxx.yhkh" placeholder="请输入用户卡号"  />
 			   </li>
 				       			 			   <li><label>卡启用日期<b></b></label>
 			   <input  type="text" class="dfinput" id="kqyrq" name="skqJqxx.kqyrq" placeholder="请输入卡启用日期"  />
 			   </li>
 				       			 			   <li><label>卡有效日期<b></b></label>
 			   <input  type="text" class="dfinput" id="kyxrq" name="skqJqxx.kyxrq" placeholder="请输入卡有效日期"  />
 			   </li>
 				       			 			   <li><label>申报方式<b></b></label>
 			   <input  type="text" class="dfinput" id="sbfs" name="skqJqxx.sbfs" placeholder="请输入申报方式"  />
 			   </li>
 				       			 			   <li><label>明细申报标志<b></b></label>
 			   <input  type="text" class="dfinput" id="mxsbbz" name="skqJqxx.mxsbbz" placeholder="请输入明细申报标志"  />
 			   </li>
 				       			 			   <li><label>开票截止日期<b></b></label>
 			   <input  type="text" class="dfinput" id="kpjzrq" name="skqJqxx.kpjzrq" placeholder="请输入开票截止日期"  />
 			   </li>
 				       			 			   <li><label>单张开票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="dzkpxe" name="skqJqxx.dzkpxe" placeholder="请输入单张开票限额"  />
 			   </li>
 				       			 			   <li><label>月累计开票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="yljkpxe" name="skqJqxx.yljkpxe" placeholder="请输入月累计开票限额"  />
 			   </li>
 				       			 			   <li><label>月累计开票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="yljtpxe" name="skqJqxx.yljtpxe" placeholder="请输入月累计开票限额"  />
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			   <input  type="text" class="dfinput" id="status" name="skqJqxx.status" placeholder="请输入状态"  />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqjqxx/list'"/></li>
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
 			$('#skqJqxxForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqJqxx.id':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.jqxhbm':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.jqbh':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.skkh':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.yhkh':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.kqyrq':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.kyxrq':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.sbfs':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.mxsbbz':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.kpjzrq':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.dzkpxe':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.yljkpxe':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.yljtpxe':'required;',
 			    	     			    	 			    		 			    			'skqJqxx.status':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url:"${ contextpath}/skqjqxx/addaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqjqxx/list';
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
 