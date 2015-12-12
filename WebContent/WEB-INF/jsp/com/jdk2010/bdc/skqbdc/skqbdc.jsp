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
</head>
<body>
<div class="place"> <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">不动产</a></li>
  </ul>
</div>
<div class="rightinfo">
	<form method="post" action="${ contextpath }/skqbdc/list">
  <ul class="seachform" style="padding-top: 10px; padding-left: 15px">
    <li>
      <label style="width: 70px">项目名称</label>
      <input type="text" name="xmmc" id="xmmc" class="scinput1" style="width:300px;" placeholder="请输入项目名称" value="${xmmc}">
      <input type="hidden" name="nsrwjbm" id="nsrwjbm" value="${nsrwjbm}" />
    </li>
    <li><input name="" type="submit" class="btn" style="width:80px;" value="查询"/></li>
    <li><input name="" type="button" class="btn" style="width:80px;" value="重置" onclick="resBdc();"/></li>
  </ul>
  </form>
  <div class="tools">
    <ul class="toolbar">
      <li class="click" onclick="add();"><span><img src="${ contextpath }/res/images/t01.png" /></span>添加</li>
      <li class="click" id="table_delete"><span><img src="${ contextpath }/res/images/t03.png" /></span>删除</li>
    </ul>
  </div>
  <div class="formtitle1"> <span>不动产</span> </div>
  <table class="tablelist">
    <thead>
      <tr>
        <th width="30px"><input type="checkbox" id="checkAll"/></th>
        <th>项目名称</th>
        <th width="15%">创建时间</th>
        <th width="15%">操作</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="item">
        <tr>
          <td><input type="checkbox" name="subBox" value="${item.id}" /></td>
          <td> ${ item.xmmc} </td>
          <td> <fmt:formatDate value="${item.cjsj }"   pattern="yyyy-MM-dd"/></td>
          <td>
            <a href="${ contextpath }/skqbdc/modify.htm?id=${item.id}" class="tablelink">编辑</a>&nbsp;&nbsp;
            <a href="${ contextpath }/skqbdczxm/list.htm?bdcid=${item.id}"  class="tablelink">子项目管理</a> 
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
	var nsrwjbm = $('#nsrwjbm').val(); 
	table_init("${ contextpath}/skqbdc","${ contextpath}/skqbdc/list?nsrwjbm="+nsrwjbm);
});
function resBdc(){
	var nsrwjbm = $('#nsrwjbm').val();
	window.location.href = '${ contextpath }/skqbdc/list.htm?nsrwjbm='+nsrwjbm;
}
function add(){
	var nsrwjbm = $('#nsrwjbm').val();
	window.location.href = "${ contextpath }/skqbdc/add.htm?nsrwjbm="+nsrwjbm;
}
</script>
