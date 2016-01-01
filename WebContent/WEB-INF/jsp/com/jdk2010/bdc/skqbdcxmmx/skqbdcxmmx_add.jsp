<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产项目明细</title>
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
<div class="place"> <span>位置：</span>
   <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">不动产项目明细</a></li>
  </ul>
 </div>
<div class="formbody">
   <div id="usual1" class="usual">
    <div class="itab">
       <ul>
        <li><a href="#tab1" class="selected">不动产项目明细添加</a></li>
      </ul>
     </div>
    <div id="tab1" class="tabson">
       <ul class="forminfo">
        <form action="" method="POST"  id="skqBdcxmmxForm">
		  <li>
            <label>项目名称<b></b></label>
            <input  type="text" class="dfinput" id="xmmc" name="skqBdcxmmx.xmmc" placeholder="请输入项目名称"  />
          </li>
          <li>
            <label>项目编码<b></b></label>
            <input  type="text" class="dfinput" id="xmbm" name="skqBdcxmmx.xmbm" placeholder="请输入项目编码"  />
          </li>
          <li>
            <label>保障性普通住宅套数<b></b></label>
            <input  type="text" class="dfinput" id="bzxptzzts" name="skqBdcxmmx.bzxptzzts" placeholder="请输入保障性普通住宅套数"  />
          </li>
          <li>
            <label>非保障性普通住宅套数<b></b></label>
            <input  type="text" class="dfinput" id="fbzxptzzts" name="skqBdcxmmx.fbzxptzzts" placeholder="请输入非保障性普通住宅套数"  />
          </li>
          <li>
            <label>非普通住宅套数<b></b></label>
            <input  type="text" class="dfinput" id="fptzzts" name="skqBdcxmmx.fptzzts" placeholder="请输入非普通住宅套数"  />
          </li>
          <li>
            <label>别墅套数<b></b></label>
            <input  type="text" class="dfinput" id="bsts" name="skqBdcxmmx.bsts" placeholder="请输入别墅套数"  />
          </li>
          <li>
            <label>商铺套数<b></b></label>
            <input  type="text" class="dfinput" id="spts" name="skqBdcxmmx.spts" placeholder="请输入商铺套数"  />
          </li>
          <li>
            <label>写字楼套数<b></b></label>
            <input  type="text" class="dfinput" id="xzlts" name="skqBdcxmmx.xzlts" placeholder="请输入写字楼套数"  />
          </li>
           <li>
            <label>其他套数<b></b></label>
            <input  type="text" class="dfinput" id="qtts" name="skqBdcxmmx.qtts" placeholder="请输入其他套数"  />
          </li>
           <li>
            <label>保障性普通住宅面积<b></b></label>
            <input  type="text" class="dfinput" id="bzxptzzmj" name="skqBdcxmmx.bzxptzzmj" placeholder="请输入保障性普通住宅面积"  />
          </li>
           <li>
            <label>非保障性普通住宅面积<b></b></label>
            <input  type="text" class="dfinput" id="fbzxptzzmj" name="skqBdcxmmx.fbzxptzzmj" placeholder="请输入非保障性普通住宅面积"  />
          </li>
           <li>
            <label>非普通住宅面积<b></b></label>
            <input  type="text" class="dfinput" id="fptzzmj" name="skqBdcxmmx.fptzzmj" placeholder="请输入非普通住宅面积"  />
          </li>
           <li>
            <label>别墅面积<b></b></label>
            <input  type="text" class="dfinput" id="bsmj" name="skqBdcxmmx.bsmj" placeholder="请输入别墅面积"  />
          </li>
           <li>
            <label>商铺面积<b></b></label>
            <input  type="text" class="dfinput" id="spmj" name="skqBdcxmmx.spmj" placeholder="请输入商铺面积"  />
          </li>
           <li>
            <label>写字楼面积<b></b></label>
            <input  type="text" class="dfinput" id="xzlmj" name="skqBdcxmmx.xzlmj" placeholder="请输入写字楼面积"  />
          </li>
           <li>
            <label>其他面积<b></b></label>
            <input  type="text" class="dfinput" id="qtmj" name="skqBdcxmmx.qtmj" placeholder="请输入其他面积"  />
          </li>
           <li>
            <label>&nbsp;</label>
            <input name="" type="submit" class="btn" value=" 确定"/>
            &nbsp;&nbsp;
            <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqbdcxmmx/list?nsrwjbm=${nsrwjbm}&bdcid=${bdcid}&bdczxmid={bdczxmid}'"/>
          </li>
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
 			$('#skqBdcxmmxForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
					'skqBdcxmmx.xmmc':'required;'
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url:"${ contextpath}/skqbdcxmmx/addaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqbdcxmmx/list?nsrwjbm=${nsrwjbm}&bdcid=${bdcid}&bdczxmid={bdczxmid}';
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
 