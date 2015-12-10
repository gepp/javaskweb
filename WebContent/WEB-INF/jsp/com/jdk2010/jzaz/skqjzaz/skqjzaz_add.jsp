<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建筑安装项目</title>
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
    <li><a href="#">建筑安装项目</a></li>
    </ul>
</div>
<div class="formbody">
<div id="usual1" class="usual"> 
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">建筑安装项目添加</a></li> 
  	</ul>
</div> 
<div id="tab1" class="tabson">
  <ul class="forminfo">
  	<form action="" method="POST"  id="skqJzazForm">
									 
					 			   <li><label>ID<b></b></label>
 			   <input  type="text" class="dfinput" id="id" name="skqJzaz.id" placeholder="请输入ID"  />
 			   </li>
 				       			 			   <li><label>上级项目ID<b></b></label>
 			   <input  type="text" class="dfinput" id="parentid" name="skqJzaz.parentid" placeholder="请输入上级项目ID"  />
 			   </li>
 				       			 			   <li><label>项目代码<b></b></label>
 			   <input  type="text" class="dfinput" id="xmdm" name="skqJzaz.xmdm" placeholder="请输入项目代码"  />
 			   </li>
 				       			 			   <li><label>项目名称<b></b></label>
 			   <input  type="text" class="dfinput" id="xmmc" name="skqJzaz.xmmc" placeholder="请输入项目名称"  />
 			   </li>
 				       			 			   <li><label>税务机关编码<b></b></label>
 			   <input  type="text" class="dfinput" id="zgswjg" name="skqJzaz.zgswjg" placeholder="请输入税务机关编码"  />
 			   </li>
 				       			 			   <li><label>甲方微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="jfwjbm" name="skqJzaz.jfwjbm" placeholder="请输入甲方微机编码"  />
 			   </li>
 				       			 			   <li><label>甲方名称<b></b></label>
 			   <input  type="text" class="dfinput" id="jfmc" name="skqJzaz.jfmc" placeholder="请输入甲方名称"  />
 			   </li>
 				       			 			   <li><label>乙方微机编码<b></b></label>
 			   <input  type="text" class="dfinput" id="yfwjbm" name="skqJzaz.yfwjbm" placeholder="请输入乙方微机编码"  />
 			   </li>
 				       			 			   <li><label>乙方名称<b></b></label>
 			   <input  type="text" class="dfinput" id="yfmc" name="skqJzaz.yfmc" placeholder="请输入乙方名称"  />
 			   </li>
 				       			 			   <li><label>项目类型<b></b></label>
 			   <input  type="text" class="dfinput" id="xmlx" name="skqJzaz.xmlx" placeholder="请输入项目类型"  />
 			   </li>
 				       			 			   <li><label>合同性质<b></b></label>
 			   <input  type="text" class="dfinput" id="htxz" name="skqJzaz.htxz" placeholder="请输入合同性质"  />
 			   </li>
 				       			 			   <li><label>工程款<b></b></label>
 			   <input  type="text" class="dfinput" id="gck" name="skqJzaz.gck" placeholder="请输入工程款"  />
 			   </li>
 				       			 			   <li><label>甲供材<b></b></label>
 			   <input  type="text" class="dfinput" id="jgc" name="skqJzaz.jgc" placeholder="请输入甲供材"  />
 			   </li>
 				       			 			   <li><label>创建者<b></b></label>
 			   <input  type="text" class="dfinput" id="cjz" name="skqJzaz.cjz" placeholder="请输入创建者"  />
 			   </li>
 				       			 			   <li><label>创建时间<b></b></label>
 			   <input  type="text" class="dfinput" id="cjsj" name="skqJzaz.cjsj" placeholder="请输入创建时间"  />
 			   </li>
 				       			 			   <li><label>登记已开金额<b></b></label>
 			   <input  type="text" class="dfinput" id="ykje" name="skqJzaz.ykje" placeholder="请输入登记已开金额"  />
 			   </li>
 				       			 			   <li><label>纳税人性质<b></b></label>
 			   <input  type="text" class="dfinput" id="nsrxz" name="skqJzaz.nsrxz" placeholder="请输入纳税人性质"  />
 			   </li>
 				       			 			   <li><label>待抵扣金额<b></b></label>
 			   <input  type="text" class="dfinput" id="ddkje" name="skqJzaz.ddkje" placeholder="请输入待抵扣金额"  />
 			   </li>
 				       			 			   <li><label>项目状态<b></b></label>
 			   <input  type="text" class="dfinput" id="xmzt" name="skqJzaz.xmzt" placeholder="请输入项目状态"  />
 			   </li>
 				        			<li><label>&nbsp;</label><input name="" type="submit" class="btn" value=" 确定"/>
    			&nbsp;&nbsp;
   			 <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqjzaz/list'"/></li>
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
 			$('#skqJzazForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
 			    	 			    		 			    			'skqJzaz.id':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.parentid':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.xmdm':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.xmmc':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.zgswjg':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.jfwjbm':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.jfmc':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.yfwjbm':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.yfmc':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.xmlx':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.htxz':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.gck':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.jgc':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.cjz':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.cjsj':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.ykje':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.nsrxz':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.ddkje':'required;',
 			    	     			    	 			    		 			    			'skqJzaz.xmzt':'required;',
 			    	     			    	 			        
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url:"${ contextpath}/skqjzaz/addaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqjzaz/list';
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
 