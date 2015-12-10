<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申报数据</title>
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
    <li><a href="#">申报数据</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">申报数据添加</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  	<form action="" method="POST"  id="skqSbsjForm">
									 
					 			   <li><label>id<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqSbsj.id" placeholder="请输入id"  />
 			   </li>
 				       			 			   <li><label>所属开始时间<b></b></label>
 			   <input  type="text" class="dfinput" id="sskssj" name="skqSbsj.sskssj" placeholder="请输入所属开始时间"  />
 			   </li>
 				       			 			   <li><label>所属截止时间<b></b></label>
 			   <input  type="text" class="dfinput" id="ssjzsj" name="skqSbsj.ssjzsj" placeholder="请输入所属截止时间"  />
 			   </li>
 				       			 			   <li><label>正常票份数<b></b></label>
 			   <input  type="text" class="dfinput" id="zcpfs" name="skqSbsj.zcpfs" placeholder="请输入正常票份数"  />
 			   </li>
 				       			 			   <li><label>退票份数<b></b></label>
 			   <input  type="text" class="dfinput" id="tpfs" name="skqSbsj.tpfs" placeholder="请输入退票份数"  />
 			   </li>
 				       			 			   <li><label>废票份数<b></b></label>
 			   <input  type="text" class="dfinput" id="fpfs" name="skqSbsj.fpfs" placeholder="请输入废票份数"  />
 			   </li>
 				       			 			   <li><label>正常票总金额<b></b></label>
 			   <input  type="text" class="dfinput" id="zcpzje" name="skqSbsj.zcpzje" placeholder="请输入正常票总金额"  />
 			   </li>
 				       			 			   <li><label>退票总金额<b></b></label>
 			   <input  type="text" class="dfinput" id="tpzje" name="skqSbsj.tpzje" placeholder="请输入退票总金额"  />
 			   </li>
 				       			 			   <li><label>纳税人微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrwjbm" name="skqSbsj.nsrwjbm" placeholder="请输入纳税人微机编码"  />
 			   </li>
 				       			 			   <li><label>机器编号<b></b></label>
 			   <input  type="text" class="dfinput" id="jqbh" name="skqSbsj.jqbh" placeholder="请输入机器编号"  />
 			   </li>
 				       			 			   <li><label>申报类型<b></b></label>
 			   <input  type="text" class="dfinput" id="sblx" name="skqSbsj.sblx" placeholder="请输入申报类型"  />
 			   </li>
 				       			 			   <li><label>开票截止日期<b></b></label>
 			   <input  type="text" class="dfinput" id="kpjzsj" name="skqSbsj.kpjzsj" placeholder="请输入开票截止日期"  />
 			   </li>
 				       			 			   <li><label>单张开票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="dzkpxe" name="skqSbsj.dzkpxe" placeholder="请输入单张开票限额"  />
 			   </li>
 				       			 			   <li><label>月累计开票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="yljkpxe" name="skqSbsj.yljkpxe" placeholder="请输入月累计开票限额"  />
 			   </li>
 				       			 			   <li><label>月累计退票限额<b></b></label>
 			   <input  type="text" class="dfinput" id="yljtpxe" name="skqSbsj.yljtpxe" placeholder="请输入月累计退票限额"  />
 			   </li>
 				       			 			   <li><label>下载状态<b></b></label>
 			   <input  type="text" class="dfinput" id="xzzt" name="skqSbsj.xzzt" placeholder="请输入下载状态"  />
 			   </li>
 				       			 			   <li><label>下载日期<b></b></label>
 			   <input  type="text" class="dfinput" id="xzrq" name="skqSbsj.xzrq" placeholder="请输入下载日期"  />
 			   </li>
 				       			 			   <li><label>创建日期<b></b></label>
 			   <input  type="text" class="dfinput" id="cjrq" name="skqSbsj.cjrq" placeholder="请输入创建日期"  />
 			   </li>
 				       			 			   <li><label>申报日期<b></b></label>
 			   <input  type="text" class="dfinput" id="sbrq" name="skqSbsj.sbrq" placeholder="请输入申报日期"  />
 			   </li>
 				       			 			   <li><label>MAC<b></b></label>
 			   <input  type="text" class="dfinput" id="mac" name="skqSbsj.mac" placeholder="请输入MAC"  />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqsbsj/list'"/></li>
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
 			$('#skqSbsjForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqSbsj.id':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.sskssj':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.ssjzsj':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.zcpfs':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.tpfs':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.fpfs':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.zcpzje':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.tpzje':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.nsrwjbm':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.jqbh':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.sblx':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.kpjzsj':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.dzkpxe':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.yljkpxe':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.yljtpxe':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.xzzt':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.xzrq':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.cjrq':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.sbrq':'required;',
 			    	     			    	 			    		 			    			'skqSbsj.mac':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url:"${ contextpath}/skqsbsj/addaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqsbsj/list';
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
 