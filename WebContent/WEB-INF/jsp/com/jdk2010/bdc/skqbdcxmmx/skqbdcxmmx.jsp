<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib uri="http://www.tag.mytag.com" prefix="page"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>不动产项目明细</title>
<link href="${ contextpath }/res/css/style.css" rel="stylesheet"
	type="text/css" />
<link href="${ contextpath }/res/css/page.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${ contextpath }/res/js/jquery.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/common.js"></script>
<script type="text/javascript" src="${ contextpath }/res/js/layer/layer.js"></script>
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">不动产项目明细</a></li>
  </ul>
</div>
<div class="rightinfo">
  <form method="post" action="${ contextpath }/skqbdcxmmx/list">
    <ul class="seachform" style="padding-top: 10px; padding-left: 15px">
      <li>
        <label style="width: 80px">项目明细名称</label>
        <input type="text" name="xmmc" id="xmmc" class="scinput1" style="width:300px;" placeholder="请输入项目明细名称" value="${xmmc}">
        <input type="hidden" name="nsrwjbm" id="nsrwjbm" value="${nsrwjbm}" />
        <input type="hidden" name="bdcid" id="bdcid" value="${bdcid}" />
        <input type="hidden" name="bdczxmid" id="bdczxmid" value="${bdczxmid}" />
      </li>
      <li>
        <input name="" type="submit" class="btn" style="width:80px;" value="查询"/>
      </li>
      <li>
        <input name="" type="button" class="btn" style="width:80px;" value="重置" onclick="resetSearch();"/>
      </li>
      <li>
        <input name="" type="button" class="btn" style="width:80px;" value="返回" onclick="goBack();"/>
      </li>
    </ul>
  </form>
  <div class="tools">
    <ul class="toolbar">
      <li class="click" onclick="add();"><span><img src="${ contextpath }/res/images/t01.png" /></span>添加</li>
      <li class="click" id="table_delete" ><span><img src="${ contextpath }/res/images/t03.png" /></span>删除</li>
    </ul>
  </div>
  <div class="formtitle1"> <span>${zxmmc}</span> </div>
  <table class="tablelist">
    <thead>
      <tr>
        <th width="30px"><input type="checkbox"  id="checkAll"/></th>
        <th width="7%">项目代码</th>
        <th>项目明细名称</th>
        <th width="8%">保普住宅套数</th>
        <th width="8%">非保普住宅套数</th>
        <th width="8%">非普住宅套数</th>
        <th width="8%">别墅套数</th>
        <th width="8%">商铺套数</th>
        <th width="8%">写字楼套数</th>
        <th width="8%">其他套数</th>
        <th width="8%">总套数</th>
        <th width="8%">录入总套数</th>
        <th width="8%">操作</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="item">
        <tr>
          <td><input type="checkbox" name="subBox" value="${item.id}" /></td>
          <td> ${ item.xmbm} </td>
          <td> ${ item.xmmc} </td>
          <td> ${ item.bzxptzzts} </td>
          <td> ${ item.fbzxptzzts} </td>
          <td> ${ item.fptzzts} </td>
          <td> ${ item.bsts} </td>
          <td> ${ item.spts} </td>
          <td> ${ item.xzlts} </td>
          <td> ${ item.qtts} </td>
          <td> ${ item.zts} </td>
          <td> ${ item.lrts} </td>
          <td><a href="${ contextpath }/skqbdcxmmx/modify.htm?id=${item.id}" class="tablelink">编辑</a> <a href="${ contextpath }/skqbdcxmmx/view.htm?id=${item.id}&nsrwjbm=${nsrwjbm}&bdcid=${bdcid}&bdczxmid=${bdczxmid}"  class="tablelink">查看</a> 
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
<script type="text/javascript">
$('.tablelist tbody tr:odd').addClass('odd');
$(document).ready(function(){
	table_init("${ contextpath}/skqbdcxmmx","${ contextpath}/skqbdcxmmx/list?nsrwjbm=${nsrwjbm}&bdcid=${bdcid}&bdczxmid=${bdczxmid}");
});
function resetSearch(){
	var nsrwjbm = $('#nsrwjbm').val();
	var bdcid = $('#bdcid').val();
	var bdczxmid = $('#bdczxmid').val();
	window.location.href = '${ contextpath }/skqbdczxm/list.htm?nsrwjbm='+nsrwjbm+'&bdcid='+bdcid+'&bdczxmid='+bdczxmid;
}
function goBack(){
	var nsrwjbm = $('#nsrwjbm').val();
	var bdcid = $('#bdcid').val();
	window.location.href = '${ contextpath }/skqbdczxm/list.htm?nsrwjbm='+nsrwjbm+'&bdcid='+bdcid;
}

function add(){
	var nsrwjbm = $('#nsrwjbm').val();
	var bdcid = $('#bdcid').val();
	var bdczxmid = $('#bdczxmid').val();
	window.location.href = "${ contextpath }/skqbdcxmmx/add.htm?nsrwjbm="+nsrwjbm+'&bdcid='+bdcid+'&bdczxmid='+bdczxmid;
}
</script>
