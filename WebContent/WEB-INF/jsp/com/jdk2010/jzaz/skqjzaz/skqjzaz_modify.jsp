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
<div class="place"> <span>位置：</span>
   <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">建筑安装项目</a></li>
  </ul>
 </div>
<div class="formbody">
   <div id="usual1" class="usual">
    <div class="itab">
       <ul>
        <li><a href="#tab1" class="selected">建筑安装项目编辑</a></li>
      </ul>
     </div>
    <div id="tab1" class="tabson">
       <ul class="forminfo">
        <form action="" method="POST"  id="skqJzazForm">
           <li>
            <label>项目代码<b></b></label>
            <input  type="text" class="dfinput" id="xmdm" name="skqJzaz.xmdm" placeholder="请输入项目代码" value="${ skqJzaz.xmdm}" />
          </li>
           <li>
            <label>项目名称<b></b></label>
            <input  type="text" class="dfinput" id="xmmc" name="skqJzaz.xmmc" placeholder="请输入项目名称" value="${ skqJzaz.xmmc}" />
          </li>
           <li>
            <label>甲方识别号<b></b></label>
            <input  type="text" class="dfinput" id="jfwjbm" name="skqJzaz.jfwjbm" placeholder="请输入甲方识别号" value="${ skqJzaz.jfwjbm}" />
          </li>
           <li>
            <label>甲方名称<b></b></label>
            <input  type="text" class="dfinput" id="jfmc" name="skqJzaz.jfmc" placeholder="请输入甲方名称" value="${ skqJzaz.jfmc}" />
          </li>
           <li>
            <label>项目类型<b></b></label>
            <cite>
            <input type="radio" name="skqJzaz.xmlx" value="1" id="xmlx_0" <c:if test="${skqJzaz.xmlx==1}">checked</c:if> />
            房地产工程
            <input type="radio" name="skqJzaz.xmlx" value="2" id="xmlx_1" <c:if test="${skqJzaz.xmlx==2}">checked</c:if>/>
            城市基础设施建设工程
            <input type="radio" name="skqJzaz.xmlx" value="3" id="xmlx_2" <c:if test="${skqJzaz.xmlx==3}">checked</c:if>/>
            企业设立改造工程
            <input type="radio" name="skqJzaz.xmlx" value="4" id="xmlx_3" <c:if test="${skqJzaz.xmlx==4}">checked</c:if>/>
            其他
            </cite>
          </li>
           <li>
            <label>合同性质<b></b></label>
            <cite>
            总包合同
            </cite>
            <input  type="hidden" id="htxz" name="skqJzaz.htxz" value="${ skqJzaz.htxz}" />
          </li>
           <li>
            <label>合同金额<b></b></label>
            <input  type="text" class="dfinput" id="gck" name="skqJzaz.gck" placeholder="请输入合同金额" value="${ skqJzaz.gck}" />
          </li>
           <li>
            <label>登记已开金额<b></b></label>
            <input  type="text" class="dfinput" id="ykje" name="skqJzaz.ykje" placeholder="请输入登记已开金额" value="${ skqJzaz.ykje}" />
          </li>
           <li>
            <label>&nbsp;</label>
            <input  type="hidden" id="id" name="skqJzaz.id" value="${ skqJzaz.id}" />
            <input  type="hidden" id="nsrwjbm" name="nsrwjbm" value="${ skqJzaz.yfwjbm}" />
            <input name="" type="submit" class="btn" value=" 确定"/>
            &nbsp;&nbsp;
            <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqjzaz/list?nsrwjbm=${skqJzaz.yfwjbm}'"/>
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
 			$('#skqJzazForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
					'skqJzaz.xmdm':'required;',
					'skqJzaz.xmmc':'required;',
					'skqJzaz.jfwjbm':'required;',
					'skqJzaz.jfmc':'required;',
					'skqJzaz.gck':'required;',
					'skqJzaz.ykje':'required;'
				},
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqjzaz/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqjzaz/list?nsrwjbm=${skqJzaz.yfwjbm}';
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
 