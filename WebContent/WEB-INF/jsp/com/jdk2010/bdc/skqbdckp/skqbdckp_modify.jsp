<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产开票</title>
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
    <li><a href="#">不动产开票</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">不动产开票编辑</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  <form action="" method="POST"  id="skqBdckpForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqBdckp.id" placeholder="请输入id" value="${ skqBdckp.id}" />
 			   </li>
 				       			 			   <li><label>楼牌ID<b></b></label>
 			   <input  type="text" class="dfinput" id="parentid" name="skqBdckp.parentid" placeholder="请输入楼牌ID" value="${ skqBdckp.parentid}" />
 			   </li>
 				       			 			   <li><label>楼牌号<b></b></label>
 			   <input  type="text" class="dfinput" id="lpmc" name="skqBdckp.lpmc" placeholder="请输入楼牌号" value="${ skqBdckp.lpmc}" />
 			   </li>
 				       			 			   <li><label>付款方名称<b></b></label>
 			   <input  type="text" class="dfinput" id="fkfmc" name="skqBdckp.fkfmc" placeholder="请输入付款方名称" value="${ skqBdckp.fkfmc}" />
 			   </li>
 				       			 			   <li><label>付款方代码<b></b></label>
 			   <input  type="text" class="dfinput" id="fkfdm" name="skqBdckp.fkfdm" placeholder="请输入付款方代码" value="${ skqBdckp.fkfdm}" />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqBdckp.nsrwjbm" placeholder="请输入纳税人微机编码" value="${ skqBdckp.nsrwjbm}" />
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			   <input  type="text" class="dfinput" id="jqbh" name="skqBdckp.jqbh" placeholder="请输入机器编号" value="${ skqBdckp.jqbh}" />
 			   </li>
 				       			 			   <li><label>开票金额<b></b></label>
 			   <input  type="text" class="dfinput" id="hjzje" name="skqBdckp.hjzje" placeholder="请输入开票金额" value="${ skqBdckp.hjzje}" />
 			   </li>
 				       			 			   <li><label>款项性质<b></b></label>
 			   <input  type="text" class="dfinput" id="kxxz" name="skqBdckp.kxxz" placeholder="请输入款项性质" value="${ skqBdckp.kxxz}" />
 			   </li>
 				       			 			   <li><label>发票代码<b></b></label>
 			   <input  type="text" class="dfinput" id="fpdm" name="skqBdckp.fpdm" placeholder="请输入发票代码" value="${ skqBdckp.fpdm}" />
 			   </li>
 				       			 			   <li><label>发票号码<b></b></label>
 			   <input  type="text" class="dfinput" id="fphm" name="skqBdckp.fphm" placeholder="请输入发票号码" value="${ skqBdckp.fphm}" />
 			   </li>
 				       			 			   <li><label>开票类型<b></b></label>
 			   <input  type="text" class="dfinput" id="kplx" name="skqBdckp.kplx" placeholder="请输入开票类型" value="${ skqBdckp.kplx}" />
 			   </li>
 				       			 			   <li><label>开票日期<b></b></label>
 			   <input  type="text" class="dfinput" id="kprq" name="skqBdckp.kprq" placeholder="请输入开票日期" value="${ skqBdckp.kprq}" />
 			   </li>
 				       			 			   <li><label>上传日期<b></b></label>
 			   <input  type="text" class="dfinput" id="scrq" name="skqBdckp.scrq" placeholder="请输入上传日期" value="${ skqBdckp.scrq}" />
 			   </li>
 				       			 			   <li><label>项目ID<b></b></label>
 			   <input  type="text" class="dfinput" id="bdcid" name="skqBdckp.bdcid" placeholder="请输入项目ID" value="${ skqBdckp.bdcid}" />
 			   </li>
 				       			 			   <li><label>子项目ID<b></b></label>
 			   <input  type="text" class="dfinput" id="bdczxmid" name="skqBdckp.bdczxmid" placeholder="请输入子项目ID" value="${ skqBdckp.bdczxmid}" />
 			   </li>
 				       			 			   <li><label>项目明细ID<b></b></label>
 			   <input  type="text" class="dfinput" id="bdcxmmxid" name="skqBdckp.bdcxmmxid" placeholder="请输入项目明细ID" value="${ skqBdckp.bdcxmmxid}" />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqbdckp/list'"/></li>
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
 			$('#skqBdckpForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqBdckp.id':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.parentid':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.lpmc':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.fkfmc':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.fkfdm':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.jqbh':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.hjzje':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.kxxz':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.fpdm':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.fphm':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.kplx':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.kprq':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.scrq':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.bdcid':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.bdczxmid':'required;',
 			    	     			    	 			    		 			    			'skqBdckp.bdcxmmxid':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqbdckp/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqbdckp/list';
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
 