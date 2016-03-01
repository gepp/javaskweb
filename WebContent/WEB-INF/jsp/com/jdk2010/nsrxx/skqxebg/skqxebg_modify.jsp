<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>限额变更</title>
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
    <li><a href="#">限额变更</a></li>
  </ul>
 </div>
<div class="formbody">
   <div id="usual1" class="usual">
    <div class="itab">
       <ul>
        <li><a href="#tab1" class="selected">限额变更申请信息</a></li>
      </ul>
     </div>
    <div id="tab1" class="tabson">
      <ul class="forminfo">
          <table width="100%">
            <tr height="40px;">
              <td>纳税人识别号<b></b></td>
              <td>${skqXebg.nsrsbh}&nbsp;</td>
              <td>纳税人名称<b></b></td>
              <td>${skqXebg.nsrmc}&nbsp;</td>
            </tr>
            <tr height="40px;">
              <td>机器编号<b></b></td>
              <td>${skqXebg.jqbh}&nbsp;</td>
              <td>申请时间<b></b></td>
              <td>${skqXebg.sqsj}&nbsp;</td>
            </tr>
            <tr height="40px;">
              <td>剩余累计开票限额<b></b></td>
              <td>${skqXebg.syljkpxe}&nbsp;</td>
              <td>剩余累计退票限额<b></b></td>
              <td>${skqXebg.syljtpxe}&nbsp;</td>
            </tr>
            <tr height="40px;">
              <td>申请累计开票限额<b></b></td>
              <td>${skqXebg.sqljkpxe}&nbsp;</td>
              <td>申请累计退票限额<b></b></td>
              <td>${skqXebg.sqljtpxe}&nbsp;</td>
            </tr>
            <tr height="40px;">
              <td>变更说明<b></b></td>
              <td colspan="3">${skqXebg.bgsm}&nbsp;</td>
            </tr>
          </table>
        </ul>
      </div>
      <div class="itab">
       <ul>
        <li><a href="#tab1" class="selected">限额变更审核信息&nbsp;&nbsp;<font color="#FF0000">调整后开票限额不能超过：四千贰佰玖拾万(42900000.00)</font></a></li>
      </ul>
     </div>
     <div id="tab1" class="tabson">
       <ul class="forminfo">
        <form action="" method="POST"  id="skqXebgForm">
            <table width="100%">
            <tr height="50px;">
              <td>批准累计开票限额<b></b></td>
              <td><input  type="text" class="dfinput" id="pzljkpxe" name="skqXebg.pzljkpxe" placeholder="请输入批准累计开票限额" value="${skqXebg.syljkpxe+skqXebg.sqljkpxe}" /></td>
              <td>批准累计退票限额<b></b></td>
              <td><input  type="text" class="dfinput" id="pzljtpxe" name="skqXebg.pzljtpxe" placeholder="请输入批准累计退票限额" value="${skqXebg.syljtpxe+skqXebg.sqljtpxe}" /></td>
            </tr>
            <tr height="50px;">
              <td>审核标记<b></b></td>
              <td><input type="radio" name="skqXebg.clbz" value="1" id="clbz_0" checked />
            审核通过
            <input type="radio" name="skqXebg.clbz" value="2" id="clbz_1" />
            审核不通过</td>
              <td>审核意见<b></b></td>
              <td><input  type="text" class="dfinput" id="clyj" name="skqXebg.clyj" placeholder="请输入处理意见" /></td>
            </tr>
          </table>
           <li>
            <label>&nbsp;</label>
            <input  type="hidden" id="id" name="skqXebg.id" value="${ skqXebg.id}" />
            <input name="" type="submit" class="btn" value=" 确定"/>
            &nbsp;&nbsp;
            <input name="" type="button" class="btn" value="返回" onclick="window.location='${ contextpath}/skqxebg/list'"/>
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
 			$('#skqXebgForm').on("click", ".doSubmit", function(e){
 				var a=$(e.delegateTarget).trigger("validate");
 			})
 			.validator({
 			    fields: {
					'skqXebg.pzljkpxe':'required;range[1~42900000.00];',
					'skqXebg.pzljtpxe':'required;range[1~42900000.00];'
 			    },
 			   valid: function(form){
 				  var me = this;
 			        // 提交表单之前，hold住表单，防止重复提交
 			        me.holdSubmit();
 			        $.ajax({
 			            url: "${ contextpath}/skqxebg/modifyaction",
 			            data: $(form).serialize(),
 			            type: "POST",
 			            success: function(data){
 			                // 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
 			                me.holdSubmit(false);
 			                if(data.status=='success'){
 			                	layer.alert('当前操作成功', {
								shade:0,closeBtn: 0
								}, function(){
									window.location.href='${ contextpath}/skqxebg/list';
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
 