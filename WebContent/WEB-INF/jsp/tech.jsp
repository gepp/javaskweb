<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${contextpath}/res/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${contextpath}/res/js/jquery.js"></script>

<script language="javascript">
	$(function(){
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	$(window).resize(function(){  
    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
    })  
});  
</script> 


</head>


<body style="background:#edf6fa;">

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">技术支持</a></li>
    </ul>
    </div>
    
    <div class="tech">
        
    <dl>    
    <dt>技术支持</dt>
    <dd><b>QQ:&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</b>7867770</dd>
    <dd><b>电子邮件:&nbsp;&nbsp;</b>7867770@qq.com</dd>
    <dd><b>手机:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b>13770737278</dd>
    <dd><b>联系人:&nbsp;&nbsp;&nbsp;&nbsp;</b>老 财</dd>
    </dl>
    
        
    </div>
    


</body>

</html>
