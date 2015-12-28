<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/layer/layer.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/googlesuggest/prototype.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/googlesuggest/autocomplete.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/googlesuggest/so.js"></script>
<link rel="stylesheet" type="text/css" href="${ contextpath }/res/js/googlesuggest/autocomplete.css" />
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">网络发票购买</a></li>
  </ul>
</div>
<div class="rightinfo">
  <div class="formtitle1"> <span>网络发票购买</span> </div>
  <form action="" method="post"  id="skqBdcForm">
    <li style="top:30%; position:fixed; left:30%;">
    	<label>纳税人识别号<b></b></label>
      <input type="text" class="dfinput" name="nsrsbh" id="nsrsbh" placeholder="请输入纳税人识别号" />&nbsp;&nbsp;
      <script type="text/javascript">
	//var nsrsbh = document.getElementById('nsrsbh').value;
	
		new CAPXOUS.AutoComplete("nsrsbh", function() {
			if(this.text.value.length>=3){
        		return "${ contextpath}/skqbdc/hqmc?keyword=" + this.text.value;
			}
    	});
	
</script>
      <input name="button" type="button" class="btn" value=" 确定" onclick="toFplist();"/>
    </li>
  </form>
</div>
</body>
</html>
<script type="text/javascript">
function toFplist(){
	var nsrsbh = document.getElementById('nsrsbh').value;
	if(nsrsbh==''){
		layer.alert('请输入纳税人识别号',{shade:0,closeBtn: 0});
	}
	else{
		jQuery.ajax({
			url:"${ contextpath}/skqbdc/checkNsrsbh?nsrsbh="+nsrsbh,
			type: "POST",
			success: function(data){
				// 提交表单成功后，释放hold，如果不释放hold，就变成了只能提交一次的表单
				if(data.status=='success'){
					window.location.href = '${contextpath}/skqfpj/wlfplist.htm?nsrwjbm='+data.data.nsrwjbm;					 
				}else{
					sAlert("未查询到纳税人信息");
				}
			   
			}
		});
		
	}
}
</script>
