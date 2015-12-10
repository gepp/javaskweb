<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发票开具</title>
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
    <li><a href="#">发票开具</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发票开具添加</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  	<form action="" method="POST"  id="skqFpkjForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqFpkj.id" placeholder="请输入id"  />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqFpkj.nsrwjbm" placeholder="请输入纳税人微机编码"  />
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			   <input  type="text" class="dfinput" id="jqbh" name="skqFpkj.jqbh" placeholder="请输入机器编号"  />
 			   </li>
 				       			 			   <li><label>开票日期<b></b></label>
 			   <input  type="text" class="dfinput" id="kprq" name="skqFpkj.kprq" placeholder="请输入开票日期"  />
 			   </li>
 				       			 			   <li><label>开票类型<b></b></label>
 			   <input  type="text" class="dfinput" id="kplx" name="skqFpkj.kplx" placeholder="请输入开票类型"  />
 			   </li>
 				       			 			   <li><label>发票代码<b></b></label>
 			   <input  type="text" class="dfinput" id="fpdm" name="skqFpkj.fpdm" placeholder="请输入发票代码"  />
 			   </li>
 				       			 			   <li><label>发票号码<b></b></label>
 			   <input  type="text" class="dfinput" id="fphm" name="skqFpkj.fphm" placeholder="请输入发票号码"  />
 			   </li>
 				       			 			   <li><label>开票金额<b></b></label>
 			   <input  type="text" class="dfinput" id="hjzje" name="skqFpkj.hjzje" placeholder="请输入开票金额"  />
 			   </li>
 				       			 			   <li><label>原发票号码<b></b></label>
 			   <input  type="text" class="dfinput" id="yfphm" name="skqFpkj.yfphm" placeholder="请输入原发票号码"  />
 			   </li>
 				       			 			   <li><label>付款单位<b></b></label>
 			   <input  type="text" class="dfinput" id="fkdw" name="skqFpkj.fkdw" placeholder="请输入付款单位"  />
 			   </li>
 				       			 			   <li><label>收款员<b></b></label>
 			   <input  type="text" class="dfinput" id="sky" name="skqFpkj.sky" placeholder="请输入收款员"  />
 			   </li>
 				       			 			   <li><label>项目数<b></b></label>
 			   <input  type="text" class="dfinput" id="xms" name="skqFpkj.xms" placeholder="请输入项目数"  />
 			   </li>
 				       			 			   <li><label>税控码<b></b></label>
 			   <input  type="text" class="dfinput" id="skm" name="skqFpkj.skm" placeholder="请输入税控码"  />
 			   </li>
 				       			 			   <li><label>确认标志<b></b></label>
 			   <input  type="text" class="dfinput" id="qrbz" name="skqFpkj.qrbz" placeholder="请输入确认标志"  />
 			   </li>
 				       			 			   <li><label>状态<b></b></label>
 			   <input  type="text" class="dfinput" id="status" name="skqFpkj.status" placeholder="请输入状态"  />
 			   </li>
 				       			 			   <li><label>上传时间<b></b></label>
 			   <input  type="text" class="dfinput" id="scsj" name="skqFpkj.scsj" placeholder="请输入上传时间"  />
 			   </li>
 				       			 			   <li><label>备注<b></b></label>
 			   <input  type="text" class="dfinput" id="bz" name="skqFpkj.bz" placeholder="请输入备注"  />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqfpkj/list'"/></li>
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
 			$('#skqFpkjForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqFpkj.id':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.jqbh':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.kprq':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.kplx':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.fpdm':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.fphm':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.hjzje':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.yfphm':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.fkdw':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.sky':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.xms':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.skm':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.qrbz':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.status':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.scsj':'required;',
 			    	     			    	 			    		 			    			'skqFpkj.bz':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url:"${ contextpath}/skqfpkj/addaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqfpkj/list';
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
 