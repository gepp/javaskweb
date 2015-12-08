<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${contextpath }/res/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${contextpath }/res/js/jsapi.js"></script>
<script type="text/javascript" src="${contextpath }/res/js/format+zh_CN,default,corechart.I.js"></script>		
<script type="text/javascript" src="${contextpath }/res/js/jquery.ba-resize.min.js"></script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">工作台</a></li>
    </ul>
    </div>
    
    
    <div class="mainbox">
    
    <div class="mainleft">
    
     
    <!--leftinfo end-->
    
    
    <div class="leftinfos">
    
   <div class="infoleft">
    <div class="listtitle">常用工具</div>
    
    <ul class="tooli">
    <li><span><img src="${contextpath }/res/images/d01.png" /></span><p><a href="#">发票购买</a></p></li>
    <li><span><img src="${contextpath }/res/images/d02.png" /></span><p><a href="#">机器注册</a></p></li>
    <li><span><img src="${contextpath }/res/images/d03.png" /></span><p><a href="#">发票购买</a></p></li>
    <li><span><img src="${contextpath }/res/images/d04.png" /></span><p><a href="#">任务日历</a></p></li>
    <li><span><img src="${contextpath }/res/images/d05.png" /></span><p><a href="#">图片管理</a></p></li>
    <li><span><img src="${contextpath }/res/images/d06.png" /></span><p><a href="#">交易</a></p></li>
    <li><span><img src="${contextpath }/res/images/d07.png" /></span><p><a href="#">档案袋</a></p></li>    
    </ul>
    
    </div>
   
    <div class="inforight">
    
    <div class="listtitle"><a href="#" class="more1">更多</a>发文公告</div>    
    <ul class="newlist">
    <li><a href="#">上海自贸区今日正式挂牌成立</a><b>10-09</b></li>
    <li><a href="#">习近平将访东南亚两国 首次出席APEC峰会</a><b>10-08</b></li>
    <li><a href="#">最高法:谎称炸弹致航班备降者从重追刑责</a><b>10-09</b></li>
    <li><a href="#">华北大部遭遇雾霾天 北京全城陷重污染</a><b>10-06</b></li>
    <li><a href="#">"环保专家"董良杰涉嫌寻衅滋事被刑拘</a><b>10-05</b></li>
    <li><a href="#">中央巡视组：重庆对一把手监督不到位</a><b>10-04</b></li>
    <li><a href="#">囧!悍马没改好成华丽马车(图)</a><b>10-03</b></li>
    </ul>   
    
    </div>
     
    </div>
    
    
    </div>
    <!--mainleft end-->
     
    <div class="mainright">
     
    <div class="dflist1">
    <div class="listtitle"><a href="#" class="more1">更多</a>信息统计</div>    
    <ul class="newlist">
    <li><i>纳税户：</a></i>2535462</li>
    <li><i>机器总数：</a></i>5546</li>
    <li><i>发票总数：</a></i>2315</li>
    <li><i>软件：</a></i>1585</li>
    <li><i>评论数：</a></i>5342</li>    
    </ul>        
    </div>

    </div>
    <!--mainright end--> 
    </div>
</body>
<script type="text/javascript">
	setWidth();
	$(window).resize(function(){
		setWidth();	
	});
	function setWidth(){
		var width = ($('.leftinfos').width()-12)/2;
		$('.infoleft,.inforight').width(width);
	}
</script>
</html>
