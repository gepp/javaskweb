<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <li><a href="${contextpath }/skqnsrxx/listHandler.htm" target="rightFrame"><span><img src="${contextpath }/res/images/d01.png" /></span><p>纳税人管理</a></p></li>
    <li><a href="${contextpath }/skqfpj/toFpgm.htm"  target="rightFrame"><span><img src="${contextpath }/res/images/d02.png" /></span><p>发票购买</a></p></li>
    <li><a href="${contextpath }/skqfpj/wlfpgmImport.htm"  target="rightFrame"><span><img src="${contextpath }/res/images/d07.png" /></span><p>网络发票购买</a></p></li>    
    <li><a href="${contextpath }/skqsbsj/toZrysb.htm"  target="rightFrame"><span><img src="${contextpath }/res/images/d03.png" /></span><p>自然月申报</a></p></li>
    <li><a href="${contextpath }/skqsbsj/toJdsb.htm"  target="rightFrame"><span><img src="${contextpath }/res/images/d04.png" /></span><p>阶段申报</a></p></li>
    <li><a href="${contextpath }/skqsbsj/toJkhc.htm"  target="rightFrame"><span><img src="${contextpath }/res/images/d05.png" /></span><p>监控回传</a></p></li>
    <li><a href="${contextpath }/skqsbsj/listImport.htm"  target="rightFrame"><span><img src="${contextpath }/res/images/d06.png" /></span><p>申报汇总查询</a></p></li>
    
    </ul>
    </div>
    <div class="inforight">
    <div class="listtitle"><a href="${contextpath }/securitynews/list.htm" target="rightFrame" class="more1">更多</a>通知通告</div>    
    <ul class="newlist">
    <c:forEach var="item" items="${newsList }">
		   <li><a href="${contextpath }/securitynews/view.htm?id=${item.id}">${item.title }</a><b>${item.ctime }</b></li>
    </c:forEach>
    </ul>   
    
    </div>
     
    </div>
    
    
    </div>
    <!--mainleft end-->
     
    <div class="mainright">
     
    <div class="dflist1">
    <div class="listtitle">信息统计</div>    
    <ul class="newlist">
    <li><a>纳税户：</a><b>${totalNsrxxCount }</b></li>
    <li><a>机器总数：</a><b>${totalJqxxCount }</b></li>
    <li><a>未领购发票总数（卷）：</a><b>${totalFpjmxCount }</b></li>
    <li><a>未申报纳税户：</a><b>${totalNoSbNsrxxCount }</b></li>
     
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
